
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Employee;
import vista.Vadd;
import vista.Vlist;
import vista.Vmenu;


public class Controller implements ActionListener,KeyListener{

   private Employee employee;
   public Vadd vadd;
   private Vlist vlist;
   private Vmenu vmenu;

    public Controller(Employee employee, Vadd vadd, Vlist vlist, Vmenu vmenu) {
        this.employee = employee;
        this.vadd = vadd;
        this.vlist = vlist;
        this.vmenu = vmenu;
        assignment();
    }
    
    public void assignment(){
        
        vmenu.getBtnAddMenu().addActionListener(this);
        vmenu.getBtnCloseMenu().addActionListener(this);
        vmenu.getBtnSeelistMenu().addActionListener(this);
        vadd.getBtnAddVadd().addActionListener(this);
        vadd.getBtnBackAdd().addActionListener(this);
        vadd.getBtnCloseAdd().addActionListener(this);
        vlist.getBtnBackList().addActionListener(this);
        vlist.getBtnCloseList().addActionListener(this);
        vlist.getBtnExport().addActionListener(this);
        vlist.getBtnImport().addActionListener(this);
        vadd.nameTxt.addKeyListener(this) ;
        
        
    }

    
    ArrayList<Employee>employees = new ArrayList<>();
   
  
   public void addNewEmployee(){
       
       
       if("*".equals(vadd.getNameTxt().getText())){
           JOptionPane.showMessageDialog(null, "Nombre invalido, programa finalizado");
           
           vadd.dispose();
       }
       else{
           String newName = vadd.getNameTxt().getText();
           System.out.println(newName.getClass().getSimpleName());
           
           String newLastName = vadd.getLastNameTxt().getText();
            int hours = Integer.parseInt(vadd.getHoursTxt().getText());
            int extrahours = Integer.parseInt(vadd.getExtraTxt().getText()); 

            Employee newEmployee =new Employee(newName, newLastName, hours, extrahours);

            employees.add(newEmployee);

            clean();
            JOptionPane.showMessageDialog(null,"agregado exitosamente: "+newEmployee.getName()+" " + newEmployee.getLastName()+" " + newEmployee.getSalary() );

           
       }
       
       
   }
          
//   public void verification(){
//       vadd.nameTxt.addKeyListener(new KeyAdapter() {
//           @Override
//           public void keyPressed(KeyEvent e) {
//               if (e.getKeyCode()==KeyEvent.VK_ASTERISK) {
//                   vadd.dispose();
//               }
//           }
//           
//          
//       });
//   }
   
   
   
     public void insertInformation(ArrayList r){
         DefaultTableModel md = new DefaultTableModel(new String[]{"Nombre","Apellidos","salario"},employees.size());
         vlist.getjTable1().setModel(md);
         
         TableModel model = vlist.getjTable1().getModel();
         
         for (int i = 0; i < r.size(); i++) {
             Employee employee = (Employee) r.get(i);
             model.setValueAt(employee.getName(), i, 0);
             model.setValueAt(employee.getLastName(), i, 1);
             model.setValueAt(employee.getSalary(), i, 2);

         }
     }
     
     //Escribir en fichero 
     
     public void writter(){
    
        PrintWriter listEmployees = null;
        try {
           
            listEmployees = new PrintWriter(new BufferedWriter(new FileWriter("employees.txt")));
            for (int i = 0; i < employees.size(); i++) {
                listEmployees.println(employees.get(i).getName() + "___" +employees.get(i).getLastName()+ "___" +employees.get(i).getHours()+ "___" +employees.get(i).getExtrasHours()+ "___" +employees.get(i).getSalary());
            }
            listEmployees.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Upps... Algo a salido mal.");
        } 
            listEmployees.close();
        
    }
     
     //Leer fichero
     
     public void importPatients( ) {

        try {


            //lectura de datos
            FileReader fR = new FileReader("employees.txt");
            
            try (BufferedReader checkedemployees = new BufferedReader(fR)) {
                String ingres = new String();
                String emNameOlder;
                String emLastNameOlder;
                String emHours;
                String emExtrahours;
                String emSalary;
                
                while ((ingres=checkedemployees.readLine()) != null) {
                    
                    String[] olders = ingres.split("___");
                    emNameOlder = olders[0];
                    emLastNameOlder = olders[1];
                    emHours = olders[2] ;
                    emExtrahours = olders[3];
                    emSalary = olders[4];
                    
                    
                    Employee em = new Employee(emNameOlder, emLastNameOlder, Integer.parseInt(emHours) , Integer.parseInt(emExtrahours));
                    employees.add(em);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Upps... Algo a salido mal.");
        }
        
    }
    
     
  
   
        public void clean (){
            vadd.getNameTxt().setText("");
            vadd.getLastNameTxt().setText("");
            vadd.getHoursTxt().setText("");
            vadd.getExtraTxt().setText(""); 
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(vmenu.getBtnAddMenu()==e.getSource()){
            vadd.setVisible(true);
            vmenu.setVisible(false);
        }else if (vmenu.getBtnCloseMenu()==e.getSource()) {
            vmenu.dispose();
        } else if(vmenu.getBtnSeelistMenu()==e.getSource()){
            vlist.setVisible(true);
            insertInformation(employees);
            vmenu.setVisible(false); 
        }else if (vadd.getBtnAddVadd()==e.getSource()) {
            addNewEmployee();
            System.out.println(employees);
            
        } else if(vadd.getBtnBackAdd()==e.getSource()){
            vadd.setVisible(false);
            vmenu.setVisible(true);
        }else if (vadd.getBtnCloseAdd()==e.getSource()) {
            vadd.dispose();
        } else if(vlist.getBtnBackList()==e.getSource()){
            vlist.setVisible(false);
            vmenu.setVisible(true);
            
        }else if (vlist.getBtnCloseList()==e.getSource()) {
            vlist.dispose();
            
        }else if(vlist.getBtnExport()==e.getSource()){
            writter();
        }else if(vlist.getBtnImport()==e.getSource()){
            importPatients();
            insertInformation(employees);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int keycode = e.getKeyCode();
        
        if(keycode==KeyEvent.VK_ASTERISK){
            vadd.dispose();
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
    int keycode = e.getKeyCode();

            if(keycode==KeyEvent.VK_ASTERISK){
                vadd.dispose();
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
        
        
        
    
}
