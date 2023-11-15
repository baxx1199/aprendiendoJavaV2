
package com.mycompany.quizpunto2;


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
    
    
    public void mostrarPila(float a []){
        
        if(tope<base){
                System.out.println("Pila vacia");
        
        }else{
            for (int i = base; i <=tope; i++) {
                System.out.println("\t"+ a[i]);
            }
        }
    }
    
    public void insertar(float a[], float[]b){
        System.out.println("original");
        for (int i = 0; i < b.length; i++) {
            System.out.print(" "+ b[i]);
        }
        System.out.println("");
        if (tope +c >=lf) {
            System.out.println("Pila saturada");
        } else {
            tope += c;
            for (int i = 0; i < b.length; i++) {
                a[tope]= b[i];
            }
            
        }
        
        mostrarPila(b);
        
        
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
