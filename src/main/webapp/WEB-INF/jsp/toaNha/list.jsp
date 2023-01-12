
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<meta charset="ISO-8859-1">
<title>Product List</title>
<style>
.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}


</style>
</head>
<body>
	<header>
		<jsp:include page="../../jsp/fragments/header.jsp" />
	</header>

	<div class="container mt-4"  style=" height: 30em">

		<div align="center">
			<form action="${pageContext.request.contextPath}/toaNha/search"
				method="get" class=" input-group mb-3 mt-3" style="width: 50%">
				
				
			
				<input class="form-control " style="width: 50%" type="text"
					name="searchKey"> <input type="submit" value="Search">
			</form>
			
		</div>
		<table class="table table-bordered text-center">
			<thead>
				<tr>
					<th width="25%">Ma toa nha</th>
					<th width="25%">Ten toa nha</th>

					<th width="25%">action</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${toaNhas}" varStatus="status">
					<tr>
						<td>${c.maToaNha}</td>
						<td>${c.tenToaNha}</td>
						

						<td><a class="btn btn-danger btn-sm" href="delete?maToaNha=${c.maToaNha}">Delete</a>
							&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn btn-warning btn-sm" href="update/${c.maToaNha}">Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />

		<div class="pagination">
			<b> <c:if test="${currentPage > 1}">
					<a href="list?page=${currentPage-1}">Previous</a>
				</c:if> <c:forEach begin="1" end="${totalPages}" var="i">
					<c:choose>
						<c:when test="${currentPage eq i}">
							<a class="active"> ${i} </a>
						</c:when>
						<c:otherwise>
							<a href="list?page=${i}">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach> <c:if test="${currentPage lt totalPages}">
					<a href="list?page=${currentPage+1}">Next</a>
				</c:if>
			</b>
		</div>
	</div>
	
	<footer class="footer">

		<jsp:include page="../../jsp/fragments/footer.jsp" />
	</footer>
</body>
</html>