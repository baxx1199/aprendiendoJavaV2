/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.directorioproveedores;
import java.util.HashMap;
import java.util.Iterator;

public class DirectorioProveedores {
    private HashMap<String, Proveedor> proveedores;

    public DirectorioProveedores() {
        proveedores = new HashMap<String, Proveedor>();
    }

    public Proveedor get(String nit) {
        return proveedores.get(nit);
    }

    public void put(String nit, Proveedor proveedor) {
        proveedores.put(nit, proveedor);
    }

    public Proveedor remove(String nit) {
        return proveedores.remove(nit);
    }

    public int size() {
        return proveedores.size();
    }

    public boolean isEmpty() {
        return proveedores.isEmpty();
    }

    public Iterator<String> keys() {
        return proveedores.keySet().iterator();
    }

    public Iterator<Proveedor> values() {
        return proveedores.values().iterator();
    }

    
}

