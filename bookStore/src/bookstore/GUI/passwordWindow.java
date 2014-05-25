/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.GUI;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;
import java.util.Arrays;
import java.awt.Component;
import javax.swing.SwingConstants;


/**
 *
 * @author Jagjit
 */
public class passwordWindow {
    ImageIcon[] icons = new imageIconLoader().getImages();
    private boolean isCorrect;
    public void showPasswordWindow(){
    JPanel passwordPanel = new JPanel(new GridLayout(3,3));
    JLabel mainIcon = new JLabel(icons[4]);
    mainIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
    passwordPanel.add(mainIcon);
    JLabel passwordLabel = new JLabel("Password:");
    JPasswordField passwordField = new JPasswordField();
    passwordField.setAlignmentX(SwingConstants.RIGHT);
    passwordPanel.add(passwordLabel);
    passwordPanel.add(passwordField);
    JFrame frame = new JFrame();
    frame.add(passwordPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    int passwordInput = JOptionPane.showConfirmDialog(null, passwordPanel, "Enter your password:" ,JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    char[] password = passwordField.getPassword();
    char[] correctPassword = {'m', 'r', 'w', 'e', 'b', 'b', 'i', 's', 'a','w','e','s','o','m','e'};
    isCorrect = Arrays.equals(correctPassword,password);
    if(!isCorrect()){
              int dialogButton = JOptionPane.YES_NO_OPTION;
              int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Try Again?","Warning",dialogButton);
              if(dialogResult == JOptionPane.YES_OPTION){
                  showPasswordWindow();
              }
              if(dialogResult==JOptionPane.NO_OPTION)
                  System.exit(0);
    }
   
}
    public boolean isCorrect()
    {
        return isCorrect;
    }
    public void close()
    {
        System.exit(0);
    }
}
