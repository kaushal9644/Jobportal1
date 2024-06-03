<%@page import="com.entity.Jobs"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.JobDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Jobs</title>
    <%@include file="all_components/all_css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
<c:if test="${userobj.role ne 'admin' }">
		<c:redirect url="login.jsp">
		</c:redirect>
	</c:if>    <%@include file="all_components/navbar.jsp"%>
    <div class="container p-2">
        <div class="col-md-10 offset-md-1">
            <div class="card">
                <div class="card-body">
                    <div class="text-center text-success">
                        <i class="fas fa-user-friends fa-3x"></i>
                        <%
                            int id = Integer.parseInt(request.getParameter("id"));
                            JobDAO dao = new JobDAO(DBConnect.getConn());
                            Jobs j = dao.getJobsById(id);
                        %>
                        <h5>Edit Job</h5>
                    </div>
                    <form action="update" method="post">
                        <input type="hidden" value="<%= j.getId() %>" name="id">
                        <div class="form-group">
                            <label for="title">Enter Title</label>
                            <input type="text" id="title" name="title" required class="form-control" value="<%= j.getTitle() %>">
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="location">Location</label>
                                <select name="location" class="custom-select" id="location">
                                    <option value="<%= j.getLocation() %>"><%= j.getLocation() %></option>
                                    <option value="Bangalore">Bangalore</option>
                                    <option value="Hyderabad">Hyderabad</option>
                                    <option value="Chennai">Chennai</option>
                                    <option value="Pune">Pune</option>
                                    <option value="Ahmedabad">Ahmedabad</option>
                                    <option value="Nagpur">Nagpur</option>
                                    <option value="Indore">Indore</option>
                                    <option value="Surat">Surat</option>
                                    <option value="Mumbai">Mumbai</option>
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="category">Category</label>
                                <select class="custom-select" id="category" name="category">
                                    <option value="<%= j.getCategory() %>"><%= j.getCategory() %></option>
                                    <option value="IT">IT</option>
                                    <option value="Developer">Developer</option>
                                    <option value="Banking">Banking</option>
                                    <option value="Engineer">Engineer</option>
                                    <option value="Teacher">Teacher</option>
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="status">Status</label>
                                <select class="form-control" id="status" name="status">
                                    <option value="<%= j.getStatus() %>"><%= j.getStatus() %></option>
                                    <option value="Active">Active</option>
                                    <option value="Inactive">Inactive</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description">Enter Description</label>
                            <textarea id="description" name="description" required rows="6" class="form-control"><%= j.getDescription() %></textarea>
                        </div>
                        <button type="submit" class="btn btn-success">Update Job</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
