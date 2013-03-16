package Main;

import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

/** 
 * Hovedklassen for sjakkspillet
 * 
 * Denne klassen tar seg av utplasseringen av brettet,
 * brikkene og lignende. I tillegg er denne klassen sjefen over vinduet som
 * viser alt sammen. Denne klassen er en subklasse av BasicGame
 * 
 */
public class Main extends BasicGame implements MouseListener{
    private int orgX;
    private int orgY;
    private Pieces brikke;
    private TiledMap board;
    private ArrayList<Pieces> list = new ArrayList<>();
    private ArrayList<Blockers> blockerliste = new ArrayList<>(); 
    private ArrayList<String> text = new ArrayList<>();
    public ArrayList<LegalMoves> muligeTrekk = new ArrayList<>();
    private Board brett = new Board();
    private Image pw, rw, bw, knw, qw, kw;
    private Image pb, rb, bb, knb, qb, kb;
    private Image SjMa;
    private Image  nyttspill, muligetrekk; 
    private Image blocker, p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
    private String bleh = "";
    private String oldpos = "";
    private boolean farge = true;
    private VariousMethods v = new VariousMethods();
    /**
     * Konstruktøren til Main hvor navnet til vinduet skrives inn
     * 
     * Denne konstruktøren er arvet fra {@link BasicGame}
     * 
     */
    public Main(){
        super("Chess Game");
    }
    
    @Override
    /**
     * Initierer alle diverse variabler
     * 
     */
    public void init(GameContainer container) throws SlickException{
        muligetrekk = new Image("grx/GUL.png");
        board = new TiledMap("grx/1.tmx");
        pw = new Image("grx/WHPaW.png");
        pb = new Image("grx/BLPaW.png");
        rw = new Image("grx/BLToW.png");
        rb = new Image("grx/WHToW.png");
        kw = new Image("grx/WHKiN.png");
        kb = new Image("grx/BLKiN.png");
        qw = new Image("grx/WHQuE.png");
        qb = new Image("grx/BLQuE.png");
        bw = new Image("grx/WHBiS.png");
        bb = new Image("grx/BLBiS.png");
        knw = new Image("grx/WHKnI.png");
        knb = new Image("grx/BLKnI.png");
        blocker = new Image("grx/rodX.png");
        nyttspill = new Image ("grx/NyttSpillKnapp.png");
        
        
        for(int i = 0; i<8; i++){
            list.add(new Pawn(pw, i, 1, "Pawn", true,0));
        }
        for(int i =0 ; i < 8; i++){
            list.add(new Pawn(pb, i, 6, "Pawn", false,0));
        }
        list.add(new Rook(rw, 0, 7, "Rook", false));
        list.add(new Rook(rw, 7, 7, "Rook", false));
        list.add(new Rook(rb, 0, 0, "Rook", true));
        list.add(new Rook(rb, 7, 0, "Rook", true));
        list.add(new King(kw,3, 0, "King", true));
        list.add(new King(kb, 3,7, "King", false));
        list.add(new Queen(qw, 4,0,"Queen", true));
        list.add(new Queen(qb, 4, 7, "Queen", false));
        list.add(new Bishop(bw, 2, 0, "Bishop", true));
        list.add(new Bishop(bw, 5, 0, "Bishop", true));
        list.add(new Bishop(bb, 2, 7, "Bishop", false));
        list.add(new Bishop(bb, 5, 7, "Bishop", false));
        list.add(new Knight(knw, 1, 0, "Knight", true));
        list.add(new Knight(knw, 6, 0, "Knight", true));
        list.add(new Knight(knb, 1, 7, "Knight", false));
        list.add(new Knight(knb, 6, 7, "Knight", false));
        
            for(Pieces p : list){   
                brett.addPiece(p);
                    
            }
        p1 = new Image("grx/1.png");
        p2 = new Image("grx/2.png");
        p3 = new Image("grx/3.png");
        p4 = new Image("grx/4.png");
        p5 = new Image("grx/5.png");
        p6 = new Image("grx/6.png");
        p7 = new Image("grx/7.png");
        p8 = new Image("grx/8.png");
        p9 = new Image("grx/9.png");
        p10 = new Image("grx/10.png");    
    }
        
