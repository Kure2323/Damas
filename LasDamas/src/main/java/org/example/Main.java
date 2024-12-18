package org.example;
import java.util.Scanner;

public class Main {

    static Scanner entrada = new Scanner(System.in);

    static boolean turno = true;    //Cuando sea true = turno de los blancos / Cuando sea false = turno de los negros
    //Este boolean lleva la dependencia del turno, tanto de los blancos como de los negros, la inversa de la matriz depende del turno también

    static String[][] tablero = {{null,"n",null,"n",null,"n",null,"n"}, {"n",null,"n",null,"n",null,"n",null}, {null,"n",null,"n",null,"n",null,"n"}, {null,null,null,null,null,null,null,null}, {null,null,null,null,null,null,null,null}, {"b",null,"b",null,"b",null,"b",null}, {null,"b",null,"b",null,"b",null,"b"}, {"b",null,"b",null,"b",null,"b",null}};
    //Matriz del tablero con únicamente las fichas, este sería el tablero a modificar durante toda la partida
    //Para mostrarla por pantalla primero deberíamos pasarla por un método que rellene los 'null' con las casillas blancas y negras

    public static void main(String[] args) {

        Method.plantillaInicio();
        while (true) {
            if (turno) {
                String color = "b";
            } else {
                String color = "n";
            }
            String[] movimiento = Method.pedirMovimiento();
            Method.mostrarTablero(tablero);


            break;
        }






    }
}