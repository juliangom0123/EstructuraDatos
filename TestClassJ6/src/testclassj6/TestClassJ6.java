/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclassj6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author RENE
 */
public class TestClassJ6 {

    public static String Organizador(StringBuilder expr) {
        StringBuilder resultado = new StringBuilder();
        int i = 0;

        StringBuilder word = new StringBuilder();;
        while (i < expr.length()) {
            word.delete(0, word.length());
            switch (expr.charAt(i)) {
                case '(':
                    i++;
                    while (i < expr.length()) {
                        if (expr.charAt(i) == '(' || expr.charAt(i) == ')') {
                            break;
                        }
                        word.append(expr.charAt(i));
                        i++;
                    }
                    resultado.insert(0, word);
                    break;
                case ')':
                    i++;
                    while (i < expr.length()) {
                        if (expr.charAt(i) == '(' || expr.charAt(i) == ')') {
                            break;
                        }
                        word.append(expr.charAt(i));
                        i++;
                    }
                    resultado.append(word);
                    break;
                default:
                    resultado.append(expr.charAt(i));
                    i++;
            }
        }
        return resultado.toString();
    }

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        BufferedReader auxIngre = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ingreso = new StringBuilder(auxIngre.readLine());
            System.out.println(Organizador(ingreso));
    }
}
