package testclassj12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 *
 * @author RENE
 */
public class TestClassJ12 {

    private final static String EVENT_APELLIDO = "APELLIDO";
    private final static String EVENT_CREATED = "CREATED";
    private final static String EVENT_NOMBRE = "NOMBRE";
    private final static String EVENT_DELETE = "DELETE";
    private final static String EVENT_UPDATE = "UPDATE";
    private final static String EVENT_READ = "READ";
    private final static String EVENT_EDAD = "EDAD";
    private final static String EVENT_PAPA = "PAPA";
    private final static String EVENT_ID = "ID";

    void principal() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int lineas = 0;
        TreeSet<Estudiante> arbolito = new TreeSet<>();
        Map<Long, Estudiante> auxiliar = new LinkedHashMap<>();
        StringBuilder resultado = new StringBuilder();
        while (lineas <= 200000) {
            lineas++;
            String linea = bf.readLine();
            if (linea.equals("")) {
                break;
            }
            StringTokenizer bt = new StringTokenizer(linea);
            String comando = bt.nextToken();
            if (comando.equalsIgnoreCase(EVENT_CREATED)) {
                long idEstudante = Long.parseLong(bt.nextToken());
                String nombreEstudiante = bt.nextToken();
                String apellidoEstudiante = bt.nextToken();
                String edadAux = bt.nextToken();
                if (edadAux.contains(".")) {
                    edadAux.substring(0, Integer.parseInt("."));
                    edadAux.substring(0, (edadAux.length()) - 1);
                }
                short edadEstudiante = Short.parseShort(edadAux);
                String papaAux = bt.nextToken();
                Double papaEstudiante = Double.parseDouble(papaAux);
                Double papaFinal = (double) Math.round(papaEstudiante * 100d) / 100d;
                Estudiante estudiante = new Estudiante(idEstudante, nombreEstudiante, apellidoEstudiante, edadEstudiante, papaEstudiante);
                arbolito.add(estudiante);
                auxiliar.put(idEstudante, estudiante);
            }
            if (comando.equalsIgnoreCase(EVENT_READ)) {
                String lector = bt.nextToken();
                if (lector.equalsIgnoreCase(EVENT_ID)) {
                    int idEstud = Integer.parseInt(bt.nextToken());
                }
                if (lector.equalsIgnoreCase(EVENT_EDAD)) { 
                   short edadEstud = Short.parseShort(bt.nextToken());
                }
                if (lector.equalsIgnoreCase(EVENT_PAPA)) {
                    Double papaEstud = Double.parseDouble(bt.nextToken());
                }
                if (lector.equalsIgnoreCase(EVENT_NOMBRE) || lector.equalsIgnoreCase(EVENT_APELLIDO)) {
                    String newNick = bt.nextToken();
                }
                //resultado.append(descartable.documento + " " + descartable.nombre + " " + descartable.apellido + " " + descartable.edad + " " + descartable.papa).append("\n");
            }
            if (comando.equalsIgnoreCase(EVENT_DELETE)) {
                long idEstudDele = Long.parseLong(bt.nextToken());
                Estudiante descartable = auxiliar.get(idEstudDele);
                if (arbolito.contains(descartable)) {                    
                    arbolito.remove(descartable);
                    auxiliar.remove(idEstudDele);

                } else {
                    resultado.append("no existe estudiante con ID " + idEstudDele).append("\n");
                }

            }
            if (comando.equalsIgnoreCase(EVENT_UPDATE)) {
                int idEstudUp = Integer.parseInt(bt.nextToken());
                String datoActualizar = bt.nextToken();
                if (datoActualizar.equalsIgnoreCase(EVENT_ID)) {
                    int idEstud = Integer.parseInt(bt.nextToken());
                }
                if (datoActualizar.equalsIgnoreCase(EVENT_EDAD)) {
                    short edadEstud = Short.parseShort(bt.nextToken());
                }
                if (datoActualizar.equalsIgnoreCase(EVENT_PAPA)) {
                    Double papaEstud = Double.parseDouble(bt.nextToken());
                }
                if (datoActualizar.equalsIgnoreCase(EVENT_NOMBRE) || datoActualizar.equalsIgnoreCase(EVENT_APELLIDO)) {
                    String newNick = bt.nextToken();
                }
            }
        }
        bf.close();
        System.out.println(resultado.toString());

    }

    public static void main(String[] args) throws Exception {
        new TestClassJ12().principal();
    }

    class Estudiante implements Comparable<Estudiante> {

        Long documento;
        String nombre;
        String apellido;
        short edad;
        double papa;

        @Override
        public String toString() {
            return "Estudiante{" + "documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", papa=" + papa + '}';
        }

        public Estudiante(Long documento, String nombre, String apellido, short edad, double papa) {
            this.documento = documento;
            if (nombre.length() <= 50) {
                this.nombre = nombre;
            } else {
                this.nombre = nombre.substring(0, 50);
            }
            if (apellido.length() <= 50) {
                this.apellido = apellido;
            } else {
                this.apellido = apellido.substring(0, 50);
            }
            if (edad <= 0) {
                this.edad = 0;
            } else if ((edad <= 127) && (edad > 0)) {
                this.edad = edad;
            } else if (edad > 127) {
                this.edad = 127;
            }
            this.papa = papa;
        }

        public long getDocumento() {
            return documento;
        }

        public void setDocumento(long documento) {
            this.documento = documento;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public short getEdad() {
            return edad;
        }

        public void setEdad(short edad) {
            this.edad = edad;
        }

        public double getPapa() {
            return papa;
        }

        public void setPapa(double papa) {
            this.papa = papa;
        }

        @Override
        public int compareTo(Estudiante o) {
            int resultado = this.apellido.compareTo(o.apellido);
            if (resultado == 0) {
                resultado = this.nombre.compareTo(o.nombre);
                if (resultado == 0) {
                    if (this.papa > o.papa) {
                        return -1;
                    }
                    if (this.papa < o.papa) {
                        return 1;
                    }
                    if (resultado == 0) {
                        if (this.documento > o.documento) {
                            return -1;
                        }
                        if (this.documento < o.documento) {
                            return 1;
                        }
                    }
                }
            }
            return resultado;
        }

    }

}
