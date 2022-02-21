/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guiro.agenda.doa;

import com.guiro.donnees.EventParticipant;
import com.guiro.exception.ChampEventException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guiro
 */
public class EventParticipantDOA extends DOAContext{
    
    public EventParticipantDOA() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<EventParticipant> getAll(int event){
        String queryString = "SELECT * FROM event_participants where id_event = "+event;
        List<EventParticipant> event_participants = new ArrayList<>();
        Statement st ;
        ResultSet rs ;
        
        
        try {
            // make sure autocommit is off
            this.conn.setAutoCommit(false);
            st = this.conn.createStatement();
            // Turn use of the cursor on.
            st.setFetchSize(50);
            rs = st.executeQuery(queryString);
            
            while (rs.next())
            {
                EventParticipant ep = new EventParticipant() ;
                ep.fromResultSet(rs) ;
                event_participants.add(ep) ;
            }
            rs.close();
            st.close();
            this.setErrors("all_participants", "Lecture....");

        } catch (SQLException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
            this.setErrors("all_participants", "Lecture all participants error");
        } catch (ChampEventException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return event_participants ;
    }
    
    public EventParticipant getById(int id){
        String queryString = "SELECT * FROM event_participants where id = " + id;
        List<EventParticipant> event_participants = new ArrayList<>();
        Statement st ;
        ResultSet rs ;
        
        
        try {
            // make sure autocommit is off
            this.conn.setAutoCommit(false);
            st = this.conn.createStatement();
            // Turn use of the cursor on.
            st.setFetchSize(50);
            rs = st.executeQuery(queryString);
            
            while (rs.next())
            {
                EventParticipant ep = new EventParticipant() ;
                ep.fromResultSet(rs) ;
                event_participants.add(ep) ;
            }
            rs.close();
            st.close();
            this.setErrors("participant_by_id", "Lecture....");

        } catch (SQLException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
            this.setErrors("get_by_id", "Lecture participant by id error");
        } catch (ChampEventException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return event_participants.get(0) ;
    }
    
//    public List<EventParticipant> getParticipantsByName(String name){
//        String queryString = "SELECT * FROM participants where firstname = ?  or lastname = ?";
//        List<Participant> participants = new ArrayList<>();
//        PreparedStatement st ;
//        ResultSet rs ;
//        
//        
//        try {
//           st = this.conn.prepareStatement(queryString);
//           st.setString(1, name) ;
//           st.setString(2, name) ;
//           
//           rs = st.executeQuery() ;
//            
//            while (rs.next())
//            {
//                Participant p = new Participant() ;
//                p.fromResultSet(rs) ;
//                participants.add(p) ;
//            }
//            rs.close();
//            st.close();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
//            this.setErrors("addEventErro", "Add Event error");
//        } catch (ChampEventException ex) {
//            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//        return participants ;
//    }
    
    public boolean add(EventParticipant ep){
        String queryString = "insert into event_participants(id_event, firstname, lastname, email) values (?, ?, ?, ?)" ;
        PreparedStatement st ;
        
        
        try {
           st = this.conn.prepareStatement(queryString);
           st.setInt(1, ep.getId_event()) ;
           st.setString(2, ep.getFirstname());
           st.setString(3, ep.getLastname());
           st.setString(4, ep.getEmail());

            
           st.executeUpdate();
            
           st.close();
           this.setErrors("addEventParticipantSucces", "Ajouter....");
            
           return true ;

        } catch (SQLException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
            this.setErrors("addEventParticipantErro", "Add Event Participant error");
        }
        
        
        return false;
    }
    
    public boolean update(EventParticipant ep){
        String queryString = "update event_participants set id_event = ?, firstname = ?, lastname = ?, email = ? where id = ?" ;
        PreparedStatement st ;
        
        
        try {
           st = this.conn.prepareStatement(queryString);
           st.setInt(1, ep.getId_event()) ;
           st.setString(2, ep.getFirstname());
           st.setString(3, ep.getLastname());
           st.setString(4, ep.getEmail());           
           st.setInt(5, ep.getId());
           
           st.executeUpdate();
            
           st.close();
           this.setErrors("message", "Successfull Updated");
            
           return true ;

        } catch (SQLException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
            this.setErrors("updateEventParticipantErro", "Update Event Participant error");
        }
        
        
        return false;
    }
    
    public boolean delete(int id){
        String queryString = "delete from event_participants where id=?" ;
        PreparedStatement st ;
        
        
        try {
           st = this.conn.prepareStatement(queryString);
           st.setInt(1, id) ;
            
           st.executeUpdate();
            
           st.close();
           this.setErrors("msg", "Succes Delete....");
            
           return true ;

        } catch (SQLException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
            this.setErrors("deleteEventParticipantErro", "Delete Participant error");
        }
        
        
        return false;
    }

}
