package av.avance_1;






public class ListaDobleCircular {

    private NodoExpediente inicio;
    private int tamaño;

    
    
    public ListaDobleCircular() {
        this.inicio = null;
        this.tamaño = 0;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public int getTamaño() {
        return tamaño;
    }

    public NodoExpediente getInicio() {
        return inicio;
    }

    public void setInicio(NodoExpediente inicio) {
        this.inicio = inicio;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
    
    
    public void agregar(Expediente expediente) {
    // Verificar si el expediente ya existe por cédula
    if (buscarPorCedula(expediente.getCedula()) != null) {
        System.out.println("Expediente con cédula " + expediente.getCedula() + " ya existe.");
        return;  // No agregar el expediente
    }

    NodoExpediente nuevo = new NodoExpediente(expediente);
    if (esVacia()) {
        inicio = nuevo;
        inicio.setSiguiente(inicio);
        inicio.setAnterior(inicio);
    } else {
        NodoExpediente ultimo = inicio.getAnterior();
        ultimo.setSiguiente(nuevo);
        nuevo.setAnterior(ultimo);
        nuevo.setSiguiente(inicio);
        inicio.setAnterior(nuevo);
    }
    tamaño++;
}
    
    public Expediente buscarPorCedula(String cedula) {
    if (esVacia()) {
        return null;
    }
    NodoExpediente actual = inicio;
    do {
        Expediente expediente = actual.getDatos();
        if (expediente.getCedula().equals(cedula)) {
            return expediente;
        }
        actual = actual.getSiguiente();
    } while (actual != inicio);
    return null;
}

    public void navegar() {
        if (esVacia()) {
            System.out.println("La lista está vacía.\n");
            return;
        }
        NodoExpediente actual = inicio;
        java.util.Scanner lector = new java.util.Scanner(System.in);
        String opcion;

        do {
            System.out.println("\nMostrando expediente actual:\n");
            mostrarExpediente(actual.getDatos());

            System.out.println("Opciones: ");
            System.out.println("1. Siguiente (>)");
            System.out.println("2. Anterior (<)");
            System.out.println("3. Salir (x)");
            System.out.print("Seleccione una opción: ");
            opcion = lector.nextLine();

            switch (opcion) {
                case "1":
                    actual = actual.getSiguiente();
                    break;
                case "2":
                    actual = actual.getAnterior();
                    break;
                case "3":
                    System.out.println("Saliendo de la navegación.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (!opcion.equals("3"));
    }
    
    private void mostrarExpediente(Expediente expediente) {
        System.out.println("Cédula: " + expediente.getCedula());
        System.out.println("Nombre: " + expediente.getNombre());
        System.out.println("Edad: " + expediente.getEdad());
        System.out.println("Género: " + expediente.getGenero());
        System.out.println("Histórico de Citas:\n");
        expediente.getHistoricoDeCitas().mostrar();
        System.out.println("Histórico de Medicamentos:\n");
        expediente.getHistoricoDeMedicamentos().mostrar();
        System.out.println("-----------------------------------");
    }
}
    
   

























































    /*
    public Expediente buscarExpedientePorCedula(String cedula) {
    if (esVacia()) return null;

    NodoExpediente actual = this.inicio;
    do {
        Expediente expediente = actual.getDatos();
        if (expediente.getCedula().equals(cedula)) {
            return expediente; // Retorna el expediente encontrado
        }
        actual = actual.getSiguiente();
    } while (actual != this.inicio);

    return null; // Si no encuentra ningún expediente, retorna null
}
}
    //////////////////////////////
    /*
    public Expediente buscarExpedientePorCedula(String cedula) {
    if (esVacia()) {
        return null;
    }

    NodoExpediente actual = inicio;
    do {
        if (actual.getDatos().getCedula().equals(cedula)) {
            return actual.getDatos();
        }
        actual = actual.getSiguiente();
    } while (actual != inicio);

    return null;
    }
}*/

/*
    public void agregarExpediente(Expediente nuevoExpediente) {
        if (Cabeza == null) {
            // Lista vacía: crear el primer nodo
            Cabeza = new NodoExpediente(nuevoExpediente);
            Cabeza.Siguiente = Cabeza;
            Cabeza.Anterior = Cabeza;
            System.out.println("Expediente agregado exitosamente.");
            return;
        }

        // Verificar si la cédula ya existe
        NodoExpediente Actual = Cabeza;
        do {
            if (Actual.Datos.getCedula().equals(nuevoExpediente.getCedula())) {
                System.out.println("Ese expediente ya existe.");
                return;
            }
            Actual = Actual.Siguiente;
        } while (Actual != Cabeza);

        // Agregar el nuevo nodo al final de la lista
        NodoExpediente nuevoNodo = new NodoExpediente(nuevoExpediente);
        NodoExpediente Ultimo = Cabeza.Anterior;

        Ultimo.Siguiente = nuevoNodo;
        nuevoNodo.Anterior = Ultimo;

        nuevoNodo.Siguiente = Cabeza;
        Cabeza.Anterior = nuevoNodo;

        System.out.println("Expediente agregado exitosamente.");
    }*/
