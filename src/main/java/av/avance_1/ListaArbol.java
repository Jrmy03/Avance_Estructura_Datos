package av.avance_1;

/**
 * Clase que implementa una lista enlazada para gestionar preguntas y
 * respuestas. Proporciona funcionalidades para insertar, buscar y mostrar
 * preguntas en la lista.
 *
 * @author Jeremy Emmanuel Lorente Cerdas
 * @author Antonio Jesus Lopez Chacon
 */
public class ListaArbol {

    // Nodo interno para la lista
    private class NodoC {

        private Pregunta pregunta;
        private NodoC siguiente;

        public NodoC(Pregunta pregunta) {
            this.pregunta = pregunta;
            this.siguiente = null;
        }

        public Pregunta getPregunta() {
            return pregunta;
        }

        public NodoC getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoC siguiente) {
            this.siguiente = siguiente;
        }
    }

    private NodoC cabeza; // Nodo inicial de la lista

    public ListaArbol() {
        this.cabeza = null;
    }

    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }

    /**
     * Inserta una nueva pregunta al final de la lista.
     *
     * @param pregunta Objeto Pregunta a añadir a la lista.
     */
    public void insertar(Pregunta pregunta) {
        NodoC nuevoNodo = new NodoC(pregunta);

        if (estaVacia()) {
            cabeza = nuevoNodo; // Si está vacía, el nuevo nodo será la cabeza
        } else {
            NodoC actual = cabeza;
            while (actual.getSiguiente() != null) { // Recorrer hasta el último nodo
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo); // Insertar al final
        }
    }

    /**
     * Busca una pregunta en la lista basada en su código.
     *
     * @param codigo Código de la pregunta a buscar.
     * @return Objeto Pregunta encontrado o null si no existe.
     */
    public Pregunta buscarPregunta(String codigo) {
        NodoC actual = cabeza;

        while (actual != null) {
            if (actual.getPregunta().getCodigo().equals(codigo)) {
                return actual.getPregunta(); // Retorna la pregunta si coincide el código
            }
            actual = actual.getSiguiente();
        }

        return null; // No se encontró la pregunta
    }

    /**
     * Muestra todas las preguntas almacenadas en la lista. Si la lista está
     * vacía, informa al usuario.
     */
    public void mostrarPreguntas() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }

        NodoC actual = cabeza;
        while (actual != null) {
            Pregunta pregunta = actual.getPregunta();
            System.out.println(pregunta.getCodigo() + ". " + pregunta.getPregunta());
            actual = actual.getSiguiente();
        }
    }

    /**
     * Busca la respuesta asociada a una pregunta específica basada en su
     * código.
     *
     * @param codigo Código de la pregunta cuya respuesta se desea obtener.
     * @return Respuesta de la pregunta o null si no se encuentra la pregunta.
     */
    public String buscarRespuesta(String codigo) {
        Pregunta pregunta = buscarPregunta(codigo);

        if (pregunta != null) {
            return pregunta.getRespuesta();
        }

        return null; // No se encontró la pregunta
    }
}
