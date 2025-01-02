package org.example;
import java.util.Scanner;

public class Main {

    static Scanner entrada = new Scanner(System.in);

    static String[][] tablero = {{null,"○",null,"○",null,"○",null,"○"}, {"○",null,"○",null,"○",null,"○",null}, {null,"○",null,"○",null,"○",null,"○"}, {null,null,null,null,null,null,null,null}, {null,null,null,null,null,null,null,null}, {"●",null,"●",null,"●",null,"●",null}, {null,"●",null,"●",null,"●",null,"●"}, {"●",null,"●",null,"●",null,"●",null}};
    //Matriz del tablero con únicamente las fichas, este sería el tablero a modificar durante toda la partida
    //Para mostrarla por pantalla primero deberíamos pasarla por un método que rellene los 'null' con las casillas blancas y negras

    public static void main(String[] args) {
        boolean turno = true;    //Cuando sea true = turno de los blancos / Cuando sea false = turno de los negros
        //Este boolean lleva la dependencia del turno, tanto de los blancos como de los negros, la inversa de la matriz depende del turno también
        String color;
        Method.plantillaInicio();
        while (true) {

            if (turno) {
                color = "●";
            } else {
                color = "○";
            }
            Method.mostrarTablero();
            String[] movimiento = Method.pedirMovimiento(turno);
            Method.limpiarPantalla();
            Method.cambioDama(turno);
            System.out.println();

            turno = !turno;
        }






    }
}