/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.memoriadinamicajava;

public class Employee {
    
    
    private String name;
    private String lastName;
    private int hours;
    int extrasHours;
    private int salary;
    
    

    public Employee(String name, String lastName, int hours,int extrasHours) {
        this.name = name;
        this.lastName = lastName;
        this.hours = hours;
        salary=getSalary(hours, extrasHours);
        
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
    
     public int getSalary(int hours, int extraHours){
         
         
         int tempSalary;
         
         
         if (extraHours>10) {
             int temExt = extraHours-10;
             tempSalary = (hours*4000)+(10*5000)+(temExt*5700);
         } else {
             tempSalary = (hours*4000)+(extraHours*5000);
         }
         
        
         return tempSalary;
     }

    @Override
    public String toString() {

        return "Nombre: "+name+ " Su salario es: "+ salary +" horas trabajadas: "+hours + "Horas extras "+extrasHours; 
    }
   
        public Employee addEmployee(String name, String lastname, int hours){
            Employee newEmployee = new Employee(name, lastname, hours,extrasHours);
            
          //  newEmployee.salary=getSalary(hours);
           return  newEmployee ;
        }
    
}
