
import com.mycompany.ejerciopila.Pila;
import java.util.Scanner;


public class Main {

    
    public static void main(String[] args) {
       String pila[]= new String[100];
       String salida []= new String[100];
       
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
    
}
