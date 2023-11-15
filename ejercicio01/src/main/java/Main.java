
import java.util.Scanner;



public class Main {

    
    public static void main(String[] args) {
        
        
        System.out.println("=======================================================");
        System.out.println("Presentado por: Joshua Julian Cobos Bautista 402Sis ");
        System.out.println("=======================================================");
        System.out.println("");
        
        int select ;
        
        do{
            
            
            select = seleccionar();
            
            
            switch (select) {
                case 1:
                        ejercicioUno();
                    break;
                    
                case 2:
                    ejercicioDos();
                    break;
                case 3:
                    ejercicioTres();
                    break;
                            
                default:
                    select=0;
            }
            
            
            
        
        }while(select !=0);
        
        
        
        
        
    }
    
    static int seleccionar(){
        
        Scanner sc = new Scanner(System.in);
        int select = 0;
        System.out.println("Elija el ejercicio que quiere ejecutar");
            System.out.println("1. Ejercio Uno: caragar e imprimir vector");
            System.out.println("2. Ejercicio Dos: Cargar, ordenar e imprimir un vector");
            System.out.println("3. Ejercicio Tres: Suma de vectores");
            System.out.println("0. Salir");
            
            
            select = sc.nextInt();
        return select;
    }
    
    static void ejercicioUno(){
        
        
        // ejercicio 1.definir un vector n, cargar e imprimir vector
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del vector");
        int lenghtArray = sc.nextInt();
        
        int [] vectorA = new int[lenghtArray] ;
        
        
        for (int i = 0; i < vectorA.length; i++) {
            System.out.println("ingrese un numero");
            vectorA[i]= sc.nextInt();
        }
        System.out.println("==============***====================");
        
        
        for (int i = 0; i < vectorA.length; i++) {
            System.out.println(vectorA[i]);
        }
    }
    
      static void ejercicioDos(){
        
//        ejercicio dos: definir un vector
//        cargar vector
//        ordnerar e imprimir


        Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el tamaño del vector");
            int lenghtArray = sc.nextInt();

            int [] vectorB = new int[lenghtArray] ;


            //cargar
            for (int i = 0; i < vectorB.length; i++) {
                System.out.println("ingrese un numero");
                vectorB[i]= sc.nextInt();
            }   

        
            
                    System.out.println("==============***====================");
        
        
                        for (int i = 0; i < vectorB.length; i++) {
                            System.out.println(vectorB[i]);
                        }
            //ordenar
            
            int temp, act;
            
            for (int i = 0; i < vectorB.length; i++) {

                for (int j = 0; j < i; j++) {
                    act = vectorB[i];
                    temp = vectorB[j];
                    if (act<temp) {
                        vectorB[i]= temp;
                        vectorB[j]=act;
                    }
                }
                
                
                
            }
            
             System.out.println("==============***====================");
        
        
                        for (int i = 0; i < vectorB.length; i++) {
                            System.out.println(vectorB[i]);
                        }
    }
      
      static void ejercicioTres(){
//          definir dos vectores A y B de n y m pocisiones
//                 cargar los vectores.
//                 realizar la suma de los vectores en un nuevo vector C
//                         imprimir


            Scanner sc = new Scanner(System.in);
            System.out.println("================Vector A==================");
            System.out.println("Ingrese el tamaño del vector A");
            int lenghtArrayA = sc.nextInt();
            
            int [] vectorA = new int[lenghtArrayA] ;
            //cargar
            for (int i = 0; i < vectorA.length; i++) {
                System.out.println("-> ingrese un numero");
                vectorA[i]= sc.nextInt();
            }
            
            System.out.println("================Vector B==================");
           
            System.out.println("Ingrese el tamaño del vector B");
            int lenghtArrayB = sc.nextInt();
            
            int [] vectorB = new int [lenghtArrayB];
                
            
             for (int i = 0; i < vectorB.length; i++) {
                System.out.println("ingrese un numero");
                vectorB[i]= sc.nextInt();
            }
                
            int [] vectorC;
            
            char small = 'a';
            if (lenghtArrayA > lenghtArrayB) {
                vectorC = new int[lenghtArrayA];
                small ='b';
            } else {
                  vectorC = new int[lenghtArrayB];
                  if(lenghtArrayA == lenghtArrayB){
                      small='n';
                  }
            }
            
            System.out.println("==================================");
            
            for (int i = 0; i < vectorC.length; i++) {
                
                
                switch (small) {
                    case 'b' -> {
                        if(i < vectorB.length){
                            vectorC[i]=vectorA[i]+vectorB[i];
                        }else{
                            vectorC[i]=vectorA[i];
                        }
                    }
                        
                    case 'a' -> {
                        if(i < vectorA.length){
                            vectorC[i]=vectorA[i]+vectorB[i];
                        }else{
                            vectorC[i]=vectorB[i];
                        }
                    }
                     case 'n' -> vectorC[i]=vectorA[i]+vectorB[i];
                    default -> throw new AssertionError();
                }
          }
            
            System.out.println("================imprimiendo Vector A==================");
            
            for (int i = 0; i < vectorA.length; i++) {
                System.out.println(vectorA[i]);
          }
            
            System.out.println("================ imprimiendo Vector B==================");
            
            for (int i = 0; i < vectorB.length; i++) {
                System.out.println(vectorB[i]);
          }
            
            System.out.println("================suma de los vectores A y B==================");
            
            for (int i = 0; i < vectorC.length; i++) {
                System.out.println(vectorC[i]);
          }
                
      }
    
}
