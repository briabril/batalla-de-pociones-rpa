import java.util.Scanner;

class BatallaPociones {
    public static int determinarGanador(int opcionJugador, int opcionComputadora) {

        int resultado;

        if (opcionJugador == opcionComputadora) {
            resultado = 0;
        } else if ((opcionJugador == 1 && opcionComputadora == 3) ||
                (opcionJugador == 3 && opcionComputadora == 2) ||
                (opcionJugador == 2 && opcionComputadora == 1)) {
            resultado = 1;
        } else {
            resultado = 2;
        }

        return resultado;
    }

    public static int generarOpcionComputadora() {
        int opcion;
        opcion = (int) (Math.random() * 3) + 1;
        return opcion;
    }

    public static String nombrePocion(int opcion) {
        String nombre;

        if (opcion == 1) {
            nombre = "Fuego";
        } else if (opcion == 2) {
            nombre = "Agua";
        } else {
            nombre = "Planta";
        }
        return nombre;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int puntosJugador = 0;
        int puntosComputadora = 0;
        int numeroRonda = 1;

        System.out.println("BATALLA DE POCIONES");

        while (numeroRonda <= 5) {
            System.out.println("\nRonda " + numeroRonda);

            int opcionJugador;

            do {
                System.out.print("Elegí (1 Fuego, 2 Agua, 3 Planta): ");
                opcionJugador = sc.nextInt();
            } while (opcionJugador < 1 || opcionJugador > 3);

            int opcionComputadora = generarOpcionComputadora();

            System.out.println("Jugador: " + nombrePocion(opcionJugador));
            System.out.println("Computadora: " + nombrePocion(opcionComputadora));

            int resultadoRonda = determinarGanador(opcionJugador, opcionComputadora);

            if (resultadoRonda == 1) {
                System.out.println("Gana el jugador esta ronda");
                puntosJugador++;
            } else if (resultadoRonda == 2) {
                System.out.println("Gana la computadora esta ronda");
                puntosComputadora++;
            } else {
                System.out.println("Empate");
            }
            numeroRonda++;
        }

        System.out.println("\nRESULTADO FINAL");

        if (puntosJugador > puntosComputadora) {
            System.out.println("Gana el jugador");
        } else if (puntosComputadora > puntosJugador) {
            System.out.println("Gana la computadora");
        } else {
            System.out.println("Empate");
        }

        System.out.println("Puntaje: Jugador " + puntosJugador + " - Computadora " + puntosComputadora);

        sc.close();
    }
}