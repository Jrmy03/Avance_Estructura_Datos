package av.avance_1;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Avance_1 {

    public static void main(String[] args) {

        int numero;
        //Constructores
        Terminal opciones = new Terminal();
        PilaQuejas Quejas = new PilaQuejas();
        Cola_de_pacientes_preferenciales preferenciales = new Cola_de_pacientes_preferenciales();
        Cola_de_pacientes_regulares regulares = new Cola_de_pacientes_regulares();

        System.out.println("Bienvenido a 'nombre del hospital'");
        opciones.gestionarLlegadaPacientes();

    }

}
