/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore;

/**
 * A type of text that can be sold for a price, and has an ISBN, price, title and author.
 * @author Vassily
 */
public class Book implements Sellable {
    
    private double cost; //Price can be changed
    public final String ISBN;
    public final String AUTHOR;
    public final String TITLE;
    
    public Book(double cost, String isbn, String author, String title){
        this.cost = cost;
        ISBN = isbn;
        AUTHOR = author;
        TITLE = title;
    }
    
    public double getPrice(){
        return cost;
    }
    
    public String getID(){
        return ISBN; 
    }
    
    public String getISBN(){
        return ISBN;
    }
    
    public String getName(){
        return TITLE;
    }
    
    
    
    
    
}
