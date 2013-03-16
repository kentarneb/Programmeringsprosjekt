/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.Logic;

import chess.Models.*;
import java.io.Serializable;

/**
 * 
 * @author Jørgen
 * @version 0.2, 2. April 2012
 * 
 */
public class GameRules implements Serializable{

    private int x;
    private int y;
    private Board b;

    public GameRules() {
    }

    /**
     * This method returns all the legal moves for a King on a p's location on the Board.
     * @param p a Piece.
     * @return a matrix with 1 or null values.
     */
    public int[][] getMovesKing(Piece p) {
        x = p.getX();
        y = p.getY();
        int legalMoves[][] = new int[8][8];

        //Sjekker alle åtte mulige trekk en konge har.
        if ((x + 1) < 8) {
            if (b.getPieceAt(y, (x + 1)) != null) {
                if (p.isWhite() != b.getPieceAt(y, (x + 1)).isWhite()) {
                    legalMoves[y][(x + 1)] = 1;
                }
            } else {
                legalMoves[y][(x + 1)] = 1;
            }
        }

        if ((x + 1) < 8 && (y + 1) < 8) {
            if (b.getPieceAt((y + 1), (x + 1)) != null) {
                if (p.isWhite() != b.getPieceAt((y + 1), (x + 1)).isWhite()) {
                    legalMoves[(y + 1)][(x + 1)] = 1;
                }
            } else {
                legalMoves[(y + 1)][(x + 1)] = 1;
            }
        }

        if ((x - 1) > -1 && (y - 1) > -1) {
            if (b.getPieceAt((y - 1), (x - 1)) != null) {
                if (p.isWhite() != b.getPieceAt((y - 1), (x - 1)).isWhite()) {
                    legalMoves[(y - 1)][(x - 1)] = 1;
                }
            } else {
                legalMoves[(y - 1)][(x - 1)] = 1;
            }
        }

        if ((x + 1) < 8 && (y - 1) > -1) {
            if (b.getPieceAt((y - 1), (x + 1)) != null) {
                if (p.isWhite() != b.getPieceAt((y - 1), (x + 1)).isWhite()) {
                    legalMoves[(y - 1)][(x + 1)] = 1;
                }
            } else {
                legalMoves[(y - 1)][(x + 1)] = 1;
            }
        }

        if ((x - 1) > -1) {
            if (b.getPieceAt(y, (x - 1)) != null) {
                if (p.isWhite() != b.getPieceAt(y, (x - 1)).isWhite()) {
                    legalMoves[y][(x - 1)] = 1;
                }
            } else {
                legalMoves[y][(x - 1)] = 1;
            }
        }

        if ((y - 1) > -1) {
            if (b.getPieceAt((y - 1), x) != null) {
                if (p.isWhite() != b.getPieceAt((y - 1), x).isWhite()) {
                    legalMoves[(y - 1)][x] = 1;
                }
            } else {
                legalMoves[(y - 1)][x] = 1;
            }
        }

        if ((y + 1) < 8) {
            if (b.getPieceAt((y + 1), x) != null) {
                if (p.isWhite() != b.getPieceAt((y + 1), x).isWhite()) {
                    legalMoves[(y + 1)][x] = 1;
                }
            } else {
                legalMoves[(y + 1)][x] = 1;
            }
        }

        if ((x - 1) > -1 && (y + 1) < 8) {
            if (b.getPieceAt((y + 1), (x - 1)) != null) {
                if (p.isWhite() != b.getPieceAt((y + 1), (x - 1)).isWhite()) {
                    legalMoves[(y + 1)][x - 1] = 1;

                }
            } else {
                legalMoves[(y + 1)][x - 1] = 1;
            }
        }
        //Sjekker så om passant trekk går.
        if(p.isWhite()){
            
            if(p.getY() == 7 && p.getX() == 4){
                if(b.getPieceAt(7, 6) == null && b.getPieceAt(7, 5) == null){
                    if(b.getPieceAt(7,7) instanceof Rook){
                        legalMoves[7][7] = 1;
                    }
                }
                if(b.getPieceAt(7,3) == null && b.getPieceAt(7, 2) == null && b.getPieceAt(7, 1)==null){
                    if(b.getPieceAt(7, 0) instanceof Rook){
                        legalMoves[7][0] = 1;
                    }
                }
            }
        }
        if(!p.isWhite()){
            if(p.getY() == 0 && p.getX() == 4){
                if(b.getPieceAt(0, 6) == null && b.getPieceAt(0, 5) == null){
                    if(b.getPieceAt(0,7) instanceof Rook){
                        legalMoves[0][7] = 1;
                    }
                }
                if(b.getPieceAt(0,3) == null && b.getPieceAt(0, 2) == null && b.getPieceAt(0, 1)==null){
                    if(b.getPieceAt(0, 0) instanceof Rook){
                        legalMoves[0][0] = 1;
                    }
                }
            }
        }

        return legalMoves;

    }

