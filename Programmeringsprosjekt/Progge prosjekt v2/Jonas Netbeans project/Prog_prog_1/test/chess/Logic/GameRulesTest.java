/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.Logic;

import chess.Logic.Board;
import chess.Models.Pawn;
import chess.Models.Piece;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jørgen
 */
public class GameRulesTest {

    public GameRulesTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetLegalMoves() {
        System.out.println("getLegalMoves");
        Board b = new Board();
        Piece p = b.getPieceAt(7, 1); // Dette er en hest
        GameRules instance = new GameRules();
        if (instance.getLegalMoves(p, b)[5][2] == 1) {
            if (instance.getLegalMoves(p, b)[5][0] == 1) {
                System.out.println("Success! Hesten på (1,7) har indeed låv å flytte til (2,5) og (0,5).");
            }
        }
        if (instance.getLegalMoves(p, b)[4][4] != 1) {
            System.out.println("Success! Hesten på (1,7) skal ikke få lov til å flytte til (4,4)");
        }
        Piece p2 = b.getPieceAt(6, 2); // Dette er en bonde.
        if(instance.getLegalMoves(p2, b)[4][2] == 1){
            if(instance.getLegalMoves(p2, b)[5][2] == 1){
                System.out.println("Success! Bonden på (2,6) har låv til å flytte til (2,4) og (2,5)!");
            }
        }
        if(instance.getLegalMoves(p2, b)[1][1] !=1){
            System.out.println("Success! Bonden på (2,6) har ikke låv til å flytte til (1,1)");
        }
    }
    
}
