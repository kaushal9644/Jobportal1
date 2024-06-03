<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Admin : Add Jobs</title>
    <%@include file="all_components/all_css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
   <!-- Check if the user is not an admin, then redirect to login page -->
   <c:if test="${userobj.role ne 'admin' }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
   
   <!-- Include the navigation bar -->
   <%@include file="all_components/navbar.jsp"%>

    <div class="container p-2">
        <div class="col-md-10 offset-md-1">
            <div class="card">
                <div class="card-body">
                    <div class="text-center text-success">
                        <i class="fas fa-user-friends fa-3x"></i>

                        <!-- Display success message if present -->
                        <c:if test="${not empty succMsg}">
                            <div class="alert alert-success" role="alert">${succMsg}</div>
                            <c:remove var="succMsg"/>
                        </c:if> 

                        <h5>Add Jobs</h5>
                    </div>

                    <!-- Form for adding a job -->
                    <form action="AddPostServlet" method="post">
                        <div class="form-group">
                            <label for="title">Enter Title</label>
                            <input type="text" id="title" name="title" required class="form-control">
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="location">Location</label>
                                <select name="location" class="custom-select" id="location">
                                    <option selected>Choose...</option>
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
                        </div>
                        
                        <div class="form-group col-md-4">
                            <label for="category">Category</label>
                            <select class="custom-select" id="category" name="category">
                                <option selected>Choose...</option>
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
                                <option value="Active">Active</option>
                                <option value="Inactive">Inactive</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="description">Enter Description</label>
                            <textarea id="description" name="description" required rows="6" class="form-control"></textarea>
                        </div>

                        <button type="submit" class="btn btn-success">Publish Job</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
