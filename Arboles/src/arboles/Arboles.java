/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;
import java.util.*;
/**
 *
 * @author hp
 */
public class Arboles {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nodos = Integer.valueOf(s.nextLine());
        ArrayList <Nodo> arbol = new ArrayList<>(); 
        Stack <Double> resultado = new Stack<>();
        Stack <Nodo> jerarquia = new Stack<>();
        boolean error = false;
        for(int i = 0; i < nodos; i++){
            String elemento = s.nextLine();
            String[] expresion = elemento.trim().split(" ");            
            Nodo caracter = new Nodo(expresion[0],i,Integer.valueOf(expresion[1])-1,Integer.valueOf(expresion[2])-1);
            arbol.add(caracter);
        }
        /*
        int nodos = 11;
        
        Nodo n0 = new Nodo("+",0,2-1,3-1);
        arbol.add(n0);
        Nodo n1 = new Nodo("/",1,4-1,5-1);
        arbol.add(n1);
        Nodo n2 = new Nodo("-",2,6-1,7-1);
        arbol.add(n2);
        Nodo n3 = new Nodo("-1.2",3,-1-1,-1-1);
        arbol.add(n3);
        Nodo n4 = new Nodo("2",4,-1-1,-1-1);
        arbol.add(n4);
        Nodo n5 = new Nodo("12.45",5,-1-1,-1-1);
        arbol.add(n5);
        Nodo n6 = new Nodo("*",6,8-1,9-1);
        arbol.add(n6);
        Nodo n7 = new Nodo("-",7,10-1,11-1);
        arbol.add(n7);
        Nodo n8 = new Nodo("4.5",8,-1-1,-1-1);
        arbol.add(n8);
        Nodo n9 = new Nodo("3.58",9,-1-1,-1-1);
        arbol.add(n9);
        Nodo n10 = new Nodo("1.58",10,-1-1,-1-1);
        arbol.add(n10);
        */        
        int raiz = 0;
        /*
        while(arbol.get(hijo).getIzq()>= 0){  
            jerarquia.push(arbol.get(hijo));
            padre = arbol.get(hijo).getIzq();
            hijo = arbol.get(padre).getIzq();            
        }
        */
        do{
            do{
                do{
                    jerarquia.push(arbol.get(raiz));
                    System.out.println("Pushed "+jerarquia.peek().getElemento());
                    raiz = arbol.get(raiz).getIzq();
                }while(arbol.get(raiz).getIzq() >= 0);
                System.out.println("Hoja izquierda");
                resultado.push(Double.valueOf(arbol.get(raiz).getElemento()));
                System.out.println("Pushed "+resultado.peek());    
            
                raiz = jerarquia.peek().getDer();
            }while(arbol.get(raiz).getDer() >= 0);
            
            System.out.println("Hoja derecha");
            resultado.push(Double.valueOf(arbol.get(raiz).getElemento()));
            System.out.println("Pushed "+resultado.peek());
        
            System.out.println("Opero");
            double operando1;
            double operando2;
            Nodo cambio = new Nodo();
            switch(jerarquia.peek().getElemento()){
                case "/":
                    operando2 = resultado.pop();
                    operando1 = resultado.pop();
                    if(operando2==0){error = true;}
                    resultado.push(operando1/operando2);                    
                    System.out.println("Pushed "+resultado.peek());
                    cambio.setDer(-1);
                    cambio.setIzq(-1);
                    cambio.setIndice(jerarquia.peek().getIndice());
                    cambio.setElemento(resultado.peek().toString());
                    arbol.set(jerarquia.peek().getIndice(),cambio);
                    System.out.printf("Cambiado %s en %d por %s\n",jerarquia.peek().getElemento(),jerarquia.peek().getIndice(),cambio.getElemento());
                    System.out.println("Poped "+jerarquia.peek().getElemento());
                    if(!jerarquia.empty()){
                        jerarquia.pop();
                    }                     
                    break;
                
                case "-":
                    operando2 = resultado.pop();
                    operando1 = resultado.pop();
                    resultado.push(operando1-operando2);                    
                    System.out.println("Pushed "+resultado.peek());
                    cambio.setDer(-1);
                    cambio.setIzq(-1);
                    cambio.setIndice(jerarquia.peek().getIndice());
                    cambio.setElemento(resultado.peek().toString());
                    arbol.set(jerarquia.peek().getIndice(),cambio);
                    System.out.printf("Cambiado %s en %d por %s\n",jerarquia.peek().getElemento(),jerarquia.peek().getIndice(),cambio.getElemento());
                    System.out.println("Poped "+jerarquia.peek().getElemento());
                    if(!jerarquia.empty()){
                        jerarquia.pop();
                    }                     
                    break;
                
                case "*":
                    operando2 = resultado.pop();
                    operando1 = resultado.pop();
                    resultado.push(operando1*operando2);                    
                    System.out.println("Pushed "+resultado.peek());
                    cambio.setDer(-1);
                    cambio.setIzq(-1);
                    cambio.setIndice(jerarquia.peek().getIndice());
                    cambio.setElemento(resultado.peek().toString());
                    arbol.set(jerarquia.peek().getIndice(),cambio);
                    System.out.printf("Cambiado %s en %d por %s\n",jerarquia.peek().getElemento(),jerarquia.peek().getIndice(),cambio.getElemento());
                    System.out.println("Poped "+jerarquia.peek().getElemento());
                    if(!jerarquia.empty()){
                        jerarquia.pop();
                    }                     
                    break;
            
                case "+":
                    operando2 = resultado.pop();
                    operando1 = resultado.pop();
                    resultado.push(operando1+operando2);                    
                    System.out.println("Pushed "+resultado.peek());
                    cambio.setDer(-1);
                    cambio.setIzq(-1);
                    cambio.setIndice(jerarquia.peek().getIndice());
                    cambio.setElemento(resultado.peek().toString());
                    arbol.set(jerarquia.peek().getIndice(),cambio);
                    System.out.printf("Cambiado %s en %d por %s\n",jerarquia.peek().getElemento(),jerarquia.peek().getIndice(),cambio.getElemento());
                    System.out.println("Poped "+jerarquia.peek().getElemento());
                    if(!jerarquia.empty()){
                        jerarquia.pop();
                    }                    
                    break;
            
                default: break;
            }              
        
        
        
        
            System.out.printf("%.6f %n", resultado.peek());
            
            if(!jerarquia.empty()){
                System.out.println("Padre backwards "+jerarquia.peek().getElemento());
                raiz = jerarquia.peek().getIndice();
                jerarquia.pop();
            }            
        }while(arbol.get(raiz).getIzq()>0);
        
        /*
        for(int i = 0; i < nodos; i++){
            System.out.println(arbol.get(i).getElemento());
        }
        */  
        

        
        
    }
    
}

class Nodo{
    String elemento;
    int izq;
    int der;
    int indice;
    
    public Nodo(){
        this.elemento="";
        this.izq=0;
        this.der=0; 
        this.indice = 0;
    }
    
    public Nodo(String elemento,int indice, int izq, int der){
        this.elemento=elemento;
        this.izq=izq;
        this.der=der; 
        this.indice=indice;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }   
    
    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public int getIzq() {
        return izq;
    }

    public void setIzq(int izq) {
        this.izq = izq;
    }

    public int getDer() {
        return der;
    }

    public void setDer(int der) {
        this.der = der;
    }
    
    
}