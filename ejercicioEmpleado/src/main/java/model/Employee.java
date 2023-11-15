/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.Controller;


public class Employee {
    private String name;
    private String lastName;
    private int hours;
    int extrasHours;
    private int salary;
    
    private Controller control;

    public Employee() {
    }

    
    
    public Employee(String name, String lastName, int hours, int extrasHours) {
        this.name = name;
        this.lastName = lastName;
        this.hours = hours;
        this.extrasHours = extrasHours;
        this.salary = setSalary(hours, extrasHours);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getExtrasHours() {
        return extrasHours;
    }

    public void setExtrasHours(int extrasHours) {
        this.extrasHours = extrasHours;
    }

    public int getSalary() {
        return salary;
    }
    
    
    
    // Realiza un programa que calcule el salario de los empleados
        //hora normales 4k
        //hora extras 5k
        //despues de 10 horas extras estas se pagaran a 5700k
        //escribir * por nombre del trabajador terminara el programa
    
    public int setSalary(int hours,int extras){
        
        int temp=0;
        
        if(extras>10){
            int tempExtras = extras -10;
            
            temp = (hours * 4000)+ (10*5000)+(tempExtras*5700);
        }else{
            temp = (hours * 4000)+ (extras*5000);
        }
        
        
        return temp;
    }

    public Employee addEmployee(String name,String lastname,int hour, int extras){
        Employee newEmployee = new Employee(name, lastname, hours, extrasHours);
        
        return newEmployee;
    }
    
    public void setController(Controller control) {
        this.control = control;
    }
}