    @Override
    /**
     * Oppdaterer spillet så lenge det ikke er pause
     */
    public void update(GameContainer container, int delta) throws SlickException{
        Input input = container.getInput();
        input.addMouseListener(this);
    }
    
    @Override
    /**
     * Tegner diverse bilder i vinduet.
     */
    public void render(GameContainer container, Graphics g) throws SlickException{
        board.render(0,0);
        for(LegalMoves l : muligeTrekk){
            l.getImage().draw(l.getPosX()* 64, l.getPosY()*64);
        }
        for(Pieces ps : list){
            ps.getImage().draw(ps.getPosX()*64,ps.getPosY()*64);
        }
        if(brikke != null){
            brikke.getImage().draw(brikke.getPosX()*64, brikke.getPosY()*64);
        }
        nyttspill.draw(512, 0);
        g.drawString(bleh, 512, 112);
        
        
        p1.draw(950,112);
        p2.draw(950,144);
        p3.draw(950,176);
        p4.draw(950,208);
        p5.draw(950,240);
        p6.draw(950,272);
        p7.draw(950,304);
        p8.draw(950,336);
        p9.draw(950,368);
        p10.draw(950,400); 
        
        
    
    }
    /**
     * Denne metoden tar inn en String som skal skrives til vinduet.
     * 
     * Metoden legger parameteren inn i ArrayListen av strenger og i tillegg 
     * legges den til vinduet for å vises der. Hvis antall trekk som er vist på
     * skjermen går over 20 trekk så bytter denne metoden i tillegg side.
     * 
     * @param sur Tekststreng som skal skrives til listen over strenger
     */
    public void textDraw(String sur){
        text.add(sur);
        
        if(text.size() % 20 == 0){
            bleh = "";
            bleh += sur;
            
        }else{
            
            
            bleh += sur;
        }
        
        
    
    }
    /**
     * 
     * Bytter side ved visning av gamle trekk
     * 
     * @param pagenr Tar inn en int fra 0 til 9 som bytter side etter dette
     */
    public void scrollText(int pagenr){
        bleh = "";
        for(int i = pagenr * 20; i < i +20; i++){
            if(i<text.size()) bleh += text.get(i);
            
        }
        
    }
    /**
     * Hovedmetoden som starter selve spillet
     * 
     * 
     * @param args String-tabell av argumenter hvis det skulle være noen
     * @throws SlickException Kaster en SlickException om noe skulle gå galt
     */
    public static void main(String[] args) throws SlickException{
        try{
            AppGameContainer spill = new AppGameContainer(new Main());
            spill.setDisplayMode(980, 512, false);
            spill.setShowFPS(false);
            spill.start();
        }
        catch(SlickException e){
            e.printStackTrace();
        }
    }
    /**
     * Sjekker om parameterene stemmer overens.
     * 
     * Sjekker om koordinatene musepekeren befinner seg i tillegg inneholder
     * en brikke og om også inneholder denne brikke
     * 
     * 
     * @param x Tar inn en x-koordinat etter hvor musepekeren befinner seg
     * @param y Tar inn en y-koordinat etter hvor musepekeren befinner seg
     * @param p Tar inn en {@link Pieces} for å sammenligne med de andre paramerene
     * @param t Tar inn en {@link Tile} for å sammenlignes med de andre parameterene
     * @return En boolsk verdi om parameterene befinner seg på samme sted
     */
    private boolean isSame(int x, int y, Pieces p, Tile t){
        if(p.getPosX() == x/64 && p.getPosY() == y/64){
            if(p.getPosX() == t.getPosX() && p.getPosY() == t.getPosY()&& t.getPiece() != null){
                return true;
            }
        }
        return false;     
    }
    /**
     * 
     * @return En boolsk verdi av hvem sin tur det er, true = hvit og false = svart
     */
    public boolean turn(){
        return farge;
    }
    /**
     * Endrer runden til den som kan flytte brikkene sine.
     * 
     * Denne metoden brukes bare når en brikke har blitt sluppet i 
     * {@link #mouseReleased(int, int, int)}
     * 
     * @param kalle Tar inn en {@link Pieces} som endrer tur etter fargen på brikken
     */
    public void changeTurn(Pieces kalle){
        if(kalle.getWhite() == true){
            farge = false;
        }
        if(kalle.getWhite() == false){
            farge = true;
        }
    }
   /**
    * Sjekker om en {@link Pieces} kan flyttes til {@link Tile}
    * 
    * Metoden sjekker blant annet om at en rute er tom eller om brikken kan ta
    * en rute fra en brikke av en annen farge. I tillegg sjekker den om det
    * finnes {@link Blockers} brikken prøver å flytte til
    * 
    * @param p Tar inn en {@link Pieces} for å sjekke om det kan flyttes hit
    * @param t Tar inn en {@link Tile} for å sjekke om det kan flyttes hit
    * @param helemetoden Eksluderer noen linjer av kode hvis false
    * @return true hvis brikken kan flyttes hit, false hvis ikke
    */
    public boolean canMoveTo(Pieces p, Tile t, boolean helemetoden){
        if(turn() == p.getWhite()){
        if(t.getPosX() == orgX && t.getPosY() == orgY) return false;
        for(int i = 0; i < p.movePiece().length; i++){
            if(!blockerliste.isEmpty()){
            for(int n = 0; n < blockerliste.size(); n++){
                if(blockerliste.get(n).getPosX() == p.movePieceX(p.movePiece())[i] && blockerliste.get(n).getPosY() == p.movePieceY(p.movePiece())[i]){
                    if(t.getPosX() == p.movePieceX(p.movePiece())[i] && t.getPosY() == p.movePieceY(p.movePiece())[i]){
                    return false;
                    }
                }
            }
           }
        
           if(t.getPosX() == p.movePieceX(p.movePiece())[i] && t.getPosY() == p.movePieceY(p.movePiece())[i]){
               if(p instanceof Pawn && t.getPiece() == null){
                   if((t.getPosX() == p.movePieceX(p.movePiece())[0] && t.getPosY() == p.movePieceY(p.movePiece())[0])
                       || (t.getPosX() == p.movePieceX(p.movePiece())[1] && t.getPosY() == p.movePieceY(p.movePiece())[1])) return true;
           
           }else if(t.getPiece() == null){ 
            return true;
              }else if(t.getPiece() != null && t.getPiece().getWhite() != p.getWhite()){
                  for(Pieces b : list){
                      if(p instanceof Pawn && t.getPosX() == b.getPosX() && t.getPosY() == b.getPosY()){
                          if((b.getPosX() == p.movePieceX(p.movePiece())[2] && b.getPosY() == p.movePieceY(p.movePiece())[2])
                            || (b.getPosX() == p.movePieceX(p.movePiece())[3] && b.getPosY() == p.movePieceY(p.movePiece())[3])){
                            if(helemetoden == true)removeTakenPiece(b,t);
                            return true;
                              
                          }
                  
                      
                  }else if(t.getPosX() == b.getPosX() && t.getPosY() == b.getPosY()){
                          if(helemetoden == true)removeTakenPiece(b,t);
                          return true;
                      }
                  }
              }
              }
           }
       }
    return false;
    }
    
