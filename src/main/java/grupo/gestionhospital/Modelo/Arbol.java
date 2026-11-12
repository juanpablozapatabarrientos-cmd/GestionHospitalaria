
package grupo.gestionhospital.Modelo;

import grupo.gestionhospital.Modelo.NodoArbol;


public class Arbol {
     private NodoArbol raizPtr;
     private Paciente ultimoEncontrado; //para que cuando encuentre algo en 
                                        //la opcion 3 del menu se pueda mostrar 
                                        //los datos del encontrado

    public Arbol() {
        raizPtr = null;
    }

    public boolean esVacio() {
        return raizPtr == null;
    }

    public NodoArbol regresaRaiz() {
        return raizPtr;
    }


    public void insertarNodo(Paciente paciente) {
        raizPtr = insertarNodo(paciente , raizPtr);
    }

    private NodoArbol insertarNodo(Paciente paciente, NodoArbol nodoPtr) {

        if (nodoPtr == null) {
            nodoPtr = new NodoArbol(paciente);
        } else if (paciente.getIdPaciente() < nodoPtr.getDato().getIdPaciente()) {
            nodoPtr.setIzquierdoPtr(
                    insertarNodo(paciente, nodoPtr.getIzquierdoPtr())
            );
        } else if (paciente.getIdPaciente() > nodoPtr.getDato().getIdPaciente()) {
            nodoPtr.setDerechoPtr(
                    insertarNodo(paciente, nodoPtr.getDerechoPtr())
            );
        } else {
            System.out.println("El paciente con ID: " + paciente.getIdPaciente() + "ya existe en el arbol.");
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

    public boolean busqueda(int id) {
        ultimoEncontrado = null;
        return busqueda(id , raizPtr);
        
    }

    private boolean busqueda(int id , NodoArbol nodoPtr) {

        if (nodoPtr == null) {
            return false;
        } else if (id  < nodoPtr.getDato().getIdPaciente()) {
            return busqueda(id , nodoPtr.getIzquierdoPtr());
        } else if (id > nodoPtr.getDato().getIdPaciente()) {
            return busqueda(id , nodoPtr.getDerechoPtr());
        } else {
            this.ultimoEncontrado = nodoPtr.getDato();
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

    public void eliminarPredecesor(Paciente paciente) {
        raizPtr = eliminarPredecesor(paciente , raizPtr);
    }

    private NodoArbol eliminarPredecesor(Paciente paciente, NodoArbol nodoPtr) {

        if (nodoPtr == null) {
            System.out.println("El Id " + paciente.getIdPaciente() + " no existe en el árbol.");
            return null;
        }

        if (paciente.getIdPaciente() < nodoPtr.getDato().getIdPaciente()) {
            nodoPtr.setIzquierdoPtr(
                    eliminarPredecesor(paciente , nodoPtr.getIzquierdoPtr())
            );
        } else if (paciente.getIdPaciente() > nodoPtr.getDato().getIdPaciente()) {
            nodoPtr.setDerechoPtr(
                    eliminarPredecesor(paciente , nodoPtr.getDerechoPtr())
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

    public void eliminarSucesor(Paciente paciente) {
        raizPtr = eliminarSucesor(paciente , raizPtr);
    }

    private NodoArbol eliminarSucesor(Paciente paciente, NodoArbol nodoPtr) {

        if (nodoPtr == null) {
            System.out.println("El Id " + paciente.getIdPaciente() + " no existe en el árbol.");
            return null;
        }

        if (paciente.getIdPaciente() < nodoPtr.getDato().getIdPaciente()) {
            nodoPtr.setIzquierdoPtr(
                    eliminarSucesor(paciente , nodoPtr.getIzquierdoPtr())
            );
        } else if (paciente.getIdPaciente() > nodoPtr.getDato().getIdPaciente()) {
            nodoPtr.setDerechoPtr(
                    eliminarSucesor(paciente , nodoPtr.getDerechoPtr())
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

    public Paciente getUltimoEncontrado() {
        return ultimoEncontrado;
    }
    
    
    
}