    /**
     * This method returns all the legal moves for a Rook on a p's location on the Board.
     * @param p a Piece.
     * @return a matrix with 1 or null values.
     */
    public int[][] getMovesRook(Piece p) {
        x = p.getX();
        y = p.getY();
        int legalMoves[][] = new int[8][8];

        for (int i = x + 1; i < 8; i++) {//Traversing from piece coords, right till end of board.
            if (b.getPieceAt(y, i) != null) {
                if (p.isWhite() == b.getPieceAt(y, i).isWhite()) {
                    break;
                } else {
                    legalMoves[y][i] = 1;
                    break;
                }
            } else {
                legalMoves[y][i] = 1;
            }
        }
        for (int i = x - 1; i > -1; i--) {//Traversing from piece coords, left till end of board.
            if (b.getPieceAt((y), i) != null) {
                if (p.isWhite() == b.getPieceAt((y), i).isWhite()) {
                    break;
                } else {
                    legalMoves[(y)][i] = 1;
                    break;
                }
            } else {
                legalMoves[y][i] = 1;
            }
        }
        for (int i = y - 1; i > -1; i--) { //Traversing from piece coords, downwards till end of board.
            if (b.getPieceAt((i), x) != null) {
                if (p.isWhite() == b.getPieceAt(i, x).isWhite()) {
                    break;
                } else {
                    legalMoves[i][x] = 1;
                    break;
                }
            } else {
                legalMoves[i][x] = 1;
            }
        }
        for (int i = y + 1; i < 8; i++) { //Traversing from piece coords, upwards till end of board.
            if (b.getPieceAt((i), x) != null) {
                if (p.isWhite() == b.getPieceAt(i, x).isWhite()) {
                    break;
                } else {
                    legalMoves[i][x] = 1;
                    break;
                }
            } else {
                legalMoves[i][x] = 1;
            }
        }
        return legalMoves;
    }

