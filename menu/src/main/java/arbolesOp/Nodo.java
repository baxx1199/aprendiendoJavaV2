
package arbolesOp;


public class Nodo {
    
    
    private Nodo izq;
    private int dato;
    private Nodo der;

    public Nodo(int dato) {
        this.dato = dato;
        this.izq = this.der = null;
        
        
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    
    public Nodo getIzq() {
        return izq;
    }

   
    public Nodo getDer() {
        return der;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

   

    
  public void insertar(int newDato){
     
      if(newDato < this.dato){
          if(this.izq==null){
              this.izq= new Nodo(newDato);
          }else{
              this.izq.insertar(newDato);
          }
      }else{
          if(this.der==null){
              this.der= new Nodo(newDato);
          }else{
              this.der.insertar(newDato);
          }
      }
  }
    
}
