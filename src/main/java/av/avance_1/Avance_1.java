


package av.avance_1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Avance_1 {

    public static void main(String[] args) {
        //Definimos una variable de tipo String
        String tiempo;
        
        
         // Obtener la fecha y hora actual
         LocalDateTime now = LocalDateTime.now();
         DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
         tiempo = now.format(formato);
         System.out.println( tiempo); 
         
         
        
    }
}



   
  