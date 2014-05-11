/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;

/**
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

        setTitle("Webazon Bookstore");


        JPanel horizontal = new JPanel();
        horizontal.setLayout(new BoxLayout(horizontal, BoxLayout.Y_AXIS));
        add(horizontal);

        JLabel name = new JLabel("WebAzon Bookstore!", SwingConstants.CENTER);
        name.setFont(new Font("Helvetica", 1, 30));
        name.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        horizontal.add(name);

        JPanel buttonRow = new JPanel();
        horizontal.add(buttonRow);
        buttonRow.setLayout(new BoxLayout(buttonRow, BoxLayout.X_AXIS));

        buttonRow.add(Box.createRigidArea(new Dimension(30, 0)));

        JButton inventory = new JButton("Add inventory");
        inventory.setMargin(new Insets(5, 5, 5, 5));
        buttonRow.add(inventory);

        buttonRow.add(Box.createHorizontalGlue());

        JButton add = new JButton("Add items");
        add.setMargin(new Insets(5, 5, 5, 5));
        buttonRow.add(add);

        buttonRow.add(Box.createRigidArea(new Dimension(30, 0)));

        JButton sell = new JButton("Sell items");
        sell.setMargin(new Insets(5, 5, 5, 5));
        buttonRow.add(sell);

        buttonRow.add(Box.createRigidArea(new Dimension(20, 0)));
        
        String[] names = new String[]{"bob", "bill","jill","Juan"};

        JList books = new JList(names);
        books.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        books.setLayoutOrientation(JList.VERTICAL);
        books.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(books);
        listScroller.setPreferredSize(new Dimension(800, 400));
        listScroller.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), listScroller.getBorder()));
        
        horizontal.add(listScroller);
        pack();

    }

    public static void make(String[] args) {
        JFrame f = new mainGUI();
        f.setVisible(true);
    }
}
