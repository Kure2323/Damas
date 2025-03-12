package org.example;
import java.util.*;

public class Main {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        Damas play = new Damas();
        plantillaInicio();
        limpiarPantalla();
        while (play.getGanador().isEmpty()) {

            play.cambioDama();
            play.mostrarTablero();
            play.ejecutarMovimiento(play.pedirMovimiento());

            play.cambioDama();
            play.cambioTurno();
            limpiarPantalla();

            System.out.println();
        }

    }

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










}