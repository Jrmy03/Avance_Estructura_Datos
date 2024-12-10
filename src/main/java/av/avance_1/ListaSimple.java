
package av.avance_1;


/**
 *
 * @author Usuario
 */
public class ListaSimple {

    private NodoC cabeza;

    public ListaSimple() {
        this.cabeza = null;
    }

    public NodoC getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoC cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * Inserta un paciente en la lista de forma ordenada por su número de cédula.
     *
     * @param paciente El paciente a insertar.
     */
    public void insertar(Paciente paciente) {
        int cedulaPaciente = convertirStringAEntero(paciente.getNúmero_de_Cedula_del_Paciente());

        if (cedulaPaciente == -1) {
            System.out.println("No se puede insertar el paciente debido a un error en su número de cédula.");
            return;
        }

        // Caso 1: La lista está vacía
        if (cabeza == null) {
            NodoC nuevoNodo = new NodoC();
            nuevoNodo.setDatos(paciente);
            cabeza = nuevoNodo;
            return;
        }

        // Caso 2: Insertar antes de la cabeza
        int cedulaCabeza = convertirStringAEntero(cabeza.getDatos().getNúmero_de_Cedula_del_Paciente());
        if (cedulaPaciente < cedulaCabeza) {
            NodoC nuevoNodo = new NodoC();
            nuevoNodo.setDatos(paciente);
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
            return;
        }

        // Caso 3: Recorrer la lista para insertar en la posición correcta
        NodoC aux = cabeza;
        while (aux.getSiguiente() != null &&
               convertirStringAEntero(aux.getSiguiente().getDatos().getNúmero_de_Cedula_del_Paciente()) < cedulaPaciente) {
            aux = aux.getSiguiente();
        }

        // Insertar el nuevo nodo en la posición encontrada
        NodoC nuevoNodo = new NodoC();
        nuevoNodo.setDatos(paciente);
        nuevoNodo.setSiguiente(aux.getSiguiente());
        aux.setSiguiente(nuevoNodo);
    }

   

    /**
     * Convierte una cadena de texto a un entero.
     *
     * @param numero La cadena de texto que representa un número.
     * @return El número convertido o -1 si hay un error.
     */
    private int convertirStringAEntero(String numero) {
        try {
            return Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            System.out.println("Error: La cadena no es un número válido. Valor: " + numero);
            return -1; // Valor especial para indicar error
        }
    }
}