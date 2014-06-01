package bookstore;

/**
 * A bill is used for storing inventorItems that will be sold from a main
 * inventory
 *
 * @author Jagjit
 */
//class Bill
public class Bill extends Inventory {

    public final String customer;

    /**
     * Postcondition: a new bill will be created. Precondition: super.getList()
     * must already be made.
     *
     * @param customer Name of the customer.
     */
    public Bill(String customer) {
        super();
        this.customer = customer;

    }

    /**
     * returns the total bill for the customer. Postcondition: totalCost is
     * returned Precondition: super.getList() must be occupied.
     *
     * @return totalCost
     */
    public double getTotalCost() {
        double totalCost = 0;
        for (InventoryItem tempItem : getList()) {
            totalCost += tempItem.getPrice() * tempItem.getQuantity();
        }
        return totalCost;
    }

    /**
     * Calculates the total number of copies of books sold in this bill
     *
     * @return number of books sold
     */
    public int getTotalCopies() {
        int copies = 0;
        for (InventoryItem item : getList()) {
            copies += item.getQuantity();
        }
        return copies;
    }

    /**
     * Decides whether the items in the inventory can be bought. Postcondition:
     * returns true or false based on whether the items can be bought.
     * Precondition: list and super.getList() must be occupied.
     *
     * @param list
     * @return true or false
     */
    public boolean verify(Inventory list) {

        for (InventoryItem tempItem : getList()) {
            if (list.getBySellable(tempItem.getItem()) == null) {
                throw new IllegalArgumentException("Item '" + tempItem + "' not available");
            }
            InventoryItem main = list.getBySellable(tempItem.getItem());
            if (main.getQuantity() < tempItem.getQuantity()) {
                return false;
            }
        }
        return true;
    }

    /**
     * "sells" the inventory items by reducing the quantity of each item IF the
     * list is verified. //Postcondition: reduces quantity of each item in the
     * super.getList(). //Precondition: super.getList() and list must be
     * occupied. //@param list
     */
    public void sellBooks(Inventory list) {
        if (verify(list)) {
            for (InventoryItem tempItem : getList()) {

                InventoryItem main = list.getBySellable(tempItem.getItem());
                main.setQuantity(main.getQuantity() - tempItem.getQuantity());

            }
        }
    }
}
