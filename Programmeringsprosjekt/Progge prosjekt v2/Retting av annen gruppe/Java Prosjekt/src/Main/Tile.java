package Main;


import java.util.ArrayList;
/**
 * Klasse som håndterer en rute på sjakkbrettet
 * 
 */
public class Tile {
    private int posX;
    private int posY;
    /**
     * ArrayList av {@link Pieces} på denne ruten
     */
    public ArrayList <Pieces>list = new ArrayList<> (1);
    /**
     * 
     * @param posX Posisjon av ruten i x-retning
     * @param posY Posisjon av ruten i y-retning
     */
    public Tile(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }
    /**
     * 
     * @return Posisjonen av ruten i x-retning
     */
    public int getPosX(){
        return posX;
    }
    /**
     * 
     * @return Posisjonen av ruten i y-retning
     */
    public int getPosY(){
        return posY;
    }
    /**
     * 
     * 
     * @return Brikken som er på denne ruten
     */
    public Pieces getPiece(){
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }
    @Override
    /**
     * {@inheritDoc}
     */
    public String toString(){
        if(!list.isEmpty()){
            return "" + list.get(0).toString();
        }
        return "" + getPosX() + getPosY() + " Er tom";
    }
}
    

