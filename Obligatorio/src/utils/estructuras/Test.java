/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.estructuras;

/**
 *
 * @author maurp
 */
public class Test {

    static private int idGlobal = 0;
    private int id;
    private String comment = "mauro";

    public Test() {
        this.id = Test.idGlobal;
        Test.idGlobal++;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Test other = (Test) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Test{" + "id=" + id + ", comment=" + comment + '}';
    }

}
