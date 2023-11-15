
package com.mycompany.quiz;


public class Pila {
    
    int li,lf,tope,base,c,k;

    public Pila( int lf) {
        li = 0;
        k=0;
        c=1;
        tope= li-c;
        base = li;
        this.lf=lf;
        
    }
    
    
    public void insertar(char a[], String palabra){
        
        
        if (tope +c >=lf) {
            System.out.println("Pila saturada");
        } else {
            for (int i = 0; i < palabra.length(); i++) {
                tope += c;
            a[tope]= palabra.charAt(i);
            }
            
        }
        
        String tempPalabra="";
        
        
        
            
            if(tope<base){
                System.out.println("Pila vacia");
        
        }else{
            for (int i = tope; i >=base; i--) {
                tempPalabra+= a[i];
                System.out.println(a[i]);
            }
                System.out.println("-- "+ tempPalabra);
                System.out.println("-- "+palabra);
        }
            
            if(palabra.equalsIgnoreCase(tempPalabra)){
                System.out.println(palabra + " es un palindormo");
            }else{
                
                System.out.println(palabra + " no es un palindormo");
            }
            
            
            if(tope<base){
                System.out.println("Pila vacia");
        
        }else{
            for (int i = base; i <=tope; i++) {
                System.out.println("\t"+ a[i]);
            }
        }
    }
    

    
}
