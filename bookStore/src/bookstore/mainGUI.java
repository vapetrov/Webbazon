package bookstore;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.*;

/**
 * The main GUI. Renders a window that allows a person to add add and sell
 * books.
 *
 * @author Vassily
 */
public class mainGUI extends JFrame {

    public mainGUI() {

        // Window closer
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

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

        String[] names = new String[]{
            "War of the Worlds",
            "War and Peace",
            "To kill a mockingbird",
            "The Great Gatsby",
            "A tale of two cities",
            "The Lord of the Rings"
        };

        JList books = new JList(names);

        books.setFont(new Font("Helvetica", 3, 14));

        books.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        books.setLayoutOrientation(JList.VERTICAL);
        books.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(books);
        listScroller.setPreferredSize(new Dimension(800, 400));
        listScroller.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), listScroller.getBorder()));
        horizontal.add(listScroller);

        bookStatus book = new bookStatus();
        horizontal.add(book);

        pack();

    }

    public static void make(String[] args) {
        JFrame f = new mainGUI();
        f.setVisible(true);
    }
}
