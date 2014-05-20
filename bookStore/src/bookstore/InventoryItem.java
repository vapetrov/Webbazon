package bookstore;
//Class Inventory Item is a sellable item that will be available in the inventory
public class InventoryItem{
    //private fields
    private Sellable item; 
    private int quantity;

    //InventoryItem constructor: sets the inventory item to a book. 
    //Postcondition: successfully sets up a Book inventory item. 
    //Precondition: As of now (or until Webbazon decides to sell another item) constructor parameters must contain a book. 
    //@param (Book) book
    public InventoryItem(Sellable item, int quantity) {
        this.item = item;
        this.quantity = quantity;
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
        return quantity;
    }
    //getItem: returns the Item.
    //Postcondition: returns the item.
    //Precondition: item must be set and initualized before calling this method.
    //@return item.
    public Sellable getItem() {
        return item;
    }
    public double getPrice(){
        return item.getPrice();
    }
    public String getID(){
        return item.getID();
    }
    public String getName(){
        return item.getName();
    }
    public String getCreator(){
        return item.getCreator();
    }
    
    
    @Override
    public String toString(){
        return item.toString();
    }
    
    
    
 }
    


