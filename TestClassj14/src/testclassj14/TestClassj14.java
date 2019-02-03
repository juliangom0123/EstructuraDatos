package testclassj14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author RENE
 */
public class TestClassj14 {

    class Fraccion implements Comparable<Fraccion> {

        private int num;
        private int den;

        public Fraccion() {
            num = 0;
            den = 1;
        }

        public Fraccion(int x, int y) {
            num = x;
            den = y;
        }

        private int mcd() {
            int u = Math.abs(num);
            int v = Math.abs(den);
            if (v == 0) {
                return u;
            }
            int r;
            while (v != 0) {
                r = u % v;
                u = v;
                v = r;
            }
            return u;
        }

        public Fraccion simplificar() {
            int dividir = mcd();
            num /= dividir;
            den /= dividir;
            return this;
        }

        public String toString() {
            String texto = num + " / " + den;
            return texto;
        }

        public int compareTo(Fraccion o) {
            int resultado = 1;//this.apellido.compareTo(o.apellido);
            return resultado;
        }
    }

    void principal() throws Exception {
        Map<Double, String> mapa = new TreeMap<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("casos");
        int numeroCasos = Integer.parseInt(bf.readLine());
        int contadorIngresos = 0;
        System.out.println("promedios");
        String linea = bf.readLine();
        StringTokenizer st = new StringTokenizer(linea);
        while (contadorIngresos < numeroCasos) {
            contadorIngresos++;                        
            int numerador = Integer.parseInt(st.nextToken());
            int denominador = Integer.parseInt(st.nextToken());
            Fraccion entrante = new Fraccion(numerador, denominador);
            entrante.simplificar();
            double numeradorPromedio = numerador*1.0;
            double denominadorPromedio = denominador*1.0;
            double promedio = numeradorPromedio/denominadorPromedio;
            mapa.put(promedio, entrante.toString());
        }
        //System.out.println("posicion de mediana:" + (((mapa.size() - 1) / 2) + 1));     //algoritmo find median  
        //actualizacion por indicador de posicion 
        //algoritmo de recorrido para funciones variantes
        System.out.println(mapa.toString());
    }

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        new TestClassj14().principal();
    }

}
