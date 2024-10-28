package av.avance_1;

import java.util.Date;

public class Cola_de_pacientes_preferenciales extends Cola {

   private int contadorFichaPreferencial = 1;
    
   public void asignarFichaPreferencial(String Número_de_Cedula_del_Paciente, String Nombre_del_Paciente){
        String Número_de_ficha = "R" + contadorFichaPreferencial++;
        Date Timestamp = new Date();
        
        System.out.println(" Su número de ficha es: " + Número_de_ficha);
   }
}
