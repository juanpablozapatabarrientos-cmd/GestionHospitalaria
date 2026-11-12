
package grupo.gestionhospital.Modelo;

public class NodoArbol {

    private Paciente dato ;
    private NodoArbol izquierdoPtr;
    private NodoArbol derechoPtr;

    public NodoArbol(Paciente dato) {
        this.dato = dato;
        this.izquierdoPtr = null;
        this.derechoPtr = null;
    }

    public Paciente getDato() {
        return dato;
    }

    public void setDato(Paciente dato) {
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