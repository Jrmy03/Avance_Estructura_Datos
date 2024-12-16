
package av.avance_1;


import java.util.Scanner;


public class ArbolChatbot extends ListaArbol {

    private NodoA raiz;

    public ArbolChatbot() {
        this.raiz = null;
    }

    public void precargarArbol() {
        // Crear el árbol desde el nivel 1 al 4
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

    public NodoA getRaiz() {
        return raiz;
    }

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

}
