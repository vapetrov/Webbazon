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
//class Bill
public class Bill extends Inventory {
        //Private fields
	private ArrayList<InventoryItem> inventoryList;
	//Bill Constructor
        //Postcondition: a new bill will be created.
        //Precondition: inventoryList must already be made.
        public Bill()
	{
		super();
		inventoryList = super.getList();
	}
        //getTotalCost returns the total bill for the customer.
        //Postcondition: totalCost is returned
        //Precondition: inventoryList must be occupied.
        //@return totalCost
	public double getTotalCost()
	{
	    double totalCost = 0;
	    for(InventoryItem tempItem: inventoryList)
	    	totalCost += tempItem.getPrice() * tempItem.getQuantity(); 
	    return totalCost; 
	}
        //Decides whether the items in the inventory can be bought.
        //Postcondition: returns true or false based on whether the items can be bought.
        //Precondition: list and inventoryList must be occupied.
        //@param list
        //@return true or false
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
        //sellBooks "sells" the inventory items by reducing the quantity of each item IF the list is verified.
        //Postcondition: reduces quantity of each item in the inventoryList.
        //Precondition: inventoryList and list must be occupied.
        //@param list
	public void sellBooks(Inventory list)
	{
		if(verify(list))
                {
			for(InventoryItem tempItem: inventoryList)
				tempItem.setQuantity(tempItem.getQuantity() - 1);
                }
	}
}




