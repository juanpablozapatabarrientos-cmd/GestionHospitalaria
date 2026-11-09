
package grupo.gestionhospital;


public class Arbol {
     private NodoArbol raizPtr;

    public Arbol() {
        raizPtr = null;
    }

    public boolean esVacio() {
        return raizPtr == null;
    }

    public NodoArbol regresaRaiz() {
        return raizPtr;
    }


    public void insertarNodo(int valor) {
        raizPtr = insertarNodo(valor, raizPtr);
    }

    private NodoArbol insertarNodo(int valor, NodoArbol nodoPtr) {

        if (nodoPtr == null) {
            nodoPtr = new NodoArbol(valor);
        } else if (valor < nodoPtr.getDato()) {
            nodoPtr.setIzquierdoPtr(
                    insertarNodo(valor, nodoPtr.getIzquierdoPtr())
            );
        } else if (valor > nodoPtr.getDato()) {
            nodoPtr.setDerechoPtr(
                    insertarNodo(valor, nodoPtr.getDerechoPtr())
            );
        } else {
            System.out.println("El valor " + valor + " ya existe en el árbol.");
        }

        return nodoPtr;
    }

    public void muestraAcostado() {
        muestraAcostado(0, raizPtr);
    }

    private void muestraAcostado(int nivel, NodoArbol nodoPtr) {

        if (nodoPtr == null) {
            return;
        }

        muestraAcostado(nivel + 1, nodoPtr.getDerechoPtr());

        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }

        System.out.println(nodoPtr.getDato());

