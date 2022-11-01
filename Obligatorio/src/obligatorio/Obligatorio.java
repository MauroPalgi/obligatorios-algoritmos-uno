/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

import utils.*;
import utils.estructuras.ListaDoble;
import utils.estructuras.NodoDoble;
import utils.estructuras.Test;

/**
 *
 * @author maurp
 */
public class Obligatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ListaDoble<Test> listaTest = new ListaDoble<>();
        NodoDoble<Test> prueba = new NodoDoble<>(new Test());
        listaTest.setInicio(prueba);
        System.out.println(">|" + listaTest.getInicio().getDato().toString());
        NodoDoble<Test> prueba1 = new NodoDoble<>(new Test());
        NodoDoble<Test> prueba2 = new NodoDoble<>(new Test());
        System.out.println(prueba.getDato().toString());
        System.out.println(prueba1.getDato().toString());
        System.out.println(prueba2.getDato().toString());

    }

}
