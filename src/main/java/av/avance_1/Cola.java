/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package av.avance_1;

/**
 *
 * @author Usuario
 */
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
    }

    public boolean esVacia() {
        if (frente == null) {
            return true;
        } else {
            return false;
        }
    }

    public void encolar(String elemento) {
        NodoC aux = new NodoC();
        aux.setDato(elemento);
        if (esVacia()) {

            this.setFrente(aux);
        }
        else
        {
            this.getUltimo().setAtras(aux);
        }
        this.setUltimo(aux);
    }

    public void encolar(NodoC aux) {

        if (esVacia()) {

            this.setFrente(aux);
        }
        {
            this.getUltimo().setAtras(aux);
        }
        this.setUltimo(aux);
    }

    public NodoC antender() {
        NodoC aux = this.getFrente();
        if (frente != null) {
            frente = frente.getAtras();
            aux.setAtras(null);
        }
        return aux;

    }

    public String antenderStr() {
        NodoC aux = this.getFrente();
        if (frente != null) {
            frente = frente.getAtras();
            aux.setAtras(null);
        }
        if (aux != null)
            return aux.getDato();
        else
            return null;
    }

    public String toString() {
        String buffer = "";
        NodoC aux = frente;
        while (aux != null) {
            buffer = buffer + aux.getDato() + "\n";
            aux = aux.getAtras();
        }
        return buffer;
    }

}
