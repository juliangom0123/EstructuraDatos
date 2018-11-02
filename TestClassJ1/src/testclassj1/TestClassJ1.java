/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclassj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author RENE
 */
public class TestClassJ1 {

    class Estudiante {

        String usuario;
        long promedio;
        long creditosTotales;
        long creditosSemestre;

        public Estudiante() {
            this.usuario = null;
            this.promedio = 0;
            this.creditosTotales = 0;
            this.creditosSemestre = 0;
        }

        public Estudiante(String nombre, long prom, long Totales, long Semestre) {
            this.usuario = nombre;
            this.promedio = prom;
            this.creditosTotales = Totales;
            this.creditosSemestre = Semestre;
        }

        public Estudiante(String nombre) {
            this.usuario = nombre;
            this.promedio = 0;
            this.creditosTotales = 0;
            this.creditosSemestre = 0;
        }

        long compareTo(Estudiante otro) {
            if (this.promedio * otro.creditosTotales < otro.promedio * this.creditosTotales) {
                return 1;
            }
            if (this.promedio * otro.creditosTotales > otro.promedio * this.creditosTotales) {
                return -1;
            }
            if (this.creditosSemestre < otro.creditosSemestre) {
                return 1;
            }
            if (this.creditosSemestre > otro.creditosSemestre) {
                return -1;
            }
            return this.usuario.compareTo(otro.usuario);
        }

    }

    void principal() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int casosEstudiante = Integer.parseInt(reader.readLine());
        Estudiante inscripciones[] = new Estudiante[casosEstudiante];
        for (int i = 0; i < casosEstudiante; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            inscripciones[i] = new Estudiante(st.nextElement().toString());
            int m = Integer.parseInt(st.nextElement().toString());
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(reader.readLine());
                int creditos = Integer.parseInt(st.nextElement().toString());
                inscripciones[i].creditosTotales += creditos;
                String nota = st.nextElement().toString();
                if (!nota.equalsIgnoreCase("cancelado")) {
                    inscripciones[i].creditosSemestre += creditos;
                    inscripciones[i].promedio += (int) (Double.parseDouble(nota) * 10) * creditos;   //casting para evitar errores poner cuidado 
                }
            }
        }
        for (int r = 0; r < casosEstudiante; r++) {
            for (int j = r + 1; j < casosEstudiante; j++) {
                if (inscripciones[j].compareTo(inscripciones[r]) < 0) {
                    Estudiante auxi = inscripciones[r];
                    inscripciones[r] = inscripciones[j];
                    inscripciones[j] = auxi;
                }
            }
        }
        for (int j = 0; j < casosEstudiante; j++) {
            System.out.println(inscripciones[j].usuario);

        }
    }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new TestClassJ1().principal();
    }
}


    


