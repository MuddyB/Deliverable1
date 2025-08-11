/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author Mouddassar Baig 
 * @author Valmir Muratovski June 2025
 */
public abstract class Player {

    private String name; //the unique name for this player

    /*
     name to assign to this player
     */
    public Player(String name) {
        this.name = name;
    }

    /*
     return the player name
     */
    public String getName() {
        return name;
    }

    /*
   
     name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public abstract void play();

}
