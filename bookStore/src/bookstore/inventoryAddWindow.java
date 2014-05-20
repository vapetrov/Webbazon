/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Vassily
 */
public class inventoryAddWindow extends JFrame implements ActionListener {

    private mainGUI root;

    final JTextField price = new JTextField();
    final JTextField isbn = new JTextField();
    final JTextField author = new JTextField();
    final JTextField name = new JTextField();
    final JTextField quantity = new JTextField();

    public inventoryAddWindow(mainGUI root) {
        this.root = root;

        setTitle("Add a new book");

        setLayout(new GridBagLayout());

        GridBagConstraints text = new GridBagConstraints();
        GridBagConstraints box = new GridBagConstraints();

        text.anchor = GridBagConstraints.WEST;
        box.anchor = GridBagConstraints.WEST;
        text.ipadx = 10;
        box.ipadx = 150;
        box.weightx = 1;
        box.fill = GridBagConstraints.HORIZONTAL;
        text.insets = new Insets(2, 10, 2, 2);
        box.insets = new Insets(2, 2, 2, 10);

        add(Box.createVerticalStrut(10), text);

        text.gridy = 1;
        box.gridy = 1;
        this.add(new JLabel("Book title:"), text);
        this.add(name, box);

        text.gridy = 2;
        box.gridy = 2;
        this.add(new JLabel("Author:"), text);
        this.add(author, box);

        text.gridy = 3;
        box.gridy = 3;
        this.add(new JLabel("ISBN:"), text);
        this.add(isbn, box);

        text.gridy = 4;
        box.gridy = 4;
        this.add(new JLabel("Price:"), text);
        this.add(price, box);

        text.gridy = 5;
        box.gridy = 5;
        this.add(new JLabel("Available copies:"), text);
        this.add(quantity, box);

        GridBagConstraints add = new GridBagConstraints();
        add.gridwidth = 2;
        add.gridx = 0;
        add.gridy = 6;
        add.insets = new Insets(10, 0, 0, 0);
        JButton adder = new JButton("Add");
        this.add(adder, add);

        adder.addActionListener(new bookAdder(root.getInventory()));

        text.gridy = 7;
        box.gridy = 7;
        add(Box.createVerticalStrut(10), text);

        this.pack();
        this.setResizable(false);
    }
    
    private void closeWindow(){
        setVisible(false);
        clearFields();
    }

    private void clearFields() {
        name.setText("");
        isbn.setText("");
        author.setText("");
        price.setText("");
        quantity.setText("");

    }

    private class bookAdder implements ActionListener {

        Inventory invent;

        public bookAdder(Inventory invent) {

            this.invent = invent;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(name.getText());
            invent.addNewBook(Double.parseDouble(price.getText()), isbn.getText(), author.getText(), name.getText(), Integer.parseInt(quantity.getText()));
            root.updateList();
            inventoryAddWindow.this.closeWindow();
        }

    }

    public static inventoryAddWindow make(mainGUI root) {
        inventoryAddWindow window = new inventoryAddWindow(root);
        window.setVisible(false); // not ready to be displayed yet!
        return window;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clearFields();
        setVisible(true);
    }

}
