package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Test {

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> listaEnlazada = new LinkedHashMap<Integer, Integer>();
        Map<Integer, Integer> resultado = new LinkedHashMap<Integer, Integer>();
        List<Integer> resultadoM = new LinkedList<>();
        List<Integer> listaIndiResultado = new LinkedList<>();
        List<Integer> listaValores = new LinkedList<>();
        List<Integer> listaIndices = new LinkedList<>();
        int contadorMarchas = 0;
        String clasificacion = bf.readLine();
        if ("AVENIDA".equalsIgnoreCase(clasificacion)) {
            int casosEnArray = Integer.parseInt(bf.readLine());
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
            String marchaAlcade = bf.readLine();
            while (marchaAlcade != null) {
                String[] split = marchaAlcade.split(" ");
                String comando = split[0];
                if (comando.equals("")) {
                    break;
                }
                String numeroUno = split[1];
                String numeroDos = split[2];
                int primero = Integer.parseInt(numeroUno);
                int segundo = Integer.parseInt(numeroDos);
                if (primero > segundo) {
                    primero = Integer.parseInt(numeroDos);
                    segundo = Integer.parseInt(numeroUno);
                }
                int sum = 0;
                int indice = 0;
                int indiceRepetido = 0;
                int max = 0;
                if ("marcha".equalsIgnoreCase(comando) && primero != 0 && segundo != 0) {
                    for (int j = primero; j <= segundo; j++) {
                        sum += listaEnlazada.get(j);
                    }
                    for (int r = 1; r <= segundo; r++) {
                        if (listaEnlazada.get(r) > max) {
                            max = listaEnlazada.get(r);
                        }
                        indice = r;
                    }
                    for (int r = 1; r < indice; r++) {
                        if (listaEnlazada.get(r) == max) {
                            indiceRepetido = r;            // indice en 0 cuando se repite
                        }
                    }
                    if ((indiceRepetido < indice) && resultado.containsKey(indice) && (contadorMarchas >= 1)) {
                        int indiceLista = indiceRepetido;
                        listaValores.add(sum);
                        listaIndices.add(indiceLista);
                        contadorMarchas--;
                        marchaAlcade = bf.readLine();
                    } else {
                        listaIndiResultado.add(indice);
                        resultado.put(indice, sum);
                        resultadoM.add(sum);
                        marchaAlcade = bf.readLine();
                        contadorMarchas++;
                    }
                } else if ("alcalde".equalsIgnoreCase(comando) && primero != 0 && segundo != 0) {
                    int replace = 1;
                    for (int j = primero; replace <= 1; replace++) {
                        listaEnlazada.replace(primero, segundo);
                    }
                    marchaAlcade = bf.readLine();
                }
            }
        } else if ("CIUDAD".equalsIgnoreCase(clasificacion)) {
            System.out.println("No hay ciudad todavia :'v");
        }
        bf.close();
        if (!(listaIndiResultado.isEmpty())) {
            while (!(listaIndiResultado.isEmpty())) {
                System.out.println(listaIndiResultado.get(0) + " " + resultadoM.get(0));
                listaIndiResultado.remove(0);
                resultadoM.remove(0);
            }
        }
        if (!(listaIndices.isEmpty())) {
            while (!(listaIndices.isEmpty())) {
                System.out.println(listaIndices.get(0) + " " + listaValores.get(0));
                listaIndices.remove(0);
                listaValores.remove(0);
            }
        }
    }
}
