/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.GUI;

import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gjerde
 */
public class IconLoaderTest {
    
    public IconLoaderTest() {
    }
/**
     * Test of createImageIcon method, of class IconLoader.
     */        
    @Test
    public void testCreateImageIcon() {
        String url = "test_icon.png";
        IconLoader instance = new IconLoader();
        Icon result = instance.createImageIcon(url);
        if(result == null){
            fail();
        }        
        JOptionPane.showMessageDialog(null, "The icon was created succesfully", "Create Image Icon", JOptionPane.INFORMATION_MESSAGE, result);
    }
    
    /**
     * Test of createImageIcon method error, of class IconLoader.
     * Expected to return null
     */ 
    @Test
    public void testCreateImageIconError() {
        String url = "invalidUrl";
        IconLoader instance = new IconLoader();
        Icon expResult = null;
        Icon result = instance.createImageIcon(url);
        assertEquals(expResult, result);
    }    
}
