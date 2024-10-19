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

    public void encolar(NodoC paciente) {

        if (esVacia()) {

            this.setFrente(paciente);
        }
        {
            this.getUltimo().setAtras(paciente);
        }
        this.setUltimo(paciente);
    }                                                                 //Desencolar

//-------------------------------------------------------------------------------------------------------------------------------------------//
    public NodoC desencolar() {
        if (esVacia()) { // Mesaje y devolvemos porque la cola esta vacía
            return null;
        }
        NodoC aux = this.getFrente(); // almacenar temporalmente el nodo, ya que es el que descolaremos
        this.setFrente(this.getFrente().getAtras()); // se mueve el puntero atras
        // si descoloamos y queda vacio el frente, se actualiza el ultimo nodo a null
        if (this.getFrente() == null) {
            this.setUltimo(null); // Como en el encolar, eliminamos eliminamos la referencia hacial el otro nodo
        }
        // retornamos el nodo que estaba al frente
        aux.setAtras(null);
        return aux;
    }

}

/*
    public NodoC antender(NodoC aux) {
       
        if (frente != null) {
            frente = frente.getAtras();
            aux.setAtras(null);
        }
        return aux;

    }

    public Paciente antenderStr() {
        NodoC aux = this.getFrente();
        if (frente != null) {
            frente = frente.getAtras(); 
            aux.setAtras(null);
        }
        if (aux != null)
            return aux.getDatos();
        else
            return null;
    }

    public String toString() {
        String buffer = "";
        NodoC aux = frente;
        while (aux != null) {
            buffer = buffer + aux.getDatos() + "\n";
            aux = aux.getAtras();
        }
        return buffer;*/
