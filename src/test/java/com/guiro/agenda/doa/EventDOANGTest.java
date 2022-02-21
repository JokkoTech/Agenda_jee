/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package com.guiro.agenda.doa;

import com.guiro.donnees.Event;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.testng.Assert.*;

/**
 *
 * @author Guiro
 */
public class EventDOANGTest {
    
    public EventDOANGTest() {
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getEvents method, of class EventDOA.
     */
    @org.testng.annotations.Test
    public void testGetEvents() {
        System.out.println("getEvents");
        try{
            EventDOA instance = new EventDOA();
            List expResult = null;
            List result = instance.getEvents(1);
            assertEquals(result, expResult);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getEventById method, of class EventDOA.
     */
    @org.testng.annotations.Test
    public void testGetEventById() {
        System.out.println("getEventById");
        int id = 0;
        
        try{
            EventDOA instance = new EventDOA();
            Event expResult = null;
            Event result = instance.getEventById(id);
            assertEquals(result, expResult);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getEventsByName method, of class EventDOA.
     */
    @org.testng.annotations.Test
    public void testGetEventsByName() {
        System.out.println("getEventsByName");
        String eventName = "";
        
        try{
            EventDOA instance = new EventDOA();
            List expResult = null;
            List result = instance.getEventsByName(eventName);
            assertEquals(result, expResult);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of addEvent method, of class EventDOA.
     */
    @org.testng.annotations.Test
    public void testAddEvent() {
        System.out.println("addEvent");
        Event ev = null;
        
        try{
            EventDOA instance = new EventDOA();
            boolean expResult = false;
            boolean result = instance.addEvent(ev);
            assertEquals(result, expResult);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of update_event method, of class EventDOA.
     */
    @org.testng.annotations.Test
    public void testUpdate_event() {
        System.out.println("update_event");
        Event ev = null;
        
        try{
            EventDOA instance = new EventDOA();
            boolean expResult = false;
            boolean result = instance.update_event(ev);
            assertEquals(result, expResult);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of delete_event method, of class EventDOA.
     */
    @org.testng.annotations.Test
    public void testDelete_event() {
        System.out.println("delete_event");
        int id = 0;
        
        try{
            EventDOA instance = new EventDOA();
            boolean expResult = false;
            boolean result = instance.delete_event(id);
            assertEquals(result, expResult);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
