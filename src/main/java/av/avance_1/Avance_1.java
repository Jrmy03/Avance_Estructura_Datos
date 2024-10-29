package av.avance_1;

import java.util.Scanner;


public class Avance_1 {

    
    
private static int contador = 0;

    static Cola_de_pacientes_regulares pr = new Cola_de_pacientes_regulares();
    static Cola_de_pacientes_preferenciales pp = new Cola_de_pacientes_preferenciales();
    static final Scanner scanner = new Scanner(System.in);
    static PilaQuejas pilaDeQuejas = new PilaQuejas();

     /**
     * Asigna datos a un paciente preferencial.
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author  Antonio Jesus Lopez Chacon
     */
    public static void AsignardatosP() {
        String cedula = "123456789";
        String nombre = "Nombre del Paciente";
        pp.asignarFichaPreferencial(cedula, nombre);
    }
/**
     * Asigna datos a un paciente regulares.
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author  Antonio Jesus Lopez Chacon
     */
    public static void AsignardatosR() {
        String cedula = "123456789";
        String nombre = "Nombre del Paciente";
        pr.asignarFichaRegulares(cedula, nombre);
    }
/**
     * Escanea y valida la entrada de opciones en el menú.
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author  Antonio Jesus Lopez Chacon
     * @return La opción ingresada por el usuario.
     */
    public static int escanear() {
        System.out.print("Ingrese una opción: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor ingrese un número.");
            scanner.next();
        }
        return scanner.nextInt();
    }
/**
     * Muestra las fichas de pacientes pendientes en las colas preferenciales y regulares.
     */
    public static void mostrarFichasPendientes() {

        System.out.println("Fichas Preferenciales:");
        NodoC nodoPreferencial = pp.getFrente();
        while (nodoPreferencial != null) {
            Paciente paciente = (Paciente) nodoPreferencial.getDatos();
            System.out.println("Ficha: " + paciente.getNúmero_de_ficha() + " - Nombre: " + paciente.getNombre_del_Paciente());
            nodoPreferencial = nodoPreferencial.getAtras();
        }

        System.out.println("Fichas Regulares:");
        NodoC nodoRegular = pr.getFrente();
        while (nodoRegular != null) {
            Paciente paciente = (Paciente) nodoRegular.getDatos();
            System.out.println("Ficha: " + paciente.getNúmero_de_ficha() + " - Nombre: " + paciente.getNombre_del_Paciente());
            nodoRegular = nodoRegular.getAtras();
        }
    }
/**
     * Atiende a un paciente, priorizando los preferenciales cada dos turnos.
     */
    public static void atenderPaciente() {
        if (pp.esVacia() && pr.esVacia()) {
            System.out.println("No hay pacientes en espera.");
            return;
        }

        if (contador < 2 && !pp.esVacia()) {
            NodoC pacientePreferencial = pp.desencolar();
            System.out.println("Atendiendo paciente preferencial: "
                    + "Ficha #" + pacientePreferencial.getDatos().getNúmero_de_ficha());
            contador++;
            return;
        }

        if (contador == 2 || pp.esVacia()) {
            if (!pr.esVacia()) {
                NodoC pacienteRegular = pr.desencolar();
                System.out.println("Atendiendo paciente regular: "
                        + "Ficha #" + pacienteRegular.getDatos().getNúmero_de_ficha());
                contador = 0;
            }
            return;
        }

        if (pp.esVacia() && !pr.esVacia()) {
            NodoC pacienteRegular = pr.desencolar();
            System.out.println("Atendiendo paciente regular: "
                    + "Ficha #" + pacienteRegular.getDatos().getNúmero_de_ficha());
        } else if (!pp.esVacia() && pr.esVacia()) {
            NodoC pacientePreferencial = pp.desencolar();
            System.out.println("Atendiendo paciente preferencial: "
                    + "Ficha #" + pacientePreferencial.getDatos().getNúmero_de_ficha());
        }
    }
 /**
     * Selecciona y ejecuta una opción del menú principal.
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author  Antonio Jesus Lopez Chacon
     * @param select La opción seleccionada en el menú principal.
     */
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
 /**
     * Selecciona y ejecuta una opción del menú secundario de gestión de pacientes.
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author  Antonio Jesus Lopez Chacon
     * @param select La opción seleccionada en el menú secundario.
     */
    public static void seleccionarOpcionMenu2(int select) {

        switch (select) {
            case 1:
                System.out.println("\nSeleccionar Ficha:\n\n1) Preferencial\n2) Regular\n");
                int numero = escanear();

                if (numero == 1) {
                    AsignardatosP();
                    System.out.println("\n1. Seleccionar Ficha\n2. Atender Paciente.\n3. Abandonar Cola de Pacientes."
                            + "\n4. Mostrar Fichas Pendientes.\n5. Mostrar Quejas recibidas\n6. Regresar\n");
                    seleccionarOpcionMenu2(escanear());
                    break;
                } else if (numero == 2) {
                    AsignardatosR();
                    System.out.println("\n1. Seleccionar Ficha\n2. Atender Paciente.\n3. Abandonar Cola de Pacientes."
                            + "\n4. Mostrar Fichas Pendientes.\n5. Mostrar Quejas recibidas\n6. Regresar\n");
                    seleccionarOpcionMenu2(escanear());
                    break;
                } else {
                    System.out.println("\nOpción no válida. Por favor intenta de nuevo.\n");
                    seleccionarOpcionMenu2(1);
                    break;
                }

            case 2:

                atenderPaciente();
                System.out.println("\n1. Seleccionar Ficha\n2. Atender Paciente.\n3. Abandonar Cola de Pacientes."
                        + "\n4. Mostrar Fichas Pendientes.\n5. Mostrar Quejas recibidas\n6. Regresar\n");
                seleccionarOpcionMenu2(escanear());
                break;
            case 3:
                System.out.print("Ingrese el número de ficha del paciente a eliminar: ");
                String numeroFicha = scanner.next();
                if (pp.eliminarNodoEspecifico(numeroFicha)) {
                    System.out.println("Nodo eliminado con éxito de la cola preferencial.");
                }if (pr.eliminarNodoEspecifico(numeroFicha)) {
                    System.out.println("Nodo eliminado con éxito de la cola regular.");
                }else {
                    System.out.println("No se encontró ninguna ficha ingresada");
                }
                System.out.println("Volviendo al menu..");
                seleccionarOpcionMenu2(escanear());
                break;
            case 4:

                mostrarFichasPendientes();
                System.out.println("\n1. Seleccionar Ficha\n2. Atender Paciente.\n3. Abandonar Cola de Pacientes."
                        + "\n4. Mostrar Fichas Pendientes.\n5. Mostrar Quejas recibidas\n6. Regresar\n");
                seleccionarOpcionMenu2(escanear());
                break;
            case 5:
                System.out.println("Mostrar Quejas recibidas.");
                pilaDeQuejas.listarQuejas();
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
 /**
     * Método principal que ejecuta el programa.
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author  Antonio Jesus Lopez Chacon
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {

        System.out.println("Bienvenido a Su Salud. Seleccione la opción que desea:\n\n"
                + "1. Gestionar Llegada de Pacientes\n2. Ayuda\n3. Salir\n");

        seleccionarOpcionMenu1(escanear());

    }
}
