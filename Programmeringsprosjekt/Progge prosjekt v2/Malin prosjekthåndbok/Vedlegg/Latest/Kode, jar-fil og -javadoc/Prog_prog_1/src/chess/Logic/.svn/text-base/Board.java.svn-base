package chess.Logic;

import chess.Models.*;
import java.awt.event.ComponentEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EventListener;
import javax.swing.JOptionPane;

/**
 * This class handles all the logic related to the board, see it as an backend for the visual chess board in GUI.
 *
 * @author Bjørn Tore
 * @author Jørgen
 * @author Jonas
 * @version 0.2, 2. April 2012
 */
public class Board implements Serializable {

    private Piece[][] board = new Piece[8][8];
    private ArrayList<Piece> deadBlack = new ArrayList<Piece>();
    private ArrayList<Move> moveRecord = new ArrayList<Move>();
    private GameRules gr = new GameRules();
    private boolean whitePlaying = true;

    /**
     * Get true value if white player is currently the player
     * 
     * @return boolean
     */
    public boolean getWhitePlaying() {
        return whitePlaying;
    }

    /**
     * Change the player who is gaming.
     * 
     */
    public void changePlayer() {
        if (whitePlaying) {
            whitePlaying = false;
        } else {
            whitePlaying = true;
        }
    }

    /**
     * Get the list of taken black pieces.
     * 
     * @return ArrayList<Piece>
     * @see java.util.ArrayList
     * @see chess.Models.Piece
     */
    public ArrayList<Piece> getDeadBlack() {
        return deadBlack;


    }

    /**
     * Get the list of taken white pieces.
     * 
     * @return ArrayList<Piece>
     * @see java.util.ArrayList
     * @see chess.Models.Piece
     */
    public ArrayList<Piece> getDeadWhite() {
        return deadWhite;


    }
    private ArrayList<Piece> deadWhite = new ArrayList<Piece>();

    /**
     * Initiate the position of the pieces at the beginning of the game
     */
    public Board() {
        initPieces();
    }

    private void initPieces() {

        String filepath = "/resources/graphics/";
        String suffix = ".png";

        //Init black filepath and imagefile
        String black_Rook_image = filepath + "b_rook" + suffix;
        String black_knight_image = filepath + "b_knight" + suffix;
        String black_bishop_image = filepath + "b_bishop" + suffix;
        String black_queen_image = filepath + "b_queen" + suffix;
        String black_king_image = filepath + "b_king" + suffix;
        String black_pawn_image = filepath + "b_pawn" + suffix;

        //Init white filepath and imagefile
        String white_Rook_image = filepath + "w_rook" + suffix;
        String white_knight_image = filepath + "w_knight" + suffix;
        String white_bishop_image = filepath + "w_bishop" + suffix;
        String white_queen_image = filepath + "w_queen" + suffix;
        String white_king_image = filepath + "w_king" + suffix;
        String white_pawn_image = filepath + "w_pawn" + suffix;

        //Init blackpieces
        board[0][0] = new Rook(black_Rook_image, false, 0, 0);
        board[1][0] = new Knight(black_knight_image, false, 1, 0);
        board[2][0] = new Bishop(black_bishop_image, false, 2, 0);
        board[3][0] = new Queen(black_queen_image, false, 3, 0);
        board[4][0] = new King(black_king_image, false, 4, 0);
        board[5][0] = new Bishop(black_bishop_image, false, 5, 0);
        board[6][0] = new Knight(black_knight_image, false, 6, 0);
        board[7][0] = new Rook(black_Rook_image, false, 7, 0);

        //Init whitepieces
        board[0][7] = new Rook(white_Rook_image, true, 0, 7);
        board[1][7] = new Knight(white_knight_image, true, 1, 7);
        board[2][7] = new Bishop(white_bishop_image, true, 2, 7);
        board[3][7] = new Queen(white_queen_image, true, 3, 7);
        board[4][7] = new King(white_king_image, true, 4, 7);
        board[5][7] = new Bishop(white_bishop_image, true, 5, 7);
        board[6][7] = new Knight(white_knight_image, true, 6, 7);
        board[7][7] = new Rook(white_Rook_image, true, 7, 7);
        /*
         */
        //board[2][5] = new Pawn(white_pawn_image, true, 2, 5);

        //The loop for creating pawns in the matrix


        for (int i = 0; i
                < 8; i++) {
            board[i][1] = new Pawn(black_pawn_image, false, i, 1);
            board[i][6] = new Pawn(white_pawn_image, true, i, 6);


        }
    }

