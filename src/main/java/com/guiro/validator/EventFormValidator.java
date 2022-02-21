/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guiro.validator;

import com.guiro.donnees.Event;
import com.guiro.exception.ChampEventException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Guiro
 */
public class EventFormValidator {
    /*Parametres de la requete */
    private final String PARAM_ID = "id" ;
    private final String PARAM_NAME = "eventName" ;
    private final String PARAM_START_DATE = "startDate" ;
    private final String PARAM_END_DATE = "endDate" ;
    private final String PARAM_START_TIME = "startTime" ;
    private final String PARAM_END_TIME = "endTime" ;
    private final String PARAM_LOCATION = "location" ;
    private final String PARAM_CATEGORY = "category" ;
    private final String PARAM_PRIORITY = "priority" ;
//    private final String PARAM_PARTICIPANTS = "participants" ;
    /* Messages de l'application */
    private final String MSG_SUCCESS = "Evenement ajoutei avec succes." ;
    
    /* Messages d'erreurs */
    
    private Event event = new Event();
    private Map<String, String> errors = new HashMap<>();
    private String msgSucces = ""; 

    public EventFormValidator(HttpServletRequest request) {
        
        int id = 0 ;
        
        String idString = request.getParameter(PARAM_ID) ;
        if( !idString.isEmpty() ){
            id = Integer.parseInt(idString) ;
        }
            
        event.setId(id);
        event.setIdOwn(Integer.parseInt(request.getSession().getAttribute("user_id").toString()));
        
        try {
            event.setEventName(request.getParameter(PARAM_NAME));
        } catch (ChampEventException ex) {
            errors.put(PARAM_NAME, "le nom doit contenir au moins deux caracteres.");
        }
        try {
            event.setStartDate(request.getParameter(PARAM_START_DATE));
        } catch (ChampEventException ex) {
            errors.put(PARAM_START_DATE, "La date du debut de l'evenement ne doit pas etre vide.");
        }
        try {
            event.setEndDate(request.getParameter(PARAM_END_DATE));
        } catch (ChampEventException ex) {
            errors.put(PARAM_END_DATE, "le nom doit contenir au moins deux caracteres.");
        }
        try {
            event.setStartTime(request.getParameter(PARAM_START_TIME));
        } catch (ChampEventException ex) {
            errors.put(PARAM_START_TIME, "le nom doit contenir au moins deux caracteres.");
        }
        try {
            event.setEndTime(request.getParameter(PARAM_END_TIME));
        } catch (ChampEventException ex) {
            errors.put(PARAM_END_TIME, "le nom doit contenir au moins deux caracteres.");
        }
        try {
            event.setLocation(request.getParameter(PARAM_LOCATION));
        } catch (ChampEventException ex) {
            errors.put(PARAM_LOCATION, "le nom doit contenir au moins deux caracteres.");
        }
        try {
            event.setCategory(request.getParameter(PARAM_CATEGORY));
        } catch (ChampEventException ex) {
            errors.put(PARAM_CATEGORY, "le nom doit contenir au moins deux caracteres.");
        }
        try {
            event.setPriority(Integer.parseInt(request.getParameter(PARAM_PRIORITY)));
        } catch (ChampEventException ex) {
            errors.put(PARAM_PRIORITY, "le nom doit contenir au moins deux caracteres.");
        }
        
        if(errors.isEmpty())
            msgSucces = MSG_SUCCESS ;
    }

    public Event getEvent() {
        return event;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public String getMsgSucces() {
        return msgSucces;
    }
    
}