    /**
     * Setter ut {@link Blockers} etter hvor en brikke befinner seg
     * 
     * Denne metoden bruker metodene fra {@link VariousMethods} for å plassere
     * usynlige {@link Blockers} på brettet ut fra hvor brikken som er parameteren
     * befinner seg.
     * 
     * 
     * @param p Tar inn en brikke som bestemmer hvor {@link Blockers} skal settes ut
     */
    private void setBlockers(Pieces p){
        if(!(p instanceof King || p instanceof Knight)){
        for(int i = 0; i < list.size(); i++){ 
            for(Blockers b : v.getArrayList(p, list.get(i))){
                b.setImage(blocker);
                if(!blockerliste.contains(b)){
                    if(!(b.getPosY() == p.getPosY() && b.getPosX() == p.getPosX())){
                        blockerliste.add(b);
                        }
                    }
                }
            }
        }
    }
    /**
     * 
     * Setter ut bilder som viser hvor brikken kan flyttes til
     * 
     * @param p Brikke som det skal settes muligetrekk ruter for
     */
    public void setLegalMoves(Pieces p){
        for(Tile t : brett.getArrayList()){
                    if(canMoveTo(p,t,false)){
                        LegalMoves l = new LegalMoves(muligetrekk,t.getPosX(), t.getPosY(), "LegalMove", p.getWhite());
                        l.setImage(muligetrekk);
                        if(!muligeTrekk.contains(l)) muligeTrekk.add(l);
                    
                
            }
        }
    }
    /**
     * Fjerner alle {@link Blockers} som finnes i ArrayLister
     */     
    private void clearBlockerlist(){
        blockerliste.clear();
        v.clearArray();
    }
    /**
     * Sier spillet blir uavgjort hvis det bare er to konger igjen på brettet
     * 
     */
    private void drawedGame(){
        for(Pieces p : list){
            if(list.size() <= 2 && (p instanceof King) ){
                showMessageDialog(null,"Draw!");
            }
        }
    }
    
