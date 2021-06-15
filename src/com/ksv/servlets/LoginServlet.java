package com.ksv.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public LoginServlet() {
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	System.out.println("inside init(ServletConfig) /n");
    }
    @Override
    public void init() throws ServletException {
    	super.init();
    	System.out.println("inside init() /n");
    }
    
    
    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
    	super.service(arg0, arg1);
    	System.out.println("inside service method");
    	if("GET".equalsIgnoreCase(arg0.getMethod())){
    		System.out.println("inside GET");
    	}
    	if("POST".equalsIgnoreCase(arg0.getMethod())){
    		System.out.println("inside post");
    	}
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("Inside doget methode");
		//out.print("haii inside doGet()");
		//out.write("hello writter ");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		out.println("<html>");
		out.println("<body>");
		out.println("<form method='get' action='LoginServlet'>");
		out.println("<table>");
		out.println("<tr><td>UserName :</td><td><input type='text' name='username'/></td></tr>");
		out.println("<tr><td>Password :</td><td><input type='password' name='password'/></td></tr>");
		out.println("<tr><td colspan='2'><input type='submit' value='Submit'></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside dopost methode");
		doGet(request, response);
	}

}
