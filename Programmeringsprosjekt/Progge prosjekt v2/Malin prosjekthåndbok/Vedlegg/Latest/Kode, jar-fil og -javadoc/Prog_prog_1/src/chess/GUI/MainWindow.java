/*
 * This is the main class.
 * 
 * It has two external panels, BoardPanel and SidePanel. These are layed out in given orden; first BoardPanel in the center,
 * then SidePanel to the right of the frame.
 * 
 */
package chess.GUI;

import chess.Logic.Board;
import chess.Logic.InstanceManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Gjerde, Jonas
 * @version 0.1, 18. Mars 2012 - Gjerde
 * @version 0.2, 22. Mars 2012 - Jonas
 */
public class MainWindow extends JFrame implements Serializable {

    private BoardPanel bp;
    private SidePanel deadWhite = new SidePanel("Player 1");
    private SidePanel deadBlack = new SidePanel("Player 2");
    private InstanceManager instanceManager = new InstanceManager();
    private MainWindow mainWindow = this;

    public MainWindow() {
        setTitle("Chess by Group 01");
        setLayout(new BorderLayout());
        setSize(1000, 630);
        bp = new BoardPanel(null, Color.BLACK, deadWhite, deadBlack);
        //bp.paintButtonsWithPieces();
        add(bp, BorderLayout.CENTER);
        add(deadWhite, BorderLayout.WEST);
        add(deadBlack, BorderLayout.EAST);
        this.setJMenuBar(populateMenuBar());
    }

    /**
     * This method populates an JMenuBar object with parameters.
     * This JMenuBar is then returned to the caller who can us this
     * as it likes. 
     * 
     * @return JMenuBar - for use in the main window
     */
    private JMenuBar populateMenuBar() {
        JMenuBar thismenu = new JMenuBar();
        JMenu filemenu = new JMenu("File");
        JMenu editmenu = new JMenu("Edit");
        JMenu helpmenu = new JMenu("Help");
        JMenuItem menuItem;
        MenuListener ml = new MenuListener();

        //A group of JMenu items under the File menu
        menuItem = new JMenuItem("New Game");
        menuItem.addActionListener(ml);
        menuItem.setAccelerator(KeyStroke.getKeyStroke("F2"));
        filemenu.add(menuItem);
        menuItem = new JMenuItem("Save");
        menuItem.addActionListener(ml);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.Event.CTRL_MASK));
        filemenu.add(menuItem);
        menuItem = new JMenuItem("Open");
        menuItem.addActionListener(ml);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.Event.CTRL_MASK));
        filemenu.add(menuItem);
        filemenu.addSeparator();
        menuItem = new JMenuItem("Exit");
        menuItem.addActionListener(ml);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.Event.CTRL_MASK));
        filemenu.add(menuItem);

        //A group of item under editmenu
        menuItem = new JMenuItem("Undo move");
        menuItem.addActionListener(ml);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.Event.CTRL_MASK));
        editmenu.add(menuItem);
        editmenu.addSeparator();
        menuItem = new JMenuItem("Standard - Black/White");
        menuItem.addActionListener(ml);
        editmenu.add(menuItem);
        menuItem = new JMenuItem("Swedish - Yellow/Blue");
        menuItem.addActionListener(ml);
        editmenu.add(menuItem);
        menuItem = new JMenuItem("Norwegian - Red/Blue");
        menuItem.addActionListener(ml);
        editmenu.add(menuItem);
        menuItem = new JMenuItem("Coders - Yellowish/Brownish");
        menuItem.addActionListener(ml);
        editmenu.add(menuItem);

        //A group of JMenu items under the Help menu
        menuItem = new JMenuItem("About us");
        menuItem.addActionListener(ml);
        helpmenu.add(menuItem);
        helpmenu.addSeparator();
        menuItem = new JMenuItem("Help");
        menuItem.addActionListener(ml);
        helpmenu.add(menuItem);

        thismenu.add(filemenu);
        thismenu.add(editmenu);
        thismenu.add(helpmenu);
        return thismenu;
    }

    private class MenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JMenuItem jmi = (JMenuItem) ae.getSource();
            String action = jmi.getText();

            if (action.equals("New Game")) {
                bp.setBoard(new Board());
            } else if (action.equals("Exit")) {
                System.exit(0);
            } else if (action.equals("About us")) {
                System.out.println("About us");
                About dialog = new About(MainWindow.this, true);
                dialog.setVisible(true);

            } else if (action.equals("Standard - Black/White")) {
                bp.setBoardColors(null, Color.BLACK);
            } else if (action.equals("Swedish - Yellow/Blue")) {
                bp.setBoardColors(Color.YELLOW, Color.BLUE);
            } else if (action.equals("Norwegian - Red/Blue")) {
                bp.setBoardColors(Color.RED, Color.BLUE);
            } else if (action.equals("Coders - Yellowish/Brownish")) {
                bp.setBoardColors(new Color(251, 206, 156), new Color(211, 141, 71));
            } else if (action.equals("Undo move")) {
                if (bp.undoMove()) {
                    bp.switchPlayer();
                }
            } else if (action.equals("Save")) {
                JFileChooser jfc = new JFileChooser("app");
                new File("Saves").mkdir();
                jfc.setCurrentDirectory(new File("Saves"));
                int returnVal = jfc.showSaveDialog(getParent());
                if (returnVal == jfc.APPROVE_OPTION) {
                    String filename = jfc.getSelectedFile().getAbsolutePath();
                    if (instanceManager.saveGame(bp.getBoard(), filename)) {
                        javax.swing.JOptionPane.showMessageDialog(null, "Spill lagret");
                    }
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "Du valgte ingen fil, skrev ikke noe filnavn eller trykket avbryt. \nLagring avbrutt");
                }

            } else if (action.equals("Open")) {
                JFileChooser jfc = new JFileChooser("app");
                jfc.setCurrentDirectory(new File("Saves"));
                int returnVal = jfc.showOpenDialog(getParent());
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    bp.setBoard(instanceManager.loadGame(jfc.getSelectedFile(), bp.getBoard()));
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "Du valgte ingen fil!");
                }
            }
        }
    }
}

class MyWindow {

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
    }
}
