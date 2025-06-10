/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Mouddassar Baig and 
 */

public class UnoCard extends Card {
    public enum Color { RED, BLUE, GREEN, YELLOW }
    public enum Value { ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE }

    private final Color color;
    private final Value value;

    public UnoCard(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public String toString() {
        return color + " " + value;
    }

    public Color getColor() { return color; }
    public Value getValue() { return value; }
}
