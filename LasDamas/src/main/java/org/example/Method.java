package org.example;

import java.util.Scanner;

import static org.example.Main.tablero;

public class Method {

    static Scanner entrada = new Scanner(System.in);

    /**
     * Limpia la pantalla, es decir, desplaza toda la información hacia arriba dejando la terminal en blanco.
     */
    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    /**
     * Plantilla que muestra la bienvenida y lo básico para saber de que va el programa, las reglas.
     */
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
            System.out.println("Peones blancos: ●");
            System.out.println("Damas blancas: ♛");
            System.out.println("Peones negros: ○");
            System.out.println("Damas negras: ♕");
            System.out.println("Si consigues que un peón llegue a la parte opuesta de tu tablero este se convertirá en una dama");
            System.out.println("¿Empezamos?");
            System.out.println("(S para empezar, N u otra cosa para repetir las reglas)");
            String empezar = entrada.next();
            if (empezar.equals("S") || empezar.equals("s")) {
                salir=true;
            } else {
                limpiarPantalla();
                continue;
            }

        } while (!salir);

    }

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

    /**
     * Cambia a DAMAS los peones situados en el extremo contrario al que pertenecen.
     * @param tablero
     * @param color
     * @return Tablero con las Damas
     */
    public static String[][] cambioDama(boolean turno) {  //Comprueba y cambia los peones que estén situados al extremo contrario a damas
        if (turno) {
            for (int i = 0; i < tablero.length; i++) {
                if (tablero[0][i].equals("●")) {
                    tablero[0][i] = "♛";
                }
            }
        } else {
            for (int i = 0; i < tablero.length; i++) {
                if (tablero[7][i].equals("○")) {
                    tablero[7][i] = "♕";
                }
            }
        }
        return tablero;
    }   //Si hay un peón en el extremo contrario lo cambia a dama

    public static String[] pedirMovimiento(boolean turno) {

        String team;
        if (turno) {
            team = "Blancas";
        } else {
            team = "Negras";
        }
        String[] vector;
        while (true) {
            try {
                System.out.println("Es turno de las " + team + ", introduzca primero la posición de la ficha a mover, un espacio y la posición que quieres que vaya.");
                Scanner entrada = new Scanner(System.in);
                String aux = entrada.nextLine();
                if (!aux.matches("[0-7][0-7] [0-7][0-7]")) {
                    System.out.println("Debe introducirse los datos de la siguiente manera: [0-7][0-7] [0-7][0-7]");
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

    public static void mostrarTablero() {

        String[][] casillas = {{" ", "."," ", "."," ", "."," ", "."},{"."," ", "."," ", "."," ", "."," "},
                {" ", "."," ", "."," ", "."," ", "."},{"."," ", "."," ", "."," ", "."," "},
                {" ", "."," ", "."," ", "."," ", "."},{"."," ", "."," ", "."," ", "."," "},
                {" ", "."," ", "."," ", "."," ", "."},{"."," ", "."," ", "."," ", "."," "}};
        System.out.println("_______________________");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == null) {
                    tablero[i][j] = casillas[i][j];
                }
                System.out.print(tablero[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("_______________________");

    }   //Junta las matrices de tablero y le pone las casillas para mostrarlo por pantalla

    /**
     * Función para ejecutar el movimiento introducido por el usuario.
     * Primero debe haber pasado por controles para que no pueda saltar errores.
     * Controles tales como: Comprobar que la ficha a mover existe y que a donde vaya no haya otra ficha de su mismo color o que tipo de ficha es...
     * @param movimiento
     * @param turno
     * @return
     */
    public static String[][] ejecutarMovimiento(String movimiento, boolean turno) {

        if (turno) {
            if (tablero[Integer.parseInt(movimiento.substring(0, 1))][Integer.parseInt(movimiento.substring(1, 2))].equals("●")) {
                //Enviar a método de ejecución de movimiento de peón.
            } else if (tablero[Integer.parseInt(movimiento.substring(0, 1))][Integer.parseInt(movimiento.substring(1, 2))].equals("♛")) {
                //Enviar a método de ejecución de movimiento de DAMA.
            } else {
                //Enviar a método que avise del error y vuelva pedir el movimiento.
            }
        } else {
            if (tablero[Integer.parseInt(movimiento.substring(0, 1))][Integer.parseInt(movimiento.substring(1, 2))].equals("○")) {
                //Enviar a método de ejecución de movimiento de peón.
            } else if (tablero[Integer.parseInt(movimiento.substring(0, 1))][Integer.parseInt(movimiento.substring(1, 2))].equals("♕")) {
                //Enviar a método de ejecución de movimiento de DAMA.
            } else {
                //Enviar a método que avise del error y vuelva pedir el movimiento.
            }
        }

        return tablero;
    }


}
