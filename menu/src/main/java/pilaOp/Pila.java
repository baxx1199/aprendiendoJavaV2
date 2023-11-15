/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilaOp;

import java.util.Scanner;

/**
 *
 * @author baxx
 */
public class Pila {
    public int lf, li, base, tope, k, c;

    public Pila(int lf) {
        li = 0;
        k = 0;
        c = 1;
        tope = li -c;
        base = li;
        
        this.lf = lf;
    }
    
    
    
    
    public static void ejecutar(){
        int pila[]= new int[100];
       int salida []= new int[100];
       
       Scanner sc =new Scanner(System.in);
       
       int select = 0;
       
       int lf =10;
       Pila obj = new Pila(lf);
       int element;
       
        do {            
            System.out.println("¿Que desea hacer?");
            System.out.println("\t 1. Imprimir pila");
            System.out.println("\t2. insertar un elemento");
            System.out.println("\t3. eliminar un elemento");
            
            System.out.println("\t0. salir");
            
            select=sc.nextInt();
            
            switch (select) {
                case 1:
                    obj.mostrarPila(pila);
                    break;
                case 2:
                    System.out.println("ingrese un elemento");
                    element = sc.nextInt();
                    obj.insertar(pila, element);
                    
                    break;
                    
                    case 3:
                        obj.eliminar(pila, salida);
                    
                    break;
                
            }
        } while (select !=0);
       
       
       
       
    
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
    
    public void insertar(int a[], int elemento){
        if (tope +c >=lf) {
            System.out.println("Pila saturada");
        } else {
            tope += c;
            a[tope]= elemento;
        }
    }
    
    
    public void eliminar(int a[], int salida[]){
        if (tope<base){
            System.out.println("Pila vacia");
        }else{
            salida[k++]= a[tope];
            tope -=c;
            
            
        }
    }
}
