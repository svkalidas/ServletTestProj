package com.ksv.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			
			if(request.getParameter("Sr.No") != null && !request.getParameter("Sr.No").isEmpty() &&
					request.getParameter("installed_component_id") != null && !request.getParameter("installed_component_id").isEmpty()	){
				Connection conn = TableCreation.connection;
				if(conn != null){
					
					Statement stmt = conn.createStatement();
					
					String sql = "SELECT * FROM PRODUCT_DETAILS WHERE Sr.No = "+request.getParameter("Sr.No");
					
					ResultSet rs = stmt.executeQuery(sql);
					if(rs != null ){
						rs.updateInt("installed_component_id", Integer.parseInt(request.getParameter("installed_component_id")));
					}else{
						response.getWriter().write("No product Found");
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
