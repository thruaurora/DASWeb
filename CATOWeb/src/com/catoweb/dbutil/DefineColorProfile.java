package com.catoweb.dbutil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DefineColorProfile
 */
public class DefineColorProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DefineColorProfile() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8" );
		PrintWriter out = response.getWriter();
		DBManager db=DBManager.getInstance();
		String colorprofile=(String)request.getParameter("colorprofile");
		db.setColorProfile(colorprofile);
		out.println(colorprofile);
	}
}
