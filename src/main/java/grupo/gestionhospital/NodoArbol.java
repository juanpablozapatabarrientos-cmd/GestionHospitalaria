
package grupo.gestionhospital;

public class NodoArbol {

    private int dato;
    private NodoArbol izquierdoPtr;
    private NodoArbol derechoPtr;

    public NodoArbol(int dato) {
        this.dato = dato;
        this.izquierdoPtr = null;
        this.derechoPtr = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoArbol getIzquierdoPtr() {
        return izquierdoPtr;
    }

    public void setIzquierdoPtr(NodoArbol izquierdoPtr) {
        this.izquierdoPtr = izquierdoPtr;
    }

    public NodoArbol getDerechoPtr() {
        return derechoPtr;
    }

    public void setDerechoPtr(NodoArbol derechoPtr) {
        this.derechoPtr = derechoPtr;
    }
}