package bookstore.GUI;

import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;
import java.util.Arrays;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

/**
 *
 * @author Jagjit
 */
public class passwordWindow implements ActionListener {

    ImageIcon[] icons = new imageIconLoader().getImages();
    private boolean isCorrect;
    mainGUI root;
    
    public passwordWindow(mainGUI root){
        this.root = root;
    }
    
    
    public void showPasswordWindow() {
        JPanel passwordPanel = new JPanel(new GridLayout(3, 3));
        JLabel mainIcon = new JLabel(icons[4]);
        mainIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordPanel.add(mainIcon);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        passwordField.setAlignmentX(SwingConstants.RIGHT);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        int passwordInput = JOptionPane.showConfirmDialog(null, passwordPanel, "Enter your password:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (passwordInput == JOptionPane.CANCEL_OPTION) {
            System.exit(0);
        }
        if (passwordInput == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }
        char[] password = passwordField.getPassword();
        char[] correctPassword = {'a', 'p', 'c', 's', 'i', 's', 'f', 'u', 'n'};
        isCorrect = Arrays.equals(correctPassword, password);
        if (!isCorrect()) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like to Try Again?", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                showPasswordWindow();
            }
            if (dialogResult == JOptionPane.NO_OPTION) {
                System.exit(0);
            }

        }
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void close() {
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        root.setVisible(false);
        showPasswordWindow();
        root.setVisible(true);
    }
}
