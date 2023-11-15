package com.mycompany.ejerciopila;


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
