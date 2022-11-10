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
        NodoDoble<Test> inicio = new NodoDoble<>(new Test("inicio"));
        NodoDoble<Test> medio = new NodoDoble<>(new Test());
        NodoDoble<Test> fin = new NodoDoble<>(new Test("fin"));
        NodoDoble<Test> segundoFin = new NodoDoble<>(new Test("nuevo fin"));

        

        // test 1
//        listaTest.mostrar();
//        listaTest.agregarFinal(inicio);        
//        listaTest.borrarInicio();        
//        listaTest.mostrar();
        
        // test 2
        listaTest.agregarInicio(inicio);                
        listaTest.agregarInicio(inicio);                
        listaTest.mostrar();
        listaTest.borrarInicio();
        listaTest.mostrar();
//        
//        listaTest.borrarFin();
//        listaTest.mostrar();

        // listaTest.agregarFinal(prueba);
        // listaTest.mostrar();
    }

}
