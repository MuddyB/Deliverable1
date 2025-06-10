/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Mudaser
 */
import java.util.ArrayList;
import java.util.Scanner;

public class UnoPlayer extends Player {
    //store cards in players hand
    private ArrayList<UnoCard> hand = new ArrayList<>();
    
    //unoplayer giving errors, override for now
    @Override
    public void play() {
    }

    //call playername
    public UnoPlayer(String name) {
        super(name);
    }

    //draw cards from deck
    public void drawCard(UnoDeck deck) {
        hand.add(deck.draw());
    }

    //display cards in hnad
    public void showHand() {
        System.out.println("Your hand:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println((i+1) + ": " + hand.get(i));
        }
    }
    
    //Shows drawn card + asks player to play a card
    public boolean playTurn(UnoCard topCard, UnoDeck deck) {
        showHand();
        System.out.println("Top card: " + topCard);
        
        //If user cannot play a card, draw a card
        System.out.println("Choose card to play (number), or 0 to draw:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice == 0) {
            drawCard(deck);
            return false;
        } else {
            UnoCard chosen = hand.get(choice - 1);
            if (chosen.getColor() == topCard.getColor() || chosen.getValue() == topCard.getValue()) {
                hand.remove(choice - 1);
                return true;
            } else {
                System.out.println("Invalid move. Draw a card.");
                drawCard(deck);
                return false;
            }
        }
    }

    //show how many cards in player hand
    public int getHandSize() { return hand.size(); }
    public UnoCard getLastPlayedCard() { return hand.get(hand.size() - 1); }
}