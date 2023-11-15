
package arbolesOp;

public class Binario {
    Nodo raiz;
    

    public Binario() {
       this.raiz = null;
       
        
    }
    
    public void insertarArbol(int dato){
        
        if (this.raiz == null) {
            this.raiz = new Nodo(dato);
        } else {
            this.raiz.insertar(dato);
        }
    }
    
    
    // Recorrer arbol
    
    public void ejecutarIn(){
        System.out.println("Recorrido inOrden ");
        
        inOrden(raiz);
        System.out.println("");
    }
    public void ejecutarPre(){
        System.out.println("Recorrido preOrden");
        
        preOrden(raiz);
        System.out.println("");
    }
    public void ejecutarPos(){
        System.out.println("Recorrido posOrden");
        
        posOrden(raiz);
        System.out.println("");
    }
    public void inOrden(Nodo b){
        if(b==null){
            return;
        }else{
            inOrden(b.getIzq());
            System.out.print(b.getDato()+ " - ");
            inOrden(b.getDer());
        }
    }
  
    public void preOrden(Nodo b){
        if(b==null){
            return;
        }else{
            System.out.print(b.getDato()+ " - ");
            preOrden(b.getIzq());            
            preOrden(b.getDer());
        }
    }
    public void posOrden(Nodo b){
        if(b==null){
            return;
        }else{
            posOrden(b.getIzq());
            posOrden(b.getDer());
            System.out.print(b.getDato() + " - ");
        }
    }
  
    public void buscar(Nodo aux, int datoB){
        
        
        if (aux==null) {
            System.out.println("Arbol vacio no se puede buscar");
            
        } else {
            if(datoB == aux.getDato()){
                System.out.println("Dato encontrado");
                
            }else 
            if(datoB<aux.getDato()){
                
               aux=aux.getIzq();
               
                buscar(aux, datoB);
                
            }else if(datoB > aux.getDato()){
                aux=aux.getDer();
                 buscar(aux, datoB);
            
                
            }else{
                System.out.println("Dato no encontrado");
            }
        }
        
        
    }
    public void ejecutarBusqueda(int dato){
        buscar(raiz, dato);
        
    }
    
    public void ejecutarEliminar(int datoE){
        this.raiz = eliminar(raiz, datoE);
    }
    
    public Nodo eliminar(Nodo a, int datoE){
        if(a!=null){//si el nodo no es nulo 
            if(datoE == a.getDato()){ //el valor a eliminar y el valor del nodo actual comprobara los siguientes casos
                if(a.getDer()==null && a.getIzq()==null){ // si el nodo no
                 a=null;
                }else{
                    if(a.getDer()!=null && a.getIzq()==null){
                        a = a.getDer();
                    }else if(a.getIzq()!=null && a.getDer()==null){
                        a = a.getIzq();
                    }else{
                        Nodo auxder = a.getDer();
                        Nodo aux = reemplazo(auxder);
                        
                        aux.setIzq(a.getIzq());
                        
                        return aux;
                    }
                    
                }
            }
                
            else{
                if(datoE<a.getDato()){
                    a.setIzq(eliminar(a.getIzq(), datoE));
                }else{
                     a.setDer(eliminar(a.getDer(), datoE));
                }
            }
            
        }else{ //el nodo es nulo o no se puede encontrar
            System.out.println("Dato no encontrado");  
            return a;
        }
        
        return a;
    }
    
    public Nodo reemplazo(Nodo a){
        //retornara el mayor de menores
        if(a.getIzq()!=null){
            a= reemplazo(a.getIzq());
        }
        return a;
    }
}