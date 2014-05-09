/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore;

/**
 *
 * @author Vassily
 */
public class BookStore {

    /**
     * This is the runner class. Later it will become the GUI.
     * 
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        
        System.out.println("=== BOOK STORE!!! ===\n\n");
        
        //another test here
        
        Sellable myBook = new Book(19.95, "853BA","Mr.Jones","War and Peace");
        
        System.out.println(((Book) myBook).TITLE);
        System.out.println(((Book) myBook).AUTHOR);
        System.out.println(myBook.getPrice());
        
    }
    
}
