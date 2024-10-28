package av.avance_1;

public class PilaQuejas extends Pila {

    public PilaQuejas() {
    }

    public void listarQuejas() {
        NodoP aux = getTop();
        if (aux == null) {
            System.out.println("No hay quejas registradas.");
        } else {
            while (aux != null) {
                System.out.println(aux.getQuejas());
                aux = aux.getAbajo();
            }
        }
    }
}
