package av.avance_1;

/**
 * Clase genérica que implementa una lista simple circular.
 * Se utiliza para manejar nodos de tipo NodoCita o NodoMedicamento.
 * La lista admite operaciones de agregar y mostrar elementos.
 *
 * @param <T> Tipo genérico de nodo que será almacenado en la lista (NodoCita o NodoMedicamento).
 * @author Jeremy Emmanuel Lorente Cerdas
 * @author  Antonio Jesus Lopez Chacon
 
 */
public class ListaSimpleCircular<T> {

    private T inicio; // Nodo inicial de la lista circular.

    /**
     * Constructor que inicializa la lista como vacía.
     */
    public ListaSimpleCircular() {
        this.inicio = null;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista no contiene elementos, false en caso contrario.
     */
    public boolean esVacia() {
        return inicio == null;
    }

    /**
     * Agrega un nuevo nodo a la lista. El nodo puede ser de tipo NodoCita o NodoMedicamento.
     *
     * @param nuevoNodo El nodo a agregar a la lista.
     */
    public void agregar(T nuevoNodo) {
        if (esVacia()) {
            inicio = nuevoNodo;
            if (nuevoNodo instanceof NodoCita) {
                ((NodoCita) nuevoNodo).setSiguiente((NodoCita) inicio);
            } else if (nuevoNodo instanceof NodoMedicamento) {
                ((NodoMedicamento) nuevoNodo).setSiguiente((NodoMedicamento) inicio);
            }
        } else {
            if (nuevoNodo instanceof NodoCita) {
                NodoCita actual = (NodoCita) inicio;
                while (actual.getSiguiente() != inicio) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente((NodoCita) nuevoNodo);
                ((NodoCita) nuevoNodo).setSiguiente((NodoCita) inicio);
            } else if (nuevoNodo instanceof NodoMedicamento) {
                NodoMedicamento actual = (NodoMedicamento) inicio;
                while (actual.getSiguiente() != inicio) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente((NodoMedicamento) nuevoNodo);
                ((NodoMedicamento) nuevoNodo).setSiguiente((NodoMedicamento) inicio);
            }
        }
    }

    /**
     * Muestra el contenido de la lista circular.
     * Si el nodo inicial es de tipo NodoCita, muestra las citas con su fecha, doctor y diagnóstico.
     * Si el nodo inicial es de tipo NodoMedicamento, muestra la fecha de prescripción y el medicamento.
     */
    public void mostrar() {
        if (!esVacia()) {
            if (inicio instanceof NodoCita) {
                NodoCita actual = (NodoCita) inicio;
                do {
                    System.out.println("Fecha: " + actual.getFecha() +
                                       ", Doctor: " + actual.getDoctor() +
                                       ", Diagnóstico: " + actual.getDiagnostico() + "\n");
                    actual = actual.getSiguiente();
                } while (actual != inicio);
            } else if (inicio instanceof NodoMedicamento) {
                NodoMedicamento actual = (NodoMedicamento) inicio;
                do {
                    System.out.println("Fecha de prescripción: " + actual.getFechaPrescripcion() +
                                       ", Medicamento: " + actual.getMedicamento() + "\n");
                    actual = actual.getSiguiente();
                } while (actual != inicio);
            }
        } else {
            System.out.println("La lista está vacía.\n");
        }
    }
}