/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore;

import javax.swing.ImageIcon;

/**
 * Loads icons so that they can be displayed in the GUI
 * @author Vassily
 */
public class imageIconLoader {
    
    private ImageIcon[] images;
    
    public imageIconLoader(){        
        images = new ImageIcon[3];
        
        images[0] = new ImageIcon(this.getClass().getResource("images/1.png"));
        images[1] = new ImageIcon(this.getClass().getResource("images/2.png"));
        images[2] = new ImageIcon(this.getClass().getResource("images/3.png"));
    }
    
    public ImageIcon[] getImages(){
        return images;
    }
    
    
}
