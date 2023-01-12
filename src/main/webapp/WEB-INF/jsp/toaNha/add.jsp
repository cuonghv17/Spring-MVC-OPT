<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<meta charset="ISO-8859-1">
<style type="text/css">
.error{
color: red;
}
</style>

</head>
<body>
	<header>
		<jsp:include page="../../jsp/fragments/header.jsp" />
	</header>
	<div align="center" style="margin: 55px">

		<form:form action="${pageContext.request.contextPath}/toaNha/save"
			method="post" modelAttribute="toaNhaForm">


			<div class="form-group justify-content-md-center">
				<div class=" row justify-content-md-center">

					<form:label class="col-2 col-form-label" path="tenToaNha">Ten Toa Nha</form:label>
					<form:input class="form-control col-sm-4" path="tenToaNha" />
				</div>
				<form:errors class="justify-content-md-center" cssClass="error" path="tenToaNha" />
			</div>


			
			<div class="form-group">
				<form:button class="btn btn-outline-success col-sm-1" value="Add">Add</form:button>
			</div>


		</form:form>
	</div>

	
	<footer class="footer">

		<jsp:include page="../../jsp/fragments/footer.jsp" />
	</footer>

</body>
</html>

