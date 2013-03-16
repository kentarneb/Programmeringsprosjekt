/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.Logic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * This class is used for saving and loading instances of the Board class.
 * @author Gjerde
 */
public class InstanceManager {

    public boolean saveGame(Board board, String filename) {
        try {            
            filename = filename.replace(".chess", "");
            OutputStream file = new FileOutputStream(filename + ".chess");
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            try {
                output.writeObject(board);
            } finally {
                output.close();
                return true;
            }
        } catch (IOException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Lagring mislykket!");
            return false;
        }
    }

    public Board loadGame(File file, Board oldBoard) {
        Board board = null;
        try {
            InputStream fileInput = new FileInputStream(file);
            InputStream buffer = new BufferedInputStream(fileInput);
            ObjectInput input = new ObjectInputStream(buffer);
            try {
                board = (Board) input.readObject();
            } finally {
                input.close();
                if(board == null){
                    javax.swing.JOptionPane.showMessageDialog(null, "Ugyldig fil!");
                    board = oldBoard;
                }
                return board;
            }
        } catch (IOException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Lasting av spill mislykket!");
            return board;
        }
    }
}
