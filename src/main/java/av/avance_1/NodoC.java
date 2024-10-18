package av.avance_1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class NodoC {
    
    private String dato;
    private NodoC atras;

    public NodoC() {
    }

    public String getDato() {
        return dato;
    }

    public NodoC getAtras() {
        return atras;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public void setAtras(NodoC atras) {
        this.atras = atras;
    }

    @Override
    public String toString() {
        return "NodoC{" + "dato=" + dato + ", atras=" + atras + '}';
    }
    
    
}
