package bookstore;

/**
 * An InventoryItem represents a single entry in an inventory. It stores both a
 * sellable item and the quantity of that item.
 *
 * @author Jagjit
 */
public class InventoryItem {

    private Sellable item;
    private int quantity;

    /**
     * InventoryItem constructor: sets the inventory item to a book.
     * //Postcondition: successfully sets up a Book inventory item.
     * //Precondition: As of now (or until Webbazon decides to sell another
     * item) constructor parameters must contain a book. //@param (Book) book
     */
    public InventoryItem(Sellable item, int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity has to be more than 0");
        }

        this.item = item;
        this.quantity = quantity;
    }

    /**
     * setQuantity: sets the quantity of the item to amount. //Postcondition:
     * successfully sets quantity to the given amount. //Precondition: amount
     * must contain a paramater (int). //@param (int) amount
     */
    public void setQuantity(int amount) {
        quantity = amount;
    }

    /**
     * getQuantity: returns the quantity. //Postcondition: returns quantity.
     * //Precondition: quantity must be set and initialized before calling this
     * method. //@return (int) quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * getItem: returns the Item. //Postcondition: returns the item.
     * //Precondition: item must be set and initialized before calling this
     * method. //@return item.
     */
    public Sellable getItem() {
        return item;
    }

    public double getPrice() {
        return item.getPrice();
    }

    public String getID() {
        return item.getID();
    }

    public String getName() {
        return item.getName();
    }

    public String getCreator() {
        return item.getCreator();
    }

    @Override
    public String toString() {
        return item.toString();
    }
    
    /**
     * Compares whether or not one InventoryItem is equal to another.
     * @param o another InventoryItem
     * @return true if they contain the same data, otherwise false.
     */
    @Override
    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }

        InventoryItem item = null;
        try {
            item = (InventoryItem) o;
        } catch (ClassCastException ex) {
            return false;
        }
        if (item.getItem().equals(this.item) && item.getQuantity() == quantity) {
            return true;
        }
        return false;
    }
}
