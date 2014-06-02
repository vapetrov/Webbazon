package bookstore;

/**
 * A type of text that can be sold for a price, and has an ISBN, price, title
 * and author.
 *
 * @author Vassily
 */
public class Book implements Sellable {

    private double cost; //Price can be changed
    public final String ISBN;
    public final String AUTHOR;
    public final String TITLE;

    public Book(double cost, String isbn, String author, String title) {
        
   
        
        if (cost <= 0)
            throw new IllegalArgumentException("Cost has to be more than 0");
        
        if (isbn.equals("") || author.equals("") || title.equals(""))
            throw new IllegalArgumentException("Fields cannot be blank");
        
        this.cost = cost;
        ISBN = isbn;
        AUTHOR = author;
        TITLE = title;
    }


    public double getPrice() {
        return cost;
    }

    public String getID() {
        return ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getName() {
        return TITLE;
    }

    public String getCreator() {
        return AUTHOR;
    }

    
    /**
     * Formats the Object into a comprehensible string.
     * @return String representing object
     */
    @Override
    public String toString() {
        return TITLE + " by: " + AUTHOR;

    }

    /**
     * Compares the object to another one to see if they contain the same data.
     * @param o Object to compare.
     * @return True if they are equal, otherwise false.
     */
    @Override
    public boolean equals(Object o){
        
        if(o == null){
            return false;
        }
        
        Book item = null;
        try {
            item = (Book) o;
        } catch (ClassCastException ex) {
            return false;
        }
        
        return item.getID() == ISBN &&
               item.getCreator() == AUTHOR &&
               item.getName() == TITLE &&
               item.getPrice() == cost ;
        
    }
    
}
