package Main;



import org.newdawn.slick.Image;
/**
     * Klasse som tilsvarer en fiktiv brikke som blokkerer
     * 
     * Klassen brukes bare av {@link VariousMethods} for å sette ut
     * fiktive brikker som fungerer som blokkere for de andre brikkene
     * 
     */
public class Blockers extends Pieces{
    /**
     
     * @param bilde Bildet til brikken
     * @param posX Posisjonen til brikken i x-retning
     * @param posY Posisjonen til brikken i y-retning
     * @param piecename Navnet til brikken
     * @param isWhite En boolsk verdi som bestemmer om brikken er hvit eller ikke
     */
    Blockers(Image bilde, int posX, int posY,String piecename, boolean isWhite){
        super(bilde, posX, posY,piecename, isWhite);
    }
    
    @Override
    /**
     * {@inheritDoc}
     */
    
    public void inkrementerAntTrekk(){
    }
    
    @Override
    
    /**
     * {@inheritDoc}
     */
    public String[] movePiece(){
        String t = "" + getPosX() + "" + getPosY();
        String[] bleh = {t};
        return bleh;
    }
    
    /**
     * 
     * Forandrer bildet til brikken fra et bilde til et annet
     * 
     * @param i Parameteren som {@link #bilde} skal byttes til
     */
    public void setImage(Image i){
        bilde = i;
    }
    @Override
    /**
     * {@inheritDoc}
     */
    public void resetTrekk(){
    }
}
    