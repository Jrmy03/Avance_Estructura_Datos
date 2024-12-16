package av.avance_1;


/**
 * Clase NodoC que representa un nodo en una estructura de cola. Almacena datos
 * específicos del paciente y una referencia al siguiente nodo en la cola.
 * Utilizada como elemento básico en la implementación de una cola.
 *
 * @autor JOSE ALFREDO CHAVES BARBOZA
 * @autor VEGA OREAMUNO BRANDON JOSHUE
 */
public class NodoC {

    private Paciente datos;
    private NodoC atras;
    private NodoC siguiente;
    private ListaSimple historicoCitas;
    
     private ListaSimple historicoMedicamentos;

    public NodoC() {
    }

    public NodoC(Paciente datos) {
        this.datos = datos;
        this.atras = atras;
        this.siguiente = siguiente;
        this.historicoCitas = historicoCitas;
        this.historicoMedicamentos = historicoMedicamentos;
    }

    public Paciente getDatos() {
        return datos;
    }

    public NodoC getAtras() {
        return atras;
    }

    public NodoC getSiguiente() {
        return siguiente;
    }

    public ListaSimple getHistoricoCitas() {
        return historicoCitas;
    }

    public ListaSimple getHistoricoMedicamentos() {
        return historicoMedicamentos;
    }

    public void setDatos(Paciente datos) {
        this.datos = datos;
    }

    public void setAtras(NodoC atras) {
        this.atras = atras;
    }

    public void setSiguiente(NodoC siguiente) {
        this.siguiente = siguiente;
    }

    public void setHistoricoCitas(ListaSimple historicoCitas) {
        this.historicoCitas = historicoCitas;
    }

    public void setHistoricoMedicamentos(ListaSimple historicoMedicamentos) {
        this.historicoMedicamentos = historicoMedicamentos;
    }

   
    @Override
    public String toString() {
        return "NodoC{" + "datos=" + datos + ", atras=" + atras + ", siguiente=" + siguiente + '}';
    }

}                                                    


