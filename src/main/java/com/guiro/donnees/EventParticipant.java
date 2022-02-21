/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guiro.donnees;

import com.guiro.exception.ChampEventException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Guiro
 */
public class EventParticipant {
    private final String PARAM_ID = "id" ;
    private final String PARAM_ID_EVENT = "id_event" ;
    private final String PARAM_FIRSTNAME = "firstname" ;
    private final String PARAM_LASTNAME = "lastname" ;
    private final String PARAM_EMAIL = "email" ;
    
    private int id ;
    private int id_event ;
    private String firstname ;
    private String lastname ;
    private String email ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EventParticipant fromResultSet(ResultSet rs) throws SQLException, ChampEventException{
        int _id = rs.getInt(PARAM_ID) ;
        int _event = rs.getInt(PARAM_ID_EVENT) ;
        String _firstname = rs.getString(PARAM_FIRSTNAME) ;
        String _lastname = rs.getString(PARAM_LASTNAME) ;
        String _email = rs.getString(PARAM_EMAIL) ;
                
        this.setId(_id);
        this.setId_event(_event);
        this.setFirstname(_firstname);
        this.setLastname(_lastname);
        this.setEmail(_email);
                
        return this ;
    }
    
    public EventParticipant fromRequest(HttpServletRequest request){
        String idString = request.getParameter(PARAM_ID) ;
        
        if(idString.isEmpty()){
            setId(0) ;
        }
        else{
            setId(Integer.parseInt(idString)) ;
        }
        
        this.setId_event(Integer.parseInt(request.getParameter(PARAM_ID_EVENT)));
        this.setFirstname(request.getParameter(PARAM_FIRSTNAME));
        this.setLastname(request.getParameter(PARAM_LASTNAME));
        this.setEmail(request.getParameter(PARAM_EMAIL));
        
        return this;
    }
}
