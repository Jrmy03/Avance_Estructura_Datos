
package av.avance_1;
/**
 * Clase NodoP que representa un nodo en una estructura de pila.
 * Almacena una queja y una referencia al nodo siguiente en la pila.
 * Utilizada como elemento básico en la implementación de una pila de quejas.
 * 
 * @author 
 * JOSE ALFREDO CHAVES BARBOZA
 * VEGA OREAMUNO BRANDON JOSHUE
 */

public class NodoP {
    private String quejas;
    private NodoP abajo;

    public NodoP() {
    }

    public String getQuejas() {
        return quejas;
    }

    public NodoP getAbajo() {
        return abajo;
    }

    public void setQuejas(String quejas) {
        this.quejas = quejas;
    }

    public void setAbajo(NodoP abajo) {
        this.abajo = abajo;
    }

   
  
    
}
