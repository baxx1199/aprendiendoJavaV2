
import com.mycompany.ejercicio02.Employee;
import java.util.ArrayList;
import java.util.Iterator;



public class Main {

    
    public static void main(String[] args) {
        
        ArrayList <Employee> employeeList = new ArrayList<>();
        
        
        Employee employee1 = new Employee(0001, "baxx", "aux");
        employeeList.add(employee1);
        
        
        Employee employee2 = new Employee(0002, "julian", "dev");
        employeeList.add(employee2);
        
        
        Iterator i = employeeList.iterator();
        
        while (i.hasNext()) {
            Employee next =(Employee)i.next();
            System.out.println(next.toString());
            
        }
    }
    
}
