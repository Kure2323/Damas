package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int pos = 0;

        String[][] matriz = new String[3][3];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                matriz[i][j] = Integer.toString(pos);
                pos++;
            }
        }
        Method.MostrarMatriz(matriz);
        System.out.println();
        matriz = Method.InvertirMatriz(matriz);
        System.out.println();
        Method.MostrarMatriz(matriz);



    }
}