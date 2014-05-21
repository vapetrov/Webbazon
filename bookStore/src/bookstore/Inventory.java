package bookstore;

import java.util.ArrayList;

/**
 *
 * @author Jagjit
 */
//Class Inventory
public class Inventory {

    //Private fields.
    private ArrayList<InventoryItem> items;

    //Constructs new Inventory and uses the superclass's constructor.
    //@param (Book) book
    public Inventory() {
        items = new ArrayList<InventoryItem>();
    }

    //addItem adds the specified item to the complete InventoryItem list.
    //Postcondition: item is added to items.
    //Precondition: item must be occupied
    //@param (InventoryItem) item
    public void addItem(InventoryItem item) {
        items.add(item);
    }

    //removeItem removes the specified item from the complete InventoryItem list.
    //Postcondition: item is removed from items.
    //Precondition: item must be occupied.
    //@param (InventoryItem) item
    public void removeItem(InventoryItem item) {
        boolean removed = true;
        while (removed) {
            removed = items.remove(item);
        }

    }

    //getList returns the list items as an ArrayList.
    //Postcondition: items is returned. 
    //Precondition: items must be occupied.
    //@return ArrayList<InventoryItem> items.
    public ArrayList<InventoryItem> getList() {
        //Checks to make sure that items is not empty.
        if (items.get(0) == null) {
            System.out.println("Items list is empty. Please try again!");
        }
        return items;

    }

    public InventoryItem get(Object o) {
        if (o != null && items.indexOf(o) >= 0) {
            return items.get(items.indexOf(o));
        }
        return null;
    }

    public void addNewBook(double cost, String isbn, String author, String title, int quantity) {

        Sellable Item = new Book(cost, isbn, author, title);
        InventoryItem inv = new InventoryItem(Item, quantity);
        addItem(inv);

    }

}
