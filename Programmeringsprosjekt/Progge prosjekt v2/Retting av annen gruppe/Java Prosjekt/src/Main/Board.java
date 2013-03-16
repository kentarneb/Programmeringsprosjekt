package Main;

import java.util.ArrayList; 
/**
 * Klasse som tar hånd om alle rutene
 * 
 * Klassen inneholder en ArrayList over {@link Tile}
 * 
 */
public class Board {
    private ArrayList <Tile> list = new ArrayList<>(); //ArrayList av alle de forskjellige rutene.
    
    /**
     * Oppretter alle de forskjellige rutene
     */
    public Board(){
        int kolonne = -1;
        int rekke = -1;
        for(int n = 0; n<8; n++){
            kolonne += 1;
            rekke = -1;
            for(int i = 0; i<8; i++){
                rekke += 1;
                list.add(new Tile(kolonne, rekke));  
            }
        }
    }
    
    @Override
    /**
     * {@inheritDoc}
     */
    public String toString(){
        String s = "";
        for(int i = 0; i<list.size(); i++){
            s += list.get(i).getPosX()+""+ list.get(i).getPosY() + " " + list.size() + " \n"; 
        }
        return s;
    }
    /**
     * 
     * @return ArrayListen over alle rutene
     */
    public ArrayList<Tile> getArrayList(){
        return list;
    }
    /**
     * Legger til en brikke på en rute
     * 
     * @param brikke Brikke som skal legges til
     */
    public void addPiece(Pieces brikke){
        for(Tile t : list){
            if(t.getPosX() == brikke.getPosX() && t.getPosY() == brikke.getPosY()){
                t.list.add(brikke);
            }
        }
    }
    
    /**
     * Fjerner alle elementene hos rutene
     * 
     */
    public void clearArrayList(){
        for(Tile t : list){
            t.list.clear();
        }
    }
}