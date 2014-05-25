package bookstore.GUI;

import bookstore.Bill;
import bookstore.InventoryItem;
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
    private JTextField customer = new JTextField();

    public sellWindow(mainGUI root) {
        this.root = root;
        adder = new elementAdder();

        setTitle("create a bill");

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
        JButton add = new JButton("add more");
        add.addActionListener(adder);
        buttons.add(add);
        buttons.add(Box.createRigidArea(new Dimension(20, 10)));
        JButton sell = new JButton("Sell");
        sell.addActionListener(new seller());
        buttons.add(sell);
        buttons.setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 5));

        add(buttons);

        JPanel cust = new JPanel();
        cust.add(new JLabel("Customer: "));
        cust.add(customer);
        customer.setPreferredSize(new Dimension(150, customer.getPreferredSize().height));
        add(cust);
        add(Box.createHorizontalGlue());

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

    private class seller implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            final Bill bill = new Bill(customer.getText());
            for (bookElement entry : entries) {
                InventoryItem sellItem = new InventoryItem(((InventoryItem) entry.bookList.getSelectedItem()).getItem(), (int) entry.amount.getValue());
                try{
                    bill.addItem(sellItem);
                }catch(IllegalArgumentException ex){
                    JOptionPane.showMessageDialog(sellWindow.this, "You cannot have more than one entry per book.", "book selling error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            if (!bill.verify(root.getInventory())) {
                JOptionPane.showMessageDialog(sellWindow.this, "You cannot sell more books than you Have.", "book selling error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            root.addToTotal(bill.getTotalCopies(), bill.getTotalCost());
            bill.sellBooks(root.getInventory());

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame f = new billWindow(bill);
                    f.setVisible(true);
                }
            });

            clearFields();
            sellWindow.this.setVisible(false);
        }

    }

    private class bookElement extends JPanel implements ActionListener {

        JComboBox bookList;
        JSpinner amount;

        public bookElement() {

            bookList = new JComboBox();
            setLayout(new GridBagLayout());
            GridBagConstraints hold = new GridBagConstraints();
            hold.insets = new Insets(5, 5, 5, 5);
            hold.gridx = 0;
            add(bookList, hold);
            hold.gridx = 1;
            amount = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
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
