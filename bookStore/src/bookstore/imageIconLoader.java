/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;

/**
 * Loads icons and images so that they can be displayed in the GUI
 *
 * @author Vassily
 */
public class imageIconLoader {

    private ImageIcon[] images;

    public imageIconLoader() throws URISyntaxException, MalformedURLException {

        File resources = new File(getClass().getResource("images").toURI());
        File[] icons = resources.listFiles();

        images = new ImageIcon[icons.length];

        int count = 0;
        for (File f : icons) {
            images[count] = new ImageIcon(f.toURI().toURL());
            count++;
        }

    }

    public ImageIcon[] getImages() {
        return images;
    }

}
