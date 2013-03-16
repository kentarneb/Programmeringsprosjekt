package chess.GUI;

import chess.Models.Piece;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * This class has the sidepanel for dead pieces. It is implemented in the BoardPanel class.
 *
 * @author Jonas Bo Grimsgaard <jonasbg@gmail.com>
 * @version 0.1, 21. Mars 2012
 * @version 0.2, 22. Mars 2012
 * @see chess.GUI.BoardPanel
 */
public class SidePanel extends JPanel implements Serializable {

    private IconLoader iconLoader = new IconLoader();
    private JLabel nameLabel;
    private String playerName;
    private final Font myFont = new Font("Serif", Font.PLAIN, 25);

    /**
     * Method to set the players name.
     * 
     * @param playerName - name of the player
     */
    public SidePanel(String playerName) {
        setLayout(new FlowLayout());
        setPreferredSize(new java.awt.Dimension(120, 800));
        setBackground(new Color(233, 233, 233));
        nameLabel = new JLabel(playerName, SwingConstants.CENTER);
        nameLabel.setFont(myFont);
        add(nameLabel);
        JLabel helperLabel = new JLabel();
        add(helperLabel);
        this.playerName = playerName;
    }

    /**
     * Method to update the list of fallen pieces. 
     * 
     * @param fallenPieces - ArrayList of fallen Pieces
     * @see java.util.ArrayList
     * @see chess.Models.Piece
     */
    public void updatePieces(ArrayList<Piece> fallenPieces) {
        this.removeAll();
        JButton button;
        nameLabel = new JLabel(playerName, SwingConstants.CENTER);
        nameLabel.setFont(myFont);
        add(nameLabel);
        JLabel helperLabel = new JLabel();
        add(helperLabel);
        for (Piece p : fallenPieces) {
            button = new JButton();
            button.setIcon(iconLoader.createImageIcon(p.getPictureURL()));
            button.setPreferredSize(new java.awt.Dimension(this.getWidth() / 2 - 5, this.getHeight() / 9 - 5));
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setBackground(null);
            add(button);
        }repaint();
    }
    
    public void doRepaint(){
        this.repaint();
    }
}
