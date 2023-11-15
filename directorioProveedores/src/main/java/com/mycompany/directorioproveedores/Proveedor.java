/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.directorioproveedores;

public class Proveedor {
    private String nit;
    private String nombre;
    private String direccion;
    private String correo;

    public Proveedor(String nit, String nombre, String direccion, String correo) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return  " Nit: "+nit + "  Nombre: "+ nombre + " Direccion: "+ direccion + " correo: "+ correo; 
    }
    
    
    
}
