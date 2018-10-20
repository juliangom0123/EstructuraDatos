
package javaapplication12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class JavaApplication12 {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> listaEnlazada = new LinkedHashMap<Integer, Integer>();
        Map<Integer, Integer> resultado = new LinkedHashMap<Integer, Integer>();
        System.out.println("clasificacion");
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String clasificacion = st.nextElement().toString();
        String ar = st.nextElement().toString();
        String bq= st.nextElement().toString();
        int sum = 0;
        int indice = 0;
        int max = 0;
        if ("AVENIDA".equalsIgnoreCase(clasificacion) && ar == null && bq ==null) {
            System.out.println("casosarray");
            int casosEnArray = Integer.parseInt(bf.readLine());
            System.out.println("datos de algoritmo");
            int f1 = Integer.parseInt(st.nextElement().toString());
            int a = Integer.parseInt(st.nextElement().toString());
            int b = Integer.parseInt(st.nextElement().toString());

            int mov = f1;
            listaEnlazada.put(1, mov);
            int i = 2;
            while (casosEnArray > 1) {
                casosEnArray--;
                mov = (a * mov + b) % 1000000;
                listaEnlazada.put(i, mov);
                i++;
            }
        } else if ("CIUDAD".equalsIgnoreCase(clasificacion)) {
            System.out.println("No hay ciudad todavia :v");

        } else {

        }

        while (clasificacion != null) {
            System.out.println("ingrese marcha alcalde");
            StringTokenizer nt = new StringTokenizer(bf.readLine());
            String comando = nt.nextElement().toString();
            int primero = Integer.parseInt(nt.nextElement().toString());
            int segundo = Integer.parseInt(nt.nextElement().toString());
    }

}
}