    /**
     * Method for moving pieces to a give position
     * 
     * @param x - int the value of x-axes
     * @param y - int the value of y-axes
     * @param p - Piece
     * @param b - Board
     */
    public void movePieceToPosition(int x, int y, Piece p, Board b) {
        Piece killedPiece = null;
        Piece Rook = null;
        if (p instanceof King && board[x][y] instanceof Rook && p.isWhite() == board[x][y].isWhite()) {
            if (x == 0 && y == 0) {
                if (gr.getLegalMoves(p, b)[y][x] == 1) {
                    Rook = board[x][y];
                    board[x][y] = null;
                    board[2][0] = p;
                    board[p.getX()][p.getY()] = null;
                    board[3][0] = Rook;
                    board[Rook.getX()][p.getY()] = null;
                    p.setCords(2, 0);
                    Rook.setCords(3, 0);
                    moveRecord.add(new Move(p.getX(), p.getY(), x, y, p, Rook, true));
                }
            } else if (x == 7 && y == 0) {
                if (gr.getLegalMoves(p, b)[y][x] == 1) {
                    Rook = board[x][y];
                    board[x][y] = null;
                    board[6][0] = p;
                    board[p.getX()][p.getY()] = null;
                    board[5][0] = Rook;
                    board[Rook.getX()][p.getY()] = null;
                    p.setCords(6, 0);
                    Rook.setCords(5, 0);
                    moveRecord.add(new Move(p.getX(), p.getY(), x, y, p, Rook, true));
                }
            } else if (x == 0 && y == 7) {
                if (gr.getLegalMoves(p, b)[y][x] == 1) {
                    Rook = board[x][y];
                    board[x][y] = null;
                    board[2][7] = p;
                    board[p.getX()][p.getY()] = null;
                    board[3][7] = Rook;
                    board[x][y] = null;
                    p.setCords(2, 7);
                    Rook.setCords(3, 7);
                    moveRecord.add(new Move(p.getX(), p.getY(), x, y, p, Rook, true));

                }
            } else if (x == 7 && y == 7) {
                if (gr.getLegalMoves(p, b)[y][x] == 1) {
                    Rook = board[x][y];
                    board[x][y] = null;
                    board[6][7] = p;
                    board[p.getX()][p.getY()] = null;
                    board[5][7] = Rook;
                    board[Rook.getX()][p.getY()] = null;
                    p.setCords(6, 7);
                    Rook.setCords(5, 7);
                    moveRecord.add(new Move(p.getX(), p.getY(), x, y, p, Rook, true));
                }
            }

            

        } else {

            {
                if (board[x][y] != null) {
                    if (p.isWhite() && board[x][y].isWhite()) {
                    } else {
                        killedPiece = board[x][y];
                        killPiece(board[x][y]);
                        board[x][y] = null;
                    }
                }
                if (p instanceof Pawn) {
                    Pawn helper = (Pawn) p;
                    helper.setIsDrawn(true);
                    helper.incrementNumberOfMoves();
                    p = helper;


                }

                if (killedPiece == null) {
                    moveRecord.add(new Move(p.getX(), p.getY(), x, y, p));


                } else {
                    moveRecord.add(new Move(p.getX(), p.getY(), x, y, p, killedPiece));


                }
                board[x][y] = board[p.getX()][p.getY()];
                board[p.getX()][p.getY()] = null;
                p.setCords(x, y);
                transformPawn(p);
                isChecked(b);


                /* if (gr.isChecked(board)) { //gr.isChecked(board
                System.out.println("test3");
                undoMove();
                changePlayer();
                
                
                
                }*/
            }
        }
    }

    /**
     * Get the object of the last moved piece in the game
     * 
     * @return Piece
     */
    public Piece lastMovedPiece() {
        return moveRecord.get(moveRecord.size() - 2).getPiece();
    }