    /**
     * This method returns all the legal moves for a white Pawn on a p's location on the Board.
     * @param p a Piece.
     * @return a matrix with 1 or null values.
     */
    public int[][] getMovesWhitePawn(Pawn p) {
        x = p.getX();
        y = p.getY();
        int legalMoves[][] = new int[8][8];

        if (!p.isDrawn()) { //Sjekker om brikken er brukt før.
            for (int i = (y - 1); i > (y - 3); i--) { //Brikken er brukt før, og sjekker om den kan plasseres
                if (b.getPieceAt(i, x) != null) {//på plassen ovenfor, for så å sjekke om 2 plasser ovenfor.
                    break;//Setter plassene som lovlig trekk om den er trekt og om ingen står der fra før.
                } else {
                    legalMoves[i][x] = 1;
                }
            }
            if ((x - 1) > -1) { //Sjekker at brikken ikke går utenfor brettet.
                if (b.getPieceAt((y - 1), (x - 1)) != null) {//Sjekker at plassen diagonalt fram ikke er ledig.
                    if (p.isWhite() != b.getPieceAt((y - 1), (x - 1)).isWhite()) {//Sjekker at det er en fiende.
                        legalMoves[(y - 1)][(x - 1)] = 1;//Setter plassen som lovlig trekk.
                    }
                }
            }
            if ((x + 1) < 8) {//Det samme som if setningen over, bare motsatt diagonal.
                if (b.getPieceAt((y - 1), (x + 1)) != null) {
                    if (p.isWhite() != b.getPieceAt((y - 1), (x + 1)).isWhite()) {
                        legalMoves[(y - 1)][(x + 1)] = 1;
                    }
                }
            }
        } else {//Om brikken har blitt flyttet før. Da kan den bare gå et skritt rett fram, eller diagonalt en vei.
            if ((y - 1) > -1) { //Sjekker at brikken ikke går utenfor brettet.

                if (b.getPieceAt((y - 1), x) == null) { //Sjekker om plassen framfor er ledig.
                    legalMoves[(y - 1)][x] = 1; //Setter plassen som lovlig trekk. Rett fram.
                }
                if ((x - 1) > -1) { //Sjekker at brikken ikke går utenfor brettet.
                    if (b.getPieceAt((y - 1), (x - 1)) != null) {//Sjekker at plassen diagonalt fram ikke er ledig.
                        if (p.isWhite() != b.getPieceAt((y - 1), (x - 1)).isWhite()) {//Sjekker at det er en fiende.
                            legalMoves[(y - 1)][(x - 1)] = 1;//Setter plassen som lovlig trekk.
                        }
                    }
                }
                if ((x + 1) < 8) {//Det samme som if setningen over, bare motsatt diagonal.
                    if (b.getPieceAt((y - 1), (x + 1)) != null) {
                        if (p.isWhite() != b.getPieceAt((y - 1), (x + 1)).isWhite()) {
                            legalMoves[(y - 1)][(x + 1)] = 1;
                        }
                    }
                }
            }

        }
        return legalMoves;
    }

    /**
     * This method returns all the legal moves for a black Pawn on a p's location on the Board.
     * @param p a Piece.
     * @return a matrix with 1 or null values.
     */
    public int[][] getMovesBlackPawn(Pawn p) {
        x = p.getX();
        y = p.getY();
        int legalMoves[][] = new int[8][8];

        if (!p.isDrawn()) { //Sjekker om brikken er brukt før.
            for (int i = (y + 1); i < (y + 3); i++) { //Brikken er brukt før, og sjekker om den kan plasseres
                if (b.getPieceAt(i, x) != null) {//på plassen ovenfor, for så å sjekke om 2 plasser ovenfor.
                    break;//Setter plassene som lovlig trekk om den er trekt og om ingen står der fra før.
                } else {
                    legalMoves[i][x] = 1;
                }
            }
            if ((x - 1) > -1) { //Sjekker at brikken ikke går utenfor brettet.
                if (b.getPieceAt((y + 1), (x - 1)) != null) {//Sjekker at plassen diagonalt fram ikke er ledig.
                    if (p.isWhite() != b.getPieceAt((y + 1), (x - 1)).isWhite()) {//Sjekker at det er en fiende.
                        legalMoves[(y + 1)][(x - 1)] = 1;//Setter plassen som lovlig trekk.
                    }
                }
            }
            if ((x + 1) < 8) {//Det samme som if setningen over, bare motsatt diagonal.
                if (b.getPieceAt((y + 1), (x + 1)) != null) {
                    if (p.isWhite() != b.getPieceAt((y + 1), (x + 1)).isWhite()) {
                        legalMoves[(y + 1)][(x + 1)] = 1;
                    }
                }
            }
        } else {//Om brikken har blitt flyttet før. Da kan den bare gå et skritt rett fram, eller diagonalt en vei.
            if ((y + 1) < 8) { //Sjekker at brikken ikke går utenfor brettet.

                if (b.getPieceAt((y + 1), x) == null) { //Sjekker om plassen framfor er ledig.
                    legalMoves[(y + 1)][x] = 1; //Setter plassen som lovlig trekk. Rett fram.
                }
                if ((x - 1) > -1) { //Sjekker at brikken ikke går utenfor brettet.
                    if (b.getPieceAt((y + 1), (x - 1)) != null) {//Sjekker at plassen diagonalt fram ikke er ledig.
                        if (p.isWhite() != b.getPieceAt((y + 1), (x - 1)).isWhite()) {//Sjekker at det er en fiende.
                            legalMoves[(y + 1)][(x - 1)] = 1;//Setter plassen som lovlig trekk.
                        }
                    }
                }
                if ((x + 1) < 8) {//Det samme som if setningen over, bare motsatt diagonal.
                    if (b.getPieceAt((y + 1), (x + 1)) != null) {
                        if (p.isWhite() != b.getPieceAt((y + 1), (x + 1)).isWhite()) {
                            legalMoves[(y + 1)][(x + 1)] = 1;
                        }
                    }
                }
            }

        }
        return legalMoves;
    }

