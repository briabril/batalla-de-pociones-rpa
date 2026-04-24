import java.util.Scanner;

class BatallaPociones {

    public static int determinarGanador(int j1, int j2) {
        if (j1 == j2) return 0;
        if ((j1 == 1 && j2 == 3) || (j1 == 3 && j2 == 2) || (j1 == 2 && j2 == 1)) return 1;
        return 2;
    }

    public static int generarOponente() {
        return (int) (Math.random() * 3) + 1;
    }

    public static String nombrePocion(int o) {
        return switch (o) {
            case 1 -> "🔥 Fuego";
            case 2 -> "💧 Agua";
            case 3 -> "🌿 Planta";
            default -> "";
        };
    }

    public static String barraVida(int vida) {
        String b = "";
        for (int i = 0; i < vida / 10; i++) b += "█";
        return b;
    }

    public static void linea() {
        System.out.println("================================");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int vJ = 100, vCPU = 100;
        int pJ = 0, pCPU = 0;
        int ronda = 1;

        System.out.println("\n🧪 BATALLA DE POCIONES 🧪");

        do {
            linea();
            System.out.println("⚔️  RONDA " + ronda);
            linea();

            System.out.print("👉 Elegí (1🔥 2💧 3🌿): ");
            int e1;
            do { e1 = sc.nextInt(); } while (e1 < 1 || e1 > 3);

            int e2 = generarOponente();

            System.out.println("\n🎮 Jugador: " + nombrePocion(e1));
            System.out.println("🤖 CPU:     " + nombrePocion(e2));

            int res = determinarGanador(e1, e2);

            linea();

            if (res == 1) {
                System.out.println("🟢 VICTORIA");
                System.out.println("💥 -20 HP a la CPU");
                vCPU -= 20; pJ++;
            } else if (res == 2) {
                System.out.println("🔴 DERROTA");
                System.out.println("💥 -20 HP al jugador");
                vJ -= 20; pCPU++;
            } else {
                System.out.println("🟡 EMPATE");
                System.out.println("⚡ Ambos pierden -5 HP");
                vJ -= 5; vCPU -= 5;
            }

            linea();

            System.out.println("❤️ Jugador: " + vJ + " " + barraVida(vJ));
            System.out.println("❤️ CPU:     " + vCPU + " " + barraVida(vCPU));

            if (vJ <= 0 || vCPU <= 0) break;

            ronda++;

        } while (ronda <= 5);

        linea();
        System.out.println("🏆 RESULTADO FINAL");
        linea();

        if (vJ <= 0 && vCPU <= 0) {
            System.out.println("💀 Empate total");
        } else if (vCPU <= 0 || pJ > pCPU) {
            System.out.println("👑 GANA EL JUGADOR");
        } else if (vJ <= 0 || pCPU > pJ) {
            System.out.println("🤖 GANA LA CPU");
        } else {
            System.out.println("⚖️ Empate");
        }

        linea();
        System.out.println("📊 Puntaje final: Jugador " + pJ + " - CPU " + pCPU);
        linea();
    }
}