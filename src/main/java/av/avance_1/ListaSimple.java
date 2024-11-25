
package av.avance_1;


/**
 *
 * @author Usuario
 */
public class ListaSimple {
/*
    private NodoC cabeza;

    public ListaSimple() {
    }

    public NodoC getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoC cabeza) {
        this.cabeza = cabeza;
    }

    public void insertar(Paciente paciente) {
        if (cabeza == null) {  // Caso 1: La lista está vacía.
            //1.1 Crear el nodo.
            NodoC nuevoNodo = new NodoC();
            //1.2 Establecer el dato del nodo.
            nuevoNodo.setDatos(paciente);
            //1.3 Poner la cabeza a apuntar a este nuevo.
            cabeza = nuevoNodo;
        } else if (paciente.getNúmero_de_Cedula_del_Paciente() < cabeza.getDatos().getNúmero_de_Cedula_del_Paciente()) { // Caso 2: El id es menor a la cabeza.
            // 2.1 Crear el nodo.
            NodoC nuevoNodo = new NodoC();
            // 2.2 Establecer el dato del nodo.
            nuevoNodo.setDatos(paciente);
            // 2.3 Amarro el nuevo nodo al resto de la lista.
            nuevoNodo.setSiguiente(cabeza);
            // 2.4 Mover la cabeza al nuevo nodo que ahora es el primero.
            cabeza = nuevoNodo;

        } else if (cabeza.getSiguiente() == null) { // Caso 3. Si solo tiene un elemento.
            // 3.1 Crear el nodo.
            NodoC nuevoNodo = new NodoC();
            // 3.2 Establece el dato del nodo.
            nuevoNodo.setDatos(paciente);
            // 3.3 Amarrar el nuevo nodo a la derecha de la cabeza.
            cabeza.setSiguiente(nuevoNodo);
        } else { // No se cumple nada de lo que está arriba
            // Se debe recorrer la lista para buscar donde le corresponde al elemento
            // Se recorre con un ciclo.
            NodoC aux = cabeza;    // Creamos un puntero aux temporal y lo igualamos a la cabeza-
            while (aux.getSiguiente() != null
                    && aux.getSiguiente().getDatos().getNúmero_de_Cedula_del_Paciente() < paciente.getNúmero_de_Cedula_del_Paciente()) {
                // Mientras se de esa condicion (que no llego al final y que los elementos
                // siguen siendo menores al que deseo insertar-
                aux = aux.getSiguiente();
            }
            // El while sirve para encontrar la posicion donde deseo insertar el elemento.
            // 4.1 Crear el nodo.
            NodoC nuevoNodo = new NodoC();
            // 4.2 Establece el dato del nodo.
            nuevoNodo.setDatos(paciente);
            // 4.3 Amarrar el nuevo nodo a la lista.
            nuevoNodo.setSiguiente(aux.getSiguiente());
            // 4.4 Amarrar el que esta antes del nuevo nodo al nuevo nodo que estoy
            // incorporando a la lista.
            aux.setSiguiente(nuevoNodo);
        }
    }

    public String toString() {
        NodoC aux = cabeza;
        String buffer = "Lista: ";
        while (aux != null) {
            buffer += aux.getDatos() + " ";
            aux = aux.getSiguiente();
        }
        return buffer;
    }*/
}
