package testclassj3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author RENE
 */
public class TestClassJ3 {

    /**
     * @param args the command line arguments
     */
    class participante {     //clase para anexar estudiantes en lista enlazada desde cero

        int numeroEstudiante;
        participante next;
        participante prev;

        participante() {
            this.numeroEstudiante = 1;
            this.next = this;
            this.prev = this;
        }

        participante(int numero, participante sig, participante ant) {
            this.numeroEstudiante = numero;
            this.next = sig;
            this.prev = ant;
        }

        public int getNumeroEstudiante() {
            return numeroEstudiante;
        }

        public void setNumeroEstudiante(int numeroEstudiante) {
            this.numeroEstudiante = numeroEstudiante;
        }

        public participante getNext() {
            return next;
        }

        public void setNext(participante siguiente) {
            this.next = siguiente;
        }

        public participante getPrev() {
            return prev;
        }

        public void setPrev(participante anterior) {
            this.prev = anterior;
        }

        @Override
        public String toString() {
            return Integer.toString(this.numeroEstudiante);
        }
    }

    class concursantes {

        participante actual;
        int size;

        concursantes() {
            this.actual = null;
            size = 0;
        }

        void add(int estudiante) {   //anexa nodos nuevos por estudiante
            if (this.actual == null) {
                this.actual = new participante();
            } else {
                participante nuevo = new participante(estudiante, this.actual, this.actual.getPrev());
                this.actual.getPrev().setNext(nuevo);
                this.actual.setPrev(nuevo);
            }
            this.size++;
        }

        void eliminar() {     // elimina y ordena los nodos desde el actual sin desordenarlos
            if (this.actual == this.actual.getNext()) {
                this.actual = null;
            } else {
                this.actual = this.actual.getNext();
                this.actual.setPrev(this.actual.getPrev().getPrev());
                this.actual.getPrev().setNext(this.actual);;
            }
            this.size--;
        }

        void move(long preguntas) {      //dimension grande en preguntas para poder no fallar en caso de muchos estudiantes
            preguntas = preguntas % this.size;
            if (2 * preguntas < this.size) {
                for (int i = 0; i < preguntas; i++) {
                    this.actual = this.actual.getNext();
                }
            } else {
                preguntas = size - preguntas;
                for (int i = 0; i < preguntas; i++) {
                    this.actual = this.actual.getPrev();
                }
            }
        }

        @Override
        public String toString() {
            return this.actual.toString();
        }

    }

    void principal() throws IOException {
        concursantes elMasDebil = new concursantes();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        long numEstud = Integer.parseInt(st.nextElement().toString());
        long a1 = Integer.parseInt(st.nextElement().toString());
        long b = Integer.parseInt(st.nextElement().toString());
        long c = Integer.parseInt(st.nextElement().toString());
        for (int i = 1; i <= numEstud; i++) {
            elMasDebil.add(i);
        }
        long mov = a1;
        while (numEstud > 1) {
            elMasDebil.move(mov);
            elMasDebil.eliminar();
            numEstud--;
            mov = (b * mov + c) % 1000000007;   //formula preguntas
        }
        System.out.println(elMasDebil);
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new TestClassJ3().principal();
    }

}