    /**
     * Fjerner en {@link Pieces} fra brettet på en {@link Tile}
     * 
     * Metoden sjekker om det finnes en brikke på denne ruten og om det gjør det
     * så fjernes brikken fra ArrayListen over brikker her og på ruten
     * 
     * 
     * @param p En brikke som skal fjernes
     * @param t En rute hvor det skal fjernes en brikke
     */
    private void removeTakenPiece(Pieces p, Tile t){
        if(t.getPiece() != null){
            if(t.getPosX() == p.getPosX() && t.getPosY() == p.getPosY()){
                if(t.getPiece().getPosX() == p.getPosX() && t.getPiece().getPosY() == p.getPosY()){
                    list.remove(p);
                    t.list.clear();
                }
            }
        }
    }
    
    
    
    @Override
    /**
     * {@inheritDoc}
     */
	public void mouseClicked(int button, int x, int y, int clickCount) {
            if(button == 0){
                if(x > 512 && x< 980){
                    if (y> 0 && y < 112){
                        startgame();
                        
                    }
                }
                if(x > 950 && x < 982){
                    if(y > 112 && y < 144) scrollText(0);
                    if(y > 144 && y < 176) scrollText(1);
                    if(y > 176 && y < 208) scrollText(2);
                    if(y > 208 && y < 240) scrollText(3);
                    if(y > 240 && y < 272) scrollText(4);
                    if(y > 272 && y < 304) scrollText(5);
                    if(y > 304 && y < 336) scrollText(6);
                    if(y > 336 && y < 368) scrollText(7);
                    if(y > 368 && y < 400) scrollText(8);
                    if(y > 400 && y < 432) scrollText(9);
                }
                
                
            }
	}
    private void clearLegalMoves(){
        muligeTrekk.clear();
    }
 
