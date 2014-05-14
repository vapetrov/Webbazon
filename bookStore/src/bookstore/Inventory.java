/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore;
import java.util.ArrayList;

/**
 *
 * @author Jagjit
 */
//Class Inventory
public class Inventory extends InventoryItem
{
        //Private fields.
	private ArrayList<InventoryItem> items;
        //Constructs new Inventory and uses the superclass's constructor.
        //@param (Book) book
	public Inventory(Book book)
        {
            super(book);
            items = new ArrayList<InventoryItem>(); 
        }
        //addItem adds the specified item to the complete InventoryItem list.
        //Postcondition: item is added to items.
        //Precondition: item must be occupied
        //@param (InventoryItem) item
        public void addItem(InventoryItem item)
        {
            items.add(item);
        }
        //removeItem removes the specified item from the complete InventoryItem list.
        //Postcondition: item is removed from items.
        //Precondition: item must be occupied.
        //@param (InventoryItem) item
        public void removeItem(InventoryItem item)
        {
            boolean removed = true;
            while(removed)
                removed = items.remove(item);
                      
         }
        //getList returns the list items as an ArrayList.
        //Postcondition: items is returned. 
        //Precondition: items must be occupied.
        //@return ArrayList<InventoryItem> items.
        public ArrayList<InventoryItem> getList()
        {
            //Checks to make sure that items is not empty.
            while(items.get(0) == null)
                System.out.println("Items list is empty. Please try again!");
            return items;
            
        }
                
}

