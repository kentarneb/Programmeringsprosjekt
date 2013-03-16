/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.Models;

import java.io.Serializable;

/**
 *
 * @author Malin
 */
public class Pawn extends Piece implements Serializable{
    private boolean isDrawn = false;
    private int numberOfMoves = 0;
    
    public Pawn(String publicURL, boolean isWhite, int xCord, int yCord) {
        super(publicURL, isWhite, xCord, yCord);
    }

    /**
     * Checks if the pawn has been drawn. If it has it will return true. Otherwise, it will return false.
     * @return the isDrawn
     */
    public boolean isDrawn() {
        return isDrawn;
    }
    
    public int getNumberOfMoves(){
        return numberOfMoves;
    }
    public void incrementNumberOfMoves(){
        numberOfMoves++;
    }
    public void decrementNumberOfMoves(){
        numberOfMoves--;
    }

    /**
     * Sets the pawn to drawn after it has been used once.
     * @param isDrawn the isDrawn to set
     */
    public void setIsDrawn(boolean isDrawn) {
        this.isDrawn = isDrawn;
    }
    
    
    
}
