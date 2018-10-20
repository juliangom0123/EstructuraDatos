/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import java.util.StringTokenizer;

class SegmentTree {

    int[] tree;

    SegmentTree(int n) {
        tree = new int[n];
    }

    void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    void update(int[] arr, int node, int index, int val, int start, int end) {
        if (start == end) {
            tree[node] += val;
            arr[start] += val;
        } else {
            int mid = (start + end) / 2;
            if (start <= index && index <= mid) {
                update(arr, 2 * node + 1, index, val, start, mid);
            } else {
                update(arr, 2 * node + 2, index, val, mid + 1, end);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    int query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int p1 = query(2 * node + 1, start, mid, left, right);
        int p2 = query(2 * node + 2, mid + 1, end, left, right);
        return p1 + p2;
    }
}

public class Test {

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,Integer> listaEnlazada = new LinkedHashMap<Integer,Integer>();
        String clasificacion = null;
        System.out.println("clasificacion");
        while ((clasificacion = bf.readLine()) != null) {
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
                int numMax = 0;                
                for (int r = 1; r <= listaEnlazada.size(); r++) {
                    if (Integer.parseInt(listaEnlazada.get(r).toString()) > numMax) {
                        numMax = Integer.parseInt(listaEnlazada.get(r).toString());
                    }
                }                                

            } else if ("CIUDAD".equalsIgnoreCase(clasificacion)) {
                System.out.println("No hay ciudad todavia :v");
                break;
            }
        }
        bf.close();
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

