/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclassj11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author RENE
 */
public class TestClassJ11 {

    void principal() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("ingrese casos y longitud");
        String elemento = bf.readLine();
        String[] datosEntrada = elemento.trim().split(" ");
        int numeroPalabras = Integer.parseInt(datosEntrada[0]);
        int maximoLongitud = Integer.parseInt(datosEntrada[1]);
        int[] resultado = new int[maximoLongitud+1];
        System.out.println("ingrese palabras");
        String p1 = "internitic";
        String p2 = "intercambio";
        for (int i = 0; i < resultado.length ; i++) {
            String c1 = p1.substring(0, i);
            String c2 = p2.substring(0, i);
            if (c1.equalsIgnoreCase(c2)) {
                resultado[i] += 1;
            } else {
                resultado[i] += 2;
            }

        }
        System.out.println("conteo de letras");
        for (int r = 1; r < resultado.length; r++) {
            System.out.print(resultado[r] + " ");
        }

    }

    public static void main(String[] args) throws Exception {
        new TestClassJ11().principal();
    }

}
