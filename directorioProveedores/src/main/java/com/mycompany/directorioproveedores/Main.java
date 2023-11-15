/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.directorioproveedores;

import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author baxx
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        DirectorioProveedores d = new DirectorioProveedores();
        int op = 0;
       
        do {            
            System.out.println("Seleccion la accion que desea realizar"); 
            System.out.println("1. agregar proveedor"); 
            System.out.println("2. buscar proveedor"); 
            System.out.println("3. eliminar proveedor"); 
            System.out.println("4. mostrar todos los proveedores"); 
            System.out.println("5. ¡El directorio esta vacio?"); 
            System.out.println("6. Mostrar Cuantos proveedores hay"); 
            
            System.out.println("0. Salir");


             op = sc.nextInt();


            switch (op) {
                case 1:
                    add(d);
                    break;
                 case 2:
                    search(d);
                    break;
                 case 3:
                    delete(d);
                    break;
                  case 4:
                    see(d);
                  case 5:
                      
                      if(d.isEmpty()){
                        System.out.println("El directorio esta vacio.");
                      }else{
                      System.out.println("El directorio No esta vacio");
                      }
                      

                    break;
                   case 6:
                      
                      if(d.isEmpty() == false){
                        System.out.println("El directorio tiene "+ d.size() + 1  +" proveedores.");
                      }else{
                        System.out.println("El directorio esta vacio");
                      }
                      

                    break;
                

                    
                default:
                    throw new AssertionError();
            }
        } while (op!= 0);
        
    }
    
    public static void add(DirectorioProveedores directorio){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese el nit del proveedor");
        String nit = sc.nextLine();
        System.out.println("Ingrese el nombre del proveedor");
        String nombreProveedor = sc.nextLine();
        System.out.println("Ingrese el direccion del proveedor");
        String direccion = sc.nextLine();
        System.out.println("Ingrese el correo del proveedor");
        String correo = sc.nextLine();
        
        Proveedor proveedor1 = new Proveedor(nit, nombreProveedor, direccion, correo);
        
        directorio.put(proveedor1.getNit(), proveedor1);
    }
    
    public static void search(DirectorioProveedores directorio){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese el nit del proveedor a buscar");
        String nit = sc.nextLine();
        
        
        
        Proveedor proveedor = directorio.get(nit);
        
        proveedor.toString();
    }
    public static void delete(DirectorioProveedores directorio){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese el nit del proveedor a eliminar");
        String nit = sc.nextLine();
        
        
        
        Proveedor proveedorEliminado = directorio.remove(nit);
        
        proveedorEliminado.toString();
    }
    
    public static void see(DirectorioProveedores directorio){
         
        Iterator<String> claves = directorio.keys();
        Iterator<Proveedor> valores = directorio.values();
        while (claves.hasNext()) {
            String clave = claves.next();
            Proveedor proveedor = valores.next();
            System.out.println(clave + " - " + proveedor.getNombre() + " - " + proveedor.getDireccion() + " - " + proveedor.getCorreo());
        }
    }
}
