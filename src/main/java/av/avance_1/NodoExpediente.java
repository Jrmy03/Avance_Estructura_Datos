package av.avance_1;

/**
 * Clase que representa un nodo de una lista doblemente enlazada circular,
 * utilizada para almacenar expedientes de pacientes.
 * 
 * Cada nodo contiene un expediente y referencias al nodo siguiente y anterior.
 * 
* @author Jeremy Emmanuel Lorente Cerdas
 * @author Antonio Jesus Lopez Chacon
 */
public class NodoExpediente {

    private Expediente Datos;        
    private NodoExpediente Siguiente;
    private NodoExpediente Anterior; 

    /**
     * Constructor vacío de NodoExpediente.
     */
    public NodoExpediente() {
    }

    /**
     * Constructor que inicializa un nodo con los datos de un expediente.
     * 
     * @param Datos Objeto Expediente que contiene la información del paciente.
     */
    public NodoExpediente(Expediente Datos) {
        this.Datos = Datos;
        this.Siguiente = null;
        this.Anterior = null;
    }

    /**
     * Obtiene los datos del expediente almacenado en el nodo.
     * 
     * @return Los datos del expediente.
     */
    public Expediente getDatos() {
        return Datos;
    }

    /**
     * Obtiene el nodo siguiente en la lista.
     * 
     * @return El nodo siguiente.
     */
    public NodoExpediente getSiguiente() {
        return Siguiente;
    }

    /**
     * Obtiene el nodo anterior en la lista.
     * 
     * @return El nodo anterior.
     */
    public NodoExpediente getAnterior() {
        return Anterior;
    }

    /**
     * Establece los datos del expediente almacenado en el nodo.
     * 
     * @param Datos El objeto Expediente que se almacenará en el nodo.
     */
    public void setDatos(Expediente Datos) {
        this.Datos = Datos;
    }

    /**
     * Establece el nodo siguiente en la lista.
     * 
     * @param Siguiente Nodo que será el siguiente en la lista.
     */
    public void setSiguiente(NodoExpediente Siguiente) {
        this.Siguiente = Siguiente;
    }

    /**
     * Establece el nodo anterior en la lista.
     * 
     * @param Anterior Nodo que será el anterior en la lista.
     */
    public void setAnterior(NodoExpediente Anterior) {
        this.Anterior = Anterior;
    }
}