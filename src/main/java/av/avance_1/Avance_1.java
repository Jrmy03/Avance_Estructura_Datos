package av.avance_1;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Avance_1 {

    
    public static void main(String[] args) {
        System.out.println("Bienvenido a 'nombre del hospital'. Seleccione la opción que desea:\n\n"
                + "1. Gestionar Llegada de Pacientes\n2. Ayuda\n3. Salir\n");

        int numero = Terminal.escanear();
        Terminal.seleccionarOpcionMenu1(numero);
    }
}
