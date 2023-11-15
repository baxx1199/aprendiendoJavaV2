/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.guardarusuarios;

import controlador.Control;
import modelos.Usuario;
import vistas.VInicio;

/**
 *
 * @author baxx
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Usuario user = new Usuario();
        VInicio vini =new VInicio();
        
        Control control = new Control(user, vini);
        
        vini.setVisible(true);
    }
    
}
