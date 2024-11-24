/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package av.avance_1;

/**
 *
 * @author Usuario
 */
public class ListaDobleCircular {
    
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
