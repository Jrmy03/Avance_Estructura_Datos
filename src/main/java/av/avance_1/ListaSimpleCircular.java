
package av.avance_1;


public class ListaSimpleCircular<T> {
    private T inicio;

    public ListaSimpleCircular() {
        this.inicio = null;
    }

    public boolean esVacia() {
        return inicio == null;
    }

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

    public void mostrar() {
        if (!esVacia()) {
            if (inicio instanceof NodoCita) {
                NodoCita actual = (NodoCita) inicio;
                do {
                    System.out.println("Fecha: " + actual.getFecha() +
                                       ", Doctor: " + actual.getDoctor() +
                                       ", Diagnóstico: " + actual.getDiagnostico()+"\n");
                    actual = actual.getSiguiente();
                } while (actual != inicio);
            } else if (inicio instanceof NodoMedicamento) {
                NodoMedicamento actual = (NodoMedicamento) inicio;
                do {
                    System.out.println("Fecha de prescripción: " + actual.getFechaPrescripcion() +
                                       ", Medicamento: " + actual.getMedicamento()+"\n");
                    actual = actual.getSiguiente();
                } while (actual != inicio);
            }
        } else {
            System.out.println("La lista está vacía.\n");
        }
    }
}



