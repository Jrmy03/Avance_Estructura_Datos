package av.avance_1;


public class NodoMedicamento {
    private String fechaPrescripcion;
    private String medicamento;
    private NodoMedicamento siguiente;

    public NodoMedicamento(String fechaPrescripcion, String medicamento) {
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