package av.avance_1;

/**
 * Clase NodoC que representa un nodo en una estructura de cola.
 * Almacena datos específicos del paciente y una referencia al siguiente nodo en la cola.
 * Utilizada como elemento básico en la implementación de una cola.
 * 
 * @autor JOSE ALFREDO CHAVES BARBOZA
 * @autor VEGA OREAMUNO BRANDON JOSHUE
 */
public class NodoC {
    
    private Paciente datos;
    private NodoC atras;

    public NodoC() {
    }

    public Paciente getDatos() {
        return datos;
    }

    public NodoC getAtras() {
        return atras;
    }

    public void setDatos(Paciente datos) {
        this.datos = datos;
    }

    public void setAtras(NodoC atras) {
        this.atras = atras;
    }                                                    //Override
    //------------------------------------------------------------------------------------------------------------------------//

    @Override
    public String toString() {
        return "NodoC{" + "dato=" + datos + ", atras=" + atras + '}';
    }
    
    
}
