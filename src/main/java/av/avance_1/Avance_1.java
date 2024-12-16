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
        // Verificar si hay pacientes en las colas
        if (pp.esVacia() && pr.esVacia()) {
            System.out.println("No hay pacientes en cola para atender.");
            Menu2();
            return;
        }

        NodoC nodoPaciente;
        if (contador < 2 && !pp.esVacia()) { // Atender paciente preferencial si hay menos de 2 atendidos
            nodoPaciente = pp.desencolar();
            contador++;
        } else if (!pr.esVacia()) { // Atender paciente regular
            nodoPaciente = pr.desencolar();
        } else {
            System.out.println("No hay pacientes en cola para atender.");
            Menu2();
            return;
        }

        Paciente datosPaciente = nodoPaciente.getDatos();
        Expediente expedienteExistente = exped.buscarPorCedula(datosPaciente.getNúmero_de_Cedula_del_Paciente());

        if (expedienteExistente == null) {
            // Primera vez: Mostrar mensaje y permitir al doctor crear el expediente
            System.out.println("Paciente " + datosPaciente.getNombre_del_Paciente() + " asiste a consulta por primera vez.");

            // Permitir al doctor ingresar los datos de la cita
            ListaSimpleCircular citas = new ListaSimpleCircular();
            ListaSimpleCircular medicamentos = new ListaSimpleCircular();
            ingresarDatosCita(citas, medicamentos);

            // Crear y guardar el nuevo expediente
            Expediente nuevoExpediente = new Expediente(
                    datosPaciente.getNúmero_de_Cedula_del_Paciente(),
                    datosPaciente.getNombre_del_Paciente(),
                    String.valueOf(datosPaciente.getEdad()),
                    datosPaciente.getGenero(),
                    citas,
                    medicamentos
            );
            exped.agregar(nuevoExpediente);

        } else {
            // Paciente existente: Mostrar datos del expediente
            System.out.println("Paciente encontrado en el expediente:");
            System.out.println("Cédula: " + expedienteExistente.getCedula());
            System.out.println("Nombre: " + expedienteExistente.getNombre());
            System.out.println("Edad: " + expedienteExistente.getEdad());
            System.out.println("Género: " + expedienteExistente.getGenero());

            // Permitir al doctor ingresar los datos de la cita
            ingresarDatosCita(expedienteExistente.getHistoricoDeCitas(), expedienteExistente.getHistoricoDeMedicamentos());

            // Aquí, la estructura de datos ya está actualizada
            System.out.println("Datos del expediente actualizados.");
        }

        // Registrar la cita en la bitácora diaria
        bitacoraDia.encolar(nodoPaciente);

        // Mensaje final
        System.out.println("Paciente " + datosPaciente.getNombre_del_Paciente() + ", su cita ha concluido.");
        Menu2();
    }

    private static void ingresarDatosCita(ListaSimpleCircular citas, ListaSimpleCircular medicamentos) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Registrar datos de la cita
        System.out.print("Ingrese detalles de la cita: ");
        String detalleCita = scanner.nextLine();
        citas.agregar(detalleCita);

        // Registrar medicamentos prescritos
        System.out.print("Ingrese medicamentos prescritos (separados por comas): ");
        String[] listaMedicamentos = scanner.nextLine().split(",");
        for (String medicamento : listaMedicamentos) {
            medicamentos.agregar(medicamento.trim());
        }

        System.out.println("Datos de la cita y medicamentos registrados exitosamente.");
    }

    //////////////////////////////////////////////////-------------//////////////////////////////////////////////////
    public static void atenderFicha() {
        if (contador < 2 && !pp.esVacia()) {
            NodoC pacientePreferencial = pp.desencolar();
            crearExpediente(pacientePreferencial);
            contador++;
        } else if (!pr.esVacia()) {
            NodoC pacienteRegular = pr.desencolar();
            crearExpediente(pacienteRegular);
            contador = 0;
        } else {
            System.out.println("No hay pacientes en cola para atender.");
        }
        Menu2();
    }

    private static void crearExpediente(NodoC nodoPaciente) {
        Paciente datosPaciente = nodoPaciente.getDatos();

        // Verificar si ya existe un expediente con la misma cédula
        Expediente expedienteExistente = exped.buscarPorCedula(datosPaciente.getNúmero_de_Cedula_del_Paciente());

        System.out.println("\nPaciente " + datosPaciente.getNombre_del_Paciente() + " con ficha " + datosPaciente.getNúmero_de_ficha() + " pasar a consulta\n");

        System.out.println("Mensajes para el doctor:");
        System.out.println("Paciente " + datosPaciente.getNombre_del_Paciente() + " asiste a consulta por primera vez\n\n");
        // Solicitar datos para la nueva cita
        Scanner lector = new Scanner(System.in);

        String fechaCita = "";
        System.out.println("Ingrese la fecha de la cita:");
        while (fechaCita.trim().isEmpty()) {
            fechaCita = lector.nextLine();
        }

        String nombreDoctor = "";
        System.out.println("Ingrese el nombre del doctor:");
        while (nombreDoctor.trim().isEmpty()) {
            nombreDoctor = lector.nextLine();
        }

        String diagnostico = "";
        System.out.println("Ingrese el diagnóstico:");
        while (diagnostico.trim().isEmpty()) {
            diagnostico = lector.nextLine();
        }

        NodoCita nuevaCita = new NodoCita(fechaCita, nombreDoctor, diagnostico);

        // Solicitar datos para el nuevo medicamento
        String fechaMedicamento = "";
        System.out.println("Ingrese la fecha de prescripción del medicamento:");
        while (fechaMedicamento.trim().isEmpty()) {
            fechaMedicamento = lector.nextLine();
        }

        String medicamento = "";
        System.out.println("Ingrese el medicamento prescrito:");
        while (medicamento.trim().isEmpty()) {
            medicamento = lector.nextLine();
        }

        NodoMedicamento nuevoMedicamento = new NodoMedicamento(fechaMedicamento, medicamento);

        if (expedienteExistente != null) {
            // Si el expediente ya existe, actualizar las listas
            System.out.println("El expediente ya existe. Se actualizarán los datos.\n");
            expedienteExistente.getHistoricoDeCitas().agregar(nuevaCita);
            expedienteExistente.getHistoricoDeMedicamentos().agregar(nuevoMedicamento);
            System.out.println("Expediente actualizado para: " + datosPaciente.getNombre_del_Paciente() + "\n");
        } else {
            // Si no existe, crear un nuevo expediente
            System.out.println("Creando un nuevo expediente para el paciente...\n");
            ListaSimpleCircular citas = new ListaSimpleCircular();
            citas.agregar(nuevaCita);

            ListaSimpleCircular medicamentos = new ListaSimpleCircular();
            medicamentos.agregar(nuevoMedicamento);

            Expediente nuevoExpediente = new Expediente(
                    datosPaciente.getNúmero_de_Cedula_del_Paciente(),
                    datosPaciente.getNombre_del_Paciente(),
                    String.valueOf(datosPaciente.getEdad()),
                    datosPaciente.getGenero(),
                    citas,
                    medicamentos
            );

            exped.agregar(nuevoExpediente);
            System.out.println("Expediente creado exitosamente para: " + datosPaciente.getNombre_del_Paciente() + "\n");
        }

        // Agregar a la bitácora del día
        bitacoraDia.encolar(nodoPaciente);
    }

    /*public static void atenderPaciente() {
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
    }*/
    /**
     * Escanea y valida la entrada de opciones en el menú.
     *
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author Antonio Jesus Lopez Chacon
     * @return La opción ingresada por el usuario.
     */
    public static int escanear() {
        System.out.print("\nIngrese una opción: \n");
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
        System.out.println("\n1. Gestionar Llegada de Pacientes\n"
                + "2. Llegada de Pacientes en Emergencias\n"
                + "3. Chat Bot\n"
                + "4. Ayuda y versión del sistema\n"
                + "5. Salir");
        switch (escanear()) {
            case 1:
                Menu2();
                break;
            case 2:
                System.out.println("Módulo de llegada de Pacientes en Emergencias");
                break;
            case 3:
                Menu3();
            case 4:
                System.out.println("Versión del sistema 1.3\n"
                        +"Diseño y creación software: Jeremy Lorente y Antonio López\n"
                        +"Documentación del protyecto: Brandon Vega\n");
                Menu1();
            case 5:
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
                atenderFicha();

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
                if (!exped.esVacia()) {
                    exped.navegar();
                } else {
                    System.out.println("No hay expedientes registrados.");
                }
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

    /**
     * Selecciona y ejecuta una opción del menú del chatbot.
     *
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author Antonio Jesus Lopez Chacon
     * @param escanear() La opción seleccionada en el menú principal.
     */
    public static void Menu3() {

        Scanner scanner = new Scanner(System.in);
        while (true) { // Submenú principal en un bucle
            System.out.println("¡Bienvenido al Chatbot de Preguntas Frecuentes!");
            System.out.println("1. Ver chatbot \n"
                    + "2. Mantenimiento del chatbot  \n"
                    + "3. Atrás");

            switch (scanner.nextInt()) {
                /**
                 * Opción para interactuar con el chatbot. Se precarga el árbol
                 * de preguntas frecuentes y se inicia el proceso de consulta.
                 */
                case 1:
                    ArbolChatbot arbol = new ArbolChatbot();
                    arbol.precargarArbol();
                    arbol.iniciarChat();

                    break;

                case 2:
                    /**
                     * Opción para realizar mantenimiento del chatbot. Permite
                     * modificar las preguntas y respuestas almacenadas en el
                     * árbol.
                     */
                    ArbolChatbot arbol1 = new ArbolChatbot();
                    arbol1.menuMantenimiento();

                    break;

                case 3:
                    System.out.println("Saliendo del Chatbot de Preguntas Frecuentes...");
                    Menu1();
                    return;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

    }

    public static void main(String[] args) {

        System.out.println("Bienvenido  a Su Salud\n");
        Menu1();

    }

}
