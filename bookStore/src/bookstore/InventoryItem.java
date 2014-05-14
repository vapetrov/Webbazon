package bookstore;
public class InventoryItem implements Sellable
{
  private Book item;
  private int quantity;
  public InventoryItem(Book book)
	{
		book = item;
	}
  public void setQuantity(int amount)
  	{
  		quantity = amount;
  	}
  public int getQuantity()
 	{
  		return quantity; 
  	}
  public Book getItem()
  {
  	return item;
  }
  public String getID()
  {
      return item.getID();
  }
  public double getPrice()
          {
              return item.getPrice();
          }
  public String getName()
  {
      return item.getName();
  }
}
          
          

