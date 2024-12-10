package av.avance_1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Clase principal para gestionar el sistema de atención a pacientes. Incluye
 * funcionalidades para asignar fichas, atender pacientes, y gestionar quejas.
 *
 * @author Jeremy Emmanuel Lorente Cerdas
 * @author Antonio Jesus Lopez Chacon
 */

public class Avance_1 {

    /**
     * Escanea y valida la entrada de opciones en el menú.
     *
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author Antonio Jesus Lopez Chacon
     * @return La opción ingresada por el usuario.
     */
    private static int contador = 0;
    static ColaPacientes pr = new ColaPacientes();
    static ColaPacientes pp = new ColaPacientes();
    static ColaPacientes bitacoraDia = new ColaPacientes();
    static final Scanner lector = new Scanner(System.in);
    static PilaQuejas pilaDeQuejas = new PilaQuejas();

    static ListaDobleCircular exped = new ListaDobleCircular();

    public static void imprimirclase() {

    }

    //Public static void consultaBitacora
    /**
     * Asigna datos a un paciente preferencial.
     *
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author Antonio Jesus Lopez Chacon
     */
    public static void guardardatosP() {

        String cedula = "";
        System.out.println("Cédula:");
        while (cedula.trim().isEmpty()) {
            cedula = lector.nextLine();
        }

        String nombre = "";
        System.out.println("Nombre del Paciente:");
        while (nombre.trim().isEmpty()) {
            nombre = lector.nextLine();
        }

        int edad = 0;
        System.out.println("Edad:");
        while (!lector.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor ingrese su edad:");
            lector.next();
        }
        edad = lector.nextInt();

        String Genero = "";
        System.out.println("Género:\n\n1. Hombre\n2. Mujer\n");
        int opcion = lector.nextInt();
        while (opcion != 1 && opcion != 2) {
            System.out.println("Género:\n\n1. Hombre\n2. Mujer\n");
            opcion = lector.nextInt();
        }
        if (opcion == 1) {
            Genero = "Hombre";
        } else if (opcion == 2) {
            Genero = "Mujer";
        }

        LocalDateTime fechaHoraLlegada = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String horaDeLlegada = fechaHoraLlegada.format(formato);

        pp.asignarFichaPreferencial(horaDeLlegada, nombre, Genero, cedula, edad);

    }

    /**
     * Asigna datos a un paciente regulares.
     *
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author Antonio Jesus Lopez Chacon
     */
    public static void guardardatosR() {
        //Cedula
        String cedula = "";
        System.out.println("Cédula:");
        while (cedula.trim().isEmpty()) {
            cedula = lector.nextLine();
        }

        String nombre = "";
        System.out.println("Nombre del Paciente:");
        while (nombre.trim().isEmpty()) {
            nombre = lector.nextLine();
        }

        int edad = 0;
        System.out.println("Edad:");
        while (!lector.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor ingrese su edad:");
            lector.next();
        }
        edad = lector.nextInt();

        String Genero = "";
        System.out.println("Género:\n\n1. Hombre\n2. Mujer\n");
        int opcion = lector.nextInt();
        while (opcion != 1 && opcion != 2) {
            System.out.println("Género:\n\n1. Hombre\n2. Mujer\n");
            opcion = lector.nextInt();
        }
        if (opcion == 1) {
            Genero = "Hombre";
        } else if (opcion == 2) {
            Genero = "Mujer";
        }

        LocalDateTime fechaHoraLlegada = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String horaDeLlegada = fechaHoraLlegada.format(formato);

        pr.asignarFichaRegulares(horaDeLlegada, nombre, Genero, cedula, edad);

    }

    public static void mostarBitacoraDia() {
        NodoC revisa = bitacoraDia.getFrente();
    }

