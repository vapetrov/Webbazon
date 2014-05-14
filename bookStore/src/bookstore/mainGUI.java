package bookstore;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.CompoundBorder;

/**
 * The main GUI. Renders a window that allows a person to add add and sell
 * books.
 *
 * @author Vassily
 */
public class mainGUI extends JFrame {

    Inventory books;
    
    public mainGUI(Inventory books) {

        this.books = books;
        
        // Window closer
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //this.setMinimumSize(new Dimension(457,444));

        setTitle("Webbazon Bookstore");

        ImageIcon[] icons = new imageIconLoader().getImages();

        JPanel horizontal = new JPanel();
        horizontal.setLayout(new BoxLayout(horizontal, BoxLayout.Y_AXIS));
        add(horizontal);

        JLabel name = new JLabel("", SwingConstants.CENTER);
        name.setIcon(icons[3]);

        name.setFont(new Font("Helvetica", 1, 30));
        name.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        horizontal.add(name);

        JPanel buttonRow = new JPanel();
        horizontal.add(buttonRow);
        buttonRow.setLayout(new BoxLayout(buttonRow, BoxLayout.X_AXIS));

        buttonRow.add(Box.createRigidArea(new Dimension(30, 0)));

        JButton inventory = new JButton("Add inventory");
        inventory.setIcon(icons[0]);
        inventory.setMargin(new Insets(5, 5, 5, 5));
        buttonRow.add(inventory);

        buttonRow.add(Box.createHorizontalGlue());

        JButton add = new JButton("Add items");
        add.setIcon(icons[1]);
        add.setMargin(new Insets(5, 5, 5, 5));
        buttonRow.add(add);

        buttonRow.add(Box.createRigidArea(new Dimension(30, 0)));

        JButton sell = new JButton("Sell items");
        sell.setIcon(icons[2]);
        sell.setMargin(new Insets(5, 5, 5, 5));
        buttonRow.add(sell);

        buttonRow.add(Box.createRigidArea(new Dimension(20, 0)));

        
        bookStatusPanel book = new bookStatusPanel();
        bookListPanel scroller = new bookListPanel(books, book);
        
        horizontal.add(scroller.getScroller());
        horizontal.add(book);

        pack();

    }


    public static void make(Inventory inventory) {
        JFrame f = new mainGUI(inventory);
        f.setVisible(true);
    }
}
