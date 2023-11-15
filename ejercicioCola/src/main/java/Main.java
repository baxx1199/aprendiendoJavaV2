
import com.mycompany.ejerciciocola.Cola;
import java.util.Scanner;


public class Main {

    
    public static void main(String[] args) {
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
    
}
