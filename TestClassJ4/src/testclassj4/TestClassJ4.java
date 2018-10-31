package testclassj4;

import java.io.BufferedReader;
import java.util.Stack;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author RENE
 */
public class TestClassJ4 {

    public static void main(String args[]) throws IOException, ScriptException {
        String infija = "INFIJA";
        String postfijas = "POSTFIJA";
        try (InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);) {
            String clasificar = br.readLine();
            if (clasificar.equals(infija)) {
                String expreInf = br.readLine();
                ScriptEngineManager manager = new ScriptEngineManager();
                ScriptEngine engine = manager.getEngineByName("js");
                Object result = engine.eval(expreInf);
                System.out.println(result);
            } else {

                String exprePost = br.readLine();
                String expr = exprePost;
                String[] postfija = expr.split(" ");

                Stack< String> E = new Stack< String>(); //Pila completa
                Stack< String> P = new Stack< String>(); //Pila operadores         

                for (int i = postfija.length - 1; i >= 0; i--) {
                    E.push(postfija[i]);
                }

                String operadores = "+-*/%";
                while (!E.isEmpty()) {
                    if (operadores.contains("" + E.peek())) {
                        P.push(evaluar(E.pop(), P.pop(), P.pop()) + "");
                    } else {
                        P.push(E.pop());
                    }
                }
                System.out.println(P.peek());

            }
        }

    }

    private static int evaluar(String op, String n2, String n1) {
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        if (op.equals("+")) {
            return (num1 + num2);
        }
        if (op.equals("-")) {
            return (num1 - num2);
        }
        if (op.equals("*")) {
            return (num1 * num2);
        }
        if (op.equals("/")) {
            return (num1 / num2);
        }
        if (op.equals("%")) {
            return (num1 % num2);
        }
        return 0;
    }
}
