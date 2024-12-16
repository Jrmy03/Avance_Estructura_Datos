
package av.avance_1;

/**
 * Clase que representa un Chatbot basado en un árbol de decisiones.
 * Permite gestionar un árbol de preguntas y respuestas.
 * @author Jeremy Emmanuel Lorente Cerdas
 * @author Antonio Jesus Lopez Chacon
 */
import java.util.Scanner;


public class ArbolChatbot extends ListaArbol {

    private NodoA raiz;

    public ArbolChatbot() {
        this.raiz = null;
    }

    public void precargarArbol() {
        // Se crea el árbol desde el nivel 1 al 4
        raiz = new NodoA("1", "Preguntas Frecuentes (FAQ)");

                                                        // Nivel 2
        NodoA nodoEmergencias = new NodoA("11", "Emergencias");
        NodoA nodoConsultaExterna = new NodoA("12", "Consulta Externa");
        raiz.setHijoIzq(nodoEmergencias);
        raiz.setHijoDer(nodoConsultaExterna);

                                                        // Nivel 3
        NodoA nodoEmergenciasMenores = new NodoA("111", "Emergencias Menores");
        NodoA nodoEmergenciasMayores = new NodoA("112", "Emergencias Mayores");
        nodoEmergencias.setHijoIzq(nodoEmergenciasMenores);
        nodoEmergencias.setHijoDer(nodoEmergenciasMayores);

        NodoA nodoServicios = new NodoA("121", "Servicios");
        nodoConsultaExterna.setHijoIzq(nodoServicios);

                                                          // Nivel 4
        NodoA nodoMayores18 = new NodoA("1111", "Mayores 18 años");
        NodoA nodoMenoresEdad = new NodoA("1112", "Menores de edad");
        nodoEmergenciasMenores.setHijoIzq(nodoMayores18);
        nodoEmergenciasMenores.setHijoDer(nodoMenoresEdad);

        NodoA nodoLaboratorio = new NodoA("1211", "Laboratorio");
        NodoA nodoFarmacia = new NodoA("1212", "Farmacia");
        nodoServicios.setHijoIzq(nodoLaboratorio);
        nodoServicios.setHijoDer(nodoFarmacia);

                                                       // Agregar preguntas a las hojas
        
        ListaArbol preguntasMayores18 = new  ListaArbol();
        preguntasMayores18.insertar(new Pregunta("1", "¿Cuál es el costo de consulta para adultos?",
                "El costo de atención en emergencias para un adulto es de 20,000 colones"));
        preguntasMayores18.insertar(new Pregunta("2", "¿Cuál es el tiempo promedio de espera?",
                "Por tratarse de un servicio de emergencia no podemos garantizar un tiempo mínimo para atenciones menores. Sin embargo, en promedio demoramos 30 minutos."));
        nodoMayores18.setListaPreguntas(preguntasMayores18);

        ListaArbol preguntasMenoresEdad = new ListaArbol();
        preguntasMenoresEdad.insertar(new Pregunta("1", "¿Qué especialidad atiende a los niños?",
                "Contamos con pediatra las 24 horas del día."));
        preguntasMenoresEdad.insertar(new Pregunta("2", "¿Se puede aplicar el seguro estudiantil?",
                "Si, recibimos todos los seguros médicos del mercado."));
        nodoMenoresEdad.setListaPreguntas(preguntasMenoresEdad);

         ListaArbol preguntasLaboratorio = new ListaArbol();
        preguntasLaboratorio.insertar(new Pregunta("1", "Horario", "Atendemos 24 horas del día."));
        preguntasLaboratorio.insertar(new Pregunta("2", "Sucursales",
                "Tenemos sucursales en todo el país, ingrese a www.susalud.com/sucursales para mayor información."));
        nodoLaboratorio.setListaPreguntas(preguntasLaboratorio);

        ListaArbol preguntasFarmacia = new ListaArbol();
        preguntasFarmacia.insertar(new Pregunta("1", "Aplicar a una plaza",
                "Ingrese a ¡Error! Referencia de hipervínculo no válida."));
        nodoFarmacia.setListaPreguntas(preguntasFarmacia);
    }
/**
     * Obtiene la raíz del árbol.
     * @author Jeremy Emmanuel Lorente Cerdas
     * @return NodoA que representa la raíz del árbol.
     */
    public NodoA getRaiz() {
        return raiz;
    }
 /**
     * Inicia el chat del árbol de preguntas y respuestas.
     * @author Jeremy Emmanuel Lorente Cerdas
     */
   public void iniciarChat() {
    Scanner scanner = new Scanner(System.in);
    NodoA actual = raiz; // Nodo inicial del árbol

    System.out.println("¡Bienvenido al Chatbot de Preguntas Frecuentes (FAQ)!");
    while (true) {
        System.out.println("\n" + actual.getNombre());

        // Si es una hoja, mostrar preguntas
        if (actual.getListaPreguntas() != null) {
            actual.getListaPreguntas().mostrarPreguntas();
            System.out.println("Seleccione una pregunta para ver la respuesta o escriba 3 regresar:");
            int opcion = scanner.nextInt();

            if (opcion == 3) {
                return; // Regresar al submenú principal
            }

            // Convertir el número a texto manualmente
            String codigoPregunta = convertirEnteroACadena(opcion);

            // Buscar y mostrar la respuesta
            String respuesta = actual.getListaPreguntas().buscarRespuesta(codigoPregunta);
            if (respuesta != null) {
                System.out.println("Respuesta: " + respuesta);
            } else {
                System.out.println("Pregunta no válida.");
            }
        } else {
            // Si no es hoja, mostrar opciones de hijos
            if (actual.getHijoIzq() != null) {
                System.out.println("1. " + actual.getHijoIzq().getNombre());
            }
            if (actual.getHijoDer() != null) {
                System.out.println("2. " + actual.getHijoDer().getNombre());
            }
            System.out.println("3. Regresar ");

            // Leer opción del usuario
            int opcion = scanner.nextInt();
            if (opcion == 1 && actual.getHijoIzq() != null) {
                actual = actual.getHijoIzq();
            } else if (opcion == 2 && actual.getHijoDer() != null) {
                actual = actual.getHijoDer();
            } else if (opcion == 3) {
                return; // Regresar al submenú principal
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }
}
/**
     * Convierte un entero en una cadena de caracteres manualmente.
     * @author Antonio Jesus Lopez Chacon
     * @param numero El número entero a convertir.
     * @return La representación en cadena del número.
     */
    private String convertirEnteroACadena(int numero) {
        String resultado = "";
        while (numero > 0) {
            int digito = numero % 10;
            char caracter = (char) ('0' + digito);
            resultado = caracter + resultado;
            numero /= 10;
        }
        return resultado.isEmpty() ? "0" : resultado;
    }

    /**
     * Muestra el menú de mantenimiento para modificar el árbol.
     * @author Jeremy Emmanuel Lorente Cerdas
     */
    public void menuMantenimiento() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n=== Mantenimiento del Chatbot ===");
            System.out.println("1. Insertar/Modificar pregunta padre");
            System.out.println("2. Insertar/Modificar pregunta hija");
            System.out.println("3. Imprimir preguntas hijas de un nodo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    insertarModificarPadre(scanner);
                    break;
                case 2:
                    insertarModificarHija(scanner);
                    break;
                case 3:
                    imprimirPreguntasHijas(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del mantenimiento del chatbot.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    /**
     * Inserta o modifica la pregunta de un nodo padre.
     * @author Jeremy Emmanuel Lorente Cerdas
     * @param scanner Objeto Scanner para leer datos del usuario.
     */
    private void insertarModificarPadre(Scanner scanner) {
        System.out.print("Ingrese la pregunta del nodo padre: ");
        String pregunta = scanner.nextLine();

        if (raiz == null) {
            System.out.print("Ingrese el identificador para la raíz: "); // Pide el identificador
            String identificador = scanner.nextLine();

            raiz = new NodoA(identificador, pregunta); // Crea la raíz con identificador y nombre
            System.out.println("Nodo padre creado como raíz del árbol.");
        } else {
            NodoA nodo = buscarNodo(scanner, raiz);
            if (nodo != null) {
                nodo.setNombre(pregunta); // Actualiza el nombre del nodo padre
                System.out.println("Pregunta del nodo padre actualizada.");
            } else {
                System.out.println("Nodo no encontrado.");
            }
        }

    }

    /**
     * Inserta o modifica una pregunta hija asociada a un nodo.
     * @author Antonio Jesus Lopez Chacon
     * @param scanner Objeto Scanner para leer datos del usuario.
     */
    private void insertarModificarHija(Scanner scanner) {
        if (raiz == null) {
            System.out.println("El árbol está vacío. Primero inserte un nodo padre.");
            return;
        }

        NodoA nodo = buscarNodo(scanner, raiz);
        if (nodo != null) {
            System.out.print("Ingrese la pregunta hija: ");
            String textoPregunta = scanner.nextLine();

            // Crear un objeto Pregunta
            System.out.print("Ingrese el código de la pregunta: ");
            String codigoPregunta = scanner.nextLine();
            Pregunta nuevaPregunta = new Pregunta(codigoPregunta, textoPregunta, "");

            if (nodo.getListaPreguntas() == null) {
                nodo.setListaPreguntas(new ListaArbol());
            }

            nodo.getListaPreguntas().insertar(nuevaPregunta); // Insertar la pregunta en la lista
            System.out.println("Pregunta hija añadida o modificada.");
        } else {
            System.out.println("Nodo no encontrado.");
        }
    }

    /**
     * Imprime las preguntas hijas asociadas a un nodo.
     * @author Jeremy Emmanuel Lorente Cerdas
     * @param scanner Objeto Scanner para leer datos del usuario.
     */
    private void imprimirPreguntasHijas(Scanner scanner) {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        NodoA nodo = buscarNodo(scanner, raiz);
        if (nodo != null && nodo.getListaPreguntas() != null) {
            System.out.println("Preguntas hijas del nodo:");
            nodo.getListaPreguntas().mostrarPreguntas(); // Llamar al método de ListaArbol para mostrar las preguntas
        } else {
            System.out.println("El nodo no tiene preguntas hijas o no existe.");
        }
    }

    /**
     * Busca un nodo en el árbol basado en el nombre de la pregunta.
     * @author Jeremy Emmanuel Lorente Cerdas
     * @param scanner Objeto Scanner para leer datos del usuario.
     * @param nodo Nodo actual desde donde comienza la búsqueda.
     * @return NodoA encontrado o null si no existe.
     */
    private NodoA buscarNodo(Scanner scanner, NodoA nodo) {
        System.out.print("Ingrese la pregunta del nodo a buscar: ");
        String pregunta = scanner.nextLine();

        return buscarNodoRecursivo(nodo, pregunta);
    }

    /**
     * Búsqueda recursiva de un nodo en el árbol.
     * @author Antonio Jesus Lopez Chacon
     * @param nodo Nodo actual en el que se realiza la búsqueda.
     * @param pregunta Pregunta asociada al nodo buscado.
     * @return NodoA encontrado o null si no existe.
     */
    private NodoA buscarNodoRecursivo(NodoA nodo, String pregunta) {
        if (nodo == null) {
            return null;
        }

        if (nodo.getNombre().equalsIgnoreCase(pregunta)) {
            return nodo;
        }

        NodoA encontradoIzquierda = buscarNodoRecursivo(nodo.getHijoIzq(), pregunta);
        if (encontradoIzquierda != null) {
            return encontradoIzquierda;
        }

        return buscarNodoRecursivo(nodo.getHijoDer(), pregunta);
    }
}
