/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JPanel;
import chess.Logic.Board;
import chess.Logic.GameRules;
import chess.Models.Piece;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;

/**
 *
 * The GUI class that shows the board and interacts with it.
 * 
 * @version 0.1, 21. Mars 2012
 */
public class BoardPanel extends JPanel implements Serializable {

    private JButton[][] buttonPanel = new JButton[8][8];                                                //A panel with 8x8 buttons, this is the playable area
    private Board board = new Board();                                                                  //Initiate a new Board
    private ButtonListener bl = new ButtonListener();                                                   //A single buttonlistener for all the buttons, this to reduce memory print
    private IconLoader iconLoader = new IconLoader();                                                   //IconLoader is used to load icons into the buttons so they look like a real chess board
    private GameRules gr = new GameRules();                                                             //Initiate game rules for this game
    private boolean hasSelectedButton = false;                                                          //Value true of selected button
    private Piece chosenPiece;                                                                          //A chess Piece class initialation
    private Color[] boardColors = new Color[2];                                                         //Used for the theme of the board
    private SidePanel deadWhitePanel, deadBlackPanel;                                                   //Sidepanel for showing taken pieces
    //private boolean whitePlaying = true;

    /**
     * The constructor of this class, which creates the board and visual representation of the chess pieces.
     * It takes two colors and assign them to the board so it looks like a real chess board.
     * 
     * @param c - is the first color used on the tiles
     * @param cc - is the second color used on the tiles
     * @param deadWhitePanel - JPanel of dead white pieces
     * @param deadBlackPanel - JPanel of dead black pieces
     */
    public BoardPanel(Color c, Color cc, SidePanel deadWhitePanel, SidePanel deadBlackPanel) {
        this.setLayout(new GridLayout(8, 8));
        boardColors[0] = c;
        boardColors[0] = cc;
        this.deadWhitePanel = deadWhitePanel;
        this.deadBlackPanel = deadBlackPanel;
        initButtons();
        paintBoardTiles();
        paintButtonsWithPieces();
        updateDead();
    }
    /**
     * This method updates the knocked out piece lists.
     */

    private void updateDead() {
        this.deadWhitePanel.updatePieces(board.getDeadWhite());
        this.deadBlackPanel.updatePieces(board.getDeadBlack());
    }
    /**
     * This method initiats the buttons on the board.
     */

    private void initButtons() {
        int counter = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttonPanel[i][j] = new JButton();
                buttonPanel[i][j].addActionListener(bl);
                if (counter % 2 == 0) {
                    buttonPanel[i][j].setBackground(boardColors[0]);
                }
                if (counter % 2 != 0) {
                    buttonPanel[i][j].setBackground(boardColors[1]);
                }
                buttonPanel[i][j].setBorder(BorderFactory.createLineBorder(Color.darkGray));
                counter++;
                buttonPanel[i][j].setPreferredSize(new java.awt.Dimension(80, 80));

                buttonPanel[i][j].setOpaque(true);                                      //Mac OS spesific to get color background on buttons
                buttonPanel[i][j].setBorderPainted(true);                              //to remove the border of the buttons
                this.add(buttonPanel[i][j]);
            }
            counter++;
        }
    }
    /**
     * this methods paints the board tiles.
     */

    private void paintBoardTiles() {
        int counter = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (counter % 2 == 0) {
                    buttonPanel[i][j].setBackground(boardColors[0]);

                }
                if (counter % 2 != 0) {
                    buttonPanel[i][j].setBackground(boardColors[1]);
                }
                buttonPanel[i][j].setBorder(BorderFactory.createLineBorder(Color.darkGray));
                counter++;
            }
            counter++;
        }
    }
    /**
     * This method paints the piece pictures
     */

    private void paintButtonsWithPieces() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.getPieceAt(j, i) != null) {
                    String filepath = board.getPieceAt(j, i).getPictureURL();
                    buttonPanel[j][i].setIcon(iconLoader.createImageIcon(filepath));
                } else {
                    buttonPanel[j][i].setIcon(null);
                }
            }
        }
    }
    /**
     * This method changes the colors on the board tiles.
     * @param WHITE --> a color
     * @param BLACK --> a color
     */

   public void setBoardColors(Color WHITE, Color BLACK) {
        boardColors[0] = WHITE;
        boardColors[1] = BLACK;
        paintBoardTiles();
    }

    /**
     * This is a method for changing the boolean that decides whos turn it is.
     */
    public void switchPlayer() {
        if (board.getWhitePlaying()) {
            board.changePlayer();
        } else {
            board.changePlayer();
        }
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton jb = (JButton) ae.getSource();
            outerloop:                                                                              //Initate a outerloop mark which is used in line 181.
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (jb.equals(buttonPanel[j][i])) {
                        paintBoardTiles();
                        try {
                            if (!hasSelectedButton) {
                                if (board.getPieceAt(j, i).isWhite() && board.getWhitePlaying()) {
                                    hasSelectedButton = true;
                                    chosenPiece = board.getPieceAt(j, i);
                                    paintLegalMoves(j, i);
                                } else if (!board.getPieceAt(j, i).isWhite() && !board.getWhitePlaying()) {
                                    hasSelectedButton = true;
                                    chosenPiece = board.getPieceAt(j, i);
                                    paintLegalMoves(j, i);
                                }

                            } else if (hasSelectedButton) {
                                hasSelectedButton = false;
                                if (gr.getLegalMoves(chosenPiece, board)[j][i] == 1) {
                                    board.movePieceToPosition(i, j, chosenPiece, board);
                                    if (board.getWhitePlaying()) {
                                        board.changePlayer();
                                    } else {
                                        board.changePlayer();
                                    }
                                }
                                paintButtonsWithPieces();
                                updateDead();
                                deadWhitePanel.repaint();
                                deadBlackPanel.repaint();
                            }
                        } catch (NullPointerException ex) {
                            //EXPECTED EXCEPTION
                            hasSelectedButton = false;
                            deadWhitePanel.repaint();
                            deadBlackPanel.repaint();
                        }
                        deadWhitePanel.repaint();
                        deadBlackPanel.repaint();
                        break outerloop;
                    }
                }
            }
        }
    }

    /**
     * This method paints the legal moves for a piece.
     * @param j --> y-coordinate
     * @param i --> x-coordinate
     */
    private void paintLegalMoves(int j, int i) {
        for (int l = 0; l < 8; l++) {
            for (int m = 0; m < 8; m++) {
                if (gr.getLegalMoves(board.getPieceAt(j, i), board)[m][l] == 1) {
                    buttonPanel[m][l].setBackground(new Color(72, 134, 212)); // Tegner lovlige trekk rød hver gang man trykker på en knapp.                                   System.out.println("Denne posisjonen er lovlig: " + l + "," + m);
                    buttonPanel[m][l].setBorder(BorderFactory.createLineBorder(Color.lightGray));
                }
            }
        }
    }

    /**
     * This method is used to undo the move if its not legal.
     * 
     * @return boolean
     */
    public boolean undoMove() {
        boolean result = board.undoMove();
        paintBoardTiles();
        paintButtonsWithPieces();
        updateDead();
        return result;
    }

    //Used for saving the board
    public Board getBoard() {
        return board;
    }

    //Used for loading saved games
    public void setBoard(Board load) {
        this.board = load;
        paintButtonsWithPieces();
        updateDead();
    }
}
