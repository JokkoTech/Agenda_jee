/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.guiro.agenda;

import com.guiro.agenda.doa.ParticipantDOA;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Guiro
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String VUE_FORM = "index.jsp";

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
        processRequest(request, response);
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
        
        String email = request.getParameter("email") ;
        String password = request.getParameter("password") ;
        
        ParticipantDOA pDoa;
        try {
            pDoa = new ParticipantDOA();
            int id = pDoa.login(email, password) ;
	        
	    if(id != -1){
	        HttpSession session = request.getSession() ;
	        session.setAttribute("user_id", id);
	        getServletContext().getNamedDispatcher("EventList").forward(request, response);
	    }
	    else{
	        request.setAttribute("error", "Email or password incorrect...");
                request.setAttribute("email", email);
	        processRequest(request, response);
	    }
	        
	} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
