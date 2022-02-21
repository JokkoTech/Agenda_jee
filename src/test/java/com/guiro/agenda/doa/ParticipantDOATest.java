/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.guiro.agenda.doa;

import com.guiro.donnees.Participant;
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
public class ParticipantDOATest {
    
    public ParticipantDOATest() {
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
     * Test of getParticipants method, of class ParticipantDOA.
     */
    @Test
    public void testGetParticipants() {
        System.out.println("getParticipants");
        
        try{
            ParticipantDOA instance = new ParticipantDOA();
            List<Participant> expResult = null;
            List<Participant> result = instance.getParticipants();
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getParticipantById method, of class ParticipantDOA.
     */
    @Test
    public void testGetParticipantById() {
        System.out.println("getParticipantById");
        int id = 0;
        
        try{
            ParticipantDOA instance = new ParticipantDOA();
            Participant expResult = null;
            Participant result = instance.getParticipantById(id);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getParticipantsByName method, of class ParticipantDOA.
     */
    @Test
    public void testGetParticipantsByName() {
        System.out.println("getParticipantsByName");
        String name = "";
        
        try{
            ParticipantDOA instance = new ParticipantDOA();
            List<Participant> expResult = null;
            List<Participant> result = instance.getParticipantsByName(name);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of addParticipant method, of class ParticipantDOA.
     */
    @Test
    public void testAddParticipant() {
        System.out.println("addParticipant");
        Participant p = null;
        
        try{
            ParticipantDOA instance = new ParticipantDOA();
            boolean expResult = false;
            boolean result = instance.addParticipant(p);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of update_participant method, of class ParticipantDOA.
     */
    @Test
    public void testUpdate_participant() {
        System.out.println("update_participant");
        Participant p = null;
        
        try{
            ParticipantDOA instance = new ParticipantDOA();
            boolean expResult = false;
            boolean result = instance.update_participant(p);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of delete_participant method, of class ParticipantDOA.
     */
    @Test
    public void testDelete_participant() {
        System.out.println("delete_participant");
        String id = "";
        
        try{
            ParticipantDOA instance = new ParticipantDOA();
            boolean expResult = false;
            boolean result = instance.delete_participant(id);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(EventDOATest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
