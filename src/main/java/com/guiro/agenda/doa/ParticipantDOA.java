/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guiro.agenda.doa;

import com.guiro.donnees.Participant;
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
public class ParticipantDOA extends DOAContext{
	
    public ParticipantDOA() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Participant> getParticipants(){
        String queryString = "SELECT * FROM participants";
        List<Participant> participants = new ArrayList<>();
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
                Participant p = new Participant() ;
                p.fromResultSet(rs) ;
                participants.add(p) ;
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
        
        
        return participants ;
    }
    
    public Participant getParticipantById(int id){
        String queryString = "SELECT * FROM participants where id = " + id;
        List<Participant> participants = new ArrayList<>();
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
                Participant e = new Participant() ;
                e.fromResultSet(rs) ;
                participants.add(e) ;
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
            this.setErrors("get participant by id", "Lecture by id error...");
        } catch (ChampEventException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return participants.get(0) ;
    }
    
    public List<Participant> getParticipantsByName(String name){
        String queryString = "SELECT * FROM participants where firstname = ?  or lastname = ?";
        List<Participant> participants = new ArrayList<>();
        PreparedStatement st ;
        ResultSet rs ;
        
        
        try {
            
           st = this.conn.prepareStatement(queryString);
           st.setString(1, name) ;
           st.setString(2, name) ;
           
           rs = st.executeQuery() ;
            
            while (rs.next())
            {
                Participant p = new Participant() ;
                p.fromResultSet(rs) ;
                participants.add(p) ;
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
            this.setErrors("addEventErro", "Add Event error");
        } catch (ChampEventException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return participants ;
    }
    
    public boolean addParticipant(Participant p){
        String queryString = "insert into participants(firstname, lastname, email, password, code) values (?, ?, ?, ?, ?)" ;
        PreparedStatement st ;
        
        
        try {
           st = this.conn.prepareStatement(queryString);
           st.setString(1, p.getFirstname()) ;
           st.setString(2, p.getLastname());
           st.setString(3, p.getEmail());
           st.setString(4, p.getPassword());
           st.setString(5, p.getCode());

            
           st.executeUpdate();
            
           st.close();
           this.setErrors("addParticipantSucces", "Ajouter....");
            
           return true ;

        } catch (SQLException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
            this.setErrors("addParticipantErro", "Add Participant error");
        }
        
        
        return false;
    }
    
    public boolean update_participant(Participant p){
        String queryString = "update participants set firstname = ?, lastname = ?, code = ?, email = ?, password = ?  where id = ?" ;
        PreparedStatement st ;
        
        
        try {
           st = this.conn.prepareStatement(queryString);
           st.setString(1, p.getFirstname()) ;
           st.setString(2, p.getLastname());
           st.setString(3, p.getCode());
           st.setString(4, p.getEmail());
           st.setString(5, p.getPassword()) ;
           st.setInt(6, p.getId());
            
           st.executeUpdate();
            
           st.close();
           this.setErrors("message", "Successfull Updated");
            
           return true ;

        } catch (SQLException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
            this.setErrors("updateParticipantErro", "Update Participant error");
        }
        
        
        return false;
    }
    
    public boolean delete_participant(String id){
        String queryString = "delete from participants where id=?" ;
        PreparedStatement st ;
        
        
        try {
           st = this.conn.prepareStatement(queryString);
           st.setString(1, id) ;
            
           st.executeUpdate();
            
           st.close();
           this.setErrors("msg", "Succes Delete....");
            
           return true ;

        } catch (SQLException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
            this.setErrors("deleteParticipantErro", "Delete Participant error");
        }
        
        
        return false;
    }
    
     public int login(String email, String password){
        String queryString = "SELECT * FROM participants where email = ? and password = ? " ;
        Participant p = new Participant();
        int id = -1;
        PreparedStatement st ;
        ResultSet rs ;
        
        
        try {
            st = this.conn.prepareStatement(queryString);
            st.setString(1, email) ;
            st.setString(2, password) ;
            
            rs = st.executeQuery() ;
            
            if(rs.next())
            {
                p.fromResultSet(rs) ;
                id = p.getId() ;
               
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
            this.setErrors("get participant by id", "Lecture by id error...");
        } catch (ChampEventException ex) {
            Logger.getLogger(EventDOA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id ;
    }
}
