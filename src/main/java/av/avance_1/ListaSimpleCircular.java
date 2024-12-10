
package av.avance_1;



public class ListaSimpleCircular {
    
    
    NodoC cabeza;
    NodoC ultimo;

    public void inserta(Paciente paciente) {
        int cedulaPaciente = convertirStringAEntero(paciente.getNúmero_de_Cedula_del_Paciente());

        if (cabeza == null) {
            cabeza = new NodoC(paciente);
            ultimo = cabeza;
            ultimo.setSiguiente(cabeza);
        } else {
            int cedulaCabeza = convertirStringAEntero(cabeza.getDatos().getNúmero_de_Cedula_del_Paciente());
            if (cedulaPaciente < cedulaCabeza) {
                // Insertamos al inicio
                NodoC auxiliar = new NodoC(paciente);
                auxiliar.setSiguiente(cabeza);
                cabeza = auxiliar;
                ultimo.setSiguiente(cabeza);
            } else {
                int cedulaUltimo = convertirStringAEntero(ultimo.getDatos().getNúmero_de_Cedula_del_Paciente());
                if (cedulaUltimo < cedulaPaciente) {
                    // Insertamos al final
                    NodoC auxiliar = new NodoC(paciente);
                    ultimo.setSiguiente(auxiliar);
                    ultimo = auxiliar;
                    ultimo.setSiguiente(cabeza);
                } else {
                    // Insertamos en el medio de la lista
                    NodoC auxiliar = cabeza;
                    while (convertirStringAEntero(auxiliar.getSiguiente().getDatos().getNúmero_de_Cedula_del_Paciente()) < cedulaPaciente) {
                        auxiliar = auxiliar.getSiguiente();
                    }

                    NodoC temporal = new NodoC(paciente);
                    temporal.setSiguiente(auxiliar.getSiguiente());
                    auxiliar.setSiguiente(temporal);
                }
            }
        }
    }

    // Método para convertir un String a int
    private int convertirStringAEntero(String numero) {
        try {
            return Integer.parseInt(numero); // Convierte el String a un entero
        } catch (NumberFormatException e) {
            System.out.println("Error: La cadena no es un número válido. Valor: " + numero);
            return -1; // Devuelve un valor especial o lanza una excepción personalizada si prefieres
        }
    }

    public String imprimirSiguienteDelUltimo() {
        return ultimo.getSiguiente().toString();
    }

    @Override
    public String toString() {
        String respuesta = "Lista circular: \n";

        NodoC auxiliar = cabeza;

        if (auxiliar != null) {

            respuesta += auxiliar.toString() + "\n";
            auxiliar = auxiliar.getSiguiente();
            while (auxiliar != cabeza) {
                respuesta += auxiliar.toString() + "\n";
                auxiliar = auxiliar.getSiguiente();
            }
        } else {
            respuesta += "Vacía";
        }

        return respuesta;
    }
}
    
    
    
    
    
    
