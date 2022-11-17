/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

import utils.juegosTest;
import evaluacion.*;

/**
 *
 * @author maurp
 */
public class Obligatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        evaluacion.Obligatorio obligatorio = new evaluacion.Obligatorio();
        Prueba prueba = new Prueba();

        juegosTest.pruebasCreacionSistema_1(obligatorio, prueba);
        juegosTest.pruebasRegistroClientes(obligatorio, prueba);
        juegosTest.pruebasRegistroCamion(obligatorio, prueba);
        juegosTest.pruebasRegistroProducto(obligatorio, prueba);

    }

}
