<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Employee's List</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

        <link rel="stylesheet" type="text/css" href="css/style.css" />
    </head>
    <body>
        <jsp:include page="header-admin.jsp" />
        
        <div class="container mt-3">
            <h2>Employee's List</h2>
            <p> Below table displays only 10 employees list </p>            
            <table class="table table-light table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Full Name</th>
                        <th>Email</th>
                        <th>Phone No.</th>
                        <th style="text-align: center;">Update</th>
                        <th style="text-align: center;">Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="employee" items="${model_list_emp}">
                    	<tr>
                    		<td> ${employee.getName()} </td>
                    		<td> ${employee.getEmail()} </td>
                    		<td> ${employee.getPhoneno()} </td>
                    		<td style="text-align: center;"> 
                    			<a href="#"> <i class="bi bi-pencil-square"></i> </a>
                    		</td>
                    		<td style="text-align: center;"> 
                    			<a href="#"> <i class="bi bi-trash3-fill"></i> </a>
                    		</td>
                    	</tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>
</html>
