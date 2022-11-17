/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.clases;

/**
 *
 * @author mauro
 */
public class Caja implements Comparable<Caja> {

    private int numeroCaja = 0;
    static private int numeroCajaGlobal = 0;
    private Camion camion;
    private Producto producto;
    private int unidadesProducto;

    public int getUnidadesProducto() {
        return unidadesProducto;
    }

    public void setUnidadesProducto(int unidadesProducto) {
        this.unidadesProducto = unidadesProducto;
    }

    public Caja() {
        this.numeroCaja = Caja.numeroCajaGlobal;
        Caja.numeroCajaGlobal++;
    }

    public Caja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    public Caja(int numeroCaja, Camion camion, Producto producto, int unidadesProducto) {
        this.numeroCaja = numeroCaja;
        this.camion = camion;
        this.producto = producto;
        this.unidadesProducto = unidadesProducto;
    }

    @Override
    public String toString() {

        String text = "Caja{" + "numeroCaja=" + numeroCaja;
        if (camion != null) {
            text += ", camion=" + camion.toString();
        }
        if (camion != null) {
            text += ", producto=" + producto.toString();
        }
        text += ", unidadesProducto=" + unidadesProducto + '}';
        return text;
    }

    public int getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroCaja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.numeroCaja;
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
        final Caja other = (Caja) obj;
//        if (this.numeroCaja != 0 && this.camion != null && this.producto != null) {
//            System.out.println("aca");
//        }

        if (this.numeroCaja != other.numeroCaja) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Caja o) {
        return this.numeroCaja - o.numeroCaja;
    }

}
