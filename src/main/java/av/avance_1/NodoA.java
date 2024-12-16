
package av.avance_1;

import java.util.Scanner;

/**
 * Clase que representa un nodo de un árbol con identificador, nombre,
 * una lista de preguntas y referencias a los hijos izquierdo y derecho.
 * @author Jeremy Emmanuel Lorente Cerdas
 */


public class NodoA {

    private String identificador;
    private String nombre;
    private ListaArbol listaPreguntas;
    private NodoA hijoIzq;
    private NodoA hijoDer;
    private String Codigo;
    
/**
     * Constructor de la clase NodoA.
     * @author Jeremy Emmanuel Lorente Cerdas
     * @param identificador Identificador único del nodo.
     * @param nombre Nombre asociado al nodo.
     */
    public NodoA(String identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public ListaArbol getListaPreguntas() {
        return listaPreguntas;
    }

    public NodoA getHijoIzq() {
        return hijoIzq;
    }

    public NodoA getHijoDer() {
        return hijoDer;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListaPreguntas(ListaArbol listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    public void setHijoIzq(NodoA hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public void setHijoDer(NodoA hijoDer) {
        this.hijoDer = hijoDer;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

   

}
