/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guiro.agenda.doa;

import com.guiro.donnees.Event;
import com.guiro.exception.ChampEventException;
import java.sql.Date;
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
public class EventDOA extends DOAContext{
    
    
    public EventDOA() throws Exception {
	super();
	// TODO Auto-generated constructor stub
    }

    public List<Event> getEvents(int id_own){
        
        String queryString = "SELECT * FROM events where id_own = ? order by startDate DESC, startTime ASC";
        List<Event> events = new ArrayList<>();
        PreparedStatement st ;
        ResultSet rs ;
        
        
        try {
            st = this.conn.prepareStatement(queryString);
            st.setInt(1, id_own);
            rs = st.executeQuery();
            
            while (rs.next())
            {
                Event e = new Event() ;
                e.fromResultSet(rs) ;
                events.add(e) ;
            }
            rs.close();
            st.close();
            this.setErrors("addEventSucces", "Ajouter....");

        } catch (SQLException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
            this.setErrors("addEventErro", "Add Event error");
        } catch (ChampEventException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return events ;
    }
    
    public Event getEventById(int id){
        String queryString = "SELECT * FROM events where id = "+id;
        List<Event> events = new ArrayList<>();
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
                Event e = new Event() ;
                e.fromResultSet(rs) ;
                events.add(e) ;
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
            this.setErrors("addEventErro", "Add Event error");
        } catch (ChampEventException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return events.get(0) ;
    }
    
    public List<Event> getEventsByName(String eventName){
        String queryString = "SELECT * FROM events where eventname = "+eventName;
        List<Event> events = new ArrayList<>();
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
                Event e = new Event() ;
                e.fromResultSet(rs) ;
                events.add(e) ;
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
            this.setErrors("addEventErro", "Add Event error");
        } catch (ChampEventException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return events ;
    }
    
    public boolean addEvent(Event ev){
        String queryString = "insert into events(eventName, startDate, endDate, startTime, endTime, location, category, priority, id_own) values (?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
        PreparedStatement st ;
        Date date1 = Date.valueOf(ev.getStartDate());
        Date date2 = Date.valueOf(ev.getEndDate());
        
        
        try {
           st = this.conn.prepareStatement(queryString);
           st.setString(1, ev.getEventName()) ;
           st.setDate(2, date1) ;
           st.setDate(3, date2);
           st.setString(4, ev.getStartTime());
           st.setString(5, ev.getEndTime());
           st.setString(6, ev.getLocation());
           st.setString(7, ev.getCategory());
           st.setInt(8, ev.getPriority());
           st.setInt(9, ev.getIdOwn()) ;
            
           st.executeUpdate();
            
           st.close();
           this.setErrors("addEventSucces", "Ajouter....");
            
           return true ;

        } catch (SQLException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
            this.setErrors("addEventErro", "Add Event error "+ex.getMessage());
        }
        
        
        return false;
    }
    
    public boolean update_event(Event ev){
        String queryString = "update events set eventName = ?, startDate = ?, endDate = ?, startTime=?, endTime=?, location=?, category=?, priority=?  where id = ?" ;
        PreparedStatement st ;
        Date date1 = Date.valueOf(ev.getStartDate());
        Date date2 = Date.valueOf(ev.getEndDate());
        
        
        try {
           st = this.conn.prepareStatement(queryString);
           st.setString(1, ev.getEventName()) ;
           st.setDate(2, date1) ;
           st.setDate(3, date2);
           st.setString(4, ev.getStartTime());
           st.setString(5, ev.getEndTime());
           st.setString(6, ev.getLocation());
           st.setString(7, ev.getCategory());
           st.setInt(8, ev.getPriority());
           st.setInt(9, ev.getId());   
           
           st.executeUpdate();
            
           st.close();
           this.setErrors("message", "Successfull Updated");
            
           return true ;

        } catch (SQLException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
            this.setErrors("addEventErro", "Add Event error");
        }
        
        
        return false;
    }
    
    public boolean delete_event(int id){
        String queryString = "delete from events where id=?" ;
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
            this.setErrors("addEventErro", "Add Event error");
        }
        
        
        return false;
    }
    
}
