/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore;

import java.util.ArrayList;
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
public class InventoryTest {
    
    public InventoryTest() {
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
     * Test of addItem method, of class Inventory.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        InventoryItem item = new InventoryItem(new Book(9,"a","b","c"),4);
        Inventory instance = new Inventory();
        instance.addItem(item);
        assertEquals(item, instance.getList().get(0));
    }

    /**
     * Test of selectionSort method, of class Inventory.
     */
    @Test
    public void testSelectionSort() {
        System.out.println("selectionSort");
        
        InventoryItem item1 = new InventoryItem(new Book(45,"1","ab","ab"),10);
        InventoryItem item2 = new InventoryItem(new Book(45,"2","ab","ab"),10);
        InventoryItem item3 = new InventoryItem(new Book(45,"3","ab","ab"),10);
        
        ArrayList<InventoryItem> data = new ArrayList<InventoryItem>();
        data.add(item3);
        data.add(item1);
        data.add(item2);
        
        Inventory instance = new Inventory();
        
        ArrayList<InventoryItem> expResult = new ArrayList<InventoryItem>();
        expResult.add(item1);
        expResult.add(item2);
        expResult.add(item3);
        
        ArrayList<InventoryItem> result = instance.selectionSort(data);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeItem method, of class Inventory.
     */
    @Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        
        InventoryItem item1 = new InventoryItem(new Book(45,"1","asdfb","web"),10);
        InventoryItem item2 = new InventoryItem(new Book(45,"2","asdfd","adsf"),10);
        
        Inventory instance = new Inventory();
        instance.addItem(item1);
        instance.addItem(item2);
        instance.removeItem(item1);
        
        Inventory compare = new Inventory();
        compare.addItem(item2);
        
        assertEquals(instance.getList(),compare.getList());
    }

    /**
     * Test of getList method, of class Inventory.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        
        InventoryItem item1 = new InventoryItem(new Book(234,"1","a234b","a34b"),12);
        InventoryItem item2 = new InventoryItem(new Book(42,"2","a3b","a23b"),33);
        InventoryItem item3 = new InventoryItem(new Book(2456,"3","ab3","a4b"),19);
        
        Inventory instance = new Inventory();
        instance.addItem(item1);
        instance.addItem(item2);
        instance.addItem(item3);
        
        ArrayList<InventoryItem> expResult = new ArrayList<InventoryItem>();
        expResult.add(item1);
        expResult.add(item2);
        expResult.add(item3);
        
        
        assertEquals(expResult, instance.getList());
    }

    /**
     * Test of get method, of class Inventory.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        
        
        InventoryItem item1 = new InventoryItem(new Book(234,"1","a234b","a34b"),12);
        InventoryItem item2 = new InventoryItem(new Book(42,"2","a3b","a23b"),33);
        InventoryItem item3 = new InventoryItem(new Book(2456,"3","ab3","a4b"),19);
        
        Inventory instance = new Inventory();
        instance.addItem(item1);
        instance.addItem(item2);
        instance.addItem(item3);
        
        
        assertEquals(instance.get(item1), item1);
        assertEquals(instance.get(item2), item2);
        assertEquals(instance.get(item3), item3);
    }

    /**
     * Test of getBySellable method, of class Inventory.
     */
    @Test
    public void testGetBySellable() {
        System.out.println("getBySellable");
        
        InventoryItem item1 = new InventoryItem(new Book(234,"1","a234b","a34b"),12);
        InventoryItem item2 = new InventoryItem(new Book(42,"2","a3b","a23b"),33);
        InventoryItem item3 = new InventoryItem(new Book(2456,"3","ab3","a4b"),19);
        
        Inventory instance = new Inventory();
        instance.addItem(item1);
        instance.addItem(item2);
        instance.addItem(item3);
        
        assertEquals(instance.getBySellable(item1.getItem()), item1);
        assertEquals(instance.getBySellable(item2.getItem()), item2);
        assertEquals(instance.getBySellable(item3.getItem()), item3);
    }



    /**
     * Test of addNewBook method, of class Inventory.
     */
    @Test
    public void testAddNewBook() {
        System.out.println("addNewBook");
        
        InventoryItem item1 = new InventoryItem(new Book(244,"41","a45b","a45b"),12);
        InventoryItem item2 = new InventoryItem(new Book(44,"42","3453b","3453b"),33);
        InventoryItem item3 = new InventoryItem(new Book(256,"36","an3","a4b"),59);
        
        
        Inventory instance = new Inventory();
        instance.addNewBook(item1.getPrice(), item1.getID(), item1.getCreator(), item1.getName(), item1.getQuantity());
        assertEquals(instance.getList().get(0), item1);
        
        
        instance = new Inventory();
        instance.addNewBook(item2.getPrice(), item2.getID(), item2.getCreator(), item2.getName(), item2.getQuantity());
        assertEquals(instance.getList().get(0), item2);
        
        instance = new Inventory();
        instance.addNewBook(item3.getPrice(), item3.getID(), item3.getCreator(), item3.getName(), item3.getQuantity());
        assertEquals(instance.getList().get(0), item3);
                
    }
    
}
