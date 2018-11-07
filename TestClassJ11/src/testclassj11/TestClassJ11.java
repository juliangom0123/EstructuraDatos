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
        int [] resultado = new int[maximoLongitud-1];
        System.out.println("ingrese palabras");
        String p1 = bf.readLine();
        String p2 = bf.readLine();
        for (int i = 0; i < p1.length(); i++) {
            
        }
        /*if(p1.length() >= maximoLongitud){
            p1 = p1.substring(0, maximoLongitud);
        }
        if(p2.length() >= maximoLongitud){
            p2 = p2.substring(0, maximoLongitud);
        }*/
        System.out.println("---");        
        System.out.println(p1);
        System.out.println(p2);
        
        
    }

    public static void main(String[] args) throws Exception {
        new TestClassJ11().principal();
    }

}
