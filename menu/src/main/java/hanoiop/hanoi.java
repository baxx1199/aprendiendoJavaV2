/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hanoiop;

import java.util.Scanner;
import vistas.MenuVista;
/**
 *
 * @author baxx
 */
public class hanoi {
     
    public static void ejecutar(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("ingrese el numero de discos");
        int discos = sc.nextInt();
        int moviemientos = moves(2, discos)-1;
        calcular(discos, "Origen", "Temporal", "Final");
        System.out.println("Juego perfecto en " + moviemientos);
    }
    public static void calcular(int numDiscos, String torreOrigen, String torreTemporal,String torreFinal ){
        
        if(numDiscos==1){
            System.out.println("El disco de la torre " + torreOrigen + " Pasa a la torre "+torreFinal);
            
        }else{
            calcular(numDiscos-1, torreOrigen, torreFinal,torreTemporal);
            System.out.println("El disco de la torre " + torreOrigen + " Pasa a la torre "+torreFinal);
            
            calcular(numDiscos-1, torreTemporal, torreOrigen, torreFinal);
        }
        
    }
    
    public static int moves(int a, int b){
        
        if(b==0){
            return  1;
        }else{
            return a*moves(a, b-1);
        }
    
    }
    
}
