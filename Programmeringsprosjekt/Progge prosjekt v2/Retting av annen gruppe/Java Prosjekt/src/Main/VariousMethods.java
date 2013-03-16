package Main;



import java.util.ArrayList;
import org.newdawn.slick.Image;
/**
 * Inneholder diverse metoder som brukes i {@link Main}
 * 
 */

public class VariousMethods {

    private Image blocker;
    private Blockers b;
    private ArrayList<Blockers> list = new ArrayList<>();
    
    /**
     * Blir blokkert fra sør.
     * 
     * Plasserer {@link Blockers} i en ArrayList for alle
     * trekkene som blir blokkert etter {@param p2}.
     * 
     * @param p1 Piece som blir blokkert
     * @param p2 Piece som blokkerer
     */
    public void South(Pieces p1, Pieces p2) {

         
        for(int i = 0; i < p1.movePiece().length; i++){
            if(p1.getPosX() == p2.getPosX() && p1.getPosY() < p2.getPosY()){
                int n = p2.getPosY() +1;
                for(int x =n; x< 8; x++){
                    if(x == p1.movePieceY(p1.movePiece())[i]){
                        b = new Blockers(null,p2.getPosX(),x,"blocker",p1.getWhite());
                        if(!list.contains(b)) list.add(b);
                    }
                }
            }
        }
    }
    
