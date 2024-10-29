package av.avance_1;

import java.util.Date;
/**
 * Clase Cola_de_pacientes_preferenciales que extiende de Cola.
 * Gestiona la asignación de fichas preferenciales a pacientes y los encola en la cola preferencial.
 * Cada ficha preferencial comienza con la letra "P" seguida de un número secuencial.
 * 
 * @author Jeremy Emmanuel Lorente Cerdas
 * @author Antonio Jesus Lopez Chacon
 */
public class Cola_de_pacientes_preferenciales extends Cola {

   private int contador = 1;
    /**
    * Asigna una ficha preferencial a un paciente y lo encola en la cola preferencial.
    * La ficha asignada se genera con el prefijo "P" seguido de un número único.
    * 
    * @param Número_de_Cedula_del_Paciente Número de cédula del paciente.
    * @param Nombre_del_Paciente Nombre del paciente.
    */
   public void asignarFichaPreferencial(String Número_de_Cedula_del_Paciente, String Nombre_del_Paciente){
        String Número_de_ficha = "P" + contador++;
        
        Paciente nuevoPaciente = new Paciente(
        new Date().toString(), 
        Número_de_Cedula_del_Paciente, 
        Nombre_del_Paciente, 
        Número_de_ficha);
        
        NodoC nuevoNodo = new NodoC();
        nuevoNodo.setDatos(nuevoPaciente);
        encolar(nuevoNodo);
        System.out.println("Su número de ficha es: " + Número_de_ficha);
   }
}
