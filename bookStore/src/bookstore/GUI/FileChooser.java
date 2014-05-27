package bookstore.GUI;

import javax.swing.JFileChooser; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import java.io.File;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jagjit
 */
public class FileChooser implements ActionListener {
   //If button is clicked, file directory will open and allow user to retrieve file.
   //Postcondition: 
   //Precondition:Open button must be clicked and user select a file (or close file opener)
   public void actionPerformed(ActionEvent e) {
     
       JPanel panel = new JPanel();
       final JFileChooser fc = new JFileChooser();
       fc.setCurrentDirectory(new File(System.getProperty("user.home")));
       int result = fc.showOpenDialog(panel);
       JButton openButton = new JButton("Open save file");
       openButton.setActionCommand("open file");
     if (e.getSource() == openButton) {
        int returnVal = fc.showOpenDialog(panel);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            //This is where a real application would open the file.
            JOptionPane.showMessageDialog(panel, "Opening: " + file.getName() + ".");
        }
        else {
             JOptionPane.showMessageDialog(panel, "Open command cancelled by user.");
        }
     }
   }
}
    
  
 


    