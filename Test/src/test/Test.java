/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Test {

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
            while (  ) { // correccion de lectura
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

    /*int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        int height = (int)(Math.log(n)/Math.log(2)) + 1;
        int tree_nodes = (int) Math.pow(2, height + 1);
        SegmentTree ob = new SegmentTree(tree_nodes);
        ob.build(arr, 0, 0, n - 1);
        for(int i = 0; i < tree_nodes; i++){
            System.out.print(ob.tree[i] + " ");
        }
        System.out.println();
        System.out.println(ob.query(0, 0, n - 1, 0, 5));*/
}
