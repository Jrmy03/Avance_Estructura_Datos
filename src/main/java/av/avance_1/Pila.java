
package av.avance_1;


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

        public void push(NodoP nuevoNodo) {
                    // 1. Escenario 1 es cuando la pila esta vacia.
            if (esVacia()) {
                top = nuevoNodo;// Mueve el top (que antes estaba en null) a la nueva cajita creada.
            } else {
                // 2. Escenario 2 es cuando la pila no esta vacia.
                nuevoNodo.setAbajo(top); // paso 2.1 Amarro la nueva caja al top.
                top = nuevoNodo;              // paso 2,2 muevo el top a la nueva caja.
            }

        }

        public void pop() {
            if (!esVacia()) {   // Si no esta vacia haga pop.
                top = top.getAbajo();// movemos el top al que esta despues.
            }
        }
                /*                                                
        public String popRetorno(NodoP nodoRetornar) {
            if (!esVacia()) {  // Si no esta vacia haga pop.
                nodoRetornar = top;

                top = top.getAbajo();// movemos el top al que esta despues.
            }
            return nodoRetornar.getQuejas();
        */

        
            
            
        
    }

