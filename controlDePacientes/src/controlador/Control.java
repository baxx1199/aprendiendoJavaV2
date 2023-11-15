
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.Paciente;
import vistas.InicioVista;
import vistas.VistaRegistro;


public class Control implements ActionListener{
    private Paciente paciente;
    private InicioVista vistaDeInicio;
    private VistaRegistro vistaDeRegistro;

    public Control(Paciente paciente, InicioVista vistaDeInicio, VistaRegistro vistaDeRegistro) {
        this.paciente = paciente;
        this.vistaDeInicio = vistaDeInicio;
        this.vistaDeRegistro = vistaDeRegistro;
        assignment();
    }
    
    //asignar evento botones
    public void assignment(){
        vistaDeInicio.getBtnInsert().addActionListener(this);
        vistaDeInicio.getBtnSearch().addActionListener(this);
        vistaDeRegistro.getBtnExit().addActionListener(this);
        vistaDeRegistro.getBtnExport().addActionListener(this);
        vistaDeInicio.getBtnImport().addActionListener(this);
        vistaDeRegistro.getBtnRemove().addActionListener(this);
    }
     
    //recolectar datos
    
    ArrayList<Paciente> pacientes = new ArrayList();
    
    public void gather(ArrayList r){
        String namePatient = vistaDeInicio.getTxtName().getText();
        String lastNamePatient = vistaDeInicio.getTxtLastName().getText();
        String symptompsPatient = vistaDeInicio.getTxtSymptomps().getText();
        
        pacientes.add(new Paciente(namePatient, lastNamePatient, symptompsPatient));
    }
    
    //insertar datos en tabla
    
    
     public void insertInformation(ArrayList r){
         DefaultTableModel md = new DefaultTableModel(new String[]{"Nombre","Apellidos","Sintomas"},pacientes.size());
         vistaDeRegistro.getTabPatients().setModel(md);
         
         TableModel model = vistaDeRegistro.getTabPatients().getModel();
         
         for (int i = 0; i < r.size(); i++) {
             Paciente pacient = (Paciente) r.get(i);
             model.setValueAt(pacient.getName(), i, 0);
             model.setValueAt(pacient.getLastName(), i, 1);
             model.setValueAt(pacient.getSymptomps(), i, 2);

         }
     }
     
     //eliminar paciente
     public void removePatient(ArrayList m){
        int removeIndex= vistaDeRegistro.getTabPatients().getSelectedRow();
        
        
        if (removeIndex >=0 ) {
            m.remove(removeIndex);
            insertInformation(m);
        }
    }
     
     //limpiar Campos de texto
     
     public void clean(){
         vistaDeInicio.getTxtName().setText("");
         vistaDeInicio.getTxtLastName().setText("");
         vistaDeInicio.getTxtSymptomps().setText("");
     }
    
    //Escribir en fichero 
     
     public void writter(){
    
        PrintWriter listPatients = null;
        try {
           
            listPatients = new PrintWriter(new BufferedWriter(new FileWriter("pacientes.txt")));
            for (int i = 0; i < pacientes.size(); i++) {
                listPatients.println(pacientes.get(i).getName() + "___" +pacientes.get(i).getLastName()+ "___" +pacientes.get(i).getSymptomps());
            }
            listPatients.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Upps... Algo a salido mal.");
        } 
            listPatients.close();
        
    }
     
     //Leer fichero
     
     public void importPatients( ) {

        try {


            //lectura de datos
            FileReader fR = new FileReader("pacientes.txt");
            
            try (BufferedReader checkedPatients = new BufferedReader(fR)) {
                String ingres = new String();
                String patientNameOlder;
                String patientLastNameOlder;
                String patientNameSymptompsOlder;
                
                while ((ingres=checkedPatients.readLine()) != null) {
                    
                    String[] olders = ingres.split("___");
                    patientNameOlder = olders[0];
                    patientLastNameOlder = olders[1];
                    patientNameSymptompsOlder = olders[2];
                    
                    
                    Paciente p = new Paciente(patientNameOlder, patientLastNameOlder, patientNameSymptompsOlder) ;
                    pacientes.add(p);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Upps... Algo a salido mal.");
        }
        
    }
    
     
    //reconocimiento de boton pulsado
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (vistaDeInicio.getBtnInsert()==e.getSource()) {
            gather(pacientes);
            System.out.println(pacientes);
            clean();
            
        }else if (vistaDeInicio.getBtnSearch()==e.getSource()) {
            
            insertInformation(pacientes);
            vistaDeRegistro.setVisible(true);
            vistaDeInicio.setVisible(false);
            
        }else if (vistaDeInicio.getBtnImport()==e.getSource()) {
            importPatients();
        }else if (vistaDeRegistro.getBtnExit()==e.getSource()) {
            
            vistaDeRegistro.dispose();
            vistaDeInicio.setVisible(true);
            
        }else if (vistaDeRegistro.getBtnExport()==e.getSource()) {
            
            writter();
            
        }else if (vistaDeRegistro.getBtnRemove()==e.getSource()) {
            removePatient(pacientes);
        }else if (vistaDeInicio.getBtnClose()==e.getSource()) {
           vistaDeInicio.dispose();
        }
    }
    
    
}
