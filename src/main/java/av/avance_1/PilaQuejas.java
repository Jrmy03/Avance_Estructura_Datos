package av.avance_1;

public class PilaQuejas extends Pila {

    public PilaQuejas() {
    }

    public void listarQuejas() {
        listarQuejasRecursivo(getTop());
    }
// Con el metodo recursivo imprimirá cada queja en la pila sin modificarla
    private void listarQuejasRecursivo(NodoP nodo) {

        if (nodo != null) {
            System.out.println(nodo.getQuejas());
            listarQuejasRecursivo(nodo.getAbajo());
        }

    }
}
