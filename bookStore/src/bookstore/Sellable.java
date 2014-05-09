/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore;

/**
 * Represents any item that can be sold for a price. Also has a name and an ID.
 * @author Vassily
 */
public interface Sellable {
    
    /**
     * Retrieves the cost of the item.
     * @return cost of the item. 
     */
    double getPrice();
    
    
    /**
     * Retrieves name of the item.
     * @return name of item.
     */
    String getName();
    
    
    /**
     * Retrieves a unique ID for this item.
     * For Books, this is an ISBN.
     * @return Unique ID.
     */
    String getID();
    
}
