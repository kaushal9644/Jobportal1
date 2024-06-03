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

@WebServlet("/login")
public class LoginServlet extends HttpServlet{



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			User u=new User();
			HttpSession session=request.getSession();
			
			if("admin@gmail.com".equalsIgnoreCase(email) && "admin@123".equalsIgnoreCase(password)) {
				session.setAttribute("userobj", u);
				
				/* System.out.println("email :-"+email+"Password "+password); */
				u.setRole("admin");
				System.out.println();
				response.sendRedirect("admin.jsp");
				
			}
			
			UserDAO dao=new UserDAO(DBConnect.getConn());
			User user=dao.login(email, password);
			HttpSession seesion=request.getSession();
			
			/* System.out.println("email :-"+email +"Password "+password); */
			
			if(user !=null) {
				seesion.setAttribute("userobj",user);
				response.sendRedirect("home.jsp");
			}else {
				seesion.setAttribute("succMsg","Invalid Username and Password");
				response.sendRedirect("login.jsp");
			}
			
			
			
				}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}
