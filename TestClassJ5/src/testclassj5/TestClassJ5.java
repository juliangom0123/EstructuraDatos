package testclassj5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.TreeSet;

public class TestClassJ5 {

    private final static String EVENT_ATENDER = "ATENDER";
    private final static String EVENT_RECLAMO = "RECLAMO";
    private final static String EVENT_VACIO = "No hay reclamos pendientes";

    void principal() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numeroCasos = Integer.parseInt(bf.readLine());
        String strLine = null;
        TreeSet<Task> listTask = new TreeSet<>();
        StringBuilder resultado = new StringBuilder();
        while (numeroCasos > 0) {
            String clasificacion = bf.readLine();
            numeroCasos--;
            if (clasificacion.equalsIgnoreCase(EVENT_RECLAMO)) {
                String identificacionReclamo = bf.readLine();
                String descripcionCaso = bf.readLine();
                String promedio = bf.readLine();
                Task task = new Task(Long.parseLong(identificacionReclamo), Double.parseDouble(promedio), descripcionCaso);
                listTask.add(task);
            }
            if (clasificacion.equalsIgnoreCase(EVENT_ATENDER)) {
                if (listTask.isEmpty()) {
                    resultado.append(EVENT_VACIO).append("\n");
                } else {
                    Task task = listTask.pollFirst();
                    resultado.append(task.getIdentificacionReclamo() + " " + task.getDescripcionCaso()).append("\n");
                }
            }

        }
        bf.close();
        System.out.println(resultado.toString());
    }

    public static void main(String[] args) throws Exception {
        new TestClassJ5().principal();
    }

    class Task implements Comparable<Task> {

        long identificacionReclamo;
        double promedio;
        String descripcionCaso;
        long createDate;

        public Task(long identificacionReclamo, double promedio, String descripcionCaso) {
            this.identificacionReclamo = identificacionReclamo;
            this.promedio = promedio;
            this.descripcionCaso = descripcionCaso;
            this.createDate = System.nanoTime();
        }

        public long getIdentificacionReclamo() {
            return identificacionReclamo;
        }

        public void setIdentificacionReclamo(long identificacionReclamo) {
            this.identificacionReclamo = identificacionReclamo;
        }

        public double getPrioridaPromedio() {
            return promedio;
        }

        public void setPrioridaPromedio(double promedio) {
            this.promedio = promedio;
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
            return "Task [promedio=" + promedio + ", identificacionReclamo=" + identificacionReclamo
                    + ", descripcionCaso=" + descripcionCaso + ", createDate=" + createDate + "]\n";
        }

        @Override
        public int compareTo(Task o) {
            int comparePrioridad = (int) (this.promedio - o.promedio) * -1;
            if (comparePrioridad == 0) {
                return Long.signum(this.createDate - o.createDate);
            }
            return comparePrioridad;
        }
    }
}