    /**
     * This method returns all the legal moves for a Bishop on the p's location on the Board.
     * @param p a Piece
     * @return a matrix with 1 or null values.
     */
    public int[][] getMovesBishop(Piece p) {
        x = p.getX();
        y = p.getY();
        int legalMoves[][] = new int[8][8];

        for (int i = 1; i < 8; i++) {//Traversing from piece coords, right till end of board.
            if ((x + i) < 8 && (y + i) < 8) {
                if (b.getPieceAt((y + i), (x + i)) != null) {
                    if (p.isWhite() == b.getPieceAt((y + i), (x + i)).isWhite()) {
                        break;
                    } else {
                        legalMoves[(y + i)][(x + i)] = 1;
                        break;
                    }
                } else {
                    legalMoves[(y + i)][(x + i)] = 1;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if ((x - i) > -1 && (y + i) < 8) {
                if (b.getPieceAt((y + i), (x - i)) != null) {
                    if (p.isWhite() == b.getPieceAt((y + i), (x - i)).isWhite()) {
                        break;
                    } else {
                        legalMoves[(y + i)][(x - i)] = 1;
                        break;
                    }
                } else {
                    legalMoves[(y + i)][(x - i)] = 1;
                }
            }
        }

        for (int i = 1; i < 8; i++) {

            if ((x - i) > -1 && (y - i) > -1) {
                if (b.getPieceAt((y - i), (x - i)) != null) {
                    if (p.isWhite() == b.getPieceAt((y - i), (x - i)).isWhite()) {
                        break;
                    } else {
                        legalMoves[(y - i)][(x - i)] = 1;
                        break;
                    }
                } else {
                    legalMoves[(y - i)][(x - i)] = 1;
                }
            }
        }

        for (int i = 1; i < 8; i++) {

            if ((x + i) < 8 && (y - i) > -1) {
                if (b.getPieceAt((y - i), (x + i)) != null) {
                    if (p.isWhite() == b.getPieceAt((y - i), (x + i)).isWhite()) {
                        break;
                    } else {
                        legalMoves[(y - i)][(x + i)] = 1;
                        break;
                    }
                } else {
                    legalMoves[(y - i)][(x + i)] = 1;
                }
            }
        }
        return legalMoves;
    }

    /**
     * This method returns all the legal moves for a Queen on the p's location on the Board.
     * @param p a Piece.
     * @return a matrix with 1 or null values.
     */
    public int[][] getMovesQueen(Piece p) {
        x = p.getX();
        y = p.getY();
        int temp[][] = getMovesBishop(p);
        int legalMoves[][] = getMovesRook(p);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (temp[i][j] == 1) {
                    legalMoves[i][j] = 1;
                }
            }
        }
        return legalMoves;
    }

