
package av.avance_1;


/**
 * Clase que representa un nodo de una lista circular simple, 
 * utilizado para almacenar información de citas médicas.
 * 
 * Cada nodo contiene los datos de una cita, incluyendo la fecha, 
 * el doctor, el diagnóstico, y una referencia al siguiente nodo de la lista.
 * 
 * @author Jeremy Emmanuel Lorente Cerdas
 * @author Antonio Jesus Lopez Chacon

 */
public class NodoCita {

    private String fecha;      
    private String doctor;      
    private String diagnostico; 
    private NodoCita siguiente; 

    /**
     * Constructor que inicializa un nodo con los datos de la cita.
     *
     * @param fecha       Fecha de la cita.
     * @param doctor      Nombre del doctor encargado de la cita.
     * @param diagnostico Diagnóstico realizado en la cita.
     */
    public NodoCita(String fecha, String doctor, String diagnostico) {
        this.fecha = fecha;
        this.doctor = doctor;
        this.diagnostico = diagnostico;
        this.siguiente = null;
    }

    /**
     * Obtiene la fecha de la cita.
     *
     * @return La fecha de la cita.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Obtiene el nombre del doctor que atiende la cita.
     *
     * @return El nombre del doctor.
     */
    public String getDoctor() {
        return doctor;
    }

    /**
     * Obtiene el diagnóstico asociado a la cita.
     *
     * @return El diagnóstico de la cita.
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * Obtiene el nodo siguiente en la lista circular.
     *
     * @return El nodo siguiente.
     */
    public NodoCita getSiguiente() {
        return siguiente;
    }

    /**
     * Establece el nodo siguiente en la lista circular.
     *
     * @param siguiente Nodo que será el siguiente en la lista.
     */
    public void setSiguiente(NodoCita siguiente) {
        this.siguiente = siguiente;
    }
}