package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 try {
				
		    	String name=request.getParameter("name");
		    	
		    	String email=request.getParameter("email");
		    	String password=request.getParameter("password");
		    	String qualification=request.getParameter("qualification");
		    	
		    //	System.out.println("name "+name+"email -"+email+"password -"+password+"qualification"+qualification);
		    	
		    	UserDAO dao=new UserDAO(DBConnect.getConn());
		    	
		    	User u=new User(name,email,password,qualification,"User");
		    	boolean f=dao.addUser(u);
		    	
		    	
		    
		    	
		    	
		    	HttpSession session=request.getSession();
		    	if(f) {
		    		session.setAttribute("succMsg", "Registration Succesfull");
		    		response.sendRedirect("signup.jsp");
		    	}else {
		    		session.setAttribute("succMsg", "Something wrong on server");
		    		response.sendRedirect("signup.jsp");
		    	}
		    	
		    	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		
	}
	