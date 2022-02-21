/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.guiro.agenda.doa;

import com.guiro.donnees.Event;
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
 * @author Guiro
 */
public class EventDOATest {
    
    public EventDOATest() {
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
     * Test of getEvents method, of class EventDOA.
     */
    @Test
    public void testGetEvents() {
        System.out.println("getEvents");
        EventDOA instance;
        try {
            instance = new EventDOA();
            
            List<Event> expResult = null;
            List<Event> result = instance.getEvents(1);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getEventById method, of class EventDOA.
     */
    @Test
    public void testGetEventById() {
        System.out.println("getEventById");
        int id = 0;
        try{
            EventDOA instance = new EventDOA();
            Event expResult = null;
            Event result = instance.getEventById(id);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getEventsByName method, of class EventDOA.
     */
    @Test
    public void testGetEventsByName() {
        System.out.println("getEventsByName");
        String eventName = "";
        try {
            EventDOA instance = new EventDOA();
            List<Event> expResult = null;
            List<Event> result = instance.getEventsByName(eventName);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of addEvent method, of class EventDOA.
     */
    @Test
    public void testAddEvent() {
        System.out.println("addEvent");
        Event ev = null;
        try{
            EventDOA instance = new EventDOA();
            boolean expResult = false;
            boolean result = instance.addEvent(ev);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of update_event method, of class EventDOA.
     */
    @Test
    public void testUpdate_event() {
        System.out.println("update_event");
        Event ev = null;
        try {
            EventDOA instance = new EventDOA();
            boolean expResult = false;
            boolean result = instance.update_event(ev);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of delete_event method, of class EventDOA.
     */
    @Test
    public void testDelete_event() {
        System.out.println("delete_event");
        int id = 0;
        try{
            EventDOA instance = new EventDOA();
            boolean expResult = false;
            boolean result = instance.delete_event(id);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
