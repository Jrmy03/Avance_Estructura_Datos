
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
public void encolar(NodoC x) {

        if (esVacia()) {

            this.setFrente(x);
        }
        {
            this.getUltimo().setAtras(x);
        }
        this.setUltimo(x);
    }                                                                 //Desencolar
    //-------------------------------------------------------------------------------------------------------------------------------------------//


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
    
