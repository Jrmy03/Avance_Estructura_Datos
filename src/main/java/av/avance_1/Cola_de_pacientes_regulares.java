package av.avance_1;

import java.util.Date;



public class Cola_de_pacientes_regulares extends Cola{
    
    private int contadorFichaRegular = 1;

    public Cola_de_pacientes_regulares() {
    }
    
    public void asignarFichaRegular(String Número_de_Cedula_del_Paciente, String Nombre_del_Paciente){
        String Número_de_ficha = "R" + contadorFichaRegular++;
        Date Timestamp = new Date();
        
        System.out.println(" Su número de ficha es: " + Número_de_ficha);
        
        
    }
}
