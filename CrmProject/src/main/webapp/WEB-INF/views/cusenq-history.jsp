<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Customer Enquiry</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" />
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
		
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<jsp:include page="header-employee.jsp" />
	
		<div class="container-fluid">
			<div class="container">
	
				<c:if test="${not empty model_success}">
					<div class="row">
						<div class="alert alert-success alert-dismissible fade show"
							role="alert">
							${model_success}
							<button type="button" class="btn-close" data-bs-dismiss="alert"
								aria-label="Close"></button>
						</div>
					</div>
				</c:if>
	
				<c:if test="${not empty model_error}">
					<div class="row">
						<div class="alert alert-danger alert-dismissible fade show"
							role="alert">
							${model_error}
							<button type="button" class="btn-close" data-bs-dismiss="alert"
								aria-label="Close"></button>
						</div>
					</div>
				</c:if>
	
				<div class="row">
					<div class="col-3"></div>
					<div class="col-6 d-flex justify-content-center">
						<div class="addemp_div_design bg-light">
							<h3>Customer History</h3>
							<!-- <p> Below is the history of customer : ${model_custenq.getName()} (${model_custenq.getPhoneno()}) </p>  -->
							<br />
							<table class="table table-light table-bordered table-striped">
				                <thead>
				                    <tr>
				                        <th>Discussion</th>
				                        <th>Interested Course</th>
				                        <th>Enquiry Date / Time</th>
				                    </tr>
				                </thead>
				                <tbody>
				                    <c:forEach var="custenq" items="${model_custenq}">
				                    	<tr>
				                    		<td> ${custenq.getDiscussion()} </td>
				                    		<td> ${custenq.getInterestedcourse()} </td>
				                    		<td> ${custenq.getEnquirydate()} (${custenq.getEnquirytime()}) </td>
				                    	</tr>
				                    </c:forEach>
				                </tbody>
				            </table>
						</div>
					</div>
					<div class="col-3"></div>
				</div>
			</div>
		</div>
	
	</body>
</html>
