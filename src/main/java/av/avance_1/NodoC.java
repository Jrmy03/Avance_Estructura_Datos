package av.avance_1;


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
