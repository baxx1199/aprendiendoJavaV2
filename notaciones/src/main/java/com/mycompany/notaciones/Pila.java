package com.mycompany.notaciones;


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
    
}
