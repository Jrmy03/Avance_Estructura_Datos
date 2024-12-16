package av.avance_1;

public class NodoExpediente {

    Expediente Datos;
    NodoExpediente Siguiente, Anterior;

    public NodoExpediente() {
    }

    public NodoExpediente(Expediente Datos) {
        this.Datos = Datos;
        this.Siguiente = null;
        this.Anterior = null;
    }

    public Expediente getDatos() {
        return Datos;
    }

    public NodoExpediente getSiguiente() {
        return Siguiente;
    }

    public NodoExpediente getAnterior() {
        return Anterior;
    }

    public void setDatos(Expediente Datos) {
        this.Datos = Datos;
    }

    public void setSiguiente(NodoExpediente Siguiente) {
        this.Siguiente = Siguiente;
    }

    public void setAnterior(NodoExpediente Anterior) {
        this.Anterior = Anterior;
    }

}
