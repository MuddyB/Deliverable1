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
import java.util.Collections;

//Show deck of cards
public class UnoDeck extends GroupOfCards {
    public UnoDeck(int size) {
        super(size);
        
        //Get list of cards
        getCards().clear();
        
        //add all possible combination of cards and colour
        for (UnoCard.Color color : UnoCard.Color.values()) {
            for (UnoCard.Value value : UnoCard.Value.values()) {
                getCards().add(new UnoCard(color, value));
            }
        }
    }

    //draw a card from top of deck
    public UnoCard draw() {
        return (UnoCard) getCards().remove(0);
    }
}