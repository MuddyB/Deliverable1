package ca.sheridancollege.project;

public class UnoGame extends Game {
    private UnoDeck deck;
    private UnoPlayer player1;
    private UnoPlayer player2;
    private UnoCard topCard;

    public UnoGame(String name) {
        super(name);
        deck = new UnoDeck(40);
        deck.shuffle(); // shuffle for randomness

        player1 = new UnoPlayer("Player 1");
        player2 = new UnoPlayer("Computer");

        // Deal 7 cards each
        for (int i = 0; i < 7; i++) {
            player1.drawCard(deck);
            player2.drawCard(deck);
        }

        // Start with top card
        topCard = deck.draw();
    }

    @Override
    public void play() {
        UnoPlayer currentPlayer = player1; // Player 1 starts
        boolean gameOver = false;

        while (!gameOver) {
            System.out.println("\n--- " + currentPlayer.getName() + "'s turn ---");

            boolean played;
            if (currentPlayer == player1) {
                played = currentPlayer.playTurn(topCard, deck);
            } else {
                played = currentPlayer.playComputerTurn(topCard, deck);
            }

            if (played) {
                topCard = currentPlayer.getLastPlayedCard();
                System.out.println("Top card is now: " + topCard);
            }

            if (currentPlayer.getHandSize() == 0) {
                declareWinner(currentPlayer);
                gameOver = true;
            } else {
                // Switch players
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }
    }

    @Override
    public void declareWinner() {
        // Not used here, we use the overloaded one
    }

    public void declareWinner(UnoPlayer winner) {
        System.out.println("\n*** " + winner.getName() + " WINS! ***");
    }
}
