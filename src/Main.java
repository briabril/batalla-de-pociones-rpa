import java.util.Scanner;

class BatallaPociones {

    /* Módulo que recibe las elecciones de ambos jugadores y determina el ganador */
    public static int determinarGanador(int j1, int j2) {
        if (j1 == j2) return 0;

        if ((j1 == 1 && j2 == 3) ||
                (j1 == 3 && j2 == 2) ||
                (j1 == 2 && j2 == 1)) {
            return 1;
        }
        return 2;
    }

    /* Módulo que Convierte un valor numérico en el nombre de la poción correspondiente */
    public static String nombrePocion(int opcion) {
        return switch (opcion) {
            case 1 -> "Fuego";
            case 2 -> "Agua";
            case 3 -> "Planta";
            default -> "Desconocido";
        };
    }

    /* Módulo que simula la limpieza de la consola imprimiendo varias líneas en blanco */
    public static void limpiarPantalla() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    /* Programa Principal (main) */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Declaración de variablessss
        String jugador1, jugador2;
        int eleccion1, eleccion2;
        int puntosJ1 = 0, puntosJ2 = 0; // acumuladores
        int ronda = 1; // contador

        System.out.println("=== BATALLA DE POCIONES ===");

        // Entrada de datos, solicita los nombres de los jugadores
        System.out.print("Nombre Jugador 1: ");
        jugador1 = sc.next();

        System.out.print("Nombre Jugador 2: ");
        jugador2 = sc.next();

        // Estructura repetitiva que itera 5 rondas
        do {
            System.out.println("\nRonda " + ronda);

            // Validación de entrada jugador 1
            do {
                System.out.print(jugador1 + " elige (1=Fuego, 2=Agua, 3=Planta): ");
                eleccion1 = sc.nextInt();
            } while (eleccion1 < 1 || eleccion1 > 3);

            limpiarPantalla();

            // Validación de entrada jugador 2
            do {
                System.out.print(jugador2 + " elige (1=Fuego, 2=Agua, 3=Planta): ");
                eleccion2 = sc.nextInt();
            } while (eleccion2 < 1 || eleccion2 > 3);

            limpiarPantalla();

            // Salida de datos (elecciones)
            System.out.println(jugador1 + " usó " + nombrePocion(eleccion1));
            System.out.println(jugador2 + " usó " + nombrePocion(eleccion2));

            // Determinar ganador de la ronda
            int resultado = determinarGanador(eleccion1, eleccion2);

            // Estructura condicional
            if (resultado == 1) {
                System.out.println("Gana la ronda " + jugador1);
                puntosJ1++; // acumulador
            } else if (resultado == 2) {
                System.out.println("Gana la ronda " + jugador2);
                puntosJ2++; // acumulador
            } else {
                System.out.println("Empate");
            }

            // Mostrar puntaje parcial
            System.out.println("Puntaje: " + jugador1 + " " + puntosJ1 +
                    " - " + jugador2 + " " + puntosJ2);

            ronda++; // incremento del contador

        } while (ronda <= 5);

        // Resultado final
        System.out.println("\n=== RESULTADO FINAL ===");

        if (puntosJ1 > puntosJ2) {
            System.out.println("HA GANADO: " + jugador1);
        } else if (puntosJ2 > puntosJ1) {
            System.out.println("HA GANADO: " + jugador2);
        } else {
            System.out.println("ES UN EMPATE!");
        }
    }
}
