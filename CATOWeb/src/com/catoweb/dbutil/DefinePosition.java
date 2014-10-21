package com.catoweb.dbutil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DefinePosition
 */
public class DefinePosition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DefinePosition() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8" );
		PrintWriter out = response.getWriter();
		DBManager db=DBManager.getInstance();
		float InitSpeed=Float.valueOf((String)request.getParameter("InitSpeed")).floatValue();
		float Acce1=Float.valueOf((String)request.getParameter("Acce1")).floatValue();
		float Acce2=Float.valueOf((String)request.getParameter("Acce2")).floatValue();
		float Acce3=Float.valueOf((String)request.getParameter("Acce3")).floatValue();
		float Acce4=Float.valueOf((String)request.getParameter("Acce4")).floatValue();
		float Acce5=Float.valueOf((String)request.getParameter("Acce5")).floatValue();
		float Acce6=Float.valueOf((String)request.getParameter("Acce6")).floatValue();
		float Acce7=Float.valueOf((String)request.getParameter("Acce7")).floatValue();
		float Acce8=Float.valueOf((String)request.getParameter("Acce8")).floatValue();
		float Acce9=Float.valueOf((String)request.getParameter("Acce9")).floatValue();
		float Acce10=Float.valueOf((String)request.getParameter("Acce10")).floatValue();
		float Acce11=Float.valueOf((String)request.getParameter("Acce11")).floatValue();
		float Acce12=Float.valueOf((String)request.getParameter("Acce12")).floatValue();
		float offset=Float.valueOf((String)request.getParameter("offset")).floatValue();
		db.clearPosition();
		db.genPosition(InitSpeed, Acce1, Acce2, Acce3, Acce4, Acce5, Acce6, Acce7, Acce8, Acce9, Acce10, Acce11, Acce12, offset);
		out.println(String.valueOf(InitSpeed));
	}

}
