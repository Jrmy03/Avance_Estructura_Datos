/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package av.avance_1;

/**
 *
 * @author Usuario
 */
public class ListaSimpleCircular {

    NodoC cabeza;
    NodoC ultimo;

    public void inserta(Paciente paciente) {
        if (cabeza == null) {
            cabeza = new NodoC();
            ultimo = cabeza;
            ultimo.setSiguiente(cabeza);
        } else {
            if (paciente.getNúmero_de_Cedula_del_Paciente() < cabeza.getDatos().getNúmero_de_Cedula_del_Paciente()) {
                //Insertamos al inicio
                NodoC auxiliar = new NodoC();
                auxiliar.setSiguiente(cabeza);
                cabeza = auxiliar;
                ultimo.setSiguiente(cabeza);
            } else {
                if (ultimo.getDatos().getNúmero_de_Cedula_del_Paciente() < paciente.getNúmero_de_Cedula_del_Paciente()) {
                    //Insertamos al final
                    NodoC auxiliar = new NodoC();
                    ultimo.setSiguiente(auxiliar);
                    ultimo = auxiliar;
                    ultimo.setSiguiente(cabeza);
                } else {
                    //Insertamos en el medio de la lista
                    NodoC auxiliar = cabeza;
                    while (auxiliar.getSiguiente().getDatos().getNúmero_de_Cedula_del_Paciente() < paciente.getNúmero_de_Cedula_del_Paciente()) {
                        auxiliar = auxiliar.getSiguiente();
                    }

                    NodoC temporal = new NodoC();
                    temporal.setSiguiente(auxiliar.getSiguiente());
                    auxiliar.setSiguiente(temporal);
                }
            }
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
