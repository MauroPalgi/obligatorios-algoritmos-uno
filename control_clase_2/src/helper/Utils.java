/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author maurp
 */
public class Utils {

    static public String StringMatriz(int[][] mat) {
        String texto = "{ empty }";
        if (mat.length == 0) {
            return texto;
        }
        texto = "\n{";
        for (int fila = 0; fila < mat.length; fila++) {
            int[] arregloFila = mat[fila];
            texto += StringArreglo(arregloFila, true);
        }
        texto += "\n}";
        return texto;
    }

    static public String StringArreglo(int[] arr, boolean tab) {
        String texto = tab ? "\n  {" : "\n{";
        for (int i = 0; i < arr.length; i++) {
            int celda = arr[i];
            if (i == arr.length - 1) {
                texto += celda + "}";
            } else {
                texto += celda + ",";
            }
        }
        return texto;
    }
}
