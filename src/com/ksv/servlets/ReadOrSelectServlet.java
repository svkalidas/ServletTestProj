package com.ksv.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadOrSelectServlet
 */
public class ReadOrSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadOrSelectServlet() {
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
		Statement stmt = null; 
		ResultSet rs = null;
		Connection conn = null;
		try{
			
			if(request.getParameter("Sr.No") != null && !request.getParameter("Sr.No").isEmpty()){
				conn = TableCreation.connection;
				if(conn != null){
					
					stmt = conn.createStatement();
					
					String sql = "SELECT * FROM PRODUCT_DETAILS WHERE Sr.No = "+request.getParameter("Sr.No");
					
					rs = stmt.executeQuery(sql);
					if(rs != null ){
						if(rs.getString("Status") == "New"){
							response.getWriter().write(rs.getString("product_name")+" "+rs.getDate("install_date"));
						}else if(rs.getString("Status") == "Old"){
							response.getWriter().write("Old "+rs.getInt("installed_component_id"));
						}
					}else{
						response.getWriter().write("No product Found");
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
