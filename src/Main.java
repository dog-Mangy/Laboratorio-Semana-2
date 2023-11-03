import java.util.Arrays;
import java.util.Random;

public class Main {
    private String winner(String[] deckSteve, String[] deckJosh) {
        int puntosSteve = 0;
        int puntosJosh = 0;

        for (int i = 0; i < 3; i++) {
            char cartaSteve = deckSteve[i].charAt(0);
            char cartaJosh = deckJosh[i].charAt(0);

            if (cartaSteve == 'A' && cartaJosh == 'K') {
                puntosSteve++;
            } else if (cartaSteve == 'A' && cartaJosh == 'Q') {
                puntosSteve++;
            } else if (cartaSteve == 'A' && cartaJosh == 'J') {
                puntosSteve++;
            } else if (cartaSteve == 'A' && cartaJosh == 'T') {
                puntosSteve++;
            } else if (cartaSteve > cartaJosh) {
                puntosSteve++;
            } else {
                puntosJosh++;
            }
        }

        if (puntosSteve > puntosJosh) {
            return "Steve wins " + puntosSteve + " to " + puntosJosh;
        } else if (puntosJosh > puntosSteve) {
            return "Josh wins " + puntosJosh + " to " + puntosSteve;
        } else {
            return "El juego termina en empate " + puntosSteve + " a " + puntosJosh;
        }
    }

    public static void main(String[] args) {
        char[] cartas = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
        String[] Steve = new String[3];
        String[] Josh = new String[3];
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            int randomIndex = rand.nextInt(cartas.length);
            Steve[i] = String.valueOf(cartas[randomIndex]);
            cartas[randomIndex] = cartas[cartas.length - 1];
            cartas = Arrays.copyOf(cartas, cartas.length - 1);
        }

        for (int i = 0; i < 3; i++) {
            int randomIndex = rand.nextInt(cartas.length);
            Josh[i] = String.valueOf(cartas[randomIndex]);
            cartas[randomIndex] = cartas[cartas.length - 1];
            cartas = Arrays.copyOf(cartas, cartas.length - 1);
        }

        System.out.println("Cartas de Steve: " + Arrays.toString(Steve));
        System.out.println("Cartas de Josh: " + Arrays.toString(Josh));

        Main game = new Main();
        String resultado = game.winner(Steve, Josh);
        System.out.println(resultado);
    }
}