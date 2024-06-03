
<%@page import="java.util.ArrayList"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.JobDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Jobs"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User : Single Jobs</title>
<%@include file="all_components/all_css.jsp"%>
</head>

<body style="background-color: #f0f1f2;">
	<%-- Ensure user is not admin, otherwise redirect to login --%>
	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp" />
	</c:if>
	<jsp:include page="all_components/navbar.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h5 class="text-center text-primary">All Jobs</h5>
				<c:if test="${not empty succMsg}">
					<h4 class="text-center text-danger">${succMsg}</h4>
					<c:remove var="succMsg" />
				</c:if>
				<%
				String loc = request.getParameter("loc");
				String cat = request.getParameter("cat");
				String message = "";

				JobDAO dao = new JobDAO(DBConnect.getConn());
				List<Jobs> list = null;

				if ("loc".equals(loc) && "cat".equals(cat)) {
					list = new ArrayList<Jobs>();
					message = "Jobs Not Available";
				} else if ("loc".equals(loc) || "cat".equals(cat)) {
					list = dao.getJobsOrLocationAndCat(cat, loc);
				} else {
					list = dao.getJobsAndLocationAndCat(cat, loc);
				}
				if (list.isEmpty()) {
				%>
				<h4 class="text-center text-danger">Job Not Availabel</h4>
				<%
				}
				if (list != null) {
				for (Jobs j : list) {
				%>

				<div class="card mt-2">
					<div class="card-body">
						<div class="text-center text-primary">
							<i class="far fa-clipboard fa-2x"></i>
						</div>
						<h6><%=j.getTitle()%></h6>

						<p><%=j.getDescription()%></p>

						<br>
						<div class="form-row">
							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Location: <%=j.getLocation()%>" readonly>
							</div>
							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Category: <%=j.getCategory()%>" readonly>
							</div>
						</div>
						<h6>
							Publish Date:
							<%=j.getPdate().toString()%>
						</h6>
						<div class="text-center">
							<a href="one_view.jsp?id=<%=j.getId()%>"
								class="btn btn-sm bg-success text-white">View</a>
						</div>

					</div>
				</div>
				<%
				}
				} else {
				%>
				<h4 class="text-center text-danger"><%=message%></h4>
				<%
				}
				%>
			</div>
		</div>
	</div>
</body>
</html>
