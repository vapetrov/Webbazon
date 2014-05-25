package bookstore.GUI;

import bookstore.InventoryItem;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

/**
 * A helper class for maintaining the JPanel that displays information on books
 * selected and sold.
 *
 * @author Vassily
 */
public class bookStatusPanel extends JPanel {

    JPanel selectedBook;
    JPanel totalBook;
    int sold;
    double revenue;
    
    bookStatusPanel() {
        super();
        sold = 0;
        revenue = 0;
        selectedBook = new JPanel();
        totalBook = new JPanel();
        create();
    }

    /*
    
     TODO: Dummy data should be replaced with methods that will update Information to show.
     Method must call updateSize() Afterwards!!
    
     Methods:
     updateItem(IventoryItem)
     updateTotal(int soldItems, int totalMoney)
     */
    public void updateItem(InventoryItem item) {

        selectedBook.removeAll();

        if (item != null) {
            selectedBook.add(new JLabel("Author: " + item.getItem().getCreator()));
            selectedBook.add(new JLabel("ISBN: " + item.getItem().getID()));
            selectedBook.add(new JLabel("Books available: " + item.getQuantity()));
            selectedBook.add(new JLabel("cost: $" + item.getItem().getPrice()));
        } else {
            selectedBook.add(new JLabel("Author: --"));
            selectedBook.add(new JLabel("ISBN: --"));
            selectedBook.add(new JLabel("Books available: --"));
            selectedBook.add(new JLabel("cost: --"));
        }

        this.updateUI();
        updateSize();
    }

    /**
     * Adds amount to the amount of books sold and money taken in.
     *
     * @param copies Number of books sold.
     * @param money Total amount of money taken in.
     */
    public void addToTotal(int copies, double money) {
        sold += copies;
        revenue += money;
        totalBook.removeAll();
        totalBook.add(new JLabel("Books sold: " + sold));
        totalBook.add(new JLabel("Total Revenue: $" + String.format("%.2f", revenue)));
        updateSize();
    }

    private void create() {

        this.setLayout(new GridLayout());

        //selectedBook.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        selectedBook.setLayout(new BoxLayout(selectedBook, BoxLayout.Y_AXIS));
        selectedBook.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(0, 10, 10, 5), new TitledBorder("Selected Book:")));
        add(selectedBook);

        for (Component e : selectedBook.getComponents()) {
            ((JComponent) e).setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
        }

        //totalBook.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        totalBook.setLayout(new BoxLayout(totalBook, BoxLayout.Y_AXIS));
        totalBook.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(0, 5, 10, 10), new TitledBorder("Book total:")));
        add(totalBook);

        for (Component e : totalBook.getComponents()) {
            ((JComponent) e).setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
        }
        addToTotal(0,0);
        updateItem(null);
        updateSize();

    }

    private void updateSize() {
        setMaximumSize(new Dimension(Integer.MAX_VALUE, getPreferredSize().height));
    }

}
