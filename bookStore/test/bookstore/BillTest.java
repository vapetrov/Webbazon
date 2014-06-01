/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vassily
 */
public class BillTest {
    
    public BillTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTotalCost method, of class Bill.
     */
    @Test
    public void testGetTotalCost() {
        System.out.println("getTotalCost");
        
        Bill instance = new Bill("Tommy");
        instance.addNewBook(453, "sdf", "sdf", "sda", 45);
        instance.addNewBook(12, "we", "dd", "sd", 65);
   
        
        assertEquals(65*12+45*453, instance.getTotalCost(), 0.001);
        
    }

    /**
     * Test of getTotalCopies method, of class Bill.
     */
    @Test
    public void testGetTotalCopies() {
        System.out.println("getTotalCopies");

        Bill instance = new Bill("Tommy");
        instance.addNewBook(453, "sdf", "sdf", "sda", 45);
        instance.addNewBook(12, "we", "dd", "sd", 65);
   
        
        assertEquals(65+45, instance.getTotalCopies(), 0.001);
    }

    /**
     * Test of verify method, of class Bill.
     */
    @Test
    public void testVerify() {
        System.out.println("verify");

        Sellable book = new Book(12,"degf","sdf","qwer");
        Inventory inventory = new Inventory();
        inventory.addItem(new InventoryItem(book, 13));
        
        Bill instance = new Bill("Tommy");
        instance.addItem(new InventoryItem(book,12));
        
        assertTrue(instance.verify(inventory));
        
        instance = new Bill("Tommy");
        instance.addItem(new InventoryItem(book,14));
        assertFalse(instance.verify(inventory));
        
    }

    /**
     * Test of sellBooks method, of class Bill.
     */
    @Test
    public void testSellBooks() {
        System.out.println("sellBooks");

        Sellable book = new Book(456,"degf","sdf","qwer");
        Inventory inventory = new Inventory();
        InventoryItem item = new InventoryItem(book, 13);
        inventory.addItem(item);
        
        Bill instance = new Bill("Tommy");
        instance.addItem(new InventoryItem(book,12));   
        
        instance.sellBooks(inventory);
        
        assertEquals(1, item.getQuantity());
        
        
    }
    
}
