
package bookstore;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;

/**
 * This class displays the contents of an inventory. It also allows users to select items in the inventory to get more information about them
 * @author Vassily
 */
public class bookListPanel extends JList {
    
    private Inventory inventory;
    private JScrollPane scroller;
    
    public bookListPanel(Inventory inventory){
        super();
        this.inventory = inventory;
        create();
        scroller = new JScrollPane(this);
        scroller.setPreferredSize(new Dimension(800, 400));
        scroller.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), scroller.getBorder()));
        
    }
    
    private void create(){
        setFont(new Font("Helvetica", 3, 14));

        setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        setLayoutOrientation(JList.VERTICAL);
        setVisibleRowCount(-1);
        update();
        
    }
    
    
    /**
     * Updates the current list of sellable objects Displayed on screen.
     * This method must be called whenever the Inventory updates, or else the updates will not be visible.
     */
    public void update(){
        ArrayList<String> names = new ArrayList<String>();
        for(InventoryItem s: inventory.getList()){
            names.add(s.getItem().getName());
        }
        
        this.setListData(names.toArray());
        
    }
    
    /**
     * Obtains the JSCrollPane for properly displaying this list in a JPane.
     * PRECONDITION: the update method has been called after the last time Inventory has been updated.
     * POSTCONDITION: The JScrollPane will display the correct list of sellable items on scree.
     * @return the scrollPane for this JList 
     */
    public JScrollPane getScroller(){
        return scroller;
        
    }
    
    
    
    
    
    
    
}
