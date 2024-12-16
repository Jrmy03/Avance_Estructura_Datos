package av.avance_1;


/**
 * Clase que representa un nodo en una lista simple para almacenar información
 * de medicamentos.
 * 
 * Cada nodo contiene información de un medicamento y una referencia
 * al siguiente nodo en la lista.
 * 
 * Esta clase se utiliza como base para almacenar prescripciones médicas.
 * 
* @author Jeremy Emmanuel Lorente Cerdas
 * @author Antonio Jesus Lopez Chacon
 
 */
public class NodoMedicamento {

    private String fechaPrescripcion; 
    private String medicamento;       
    private NodoMedicamento siguiente; 

    /**
     * Constructor que inicializa un nodo con los datos de un medicamento.
     * 
     * @param fechaPrescripcion Fecha de prescripción del medicamento.
     * @param medicamento       Nombre del medicamento prescrito.
     */
    public NodoMedicamento(String fechaPrescripcion, String medicamento) {
        this.fechaPrescripcion = fechaPrescripcion;
        this.medicamento = medicamento;
        this.siguiente = null;
    }

    /**
     * Obtiene la fecha de prescripción del medicamento.
     * 
     * @return La fecha de prescripción.
     */
    public String getFechaPrescripcion() {
        return fechaPrescripcion;
    }

    /**
     * Obtiene el nombre del medicamento prescrito.
     * 
     * @return El nombre del medicamento.
     */
    public String getMedicamento() {
        return medicamento;
    }

    /**
     * Obtiene el nodo siguiente en la lista.
     * 
     * @return El nodo siguiente.
     */
    public NodoMedicamento getSiguiente() {
        return siguiente;
    }

    /**
     * Establece el nodo siguiente en la lista.
     * 
     * @param siguiente Nodo que será el siguiente en la lista.
     */
    public void setSiguiente(NodoMedicamento siguiente) {
        this.siguiente = siguiente;
    }
}