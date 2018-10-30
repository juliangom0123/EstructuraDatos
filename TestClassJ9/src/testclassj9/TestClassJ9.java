package testclassj9;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeSet;

/**
 *
 * @author RENE
 */
public class TestClassJ9 {

    private final static String EVENT_EXECUTE = "EXECUTE";
    private final static String EVENT_KILL = "KILL";
    private final static String EVENT_CHANGE = "CHANGE";
    private final static String EVENT_TASK = "TASK";
    private final static String EVENT_CLEAR = "CLEAR";
    private final static String TASK_RESCHEDULED = "TASK RESCHEDULED";
    private final static String CLEARED = "CLEARED";
    private final static String TASK_NOT_FOUND = "TASK NOT FOUND";
    private final static String TASK_KILLED = "TASK KILLED";

    public static void main(String[] args) throws Exception {
        new TestClassJ9().principal(System.in);
    }

    public void principal(InputStream in) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String strLine = null;
        TreeSet<Task> listTask = new TreeSet<>();
        LinkedHashMap<Integer, Task> map = new LinkedHashMap<>();
        StringBuilder resultado = new StringBuilder();
        while ((strLine = bf.readLine()) != null) {
            if (EVENT_TASK.equalsIgnoreCase(strLine)) {
                String identificacionCaso = bf.readLine();
                String prioridadCaso = bf.readLine();
                String descripcionCaso = bf.readLine();
                Task task = new Task(Integer.parseInt(identificacionCaso), Long.parseLong(prioridadCaso), descripcionCaso);
                listTask.add(task);
                map.put(Integer.parseInt(identificacionCaso), task);
            }
            if (EVENT_CHANGE.equalsIgnoreCase(strLine)) {
                String identificacionCaso = bf.readLine();
                String prioridadCaso = bf.readLine();
                Task task = map.get(Integer.parseInt(identificacionCaso));
                if (task != null) {
                    Task taskCloned = new Task(task.getIdentificacionCaso(), Long.parseLong(prioridadCaso), task.getDescripcionCaso());
                    taskCloned.setCreateDate(task.getCreateDate());
                    listTask.remove(task);
                    listTask.add(taskCloned);
                    map.remove(taskCloned.identificacionCaso);
                    map.put(taskCloned.getIdentificacionCaso(), taskCloned);
                    resultado.append(TASK_RESCHEDULED).append("\n");
                } else {
                    resultado.append(TASK_NOT_FOUND).append("\n");
                }
            }
            if (EVENT_KILL.equalsIgnoreCase(strLine)) {
                String identificacionCaso = bf.readLine();
                Integer id = Integer.parseInt(identificacionCaso);
                Task task = map.get(id);
                if (task != null) {
                    listTask.remove(task);
                    map.remove(id);
                    resultado.append(TASK_KILLED).append("\n");
                } else {
                    resultado.append(TASK_NOT_FOUND).append("\n");
                }
            }
            if (EVENT_EXECUTE.equalsIgnoreCase(strLine)) {
                if (listTask.isEmpty()) {
                    resultado.append(TASK_NOT_FOUND).append("\n");
                } else {
                    Task task = listTask.pollFirst();
                    map.remove(task.getIdentificacionCaso());
                    resultado.append(task.getDescripcionCaso()).append("\n");
                }
            }
            if (EVENT_CLEAR.equalsIgnoreCase(strLine)) {
                listTask.clear();
                map.clear();
                resultado.append(CLEARED).append("\n");
            }
            if (strLine.equals("")) {
                break;
            }
            
        }
        bf.close();
        System.out.println(resultado.toString());
    }

    class Task implements Comparable<Task> {

        int identificacionCaso;
        long prioridadCaso;
        String descripcionCaso;
        long createDate;

        Task(int identificacionCaso, long prioridadCaso, String descripcionCaso) {
            this.identificacionCaso = identificacionCaso;
            this.prioridadCaso = prioridadCaso;
            this.descripcionCaso = descripcionCaso;
            this.createDate = System.nanoTime();
        }

        Task(int identificacionCaso) {
            this.identificacionCaso = identificacionCaso;
        }

        Task() {
        }

        public int getIdentificacionCaso() {
            return identificacionCaso;
        }

        public void setIdentificacionCaso(int identificacionCaso) {
            this.identificacionCaso = identificacionCaso;
        }

        public long getPrioridadCaso() {
            return prioridadCaso;
        }

        public void setPrioridadCaso(int prioridadCaso) {
            this.prioridadCaso = prioridadCaso;
        }

        public String getDescripcionCaso() {
            return descripcionCaso;
        }

        public void setDescripcionCaso(String descripcionCaso) {
            this.descripcionCaso = descripcionCaso;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        @Override
        public String toString() {
            return "Task [identificacionCaso=" + identificacionCaso + ", prioridadCaso=" + prioridadCaso
                    + ", descripcionCaso=" + descripcionCaso + ", createDate=" + createDate + "]\n";
        }

        @Override
        public int hashCode() {
            int hash = 3;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Task other = (Task) obj;
            if (this.identificacionCaso != other.identificacionCaso) {
                return false;
            }
            return true;
        }

        @Override
        public int compareTo(Task o) {
            int comparePrioridad = Long.signum(this.prioridadCaso - o.prioridadCaso) * -1;
            if (comparePrioridad == 0) {
                return Long.signum(this.createDate - o.createDate);
            }
            return comparePrioridad;
        }
    }
}
