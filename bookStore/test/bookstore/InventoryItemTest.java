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
public class InventoryItemTest {
    
    public InventoryItemTest() {
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
     * Test of setQuantity method, of class InventoryItem.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        
        InventoryItem instance = new InventoryItem(new Book(12,"a","b","c"),34);
        instance.setQuantity(34);
        assertEquals(34,instance.getQuantity());
        
        instance = new InventoryItem(new Book(12,"a","b","c"),34);
        instance.setQuantity(45);
        assertEquals(45,instance.getQuantity());
        

        
    }

    /**
     * Test of getQuantity method, of class InventoryItem.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        
        InventoryItem instance = new InventoryItem(new Book(12,"a","b","c"),34);
        assertEquals(34,instance.getQuantity());
        
        instance = new InventoryItem(new Book(72,"a","b","c"),78);
        assertEquals(78,instance.getQuantity());
        
    }

    /**
     * Test of getItem method, of class InventoryItem.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        
        Sellable item = new Book(345,"a","b","c");
        InventoryItem instance = new InventoryItem(item, 34);
        assertEquals(item, instance.getItem());
        
        item = new Book(456,"fgd","sgf","wer");
        instance = new InventoryItem(item, 34);
        assertEquals(item, instance.getItem());
        
    }

    /**
     * Test of getPrice method, of class InventoryItem.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        
        Sellable item = new Book(345,"a","b","c");
        InventoryItem instance = new InventoryItem(item, 34);
        assertEquals(345, instance.getPrice(), 0);
        
        item = new Book(76,"fgd","sgf","wer");
        instance = new InventoryItem(item, 34);
        assertEquals(76, instance.getPrice(), 0);
    }

    /**
     * Test of getID method, of class InventoryItem.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        
        Sellable item = new Book(345,"a","b","c");
        InventoryItem instance = new InventoryItem(item, 34);
        assertEquals("a", instance.getID());
        
        item = new Book(76,"fgd","sgf","wer");
        instance = new InventoryItem(item, 34);
        assertEquals("fgd", instance.getID());
    }

    /**
     * Test of getName method, of class InventoryItem.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");

        Sellable item = new Book(345,"a","b","c");
        InventoryItem instance = new InventoryItem(item, 34);
        assertEquals("c", instance.getName());
        
        item = new Book(76,"fgd","sgf","wer");
        instance = new InventoryItem(item, 34);
        assertEquals("wer", instance.getName());
    }

    /**
     * Test of getCreator method, of class InventoryItem.
     */
    @Test
    public void testGetCreator() {
        System.out.println("getCreator");

        Sellable item = new Book(345,"a","b","c");
        InventoryItem instance = new InventoryItem(item, 34);
        assertEquals("b", instance.getCreator());
        
        item = new Book(76,"fgd","sgf","wer");
        instance = new InventoryItem(item, 34);
        assertEquals("sgf", instance.getCreator());
    }

    /**
     * Test of toString method, of class InventoryItem.
     */
    @Test
    public void testToString() {
        System.out.println("toString");

        Sellable item = new Book(345,"a","b","c");
        InventoryItem instance = new InventoryItem(item, 34);
        assertEquals("c by: b", instance.toString());
        
        item = new Book(76,"fgd","sgf","wer");
        instance = new InventoryItem(item, 34);
        assertEquals("wer by: sgf", instance.toString());
    }

    /**
     * Test of equals method, of class InventoryItem.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        InventoryItem instance = new InventoryItem(new Book(345,"a","b","c"), 34);
        InventoryItem book2 = new InventoryItem(new Book(345,"a","b","c"), 34);
        assertTrue(instance.equals(book2));
        
        instance = new InventoryItem(new Book(35,"adf","w","qq"), 554);
        book2 = new InventoryItem(new Book(35,"adf","w","qq"), 554);
        assertTrue(instance.equals(book2));
    }
    
}
