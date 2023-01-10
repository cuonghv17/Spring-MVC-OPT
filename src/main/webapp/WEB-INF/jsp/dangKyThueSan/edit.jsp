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
			
				action="${pageContext.request.contextPath}/dangKyThueSan/editSave"
				method="post" modelAttribute="dangKyThueForm">


			

				<div class="form-group justify-content-md-center">
					<div class=" row justify-content-md-center">
						<form:label class="col-2 col-form-label" path="tenKH">Ten Khach Hang</form:label>
						<form:input class="form-control col-sm-4" path="tenKH" />
					</div>
					<form:errors cssClass="error" path="tenKH" />
				</div>
				<div class="form-group justify-content-md-center">
					<div class=" row justify-content-md-center">
						<form:label class="col-2 col-form-label" path="soDienThoai">So DT</form:label>
						<form:input type="number" class="form-control col-sm-4"
							path="soDienThoai" />
					</div>
					<form:errors cssClass="error" path="soDienThoai" />
				</div>
				<div class="form-group justify-content-md-center">
					<div class=" row justify-content-md-center">
						<form:label class="col-2 col-form-label" path="soLuongSan">So Luong San</form:label>
						<form:input type="number" class="form-control col-sm-4"
							path="soLuongSan" />
					</div>
					 <c:if test="${not empty qq}"><div style="color: red">${qq}</div></c:if>
					<form:errors cssClass="error" path="soLuongSan" />
				</div>


				<div class=" justify-content-md-center mb-3">
					<div class=" input-group row justify-content-md-center">

						<form:label class="col-sm-2" path="LoaiSan.maLoaiSan">Ma loai san</form:label>

						<form:select class="custom-select col-sm-4"
							id="inputGroupSelect01" path="LoaiSan.maLoaiSan"
							items="${loaiSans}" itemValue="maLoaiSan" itemLabel="tenLoaiSan">

						</form:select>
					</div>
					
							<form:errors cssClass="error" path="LoaiSan.maLoaiSan" />
				</div>

				<div class="form-group justify-content-md-center">
					<div class=" row justify-content-md-center">
						<form:label class="col-2 col-form-label" path="ngayThue">Ngay Thue</form:label>
						<form:input type="date" class="form-control col-sm-4"
							path="ngayThue" required="required" />
					</div>
					<form:errors  cssClass="error" path="ngayThue" />
				</div>

				<div class="form-group justify-content-md-center">
					<div class=" row justify-content-md-center">
						<form:label class="col-2 col-form-label" path="gioThue">Gio Thue</form:label>
						<form:input type="time" class="form-control col-sm-4"
							path="gioThue" required="required" />
					</div>
					<form:errors  cssClass="error" path="gioThue" />
				</div>
				<div class="form-group justify-content-md-center">
					<div class=" row justify-content-md-center">
						<form:label class="col-2 col-form-label" path="tienDatCoc">Tien dat coc</form:label>
						<form:input class="form-control col-sm-4" path="tienDatCoc"
							 />
					</div>
					<form:errors  cssClass="error" path="tienDatCoc" />
				</div>
				
				<div class="input-group mb-3 row justify-content-md-center">
					<form:label class="col-2 col-form-label" path="trangThai">Trang thai</form:label>
					<form:select path="trangThai" class="custom-select col-sm-4"
						id="inputGroupSelect01">

						<form:option value="0">Da dat coc</form:option>
						<form:option value="1">Da thanh toan</form:option>
						<form:option value="2">Huy dang ky</form:option>
					</form:select>
				</div>
				<form:hidden path="ngayDatCoc" />
				<form:hidden path="maDK" />
				<div class="form-group">
					<form:button class="btn btn-outline-success col-sm-1" value="Add">Add</form:button>
					
				</div>


			</form:form>
		</div>


	</div>


</body>
</html>
