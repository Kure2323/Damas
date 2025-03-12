package org.example;

import lombok.Data;

import java.util.Scanner;
import java.util.Stack;

@Data
public class Damas {

    public Damas() {
        tablero = new String[][]{{" ", "○", " ", "○", " ", "○", " ", "○"}, {"○", " ", "○", " ", "○", " ", "○", " "},
                {" ", "○", " ", "○", " ", "○", " ", "○"}, {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "}, {"●", " ", "●", " ", "●", " ", "●", " "},
                {" ", "●", " ", "●", " ", "●", " ", "●"}, {"●", " ", "●", " ", "●", " ", "●", " "}};
        this.turno = true;
        this.color = turnoColor();
        this.ganador = "";
    }
    /**
     * Simplemente devuelve el color del equipo que tiene que mover
     * @return
     */
    private String turnoColor() {
        if (turno) {
            return "●";
        } else {
            return "○";
        }
    }

    /**
     * Cambia a DAMAS los peones situados en el extremo contrario al que pertenecen.
     * @return Tablero con las Damas
     */
    public String[][] cambioDama() {  //Comprueba y cambia los peones que estén situados al extremo contrario a damas
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

    /**
     * Pide el
     * @return
     */
    public Stack<Integer> pedirMovimiento() {

        Stack<Integer> pila = new Stack<>();
        while (true) {
            try {
                System.out.println("Es turno de las " + color + ", introduzca primero la posición de la ficha a mover, un '-' y la posición que quieres que vaya.");
                Scanner entrada = new Scanner(System.in);
                String aux = entrada.nextLine();
                if (!aux.matches("(?:[1-9]|[12][0-9]|3[0-2])-(?:[1-9]|[12][0-9]|3[0-2])")) {
                    System.out.println("Debe introducirse los datos de la siguiente manera: 'num'-'num'");
                    continue;
                }
                for (String num : aux.split("-")) {
                    pila.push(Integer.parseInt(num));
                }


            } catch (NumberFormatException e) {
                System.out.println("Debe introducir números");
                continue;
            }
            break;

        }
        return pila;


    }   //Pide la jugada y comprueba su formato

    public void mostrarTablero() {

        String[][] casillas = {{" ", "."," ", "."," ", "."," ", "."},{"."," ", "."," ", "."," ", "."," "},
                {" ", "."," ", "."," ", "."," ", "."},{"."," ", "."," ", "."," ", "."," "},
                {" ", "."," ", "."," ", "."," ", "."},{"."," ", "."," ", "."," ", "."," "},
                {" ", "."," ", "."," ", "."," ", "."},{"."," ", "."," ", "."," ", "."," "}};
        System.out.println("_______________________");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j].equals(" ")) {
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
     * @return
     */
    public void ejecutarMovimiento(Stack movimiento) {


        String destino = "";
        String inicio = "";
        int cont = 1;

        forInicial:
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < tablero.length; i++) {

                if (i % 2 == 0) {
                    for (int j = 1; j < tablero[i].length; j++) {

                        System.out.print(tablero[i][j]);
                        if (cont == (int) movimiento.peek() && movimiento.size() == 2) {
                            movimiento.pop();
                            destino = i + "" + j;
                        } else if (cont == (int) movimiento.peek()) {
                            movimiento.pop();
                            inicio = i +""+ j;
                        }
                        if (movimiento.isEmpty()) {
                            break forInicial;
                        }
                        System.out.println(cont);
                        cont++;
                        j++;
                    }
                } else {
                    for (int j = 0; j < tablero[i].length; j++) {

                        System.out.print(tablero[i][j]);
                        if (cont == (int) movimiento.peek() && movimiento.size() == 2) {
                            movimiento.pop();
                            destino = i + "" + j;
                        } else if (cont == (int) movimiento.peek()) {
                            movimiento.pop();
                            inicio = i +""+ j;
                        }
                        if (movimiento.isEmpty()) {
                            break forInicial;
                        }
                        System.out.println(cont);
                        cont++;
                        j++;
                    }
                }

            }
        }

        System.out.println(cont);

        if (isTurno()) {
            movimientoBlancas(destino, inicio);
        } else {
            movimientoNegras(destino, inicio);
        }
        cont = 1;


    }

    private void movimientoNegras(String destino, String inicio) {
        if (tablero[Integer.parseInt(destino.substring(0, 1))][Integer.parseInt(destino.substring(1, 2))].equals("○") ||
                tablero[Integer.parseInt(destino.substring(0, 1))][Integer.parseInt(destino.substring(1, 2))].equals("♕") ||
                tablero[Integer.parseInt(inicio.substring(0, 1))][Integer.parseInt(inicio.substring(1, 2))].equals(" ") ||
                tablero[Integer.parseInt(inicio.substring(0, 1))][Integer.parseInt(inicio.substring(1, 2))].equals("♛") ||
                tablero[Integer.parseInt(inicio.substring(0, 1))][Integer.parseInt(inicio.substring(1, 2))].equals("●")) {
            System.out.println("No puede mover porque estás moviendo una ficha que no toca o hacia donde no toca.");

        } else {
            tablero[Integer.parseInt(destino.substring(0, 1))][Integer.parseInt(destino.substring(1, 2))] =
                    tablero[Integer.parseInt(inicio.substring(0, 1))][Integer.parseInt(inicio.substring(1, 2))];

            tablero[Integer.parseInt(inicio.substring(0, 1))][Integer.parseInt(inicio.substring(1, 2))] = ".";
        }
    }

    private void movimientoBlancas(String destino, String inicio) {
        if (tablero[Integer.parseInt(destino.substring(0, 1))][Integer.parseInt(destino.substring(1, 2))].equals("●") ||
                tablero[Integer.parseInt(destino.substring(0, 1))][Integer.parseInt(destino.substring(1, 2))].equals("♛") ||
                tablero[Integer.parseInt(inicio.substring(0, 1))][Integer.parseInt(inicio.substring(1, 2))].equals(" ") ||
                tablero[Integer.parseInt(inicio.substring(0, 1))][Integer.parseInt(inicio.substring(1, 2))].equals("♕") ||
                tablero[Integer.parseInt(inicio.substring(0, 1))][Integer.parseInt(inicio.substring(1, 2))].equals("○")) {
            System.out.println("No puede mover porque estás moviendo una ficha que no toca o hacia donde no toca.");

        } else {
            tablero[Integer.parseInt(destino.substring(0, 1))][Integer.parseInt(destino.substring(1, 2))] =
                    tablero[Integer.parseInt(inicio.substring(0, 1))][Integer.parseInt(inicio.substring(1, 2))];

            tablero[Integer.parseInt(inicio.substring(0, 1))][Integer.parseInt(inicio.substring(1, 2))] = ".";
        }
    }


    public void cambioTurno() {
        turno = !turno;
        setColor(turnoColor());
    }

    private String[][] tablero;
    private boolean turno;
    private String color;
    private String ganador;

}
