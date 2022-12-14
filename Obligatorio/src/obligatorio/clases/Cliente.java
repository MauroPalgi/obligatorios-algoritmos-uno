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

    private String nombre = "";
    private String rut;
    private int tel;
    private String direccion;
    private ListaDoble<Entrega> entregas = new ListaDoble<Entrega>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ListaDoble<Entrega> getEntregas() {
        return entregas;
    }

    public void setEntregas(ListaDoble<Entrega> entregas) {
        this.entregas = entregas;
    }

    public Cliente(String nombre, String rut, int tel, String direccion) {
        this.nombre = nombre;
        this.rut = rut;
        this.tel = tel;
        this.direccion = direccion;
    }

    public Cliente(String rut) {
        this.rut = rut;
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
        String text = "Cliente{" + "nombre=" + nombre + ", rut=" + rut + ", tel=" + tel + ", direccion=" + direccion;
        text += ", entregas realizadas vacias?" + entregas.esVacia();
        text += '}';
        return text;
    }

}
