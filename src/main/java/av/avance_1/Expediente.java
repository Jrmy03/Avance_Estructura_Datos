package av.avance_1;

public class Expediente {
    
    String Cedula, Nombre, Edad, Genero;
    ListaSimpleCircular HistoricoDeCitas, HistoricoDeMedicamentos;

    public Expediente() {
    }

    public Expediente(String Cedula, String Nombre, String Edad, String Genero, ListaSimpleCircular HistoricoDeCitas, ListaSimpleCircular HistoricoDeMedicamentos) {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Genero = Genero;
        this.HistoricoDeCitas = HistoricoDeCitas;
        this.HistoricoDeMedicamentos = HistoricoDeMedicamentos;
    }

    public String getCedula() {
        return Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getEdad() {
        return Edad;
    }

    public String getGenero() {
        return Genero;
    }

    public ListaSimpleCircular getHistoricoDeCitas() {
        return HistoricoDeCitas;
    }

    public ListaSimpleCircular getHistoricoDeMedicamentos() {
        return HistoricoDeMedicamentos;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public void setHistoricoDeCitas(ListaSimpleCircular HistoricoDeCitas) {
        this.HistoricoDeCitas = HistoricoDeCitas;
    }

    public void setHistoricoDeMedicamentos(ListaSimpleCircular HistoricoDeMedicamentos) {
        this.HistoricoDeMedicamentos = HistoricoDeMedicamentos;
    }
    
    
    
}
