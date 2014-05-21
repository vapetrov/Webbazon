package bookstore.GUI;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

    public imageIconLoader() {

        ArrayList<ImageIcon> lister = new ArrayList<ImageIcon>();
        int count = 0;
        boolean notDone = true;
        while (notDone) {
            InputStream input = this.getClass().getResourceAsStream("images/" + count + ".png");

            if (input == null) {
                notDone = false;
            } else {
                lister.add(new ImageIcon(reader(input)));
            }

            count++;

        }

        images = new ImageIcon[lister.size()];
        lister.toArray(images);

    }

    private byte[] reader(InputStream stream) {
        int bytesRead;
        byte[] buffer = new byte[1000];
        ByteArrayOutputStream writer = new ByteArrayOutputStream();
        try {
            while ((bytesRead = stream.read(buffer)) != -1) {
                writer.write(buffer, 0, bytesRead);
            }
        } catch (IOException ex) {
            return null;
        }
        return writer.toByteArray();
    }

    /**
     * Obtains an array of images for displaying
     *
     * @return A list of all available images in the images package
     * Precondition: Images are available and are in the right order.
     */
    public ImageIcon[] getImages() {
        return images;
    }

}
