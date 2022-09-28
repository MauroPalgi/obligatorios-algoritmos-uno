/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import helper.Utils;

/**
 *
 * @author maurp
 */
public class Ejercicios {

    public static int columnaMaxima(int[][] mat) {
        int[] vectorSum = new int[mat[0].length];
        int maxVal = Integer.MIN_VALUE;
        int maxCol = -1;
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[i].length - 1; j >= 0; j--) {
                int celda = mat[i][j];
                vectorSum[j] += celda;
                if (vectorSum[j] >= maxVal) {
                    maxVal = vectorSum[j];
                    maxCol = j;
                }
            }
        }
        return maxCol;
    }

    public static int[][] eliminarColDeMatriz(int[][] mat, int col) {
        Utils.MostrarMatriz(mat);
        int[][] nuevaMat = new int[mat.length][mat[0].length - 1];
        for (int i = 0; i < nuevaMat.length; i++) {
            for (int j = 0; j < nuevaMat[i].length; j++) {
                int celda;
                if (j < col) {
                    celda = mat[i][j];
                } else {
                    celda = mat[i][j + 1];
                }
                nuevaMat[i][j] = celda;
            }
        }
        return nuevaMat;
    }

    public static void completarMatrizConCeros(int[][] mat) {
        Utils.MostrarMatriz(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int celda = mat[i][j];
                if (celda == 0) {
                    for (int k = 0; k < mat.length; k++) {
                        mat[k][j] = 0;
                    }
                }
            }
        }
        Utils.MostrarMatriz(mat);

    }

}
