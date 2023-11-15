/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.codehp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.codec.binary.Base64;

import javax.swing.JOptionPane;

/**
 *
 * @author baxx
 */
public class Main {
    public static File archivo = new File("claveCodi.txt");;
    /**
     * @param args the command line arguments
     */
    
    
    
    private static void crearArchivo(){
        
        
        if (archivo.exists()) {
            JOptionPane.showMessageDialog(null, "El archivo si existe");
        } else{
            JOptionPane.showMessageDialog(null,"Archivo NO encontrado");
          
        }
    
    }
    
    public static String leer(File a){
        
        String cadena = "";
        
        try {
            FileReader fr = new FileReader(a);
            BufferedReader bfr = new BufferedReader(fr);
            
            while (cadena!=null) {                
                cadena= bfr.readLine();
                if (cadena != null) {
                    System.out.println(cadena);
                }
                
            }   
            
           
            
        } catch (FileNotFoundException ex) {
            System.err.println("Error: -->"+ ex);
        } catch (IOException ex) {
            System.err.println("Error: -->"+ ex);
        }
        
        
        return cadena;
    }
    
    public static void encodingKey(){
        String encoded = leer(archivo);
        byte[] decoded = Base64.getDecoder().decode(encoded);
        String decodedMsg = new String(decoded);
        System.out.println("Decoded Message "+decodedMsg);
       
    }
    public static void main(String[] args) {
        crearArchivo();
        encodingKey();
    }
}
