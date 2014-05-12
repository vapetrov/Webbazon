/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * Loads icons and images so that they can be displayed in the GUI
 *
 * @author Vassily
 */
public class imageIconLoader {

    private ImageIcon[] images;

    public imageIconLoader(){
        try {
            File resources = new File(getClass().getResource("images").toURI());
            File[] icons = resources.listFiles();
            
            images = new ImageIcon[icons.length];
            
            int count = 0;
            for (File f : icons) {
                images[count] = new ImageIcon(f.toURI().toURL());
                count++;
            }
        } catch (URISyntaxException ex) {
            System.out.println("Images couldn't be loaded.");
            images = null;
        } catch (MalformedURLException ex) {
            System.out.println("Images couldn't be loaded.");
            images = null;
        }

    }

    /**
     * Obtains an array of images for displaying
     * @return A list of all available images in the images package
     * Precondition: Images are available and are in the right order.
     */
    public ImageIcon[] getImages() {
        return images;
    }

}
