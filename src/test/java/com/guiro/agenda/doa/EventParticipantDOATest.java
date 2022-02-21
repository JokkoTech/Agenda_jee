/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.guiro.agenda.doa;

import com.guiro.donnees.EventParticipant;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author T490
 */
public class EventParticipantDOATest {
    
    public EventParticipantDOATest() {
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
     * Test of getAll method, of class EventParticipantDOA.
     */
    @Test
    public void testGetAll() {
        try {
            System.out.println("getAll");
            EventParticipantDOA instance = new EventParticipantDOA();
            List<EventParticipant> expResult = null;
            List<EventParticipant> result = instance.getAll(1);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventParticipantDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getById method, of class EventParticipantDOA.
     */
    @Test
    public void testGetById() {
        try {
            System.out.println("getById");
            int id = 0;
            EventParticipantDOA instance = new EventParticipantDOA();
            EventParticipant expResult = null;
            EventParticipant result = instance.getById(id);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventParticipantDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of add method, of class EventParticipantDOA.
     */
    @Test
    public void testAdd() {
        try {
            System.out.println("add");
            EventParticipant ep = null;
            EventParticipantDOA instance = new EventParticipantDOA();
            boolean expResult = false;
            boolean result = instance.add(ep);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventParticipantDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of update method, of class EventParticipantDOA.
     */
    @Test
    public void testUpdate() {
        try {
            System.out.println("update");
            EventParticipant ep = null;
            EventParticipantDOA instance = new EventParticipantDOA();
            boolean expResult = false;
            boolean result = instance.update(ep);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventParticipantDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of delete method, of class EventParticipantDOA.
     */
    @Test
    public void testDelete() {
        try {
            System.out.println("delete");
            int id = 0;
            EventParticipantDOA instance = new EventParticipantDOA();
            boolean expResult = false;
            boolean result = instance.delete(id);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventParticipantDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
