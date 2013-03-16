package Main;




import org.newdawn.slick.Image;

class Rook extends Pieces{
    public Rook(Image bilde,int posX,int posY,String piecename, boolean isWhite){
        super(bilde,posX,posY, piecename, isWhite);
    }
    
    @Override
    public String[] movePiece(){
        String[] muligeTrekk = new String[32]; 
        int kolonne = getPosX();
        int rekke = getPosY();
        for(int i = 0; i < WIDTH; i++){
            kolonne += ENRUTE;
            if((kolonne <= 7 && kolonne >= 0) && (rekke <= 7 && rekke >= 0)){
                muligeTrekk[i] = "" + kolonne +""+ rekke;
            }else{
                muligeTrekk[i] = "" + getPosX() +""+ getPosY();
            }
        }
        kolonne = getPosX();
        rekke = getPosY();
        for(int i = WIDTH; i < WIDTH*2; i++){
            kolonne -= ENRUTE;
            if((kolonne <= 7 && kolonne >= 0) && (rekke <= 7 && rekke >= 0)){
                muligeTrekk[i] = "" + kolonne +""+ rekke;
            }else{
                muligeTrekk[i] = "" + getPosX() +""+ getPosY();
            }
        }
        kolonne = getPosX();
        rekke = getPosY();
        for(int i = WIDTH*2; i < WIDTH*3; i++){
            rekke += ENRUTE;
            if((kolonne <= 7 && kolonne >= 0) && (rekke <= 7 && rekke >= 0)){
                muligeTrekk[i] = "" + kolonne +""+ rekke;
            }else{
                muligeTrekk[i] = "" + getPosX() +""+ getPosY();
            }
        }
        kolonne = getPosX();
        rekke = getPosY();
        for(int i = WIDTH*3; i < WIDTH*4; i++){
            rekke -= ENRUTE;
            if((kolonne <= 7 && kolonne >= 0) && (rekke <= 7 && rekke >= 0)){
                muligeTrekk[i] = "" + kolonne +""+ rekke;
            }else{
                muligeTrekk[i] = "" + getPosX() +""+ getPosY();
            }
        
        }
        return muligeTrekk;
    }
    
    @Override
    public void inkrementerAntTrekk(){
    }
    
    public void resetTrekk(){
    }
}