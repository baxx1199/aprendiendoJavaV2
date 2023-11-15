
import com.mycompany.arbolesbinarios.Binario;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Main {

    
    public static void main(String[] args) {
       
        
        Binario arbol=new Binario();;
        Scanner sc = new Scanner(System.in);
        int select =0, dato;
        
        do {            
//            JOptionPane.showInputDialog("¿que desea hacer? \n 1. ingresar Dato \n 2. Imprimir \n 3. Eliminar Nodo \n 0. Salir");
            System.out.println("¿que desea hacer?");
            System.out.println("1. ingresar Dato");
            System.out.println("2. Buscar");
            System.out.println("3. Imprimir");
            System.out.println("4. Eliminar Nodo");
            System.out.println("0. Salir");
            
            select = sc.nextInt();
            
            switch (select) {
                case 1:
                    System.out.println("ingrese el valor a guardar");
                    dato=sc.nextInt();
                    arbol.insertarArbol(dato);
                   
                    
                    
                    
                    
                    break;
                case 2:
                    
                    System.out.println("ingrese el valor a buscar");
                    dato=sc.nextInt();
                    arbol.ejecutarBusqueda(dato);
                    break;
                case 3:
                    imprimir(arbol);
                    break;
                  
                case 4:
                    System.out.println("Ingrese el valor a eliminar");
                    dato = sc.nextInt();
                    arbol.ejecutarEliminar(dato);
            }
                   
        } while (select!=0);
        
        
    }
    
    public static void imprimir(Binario a){
        Scanner sc = new Scanner(System.in);
        int op = 0;
        do {                        
                        System.out.println("¿Como desea imprimir el arbol?");
                        System.out.println("1. inorden");
                        System.out.println("2. preOrden");
                        System.out.println("3. posOrden");
                        System.out.println("4. Todas");
                        System.out.println("0. Salir");
                        
                        op= sc.nextInt();
                        
                        switch (op) {
                            case 1:
                                a.ejecutarIn();
                                break;
                            case 2:
                                a.ejecutarPre();

                                break;
                            case 3:
                                a.ejecutarPos();
                                break;
                            case 4:
                                a.ejecutarIn();
                                a.ejecutarPre();
                                a.ejecutarPos();
                                break;    
                            
                        }
                        
                    } while (op!=0);
    }
    
}
