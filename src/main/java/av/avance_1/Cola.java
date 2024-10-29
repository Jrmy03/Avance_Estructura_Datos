package av.avance_1;
/**
 * Clase Cola que representa una estructura de datos FIFO (First In, First Out) utilizando nodos.
 * Proporciona métodos para encolar, desencolar y verificar el estado de la cola.
 * @autor JOSE ALFREDO CHAVES BARBOZA
 *  @autor VEGA OREAMUNO BRANDON JOSHUE
 */
public class Cola {

    private NodoC frente;
    private NodoC ultimo;
 /**
     * Constructor de la clase Cola.
     */
    public Cola() {
    }
/**
     * Obtiene el nodo en el frente de la cola.
     * @author JOSE ALFREDO CHAVES BARBOZA
     * @autor VEGA OREAMUNO BRANDON JOSHUE
     * @return NodoC El nodo que se encuentra en el frente de la cola.
     */
    public NodoC getFrente() {
        return frente;
    }
/**
     * Obtiene el nodo al final de la cola (último en ser encolado).
     * @autor JOSE ALFREDO CHAVES BARBOZA
     * @autor VEGA OREAMUNO BRANDON JOSHUE
     * @return NodoC El nodo que se encuentra al final de la cola.
     */
    public NodoC getUltimo() {
        return ultimo;
    }
 /**
     * Establece el nodo que estará al frente de la cola.
     * @autor JOSE ALFREDO CHAVES BARBOZA
     * @autor VEGA OREAMUNO BRANDON JOSHUE
     * @param frente El nodo que se desea establecer como frente de la cola.
     */
    public void setFrente(NodoC frente) {
        this.frente = frente;
    }
/**
     * Establece el nodo que estará al final de la cola.
     * @autor JOSE ALFREDO CHAVES BARBOZA
     * @autor VEGA OREAMUNO BRANDON JOSHUE
     * @param ultimo El nodo que se desea establecer como el último de la cola.
     */
    public void setUltimo(NodoC ultimo) {
        this.ultimo = ultimo;
    }                                                               
   /**
     * Verifica si la cola está vacía.
     * @autor JOSE ALFREDO CHAVES BARBOZA
     * @autor VEGA OREAMUNO BRANDON JOSHUE
     * @return boolean true si la cola está vacía, false en caso contrario.
     */

    public boolean esVacia() {
        if (frente == null) {
            return true;
        } else {
            return false;
        }
    }                                                                    
    /**
     * Encola un nuevo nodo al final de la cola.
     * @autor JOSE ALFREDO CHAVES BARBOZA
     * @autor VEGA OREAMUNO BRANDON JOSHUE
     * @param nuevoNodo El nodo que se desea encolar.
     */

     public void encolar(NodoC nuevoNodo) {
        if (esVacia()) {
            frente = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setAtras(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }                                                    
/**
     * Desencola el nodo que se encuentra en el frente de la cola.
     * @autor JOSE ALFREDO CHAVES BARBOZA
     * @autor VEGA OREAMUNO BRANDON JOSHUE
     * @return NodoC El nodo que estaba en el frente de la cola, o null si la cola está vacía.
     */

    public NodoC desencolar() {
        if (esVacia()) {
            return null;
            
        }

        NodoC nodo = frente;
        frente = frente.getAtras();

        if (frente == null) {
            ultimo = null;
        }

        nodo.setAtras(null); 
        return nodo;
    }
    /**
     * Muestra el nodo que se encuentra en el frente de la cola sin desencolarlo.
     * @autor JOSE ALFREDO CHAVES BARBOZA
     * @autor VEGA OREAMUNO BRANDON JOSHUE
     * @return NodoC El nodo que está en el frente de la cola.
     */
    public NodoC verFrente() {
        return frente;
    }


}