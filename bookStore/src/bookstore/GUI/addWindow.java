package bookstore.GUI;

import bookstore.Inventory;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

/**
 * A separate window for adding more books of the same type to the inventory
 *
 * @author Vassily
 */
public class addWindow extends JFrame implements ActionListener {

    private mainGUI root;
    private JComboBox books;
    private JSpinner number;

    public addWindow(mainGUI root) {
        this.root = root;

        setTitle("Add more books");

        // add(number);
        setLayout(new GridBagLayout());

        GridBagConstraints bag = new GridBagConstraints();
        bag.insets = new Insets(5, 5, 5, 5);

        bag.gridwidth = 2;
        bag.gridx = 0;
        books = new JComboBox(root.getInventory().getList().toArray());
        add(books, bag);

        bag.gridy = 2;
        add(new JLabel("Current books: --"), bag);

        bag.gridwidth = 1;
        bag.gridy = 3;
        bag.weightx = 1;
        bag.anchor = GridBagConstraints.EAST;

        add(new JLabel("Add:"), bag);

        bag.anchor = GridBagConstraints.WEST;
        bag.gridx = 1;
        number = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
        add(number, bag);

        bag.gridx = 0;
        bag.anchor = GridBagConstraints.CENTER;
        bag.gridy = 4;
        bag.gridwidth = 2;
        JButton adder = new JButton("Add");
        this.add(adder, bag);

        adder.addActionListener(new addWindow.amountAdder(root.getInventory()));

        this.pack();
        //this.setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * Updates the current list of books to reflect the values stored in the
     * Inventory. Should be called whenever Inventory updates.
     */
    public void update() {
        books.removeAllItems();
        for (Object i : root.getInventory().getList()) {
            books.addItem(i);
        }
    }

    private void closeWindow() {
        setVisible(false);
        clearFields();
    }

    private void clearFields() {
        books.setSelectedIndex(0);
        number.setValue(0);
    }

    private class amountAdder implements ActionListener {

        Inventory invent;

        public amountAdder(Inventory invent) {
            this.invent = invent;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            root.updateList();
            addWindow.this.closeWindow();
        }
    }

    /**
     * Creates a new instance of the window
     *
     * @param root The main GUI that the window was created from.
     * @return the created object.
     */
    public static addWindow make(mainGUI root) {
        addWindow window = new addWindow(root);
        window.setVisible(false); // not ready to be displayed yet!
        return window;

    }

    /**
     * Listener that will clear and unhide the window when a button is pressed/
     * other action is performed
     *
     * @param e event from which it happened.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        clearFields();
        setVisible(true);
    }

}
