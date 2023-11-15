
package com.mycompany.ejerciciocola;

public class Cola {
    public int lf ,li, c, cab, cola , k;

    public Cola(int lf) {
        
        li = 0;
        c=1;
        k=0;
        cab = li -c;
        cola = cab;
        
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
