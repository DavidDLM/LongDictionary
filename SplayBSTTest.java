/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author oscar
 */
public class SplayBSTTest {
    
    public SplayBSTTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of put method, of class SplayBST.
     */
    @Test
    public void testPut_Object_Object() {
        System.out.println("put");
        Object key = null;
        Object value = null;
        SplayBST instance = new SplayBST();
        instance.put(key, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class SplayBST.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Object key = null;
        SplayBST instance = new SplayBST();
        boolean expResult = false;
        boolean result = false;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of get method, of class SplayBST.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Object key = null;
        SplayBST instance = new SplayBST();
        Object expResult = null;
        Object result = "";
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of put method, of class SplayBST.
     */
    @Test
    public void testPut_GenericType_GenericType() {
        System.out.println("put");
        Object key = null;
        Object value = null;
        SplayBST instance = new SplayBST();
        instance.put(key, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class SplayBST.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Object key = null;
        SplayBST instance = new SplayBST();
        instance.remove(key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of height method, of class SplayBST.
     */
    @Test
    public void testHeight() {
        System.out.println("height");
        SplayBST instance = new SplayBST();
        int expResult = 0;
        int result = instance.height();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class SplayBST.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        SplayBST instance = new SplayBST();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
