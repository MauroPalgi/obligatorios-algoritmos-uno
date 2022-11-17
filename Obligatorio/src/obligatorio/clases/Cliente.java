/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.clases;

import java.util.Objects;
import utils.estructuras.*;

/**
 *
 * @author mauro
 */
public class Cliente implements Comparable<Cliente> {

    private String nombre;
    private String rut;
    private int tel;
    private String direccion;
    private ListaDoble<Envio> entregas = new ListaDoble<Envio>();

    public Cliente(String nombre, String rut, int tel, String direccion) {
        this.nombre = nombre;
        this.rut = rut;
        this.tel = tel;
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.rut);
        hash = 71 * hash + this.tel;
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.rut, other.rut)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Cliente o) {
        return this.nombre.compareTo(o.nombre);
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", rut=" + rut + ", tel=" + tel + ", direccion=" + direccion + '}';
    }

}
