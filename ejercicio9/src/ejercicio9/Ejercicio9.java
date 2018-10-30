package ejercicio9;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
/**
 *
 * @author RENE
 */
public class Ejercicio9 {

//    void principal() throws Exception {
//        String[] casoProfesor = {"AVENIDA\n"
//            + "10\n"
//            + "5 1 2\n"
//            + "MARCHA 1 10\n"
//            + "MARCHA 4 8\n"
//            + "MARCHA 9 3\n"
//            + "ALCALDE 4 19\n"
//            + "MARCHA 1 10\n"
//            + "MARCHA 4 8\n"
//            + "MARCHA 9 3\n",
//            "avenida\n"
//            + "10\n"
//            + "5 1 2\n"
//            + "marcha 1 10\n"
//            + "marcha 4 8\n"
//            + "marcha 9 3\n"
//            + "alcalde 4 19\n"
//            + "marcha 1 10\n"
//            + "marcha 4 8\n"
//            + "marcha 1 10\n"};
//        InputStream in = new ByteArrayInputStream(casoProfesor[0].getBytes());
//        principal(in);
//    }
    public void principal() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long[] esmadPorCalle;
        StringBuilder resultado = new StringBuilder();

        String clasificacion = bf.readLine();
        if ("AVENIDA".equalsIgnoreCase(clasificacion)) {
            int callesAvenida = Integer.parseInt(bf.readLine());
            esmadPorCalle = new long[callesAvenida];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int f1 = Integer.parseInt(st.nextElement().toString());
            int a = Integer.parseInt(st.nextElement().toString());
            int b = Integer.parseInt(st.nextElement().toString());
            esmadPorCalle[0] = f1;

            for (int i = 1; i < callesAvenida; i++) {
                esmadPorCalle[i] = (a * esmadPorCalle[i - 1] + b);
            }
            //System.out.println("Time 1::" + (System.nanoTime() - begin));

            String linea = bf.readLine();
            while (linea != null) {
                String[] split = linea.split(" ");
                String comando = split[0];

                if ("marcha".equalsIgnoreCase(comando)) {
                    int sum = 0;
                    long max = -1L;
                    int calleInicio = Integer.parseInt(split[1]) - 1;
                    int calleFin = Integer.parseInt(split[2]) - 1;
                    int sentidoMarcha = Integer.signum(calleFin - calleInicio);
                    List<IndiceMinimoMaximo> calleEsmadMax = new ArrayList<>();
                    long beginBoss = System.nanoTime();
                    //calleEsmadMax.add(new IndiceMinimoMaximo(0, 0));
                    //Arrays.asList(arreglo).forEach(System.out::println);  //recorrer arrelo como lista O de 
                    int indice = -1;
                    if (sentidoMarcha == 1) {
                        for (int j = calleInicio; j <= calleFin; j = j + sentidoMarcha) {
                            sum += esmadPorCalle[j];
                            if (esmadPorCalle[j] > max) {
                                max = esmadPorCalle[j];
                                //calleEsmadMax.add(new IndiceMinimoMaximo(max, j));
                                indice = j;
                            } else if (esmadPorCalle[j] == max) {
                                calleEsmadMax.add(new IndiceMinimoMaximo(max, j));
                            }
                        }
                    } else if (sentidoMarcha == -1) {
                        for (int j = calleInicio; j >= calleFin; j = j + sentidoMarcha) {
                            sum += esmadPorCalle[j];
                            if (esmadPorCalle[j] > max) {
                                max = esmadPorCalle[j];
                                //calleEsmadMax.add(new IndiceMinimoMaximo(max, j));
                                indice = j;
                            } else if (esmadPorCalle[j] == max) {
                                calleEsmadMax.add(new IndiceMinimoMaximo(max, j));
                            }
                        }
                    }

                    if (!calleEsmadMax.isEmpty()) {
                        calleEsmadMax.add(new IndiceMinimoMaximo(max, indice));
                        Collections.sort(calleEsmadMax);
                        resultado.append(calleEsmadMax.get(0).indice + 1).append(" ").append(sum).append("\n");
                    } else {
                        resultado.append(indice + 1).append(" ").append(sum).append("\n");
                    }

                    //System.out.println("Time 2::" + (System.nanoTime() - beginBoss));
                } else if ("alcalde".equalsIgnoreCase(comando)) {
                    int calle = Integer.parseInt(split[1]) - 1;
                    long nuevaCantidadEsmad = Long.parseLong(split[2]);
                    esmadPorCalle[calle] = nuevaCantidadEsmad;
                }
                linea = bf.readLine();
            }
        }
        System.out.println(resultado.toString());
        bf.close();
    }

    class IndiceMinimoMaximo implements Comparable<IndiceMinimoMaximo> {

        long max;
        int indice;

        IndiceMinimoMaximo(long max, int indice) {
            this.max = max;
            this.indice = indice;
        }

        @Override
        public int compareTo(IndiceMinimoMaximo t) {
            int resultado = Long.signum(t.max - this.max);
            if (resultado == 0) {
                return Integer.signum(this.indice - t.indice);
            }
            return resultado;
        }
    }

    public static void main(String[] args) throws Exception {
        new Ejercicio9().principal();
    }
}
