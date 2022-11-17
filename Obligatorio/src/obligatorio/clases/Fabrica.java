/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.clases;

import utils.estructuras.*;
import obligatorio.clases.*;

/**
 *
 * @author mauro
 */
public class Fabrica {

    private int capacidadCajas;
    private ListaDoble<Camion> listaCamiones = new ListaDoble<>();
    private ListaDoble<Cliente> listaClientes = new ListaDoble<>();
    private ListaDoble<Producto> listaProductos = new ListaDoble<>();
    private ListaDoble<Caja> listaCaja = new ListaDoble<>();

    public void setCapacidadCajas(int capacidadCajas) {
        this.capacidadCajas = capacidadCajas;
    }

    public int getCapacidadCajas() {
        return capacidadCajas;
    }

    public ListaDoble<Caja> getListaCaja() {
        return listaCaja;
    }

    public void setListaCaja(ListaDoble<Caja> listaCaja) {
        this.listaCaja = listaCaja;
    }

    public ListaDoble<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ListaDoble<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Fabrica(int capacidadCajas) {
        this.capacidadCajas = capacidadCajas;
    }

    public ListaDoble<Camion> getListaCamiones() {
        return listaCamiones;
    }

    public void setListaCamiones(ListaDoble<Camion> listaCamiones) {
        this.listaCamiones = listaCamiones;
    }

    public ListaDoble<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ListaDoble<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

}
