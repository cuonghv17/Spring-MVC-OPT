<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>

<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="../../jsp/fragments/header.jsp" />
	</header>

	<div align="center" style="margin-top: 10px; height: 30em">

		<div align="center" style="margin: 10px">

			 
			<form:form
				action="${pageContext.request.contextPath}/ttPhiTrungCu/editSave"
				method="post" modelAttribute="ttPhiTrungCuForm">



				
				
				<div class="form-group justify-content-md-center">
					<div class=" row justify-content-md-center">
						<form:label class="col-2 col-form-label" path="hoTenChuHo"> Ho ten chu ho </form:label>
						<form:input class="form-control col-sm-4" path="hoTenChuHo" />
					</div>
					<form:errors cssClass="error" path="hoTenChuHo" />
				</div>
				
				
				
				<div class="form-group justify-content-md-center">
					<div class=" row justify-content-md-center">
						<form:label class="col-2 col-form-label" path="soThang"> So Thang</form:label>
						<form:input class="form-control col-sm-4" path="soThang"
							 />
					</div>
					 <c:if test="${not empty qq}"><div style="color: red">${qq}</div></c:if>
					<form:errors  cssClass="error" path="soThang" />
				</div>
				
				<div class="form-group justify-content-md-center">
					<div class=" row justify-content-md-center">
						<form:label class="col-2 col-form-label" path="ngayDong"> Ngay Dong</form:label>
						<form:input type="date" class="form-control col-sm-4"
							path="ngayDong" required="required" />
					</div>
					<form:errors  cssClass="error" path="ngayDong" />
				</div>
				
				<form:hidden path="maCanHo" />
				<form:hidden path="dienTich" />
				<form:hidden path="ToaNha.maToaNha" />
				<form:hidden path="soDienThoai" />
				<form:hidden path="thangBD" />
				<form:hidden path="tongTien" />
				<form:hidden path="maTT" />
				<div class="form-group">
					<form:button class="btn btn-outline-success col-sm-1" value="Add">Add</form:button>
				</div>


			</form:form>


			
		</div>


	</div>


</body>
</html>
