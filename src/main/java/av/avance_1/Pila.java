/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package av.avance_1;

/**
 *
 * @author Usuario
 */
public class Pila {

        private NodoP top; // cima.

        public Pila() {
            top = null;
        }

        public NodoP getTop() {
            return top;
        }

        public void setTop(NodoP top) {
            this.top = top;
        }

        public boolean esVacia() {
            if (this.top == null) {
                return true;
            } else {
                return false;
            }
        }

        public void push(String valor) {

            // pao 0: crear el Dato. Solo cuando la pila almacena clases de usuario.
            NodoP datoTemp = new NodoP();
            datoTemp.setInfo(info);

            // paso 1: Crear la cajita.
            NodoP temp = new NodoP();

            // paso 2: Le pongo un valor a la cajita.
            temp.setInfo(datoTemp);

            // 1. Escenario 1 cuando la pila esta vacía.
            if (esVacia()) {
                top = temp;// Mueve el top (que antes estaba en null) a la nueva cajita creada.
            } else {
                // 2. Escenario 2 es cuando la pila no esta vacia.
                temp.setAbajo(top);         // paso 2.1 Amarro la nueva caja al top.
                top = temp;                     // paso 2,2 muevo el top a la nueva caja.
            }

        }

        public void pop() {
            if (!esVacia()) {   // Si no esta vacia haga pop.
                top = top.getAbajo();// movemos el top al que esta despues.
            }
        }

        public String popRetorno() {
            NodoP nodoRetornar = new NodoP();
            if (!esVacia()) {  // Si no esta vacia haga pop.
                nodoRetornar = top;

                top = top.getAbajo();// movemos el top al que esta despues.
            }
            return nodoRetornar.getInfo().getnombre();
        }

        /**
         *
         * @return
         */
        public String toString() {
            String buffer = "";
            if (!esVacia()) {

                NodoP temp = top;
                while (temp != null) {
                    buffer = buffer + temp.getInfo().getnombre() + "\n";
                    temp = temp.getAbajo();
                }
            }
            return buffer;
        }
    }

