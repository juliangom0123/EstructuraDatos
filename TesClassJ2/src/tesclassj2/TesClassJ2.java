/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    void principal() throws Exception {
        String casoProfesor = "tarea";
        InputStream in = new ByteArrayInputStream(casoProfesor.getBytes());
        principal(in);
    }

    public void principal(InputStream in) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String clasificacion = bf.readLine();
    }

    public static void main(String[] args) throws Exception {
        new TesClassJ2().principal();
    }

}
