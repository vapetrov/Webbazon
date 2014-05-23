package bookstore.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * A sell window displays a window used for assembling a bill for the customer
 * and then displaying it.
 *
 * @author Vassily
 */
public class sellWindow extends JFrame implements ActionListener {

    private mainGUI root;
    private ArrayList<bookElement> entries = new ArrayList<bookElement>();
    private elementAdder adder;

    public sellWindow(mainGUI root) {
        this.root = root;
        adder = new elementAdder();

        setTitle("create a bill");

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
        JButton add = new JButton("add more");
        //add.setAlignmentX(Component.CENTER_ALIGNMENT);
        add.addActionListener(adder);
        buttons.add(add);
        buttons.add(Box.createRigidArea(new Dimension(20, 10)));
        buttons.add(new JButton("Sell"));
        buttons.setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 5));

        add(buttons);
        add(Box.createHorizontalGlue());
        //adder.addNew();

        //add(main);
        this.setResizable(false);

        pack();
        setLocationRelativeTo(null);

    }

    private void closeWindow() {
        setVisible(false);
        clearFields();
    }

    private void clearFields() {
        for (bookElement book : entries) {
            remove(book);
        }
        entries.clear();
        adder.addNew();

    }

    public void update() {
        for (bookElement book : entries) {
            book.update(root.getInventory().getList().toArray());
        }
    }

    private class bookElement extends JPanel implements ActionListener {

        JComboBox bookList;

        public bookElement() {

            bookList = new JComboBox();
            setLayout(new GridBagLayout());
            GridBagConstraints hold = new GridBagConstraints();
            hold.insets = new Insets(5, 5, 5, 5);
            hold.gridx = 0;
            add(bookList, hold);
            hold.gridx = 1;
            JSpinner amount = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
            amount.setPreferredSize(new Dimension(45, amount.getPreferredSize().height + 4));
            add(amount, hold);
            hold.gridx = 2;
            JButton close = new JButton("X");
            close.addActionListener(this);
            close.setMargin(new Insets(3, 3, 3, 3));
            add(close, hold);

            pack();
        }

        public void update(Object[] element) {
            bookList.removeAllItems();
            for (Object o : element) {
                bookList.addItem(o);
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (sellWindow.this.entries.size() > 1) {
                sellWindow.this.entries.remove(this);
                sellWindow.this.remove(this);
                sellWindow.this.pack();
            }

        }
    }

    private class elementAdder implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            bookElement newOne = new bookElement();
            entries.add(newOne);
            sellWindow.this.add(newOne);
            newOne.update(sellWindow.this.root.getInventory().getList().toArray());
            sellWindow.this.pack();

        }

        public void addNew() {
            actionPerformed(null);
        }
    }

    /**
     * Creates a new instance of the window
     *
     * @param root The main GUI that the window was created from.
     * @return the created object.
     */
    public static inventoryWindow make(mainGUI root) {
        inventoryWindow window = new inventoryWindow(root);
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
