package javaapplication12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class JavaApplication12 {

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> listaEnlazada = new LinkedHashMap<Integer, Integer>();
        Map<Integer, Integer> resultado = new LinkedHashMap<Integer, Integer>();
        int sum = 0;
        int indice = 0;
        int max = 0;
        System.out.println("clasificacion");
        String clasificacion = bf.readLine();
        if ("AVENIDA".equalsIgnoreCase(clasificacion)) {
            System.out.println("casosarray");
            int casosEnArray = Integer.parseInt(bf.readLine());
            System.out.println("datos de algoritmo");
            StringTokenizer st = new StringTokenizer(bf.readLine());
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
            System.out.println("ingrese marcha alcalde");
            StringTokenizer nt = new StringTokenizer(bf.readLine());
            String comando = nt.nextToken();
            int primero = Integer.parseInt(nt.nextToken());
            int segundo = Integer.parseInt(nt.nextToken());
            while ("marcha".equalsIgnoreCase(comando) || "alcalde".equalsIgnoreCase(comando)) {
                if ("marcha".equalsIgnoreCase(comando) && primero != 0 && segundo != 0) {
                    if (primero > segundo) {
                        primero = segundo;
                        segundo = primero;
                    }
                    for (int j = primero; j <= segundo; j++) {
                        sum += listaEnlazada.get(j);
                    }
                    for (int r = 1; r <= listaEnlazada.size(); r++) {
                        if (listaEnlazada.get(r) > max) {
                            max = listaEnlazada.get(r);
                        }
                        indice = r;
                    }
                    resultado.put(indice, sum);
                } else if ("alcalde".equalsIgnoreCase(comando) && primero != 0 && segundo != 0) {
                    int replace = 1;
                    for (int j = primero; replace <= 1; replace++) {
                        listaEnlazada.replace(primero, segundo);
                    }
                } else {
                    break;
                }
            }
        } else if ("CIUDAD".equalsIgnoreCase(clasificacion)) {
            System.out.println("No hay ciudad todavia :'v");
        }

        //System.out.println(listaEnlazada);
        if (indice != 0 && resultado.get(indice) != null) {
            System.out.println(indice + " " + resultado.get(indice));
        }
    }
}
