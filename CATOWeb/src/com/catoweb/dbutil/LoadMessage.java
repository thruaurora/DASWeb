package com.catoweb.dbutil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadMessage
 */
public class LoadMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8" );
		PrintWriter out = response.getWriter();
		String mode="AltX";
		
		if(request.getParameter("mode")!=null){
			mode=request.getParameter("mode").trim();
		}
	     String message="";
	     DBManager db=DBManager.getInstance();
	       ArrayList<String> list=null;
	       if(mode.equalsIgnoreCase("AltX")){
	    	   list=db.getAltXList();
	       }
	       if(mode.equalsIgnoreCase("AltY")){
	    	   list=db.getAltYList(); 
	       }
	       if(mode.equalsIgnoreCase("AdvS")){
	    	   list=db.getAdvSList();
	       }
	       if(mode.equalsIgnoreCase("ActS")){
	    	   list=db.getActSList();
	       }
	       if(mode.equalsIgnoreCase("LMTS")){
	    	   list=db.getLmtSList();
	       }
	       if(mode.equalsIgnoreCase("COLOR")){
	    	   list=db.getColor();
	       }
	       if(mode.equalsIgnoreCase("Station")){
	    	   list=db.getStation();
	       }
	       for(int i=0;i<list.size();i++){
	    	   message=message+list.get(i)+",";
	       }
		out.print(message);
		out.flush();
		out.close();
	}

}
