
package av.avance_1;


public class NodoCita {
    private String fecha;
    private String doctor;
    private String diagnostico;
    private NodoCita siguiente;

    public NodoCita(String fecha, String doctor, String diagnostico) {
        this.fecha = fecha;
        this.doctor = doctor;
        this.diagnostico = diagnostico;
        this.siguiente = null;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public NodoCita getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCita siguiente) {
        this.siguiente = siguiente;
    }
}