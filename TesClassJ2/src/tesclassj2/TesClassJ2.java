package tesclassj2;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author RENE
 */
public class TesClassJ2 {

//    void principal() throws Exception {
//        String casoProfesor = "";     //usar metodo de string [] para 2+ casos
//        InputStream in = new ByteArrayInputStream(casoProfesor.getBytes());
//        principal(in);
//    }

    public static void makeSierpinski(boolean [][] triangulo, int y, int x, int size, int level) {
        if (level == 0) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j <= i; j++) {
                     triangulo[y + i][x + j] = true;
                }
            }
            return;
        }
        makeSierpinski(triangulo, y, x, size / 2, level - 1);
        makeSierpinski(triangulo, y + size / 2, x, size / 2, level - 1);
        makeSierpinski(triangulo, y + size / 2, x + size / 2, size / 2, level - 1);
        return;
    }

    public void principal() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numeroTriangulos = Integer.parseInt(bf.readLine());
        int deepTriangulo = Integer.parseInt(bf.readLine());
        boolean[][] triangulo = new boolean[numeroTriangulos][numeroTriangulos];
        makeSierpinski(triangulo, 0, 0, numeroTriangulos, deepTriangulo);
        for (int i = 0; i < numeroTriangulos; i++) {
            for (int j = 0; j < numeroTriangulos; j++) {
                if (triangulo[i][j]) {
                    System.out.print("#");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) throws Exception {
        new TesClassJ2().principal();
    }
}
