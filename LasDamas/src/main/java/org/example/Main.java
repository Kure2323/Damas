package org.example;

import java.util.Arrays;

public class Main {


    static boolean turno = true;    //Cuando sea true = turno de los blancos / Cuando sea false = turno de los negros
    //Este boolean lleva la dependencia del turno, tanto de los blancos como de los negros, la inversa de la matriz depende del turno también

    public static void main(String[] args) {

        if (turno == true) {    //
            String color = "b";
        } else {
            String color = "n";
        }

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