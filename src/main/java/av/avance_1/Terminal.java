
package av.avance_1;

import java.util.Scanner;

public class Terminal {
    
    public int escanear() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();}
    
    public void seleccionarOpcionMenu0(){
        
        System.out.println("Bienvenido a 'nombre del hospital'. Seleccione la opción que desea:\n\n1. Gestionar Llegada "
                        + "de Pacientes\n2. Ayuda\n3. Salir");
        escanear();
    }

    
    public void seleccionarOpcionMenu1(int select) {
        switch (select) {
            case 1:
                System.out.println("1. Seleccionar Ficha\n2. Atender Paciente.\n3. Abandonar Cola de Pacientes." + ""
                        + "\n4. Mostrar Fichas Pendientes. +\n5. Mostrar Quejas recibidas\n6. Regresar");
                break;
            case 2:
                System.out.println("Apache NetBeans IDE.20. Avance 1 V 1.0.0.");
                break;
            case 3:
                System.out.println("saliendo..");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida. Por favor intenta de nuevo. Seleccione la opción que desea:\n\n1. Gestionar Llegada "
                        + "de Pacientes\n2. Ayuda\n3. Salir");
        }

    }

    public void seleccionarOpcionMenu2(int select) {
        switch (select) {
            case 1:
                System.out.println("Seleccionar Ficha.");
                break;
            case 2:
                System.out.println("Atender Paciente.");
                break;
            case 3:
                System.out.println("Abandonar Cola de Pacientes.");
                break;
            case 4:
                System.out.println("Mostrar Fichas Pendientes.");
                break;
            case 5:
                System.out.println("Mostrar Quejas recibidas");
                break;
            case 6:
                System.out.println("Regresar");
                seleccionarOpcionMenu0();
                escanear();
                
            default:
                System.out.println("Opción no válida. Por favor intenta de nuevo. 1. Seleccionar Ficha\n2. Atender Paciente."+
                        "\n3. Abandonar Cola de Pacientes." + "\n4. Mostrar Fichas Pendientes. +\n5. Mostrar Quejas "+
                        "recibidas\n6. Regresar");

        }
    }
}

