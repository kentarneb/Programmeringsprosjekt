
package chess.Models;

import java.io.Serializable;

/**
 *
 * @author Bjerke
 */
public class Flytt implements Serializable {
    
    //Holder orden på traversering
    private boolean travesert = false;
    //heltallsverdier for flytting
    private int fraX, fraY, tilX, tilY;
    //Brikken som skal flyttes/elimineres.
    private Piece flyttetBrikke, eliminertBrikke;
    

    public Flytt(int fraX, int fraY, int tilX, int tilY, Piece flyttetBrikke) {
        this.fraX = fraX;
        this.fraY = fraY;
        this.tilX = tilX;
        this.tilY = tilY;
        this.flyttetBrikke = flyttetBrikke;
    }

    public Flytt(int fraX, int fraY, int tilX, int tilY, Piece flyttetBrikke, Piece eliminertBrikke) {
        this.fraX = fraX;
        this.fraY = fraY;
        this.tilX = tilX;
        this.tilY = tilY;
        this.flyttetBrikke = flyttetBrikke;
        this.eliminertBrikke = eliminertBrikke;
    }

    public Flytt(int fraX, int fraY, int tilX, int toY, Piece movedPiece, Piece killedPiece, boolean traversed) {
        this.fraX = fraX;
        this.fraY = fraY;
        this.tilX = tilX;
        this.tilY = toY;
        this.flyttetBrikke = movedPiece;
        this.eliminertBrikke = killedPiece;
        this.travesert = traversed;
    }
    
    public int getFraX() {
        return this.fraX;
    }

    public int getFraY() {
        return this.fraY;
    }
    
    public boolean getTravesert(){
        return travesert;
    }
    
    public void setTravesert(boolean traversed){
        this.travesert = traversed;
    }

    public int getTilX() {
        return tilX;
    }

    public int getTilY() {
        return tilY;
    }

    public Piece getBrikke() {
        return this.flyttetBrikke;
    }

    public Piece getEliminertBrikke() throws NullPointerException {
        return eliminertBrikke;
    }

    public void setBrikke(Piece p) {
        flyttetBrikke = p;
    }

    public String toString() {
        return fraX + "/" + fraY + " -> " + tilX + "/" + tilY + ": " + flyttetBrikke;
    }
}
