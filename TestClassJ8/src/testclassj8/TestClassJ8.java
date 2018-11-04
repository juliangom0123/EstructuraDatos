package testclassj8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author RENE
 */
public class TestClassJ8 {

    void principal() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cantidadNodos = Integer.valueOf(bf.readLine());
        ArrayList<Nodo> arbol = new ArrayList<>();
        List<Double> resultado = new LinkedList<>();
        boolean error = false;
        for (int i = 0; i < cantidadNodos; i++) {
            String elemento = bf.readLine();
            String[] abolEnArray = elemento.trim().split(" ");
            Nodo ingreso = new Nodo(abolEnArray[0], i, Integer.valueOf(abolEnArray[1]) - 1, Integer.valueOf(abolEnArray[2]) - 1);
            arbol.add(ingreso);
        }
        for (int r = arbol.size() - 1; r >= 0; r--) {
            if ((arbol.get(r).getElemento().contains("0")) || (arbol.get(r).getElemento().contains("1"))
                    || (arbol.get(r).getElemento().contains("2")) || (arbol.get(r).getElemento().contains("3"))
                    || (arbol.get(r).getElemento().contains("4")) || (arbol.get(r).getElemento().contains("5"))
                    || (arbol.get(r).getElemento().contains("6")) || (arbol.get(r).getElemento().contains("7"))
                    || (arbol.get(r).getElemento().contains("8")) || (arbol.get(r).getElemento().contains("9"))) {
                resultado.add(Double.valueOf(arbol.get(r).getElemento()));
            }
            double operando1;
            double operando2;
            switch (arbol.get(r).getElemento()) {
                case "/":
                    operando2 = resultado.get(0);
                    resultado.remove(0);
                    operando1 = resultado.get(0);
                    resultado.remove(0);
                    if (operando2 == 0) {
                        error = true;
                    }
                    resultado.add(Double.valueOf(operando1 / operando2));
                    break;
                case "-":
                    operando2 = resultado.get(0);
                    resultado.remove(0);
                    operando1 = resultado.get(0);
                    resultado.remove(0);
                    if (operando2 == 0) {
                        error = true;
                    }
                    resultado.add(Double.valueOf(operando1 - operando2));
                    break;
                case "*":
                    operando2 = resultado.get(0);
                    resultado.remove(0);
                    operando1 = resultado.get(0);
                    resultado.remove(0);
                    if (operando2 == 0) {
                        error = true;
                    }
                    resultado.add(Double.valueOf(operando1 * operando2));
                    break;
                case "+":
                    operando2 = resultado.get(0);
                    resultado.remove(0);
                    operando1 = resultado.get(0);
                    resultado.remove(0);
                    if (operando2 == 0) {
                        error = true;
                    }
                    resultado.add(Double.valueOf(operando1 + operando2));
                    break;
                case "%":
                    operando2 = resultado.get(0);
                    resultado.remove(0);
                    operando1 = resultado.get(0);
                    resultado.remove(0);
                    if (operando2 == 0) {
                        error = true;
                    }
                    resultado.add(Double.valueOf(operando1 % operando2));
                    break;
            }
        }
        if (!resultado.isEmpty()) {
            System.out.printf("%.6f %n", resultado.get(0));
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public static void main(String[] args) throws Exception {
        new TestClassJ8().principal();
    }

    class Nodo {

        String elemento;
        int izq;
        int der;
        int indice;

        public Nodo() {
            this.elemento = "";
            this.izq = 0;
            this.der = 0;
            this.indice = 0;
        }

        public Nodo(String elemento, int indice, int izq, int der) {
            this.elemento = elemento;
            this.izq = izq;
            this.der = der;
            this.indice = indice;
        }

        public int getIndice() {
            return indice;
        }

        public void setIndice(int indice) {
            this.indice = indice;
        }

        public String getElemento() {
            return elemento;
        }

        public void setElemento(String elemento) {
            this.elemento = elemento;
        }

        public int getIzq() {
            return izq;
        }

        public void setIzq(int izq) {
            this.izq = izq;
        }

        public int getDer() {
            return der;
        }

        public void setDer(int der) {
            this.der = der;
        }

    }

}
