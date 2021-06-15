package com.ksv.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TableCreation
 */
public class TableCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static Connection connection = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TableCreation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			connection =DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/myDB","root","root");  
			if(connection != null){
				Statement stmt;
					stmt = connection.createStatement();
					String sql = "CREATE TABLE PRODUCT_DETAILS " +
							"(Sr.No INTEGER not NULL, " +
							" product_name VARCHAR(255), " + 
							" install_date DATETIME, " + 
							" status VARCHAR(100), " + 
							" installed_component_id INTEGER"+
							" PRIMARY KEY ( id ))"; 
					
					stmt.executeUpdate(sql);
			} 
			}catch(Exception e){ 
				System.out.println(e);
			}  
	}

}
