/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.estructuras;

/**
 *
 * @author mauro
 * @param <T>
 */
public class NodoCola<T extends Comparable<T>> {

    private T dato;
    private NodoCola<T> siguiente;
    static private int idGlobal = 0;
    private final int idNodoCola;

    public NodoCola(T t) {
        this.dato = t;
        this.siguiente = null;
        this.idNodoCola = idGlobal;
        NodoCola.idGlobal++;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoCola<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola<T> siguiente) {
        this.siguiente = siguiente;
    }

    public static int getIdGlobal() {
        return idGlobal;
    }

    public static void setIdGlobal(int idGlobal) {
        NodoCola.idGlobal = idGlobal;
    }

    @Override
    public String toString() {
        String text = "Nodo { dato = " + getDato().toString();
        if (getSiguiente() != null) {
            text += ", siguiente = {" + getSiguiente().getDato().toString() + " }";
        }
        text += " }\n";
        return text;
    }
}
