/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaApplication7 {

    public Map<CarreraLocalizador, List<Estudiante>> mapa = new HashMap<>();

    class Estudiante {

        public String nombre;
        public String carrera;

        Estudiante() {
            this(null, null);
        }

        Estudiante(String nombre, String carrera) {
            this.nombre = nombre;
            this.carrera = carrera;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return this.nombre;
        }

        @Override
        public int hashCode() {
            int hash = 7;
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
            final Estudiante other = (Estudiante) obj;
            if (!Objects.equals(this.nombre, other.nombre)) {
                return false;
            }
            if (!Objects.equals(this.carrera, other.carrera)) {
                return false;
            }
            return true;
        }

    }

    class CarreraLocalizador {

        String carrera;
        Integer carreraIndicador = 0;

        CarreraLocalizador(Integer carreraId, String carrera) {
            this.carreraIndicador = carreraId;
            this.carrera = carrera;
        }

        public String getCarrera() {
            return carrera;
        }

        public void setCarrera(String carrera) {
            this.carrera = carrera;
        }

        @Override
        public int hashCode() {
            int hash = 7;
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
            final CarreraLocalizador other = (CarreraLocalizador) obj;
            if (!Objects.equals(this.carrera, other.carrera)) {
                return false;
            }
            return true;
        }
    }

    public void principal() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int contador = 0;
        int lineas = 0;
        List<Estudiante> ausencia = new ArrayList();
        while (lineas <= 100000) {
            lineas++;
            String linea = bf.readLine();
            StringTokenizer st = new StringTokenizer(linea);
            String comando = st.nextToken();
            if (comando.equalsIgnoreCase("BYE")) {
                break;
            }
            if (comando.equalsIgnoreCase("LLEGA")) {
                String nombreEstudiante = st.nextToken();
                String nombreMateria = st.nextToken();
                Estudiante nuevoEnFila = new Estudiante(nombreEstudiante, nombreMateria);
                CarreraLocalizador carrera = new CarreraLocalizador(0, nombreMateria);
                List<Estudiante> listaEstudiantes = mapa.get(carrera);
                if (listaEstudiantes == null) {
                    listaEstudiantes = new ArrayList<>();
                    carrera.carreraIndicador = contador;
                    contador++;
                    mapa.put(carrera, listaEstudiantes);
                }
                listaEstudiantes.add(nuevoEnFila);
            }
            if (comando.equalsIgnoreCase("ATIENDE")) {
                if (mapa.isEmpty()) {
                    String nadie = "Forever Alone";
                    Estudiante x = new Estudiante(nadie, null);
                    ausencia.add(x);
                }else{
                CarreraLocalizador auxiliar = mapa.keySet().iterator().next();
                List<Estudiante> posicionCero = mapa.get(auxiliar);
                //if (!ausencia.contains(posicionCero.get(0))) {
                    ausencia.add(posicionCero.get(0));
                //}
                posicionCero.remove(0);
                if (posicionCero.isEmpty()) {
                    mapa.remove(auxiliar);
                }
                }
            }
        }

        bf.close();
        for (Estudiante x: ausencia) {
            System.out.println(x.nombre);
            
        }
    }

    public static void main(String args[]) throws Exception {
        JavaApplication7 x = new JavaApplication7();
        x.principal();
    }
}

