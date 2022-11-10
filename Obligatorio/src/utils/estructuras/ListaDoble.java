/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.estructuras;

/**
 *
 * @author x786412
 * @param <T>
 */
public class ListaDoble<T> implements IListaDoble<T> {

    private NodoDoble<T> inicio;
    private NodoDoble<T> fin;
    private int cantidad;

    public NodoDoble getInicio() {
        return inicio;
    }

    public void setInicio(NodoDoble<T> inicio) {
        this.inicio = inicio;
    }

    public NodoDoble getFin() {
        return fin;
    }

    public void setFin(NodoDoble<T> fin) {
        this.fin = fin;
    }

    @Override
    public boolean esVacia() { // GOOD
        return this.cantidad == 0;
    }

    @Override
    public void agregarInicio(T data) { // GOOD 
        NodoDoble<T> nodo = new NodoDoble<>(data);
        if (esVacia()) {
            this.inicio = nodo;
            this.fin = inicio;
        } else {
            nodo.setSiguiente(this.getInicio());
            nodo.getSiguiente().setAnterior(nodo);
            this.inicio = nodo;
        }
        cantidad++;
    }

    @Override
    public void agregarFinal(T data) { // GOOD 
        NodoDoble<T> nodo = new NodoDoble<>(data);
        if (this.esVacia()) {
            agregarInicio(data);
            setFin(nodo);
        } else {
            // copio valor final y borro el valor anterior
            NodoDoble aux = this.getFin();
            this.setFin(null);

            // seteo al nuevo final el valor anterior como el anterior final
            // que tengo en el auxiliar
            nodo.setAnterior(aux);
            // seteo el final el nuevo final
            this.setFin(nodo);
            // le coloco al siguiente el valor del mismo
            aux.setSiguiente(this.getFin());
            cantidad++;
        }
    }

    @Override
    public void agregarOrd(T data) { // TODO UTILIZAR https://www.geeksforgeeks.org/insertion-sort-doubly-linked-list/
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarInicio() { // GOOD 
        if (!this.esVacia()) {
            if (cantidad == 1) {
                setFin(null);
                setInicio(null);
            } else {
                NodoDoble aux = getInicio().getSiguiente();
                setInicio(null);
                setInicio(aux);
                this.inicio.setAnterior(null);
            }

            cantidad--;
        } else {
            System.out.println("Esta vacia");
        }
    }

    @Override
    public void borrarFin() { // GOOD
        if (!this.esVacia()) {
            if (cantidad == 1) {
                setFin(null);
                setInicio(null);
            } else {
                NodoDoble<T> aux = this.getFin().getAnterior();
                this.setFin(null);
                aux.setSiguiente(null);
                this.setFin(aux);
            }
            cantidad--;
        }
    }

    @Override
    public void borrarElemento(T data) { // GOOD
        if (!this.esVacia()) {
            NodoDoble<T> actual = getInicio();

            while (actual != null) {

                if (actual.getDato().equals(data)) {

                    NodoDoble<T> nodoSiguiente = actual.getSiguiente();
                    NodoDoble<T> nodoAnterior = actual.getAnterior();
                    if (nodoSiguiente != null && nodoAnterior != null) {
                        nodoAnterior.setSiguiente(nodoSiguiente);
                        nodoSiguiente.setAnterior(nodoAnterior);
                        System.out.println("anterior -> " + nodoAnterior.toString());
                        System.out.println("siguiente -> " + nodoSiguiente.toString());
                        cantidad--;
                    }
                }
                if (inicio.getDato().equals(data)) {
                    borrarInicio();
                }
                if (getFin().getDato().equals(data)) {
                    borrarFin();
                }

                actual = actual.getSiguiente();

            }

        } else {
            System.out.println("La Lista esta Vacia");
        }

    }

    @Override
    public NodoDoble<T> buscarElemento(T data) {
        NodoDoble<T> ret = null;

        if (!this.esVacia()) {
            if (inicio.getDato().equals(data)) {
                ret = inicio;
            } else {
                if (getFin().getDato().equals(data)) {
                    ret = getFin();
                } else {
                    NodoDoble actual = getInicio();
                    boolean encontre = false;
                    while (actual != null && !encontre) {
                        if (actual.getDato().equals(data)) {
                            ret = actual;
                            encontre = true;
                        }
                        actual = actual.getSiguiente();
                    }
                }
            }
        }
        return ret;
    }

    @Override
    public NodoDoble obtenerElemento(T data) {
        NodoDoble<T> ret = null;
        if (!this.esVacia()) {
            if (inicio.getDato().equals(data)) {
                ret = inicio;
            } else {
                if (getFin().getDato().equals(data)) {
                    ret = getFin();
                } else {
                    NodoDoble actual = getInicio();
                    boolean encontre = false;
                    while (actual != null && !encontre) {
                        if (actual.getDato().equals(data)) {
                            ret = actual;
                            encontre = true;
                        }
                        actual = actual.getSiguiente();
                    }
                }
            }
        }
        return ret;
    }

    @Override
    public void vaciar() { // GOOD
        this.inicio = null;
        this.fin = null;
        this.cantidad = 0;
    }

    @Override
    public void mostrar() { // GOOD
        NodoDoble<T> actual = getInicio();
        if (actual != null) {
            System.out.println("Lista Nodos{ \n inicio: " + getInicio().getDato().toString() + ";\n fin: " + getFin().getDato().toString() + ";\n cantidad elementos: " + this.cantidad + " \n= [");
            while (actual != null) {
                System.out.print(actual.toString() + "  ");
                actual = actual.getSiguiente();
            }
            System.out.println("\n ]}");
        } else {
            System.out.println("La lista esta vacia");
        }
        System.out.println("");
    }

    @Override
    public void mostrarREC(NodoDoble inicio) { // TODO!
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantElementos() { // GOOD
        return this.cantidad;
    }

}
