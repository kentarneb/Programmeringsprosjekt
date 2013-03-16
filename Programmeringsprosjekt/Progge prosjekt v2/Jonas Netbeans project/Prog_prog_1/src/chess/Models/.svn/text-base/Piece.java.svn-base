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
public class Piece implements Serializable{

    private final String pictureURL;
    private final boolean isWhite;
    private int xCord, yCord;

    public Piece(String pictureURL, boolean isWhite, int xCord, int yCord) {
        this.pictureURL = pictureURL;
        this.isWhite = isWhite;
        this.xCord = xCord;
        this.yCord = yCord;
    }

    /**
     * If a piece is white it will return true.
     * Otherwise it will return false, meaning that the piece is black.
     * @return the isWhite
     */
    public boolean isWhite() {
        return isWhite;
    }

    /**
     * Gets the picture URL.
     * @return pictureURL
     */
    public String getPictureURL() {
        return pictureURL;
    }

    /**
     * Set the coordinates for x and y.
     * @param x
     * @param y 
     */
    public void setCords(int x, int y) {
        xCord = x;
        yCord = y;
    }

    /**
     * Gets the x coordinate.
     * @return 
     */
    public int getX() {
        return xCord;
    }

    /**
     * Gets the y coordinate.
     * @return 
     */
    public int getY() {
        return yCord;
    }

    /**
     * Locates the x and y coordinates. If none of them are found it means that the piece is no longer on the board and it will return false.
     * @param x
     * @param y
     * @return 
     */
    public boolean isAtPosition(int x, int y) {
        if (xCord == x && yCord == y) {
            return true;
        }
        return false;
    }
    public String getXAndY(){
        String xOgY = xCord+"x, "+yCord+"y";
        return xOgY;
    }

    public String toString() {
        String name = this.getClass().getName();
        String color = "Black ";
        if (isWhite) {
            color = "White ";
        }
        return color + name.substring(name.lastIndexOf(".") + 1).trim();
    }
}
