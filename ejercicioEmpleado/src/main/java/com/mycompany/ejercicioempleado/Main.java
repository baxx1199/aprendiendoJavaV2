
package com.mycompany.ejercicioempleado;

import controller.Controller;
import model.Employee;
import vista.Vadd;
import vista.Vlist;
import vista.Vmenu;


public class Main {

   
    public static void main(String[] args) {
       Vmenu vmenu =new Vmenu();
       Vadd vadd = new Vadd();
       Vlist vlist = new Vlist();
      
        Employee employee = new Employee();
        
         Controller control = new Controller(employee, vadd, vlist, vmenu);
       
     
       
       vmenu.setVisible(true);
       
    }
    
}
