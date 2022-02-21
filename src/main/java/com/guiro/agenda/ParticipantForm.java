/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.guiro.agenda;

import com.guiro.agenda.doa.ParticipantDOA;
import com.guiro.donnees.Participant;
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
@WebServlet(name = "ParticipantForm", urlPatterns = {"/participantform"})
public class ParticipantForm extends HttpServlet {
    /**
     * 
    */
    private static final long serialVersionUID = 1L;
	
    final String VUE_FORM = "participant/participantForm.jsp" ;

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
         
            String id = request.getParameter("id") ;
            if(id != null){
                ParticipantDOA participantDOA;
            
                try {
                    participantDOA = new ParticipantDOA();
                    Participant p = participantDOA.getParticipantById(Integer.parseInt(id)) ;

                    request.setAttribute("p", p);
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
        
            Participant p = new Participant();
            boolean rs ;
            ParticipantDOA participantDOA;
            try {
		participantDOA = new ParticipantDOA();
		p.fromRequest(request);
	        
	        if(p.getId() == 0){
	            rs = participantDOA.addParticipant(p) ;
	        }else {
	            rs = participantDOA.update_participant(p) ;
	        }
	        
	        if(rs){
	            RequestDispatcher dispatcher = getServletContext().getNamedDispatcher("EventList");
	            dispatcher.forward(request, response) ;
	        }
	        else{
	            request.setAttribute("errorConn", participantDOA.getErrors());
	            request.setAttribute("p", p);

                    processRequest(request, response);
	        }
	        
            } catch (Exception e) {
                // TODO Auto-generated catch block
		e.printStackTrace();
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
