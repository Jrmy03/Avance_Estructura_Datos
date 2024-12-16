
package av.avance_1;
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

    // Método para insertar una pregunta al final de la lista
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

    // Método para buscar una pregunta por su código
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

    // Método para mostrar todas las preguntas
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

    // Método para buscar la respuesta de una pregunta específica por su código
    public String buscarRespuesta(String codigo) {
        Pregunta pregunta = buscarPregunta(codigo);

        if (pregunta != null) {
            return pregunta.getRespuesta();
        }

        return null; // No se encontró la pregunta
    }
    }