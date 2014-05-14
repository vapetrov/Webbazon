package bookstore;
//Class Inventory Item is a sellable item that will be available in the inventory
public class InventoryItem implements Sellable {
    //private fields
    private Book item; 
    private int quantity;

    //InventoryItem constructor: sets the inventory item to a book. 
    //Postcondition: successfully sets up a Book inventory item. 
    //Precondition: As of now (or until Webbazon decides to sell another item) constructor parameters must contain a book. 
    //@param (Book) book
    public InventoryItem(Book book) {
        book = item;
    }
    //setQuantity: sets the quantity of the item to amount.
    //Postcondition: successfully sets quantity to the given amount. 
    //Precondition: amount must contain a paramater (int). 
    //@param (int) amount
    public void setQuantity(int amount) {
        quantity = amount;
    }
    //getQuantity: returns the quantity. 
    //Postcondition: returns quantity.
    //Precondition: quantity must be set and initialized before calling this method.
    //@return (int) quantity
    public int getQuantity() {
        return (int) quantity;
    }
    //getItem: returns the Item.
    //Postcondition: returns the item.
    //Precondition: item must be set and initualized before calling this method.
    //@return (Book) item.
    public Book getItem() {
        return (Book) item;
    }
    //getID: returns the ID number of the item. 
    //Postcondition: returns the item's ID
    //Precondition: item must be set and initialized and also must contain an ID number before calling this method.
    //@return (String) getID()
    public String getID() {
        return (String) item.getID();
    }
    //getPrice: returns the (double) price. 
    //Postcondition: returns the item's price.
    //Precondition: item must be set and initialized and also must contain a price before calling this method.
    //@return (double) getPrice()
    public double getPrice() {
        return (double) item.getPrice();
    }
    //getName: returns the (String) name. 
    //Postcondition: returns the item's name
    //Precondition: item must be set and initialized and also must contain a name before calling this method.
    //@return (String) getName()
    public String getName() {
        return (String) item.getName();
    }
}
