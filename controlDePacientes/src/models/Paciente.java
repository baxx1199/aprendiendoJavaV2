
package models;



public class Paciente {
    private String name, lastName, symptomps;
   

    public Paciente(String name, String lastName, String symptomps) {
        this.name = name;
        this.lastName = lastName;
        this.symptomps = symptomps;
        
    }

  
    public Paciente() {
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

    public String getSymptomps() {
        return symptomps;
    }

    public void setSymptomps(String symptomps) {
        this.symptomps = symptomps;
    }

   
   
    
    
           
}
