/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.clases;

import java.util.Objects;

/**
 *
 * @author mauro
 */
public class Entrega implements Comparable<Entrega> {

    private boolean esPendiente = false;
    private Producto producto;
    private int cantUnidades = 0;

    public Entrega(Producto producto, boolean pendiente, int cantidad) {
        this.producto = producto;
        this.esPendiente = pendiente;
        this.cantUnidades = cantidad;
    }

    @Override
    public String toString() {
        return "Entrega{" + "esPendiente=" + esPendiente + ", producto=" + producto + ", cantUnidades=" + cantUnidades + '}';
    }

    public boolean isEsPendiente() {
        return esPendiente;
    }

    public void setEsPendiente(boolean esPendiente) {
        this.esPendiente = esPendiente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantUnidades() {
        return cantUnidades;
    }

    public void setCantUnidades(int cantUnidades) {
        this.cantUnidades = cantUnidades;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.esPendiente ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.producto);
        hash = 89 * hash + this.cantUnidades;
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
        final Entrega other = (Entrega) obj;
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public int compareTo(Entrega o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
