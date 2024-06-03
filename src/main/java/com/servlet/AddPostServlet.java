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
import com.entity.Jobs;

public class AddPostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve form data
            String title = request.getParameter("title");
            String location = request.getParameter("location");
            String category = request.getParameter("category");
            String status = request.getParameter("status");
            String description = request.getParameter("description");
           
         

            // Create a new Jobs object and set its properties
            Jobs job = new Jobs();
            job.setTitle(title);
            job.setLocation(location);
            job.setCategory(category);
            job.setDescription(description);
            job.setStatus(status);
        
			/*
			 * System.out.println("title "+title+"location "+location+"category"+category+
			 * "status"+status+ "description" +description);
			 */            // Get the current HTTP session
            HttpSession session = request.getSession();

            // Create a JobDAO instance and add the job to the database
            JobDAO jobDAO = new JobDAO(DBConnect.getConn());
            boolean isJobAdded = jobDAO.addJobs(job);

            // Set a success or failure message in the session
            if (isJobAdded) {
                session.setAttribute("succMsg", "Job posted successfully.");
            } else {
                session.setAttribute("succMsg", "Something went wrong on the server.");
            }

            // Redirect to the add_jobs.jsp page
            response.sendRedirect("add_jobs.jsp");

        } catch (Exception e) {
            // Log the exception and redirect with an error message
            e.printStackTrace();
            HttpSession session = request.getSession();
            session.setAttribute("succMsg", "An error occurred while posting the job.");
            response.sendRedirect("add_jobs.jsp");
        }
    }
}
