/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.Models;

import java.io.Serializable;

/**
 *
 * @author Gjerde
 */
public class Move implements Serializable {

    private int fromX, fromY, toX, toY;
    private Piece movedPiece, killedPiece;
    //private boolean queenTransformedToPawn = false;
    private boolean traversed = false;

    public Move(int fromX, int fromY, int toX, int toY, Piece movedPiece) {
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
        this.movedPiece = movedPiece;
    }

    public Move(int fromX, int fromY, int toX, int toY, Piece movedPiece, Piece killedPiece) {
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    public Move(int fromX, int fromY, int toX, int toY, Piece movedPiece, Piece killedPiece, boolean traversed) {
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
        this.traversed = traversed;
    }
    
    /*public Move(int fromX, int fromY, int toX, int toY, Piece movedPiece, Piece killedPiece,boolean queenTransformedToPawn) {
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
        this.queenTransformedToPawn = queenTransformedToPawn;
    }*/
/*
    public boolean getQueenTransformedToPawn() {
        return queenTransformedToPawn;
    }
    
    public void setQueenTransformedToPawn(boolean value){
        queenTransformedToPawn = value;
    }*/

    public int getFromX() {
        return this.fromX;
    }

    public int getFromY() {
        return this.fromY;
    }
    
    public boolean getTraversed(){
        return traversed;
    }
    
    public void setTraversed(boolean traversed){
        this.traversed = traversed;
    }

    public int getToX() {
        return toX;
    }

    public int getToY() {
        return toY;
    }

    public Piece getPiece() {
        return this.movedPiece;
    }

    public Piece getKilledPiece() throws NullPointerException {
        return killedPiece;
    }

    public void setPiece(Piece p) {
        movedPiece = p;
    }

    public String toString() {
        return fromX + "/" + fromY + " -> " + toX + "/" + toY + ": " + movedPiece;
    }
}
