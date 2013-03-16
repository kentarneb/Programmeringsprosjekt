package Main;




import org.newdawn.slick.Image;
/**
 * Klasse som tilsvarer en knekt i sjakk
 * 
 * @param posX Posisjon i x-retning på brettet
 * @param posY Posisjon i y-retning på brettet
 * @param bilde Bildet som brukes for å tegne en viss brikke
 * @param piecename Navnet på brikken
 * @param isWhite Boolsk verdi som bestemmer om brikken er hvit eller ikke
 * 
 */
class Knight extends Pieces{
    
    
    public Knight(Image bilde,int posX,int posY,String piecename, boolean isWhite){
        super(bilde,posX,posY, piecename, isWhite);
    }
    
    
    @Override
    /**
     * {@inheritDoc}
     */
    
    public String[] movePiece(){
        String[] muligeTrekk = new String[8]; 
        int kolonne = getPosX();
        int rekke = getPosY();
        kolonne -= TORUTER;
        rekke += ENRUTE;
        if((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0)){
            muligeTrekk[0] =""+ kolonne +""+ rekke;
        }else{
            muligeTrekk[0] = "" + getPosX() +""+ getPosY();
        }
        kolonne += ENRUTE;
        rekke += ENRUTE;
        if((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0)){
            muligeTrekk[1] = "" + kolonne +"" +rekke;
        }else{
            muligeTrekk[1] = "" + getPosX() +""+ getPosY();
        }
        kolonne += TORUTER;
        if((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0)){
            muligeTrekk[2] = "" + kolonne +""+ rekke;
        }else{
            muligeTrekk[2] = "" + getPosX() +""+ getPosY();
        }
        kolonne += ENRUTE;
        rekke -= ENRUTE;
        if((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0)){
            muligeTrekk[3] = "" + kolonne +""+ rekke;
        }else{
            muligeTrekk[3] = "" + getPosX() +""+ getPosY();
        }
        rekke -= TORUTER;
        if((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0)){
            muligeTrekk[4] = "" + kolonne +""+ rekke;
        }else{
            muligeTrekk[4] = "" + getPosX() +""+ getPosY();
        }
        
        kolonne -= ENRUTE;
        rekke -= ENRUTE;
        if((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0)){
            muligeTrekk[5] = "" + kolonne +""+ rekke;
        }else{
            muligeTrekk[5] = "" + getPosX() +""+ getPosY();
        }
        kolonne -= TORUTER;
        if((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0)){       
            muligeTrekk[6] = "" + kolonne +""+ rekke;
        }else{
            muligeTrekk[6] = "" + getPosX() +""+ getPosY();
        }
        kolonne -= ENRUTE;
        rekke += ENRUTE;
        
        if((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0)){
            muligeTrekk[7] = "" + kolonne +""+ rekke;
        }else{
            muligeTrekk[7] = "" + getPosX() +""+ getPosY();
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
