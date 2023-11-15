
package pacientes;

import controlador.Control;
import models.Paciente;
import vistas.InicioVista;
import vistas.VistaRegistro;


public class Pacientes {

    
    public static void main(String[] args) {
        Paciente patient = new Paciente();
        InicioVista initiation =new InicioVista();
        VistaRegistro register = new VistaRegistro();
        
        Control control = new Control(patient, initiation, register);
        
        initiation.setVisible(true);
    }
    
}
