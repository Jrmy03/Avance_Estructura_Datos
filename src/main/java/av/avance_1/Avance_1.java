package av.avance_1;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Avance_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
  
        System.out.println("Bienvenido a (nombre del hospital)! Seleccione la opción que desea:\n\n1. Gestionar Llegada de Pacientes\n2. Ayuda\n3. Salir");
        int selección = scanner.nextInt(); 
        System.out.println("1. Seleccionar Ficha\n2. Atender Paciente.\n3. Abandonar Cola de Pacientes."+""
                + "\n4. Mostrar Fichas Pendientes. +\n5. Mostrar Quejas recibidas\n6. Regresar");


        /*                                    ///TIEMSTAMP
//Definimos una variable de tipo String
        String tiempo;
        
        
         // Obtener la fecha y hora actual
         LocalDateTime now = LocalDateTime.now();
         DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
         tiempo = now.format(formato);
         System.out.println( tiempo); 
         */

         
        
    }
}



   
  