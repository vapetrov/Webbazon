package bookstore.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * A sell window displays a window used for assembling a bill for the customer
 * and then displaying it.
 *
 * @author Vassily
 */
public class sellWindow extends JFrame implements ActionListener {

    private mainGUI root;

    public sellWindow(mainGUI root) {
        this.root = root;

        setTitle("create a bill");

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JButton add = new JButton("add more");
        add.setAlignmentX(Component.CENTER_ALIGNMENT);
        add.addActionListener(new elementAdder());
        add(add);
        add(Box.createHorizontalGlue());
        add(new bookElement());
        add(new bookElement());
        add(new bookElement());

        //add(main);
        pack();
        //this.setResizable(false);
        setLocationRelativeTo(null);
    }

    private void closeWindow() {
        setVisible(false);
        clearFields();
    }

    private void clearFields() {

    }

    private class bookElement extends JPanel {

        public bookElement() {
            setLayout(new GridBagLayout());
            GridBagConstraints hold = new GridBagConstraints();
            hold.insets = new Insets(5, 5, 5, 5);
            hold.gridx = 0;
            add(new JComboBox(new String[]{"A list of books", "A list of books", "A list of books"}), hold);
            hold.gridx = 1;
            JSpinner amount = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
            amount.setPreferredSize(new Dimension(60, amount.getPreferredSize().height + 4));
            add(amount, hold);
            hold.gridx = 2;
            JButton close = new JButton("X");
            close.setMargin(new Insets(3, 3, 3, 3));
            add(close, hold);

        }

    }

    private class elementAdder implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            sellWindow.this.add(new bookElement());
            sellWindow.this.pack();
            root.updateList();
            //sellWindow.this.closeWindow();
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