    /**
     * This method returns all the legal moves for a King on a Piece's location on the Board.
     * @param p a Piece
     * @return a matrix with 1 or null values.
     */
    public int[][] getMovesKnight(Piece p) {
        x = p.getX();
        y = p.getY();
        int[][] legalMoves = new int[8][8];

        if ((x + 2) < 8 && (y + 1) < 8) {
            if (b.getPieceAt((y + 1), (x + 2)) != null) {
                if (b.getPieceAt((y + 1), (x + 2)).isWhite() != p.isWhite()) {
                    legalMoves[y + 1][x + 2] = 1;
                }
            } else {
                legalMoves[y + 1][x + 2] = 1;
            }
        }
        if ((x + 2) < 8 && (y - 1) > -1) {
            if (b.getPieceAt((y - 1), (x + 2)) != null) {
                if (b.getPieceAt((y - 1), (x + 2)).isWhite() != p.isWhite()) {
                    legalMoves[y - 1][x + 2] = 1;
                }
            } else {
                legalMoves[y - 1][x + 2] = 1;
            }
        }
        if ((x - 2) > -1 && (y + 1) < 8) {
            if (b.getPieceAt((y + 1), (x - 2)) != null) {
                if (b.getPieceAt((y + 1), (x - 2)).isWhite() != p.isWhite()) {
                    legalMoves[y + 1][x - 2] = 1;
                }
            } else {
                legalMoves[y + 1][x - 2] = 1;
            }
        }
        if ((x - 2) > -1 && (y - 1) > -1) {
            if (b.getPieceAt((y - 1), (x - 2)) != null) {
                if (b.getPieceAt((y - 1), (x - 2)).isWhite() != p.isWhite()) {
                    legalMoves[y - 1][x - 2] = 1;
                }
            } else {
                legalMoves[y - 1][x - 2] = 1;
            }
        }
        if ((x + 1) < 8 && (y + 2) < 8) {
            if (b.getPieceAt((y + 2), (x + 1)) != null) {
                if (b.getPieceAt((y + 2), (x + 1)).isWhite() != p.isWhite()) {
                    legalMoves[y + 2][x + 1] = 1;
                }
            } else {
                legalMoves[y + 2][x + 1] = 1;
            }
        }
        if ((x - 1) > -1 && (y + 2) < 8) {
            if (b.getPieceAt((y + 2), (x - 1)) != null) {
                if (b.getPieceAt((y + 2), (x - 1)).isWhite() != p.isWhite()) {
                    legalMoves[y + 2][x - 1] = 1;
                }
            } else {
                legalMoves[y + 2][x - 1] = 1;
            }
        }
        if ((x - 1) > -1 && (y - 2) > -1) {
            if (b.getPieceAt((y - 2), (x - 1)) != null) {
                if (b.getPieceAt((y - 2), (x - 1)).isWhite() != p.isWhite()) {
                    legalMoves[y - 2][x - 1] = 1;
                }
            } else {
                legalMoves[y - 2][x - 1] = 1;
            }
        }
        if ((x + 1) < 8 && (y - 2) > -1) {
            if (b.getPieceAt((y - 2), (x + 1)) != null) {
                if (b.getPieceAt((y - 2), (x + 1)).isWhite() != p.isWhite()) {
                    legalMoves[y - 2][x + 1] = 1;
                }
            } else {
                legalMoves[y - 2][x + 1] = 1;
            }
        }
        return legalMoves;
    }

    /**
     * This method uses the previous methods to return a matrix of all the legal
     * moves that a Piece can perform on the Board.
     * @param p a Piece
     * @param b a Board
     * @return a matrix with 1 or null values.
     */
    public int[][] getLegalMoves(Piece p, Board b) {
        this.b = b;
        int checkMate[][] = new int[8][8];
        if (p instanceof King) {

            return getMovesKing(p);
        }
        if (p instanceof Rook) {

            return getMovesRook(p);
        }
        if (p instanceof Pawn) {
            if (!p.isWhite()) {

                return getMovesBlackPawn((Pawn) p);
            } else {

                return getMovesWhitePawn((Pawn) p);
            }
        }
        if (p instanceof Knight) {

            return getMovesKnight(p);
        }
        if (p instanceof Bishop) {

            return getMovesBishop(p);
        }
        if (p instanceof Queen) {

            return getMovesQueen(p);
        }
        return checkMate;
        
    }
}
