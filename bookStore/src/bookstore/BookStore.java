  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

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
        mainInventory.addItem(new InventoryItem(new Book(19.95, "asdf234", "Scott Fitzgerald", "The Great Gatsby"), 7));
        mainInventory.addItem(new InventoryItem(new Book(99.99, "1234abcd", "Leo Tolstoy", "War and Peace"), 23));
        mainInventory.addItem(new InventoryItem(new Book(3.00, "dd4523", "John Steinbeck", "Of Mice and Men"), 23));
        mainInventory.addItem(new InventoryItem(new Book(34.00, "34564576dgf", "Mr.Webb", "AP Comp. Sci A"), 999));

        mainGUI.make(mainInventory);

        
        
        
        /*another test here
        Sellable myBook = new Book(19.95, "853BA", "Mr.Jones", "War and Peace");

        System.out.println(((Book) myBook).TITLE);
        System.out.println(((Book) myBook).AUTHOR);
        System.out.println(myBook.getPrice());
        //System.out.println("Hello World!!!");
        */

    }

}
