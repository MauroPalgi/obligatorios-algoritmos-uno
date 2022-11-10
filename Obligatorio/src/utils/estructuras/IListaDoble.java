/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utils.estructuras;

/**
 *
 * @author alumnoFI
 * @param <T>
 */
public interface IListaDoble<T> {

    public boolean esVacia();

    public void agregarInicio(NodoDoble<T> nodo);

    public void agregarFinal(NodoDoble<T> nodo);

    public void agregarOrd(NodoDoble<T> nodo);

    public void borrarInicio();

    public void borrarFin();

    public void borrarElemento(NodoDoble<T> nodo);

    // pensar como hacer cuando empieces a ver casos
    // de los metodos que tenes que hacer
    public NodoDoble<T> buscarElemento(NodoDoble<T> data);
    // same
    public NodoDoble<T> obtenerElemento(NodoDoble<T> data);

    public void vaciar();

    public void mostrar();

    public void mostrarREC(NodoDoble<T> inicio); // implementar recursivo

    public int cantElementos();

}
