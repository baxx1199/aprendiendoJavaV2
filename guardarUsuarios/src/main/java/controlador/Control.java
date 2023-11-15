
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
import modelos.Usuario;
import vistas.VInicio;


public class Control implements ActionListener{
     private Usuario user;
    private VInicio vistaDeInicio;
    DefaultTableModel md ;

    public Control(Usuario user, VInicio vistaDeInicio){
        this.user = user;
        this.vistaDeInicio = vistaDeInicio;
       assignment();
    }
   
    public void assignment(){
        vistaDeInicio.getBtnAdd().addActionListener(this);
        vistaDeInicio.getBtnExport().addActionListener(this);
        
        vistaDeInicio.getBtnImport().addActionListener(this);
        vistaDeInicio.getBtnRemove().addActionListener(this);
        vistaDeInicio.getBtnEdit().addActionListener(this);
        vistaDeInicio.getBtnSave().addActionListener(this);
    }
    
    ArrayList<Usuario> usuarios = new ArrayList();
    
   
    public void agregar(){
           String newName =  vistaDeInicio.getTxtName().getText();
           String newlastName =  vistaDeInicio.getTxtLastname().getText();
           String correo = vistaDeInicio.getTxtEmail().getText();
           if(correo.charAt(0)>'9' && correo.contains("@")){
               usuarios.add(new Usuario(newName, newlastName, correo));
               limpiar();
               imprimirTabla(usuarios);
               
           }else{
               JOptionPane.showMessageDialog(vistaDeInicio, "Los datos ingresados son errones");
           }
           
    
    }
    public void imprimirTabla(ArrayList<Usuario> r){
        md = new DefaultTableModel(new String[]{"Nombre","Apellidos","Correo"},usuarios.size());
         vistaDeInicio.getTableUsers().setModel(md);
         
         TableModel model = vistaDeInicio.getTableUsers().getModel();
         
         for (int i = 0; i < r.size(); i++) {
             Usuario user = (Usuario) r.get(i);
             model.setValueAt(user.getName(), i, 0);
             model.setValueAt(user.getLastname(), i, 1);
             model.setValueAt(user.getEmail(), i, 2);

         }
        
    }
    public void guardar(){
        int num =vistaDeInicio.getTableUsers().getSelectedRow();
        
        String newName =  vistaDeInicio.getTxtName().getText();
           String newlastName =  vistaDeInicio.getTxtLastname().getText();
           String correo = vistaDeInicio.getTxtEmail().getText();
           
           
           if(correo.charAt(0)>'9' && correo.contains("@")){
               usuarios.get(num).setName(newName);
                usuarios.get(num).setLastname(newlastName);
                usuarios.get(num).setEmail(correo);
               limpiar();
               imprimirTabla(usuarios);
               
           }else{
               JOptionPane.showMessageDialog(vistaDeInicio, "Los datos ingresados son errones");
           }
           
        
    }
    public void editar(){
        int num =vistaDeInicio.getTableUsers().getSelectedRow();
        
        vistaDeInicio.getTxtName().setText(usuarios.get(num).getName());
        vistaDeInicio.getTxtLastname().setText(usuarios.get(num).getLastname());
        vistaDeInicio.getTxtEmail().setText(usuarios.get(num).getEmail());
        
        
    }
    public void eliminar(){
        int num =vistaDeInicio.getTableUsers().getSelectedRow();
        md.removeRow(num);
        usuarios.remove(num);
        
        
    }
    public void limpiar(){
    vistaDeInicio.getTxtName().setText("");
        vistaDeInicio.getTxtLastname().setText("");
        vistaDeInicio.getTxtEmail().setText("");
    }
    public void importar(){
        try {


            //lectura de datos
            FileReader fR = new FileReader("usuarios.txt");
            
            try (BufferedReader checkedPatients = new BufferedReader(fR)) {
                String ingres = new String();
                String usurioNameOlder;
                String usuariotLastNameOlder;
                String usuarioemail;
                
                while ((ingres=checkedPatients.readLine()) != null) {
                    
                    String[] olders = ingres.split(":");
                    usurioNameOlder = olders[0];
                    usuariotLastNameOlder = olders[1];
                    usuarioemail = olders[2];
                    
                    
                    Usuario p = new Usuario(usurioNameOlder,usuariotLastNameOlder, usuarioemail) ;
                    usuarios.add(p);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Upps... Algo a salido mal.");
        }

    }
    public void exportar(){
    PrintWriter listaUsuarios = null;
        try {
           
            listaUsuarios= new PrintWriter(new BufferedWriter(new FileWriter("usuarios.txt")));
            for (int i = 0; i < usuarios.size(); i++) {
                listaUsuarios.println(usuarios.get(i).getName() + ":" +usuarios.get(i).getLastname()+ ":" +usuarios.get(i).getEmail());
            }
            listaUsuarios.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Upps... Algo a salido mal.");
        } 
            listaUsuarios.close();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(vistaDeInicio.getBtnAdd()==e.getSource()){
            agregar();
        }else if(vistaDeInicio.getBtnEdit()==e.getSource()){
            editar();
        }else if (vistaDeInicio.getBtnSave()==e.getSource()) {
            guardar();
            
        }else if(vistaDeInicio.getBtnRemove()==e.getSource()){
            eliminar();
        }else if(vistaDeInicio.getBtnImport()==e.getSource()){
            importar();
            imprimirTabla(usuarios);
        }else if(vistaDeInicio.getBtnExport()==e.getSource()){
            exportar();
        }
        
    }
    
}
