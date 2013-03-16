package chess.GUI;

import javax.swing.ImageIcon;

/**
 * This class is used for loading images from a Jar-file.
 *
 * @author Gjerde
 * @see chess.GUI.BoardPanel
 */
public class IconLoader {

    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.out.println("The following path was invalid: " + path);
            return null;
        }
    }
}