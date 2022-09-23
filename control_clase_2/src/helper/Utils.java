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
        String texto = "{\n";
        for (int fila = 0; fila < mat.length; fila++) {
            texto += "  {";
            for (int col = 0; col < mat[fila].length; col++) {
                int celda = mat[fila][col];

                if (col < mat[fila].length) {
                    texto += celda + ",";
                }
                if (col == mat[fila].length - 1) {
                    texto += celda + "}\n";
                }
            }
        }
        texto += "}";
        System.out.println(texto);

    }
}
