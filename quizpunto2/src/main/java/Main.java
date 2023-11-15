
import com.mycompany.quizpunto2.Pila;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

  
    public static void main(String[] args) {
       
       float pila[]= new float[100];
       float salida []= new float[100];
       
       float numeros [] = new float[10] ;
       Scanner sc =new Scanner(System.in);
       
       int select = 0;
       
       int lf =10;
       Pila obj = new Pila(lf);
       
       
        do {            
            System.out.println("¿Que desea hacer?");
            System.out.println("\t 1. continuar");
            
           
            System.out.println("\t0. salir");
            
            select=sc.nextInt();
            
            switch (select) {
                case 1:
                    for (int i = 0; i < 10; i++) {
                        System.out.println("ingrese un numero");
                        numeros[i]= sc.nextFloat();
                    }
                    
                    obj.insertar(pila,numeros);
                    obj.mostrarPila(pila);
                    break;
               
                    
                   
                
            }
        } while (select !=0);
       
       
       
       
    
    }
    
}
