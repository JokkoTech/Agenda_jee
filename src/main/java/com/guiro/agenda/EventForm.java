/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.guiro.agenda;

import com.guiro.agenda.doa.EventDOA;
import com.guiro.donnees.Event;
import com.guiro.validator.EventFormValidator;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guiro
 */
@WebServlet(name = "EventForm", urlPatterns = {"/addevent"})
public class EventForm extends HttpServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String VUE_FORM = "event/eventForm.jsp" ;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
        
        request.getRequestDispatcher(VUE_FORM).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("user_id") != null){
            String idString = request.getParameter("id") ;
            
            if(idString != null){
                int id = Integer.parseInt(idString) ;
                
                EventDOA eventDOA;
            
		try {
                    eventDOA = new EventDOA();
                    Event ev = eventDOA.getEventById(id) ;
	            
	            request.setAttribute("e", ev);
	            
		} catch (Exception e) {
				// TODO Auto-generated catch block
                    e.printStackTrace();
		}            
            }
        
            processRequest(request, response);
            
        }else{
            request.setAttribute("error", "Identifiez vous d'abord pour acceder aux pages.");
            getServletContext().getNamedDispatcher("Login").forward(request, response);
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getSession().getAttribute("user_id") != null){
         
            EventFormValidator form = new EventFormValidator(request);
            boolean rs ;
        
            Event ev = form.getEvent() ;
            EventDOA eventDOA;
            try {
		eventDOA = new EventDOA();
			
		if(ev.getId() == 0){
	            rs = eventDOA.addEvent(ev) ;
	        }else {
	            rs = eventDOA.update_event(ev) ;
	        }
			
	        if(rs){
	            RequestDispatcher dispatcher = getServletContext().getNamedDispatcher("EventList");
	            dispatcher.forward(request, response) ;
	        }
	        else{
	            request.setAttribute("errorConn", eventDOA.getErrors());
	            request.setAttribute("form", form);
	            request.setAttribute("e", ev);


	            processRequest(request, response);
	        }
	        
            } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }
        }else{
            request.setAttribute("error", "Identifiez vous d'abord pour acceder aux pages.");
            getServletContext().getNamedDispatcher("Login").forward(request, response);
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
