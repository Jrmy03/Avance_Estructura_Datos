package av.avance_1;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Avance_1 {

    /**
     * Escanea y valida la entrada de opciones en el menú.
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author  Antonio Jesus Lopez Chacon
     * @return La opción ingresada por el usuario.
     */
    

    private static int contador = 0;
    static ColaPacientes pr = new ColaPacientes();
    static ColaPacientes pp = new ColaPacientes();
    static ColaPacientes bitacoraDia= new ColaPacientes();
    static final Scanner lector = new Scanner(System.in);
    static PilaQuejas pilaDeQuejas = new PilaQuejas();

    static ListaDobleCircular exped = new ListaDobleCircular();
    

    
    
    
    
    
    
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
        
        
        
        pp.asignarFichaPreferencial(horaDeLlegada, nombre,Genero,cedula, edad);
        
    }

    /**
     * Asigna datos a un paciente regulares.
     *
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author Antonio Jesus Lopez Chacon
     */
    public static void guardardatosR() {
        //Cedula
        String cedula= "";
        while (cedula.trim().isEmpty()){
        System.out.println("Cédula:");
        cedula = lector.nextLine();
        }
        //Nombre
        String nombre = "";
        while (nombre.trim().isEmpty()){
        System.out.println("Nombre del Paciente:");
        nombre = lector.nextLine();
        //edad
    }   int edad =lector.nextInt();
        System.out.println("edad:");
        while (!lector.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor ingrese su edad:");
            edad =lector.nextInt();
        }//Genero
        System.out.println("Género:\n\n1. Hombre\n2. Mujer\n");
        String Genero="";
        int opcion= lector.nextInt();
        while (opcion != 1 && opcion != 2) {
            System.out.println("Género:\n\n1. Hombre\n2. Mujer\n");
            opcion= lector.nextInt();
        if (opcion ==  1){
            Genero = "Hombre";
        }if (opcion ==  2){
            Genero = "Hombre";
    }
}
        LocalDateTime fechaHoraLlegada = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String horaDeLlegada = fechaHoraLlegada.format(formato);
        
        
        pr.asignarFichaRegulares(horaDeLlegada, nombre,Genero,cedula, edad);
 
    }
    
    public static void mostarBitacoraDia(){
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
                    + pacientePreferencial.getDatos().getNúmero_de_Cedula_del_Paciente()+" pasar a consulta médica.");   
            contador++;
            return;
        }

        if (contador == 2 || pp.esVacia()) {
            if (!pr.esVacia()) {
                NodoC pacienteRegular = pr.desencolar();
                bitacoraDia.encolar(pacienteRegular);
                System.out.println("Ficha #" + pacienteRegular.getDatos().getNúmero_de_ficha() + " con cédula "
                        + pacienteRegular.getDatos().getNúmero_de_Cedula_del_Paciente()+" pasar a consulta médica.");
                contador = 0;
            }
            return;
        }

        if (pp.esVacia() && !pr.esVacia()) {
            NodoC pacienteRegular = pr.desencolar();
            bitacoraDia.encolar(pacienteRegular);
            System.out.println("Ficha #" + pacienteRegular.getDatos().getNúmero_de_ficha() + " con cédula "
                    + pacienteRegular.getDatos().getNúmero_de_Cedula_del_Paciente()+" pasar a consulta médica.");
        } else if (!pp.esVacia() && pr.esVacia()) {
            NodoC pacientePreferencial = pp.desencolar();
            bitacoraDia.encolar(pacientePreferencial);
            System.out.println("Ficha #" + pacientePreferencial.getDatos().getNúmero_de_ficha() + " con cédula "
                    + pacientePreferencial.getDatos().getNúmero_de_Cedula_del_Paciente()+" pasar a consulta médica.");
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
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author  Antonio Jesus Lopez Chacon
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
     * Selecciona y ejecuta una opción del menú secundario de gestión de pacientes.
     * @author Jeremy Emmanuel Lorente Cerdas
     * @author  Antonio Jesus Lopez Chacon
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
                atenderPaciente();
                Menu2();
                break;
            case 3:
                System.out.print("Ingrese el número de ficha del paciente a eliminar: ");
                String numeroFicha = lector.next();
                if (pp.eliminarNodoEspecifico(numeroFicha)) {
                    System.out.println("La ficha #"+numeroFicha+" ha sido eliminada de la lista de espera");
                }if (pr.eliminarNodoEspecifico(numeroFicha)) {
                    System.out.println("La ficha #"+numeroFicha+" ha sido eliminada de la lista de espera");
                }else {
                    System.out.println("No se encontró ninguna ficha ingresada");
                }
                System.out.println("Volviendo al menu..");
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
