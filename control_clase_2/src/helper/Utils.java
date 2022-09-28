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

    static public void MostrarMatriz(int[][] mat) {
        if (mat.length == 0) {
            System.out.println("{ empty }");
            return;
        }
        System.out.println("{");
        for (int fila = 0; fila < mat.length; fila++) {
            int[] arregloFila = mat[fila];
            MostrarArreglo(arregloFila);
        }
        System.out.println("}");
    }

    static public void MostrarArreglo(int[] arr) {

        String texto = "  {";
        for (int i = 0; i < arr.length; i++) {
            int celda = arr[i];

            if (i == arr.length - 1) {
                texto += celda + "}";
            } else {
                texto += celda + ",";
            }
        }

        System.out.println(texto);
    }
}
