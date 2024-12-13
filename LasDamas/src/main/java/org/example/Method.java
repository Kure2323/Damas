package org.example;

import java.util.Scanner;

import static org.example.Main.turno;

public class Method {

    static Scanner entrada = new Scanner(System.in);

    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    } //"Limpiar" la pantalla

    public static void plantillaInicio() {

        boolean salir = false;
        do {
            System.out.println("***BIENVENIDO A LAS DAMAS***");
            System.out.println("El jugador 1 es el color blanco");
            System.out.println("El jugador 2 es el color negro");

            System.out.println("Reglas:");
            System.out.println("Tablero de 8x8 (64) dividido en 2 colores: blanco (#) y negro ( )");
            System.out.println("Peones: Avanzan y capturan en diagonal sólo hacia adelante y sólo en avance de una casilla.");
            System.out.println("Damas: Tanto para desplazarse como para realizar capturas, avanzan el número de casillas que se desee tanto hacia delante como hacia atrás, siempre en diagonal.");
            System.out.println("Peones blancos: b");
            System.out.println("Damas blancas: B");
            System.out.println("Peones negros: n");
            System.out.println("Damas negras: N");
            System.out.println("Si consigues que un peón llegue a la parte opuesta de tu tablero este se convertirá en una dama");
            System.out.println("¿Empezamos?");
            System.out.println("(S para empezar, N u otra cosa para repetir las reglas)");
            String empezar = entrada.next();
            if (empezar.equals("S")) {
                salir=true;
            } else {
                limpiarPantalla();
                continue;
            }

        } while (!salir);

    } // Muestra las reglas del juego

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println();
        }
    }   //Muestra por pantalla la matriz introducida

    public static void mostrarMatriz(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println();
        }
    }   //Muestra por pantalla la matriz introducida

    public static String[][] invertirMatriz(String[][] matriz) {

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

    public static void mostrarMatrizInversa(String[][] matriz) {

        for (int i = matriz.length -1 ; i >= 0; i--) {
            for (int j = matriz[i].length -1; j >=0; j--) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println();
        }
    }   //Muestra por pantalla la matriz introducida de forma inversa

    public static String[][] cambioDama(String[][] matriz, String color) {  //Comprueba y cambia los peones que estén situados al extremo contrario a damas
        for (int i = 0; i < matriz[0].length; i++) {
            if (matriz[0][i] == color) {
                matriz[0][i] = color.toUpperCase();
            }
        }
        return matriz;
    }   //Si hay un peón en el extremo contrario lo cambia a dama

    public static String[] pedirMovimiento() {

        String team;
        if (turno) {
            team = "Blancas";
            String color = "b";
        } else {
            team = "Negras";
            String color = "n";
        }
        String[] vector;
        while (true) {
            try {
                System.out.println("Es turno de las " + team + ", introduzca primero la posición de la ficha a mover, un espacio y la posición que quieres que vaya.");
                Scanner entrada = new Scanner(System.in);
                String aux = entrada.nextLine();
                if (!aux.matches("[0-8][0-8] [0-8][0-8]")) {
                    System.out.println("Debe introducirse los datos de la siguiente manera: [0-8][0-8] [0-8][0-8]");
                    continue;
                }
                vector = aux.split(" ");


            } catch (NumberFormatException e) {
                System.out.println("Debe introducir números");
                continue;
            }
            break;

        }
        return vector;


    }   //Pide la jugada y comprueba su formato





}
