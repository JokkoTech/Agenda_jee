/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guiro.donnees;

/**
 *
 * @author Guiro
 */


import com.guiro.exception.ChampEventException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Event {
    private final String PARAM_ID = "id" ;
    private final String PARAM_ID_OWN = "id_own" ;
    private final String PARAM_NAME = "eventName" ;
    private final String PARAM_START_DATE = "startDate" ;
    private final String PARAM_END_DATE = "endDate" ;
    private final String PARAM_START_TIME = "startTime" ;
    private final String PARAM_END_TIME = "endTime" ;
    private final String PARAM_LOCATION = "location" ;
    private final String PARAM_CATEGORY = "category" ;
    private final String PARAM_PRIORITY = "priority" ;
    
//    SimpleDateFormat format ; // Pour extraire l'heure
    int id ;
    int idOwn ;
    String eventName;
    String startDate ;
    String endDate ;
    String startTime ;
    String endTime ;
    String location;
    String category;
    int priority ;
    List<EventParticipant> participants ;   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOwn() {
        return idOwn;
    }

    public void setIdOwn(int idOwn) {
        this.idOwn = idOwn;
    }
    
    
    
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String name) throws ChampEventException{
        if(name==null || name.trim().length() < 2) {
            throw new ChampEventException();
        }
        this.eventName = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate)  throws ChampEventException{
        if(startDate==null || startDate.trim().length() < 2) {
            throw new ChampEventException();
        }
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate)  throws ChampEventException{
        if(endDate==null || endDate.trim().length() < 2) {
            throw new ChampEventException();
        }
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime)  throws ChampEventException{
        if(startTime==null || startTime.trim().length() < 2) {
            throw new ChampEventException();
        }
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime)  throws ChampEventException{
        if(endTime==null || endTime.trim().length() < 2) {
            throw new ChampEventException();
        }
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location)  throws ChampEventException{
        if(location==null || location.trim().length() < 2) {
            throw new ChampEventException();
        }
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category)  throws ChampEventException{
        if(category==null || category.trim().length() < 2) {
            throw new ChampEventException();
        }
        this.category = category;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority)  throws ChampEventException{
        if(priority < 0) {
            throw new ChampEventException();
        }
        this.priority = priority;
    }

    public List<EventParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<EventParticipant> participants) {
        this.participants = participants;
    }
    
    public Event fromResultSet(ResultSet rs) throws SQLException, ChampEventException{
        int _id = rs.getInt(PARAM_ID) ;
        int _idOwn = rs.getInt(PARAM_ID_OWN) ;
        String event_name = rs.getString(PARAM_NAME) ;
        String start_date = rs.getString(PARAM_START_DATE) ;
        String end_date = rs.getString(PARAM_END_DATE) ;
        String start_time = rs.getString(PARAM_START_TIME) ;
        String end_time = rs.getString(PARAM_END_TIME) ;
        String loc = rs.getString(PARAM_LOCATION) ;
        int prio = rs.getInt(PARAM_PRIORITY) ;
        String cat = rs.getString(PARAM_CATEGORY) ;
                
        this.setId(_id);
        this.setIdOwn(_idOwn);
        this.setEventName(event_name);
        this.setStartDate(start_date);
        this.setEndDate(end_date);
        this.setStartTime(start_time);
        this.setEndTime(end_time);
        this.setLocation(loc);
        this.setPriority(prio);
        this.setCategory(cat);
                
        return this ;
    }
}
