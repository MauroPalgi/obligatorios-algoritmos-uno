/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control_clase_2;

import helper.Utils;
import ejercicio.Ejercicios;

/**
 *
 * @author maurp
 */
public class Control_clase_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JuegosDePrueba();

    }

    public static void JuegosDePrueba() {
        // EJERCICIO 1
        // pre: la matriz debe estar completa
        // pos: se devuelve un entero representando la columna maxima
        Prueba prueba = new Prueba();
        prueba.tituloPrueba("Testeo Ejercicio - 1 ");
        // Matriz con una sola columna maxima
        int[][] mat1 = {{2, 1, 10, 5}, {11, 3, 0, 4}, {7, 3, 12, 0}};
        // Matriz con dos columnas maximas 1 y 2
        int[][] mat2 = {{1, 12, 6, 5}, {5, 3, 0, 4}, {7, 3, 12, 0}};
        var retorno1 = pruebaEjercicio1(mat1);
        var retorno2 = pruebaEjercicio1(mat2);
        prueba.ver(retorno1, Retorno.Resultado.OK, "Se espera columna 2 como maxima sumatoria de columnas", "Entero");
        prueba.ver(retorno2, Retorno.Resultado.OK, "Se espera columna 1 como maxima sumatoria de columnas", "Entero");
        prueba.finPrueba("Fin Testeo Ejercicio - 1 ");

        // EJERCICIO 2
        // pre: matriz completa, 
        // col es un valor entero positivo y dentro de la cantidad de columnas existentes
        // pos: se devuelve una matriz en forma de String
        prueba.tituloPrueba("Testeo Ejercicio - 2 ");
        var retorno3 = pruebaEjercicio2(mat2, 0);
        var retorno4 = pruebaEjercicio2(mat2, 3);
        System.out.println("------------------------- Matriz a utilizar -------------------------");
        System.out.println(Utils.StringMatriz(mat2));
        System.out.println("---------------------------------------------------------------------");

        prueba.ver(retorno3, Retorno.Resultado.OK, "Se elimina columna 0 , Se espera {{12,6,5}{3,0,4}{3,12,0}", "String");
        prueba.ver(retorno4, Retorno.Resultado.OK, "Se elimina columna 3 , Se espera {{1,12,6}{5,3,0}{7,3,12}}", "String");
        prueba.finPrueba("Fin Testeo Ejercicio - 2 ");

        // EJERCICIO 3
        // pre: matriz completa con 1 y 0
        // pos: se devuelve una matriz en forma de String
        int[][] matMostrar = {{1, 1, 1, 0, 1}, {1, 1, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 1}};
        int[][] mat3 = {{1, 1, 1, 0, 1}, {1, 1, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 1}};
        prueba.tituloPrueba("Testeo Ejercicio - 3 ");
        var retorno5 = pruebaEjercicio3(mat3);
        System.out.println("------------------------- Matriz a utilizar -------------------------");
        System.out.println(Utils.StringMatriz(matMostrar));
        System.out.println("---------------------------------------------------------------------");
        prueba.ver(retorno5, Retorno.Resultado.OK, "Se espera {{1,0,1,0,1} {1,0,1,0,1} {1,0,1,0,1} {1,0,1,0,1} {1,0,1,0,1}}", "String");
        prueba.finPrueba("Fin Testeo Ejercicio - 3 ");

        prueba.imprimirResultadosPrueba();
    }

    /*
    Ejercicio 1
    Realizar un algoritmo que reciba una matriz y retorne la columna máxima (la columna 
    máxima es aquella cuya sumatoria de los números que la componen, es la mayor en 
    comparación con el resto de las columnas). En caso de haber más de una, retornar la 
    columna de menor número (índice).
     */
    public static Retorno pruebaEjercicio1(int[][] mat) {
        Retorno retorno = new Retorno(Retorno.Resultado.OK);
        retorno.setValorEntero(Ejercicios.columnaMaxima(mat));
        return retorno;

    }

    /*
    Ejercicio 2
    Realizar un algoritmo que reciba una matriz y un número de columna, y retorne una matriz 
    donde se eliminó dicha columna de la matriz.
     */
    public static Retorno pruebaEjercicio2(int[][] mat, int col) {
        Retorno retorno = new Retorno(Retorno.Resultado.OK);
        int[][] matrizResultado = Ejercicios.eliminarColDeMatriz(mat, col);
        retorno.setValorString(Utils.StringMatriz(matrizResultado));
        return retorno;
    }

    /*
    Realizar un algoritmo que reciba una matriz de int (0 y 1) y complete las columnas y filas con 
    ceros, siempre que en la misma se encuentre un 0:
     */
    public static Retorno pruebaEjercicio3(int[][] mat) {
        Retorno retorno = new Retorno(Retorno.Resultado.OK);
        int[][] matrizResultado = Ejercicios.completarMatrizConCeros(mat);
        retorno.setValorString(Utils.StringMatriz(matrizResultado));
        return retorno;
    }

}
