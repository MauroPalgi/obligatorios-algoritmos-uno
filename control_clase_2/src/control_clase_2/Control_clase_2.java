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

        int[][] mat = {{4, 1, 6, 5}, {11, 3, 4, 4}, {7, 3, 12, 1}};
        // int[][] vv = {};
        // Utils.MostrarMatriz(v);
        // Utils.MostrarMatriz(vv);
        // Ejercicios.columnaMaxima(mat);
        Ejercicios.eliminarColDeMatriz(mat, 3);
        
    }

    /*
    Ejercicio 1
    Realizar un algoritmo que reciba una matriz y retorne la columna máxima (la columna 
    máxima es aquella cuya sumatoria de los números que la componen, es la mayor en 
    comparación con el resto de las columnas). En caso de haber más de una, retornar la 
    columna de menor número (índice).
     */
    public static void pruebaEjercicio1() {
        // Ejercicios.columnaMaxima(mat);
    }
    /*
    Ejercicio 2
    Realizar un algoritmo que reciba una matriz y un número de columna, y retorne una matriz 
    donde se eliminó dicha columna de la matriz.
    */
    public static void pruebaEjercicio2() {
    }
    /*
    Realizar un algoritmo que reciba una matriz de int (0 y 1) y complete las columnas y filas con 
    ceros, siempre que en la misma se encuentre un 0:
    */
    public static void pruebaEjercicio3() {
    }

}
