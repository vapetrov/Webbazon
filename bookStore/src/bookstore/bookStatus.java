
package bookstore;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

/**
 * A helper class for maintaining the JPanel that displays information on books selected and sold. 
 * @author Vassily
 */
public class bookStatus extends JPanel {

    bookStatus() {
        super();
        create();
    }
    
    
  
    /*
    
    TODO: Dummy data should be replaced with methods that will update Information to show.
          Method must call updateSize() Afterwards!!
    
    Methods:
         updateItem(IventoryItem)
         updateTotal(int soldItems, int totalMoney)
    */
    
    
    
    private void create() {

        this.setLayout(new GridLayout());

        JPanel selectedBook = new JPanel();
        //selectedBook.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        selectedBook.setLayout(new BoxLayout(selectedBook, BoxLayout.Y_AXIS));
        selectedBook.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(0, 10, 10, 5), new TitledBorder("Selected Book:")));
        selectedBook.add(new JLabel("Author: J.K. Rowling"));
        selectedBook.add(new JLabel("ISBN: 4523453452345"));
        selectedBook.add(new JLabel("Books available: 9"));
        selectedBook.add(new JLabel("cost: $19.99"));
        add(selectedBook);
        
        for(Component e: selectedBook.getComponents()){
            ((JComponent)e).setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
        }

        JPanel totalBook = new JPanel();
        //totalBook.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        totalBook.setLayout(new BoxLayout(totalBook, BoxLayout.Y_AXIS));
        totalBook.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(0, 5, 10, 10), new TitledBorder("Book total:")));
        totalBook.add(new JLabel("Books sold: 12"));
        totalBook.add(new JLabel("Total Revenue: $53.34"));
        add(totalBook);

        for(Component e: totalBook.getComponents()){
            ((JComponent)e).setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
        }
        
        updateSize();
        

    }
    
    private void updateSize(){
        setMaximumSize(new Dimension(Integer.MAX_VALUE, getPreferredSize().height));      
    }

}
