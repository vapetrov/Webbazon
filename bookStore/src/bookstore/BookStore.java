  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import bookstore.GUI.billWindow;
import bookstore.GUI.mainGUI;

/**
 *
 * @author Vassily and Jajgit
 */
public class BookStore {

    /**
     * This is the runner class. Later it will become the GUI.
     *
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Inventory mainInventory = new Inventory();

        mainInventory.addItem(new InventoryItem(new Book(12.99, "234234DF", "J.K. Rowling", "Harry Potter"), 12));
        mainInventory.addItem(new InventoryItem(new Book(19.95, "asdf234", "Scott Fitzgerald", "The Great Gatsby"), 14));
        mainInventory.addItem(new InventoryItem(new Book(99.99, "1234abcd", "Leo Tolstoy", "War and Peace"), 16));
        mainInventory.addItem(new InventoryItem(new Book(3.00, "dd4523", "John Steinbeck", "Of Mice and Men"), 18));
        mainInventory.addItem(new InventoryItem(new Book(34.00, "34564576dgf", "Mr.Webb", "AP Comp. Sci A"), 999));

        mainGUI.make(mainInventory);

        
        /*
        Bill bill = new Bill("Bob Jr.");

        bill.addItem(new InventoryItem(new Book(12.99, "234234DF", "J.K. Rowling", "Harry Potter"), 12));
        bill.addItem(new InventoryItem(new Book(19.95, "asdf234", "Scott Fitzgerald", "The Great Gatsby"), 14));
        bill.addItem(new InventoryItem(new Book(99.99, "1234abcd", "Leo Tolstoy", "War and Peace"), 16));
        bill.addItem(new InventoryItem(new Book(3.00, "dd4523", "John Steinbeck", "Of Mice and Men"), 18));
        bill.addItem(new InventoryItem(new Book(34.00, "34564576dgf", "Mr.Webb", "AP Comp. Sci A"), 999));
        
        billWindow window = new billWindow(bill);
        window.setVisible(true);
        */
    }

}
