package av.avance_1;

import java.util.Date;
/**
 * Clase Cola_de_pacientes_regulares que extiende de Cola.
 * Gestiona la asignación de fichas regulares a pacientes y los encola en la cola regular.
 * Cada ficha regular comienza con la letra "R" seguida de un número secuencial.
 * 
 * @author  Jeremy Emmanuel Lorente Cerdas
 * @author Antonio Jesus Lopez Chacon
 */

public class Cola_de_pacientes_regulares extends Cola {

   private int contador = 1;
    /**
    * Asigna una ficha regular a un paciente y lo encola en la cola regular.
    * La ficha asignada se genera con el prefijo "R" seguido de un número único.
    * 
    * @param Número_de_Cedula_del_Paciente Número de cédula del paciente.
    * @param Nombre_del_Paciente Nombre del paciente.
    */
   public void asignarFichaRegulares(int Número_de_Cedula_del_Paciente, String Nombre_del_Paciente){
        String Número_de_ficha = "R" + contador++;
        
        Paciente nuevoPaciente = new Paciente(
        new Date().toString(),  
        Nombre_del_Paciente, 
        Número_de_ficha,
        Número_de_Cedula_del_Paciente);
        
        NodoC nuevoNodo = new NodoC();
        nuevoNodo.setDatos(nuevoPaciente);
        encolar(nuevoNodo);
        System.out.println("Su número de ficha es la " + Número_de_ficha);
   }
}
