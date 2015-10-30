package com.first.in;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class FirstServletServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response){  
        try{  
  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        String n=request.getParameter("userName");  
        out.print("Welcome "+n);  
          
        HttpSession session=request.getSession();  
        session.setAttribute("uname",n);  
  
        out.print("<a href='servlet2'>visit</a>");  
                  
        out.close();  
  
                }catch(Exception e){System.out.println(e);}  
    }  
  
}  