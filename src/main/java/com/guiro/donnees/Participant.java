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
public class Participant {
    private final String PARAM_ID = "id" ;
    private final String PARAM_CODE = "code" ;
    private final String PARAM_FIRSTNAME = "firstname" ;
    private final String PARAM_LASTNAME = "lastname" ;
    private final String PARAM_EMAIL = "email" ;
    private final String PARAM_PASSWORD = "password" ;
//    private final String PARAM_LOCATION = "location" ;
//    private final String PARAM_CATEGORY = "category" ;
//    private final String PARAM_PRIORITY = "priority" ;
    
    private int id ;
    private String code ;
    private String firstname ;
    private String lastname ;
    private String email ;
    private String password ;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
    public Participant fromResultSet(ResultSet rs) throws SQLException, ChampEventException{
        int _id = rs.getInt(PARAM_ID) ;
        
        String first = rs.getString(PARAM_FIRSTNAME) ;
        String last = rs.getString(PARAM_LASTNAME) ;
        String _code = rs.getString(PARAM_CODE) ;
        String _email = rs.getString(PARAM_EMAIL) ;
        String _pass = rs.getString(PARAM_PASSWORD) ;
                
        this.setId(_id);
        this.setFirstname(first);
        this.setLastname(last);
        this.setCode(_code);
        this.setEmail(_email);
        this.setPassword(_pass);
                
        return this ;
    }
    
    public Participant fromRequest(HttpServletRequest request){
        String idString = request.getParameter(PARAM_ID) ;
        
        if(idString.isEmpty()){
            setId(0) ;
        }
        else{
            setId(Integer.parseInt(idString)) ;
        }
        setCode(request.getParameter(PARAM_CODE));
        setFirstname(request.getParameter(PARAM_FIRSTNAME)) ;
        setLastname(request.getParameter(PARAM_LASTNAME)) ;
        setEmail(request.getParameter(PARAM_EMAIL)) ;
        setPassword(request.getParameter(PARAM_PASSWORD)) ;

        return this;
    }
}
