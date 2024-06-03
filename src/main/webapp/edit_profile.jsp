<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile Page</title>
<%@include file="all_components/all_css.jsp"%>
</head>
<body style="background-color: #f7f7f7;">
<c:if test="${empty userobj }">
		<c:redirect url="login.jsp" />
	</c:if>
	<%@include file="all_components/navbar.jsp"%>
	<div class="conatiner-fluid">
		<div class="row p-4">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
							<h5>Edit Profile</h5>
						</div>
					<%-- 	 <c:if test="${not empty succMsg }">
							<h4 class="text-center text-success">${succMsg}</h4>
							<c:remove var="succMsg" />
							</c:if>
							 --%>

						<form action="update_profile" method="post">
						<input type="hidden" name=id value="${userobj.id }">
							<div class="form-group">
								<label>Enter Full Name</label> <input type="text"
									required="required" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailhelp"
									name="name" value="${userobj.name }">
							</div>

							<div class="form-group">
								<label>Enter Qualification</label> <input type="text"
									required="required" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailhelp" name="qualification"
									value="${userobj.qualification }">
							</div>

							<div class="form-group">
								<label>Enter Email</label> <input type="email"
									required="required" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailhelp"
									name="email" value="${userobj.email }">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Enter Password</label> <input
									type="password" required="required" class="form-control"
									id="exampleInputPassword1" aria-describedby="emailhelp"
									name="password" value="${userobj.password }">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Update</button>


						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<div style="margin-top: 50px;">
<%@include file="all_components/footer.jsp"%>
</div>
</body>
</html>