    /**
     * This method makes sure a player wont leave his king checked.
     * If his king is checked after he has done his move, the move will be undon, and he will have to move again,
     * until he has moved out of check.
     * 
     * @param b - Board
     */
    public void isChecked(Board b) {
        try {
            Piece bKing = null;
            Piece wKing = null;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[j][i] instanceof King && !board[j][i].isWhite()) { // svart konge
                        bKing = board[j][i];
                    }
                }
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[j][i] instanceof King && board[j][i].isWhite()) {
                        wKing = board[j][i];
                    }
                }
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (lastMovedPiece().isWhite()) {
                        if (gr.getLegalMoves(board[j][i], b)[bKing.getY()][bKing.getX()] == 1) {
                            changePlayer();
                            undoMove();
                            javax.swing.JOptionPane.showMessageDialog(null, "Du må flytte ut av sjakk!");
                        }
                    }
                }
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (!lastMovedPiece().isWhite()) {
                        if (gr.getLegalMoves(board[j][i], b)[wKing.getY()][wKing.getX()] == 1) {
                            changePlayer();
                            undoMove();
                            javax.swing.JOptionPane.showMessageDialog(null, "Du må flytte ut av sjakk!");
                        }
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //Don't do jack.
        }
    }

    /**
     * Check for check mate
     * 
     * @param b - Board
     * @return boolean
     */
    public boolean checkMate(Board b) {
        Piece[][] temp = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[j][i] = temp[j][i];
            }
        }
        if (getWhitePlaying()) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (b.getPieceAt(i, j).isWhite()) {
                    }
                }
            }
        }

        return false;
    }

    /**
     * Transform the piece when the Pawn has made it to the other side of the board.
     * 
     * @param p - Piece
     */
    public void transformPawn(Piece p) {
        String filepath = "/resources/graphics/";
        String suffix = ".png";
        String white_queen_image = filepath + "w_queen" + suffix;
        String black_queen_image = filepath + "b_queen" + suffix;



        if (p instanceof Pawn) {
            if (p.isWhite()) {
                if (p.getY() == 0) {
                    board[p.getX()][p.getY()] = new Queen(white_queen_image, true, p.getX(), p.getY());
                    p.setCords(p.getX(), p.getY());



                }
            } else {
                if (p.getY() == 7) {
                    board[p.getX()][p.getY()] = new Queen(black_queen_image, false, p.getX(), p.getY());
                    p.setCords(p.getX(), p.getY());

                }
            }
        }
    }

    /**
     * Undoes a move that's privously been done.
     * 
     * @return boolean
     */
    public boolean undoMove() {
        if (moveRecord.size() > 0) {
            Move move = moveRecord.get(moveRecord.size() - 1);
            resetDrawn(
                    move); //Only happens when it should.
            board[move.getFromX()][move.getFromY()] = board[move.getToX()][move.getToY()];
            board[move.getToX()][move.getToY()] = null;
            move.getPiece().setCords(move.getFromX(), move.getFromY());

            try {
                Piece killedPiece = move.getKilledPiece();
                board[move.getToX()][move.getToY()] = killedPiece;
                killedPiece.setCords(move.getToX(), move.getToY());

                if (killedPiece.isWhite()) {
                    deadWhite.remove(killedPiece);


                } else {
                    deadBlack.remove(killedPiece);


                }
            } catch (NullPointerException ex) {
            }

            moveRecord.remove(move);
            return true;


        } else {
            JOptionPane.showMessageDialog(null, "No more moves to undo.");
            return false;


        }
    }

    private void resetDrawn(Move move) {
        if (move.getPiece() instanceof Pawn) {
            Pawn helper = (Pawn) move.getPiece();
            helper.decrementNumberOfMoves();

            if (helper.getNumberOfMoves() == 0) {
                helper.setIsDrawn(false);


            }
            move.setPiece(helper);


        }
        if (move.getPiece() instanceof King) {
            King helper = (King) move.getPiece();
            helper.decrementNumberOfMoves();


            if (helper.getNumberOfMoves() == 0) {
                helper.setIsDrawn(false);


            }
            move.setPiece(helper);


        }
        if (move.getPiece() instanceof Rook) {
            Rook helper = (Rook) move.getPiece();
            helper.decrementNumberOfMoves();


            if (helper.getNumberOfMoves() == 0) {
                helper.setIsDrawn(false);


            }
            move.setPiece(helper);


        }
    }

    /**
     * Kill the piece if it's taken by the counterpart
     * 
     * @param p - Piece
     */
    public void killPiece(Piece p) {
        if (p.isWhite()) {
            deadWhite.add(p);


        } else {
            deadBlack.add(p);


        }
    }

    /**
     * Returns the piece at the give coordinate.
     * X and Y are swapped around in order to make the x-axis horizontal and the y-axis vertical.
     * 
     * @param y - int
     * @param x - int
     * @return Board
     * @throws NullPointerException
     */
    public Piece getPieceAt(int y, int x) throws NullPointerException {
        return board[x][y];


    }

    /**
     * Returns all the pieces on the board.
     * 
     * @return Board
     */
    public Piece[][] getPieces() {
        return board;

    }
}
