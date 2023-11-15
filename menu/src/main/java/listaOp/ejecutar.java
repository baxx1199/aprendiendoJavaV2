
package listaOp;
import java.util.Scanner;

public class ejecutar {
    static Lista cab, nuevo, ant,p;

    public ejecutar(Lista cab) {
        this.cab = null;
    }
    
    
    
    public static void main(String[] args) {
        
        
         
    }
    public static void correr(){
        int dato, count =0;
        Scanner sc = new Scanner(System.in);
        
        
        while (count ==0) {
            if (cab == null) {
                System.out.println("Ingrese un valor");
                dato= sc.nextInt();
                cab = new Lista(dato);
                ant= cab;
            } else {
                System.out.println("Ingrese un valor");
                dato= sc.nextInt();
                nuevo = new Lista(dato);
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
     public void introCab(Lista cab){
        Scanner sc = new Scanner(System.in);
    
        int dato;
        System.out.println("Ingrese dato");
        
        dato= sc.nextInt();
        
        nuevo = new Lista(dato);
        nuevo.sig = cab;
        
        cab= nuevo;
        
        
    }
      
    
    
}
