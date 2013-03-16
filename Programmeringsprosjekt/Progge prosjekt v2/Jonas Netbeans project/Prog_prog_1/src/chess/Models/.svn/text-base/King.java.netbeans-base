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
public class King extends Piece implements Serializable{
    private boolean isDrawn;
    private int numberOfMoves = 0;
    
    public King(String publicURL, boolean isWhite, int xCord, int yCord) {
        super(publicURL, isWhite, xCord, yCord);
    }
    public boolean isDrawn() {
        return isDrawn;
    }
    public void setIsDrawn(boolean isDrawn) {
        this.isDrawn = isDrawn;
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

}
