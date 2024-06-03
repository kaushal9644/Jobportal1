package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.JobDAO;

@WebServlet("/delete")
public class DeleteJobServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			
			 // Create a JobDAO instance and add the job to the database
            JobDAO dao = new JobDAO(DBConnect.getConn());
            boolean isJobAdded = dao.deleteJobs(id);
            HttpSession session = request.getSession();

            // Set a success or failure message in the session
            if (isJobAdded) {
                session.setAttribute("succMsg", "Job Deleted successfully.");
            } else {
                session.setAttribute("succMsg", "Something went wrong on the server.");
            }

            // Redirect to the add_jobs.jsp page
            response.sendRedirect("view_jobs.jsp");

        } catch (Exception e) {
            // Log the exception and redirect with an error message
            e.printStackTrace();
            HttpSession session = request.getSession();
            session.setAttribute("succMsg", "An error occurred while posting the job.");
            response.sendRedirect("view_jobs.jsp");
        }
	}
	
	

}
