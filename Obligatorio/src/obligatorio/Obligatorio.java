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

//        ListaDoble<Integer> listaTest = new ListaDoble<>();
        ListaDoble<Test> listaTest = new ListaDoble<>();
        Test inicio = new Test("inicio");
        Test medio = new Test("medio");
        Test medio2 = new Test("medio2");
        Test fin = new Test("fin");        
        // test 1
//        listaTest.mostrar();
//        listaTest.agregarFinal(inicio);        
//        listaTest.borrarInicio();        
//        listaTest.mostrar();
        // test 2
//        listaTest.agregarOrd(uno);
//        listaTest.agregarFinal(dos);
//        listaTest.agregarOrd(tres);
        // aca me da -1
        listaTest.agregarOrd(medio2);
        listaTest.agregarOrd(medio);
        listaTest.agregarOrd(inicio);
//        listaTest.mostrar();
//        listaTest.agregarOrd(medio);
        listaTest.agregarOrd(fin);
        listaTest.agregarOrd(medio);
        listaTest.agregarOrd(medio);
        listaTest.mostrar();
        //  aca me da positivo
//        listaTest.vaciar();
//        listaTest.agregarFinal(fin);
//        listaTest.agregarOrd(medio);
        
        
        
//        listaTest.borrarElemento(inicio);
//        listaTest.mostrar();
//        System.out.println("encontrado? - " + listaTest.buscarElemento(fin) );
//        if (listaTest.buscarElemento(fin)) {            
//            System.out.println("encontrado? - " + listaTest.obtenerElemento(fin).toString());
//        }
//        listaTest.borrarElemento(fin);
//        listaTest.mostrar();
//        System.out.println("encontrado? - " + listaTest.buscarElemento(fin) );
//        if (listaTest.buscarElemento(fin)) {            
//            System.out.println("encontrado? - " + listaTest.obtenerElemento(fin).toString());
//        }        
//        listaTest.borrarElemento(medio);
//        listaTest.mostrar();
//        System.out.println("encontrado? - " + listaTest.buscarElemento(fin));
//        if (listaTest.buscarElemento(fin)) {
//            System.out.println("encontrado? - " + listaTest.obtenerElemento(fin).toString());
//        }
//        
//        listaTest.borrarElemento(medio);
//        listaTest.mostrar();
//        listaTest.borrarElemento(fin);
//        listaTest.mostrar();
//        
//        listaTest.borrarFin();
//        listaTest.mostrar();

        // listaTest.agregarFinal(prueba);
        // listaTest.mostrar();
    }

}