    /**
     * Muestra las fichas de pacientes pendientes en las colas preferenciales y
     * regulares.
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
            bitacoraDia.encolar(pacientePreferencial);
            System.out.println("Ficha #" + pacientePreferencial.getDatos().getNúmero_de_ficha() + " con cédula "
                    + pacientePreferencial.getDatos().getNúmero_de_Cedula_del_Paciente() + " pasar a consulta médica.");
            contador++;
            return;
        }

        if (contador == 2 || pp.esVacia()) {
            if (!pr.esVacia()) {
                NodoC pacienteRegular = pr.desencolar();
                bitacoraDia.encolar(pacienteRegular);
                System.out.println("Ficha #" + pacienteRegular.getDatos().getNúmero_de_ficha() + " con cédula "
                        + pacienteRegular.getDatos().getNúmero_de_Cedula_del_Paciente() + " pasar a consulta médica.");
                contador = 0;
            }
            return;
        }

        if (pp.esVacia() && !pr.esVacia()) {
            NodoC pacienteRegular = pr.desencolar();
            bitacoraDia.encolar(pacienteRegular);
            System.out.println("Ficha #" + pacienteRegular.getDatos().getNúmero_de_ficha() + " con cédula "
                    + pacienteRegular.getDatos().getNúmero_de_Cedula_del_Paciente() + " pasar a consulta médica.");
        } else if (!pp.esVacia() && pr.esVacia()) {
            NodoC pacientePreferencial = pp.desencolar();
            bitacoraDia.encolar(pacientePreferencial);
            System.out.println("Ficha #" + pacientePreferencial.getDatos().getNúmero_de_ficha() + " con cédula "
                    + pacientePreferencial.getDatos().getNúmero_de_Cedula_del_Paciente() + " pasar a consulta médica.");
        }
    }

    /**
     * Escanea y valida la entrada de opciones en el menú.
     *
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author Antonio Jesus Lopez Chacon
     * @return La opción ingresada por el usuario.
     */
    public static int escanear() {
        System.out.print("\nIngrese una opción: ");
        while (!lector.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor ingrese un número.");
            lector.next();
        }
        return lector.nextInt();
    }

    /**
     * Selecciona y ejecuta una opción del menú principal.
     *
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author Antonio Jesus Lopez Chacon
     * @param escanear() La opción seleccionada en el menú principal.
     */
    public static void Menu1() {
        System.out.println("1. Gestionar Llegada de Pacientes\n"
                + "2. Llegada de Pacientes en Emergencias\n"
                + "3. Chat Bot\n"
                + "4. Salir");
        switch (escanear()) {
            case 1:
                Menu2();
                break;
            case 2:
                System.out.println("Módulo de llegada de Pacientes en Emergencias");
                break;
            case 3:
                System.out.println("Apache NetBeans IDE.20. Avance 1 V 1.0.0.");
            case 4:
                System.out.println("Salir");
                System.exit(0);
            default:
                System.out.println("\nOpción no válida. Por favor intenta de nuevo.");
                Menu1();
        }
    }

