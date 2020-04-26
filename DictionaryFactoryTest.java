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
public class DictionaryFactoryTest {
    
    public DictionaryFactoryTest() {
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
     * Test of getObject method, of class DictionaryFactory.
     */
    @Test
    public void testGetObject() {
        System.out.println("getObject");
        String tipo = "";
        DictionaryFactory instance = new DictionaryFactory();
        Object expResult = null;
        Object result = instance.getObject(tipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
}
