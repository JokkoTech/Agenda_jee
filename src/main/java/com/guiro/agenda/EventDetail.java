/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.guiro.agenda;

import com.guiro.agenda.doa.EventDOA;
import com.guiro.agenda.doa.EventParticipantDOA;
import com.guiro.donnees.Event;
import com.guiro.donnees.EventParticipant;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guiro
 */
@WebServlet(name = "EventDetail", urlPatterns = {"/eventdetail"})
public class EventDetail extends HttpServlet {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private final String VUE_DETAIL = "event/eventDetail.jsp" ;
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
        
        String idString = request.getParameter("id") ;
        
        if(idString != null){
            int id = Integer.parseInt(idString) ;
            
            EventDOA eventDOA;
			try {
				eventDOA = new EventDOA();
				

	            Event ev = eventDOA.getEventById(id) ;
	            
	            EventParticipantDOA epDOA = new EventParticipantDOA() ;
	            
	            List<EventParticipant> event_participants = epDOA.getAll(id);
	            ev.setParticipants(event_participants);
	            
//	            List<Integer> list_id = new ArrayList<>() ;
	            
//	            List<Participant> participants = new ArrayList<>();
//	            
//	            ParticipantDOA participantDOA = new ParticipantDOA() ;
//	            
//	            for(EventParticipant ep: event_participants){
////	                list_id.add(ep.getId_participant());
//	                participants.add(participantDOA.getParticipantById(ep.getId_participant())) ;
//	            }
//	            ev.setParticipants(participants) ;

	            
	            request.setAttribute("e", ev);
	            
	       
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
        request.getRequestDispatcher(VUE_DETAIL).forward(request, response); ;
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
            String idString = request.getParameter("id") ;
        
            if(idString != null){
                int id = Integer.parseInt(idString) ;

                EventParticipantDOA epDOA;
			try {
				epDOA = new EventParticipantDOA();
				
				EventParticipant ep = new EventParticipant();
	            
	            ep.fromRequest(request) ;
	            
	            epDOA.add(ep) ;
	            
	            request.setAttribute("p", ep);
	            
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
