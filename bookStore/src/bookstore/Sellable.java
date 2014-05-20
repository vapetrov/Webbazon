

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
    
    /**
     * Retrieves the name of the person who made this item.
     * For books, this would be an author.
     * @return name.
     */
    String getCreator();
    
    
}
