public class Game {

    public String winner(String[] deckSteve, String[] deckJosh) {
        int scoreSteve = 0;
        int scoreJosh = 0;

        // Mapeo de cartas a valores numéricos
        String cardValues = "23456789TJQKA";

        for (int i = 0; i < deckSteve.length; i++) {
            char cardSteve = deckSteve[i].charAt(0);
            char cardJosh = deckJosh[i].charAt(0);

            int valueSteve = cardValues.indexOf(cardSteve);
            int valueJosh = cardValues.indexOf(cardJosh);

            if (valueSteve == valueJosh) {
                // It's a tie; do nothing
            } else {
                if (valueSteve > valueJosh) {
                    scoreSteve++;
                } else {
                    scoreJosh++;
                }
            }
        }

        if (scoreSteve > scoreJosh) {
            return "Steve wins " + scoreSteve + " to " + scoreJosh;
        } else if (scoreJosh > scoreSteve) {
            return "Josh wins " + scoreJosh + " to " + scoreSteve;
        } else {
            return "Tie";
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        String[] deckSteve = { "A", "7", "8" };
        String[] deckJosh = { "K", "5", "9" };
        String result = game.winner(deckSteve, deckJosh);
        System.out.println(result);
    }
}
