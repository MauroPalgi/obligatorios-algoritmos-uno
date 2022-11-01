/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utils.estructuras;

/**
 *
 * @author alumnoFI
 */
public interface IListaDoble<T> {

    public boolean esVacia();

    public void agregarInicio(NodoDoble<T> data);

    public void agregarFinal(NodoDoble<T> data);

    public void agregarOrd(NodoDoble<T> t);

    public void borrarInicio();

    public void borrarFin();

    public void borrarElemento(NodoDoble<T> data);

    public boolean buscarelemento(NodoDoble<T> data);

    public NodoDoble<T> obtenerElemento(NodoDoble<T> data);

    public void vaciar();

    public void mostrar();

    public void mostrarREC(NodoDoble<T> inicio); // implementar recursivo

    public int cantElementos();

}
