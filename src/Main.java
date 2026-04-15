import java.util.Scanner;

class BatallaPociones {

    /* Módulo que recibe las elecciones y determina el ganador */
    public static int determinarGanador(int j1, int j2) {
        if (j1 == j2) return 0;

        if ((j1 == 1 && j2 == 3) ||
                (j1 == 3 && j2 == 2) ||
                (j1 == 2 && j2 == 1)) {
            return 1;
        }
        return 2;
    }

    /* Módulo que genera una elección aleatoria para la computadora */
    public static int generarOponente() {
        return (int)(Math.random() * 3) + 1;
    }

    /* Módulo que convierte un valor numérico en el nombre de la poción */
    public static String nombrePocion(int opcion) {
        return switch (opcion) {
            case 1 -> "Fuego";
            case 2 -> "Agua";
            case 3 -> "Planta";
            default -> "Desconocido";
        };
    }

    /* Programa Principal (main) */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Declaración de variables
        String jugador1;
        int eleccion1, eleccion2;
        int puntosJ1 = 0, puntosCPU = 0; // acumuladores iii
        int ronda = 1; // contador

        System.out.println("=== BATALLA DE POCIONES ===");

        // Entrada de datos
        System.out.print("Nombre del Jugador: ");
        jugador1 = sc.next();

        // Bucle de 5 rondas
        do {
            System.out.println("\nRonda " + ronda);

            // Validación de entrada del jugador
            do {
                System.out.print(jugador1 + " elige (1=Fuego, 2=Agua, 3=Planta): ");
                eleccion1 = sc.nextInt();
            } while (eleccion1 < 1 || eleccion1 > 3);

            // Elección automática de la computadora
            eleccion2 = generarOponente();

            // Muestra las elecciones
            System.out.println(jugador1 + " usó " + nombrePocion(eleccion1) + "!");
            System.out.println("La compu usó " + nombrePocion(eleccion2) + "!");

            // Determinar ganador
            int resultado = determinarGanador(eleccion1, eleccion2);

            // Condicional
            if (resultado == 1) {
                System.out.println("Gana la ronda " + jugador1);
                puntosJ1++;
            } else if (resultado == 2) {
                System.out.println("Gana la ronda la Computadora >:)");
                puntosCPU++;
            } else {
                System.out.println("Empate");
            }

            // Mostrar puntaje
            System.out.println("Puntaje: " + jugador1 + " " + puntosJ1 +
                    " - Computadora " + puntosCPU);

            ronda++;

        } while (ronda <= 5);

        // Resultado final
        System.out.println("\n=== RESULTADO FINAL ===");

        if (puntosJ1 > puntosCPU) {
            System.out.println("HA GANADO: " + jugador1);
        } else if (puntosCPU > puntosJ1) {
            System.out.println("HA GANADO: la Computadora");
        } else {
            System.out.println("ES UN EMPATE!");
        }
    }
}
