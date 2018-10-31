package testclassj3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author RENE
 */
public class TestClassJ3 {

    /**
     * @param args the command line arguments
     */
    void principal() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        long numEstud = Integer.parseInt(st.nextElement().toString());
        long a1 = Integer.parseInt(st.nextElement().toString());
        long b = Integer.parseInt(st.nextElement().toString());
        long c = Integer.parseInt(st.nextElement().toString());

        long mov = a1;
        while (numEstud > 1) {
            // hacer metodo de elmasdebil.mover(mov);
            //usar metodo de eliminacion en elmasdebil.eliminar_mas_debil();
            numEstud--;
            mov = (b * mov + c) % 1000000007;
        }
        // print metodo  System.out.println(elmasdebil);
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new TestClassJ3().principal();
    }

}
/*
class persona que tenga los atributos de recorrido

*/
