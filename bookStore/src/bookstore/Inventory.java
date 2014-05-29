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

        for (InventoryItem single : items) {
            if (single.getID().equalsIgnoreCase(item.getID()) || single.getName().equalsIgnoreCase(item.getName())) {
                throw new IllegalArgumentException("item already exists");
            }
        }

        items.add(item);
        if (items.size() >= 2) {
            items = selectionSort(items);
        }
    }

    public ArrayList<InventoryItem> selectionSort(ArrayList<InventoryItem> data) {
        int lenD = data.size();
        int j = 0;
        InventoryItem tmp = null;
        for (int i = 0; i < lenD; i++) {
            j = i;
            for (int k = i; k < lenD; k++) {
                if (data.get(j).getID().compareTo(data.get(k).getID()) > 0) {
                    j = k;
                }
            }
            tmp = data.get(i);
            data.set(i, data.get(j));
            data.set(j, tmp);
        }
        return data;
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
    
    public InventoryItem getBySellable(Sellable sell){
        for(InventoryItem temp: items){
            if(temp.getItem() == sell){
                return temp;
            }
        }
        return null;
    }
    


    public void addNewBook(double cost, String isbn, String author, String title, int quantity) {

        Sellable Item = new Book(cost, isbn, author, title);
        InventoryItem inv = new InventoryItem(Item, quantity);
        addItem(inv);

    }

}
