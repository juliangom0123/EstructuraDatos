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
        List<Integer> listaValResultado = new LinkedList<>();
        List<Integer> listaIndiResultado = new LinkedList<>();
        List<Integer> listaValores = new LinkedList<>();
        List<Integer> listaIndices = new LinkedList<>();
        int contadorMarchas = 0;
        System.out.println("clasiicacion");
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
                    for (int r = primero; r <= segundo; r++) {
                        if (listaEnlazada.get(r) > max) {
                            max = listaEnlazada.get(r);
                        }
                        indice = r;
                    }
                    for (int r = primero; r <= indice; r++) {
                        if (listaEnlazada.get(r) == max) {
                            indiceRepetido = r;
                        }
                    }
                    for (int r = primero; r < indice; r++) {
                        if (listaEnlazada.get(r) == max) {
                            indiceRepetido = r;
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
                        listaValResultado.add(sum);
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
            bf.close();
            if (!(listaIndiResultado.isEmpty())) {
                while (!(listaIndiResultado.isEmpty())) {
                    System.out.println(listaIndiResultado.get(0) + " " + listaValResultado.get(0));
                    listaIndiResultado.remove(0);
                    listaValResultado.remove(0);
                }
            }
            if (!(listaIndices.isEmpty())) {
                while (!(listaIndices.isEmpty())) {
                    System.out.println(listaIndices.get(0) + " " + listaValores.get(0));
                    listaIndices.remove(0);
                    listaValores.remove(0);
                }
            }
        } else if ("CIUDAD".equalsIgnoreCase(clasificacion)) {
            StringTokenizer nt = new StringTokenizer(bf.readLine());
            int calles = Integer.parseInt(nt.nextElement().toString());
            int carreras = Integer.parseInt(nt.nextElement().toString());
            ++calles;
            ++carreras;
            int[][] tablero = new int[calles][carreras];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int f1 = Integer.parseInt(st.nextElement().toString());
            int a = Integer.parseInt(st.nextElement().toString());
            int b = Integer.parseInt(st.nextElement().toString());
            int mov = f1;
            for (int cl = 1; cl < tablero.length; cl++) {
                for (int cr = 1; cr < tablero[1].length; cr++) {
                    boolean r = true;
                    while (r) {
                        tablero[cl][cr] = mov;
                        mov = (a * mov + b) % 1000000;
                        r = false;
                    }
                }
            }
            String marchaAlcade = bf.readLine();
            while (marchaAlcade != null) {
                String[] split = marchaAlcade.split(" ");
                String comando = split[0];
                if (comando.equals("")) {
                    break;
                }
                String calle1 = split[1];
                String callej = split[2];
                String carrera1 = split[3];
                String carreraj = split[4];                
                int primeracl = Integer.parseInt(calle1);
                int segundacl = Integer.parseInt(callej);
                int primeracr = Integer.parseInt(carrera1);
                int segundacr = Integer.parseInt(carreraj);
                if (primeracl > segundacl) {
                    primeracl = Integer.parseInt(callej);
                    segundacl = Integer.parseInt(calle1);
                }
                if (primeracr > segundacr) {
                    primeracr = Integer.parseInt(carreraj);
                    segundacr = Integer.parseInt(carrera1);
                }
                int sum = 0;
                int indicecl = 0;
                int indicecr = 0;
                int indiceRepetidoi = 0;
                int indiceRepetidoj = 0;
                int max = 0;
                if ("marcha".equalsIgnoreCase(comando) && primeracl != 0 && segundacl != 0 && primeracr != 0 && segundacr != 0) {
                    for (int i = primeracl; i <= segundacl; i++) {
                        for (int j = primeracr; j <= segundacr; j++) {
                            sum += tablero[i][j];
                        }
                    }
                    for (int i = primeracl; i <= segundacl; i++) {
                        for (int j = primeracr; j <= segundacr; j++) {
                            if (tablero[i][j] > max) {
                                max = tablero[i][j];
                            }
                            indicecl = i;
                            indicecr = j;
                        }
                    }
                    for (int i = primeracl; i <= indicecl; i++) {
                        for (int j = primeracr; j <= indicecr; j++) {
                            if (tablero[i][j] == max) {
                                indiceRepetidoi = i;
                                indiceRepetidoj = j;
                            }
                        }
                    }
                    for (int i = primeracl; i < indicecl; i++) {
                        for (int j = primeracr; j < indicecr; j++) {
                            if (tablero[i][j] == max) {
                                indiceRepetidoi = i;
                                indiceRepetidoj = j;
                            }
                        }
                    }
                    if (((indiceRepetidoi < indicecl && indiceRepetidoj < indicecr)) && (resultado.containsKey(indicecl) && resultado.containsKey(indicecr)) && (contadorMarchas >= 1)) {
                        int indiceListai = indiceRepetidoi;
                        int indiceListaj = indiceRepetidoj;
                        listaValores.add(sum);
                        listaIndices.add(indiceListai);
                        listaIndices.add(indiceListaj);
                        contadorMarchas--;
                        marchaAlcade = bf.readLine();
                        
                    } else {
                        listaIndiResultado.add(indicecl);
                        listaIndiResultado.add(indicecr);
                        resultado.put(indicecl, sum);
                        resultado.put(indicecr, sum);
                        listaValResultado.add(sum);
                        contadorMarchas++;
                        marchaAlcade = bf.readLine();
                    }
                } else if ("alcalde".equalsIgnoreCase(comando) && primeracl != 0 && segundacl != 0 && primeracr != 0 && (carreraj == null)) {
                    int replace = 1;
                    for (int cl = primeracl; cl < tablero.length; cl++) {
                        for (int cr = segundacl; cr < tablero[segundacl].length; cr++) {
                            tablero [cl][cr]  = primeracr;
                        }
                        marchaAlcade = bf.readLine();
                    }
                }
            }
            bf.close();
            if (!(listaIndiResultado.isEmpty())) {
                while (!(listaIndiResultado.isEmpty())) {
                    System.out.println(listaIndiResultado.get(0) + " " + listaIndiResultado.get(0) + " " + listaValResultado.get(0));
                    listaIndiResultado.remove(0);
                    listaIndiResultado.remove(0);
                    listaValResultado.remove(0);
                }
            }
            if (!(listaIndices.isEmpty())) {
                while (!(listaIndices.isEmpty())) {
                    System.out.println(listaIndices.get(0) + " " + listaIndices.get(0) + " " + listaValores.get(0));
                    listaIndices.remove(0);
                    listaIndices.remove(0);
                    listaValores.remove(0);
                }
            }
        }

        bf.close();
    }
}
