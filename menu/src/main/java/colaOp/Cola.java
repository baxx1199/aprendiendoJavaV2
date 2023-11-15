/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colaOp;

import java.util.Scanner;

/**
 *
 * @author baxx
 */
public class Cola {
    public int lf ,li, c, cab, cola , k;

    public Cola(int lf) {
        
        li = 0;
        c=1;
        k=0;
        cab = li -c;
        cola = cab;
        
    }
    
    public static void ejecutar(){
     Scanner sc = new Scanner(System.in);
        
        int op,ele;
        int cola[]= new int [100];
        int salida[]= new int [100];
        System.out.println("ingrese el tamaño de la cola");
        int lf = sc.nextInt();
        
        Cola obj = new Cola(lf);
        
        int select= 0;
        do {            
            System.out.println("¿Que desea hacer?");
            System.out.println("\t1. Imprimir pila");
            System.out.println("\t2. insertar un elemento");
            System.out.println("\t3. eliminar un elemento");
            
            System.out.println("\t0. salir");
            
            select=sc.nextInt();
            
            switch (select) {
                case 1:
                    obj.imprimir(cola);
                    break;
                case 2:
                    System.out.println("ingrese un elemento");
                    ele = sc.nextInt();
                    obj.insertar(cola, ele);
                    
                    break;
                    
                    case 3:
                        obj.eliminar(cola, salida);
                    
                    break;
                
            }
        } while (select !=0);
    }
    
    public void insertar(int a[],int elemento){
        
        if(cola+c>lf){
            
            System.out.println("Cola Saturada");
        }else{
            if(cab<li){
                cab=li;
                cola=li;
            }else{
                cola += c;
                a[cola] = elemento;
                System.out.println(elemento + " " + a[cola]);
                
            }
        }
        
    }
    
    public void eliminar(int a[],int salida[]){
    
        if (cab < li) {
            System.out.println("Cola Vacia");
        } else {
            
            salida[k] = a [cab];
            cab +=c;
            if (cab >=cola) {
                cab = li -c;
                cola= cab;
                
            }
        }
    }
    
    
    
    public void imprimir(int a[]){
        if (cab < li) {
            System.out.println("Cola vacia");
        } else {
            for (int i = cab; i <= cola; i++) {
                System.out.println("\t "+a[i]);
                
            }
            System.out.println("\t cab: "+cab + " cola: "+ cola);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
