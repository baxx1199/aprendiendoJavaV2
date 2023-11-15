/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.recursividad;

import java.util.Scanner;

/**
 *
 * @author joshu
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int select =0, num;
        
        do {            
            System.out.println("1. factorial");
            System.out.println("2. fibonacci");
            System.out.println("3. Minimo comun divisor");
            System.out.println("4. recursividad");
            System.out.println("0. Salir");
            
            select=sc.nextInt();
            
            switch (select) {
                case 1:
                    System.out.println("Ingrese el numero del factorial");
                    num = sc.nextInt();
                    System.out.println(factorial(num)) ;
                    break;
                case 2:
                    
                    System.out.println("ingrese el limite de fibonacci");
                    System.out.println(fibonacci(sc.nextInt()));
                    break;
                case 3:
                    
                    System.out.println("ingrese dos numeros");
                    System.out.println(mcd(sc.nextInt(), sc.nextInt()));
                    break;
                case 4:
                    
                    System.out.println("ingrese un numero");
                    recursividad(sc.nextInt());
                    break;
                case 0:
                    select=0;
                    break;
            }
            
        } while (select !=0);
        

    }
    
    public static int factorial(int n){
        if(n==0){
            return 1;
        }else{
            n=n*factorial(n-1);
        }
        return n;
    }
    
    public static int fibonacci(int n){
        
        if(n==1||n==2){
            return 1;
        }else{
           return fibonacci(n-1)+fibonacci(n-2); 
        }
        
        
    }
    
    public static int mcd(int n1, int n2){
        int res =0, k;
        
        
        k= n1%n2;
        
        if(k==0){
            res =n2;
        }else{
            res= mcd(n2, k);
        }
        
        return res;
    }
    
    
    public static void recursividad(int n) {
        if(n<10){
            System.out.println(n);
            recursividad(n+1);
        }
        
    }
}
