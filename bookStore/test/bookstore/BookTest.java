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
public class BookTest {
    
    public BookTest() {
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
     * Test of getPrice method, of class Book.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        
        Book instance = new Book(12,"4t","sedf","45");
        assertEquals(12.0, instance.getPrice(), 0);
  
        instance = new Book(24,"ddr","stef","bc");
        assertEquals(24.0, instance.getPrice(), 0);
        
        instance = new Book(1452,"fg","sdtf","edf");
        assertEquals(1452.0, instance.getPrice(), 0);
        
    }

    /**
     * Test of getID method, of class Book.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        
        
        Book instance = new Book(12,"4t","sedf","45");
        assertEquals("4t", instance.getID());
  
        instance = new Book(24,"ddr","stef","bc");
        assertEquals("ddr", instance.getID());
        
        instance = new Book(1452,"fg","sdtf","edf");
        assertEquals("fg", instance.getID());
    }

    /**
     * Test of getISBN method, of class Book.
     */
    @Test
    public void testGetISBN() {
        System.out.println("getISBN");
        Book instance = new Book(12,"4t","sedf","45");
        assertEquals("4t", instance.getISBN());
  
        instance = new Book(24,"ddr","stef","bc");
        assertEquals("ddr", instance.getISBN());
        
        instance = new Book(1452,"fg","sdtf","edf");
        assertEquals("fg", instance.getISBN());
    }

    /**
     * Test of getName method, of class Book.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        
        Book instance = new Book(12,"4t","sedf","45");
        assertEquals("4t", instance.getISBN());
  
        instance = new Book(24,"ddr","stef","bc");
        assertEquals("ddr", instance.getISBN());
        
        instance = new Book(1452,"fg","sdtf","edf");
        assertEquals("fg", instance.getISBN());
    }

    /**
     * Test of getCreator method, of class Book.
     */
    @Test
    public void testGetCreator() {
        
        Book instance = new Book(12,"4t","sedf","45");
        assertEquals("sedf", instance.getCreator());
  
        instance = new Book(24,"ddr","stef","bc");
        assertEquals("stef", instance.getCreator());
        
        instance = new Book(1452,"fg","sdtf","edf");
        assertEquals("sdtf", instance.getCreator());
    }

    /**
     * Test of toString method, of class Book.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        Book instance = new Book(12,"4t","sedf","abs");
        assertEquals("abs by: sedf", instance.toString());
  
        instance = new Book(24,"ddr","stef","bc");
        assertEquals("bc by: stef", instance.toString());
        
        instance = new Book(1452,"fg","sdtf","edf");
        assertEquals("edf by: sdtf", instance.toString());
    }

    /**
     * Test of equals method, of class Book.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        
        Book instance = new Book(24,"ddr","stef","bc");
        Book book2 = new Book(24,"ddr","stef","bc");
        
        assertTrue(instance.equals(book2));
        
    }
    
}
