package av.avance_1;

/**
 * Clase que representa un expediente médico de un paciente.
 *
 * Un expediente contiene información personal del paciente, como su cédula,
 * nombre, edad y género, así como listas circulares simples que registran el
 * historial de citas y medicamentos asociados.
 *
* @author Jeremy Emmanuel Lorente Cerdas
 * @author Antonio Jesus Lopez Chacon
 */
public class Expediente {

    private String Cedula;                    
    private String Nombre;                    
    private String Edad;                       
    private String Genero;                    
    private ListaSimpleCircular HistoricoDeCitas;         
    private ListaSimpleCircular HistoricoDeMedicamentos; 

    /**
     * Constructor vacío de la clase Expediente.
     */
    public Expediente() {
    }

    /**
     * Constructor que inicializa un expediente con datos personales e
     * históricos.
     *
     * @param Cedula Número de cédula del paciente.
     * @param Nombre Nombre completo del paciente.
     * @param Edad Edad del paciente.
     * @param Genero Género del paciente.
     * @param HistoricoDeCitas Lista circular de citas médicas del paciente.
     * @param HistoricoDeMedicamentos Lista circular de medicamentos prescritos
     * al paciente.
     */
    public Expediente(String Cedula, String Nombre, String Edad, String Genero,
            ListaSimpleCircular HistoricoDeCitas,
            ListaSimpleCircular HistoricoDeMedicamentos) {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Genero = Genero;
        this.HistoricoDeCitas = HistoricoDeCitas;
        this.HistoricoDeMedicamentos = HistoricoDeMedicamentos;
    }

    /**
     * Obtiene la cédula del paciente.
     *
     * @return La cédula del paciente.
     */
    public String getCedula() {
        return Cedula;
    }

    /**
     * Obtiene el nombre del paciente.
     *
     * @return El nombre del paciente.
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Obtiene la edad del paciente.
     *
     * @return La edad del paciente.
     */
    public String getEdad() {
        return Edad;
    }

    /**
     * Obtiene el género del paciente.
     *
     * @return El género del paciente.
     */
    public String getGenero() {
        return Genero;
    }

    /**
     * Obtiene el historial de citas médicas del paciente.
     *
     * @return La lista circular con las citas médicas del paciente.
     */
    public ListaSimpleCircular getHistoricoDeCitas() {
        return HistoricoDeCitas;
    }

    /**
     * Obtiene el historial de medicamentos del paciente.
     *
     * @return La lista circular con los medicamentos prescritos al paciente.
     */
    public ListaSimpleCircular getHistoricoDeMedicamentos() {
        return HistoricoDeMedicamentos;
    }

    /**
     * Establece la cédula del paciente.
     *
     * @param Cedula La cédula del paciente.
     */
    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    /**
     * Establece el nombre del paciente.
     *
     * @param Nombre El nombre del paciente.
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * Establece la edad del paciente.
     *
     * @param Edad La edad del paciente.
     */
    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    /**
     * Establece el género del paciente.
     *
     * @param Genero El género del paciente.
     */
    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    /**
     * Establece el historial de citas médicas del paciente.
     *
     * @param HistoricoDeCitas La lista circular con las citas médicas del
     * paciente.
     */
    public void setHistoricoDeCitas(ListaSimpleCircular HistoricoDeCitas) {
        this.HistoricoDeCitas = HistoricoDeCitas;
    }

    /**
     * Establece el historial de medicamentos del paciente.
     *
     * @param HistoricoDeMedicamentos La lista circular con los medicamentos
     * prescritos al paciente.
     */
    public void setHistoricoDeMedicamentos(ListaSimpleCircular HistoricoDeMedicamentos) {
        this.HistoricoDeMedicamentos = HistoricoDeMedicamentos;
    }
}