    @Override
    /**
     * {@inheritDoc}
     */
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
    }
 
    @Override
    /**
     * {@inheritDoc}
     */
    public void mousePressed(int button, int x, int y) {
        if(button == 0){
            for(Tile t : brett.getArrayList()){
                for(Pieces p : list){
                    if(isSame(x, y, p, t)){
                        orgX = p.getPosX();
                        orgY = p.getPosY();                                
                        t.list.clear();
                        brikke = p;
                        oldpos = brikke.posisjonX() + "" + brikke.posisjonY();
                        setBlockers(p);
                        setLegalMoves(p);
                    }
                }
            }
        }
    }
 
    @Override
    /**
     * {@inheritDoc}
     */
    public void mouseReleased(int button, int x, int y) {
        if(brikke == null)return;
        drawedGame();
        for(Pieces p : list){
 
            for(Tile t : brett.getArrayList()){
                for(Tile s : brett.getArrayList()){
                    if(t.getPosX() == x/64 && t.getPosY() == y/64){
                        if(brikke.getPosX() == t.getPosX() && brikke.getPosY() == t.getPosY()){
                            p = brikke;
                            p.setPosX(orgX);
                            p.setPosY(orgY);
                            if(canMoveTo(p, t, true)) {
                               p.setPosX(t.getPosX());
                               p.setPosY(t.getPosY());
                               t.list.add(p);
                               if(p instanceof Pawn)p.inkrementerAntTrekk();
                               orgX = -8;
                               orgY = -8;    
                               String sur ="Move " + (text.size()+1)+ ": " +  brikke + " moves from " + oldpos + " to " + p.posisjonX() + "" + p.posisjonY() + "\n";
                               textDraw(sur);
                               brikke = null;
                               if(sjakkMatt() != null){
                                   text.clear();
                                   bleh ="";
                                   list.clear();
                                   textDraw(sjakkMatt());
                               }
                               clearBlockerlist();
                               changeTurn(p);
                               clearLegalMoves();
                               return;
                            }
                        }else{
                            if(orgX == s.getPosX() && orgY == s.getPosY()){
                                p.setPosX(orgX);
                                p.setPosY(orgY);
                                s.list.add(p);
                                brikke = null; 
                                orgX = -8;
                                orgY = -8;
                                textDraw("Ugyldig Trekk \n");
                                clearBlockerlist();
                                clearLegalMoves();
                                return;
                            }
                        }
                    }
                }
            }
        }
        for(Pieces p : list){
               for(Tile t : brett.getArrayList()){
                    if(orgX == t.getPosX() && orgY == t.getPosY()){
                       p = brikke; 
                       p.setPosX(orgX);
                       p.setPosY(orgY); 
                       t.list.add(p);
                       brikke = null;
                       orgX = -8;
                       orgY = -8;
                       clearBlockerlist();
                       clearLegalMoves();
                       return;
                    }
               }
         }
    }
 
    /**
     * {@inheritDoc}
     */@Override
    public void mouseWheelMoved(int change) {
    }
        
    @Override
    /**
     * {@inheritDoc}
     */
    public void mouseDragged(int oldx, int oldy, int newx, int newy){
       if(brikke != null){
            brikke.getImage().draw(brikke.getPosX(), brikke.getPosY());
            brikke.setPosX(newx/64);
            brikke.setPosY(newy/64);
       }
    }
        
    @Override
    /**
     * {@inheritDoc}
     */
    public void inputStarted(){
    }
 
    @Override
    /**
     * {@inheritDoc}
     */
    public void inputEnded() {
    }
 
    @Override
    /**
     * {@inheritDoc}
     */
    public boolean isAcceptingInput() {
    return true;
    }
 
    @Override
    /**
     * {@inheritDoc}
     */
    public void setInput(Input arg0) {	
    }
    /**
     * Restarter spillet og setter brikkene på plass hvor de skal være
     */    
    public void startgame(){
        bleh = "";
        brett.clearArrayList();
        list.clear();
        text.clear();
        farge = true;
        
        
        for(int i = 0; i<8; i++){
            list.add(new Pawn(pw, i, 1, "Pawn", true,0));
        }
        
        for(int i =0 ; i < 8; i++){
            list.add(new Pawn(pb, i, 6, "Pawn", false,0));
        }
        
        list.add(new Rook(rw, 0, 7, "Rook", false));
        list.add(new Rook(rw, 7, 7, "Rook", false));
        list.add(new Rook(rb, 0, 0, "Rook", true));
        list.add(new Rook(rb, 7, 0, "Rook", true));
        list.add(new King(kw,3, 0, "King", true));
        list.add(new King(kb, 3,7, "King", false));
        list.add(new Queen(qw, 4,0,"Queen", true));
        list.add(new Queen(qb, 4, 7, "Queen", false));
        list.add(new Bishop(bw, 2, 0, "Bishop", true));
        list.add(new Bishop(bw, 5, 0, "Bishop", true));
        list.add(new Bishop(bb, 2, 7, "Bishop", false));
        list.add(new Bishop(bb, 5, 7, "Bishop", false));
        list.add(new Knight(knw, 1, 0, "Knight", true));
        list.add(new Knight(knw, 6, 0, "Knight", true));
        list.add(new Knight(knb, 1, 7, "Knight", false));
        list.add(new Knight(knb, 6, 7, "Knight", false));
        
        for(Pieces p : list){   
            brett.addPiece(p);
        }
        
        for(Pieces i : list){
            if(i instanceof Pawn ){
                i.resetTrekk();
            }
        }
    }
    /**
     * Avslutter hvis spillet blir sjakkmatt
     * 
     * @return boolean
     */
    public String sjakkMatt(){
        int antKonger= 0;
        for(Pieces p : list){
            if(p instanceof King){
                antKonger++;
            }
         }
        for(Pieces p : list){
            if(antKonger != 2){
                if(p instanceof King){
                    if(p.getWhite()) return "Hvit vinner!\n";
                    if(!p.getWhite()) return "Svart vinner!\n";
                
            }
        }
    }
        return null;
    }
}