        muestraAcostado(nivel + 1, nodoPtr.getIzquierdoPtr());
    }

    public void inOrden() {
        inOrden(raizPtr);
        System.out.println();
    }

    private void inOrden(NodoArbol nodoPtr) {

        if (nodoPtr == null) {
            return;
        }

        inOrden(nodoPtr.getIzquierdoPtr());
        System.out.print(nodoPtr.getDato() + " - ");
        inOrden(nodoPtr.getDerechoPtr());
    }


    public void preOrden() {
        preOrden(raizPtr);
        System.out.println();
    }

    private void preOrden(NodoArbol nodoPtr) {

        if (nodoPtr == null) {
            return;
        }

        System.out.print(nodoPtr.getDato() + " - ");
        preOrden(nodoPtr.getIzquierdoPtr());
        preOrden(nodoPtr.getDerechoPtr());
    }

    public void postOrden() {
        postOrden(raizPtr);
        System.out.println();
    }

    private void postOrden(NodoArbol nodoPtr) {

        if (nodoPtr == null) {
            return;
        }

        postOrden(nodoPtr.getIzquierdoPtr());
        postOrden(nodoPtr.getDerechoPtr());
        System.out.print(nodoPtr.getDato() + " - ");
    }

    public boolean busqueda(int x) {
        return busqueda(x, raizPtr);
    }

    private boolean busqueda(int x, NodoArbol nodoPtr) {

        if (nodoPtr == null) {
            return false;
        } else if (x < nodoPtr.getDato()) {
            return busqueda(x, nodoPtr.getIzquierdoPtr());
        } else if (x > nodoPtr.getDato()) {
            return busqueda(x, nodoPtr.getDerechoPtr());
        } else {
            return true;
        }
    }

    public NodoArbol buscaMenor() {
        return buscaMenor(raizPtr);
    }

    private NodoArbol buscaMenor(NodoArbol nodoPtr) {

        if (nodoPtr == null) {
            return null;
        } else if (nodoPtr.getIzquierdoPtr() == null) {
            return nodoPtr;
        } else {
            return buscaMenor(nodoPtr.getIzquierdoPtr());
        }
    }

    public NodoArbol buscaMayor() {
        return buscaMayor(raizPtr);
    }

    private NodoArbol buscaMayor(NodoArbol nodoPtr) {

        if (nodoPtr == null) {
            return null;
        } else if (nodoPtr.getDerechoPtr() == null) {
            return nodoPtr;
        } else {
            return buscaMayor(nodoPtr.getDerechoPtr());
        }
    }

    public void eliminarPredecesor(int x) {
        raizPtr = eliminarPredecesor(x, raizPtr);
    }

    private NodoArbol eliminarPredecesor(int x, NodoArbol nodoPtr) {

        if (nodoPtr == null) {
            System.out.println("El valor " + x + " no existe en el árbol.");
            return null;
        }

        if (x < nodoPtr.getDato()) {
            nodoPtr.setIzquierdoPtr(
                    eliminarPredecesor(x, nodoPtr.getIzquierdoPtr())
            );
        } else if (x > nodoPtr.getDato()) {
            nodoPtr.setDerechoPtr(
                    eliminarPredecesor(x, nodoPtr.getDerechoPtr())
            );
        } else {

            // Caso 1: nodo hoja
            if (nodoPtr.getIzquierdoPtr() == null && nodoPtr.getDerechoPtr() == null) {
                return null;
            }

            // Caso 2: solo tiene hijo derecho
            if (nodoPtr.getIzquierdoPtr() == null) {
                return nodoPtr.getDerechoPtr();
            }

            // Caso 2: solo tiene hijo izquierdo
            if (nodoPtr.getDerechoPtr() == null) {
                return nodoPtr.getIzquierdoPtr();
            }

            // Caso 3: tiene dos hijos
            // Se busca el predecesor: mayor del subárbol izquierdo
            NodoArbol predecesor = buscaMayor(nodoPtr.getIzquierdoPtr());

            nodoPtr.setDato(predecesor.getDato());

            nodoPtr.setIzquierdoPtr(
                    eliminarPredecesor(predecesor.getDato(), nodoPtr.getIzquierdoPtr())
            );
        }

        return nodoPtr;
    }

    public void eliminarSucesor(int x) {
        raizPtr = eliminarSucesor(x, raizPtr);
    }

    private NodoArbol eliminarSucesor(int x, NodoArbol nodoPtr) {

        if (nodoPtr == null) {
            System.out.println("El valor " + x + " no existe en el árbol.");
            return null;
        }

        if (x < nodoPtr.getDato()) {
            nodoPtr.setIzquierdoPtr(
                    eliminarSucesor(x, nodoPtr.getIzquierdoPtr())
            );
        } else if (x > nodoPtr.getDato()) {
            nodoPtr.setDerechoPtr(
                    eliminarSucesor(x, nodoPtr.getDerechoPtr())
            );
        } else {

            // Caso 1: nodo hoja
            if (nodoPtr.getIzquierdoPtr() == null && nodoPtr.getDerechoPtr() == null) {
                return null;
            }

            // Caso 2: solo tiene hijo derecho
            if (nodoPtr.getIzquierdoPtr() == null) {
                return nodoPtr.getDerechoPtr();
            }

            // Caso 2: solo tiene hijo izquierdo
            if (nodoPtr.getDerechoPtr() == null) {
                return nodoPtr.getIzquierdoPtr();
            }

            // Caso 3: tiene dos hijos
            // Se busca el sucesor: menor del subárbol derecho
            NodoArbol sucesor = buscaMenor(nodoPtr.getDerechoPtr());

            nodoPtr.setDato(sucesor.getDato());

            nodoPtr.setDerechoPtr(
                    eliminarSucesor(sucesor.getDato(), nodoPtr.getDerechoPtr())
            );
        }

        return nodoPtr;
    }

    public void podarArbol() {
        raizPtr = podarArbol(raizPtr);
    }

    private NodoArbol podarArbol(NodoArbol nodoPtr) {

        if (nodoPtr == null) {
            return null;
        }

        nodoPtr.setIzquierdoPtr(
                podarArbol(nodoPtr.getIzquierdoPtr())
        );

        nodoPtr.setDerechoPtr(
                podarArbol(nodoPtr.getDerechoPtr())
        );

        return null;
    }
    
}
