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
public class Camion implements Comparable<Camion> {

    private String matricula;
    private int toneladaMaxSoportada;
    private ListaDoble<Entrega> entregasRealizadas = new ListaDoble<>();
    private ListaDoble<Entrega> entregasPendientes = new ListaDoble<>();

    public int getToneladaMaxSoportada() {
        return toneladaMaxSoportada;
    }

    public void setToneladaMaxSoportada(int toneladaMaxSoportada) {
        this.toneladaMaxSoportada = toneladaMaxSoportada;
    }

    public ListaDoble<Entrega> getEntregasRealizadas() {
        return entregasRealizadas;
    }

    public void setEntregasRealizadas(ListaDoble<Entrega> entregasRealizadas) {
        this.entregasRealizadas = entregasRealizadas;
    }

    public ListaDoble<Entrega> getEntregasPendientes() {
        return entregasPendientes;
    }

    public void setEntregasPendientes(ListaDoble<Entrega> entregasPendientes) {
        this.entregasPendientes = entregasPendientes;
    }

    public Camion(String matricula, int toneladaMaxSoportada) {
        this.matricula = matricula;
        this.toneladaMaxSoportada = toneladaMaxSoportada;
    }

    public Camion(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.matricula);
        hash = 89 * hash + this.toneladaMaxSoportada;
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
        final Camion other = (Camion) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String text = "Camion{" + "matricula=" + matricula + ", toneladaMaxSoportada=" + toneladaMaxSoportada;
        text += "entregas realizadas es vacia ?" + entregasRealizadas.esVacia();
        text += "entregas pendientes es vacia ?" + entregasPendientes.esVacia();
        text += '}';
        return text;
    }

    @Override
    public int compareTo(Camion o) {
        return this.matricula.compareTo(o.matricula);

    }
}
