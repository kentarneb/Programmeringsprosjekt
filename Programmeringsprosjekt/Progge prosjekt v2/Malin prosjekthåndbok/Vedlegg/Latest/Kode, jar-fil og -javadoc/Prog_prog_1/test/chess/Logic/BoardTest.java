/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.Logic;

import chess.Models.Piece;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * 
 */
public class BoardTest {
    
    public BoardTest() {
    }
    /**
     * Test of movePieceToPosition method, of class Board. Shows that a pawn at (1,7) can move to (1,5).
     * We also test the method getPieceAt() here.
     */
    @Test
    public void testMovePieceToPosition() {
        System.out.println("-----------\nmovePieceToPosition");
        int x = 7;
        int y = 2;      
        Board b = new Board();
        Piece p = b.getPieceAt(1, 7); // p er nå en sort bonde.
        System.out.println(p + " x:" +p.getX() + " y:" + p.getY());
        b.movePieceToPosition(x, y, p, b); //Sjekker ikke om lovlig, bare utfører flytt.
        System.out.println(p + " x:" +p.getX() + " y:" + p.getY());
        
        if(b.getPieceAt(y, x) == null){
            fail("Did not move piece");
        }
    }
    
    /**
     * Test of killPiece method, of class Board.
     */
    @Test
    public void testKillPiece() {
        System.out.println("killPiece"); 
        Board b = new Board();
        Piece p = b.getPieceAt(1, 7); // p er nå en sort bonde.
        b.killPiece(p);     
        System.out.println("Dead: " + b.getDeadBlack().get(0));
    }
}
