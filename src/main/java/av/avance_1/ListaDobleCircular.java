
package av.avance_1;


public class ListaDobleCircular {
    
    private NodoC cabeza;
    private NodoC ultimo;

    public void inserta(Paciente p) {
        int cedulaPaciente = convertirStringAEntero(p.getNúmero_de_Cedula_del_Paciente());

        if (cabeza == null) {
            // Paso 1: Lista vacía, insertamos el primer nodo
            cabeza = new NodoC(p);
            ultimo = cabeza;
            cabeza.setAtras(ultimo);
            cabeza.setSiguiente(ultimo);
            ultimo.setSiguiente(cabeza);
            ultimo.setAtras(cabeza);
        } else {
            int cedulaCabeza = convertirStringAEntero(cabeza.getDatos().getNúmero_de_Cedula_del_Paciente());
            if (cedulaPaciente < cedulaCabeza) {
                // Paso 2: Insertar antes de la cabeza
                NodoC aux = new NodoC(p);
                aux.setSiguiente(cabeza);
                cabeza.setAtras(aux);
                cabeza = aux;
                cabeza.setAtras(ultimo);
                ultimo.setSiguiente(cabeza);
            } else {
                int cedulaUltimo = convertirStringAEntero(ultimo.getDatos().getNúmero_de_Cedula_del_Paciente());
                if (cedulaPaciente > cedulaUltimo) {
                    // Paso 3: Insertar después del último
                    NodoC aux = new NodoC(p);
                    aux.setAtras(ultimo);
                    ultimo.setSiguiente(aux);
                    ultimo = aux;
                    ultimo.setSiguiente(cabeza);
                    cabeza.setAtras(ultimo);
                } else {
                    // Paso 4: Insertar en medio
                    NodoC aux = cabeza.getSiguiente();
                    while (convertirStringAEntero(aux.getDatos().getNúmero_de_Cedula_del_Paciente()) < cedulaPaciente) {
                        aux = aux.getSiguiente();
                    }

                    NodoC temp = new NodoC(p);
                    temp.setAtras(aux.getAtras());
                    temp.setSiguiente(aux);
                    aux.setAtras(temp);
                    temp.getAtras().setSiguiente(temp);
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

    @Override
    public String toString() {
        String respuesta = "Lista doble circular: \n";

        if (cabeza != null) {
            NodoC aux = cabeza;

            respuesta += aux.toString() + "\n";

            aux = aux.getSiguiente();

            while (aux != cabeza) {
                respuesta += aux.toString() + "\n";
                aux = aux.getSiguiente();
            }
        } else {
            respuesta += "Vacía";
        }

        return respuesta;
    }
}
    
    
    /*
     private NodoC cabeza;
     private NodoC ultimo;
    
    public void inserta(Paciente p)
    {
        //Paso 1, de la presentación
        if(cabeza == null)
        {
            cabeza = new NodoC(p);
            ultimo = cabeza;
            cabeza.setAtras(ultimo);
            cabeza.setSiguiente(ultimo);
            ultimo.setSiguiente(cabeza);
            ultimo.setAtras(cabeza);
        }
        else
        {
            //Paso 2, de la presentación
            if(cabeza.getDatos().getNúmero_de_Cedula_del_Paciente()> p.getNúmero_de_Cedula_del_Paciente())
            {
                NodoC aux = new NodoC(p);
                aux.setSiguiente(cabeza);
                cabeza.setAtras(aux);
                cabeza = aux;
                cabeza.setAtras(ultimo);
                ultimo.setSiguiente(cabeza);
            }
            else
            { 
                //Paso 3, de la presentación
                if(p.getNúmero_de_Cedula_del_Paciente()> ultimo.getDatos().getNúmero_de_Cedula_del_Paciente())
                {
                    NodoC aux = new NodoC(p);
                    aux.setAtras(ultimo);
                    ultimo.setSiguiente(aux);
                    ultimo = aux;
                    ultimo.setSiguiente(cabeza);
                    cabeza.setAtras(ultimo);
                }
                else
                {
                    //Paso 4, de la presentación
                    NodoC aux = cabeza.getSiguiente();
                    while(aux.getDatos().getNúmero_de_Cedula_del_Paciente() < p.getNúmero_de_Cedula_del_Paciente())
                    {
                        aux = aux.getSiguiente();
                    }
                    
                    NodoC temp = new NodoC(p);
                    temp.setAtras(aux.getAtras());
                    temp.setSiguiente(aux); //Acá aux.getAnterior está apuntando (en su siguiente) a aux
                    aux.setAtras(temp);
                    temp.getAtras().setSiguiente(temp);
                }
            }
        }
    }

    @Override
    public String toString() {
        String respuesta = "Lista doble circular: \n";
        
        if(cabeza != null)
        {
            NodoC aux = cabeza;
            
            respuesta += aux.toString() + "\n";
             
            aux = aux.getSiguiente();
            
            while(aux != cabeza)
            {
                respuesta += aux.toString() + "\n";
                aux = aux.getSiguiente();
            }
        }
        else
        {
            respuesta += "Vacía";
        }
        
        return respuesta;
    }
}
*/