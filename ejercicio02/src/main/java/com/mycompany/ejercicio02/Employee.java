
package com.mycompany.ejercicio02;


public class Employee {
    int id;
    String name;
    String position;

    public Employee(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        return "#"+id +" "+ name+ " "+ position;
    }
    
    
}
