package Main;



import org.newdawn.slick.Image;
/**
 * Abstrakt klasse som er en mal for de andre brikkene
 * 
 * 
 */

public abstract class Pieces {
    Image bilde;
    private int posX;
    private int posY;
    private String piecename;
    private boolean white;
    /**
     * Konstant som har en verdi lik {@value }
     */
    public static final int ENRUTE = 1;
    /**
     * Konstant som har en verdi lik {@value }
     */
    public static final int TORUTER = 2;
    /**
     * Konstant som har en verdi lik {@value }
     */
    public static final int WIDTH = 8;
    /**
    * @param posX Posisjon i x-retning på brettet
    * @param posY Posisjon i y-retning på brettet
    * @param bilde Bildet som brukes for å tegne en viss brikke
    * @param piecename Navnet på brikken
    * @param isWhite Boolsk verdi som bestemmer om brikken er hvit eller ikke
    */
    public Pieces(Image bilde,int posX, int posY, String piecename, boolean isWhite){
        this.bilde = bilde;
        this.posX = posX;
        this.posY = posY;
        this.piecename = piecename;
        this.white = isWhite;
    }
    /**
     * Metode som oversetter {@link #posX} fra int til String
     * 
     * Metoden bruker {@link #posX} for å oversette int til String til
     * bruk i listen over trekkene som er gjort
     * 
     * 
     * @return String som er oversatt fra int til sjakk-koordinater
     */
    
    
    public String posisjonX(){
        String posisjon = "";
        if (posX == 0){
            posisjon = "A";
        }
        if (posX == 1){
            posisjon = "B";
        }
        if (posX == 2){
            posisjon = "C";
        }
        if (posX == 3){
            posisjon = "D";
        }
        if (posX == 4){
            posisjon = "E";
        }
        if (posX == 5){
            posisjon = "F";
        }
        if (posX == 6){
            posisjon = "G";
        }
        if (posX == 7){
            posisjon = "H";
        }
        return posisjon;
    }
    
    
    /**
     * Metode som oversetter {@link #posY} fra int til String
     * 
     * Metoden bruker {@link #posY} for å oversette int til String til
     * bruk i listen over trekkene som er gjort
     * 
     * 
     * @return String som er oversatt fra int til sjakk-koordinater
     */
    public String posisjonY(){
        String posisjon = "";
        if (posY == 0){
            posisjon = "1";
        }
        if (posY == 1){
        posisjon = "2";
        }
        if (posY == 2){
            posisjon = "3";
        }
        if (posY == 3){
            posisjon = "4";
        }
        if (posY == 4){
            posisjon = "5";
        }
        if (posY == 5){
            posisjon = "6";
        }
        if (posY == 6){
            posisjon = "7";
        }
        if (posY == 7){
            posisjon = "8";
        }
        return posisjon ;
    }
    
    /**
     * 
     * @return Posisjonen av brikken i x-retning
     */
    
    public int getPosX(){
        return posX;    
    }
    /**
     * 
     * @return Posisjonen av brikken i y-retning
     */
    public int getPosY(){
        return posY;
    }
    
    /**
     * 
     * @return Navnet på brikken
     */
    public String getPiecename(){
        return piecename;
    }
    
    /**
     * 
     * @return Om brikken er hvit eller ikke
     */
    public Boolean getWhite(){
        return white;
    }
    /**
     * 
     * @param newPosX Den nye posisjonen i x-retning for brikken
     */
    public void setPosX(int newPosX){
        if(newPosX >= 0 && newPosX <= 8){
            posX = newPosX;
        }else{
            posX = getPosX();
        }
    }
    
    /**
     * 
     * @param newPosY Den nye posisjonen i y-retning for brikken 
     */
    public void setPosY(int newPosY){
        if(newPosY >= 0 && newPosY <= 8){
            posY = newPosY;
        }else{
            posY = getPosY();
        }
     }
    
    /**
     * 
     * @return Bildet til brikken
     */
    
    public Image getImage(){
        return bilde;
    }
    
    /**
     * 
     * Returnerer en tabell over hvor brikken kan flyttes til
     * 
     * Tabellen som returneres oversettes av enten {@link #movePieceX(String[])}
     * eller {@link #movePieceY(String[])}
     * 
     * @return En String-tabell som blir oversatt
     */
    
    public abstract String[] movePiece();
    
    /**
     * Metoden oversetter{@link #movePiece()}
     * 
     * Metoden oversetter fra en String-tabell til en int tabell over trekk som
     * kan gjøres i x-retning
     * 
     * 
     * @param table String-tabell over hvilke trekk brikken kan gjøre 
     * @return En tabell over hvilke trekk som kan gjøres eksklusivt i x-retning
     */
    
    public int[] movePieceX(String[] table){
        int[] tabell = new int[table.length];
        for(int i = 0; i < table.length; i++){
            tabell[i] = Integer.parseInt(table[i].substring(0,1));
        }
        for(int i = 0; i < table.length; i++){
            if(tabell[i] > 8 || tabell[i] < 0){
            tabell[i] = getPosX();
            }
        }
        return tabell;
    }
    /**
     * Metoden oversetter{@link #movePiece()}
     * 
     * Metoden oversetter fra en String-tabell til en int tabell over trekk som
     * kan gjøres i y-retning
     * 
     * 
     * @param table String-tabell over hvilke trekk brikken kan gjøre 
     * @return En tabell over hvilke trekk som kan gjøres eksklusivt i y-retning
     */
    
    public int[] movePieceY(String[] table){
        int[] tabell = new int[table.length];
        for(int i = 0; i < table.length; i++){
            tabell[i] = Integer.parseInt(table[i].substring(1));
        }
        for(int i = 0; i <tabell.length; i++){
            if(tabell[i] > 8 || tabell[i] < 0){
                tabell[i]= getPosY();
            }
        }
        return tabell;
    }
    
    @Override
    
    /**
     * {@inheritDoc}
     */
    public String toString(){
        return "" + getPiecename();
    }
    
    /**
     * Metode som inkrementerer antall trekk hos en {@link Pawn}
     */
    
    public abstract void inkrementerAntTrekk();
     /**
     * Metode som nullstiller antall trekk hos en {@link Pawn}
     */
    public abstract void resetTrekk();
      
}