    /**
     * Selecciona y ejecuta una opción del menú secundario de gestión de
     * pacientes.
     *
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author Antonio Jesus Lopez Chacon
     * @param escanear() La opción seleccionada en el menú secundario.
     */
    public static void Menu2() {
        System.out.println("1. Seleccionar Ficha\n"
                + "2. Atender Paciente\n"
                + "3. Cancelar Cita\n"
                + "4. Expediente del Paciente y bitácora de Citas\n"
                + "5. Módulo de Atención de Quejas\n"
                + "6. Regresar");

        switch (escanear()) {
            case 1:
                while (true) {
                    System.out.println("\nSeleccionar Ficha:\n\n1) Preferencial\n2) Regular\n3) Volver");

                    int numero = escanear();

                    if (numero == 1) {
                        guardardatosP();
                        System.out.println("Desea seleccionar otra ficha?");
                    } else if (numero == 2) {
                        guardardatosR();
                        System.out.println("Desea seleccionar otra ficha?");
                    } else if (numero == 3) {
                        Menu2();
                        break;
                    } else {
                        System.out.println("\nOpción no válida. Por favor intenta de nuevo.\n");
                    }
                }
            case 2:
                /**
                 * Atiende a un paciente, registrando detalles de su consulta
                 * médica.
                 *
                 * El proceso incluye:
                 * <ul>
                 * <li>Obtener los datos del paciente desde el nodo actual.</li>
                 * <li>Registrar al paciente en la bitácora del día.</li>
                 * <li>Verificar si el paciente tiene un expediente existente o
                 * si es su primera consulta.</li>
                 * <li>Solicitar al usuario detalles adicionales de la consulta,
                 * como diagnóstico y medicamentos recetados.</li>
                 * </ul>
                 *
                 * @author Jeremy Emmanuel Lorente Cerdas
                 * @author Antonio Jesus Lopez Chacon
                 */

                atenderPaciente();
                if (pp.esVacia() && pr.esVacia()) {
                    System.out.println("No hay pacientes en espera.");
                    return;
                }
// Variable para almacenar el nodo del paciente actual.
                NodoC nodoPaciente;

                // Alterna entre la cola prioritaria y la cola regular para la atención de pacientes.
                if (contador < 2 && !pp.esVacia()) {
                    nodoPaciente = pp.desencolar();
                    contador++;
                } else {
                    nodoPaciente = pr.desencolar();
                    contador = 0;
                }

                // Verifica que el nodo del paciente no sea nulo.
                if (nodoPaciente == null) {
                    System.out.println("Error al obtener el paciente.");
                    return;
                }

                // Obtiene los datos del paciente del nodo.
                Paciente paciente = (Paciente) nodoPaciente.getDatos();

                // Registra al paciente en la bitácora del día.
                bitacoraDia.encolar(nodoPaciente);

                // Muestra el nombre del paciente que será atendido.
                System.out.println("Atendiendo al paciente: " + paciente.getNombre_del_Paciente());

                // Busca el expediente del paciente por su cédula.
                NodoC nodoExpediente = exped.buscarPorCedula(paciente.getNúmero_de_Cedula_del_Paciente());

                if (nodoExpediente == null) {
                    // Caso: el paciente no tiene un expediente previo.
                    System.out.println("Paciente " + paciente.getNombre_del_Paciente() + " asiste a consulta por primera vez.");

                    // Solicita información adicional del paciente.
                    System.out.println("Ingrese los detalles adicionales del paciente:");
                    System.out.println("Diagnóstico:");
                    lector.nextLine(); // Limpia el buffer de entrada.
                    String diagnostico = lector.nextLine();
                    System.out.println("Medicamentos recetados:");
                    String medicamentos = lector.nextLine();

                    // Aquí se puede agregar lógica para registrar esta información en un nuevo expediente.
                } else {
                    // Caso: el paciente ya tiene un expediente existente.
                    Paciente expediente = (Paciente) nodoExpediente.getDatos();
                    System.out.println("Datos del paciente:");
                    System.out.println("Cédula: " + expediente.getNúmero_de_Cedula_del_Paciente());
                    System.out.println("Nombre: " + expediente.getNombre_del_Paciente());
                    System.out.println("Edad: " + expediente.getEdad());
                    System.out.println("Género: " + expediente.getGenero());

                    // Solicita información adicional de la cita actual.
                    System.out.println("Ingrese los detalles de la cita actual:");
                    System.out.println("Diagnóstico:");
                    lector.nextLine(); // Limpia el buffer de entrada.
                    String diagnostico = lector.nextLine();
                    System.out.println("Medicamentos recetados:");
                    String medicamentos = lector.nextLine();

                    // Aquí se puede agregar lógica para actualizar el expediente del paciente.
                }

                // Registra la fecha y hora de la cita.
                LocalDateTime fechaCita = LocalDateTime.now();
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String fechaCitaFormateada = fechaCita.format(formato);

                // Concluye la atención del paciente.
                System.out.println("Paciente " + paciente.getNombre_del_Paciente() + ", su cita ha concluido.");

                // Llama al menú principal para continuar.
                Menu2();
                break;

            case 3:
                // Solicita al usuario el número de ficha del paciente a eliminar.
                System.out.print("Ingrese el número de ficha del paciente a eliminar: ");
                String numeroFicha = lector.next();

                // Intenta eliminar la ficha de la cola prioritaria.
                if (pp.eliminarNodoEspecifico(numeroFicha)) {
                    System.out.println("La ficha #" + numeroFicha + " ha sido eliminada de la lista de espera (cola prioritaria).");
                }

                // Intenta eliminar la ficha de la cola regular.
                if (pr.eliminarNodoEspecifico(numeroFicha)) {
                    System.out.println("La ficha #" + numeroFicha + " ha sido eliminada de la lista de espera (cola regular).");
                } else {
                    // Si la ficha no se encuentra en ninguna de las colas.
                    System.out.println("No se encontró ninguna ficha ingresada.");
                }

                // Informa al usuario que se regresa al menú principal.
                System.out.println("Volviendo al menú...");
                Menu2();
                break;
            case 4:
                mostrarFichasPendientes();
                Menu2();
                break;
            case 5:
                pilaDeQuejas.listarQuejas();
                Menu2();
                break;
            case 6:
                Menu1();
            case 7:

            default:
                System.out.println("\nOpción no válida. Por favor intenta de nuevo.");
                Menu2();
        }
    }

    public static void main(String[] args) {

        System.out.println("Bienvenido  a Su Salud\n");
        Menu1();

    }

}
