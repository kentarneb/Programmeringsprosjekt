package Main;




import org.newdawn.slick.Image;
/**
 * Klasse som tilsvarer en biskop i sjakk
 * 
 * @param posX Posisjon i x-retning på brettet
 * @param posY Posisjon i y-retning på brettet
 * @param bilde Bildet som brukes for å tegne en viss brikke
 * @param piecename Navnet på brikken
 * @param isWhite Boolsk verdi som bestemmer om brikken er hvit eller ikke
 * 
 */
class Bishop extends Pieces{
    
    public Bishop(Image bilde,int posX,int posY,String piecename, boolean isWhite){
        super(bilde, posX, posY, piecename, isWhite);
    }
    
    @Override
    /**
     * {@inheritDoc}
     */
    public String[] movePiece(){
        String[] muligeTrekk = new String[32]; 
        int kolonne = getPosX();
        int rekke = getPosY();
        for(int i = 0; i< WIDTH; i++){
            kolonne += ENRUTE;
            rekke += ENRUTE;
            if((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0)){
                muligeTrekk[i] = "" + kolonne +"" +rekke;
            }else{
                muligeTrekk[i] = "" + getPosX() +""+ getPosY();
            }
        }
        kolonne = getPosX();
        rekke = getPosY();
        for(int i = WIDTH; i < WIDTH*2; i++){
            kolonne += ENRUTE;
            rekke -= ENRUTE;
            if((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0)){
                muligeTrekk[i] = "" + kolonne +""+ rekke;
            }else{
                muligeTrekk[i] = "" + getPosX() +""+ getPosY();
            }
        }
        kolonne = getPosX();
        rekke = getPosY();
        for(int i = WIDTH*2; i < WIDTH*3; i++){
            kolonne -= ENRUTE;
            rekke -= ENRUTE;
            if((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0)){
                muligeTrekk[i] = "" + kolonne +""+ rekke;
            }else{
                muligeTrekk[i] = "" + getPosX() +""+ getPosY();
            }
        }
        kolonne = getPosX();
        rekke = getPosY();
        for(int i = WIDTH*3; i<WIDTH*4; i++){
            kolonne -= ENRUTE;
            rekke += ENRUTE;
            if((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0)){
                muligeTrekk[i] = "" + kolonne +""+ rekke;
            }else{
                muligeTrekk[i] = "" + getPosX() +""+ getPosY();
            }
        }
        return muligeTrekk;
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
    public void resetTrekk(){
    }
}
    
