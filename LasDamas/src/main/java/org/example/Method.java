package org.example;

public class Method {
    public static void MostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println();
        }
    }   //Muestra por pantalla la matriz introducida

    public static void MostrarMatriz(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println();
        }
    }   //Muestra por pantalla la matriz introducida

    public static String[][] InvertirMatriz(String[][] matriz) {

        String[] contenido = new String[matriz.length * matriz[0].length];
        int pos = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                contenido[pos] = matriz[i][j];
                pos++;
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                pos--;
                matriz[i][j] = contenido[pos];
            }
        }
        return matriz;
    } //Invierte y sobrescribe una matriz

    public static void MostrarMatrizInversa(String[][] matriz) {

        for (int i = matriz.length -1 ; i >= 0; i--) {
            for (int j = matriz[i].length -1; j >=0; j--) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println();
        }
    }   //Muestra por pantalla la matriz introducida de forma inversa




}
