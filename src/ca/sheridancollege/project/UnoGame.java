/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Mudaser
 */

public class UnoGame extends Game {
    private UnoDeck deck;
    private UnoPlayer player;
    private UnoCard topCard;

    public UnoGame(String name) {
        super(name);
        deck = new UnoDeck(40);
        
        //create a player and give them 7 cards to start the game
        player = new UnoPlayer("Player 1");
        for (int i = 0; i < 7; i++) player.drawCard(deck);
        topCard = deck.draw();
    }

    //loop the game cycle
    @Override
    public void play() {
        //continue playing while players still have cards
        while (player.getHandSize() > 0) {
            //player turn
            boolean played = player.playTurn(topCard, deck);
            //if card is played, update the card ontop of pile
            if (played) topCard = player.getLastPlayedCard();
        }
        //Whoever has no cards left wins
        declareWinner();
    }
    // winning message
    @Override
    public void declareWinner() {
        System.out.println("You win!");
    }
}