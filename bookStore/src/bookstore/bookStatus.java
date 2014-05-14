
package bookstore;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    
    
  
    
    
    private void create() {

        this.setLayout(new GridLayout());

        JPanel selectedBook = new JPanel();
        selectedBook.setLayout(new BoxLayout(selectedBook, BoxLayout.Y_AXIS));
        selectedBook.setBorder(new TitledBorder("Selected Book:"));
        selectedBook.add(new JLabel("Author: J.K. Rowling"));
        selectedBook.add(new JLabel("ISBN: 4523453452345"));
        selectedBook.add(new JLabel("Books available: 9"));
        selectedBook.add(new JLabel("cost: $19.99"));
        add(selectedBook);

        JPanel totalBook = new JPanel();
        totalBook.setLayout(new BoxLayout(totalBook, BoxLayout.Y_AXIS));
        totalBook.setBorder(new TitledBorder("Book total:"));
        totalBook.add(new JLabel("Books sold: 12"));
        totalBook.add(new JLabel("Total Revenue: $53.34"));
        add(totalBook);

        updateSize();
        

    }
    
    private void updateSize(){
        setMaximumSize(new Dimension(Integer.MAX_VALUE, getPreferredSize().height));      
    }

}
