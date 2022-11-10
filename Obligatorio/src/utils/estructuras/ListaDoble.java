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
public class ListaDoble<T> implements IListaDoble {
    
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
    public boolean esVacia() { // good
        return this.cantidad == 0;
    }
    
    @Override
    public void agregarInicio(NodoDoble nodo) {
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
    public void agregarFinal(NodoDoble nodo) { // TODO: VER ESTO        
        if (this.esVacia()) {
            agregarInicio(nodo);
            setFin(nodo);
        } else {
            NodoDoble aux = this.getFin();
            this.getFin().getAnterior().setSiguiente(aux);
            this.setFin(nodo);
            aux.setSiguiente(this.getFin());            
            this.getFin().setAnterior(aux);
            cantidad++;
        }
    }
    
    @Override
    public void agregarOrd(NodoDoble t) { // TODO UTILIZAR https://www.geeksforgeeks.org/insertion-sort-doubly-linked-list/
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void borrarInicio() {
        if (!this.esVacia()) {
            if (cantidad == 1) {
                fin = null;
            }
            this.inicio = getInicio().getSiguiente();
            this.inicio.setAnterior(null);
            cantidad--;
        } else {
            System.out.println("Esta vacia");
        }
    }
    
    @Override
    public void borrarFin() {
        if (!this.esVacia()) {
            if (cantidad == 1) {
                inicio = null;
                fin = inicio;
            } else {
                NodoDoble actual = getInicio();
                NodoDoble siguiente = getInicio().getSiguiente();
                
                while (siguiente.getSiguiente() != null) {
                    actual = siguiente;
                    siguiente = siguiente.getSiguiente();
                }
                actual.setSiguiente(null);
                fin = actual;
            }
            cantidad--;
        }
    }
    
    @Override
    public void borrarElemento(NodoDoble data) {
        if (!this.esVacia()) {
            if (inicio.getDato().equals(data)) {
                borrarInicio();
            } else {
                if (getFin().getDato().equals(data)) {
                    borrarFin();
                } else {
                    NodoDoble<T> aux = inicio;
                    while (aux.getSiguiente() != null && !aux.getSiguiente().getDato().equals(data)) {
                        aux = aux.getSiguiente();
                    }
                    if (aux.getSiguiente() != null) {
                        NodoDoble<T> aBorrar = aux.getSiguiente();
                        aux.setSiguiente(aBorrar.getSiguiente());
                        aBorrar.setSiguiente(null);
                        cantidad--;
                    }
                }
            }
        }
    }
    
    @Override
    public NodoDoble<T> buscarElemento(NodoDoble data) {
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
    public NodoDoble obtenerElemento(NodoDoble data) {
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
    public void vaciar() {
        this.inicio = null;
        this.fin = null;
        this.cantidad = 0;
    }
    
    @Override
    public void mostrar() {
        NodoDoble<T> actual = getInicio();
        System.out.println("" + actual.toString());
        System.out.println("" + actual.toString());
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
    public int cantElementos() {
        return this.cantidad;
    }
    
}
