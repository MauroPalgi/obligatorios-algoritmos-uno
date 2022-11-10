/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.estructuras;

/**
 *
 * @author alumnoFI
 */
public class NodoDoble<T> {

    private T dato;
    private NodoDoble<T> siguiente;
    private NodoDoble<T> anterior;
    static private int idGlobal = 0;
    private int id;

    public NodoDoble(T t) {
        this.dato = t;
        this.siguiente = null;
        this.anterior = null;
        this.id = idGlobal;
        NodoDoble.idGlobal++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoDoble<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble<T> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble<T> anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        String text = "Nodo{ dato =" + getDato().toString();
//        if (getSiguiente() != null) {
//            text += ", siguiente=" + getSiguiente();
//        }
//        if (getAnterior() != null) {
//            text += ", anterior=" + getAnterior();
//        }
        text += " }";
        return text;
    }

}
