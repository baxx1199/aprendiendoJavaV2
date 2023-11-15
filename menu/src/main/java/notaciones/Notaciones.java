package notaciones;

import java.util.Scanner;


public class Notaciones {
    public int lf, li, base, tope, k, c;
    
    
    public Notaciones(int lf) {
        li = 0;
        k = 0;
        c = 1;
        tope = li -c;
        base = li;
        
        this.lf = lf;
    }
    
    
    public void mostrarPila(int a []){
        
        if(tope<base){
                System.out.println("Pila vacia");
        
        }else{
            for (int i = base; i <=tope; i++) {
                System.out.println("\t"+ a[i]);
            }
        }
    }
    
    public void insertar(char a[], char elemento){
        if (tope +c >=lf) {
            System.out.println("Pila saturada");
        } else {
            tope += c;
            a[tope]= elemento;
        }
    }
    
    
    public void eliminar(char a[], String salida){
        
        if (tope<base){
            System.out.println("Pila vacia");
        }else{
            salida += a[tope];
            tope -=c;
            
            
        }
    }
    
    public char pop(char a[]){
        
        char ultimo;
         if (tope<base){
            System.out.println("Pila vacia");
            ultimo = ' ';
        }else{
            ultimo = a[tope];
            tope -=c;
            
            
        }
        return ultimo;
    }
    
    
    public static void ejecutar(){
        Scanner sc = new Scanner(System.in);
        int select = 0;
        
        String infija;
        
        
        do {            
            System.out.println("¿Que desea hacer?");
            System.out.println("1.conversion postfija");
            System.out.println("2.Conversion prefija");
            System.out.println("0.salir");
            select=sc.nextInt();
            switch (select) {
                case 1:
                    System.out.println("Escriba la ecucacion");
                infija = sc.next();
                    toPostfijo(infija);
                    break;
                case 2:
                    System.out.println("Escriba la ecucacion");
                infija = sc.next();
                    toPrefijo(infija);
                    break;
               
            }
                  
            
        } while (select != 0);
        
        
    }
    
    public static void toPostfijo(String infija){
        
        String postfija = "";
         char auxiliar[]=new char[100];
        Notaciones obj = new Notaciones(infija.length());
        
        for (int i = 0; i < infija.length(); i++) {
            
            if(infija.charAt(i)>='0' & infija.charAt(i)<='9'){
                postfija=postfija + infija.charAt(i);
            }else if(infija.charAt(i)>='*' & infija.charAt(i)<='/'){
                
                obj.insertar(auxiliar, infija.charAt(i));
            }else if(infija.charAt(i)==')'){
                postfija=postfija+obj.pop(auxiliar);
            }
            
        }
        
        
        postfija=postfija+obj.pop(auxiliar);
        
        System.out.println(postfija);
    }
    
    public static void toPrefijo(String infija){
        
        String prefija = "";
         char auxiliar[]=new char[infija.length()];
        Notaciones obj = new Notaciones(infija.length());
        
        for (int i = infija.length()-1; i > 0; i--) {
            System.out.println(infija.charAt(i));
            
            if(infija.charAt(i)>='*' & infija.charAt(i)<='/' ){
                prefija = prefija + infija.charAt(i);
            }else if(infija.charAt(i)>='0' & infija.charAt(i)<='9'){
                
                 obj.insertar(auxiliar, infija.charAt(i));
             
                 for (int j = 0; j < auxiliar.length; j++) {
                     System.out.println(auxiliar[j]);
                }
            }else if(infija.charAt(i)==')'){
                prefija = prefija+obj.pop(auxiliar);
            }
            
        }
        
        
        prefija=prefija+obj.pop(auxiliar);
        
        System.out.println(prefija);
    }
    
    
    
}
