/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guiro.agenda.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guiro
 */
public class DOAContext {
    protected String url = "jdbc:postgresql://localhost:5432/agenda";
    protected String user = "postgres";
    protected String password = "rootroot";
    protected String driver ;
    protected Connection conn ;
    
    private Map<String, String> errors = new HashMap<>(); ;

    public DOAContext() throws Exception {
        this.init();
    }

 
    public void init() throws Exception {
        Properties props = new Properties();
        
        props.setProperty("user", user);
        props.setProperty("password", password);
        try {
            Class.forName("org.postgresql.Driver");
//            DriverManager.registerDriver(new org.postgres.Driver());
            this.conn = DriverManager.getConnection(url, props);
            System.out.print("Connected....");
            errors.put("connectionSucces", "connected...") ;
        } catch (SQLException ex) {
            Logger.getLogger(DOAContext.class.getName()).log(Level.SEVERE, null, ex);
            errors.put("connectionError", "Not connected "+ ex.getMessage()) ;
        }
        catch(ClassNotFoundException ex){
            errors.put("classNotFoundError", "Class org.postgresql.Driver not found...") ;
        }
    }
    
    
    public Map<String, String> getErrors() {
        return this.errors;
    }

    public void setErrors(String key, String msg) {
        this.errors.put(key, msg);
    }
    
}
