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
public interface ICola<T extends Comparable<T>> {

    public boolean esVacia();

    public void agregarInicio(T data);

    public void agregarFinal(T data);

    public void agregarOrd(T data);

    public void borrarInicio();

    public void borrarFin();

    public void borrarElemento(T data);

    // pensar como hacer cuando empieces a ver casos
    // de los metodos que tenes que hacer
    public boolean buscarElemento(T data);

    // same
    public NodoDoble<T> obtenerElemento(T data);

    public void vaciar();

    public void mostrar();

    public void mostrarREC(NodoDoble<T> inicio); // implementar recursivo

    public int cantElementos();

}
