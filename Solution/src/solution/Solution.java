package solution;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 *
 * @author RENE
 */
public class Solution {

    void principal() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);        
        String strLine = null;
        StringBuilder resultado = new StringBuilder();        
        while ((strLine = bf.readLine()) != null) {
            boolean respuesta = true;
            if (strLine.equals("")) {
                break;
            }
            int arr[] = new int[Integer.parseInt(strLine)];
            String relleno = bf.readLine();
            StringTokenizer st = new StringTokenizer(relleno);
            for (int i = 0; i < arr.length; i++) {                
                arr[i] = Integer.parseInt(st.nextToken());                
            }
            for (int j = 0; j < arr.length; j++) {
                int max = 0;
                if(max < arr[j]){
                    max = arr[j];
                }else{
                    respuesta = false;
                }                
            }
            if(respuesta == true){
                resultado.append("Ordenado").append("\n");
            }else{
                resultado.append("NO Ordenado").append("\n");
            }            
        }
        System.out.println(resultado.toString());
    }

    public static void main(String[] args) throws Exception {
        new Solution().principal();
    }
}
