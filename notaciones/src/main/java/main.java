
import com.mycompany.notaciones.Pila;
import java.util.Scanner;


public class main {

    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int select = 0;
        
        String infija;
        
        
        do {            
            System.out.println("¿Que desea hacer?");
            System.out.println("1.conversion postfija");
            System.out.println("2.Conversion prefija");
            System.out.println("0.salir");
            select=sc.nextInt();
            switch (select) {
                case 1:
                    System.out.println("Escriba la ecucacion");
                infija = sc.next();
                    toPostfijo(infija);
                    break;
                case 2:
                    System.out.println("Escriba la ecucacion");
                infija = sc.next();
                    toPrefijo(infija);
                    break;
               
            }
                  
            
        } while (select != 0);
        
        
    }
    
    public static void toPostfijo(String infija){
        
        String postfija = "";
         char auxiliar[]=new char[100];
        Pila obj = new Pila(infija.length());
        
        for (int i = 0; i < infija.length(); i++) {
            
            if(infija.charAt(i)>='0' & infija.charAt(i)<='9'){
                postfija=postfija + infija.charAt(i);
            }else if(infija.charAt(i)>='*' & infija.charAt(i)<='/'){
                
                obj.insertar(auxiliar, infija.charAt(i));
            }else if(infija.charAt(i)==')'){
                postfija=postfija+obj.pop(auxiliar);
            }
            
        }
        
        
        postfija=postfija+obj.pop(auxiliar);
        
        System.out.println(postfija);
    }
    
    public static void toPrefijo(String infija){
        
        String prefija = "";
         char auxiliar[]=new char[infija.length()];
        Pila obj = new Pila(infija.length());
        
        for (int i = infija.length()-1; i > 0; i--) {
            System.out.println(infija.charAt(i));
            
            if(infija.charAt(i)>='*' & infija.charAt(i)<='/' ){
                prefija = prefija + infija.charAt(i);
            }else if(infija.charAt(i)>='0' & infija.charAt(i)<='9'){
                
                 obj.insertar(auxiliar, infija.charAt(i));
             
                 for (int j = 0; j < auxiliar.length; j++) {
                     System.out.println(auxiliar[j]);
                }
            }else if(infija.charAt(i)==')'){
                prefija = prefija+obj.pop(auxiliar);
            }
            
        }
        
        
        prefija=prefija+obj.pop(auxiliar);
        
        System.out.println(prefija);
    }
    
}
