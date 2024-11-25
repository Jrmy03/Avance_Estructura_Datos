
package av.avance_1;


 /**
     * Constructor de la clase Paciente con parámetros.
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author Antonio Jesús López Chacón
     * @param Timestamp                  La fecha y hora de registro del paciente.
     * @param Nombre_del_Paciente        El nombre del paciente.
     * @param Número_de_Cedula_del_Paciente El número de cédula del paciente.
     * @param Número_de_ficha           El número de ficha asignado al paciente.
     * @param genero                    Genero del paciente.
     * @param edad                      Edad del paciente.
     */
public class Paciente {
    
   private String Timestamp, Nombre_del_Paciente,Número_de_ficha, genero, Número_de_Cedula_del_Paciente;
   private int  edad;
   
    
   
    public Paciente() {
    }

    public Paciente(String Timestamp, String Nombre_del_Paciente, String Número_de_ficha, String genero, String Número_de_Cedula_del_Paciente, int edad) {
        this.Timestamp = Timestamp;
        this.Nombre_del_Paciente = Nombre_del_Paciente;
        this.Número_de_ficha = Número_de_ficha;
        this.genero = genero;
        this.Número_de_Cedula_del_Paciente = Número_de_Cedula_del_Paciente;
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public int getEdad() {
        return edad;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public String getNombre_del_Paciente() {
        return Nombre_del_Paciente;
    }

    public String getNúmero_de_ficha() {
        return Número_de_ficha;
    }

    public String getNúmero_de_Cedula_del_Paciente() {
        return Número_de_Cedula_del_Paciente;
    }

    public void setTimestamp(String Timestamp) {
        this.Timestamp = Timestamp;
    }

    public void setNombre_del_Paciente(String Nombre_del_Paciente) {
        this.Nombre_del_Paciente = Nombre_del_Paciente;
    }

    public void setNúmero_de_ficha(String Número_de_ficha) {
        this.Número_de_ficha = Número_de_ficha;
    }

    public void setNúmero_de_Cedula_del_Paciente(String Número_de_Cedula_del_Paciente) {
        this.Número_de_Cedula_del_Paciente = Número_de_Cedula_del_Paciente;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    
}
