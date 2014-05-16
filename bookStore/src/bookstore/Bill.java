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

public class Bill extends Inventory {
	private ArrayList<InventoryItem> inventoryList;
	public Bill()
	{
		super();
		inventoryList = super.getList();
	}
	public double getTotalCost()
	{
	    double totalCost = 0;
	    for(InventoryItem tempItem: inventoryList)
	    	totalCost += tempItem.getPrice() * tempItem.getQuantity(); 
	    return totalCost; 
	}
	public boolean verify(Inventory list)
	{
	        ArrayList<InventoryItem> totalList = list.getList();
		for(InventoryItem tempItem: inventoryList)
		{
			int counter = totalList.indexOf(tempItem);
			if(counter < 0)
				return false; 
                    InventoryItem testItem = totalList.get(counter); 
			if(tempItem.getQuantity() > testItem.getQuantity() )
				return false;
		}
		return true; 
	}
	public void sellBooks(Inventory list)
	{
		if(verify(list))
			for(InventoryItem tempItem: inventoryList)
				tempItem.setQuantity(tempItem.getQuantity() - 1);
	}
}