   /**
     * Blir blokkert fra sørvest.
     * 
     * Plasserer {@link Blockers} i en ArrayList for alle
     * trekkene som blir blokkert etter {@param p2}.
     * 
     * @param p1 Piece som blir blokkert
     * @param p2 Piece som blokkerer
     */
    public void southWest(Pieces p1, Pieces p2) {

         for(int i = 0; i< p1.movePiece().length; i++){
            if(p1.getPosX() > p2.getPosX() && p1.getPosY()< p2.getPosY()){
                for(int x = 0; x < 8; x++){
                int n = p2.getPosY() + x;
                int z = p2.getPosX() - x;
                
                        if(n == p1.movePieceY(p1.movePiece())[i] && z == p1.movePieceX(p1.movePiece())[i]){
                            if(!(p2.getPosY() == p1.movePieceY(p1.movePiece())[i] && p2.getPosX() == p1.movePieceX(p1.movePiece())[i])){
                            b = new Blockers(null, z, n, "blocker",p1.getWhite());
                        
                            if(!list.contains(b))
                               list.add(b);
                            }
                    }
                }
            }
        }
    }
    /**
     * Blir blokkert fra vest.
     * 
     * Plasserer {@link Blockers} i en ArrayList for alle
     * trekkene som blir blokkert etter {@param p2}.
     * 
     * @param p1 Piece som blir blokkert
     * @param p2 Piece som blokkerer
     */
    public void West(Pieces p1, Pieces p2) {

        for(int i = 0; i < p1.movePiece().length; i++){
            if(p1.getPosX() > p2.getPosX() && p1.getPosY() == p2.getPosY()){
                int z = p2.getPosX() -1;
                for(int u = z; u >= 0; u--){
                    if(z == p1.movePieceX(p1.movePiece())[i] && p1.getPosY() == p2.getPosY()){
                        b= new Blockers(null, u, p2.getPosY(),"blocker",p1.getWhite());
                        if(!list.contains(b)) list.add(b);
                    }
                }
            }
        }
    }
    /**
     * Blir blokkert fra nordvest.
     * 
     * Plasserer {@link Blockers} i en ArrayList for alle
     * trekkene som blir blokkert etter {@param p2}.
     * 
     * @param p1 Piece som blir blokkert
     * @param p2 Piece som blokkerer
     */
    public void northWest(Pieces p1, Pieces p2) {
            for(int i = 0; i < p1.movePiece().length; i++){
            
                if(p1.getPosX() > p2.getPosX() && p1.getPosY() > p2.getPosY()){
                for(int x = 0; x < 8; x++){
                int z = p2.getPosX() -x;
                int n = p2.getPosY() -x;
                
                        if(n == p1.movePieceY(p1.movePiece())[i] && z == p1.movePieceX(p1.movePiece())[i]){
                            b = new Blockers(null, z, n, "blocker", p1.getWhite());
                            if(!(b.getPosX() == p2.getPosX() && b.getPosY() == p2.getPosY())){
                                if(!list.contains(b)) list.add(b);
                            
                            }
                    }
                }
            }
        }
    }
    /**
     * Blir blokkert fra nord.
     * 
     * Plasserer {@link Blockers} i en ArrayList for alle
     * trekkene som blir blokkert etter {@param p2}.
     * 
     * @param p1 Piece som blir blokkert
     * @param p2 Piece som blokkerer
     */
    public void North(Pieces p1, Pieces p2) {
        for(int i = 0; i < p1.movePiece().length; i++){
            if(p1.getPosX() == p2.getPosX() && p1.getPosY() > p2.getPosY()){
                int n = p2.getPosY() -1;
                for(int x = n; x >= 0; x--){
                    if(x == p1.movePieceY(p1.movePiece())[i]){
                        b = new Blockers(null, p2.getPosX(), x, "blocker", p1.getWhite());
                        if(!list.contains(b)) list.add(b);
                    }
                }
            }
        }
    }
    /**
     * Blir blokkert fra nordøst.
     * 
     * Plasserer {@link Blockers} i en ArrayList for alle
     * trekkene som blir blokkert etter {@param p2}.
     * 
     * @param p1 Piece som blir blokkert
     * @param p2 Piece som blokkerer
     */
    public void northEast(Pieces p1, Pieces p2) {
        for(int i = 0; i < p1.movePiece().length; i++){
            if(p1.getPosX() < p2.getPosX() && p1.getPosY() > p2.getPosY()){
                for(int x = 0; x < 8; x++){
                    int n = p2.getPosY() -x;
                    int z = p2.getPosX() +x; 
                    if(z == p1.movePieceY(p1.movePiece())[i] && n == p1.movePieceX(p1.movePiece())[i]){
                         b = new Blockers(null, z, n, "blocker", p1.getWhite());
                         if(!(b.getPosX() == p2.getPosX() && b.getPosY() == p2.getPosY())){
                              if(!list.contains(b)) list.add(b);
                         }
                    }
                }
            }
        }
    }
    /**
     * Blir blokkert fra øst.
     * 
     * Plasserer {@link Blockers} i en ArrayList for alle
     * trekkene som blir blokkert etter {@param p2}.
     * 
     * @param p1 Piece som blir blokkert
     * @param p2 Piece som blokkerer
     */
    public void East(Pieces p1, Pieces p2) {
        for(int i = 0; i < p1.movePiece().length; i++){
            if(p1.getPosX() < p2.getPosX() && p1.getPosY() == p2.getPosY()){
                int z = p2.getPosX() +1;
                for(int u = z; u < 8; u++){
                    if(u == p1.movePieceX(p1.movePiece())[i]){
                        b= new Blockers(null, u, p2.getPosY(), "blocker", p1.getWhite());
                        if(!list.contains(b)) list.add(b);
                    }
                }
            }
        }
    }
    /**
     * Blir blokkert fra sørøst.
     * 
     * Plasserer {@link Blockers} i en ArrayList for alle
     * trekkene som blir blokkert etter {@param p2}.
     * 
     * @param p1 Piece som blir blokkert
     * @param p2 Piece som blokkerer
     */
    public void southEast(Pieces p1, Pieces p2) {
        for(int i = 0; i < p1.movePiece().length; i++){
            if(p1.getPosX() < p2.getPosX() && p1.getPosY() < p2.getPosY()){
                for(int x = 0; x < 8; x++){
                    int z = p2.getPosX() +x;
                    int n = p2.getPosY() +x;
                    if(!(z > 7 && n > 7)){
                        if(z == p1.movePieceX(p1.movePiece())[i] && n == p1.movePieceY(p1.movePiece())[i]){
                            if(!(p2.getPosY() == p1.movePieceY(p1.movePiece())[i] && p2.getPosX() == p1.movePieceX(p1.movePiece())[i])){
                                b = new Blockers(null, z, n,"blocker", p1.getWhite());
                                if(!list.contains(b)) list.add(b);
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     * Returnerer ArrayListen av {@link Blockers}.
     * 
     * Bruker alle blokkerer-metodene i klassen og
     * returnerer en ArrayList over disse.
     * 
     * @param p1 Piece som blir blokkert
     * @param p2 Piece som blokkerer
     * @return En ArrayList av {@link Blockers}
     */
    public ArrayList<Blockers> getArrayList(Pieces p1, Pieces p2) {
        South(p1, p2);
        southWest(p1, p2);
        West(p1, p2);
        northWest(p1, p2);
        North(p1, p2);
        northEast(p1, p2);
        East(p1, p2);
        southEast(p1, p2);
        return list;
    }
    /**
     * Fjerner alle {@link Blockers} fra ArrayListen
     */
    public void clearArray() {
        list.clear();
    }
}
