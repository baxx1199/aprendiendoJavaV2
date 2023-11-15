/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.metodosbusqueda;

import java.util.Scanner;

/**
 *
 * @author joshu
 */
public class Main {

    public static void main(String[] args) {
        
        //busqueda secuancial
        
        Scanner sc = new Scanner(System.in);
//        int numeros []= {6,8,2,3,1,7,4,9};
//        boolean search = false;
//        int iterador = 0;
//        System.out.println("Ingrese el numero que desea buscar");
//        int num = sc.nextInt();
//        do {            
//            if(numeros[iterador]==num){
//                search=true;
//            }
//            iterador ++;
//        } while (iterador<numeros.length && search==false);
//        
//        if (search==true) {
//            System.out.println("El numero buscado "+ num + " fue encontrado en la poscision "+ (iterador-1));
//        }else{
//             System.out.println("El numero buscado "+ num + " no fue encontrado ");
//
//        }
        
        
        //busuqeda binaria
        int numbers []= {1,2,3,4,8,10,20,35};
        
        //el arreglo debe estar ordenado
        System.out.println("Ingrese el numero que desea buscar");
        int numBinary = sc.nextInt();
        int k =0;
        int f=numbers.length - 1 ;
        int m;
        boolean sb = false;
        
        do {            
            m = (k + f)/2;
            
            if(numBinary < numbers[m]){
            
                f = m;
            
            }else if(numBinary > numbers[m]){
                k = m;
            }else if(numBinary == numbers[m]){
                sb = true;
            }
            
        } while (m!= 0 && sb == false);
        
        if (sb==true) {
            System.out.println("El numero buscado "+ numBinary + " fue encontrado en la poscision "+ m);
        }else{
             System.out.println("El numero buscado "+ numBinary + " no fue encontrado ");

        }
        
    }
    
}
