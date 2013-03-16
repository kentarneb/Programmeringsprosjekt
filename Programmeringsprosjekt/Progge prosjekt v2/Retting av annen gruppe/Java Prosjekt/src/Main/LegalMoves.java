package Main;


import org.newdawn.slick.Image;
/**
 * Lager en brikke av {@link Pieces} som viser et bilde av hvor en kan gå
 * 
 */
public class LegalMoves extends Pieces{
    public LegalMoves(Image bilde, int posX, int posY, String piecename, boolean isWhite){
        super(null, posX, posY, piecename, isWhite);
    }
    @Override
    public void resetTrekk(){
        
    }
    
    @Override
    public void inkrementerAntTrekk(){
        
    }
    @Override
    public String[] movePiece(){
        return null;
    }
    
    public void setImage(Image i){
        bilde = i;
    }
    
    
    
}
