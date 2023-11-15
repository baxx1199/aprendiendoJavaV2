
package com.mycompany.listaencadenada;
import java.util.Scanner;

public class Main {
    static Nodo cab, nuevo, ant,p;

    public Main(Nodo cab) {
        this.cab = null;
    }
    
    
    
    public static void main(String[] args) {
        int dato, count =0;
        Scanner sc = new Scanner(System.in);
        
        
        while (count ==0) {
            if (cab == null) {
                System.out.println("Ingrese un valor");
                dato= sc.nextInt();
                cab = new Nodo(dato);
                ant= cab;
            } else {
                System.out.println("Ingrese un valor");
                dato= sc.nextInt();
                nuevo = new Nodo(dato);
                ant.sig = nuevo;
                ant = nuevo;
                System.out.println("¿Continuar? 0 = si");
                count = sc.nextInt();
                
            }
            
        }
        
        p= cab;
        
        while (p!=null) {
           
            System.out.println(p.intro);
            p=p.sig;
        }
        
         
    }
     public void introCab(Nodo cab){
        Scanner sc = new Scanner(System.in);
    
        int dato;
        System.out.println("Ingrese dato");
        
        dato= sc.nextInt();
        
        nuevo = new Nodo(dato);
        nuevo.sig = cab;
        
        cab= nuevo;
        
        
    }
      
    
    
}
