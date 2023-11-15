
import com.mycompany.quiz.Pila;
import java.util.Scanner;


public class Main {

   
    public static void main(String[] args) {
        String palabra;
       char pila[]= new char[100];
       String salida []= new String[100];
       
       Scanner sc =new Scanner(System.in);
       
       
       
       int select = 0;
       

      
       
        do {            
            System.out.println("¿Que desea hacer?");
            System.out.println("\t 1. comprobar una palabra");

            
            System.out.println("\t0. salir");
            
            select=sc.nextInt();
            
            switch (select) {
                case 1:
                    
                     System.out.println("ingrese la palabra que quiere comprobar");
                     palabra= sc.next();
                     
                    int lf =palabra.length();
                    Pila obj = new Pila(lf);
                    obj.insertar(pila, palabra);
                    
                    
                    break;
                
                
            }
        } while (select !=0);
       
       
       
       
    }
    
    }
    

