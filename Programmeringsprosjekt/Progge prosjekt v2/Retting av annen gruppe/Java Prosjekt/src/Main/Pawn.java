package Main;



import org.newdawn.slick.Image;
class Pawn extends Pieces{
    private int antTrekk;
    public Pawn(Image bilde,int posX,int posY,String piecename, boolean isWhite, int antTrekk){
        super(bilde,posX,posY, piecename, isWhite);
        this.antTrekk = antTrekk;
    }
    
    @Override
    public String[] movePiece(){
        String[] muligeTrekk = new String[4]; 
        int kolonne = getPosX();
        int rekke = getPosY();
        if(getWhite() == true){
            
                muligeTrekk[0] = "" + kolonne +""+ (rekke+=1);
                if(!((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0))){
                    muligeTrekk[0] = "" + getPosX() + "" + getPosY();
                }
                rekke = getPosY();
                if(getAntTrekk() == 0){
                    muligeTrekk[1] = "" + kolonne + "" +(rekke+=2);
                }else{
                    muligeTrekk[1] = "" + kolonne + "" + (rekke+=1);
                }
                if(!((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0))){
                    muligeTrekk[1] = "" + getPosX() + "" + getPosY();
                }
                rekke = getPosY();
                muligeTrekk[2] = "" + (kolonne+=1) +"" + (rekke+=1);
                
                if(!((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0))){
                    muligeTrekk[2] = "" + getPosX() + "" + getPosY();
                }
                rekke = getPosY();
                kolonne = getPosX();
                muligeTrekk[3] = "" + (kolonne-=1) + "" + (rekke +=1);
                
                if(!((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0))){
                    muligeTrekk[3] = "" + getPosX() + "" + getPosY();
                }
            }else{
            muligeTrekk[0] = "" + kolonne +""+ (rekke-=1);
            if(!((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0))){
                muligeTrekk[0] = "" + getPosX() + "" + getPosY();
            }    
            rekke = getPosY();
            if(getAntTrekk() == 0){
                muligeTrekk[1] = "" + kolonne + "" +(rekke-=2);
            }else{
                muligeTrekk[1] = "" + kolonne + "" + (rekke-=1);
            }
            if(!((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0))){
                muligeTrekk[1] = "" + getPosX() + "" + getPosY();
            }
            rekke = getPosY();
            muligeTrekk[2] = "" + (kolonne+=1) +"" + (rekke-=1);
            if(!((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0))){
                muligeTrekk[2] = "" + getPosX() + "" + getPosY();
            }
            rekke = getPosY();
            kolonne = getPosX();
            muligeTrekk[3] = "" + (kolonne-=1) + "" + (rekke -=1);
            if(!((kolonne <= 8 && kolonne >= 0) && (rekke <= 8 && rekke >= 0))){
                muligeTrekk[3] = "" + getPosX() +"" + getPosY();
            }
        }
        return muligeTrekk;
    }
    
    public int getAntTrekk(){
        return antTrekk;
    }
    
    @Override
    public void inkrementerAntTrekk(){
        antTrekk++;
    }
    
    @Override
    public void resetTrekk(){
        antTrekk = 0;
    }
        
    
}
