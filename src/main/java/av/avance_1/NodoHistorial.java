package av.avance_1;



    
public class NodoHistorial {
    private String fechaPrescripcion;
    private String medicamento;
    private NodoMedicamento siguiente;

    public NodoHistorial(String fechaPrescripcion, String medicamento) {
        this.fechaPrescripcion = fechaPrescripcion;
        this.medicamento = medicamento;
        this.siguiente = null;
    }

    public String getFechaPrescripcion() {
        return fechaPrescripcion;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public NodoMedicamento getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoMedicamento siguiente) {
        this.siguiente = siguiente;
    }
}