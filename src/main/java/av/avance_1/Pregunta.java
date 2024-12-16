
package av.avance_1;

/**
 * Clase que representa una pregunta con un código, nombre y respuesta.
 * @author Jeremy Emmanuel Lorente Cerdas
 */
public class Pregunta {

    private String codigo;
    private String pregunta;
    private String respuesta;

    public Pregunta(String codigo, String pregunta, String respuesta) {
        this.codigo = codigo;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return pregunta;
    }

    /**
     * Devuelve una representación en forma de cadena de la pregunta.
     * @author Jeremy Emmanuel Lorente Cerdas
     * @return Una cadena con el formato "codigo. nombre".
     */
    
}

