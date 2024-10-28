package av.avance_1;

import java.util.Date;


public class Cola_de_pacientes_regulares extends Cola {

   private int contador = 1;
    
   public void asignarFichaRegulares(String Número_de_Cedula_del_Paciente, String Nombre_del_Paciente){
        String Número_de_ficha = "R" + contador++;
        
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
