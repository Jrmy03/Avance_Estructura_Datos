package av.avance_1;

public class Cola {

    private NodoC frente;
    private NodoC ultimo;

    public Cola() {
    }

    public NodoC getFrente() {
        return frente;
    }

    public NodoC getUltimo() {
        return ultimo;
    }

    public void setFrente(NodoC frente) {
        this.frente = frente;
    }

    public void setUltimo(NodoC ultimo) {
        this.ultimo = ultimo;
    }                                                               //Métodos Miscelaneos
    //-------------------------------------------------------------------------------------------------------------------------------------------//

    public boolean esVacia() {
        if (frente == null) {
            return true;
        } else {
            return false;
        }
    }                                                                    //Encolar
    //-------------------------------------------------------------------------------------------------------------------------------------------//

     public void encolar(NodoC nuevoNodo) {
        if (esVacia()) {
            frente = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setAtras(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }                                                      //Desencolar

//-------------------------------------------------------------------------------------------------------------------------------------------//
    public NodoC desencolar() {
        if (esVacia()) {
            return null;
        }

        NodoC nodo = frente;
        frente = frente.getAtras();

        if (frente == null) {
            ultimo = null;
        }

        nodo.setAtras(null); 
        return nodo;
    }
    public NodoC verFrente() {
        return frente;
    }


}