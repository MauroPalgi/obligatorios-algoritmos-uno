/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.clases;

import java.util.Objects;
import utils.estructuras.ListaDoble;

/**
 *
 * @author mauro
 */
public class Producto implements Comparable<Producto> {

    private String nombre;
    private String descripcion;
    private int idProducto;
    static public int idGlobal = 0;
    private int stockEnFabrica = 0;
    private ListaDoble<Caja> listaCaja = new ListaDoble<>();

    public int getStockEnFabrica() {
        return stockEnFabrica;
    }

    public void setStockEnFabrica(int stockEnFabrica) {
        this.stockEnFabrica = stockEnFabrica;
    }

    public ListaDoble<Caja> getListaCaja() {
        return listaCaja;
    }

    public void setListaCaja(ListaDoble<Caja> listaCaja) {
        this.listaCaja = listaCaja;
    }

    public Producto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idProducto = Producto.idGlobal;
        Producto.idGlobal++;
    }

    // para poder buscarlo
//    public Producto(String nombre) {
//        this.nombre = nombre;
//        this.idProducto = Producto.idGlobal;
//        Producto.idGlobal++;
//    }
    public Producto(int id) {
        this.idProducto = id;
    }

    @Override
    public int compareTo(Producto o) {
        return this.nombre.compareTo(o.nombre);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + this.idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.nombre.compareTo(other.nombre) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String text = "Producto{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", idProducto=" + idProducto + ", stockEnFabrica=" + stockEnFabrica;
        text += ", listaCaja es vacia?=" + listaCaja.esVacia() + '}';
        return text;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
