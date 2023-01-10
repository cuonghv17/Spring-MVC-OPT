
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<meta charset="ISO-8859-1">

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


	<div align="center" style="margin: 25px">
		<div>
			<a class="btn btn-success"
				href="${pageContext.request.contextPath}/loaiSan/addLoaiSan">
				new dich vu</a> <a class="btn btn-success"
				href="${pageContext.request.contextPath}">Home</a>
		</div>
		<div align="center" class="row">
			<div class="col">
				<form
					action="${pageContext.request.contextPath}/dangKyThueSan/search"
					method="get" class=" input-group mb-3 mt-3" style="width: 50%">
					<input class="form-control " style="width: 50%" type="text"
						name="searchKey"> <input type="submit" value="Search">
				</form>
			</div>
			<div class="col">
				<form action="${pageContext.request.contextPath}/dangKyThueSan/searchTenSan" class="input-group mb-3 mt-3 row justify-content-md-center">
					<select name="searchKey" class="custom-select col-sm-4 input-group">
					<option value="">Tat ca</option>
						<c:forEach var="c" items="${loaiSans}">
							<option value="${c.tenLoaiSan }">${c.tenLoaiSan}</option>
						</c:forEach>
					</select>
					 <input type="submit" value="Search">
				</form>
		</div>
			

		</div>
		<div align="center" class="justify-content-md-center" style="color: blue;">
				
			 <c:if test="${not empty tt}">${tt}</c:if>
			 </div>
		<table class="table table-striped">
			<thead>

				<tr>
					<th scope="col">Ma DK</th>
					<th scope="col">Ten KH</th>
					<th scope="col">SDT</th>
					<th scope="col">SL</th>
					<th scope="col">Ma LS</th>
					<th scope="col">Ngay Thue</th>
					<th scope="col">Gio Thue</th>
					<th scope="col">Tien coc</th>
					<th scope="col">Tien Thanh toan</th>
					<th scope="col">Ngay dat coc</th>
					<th scope="col">ngay Thanh toan</th>
					<th scope="col">Trang thai</th>

					<th width="col">action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${tTDangKyThues}" varStatus="status">
					<tr>
						<td scope="row">${c.maDK}</td>
						<td>${c.tenKH}</td>
						<td>${c.soDienThoai}</td>
						<td>${c.soLuongSan}</td>
						<td>${c.loaiSan.maLoaiSan}</td>
						<td>${c.ngayThue}</td>
						<td>${c.gioThue}</td>
						<td>${c.tienDatCoc}</td>
						<td>${c.tienThanhToan}</td>
						<td>${c.ngayDatCoc}</td>
						<td>${c.ngayThanhToan}</td>
						<td><c:if test="${c.trangThai ==0}"> Da dat coc</c:if> <c:if
								test="${c.trangThai ==1}"> Da thanh toan</c:if> <c:if
								test="${c.trangThai ==2}"> Da huy</c:if></td>
						<td><a class="btn btn-danger btn-sm"
							onclick="showConfig('${c.maDK}')">Delete</a> <a
							class="btn btn-warning btn-sm" href="update/${c.maDK}">Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<script type="text/javascript">
			function showConfig(id) {
				$('#maDK').text(id);
				$('#yesOptionConfirm').attr('href',
						'delete?maDK=${c.maDK}' + id);
				$('#configmationConfirmId').modal('show');
			}
		</script>

		<!-- Modal -->
		<div class="modal" id="configmationConfirmId">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Xác nhận</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<p>
							Bạn có muốn xác nhan xoa DK có mã "<span id="maDK"></span>" ?
						</p>
					</div>
					<div class="modal-footer">
						<a id="yesOptionConfirm" type="button" class="btn btn-info">Có</a>
						<button type="button" class="btn btn-danger" data-dismiss="modal">Không</button>
					</div>
				</div>
			</div>
		</div>


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


</body>
</html>