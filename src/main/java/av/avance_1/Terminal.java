
package av.avance_1;


import java.util.Scanner;

public class Terminal {

    static final Scanner scanner = new Scanner(System.in);

    public static int escanear() {
        System.out.print("Ingrese una opción: ");
        while (!scanner.hasNextInt()) { 
            System.out.println("Entrada inválida. Por favor ingrese un número.");
        scanner.next();
        }
        return scanner.nextInt();
    }

    

   
    public static void seleccionarOpcionMenu1(int select) {

        switch (select) {
            case 1:
                System.out.println("\n1. Seleccionar Ficha\n2. Atender Paciente.\n3. Abandonar Cola de Pacientes."
                        + "\n4. Mostrar Fichas Pendientes.\n5. Mostrar Quejas recibidas\n6. Regresar\n");
                seleccionarOpcionMenu2(escanear());
                break;
            case 2:
                System.out.println("Apache NetBeans IDE.20. Avance 1 V 1.0.0.");
                break;
            case 3:
                System.out.println("Saliendo...");
                System.exit(0);
                break;
            default:
                System.out.println("\nOpción no válida. Por favor intenta de nuevo.");
                System.out.println("\n1. Gestionar Llegada de Pacientes\n2. Ayuda\n3. Salir\n");
                seleccionarOpcionMenu1(escanear());
        }
    }

 
    public static void seleccionarOpcionMenu2(int select) {
        switch (select) {
            case 1:
                System.out.println("\nSeleccionar Ficha:\n\n1) Preferencial\n2) Regular\n");
                int numero = escanear();
                if (numero == 1) {
                    System.out.println("Usted es preferencial");
                    
                    
                }

                if (numero== 2) {
                    System.out.println("Usted es Regular");
                    
                } if (numero !=1 && numero != 2) {
                    System.out.println("\nOpción no válida. Por favor intenta de nuevo.\n");
                    
                    seleccionarOpcionMenu2(1);
                    
                 }
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
                System.out.println("Mostrar Quejas recibidas.");
                break;
            case 6:
                System.out.println("\n1. Gestionar Llegada de Pacientes\n2. Ayuda\n3. Salir\n");
                seleccionarOpcionMenu1(escanear());
                
                
                break;
            default:
                System.out.println("\nOpción no válida. Por favor intenta de nuevo.");
                System.out.println("\n1. Seleccionar Ficha\n2. Atender Paciente.\n3. Abandonar Cola de Pacientes."
                        + "\n4. Mostrar Fichas Pendientes.\n5. Mostrar Quejas recibidas\n6. Regresar\n");
                seleccionarOpcionMenu2(escanear());
        }
    }
}


