package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class UnoPlayer extends Player {
    private ArrayList<UnoCard> hand = new ArrayList<>();
    private UnoCard lastPlayedCard; // store the actual card played

    @Override
    public void play() {
        // Not used in our manual turn logic
    }

    public UnoPlayer(String name) {
        super(name);
    }

    public void drawCard(UnoDeck deck) {
        hand.add(deck.draw());
    }

    public void showHand() {
        System.out.println("Your hand:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println((i + 1) + ": " + hand.get(i));
        }
    }

    public boolean playTurn(UnoCard topCard, UnoDeck deck) {
        showHand();
        System.out.println("Top card: " + topCard);
        System.out.println("Choose card to play (number), or 0 to draw:");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if (choice == 0) {
            drawCard(deck);
            System.out.println(getName() + " draws a card.");
            return false;
        } else {
            UnoCard chosen = hand.get(choice - 1);
            if (chosen.getColor() == topCard.getColor() || chosen.getValue() == topCard.getValue()) {
                lastPlayedCard = chosen;
                hand.remove(choice - 1);
                System.out.println(getName() + " plays " + chosen);
                return true;
            } else {
                System.out.println("Invalid move. You must draw a card.");
                drawCard(deck);
                return false;
            }
        }
    }

    // Computer turn
    public boolean playComputerTurn(UnoCard topCard, UnoDeck deck) {
        for (int i = 0; i < hand.size(); i++) {
            UnoCard card = hand.get(i);
            if (card.getColor() == topCard.getColor() || card.getValue() == topCard.getValue()) {
                lastPlayedCard = card;
                hand.remove(i);
                System.out.println(getName() + " plays " + card);
                return true;
            }
        }
        drawCard(deck);
        System.out.println(getName() + " draws a card.");
        return false;
    }

    public int getHandSize() {
        return hand.size();
    }

    public UnoCard getLastPlayedCard() {
        return lastPlayedCard;
    }
}
