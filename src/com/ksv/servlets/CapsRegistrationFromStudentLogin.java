 package com.ksv.servlets;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CapsRegistrationFromStudentLogin
 */
@WebServlet("/CapsRegistrationFromStudentLogin")
public class CapsRegistrationFromStudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapsRegistrationFromStudentLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			
			HttpSession session = request.getSession(false);
			if(session != null){
				session.invalidate();
			}else{
				session = request.getSession();
			}
			session.setAttribute("register_number", request.getParameter("REGISTER_NUMBER"));
			
			session.setAttribute("name", request.getParameter("STUDENT_NAME"));
			
			session.setAttribute("phone", request.getParameter("CONTACT_NUMBER"));
			
			session.setAttribute("email", request.getParameter("EMAIL_ID"));
			
			session.setAttribute("course",  request.getParameter("CLASS_NAME"));
			
			session.setAttribute("yos",  request.getParameter("TERM"));
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("./volunteer_registration.jsp");
			dispatcher.forward(request, response);
		}catch(Exception e){
			
		}

	}

}
