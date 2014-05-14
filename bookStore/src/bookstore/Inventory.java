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
public class Inventory extends InventoryItem
{
	private ArrayList<InventoryItem> items;
	public Inventory()
        {
            items = new ArrayList<InventoryItem>(); 
        }
        public void addItem(InventoryItem item)
        {
            items.add(item);
        }
        public void removeItem(InventoryItem item)
        {
            int counter = 0;
            while(counter<items.size())
            {
                InventoryItem testItem = items.get(counter);
                if(testItem.equals(item))
                  counter++;
            }
            if(counter == 0)
            {
                if(!(items.get(counter).equals(item)))
                    return;
            }
        
            items.remove(counter);
         }
        public ArrayList<InventoryItem> getList()
        {
            return items;
        }
                
}

