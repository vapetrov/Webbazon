package bookstore.GUI;

import bookstore.Inventory;
import bookstore.InventoryItem;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * This class displays the contents of an inventory. It also allows users to
 * select items in the inventory to get more information about them
 *
 * @author Vassily
 */
public class bookListPanel extends JList {

    private Inventory inventory;
    private JScrollPane scroller;
    private bookStatusPanel toUpdate;

    public bookListPanel(Inventory inventory, bookStatusPanel toUpdate) {
        super();
        this.toUpdate = toUpdate;
        this.inventory = inventory;
        create();
        scroller = new JScrollPane(this);
        scroller.setPreferredSize(new Dimension(800, 400));
        scroller.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), scroller.getBorder()));

        getSelectionModel().addListSelectionListener(new handleSelection(this));

    }

    private void create() {
        setFont(new Font("Helvetica", 3, 14));

        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setLayoutOrientation(JList.VERTICAL);
        setVisibleRowCount(-1);
        update();

    }

    /**
     * Updates the current list of sellable objects Displayed on screen. This
     * method must be called whenever the Inventory updates, or else the updates
     * will not be visible.
     */
    public void update() {
        ArrayList<String> names = new ArrayList<String>();
        for (InventoryItem s : inventory.getList()) {
            names.add(s.getItem().getName());
        }

        this.setListData(names.toArray(new String[]{}));

    }

    /**
     * Obtains the JSCrollPane for properly displaying this list in a JPane.
     * PRECONDITION: the update method has been called after the last time
     * Inventory has been updated. POSTCONDITION: The JScrollPane will display
     * the correct list of sellable items on scree.
     *
     * @return the scrollPane for this JList
     */
    public JScrollPane getScroller() {
        return scroller;

    }

    private void selectBook(ListSelectionEvent e) {
        if (getSelectedIndex() < 0) {
            toUpdate.updateItem(null);
        } else {
            toUpdate.updateItem(inventory.getList().get(getSelectedIndex()));
        }
    }

    // inner class that handles a person clicking on a book in the list
    private class handleSelection implements ListSelectionListener {

        bookListPanel current;

        handleSelection(bookListPanel current) {
            this.current = current;
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            current.selectBook(e);
        }
    }

}
