package Main;

import org.newdawn.slick.Image;

class Queen extends Pieces{
     public Queen(Image bilde,int posX,int posY,String piecename, boolean isWhite){
        super(bilde,posX,posY, piecename, isWhite);
    }
    @Override
    public String[] movePiece(){
        String[] muligeTrekk = new String[64]; 
        int kolonne = getPosX();
        int rekke = getPosY();
        for(int i = 0; i < WIDTH; i++){
            kolonne += ENRUTE;
            if((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0)){
                muligeTrekk[i] = "" + kolonne +""+ rekke;
            }else{
                muligeTrekk[i] = "" + getPosX() +""+ getPosY();
            }
        }
        kolonne = getPosX();
        rekke = getPosY();
        for(int i = WIDTH; i < WIDTH*2; i++){
            kolonne -= ENRUTE;
            if((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0)){
                muligeTrekk[i] = "" + kolonne +""+ rekke;
            }else{
                muligeTrekk[i] = "" + getPosX() +""+ getPosY();
            }
        }
        kolonne = getPosX();
        rekke = getPosY();
        for(int i = WIDTH*2; i < WIDTH*3; i++){
            rekke += ENRUTE;
            if((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0)){
                muligeTrekk[i] = "" + kolonne +""+ rekke;
            }else{
                muligeTrekk[i] = "" + getPosX() +""+ getPosY();
            }
        }
        kolonne = getPosX();
        rekke = getPosY();
        for(int i = WIDTH*3; i < WIDTH*4; i++){
            rekke -= ENRUTE;
            if((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0)){
                muligeTrekk[i] = "" + kolonne +""+ rekke;
            }else{
                muligeTrekk[i] = "" + getPosX() +""+ getPosY();
            }
        }
        kolonne = getPosX();
        rekke = getPosY();
        for(int i = WIDTH* 4; i< WIDTH*5; i++){
            kolonne += ENRUTE;
            rekke += ENRUTE;
            
            if((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0)){
                muligeTrekk[i] = "" + kolonne +""+ rekke;
            }else{
                muligeTrekk[i] = "" + getPosX() +""+ getPosY();
            }
        }
        kolonne = getPosX();
        rekke = getPosY();
        for(int i = WIDTH*5; i < WIDTH*6; i++){
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
        for(int i = WIDTH*6; i < WIDTH*7; i++){
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
        for(int i = WIDTH*7; i<WIDTH*8; i++){
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
    public void inkrementerAntTrekk(){
    }
    
    public void resetTrekk(){
    }
}
