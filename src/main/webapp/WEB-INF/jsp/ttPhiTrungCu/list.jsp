
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
			
		<div align="center" class="row">
			<div class="col">
				<form
					action="${pageContext.request.contextPath}/ttPhiTrungCu/search"
					method="get" class=" input-group mb-3 mt-3" style="width: 50%">
					<input class="form-control " style="width: 50%" type="text"
						name="searchKey"> <input type="submit" value="Search">
				</form>
			</div>
			<div class="col">
				<form action="${pageContext.request.contextPath}/ttPhiTrungCu/searchTenSan" class="input-group mb-3 mt-3 row justify-content-md-center">
					<select name="searchKey" class="custom-select col-sm-4 input-group">
					<option value="">Tat ca</option>
						<c:forEach var="c" items="${toaNhas}">
							<option value="${c.maToaNha }">${c.maToaNha}</option>
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
					<th scope="col">Ma TT</th>
					<th scope="col"> Ma CH</th>
					<th scope="col"> Dien tich</th>
					<th scope="col">Ma toa nha</th>
					<th scope="col">Ho ten chu ho</th>
					<th scope="col"> SDT</th>
					<th scope="col">Thang bd</th>
					<th scope="col">Sothang</th>
					<th scope="col">Ngay HD</th>
					<th scope="col">TT</th>
					

					<th width="col">action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${tTPhiTrungCus}" varStatus="status">
					<tr>
						<td scope="row">${c.maTT}</td>
						<td>${c.maCanHo}</td>
						<td>${c.dienTich}</td>
						<td>${c.toaNha.maToaNha}</td>
						<td>${c.hoTenChuHo}</td>
						<td>${c.soDienThoai}</td>
						<td>${c.thangBD}</td>
						<td>${c.soThang}</td>
						<td>${c.ngayDong}</td>
						<td>${c.tongTien}</td>

						<td><a class="btn btn-danger btn-sm"
							onclick="showConfig('${c.maTT}')">Delete</a> <a
							class="btn btn-warning btn-sm" href="update/${c.maTT}">Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<script type="text/javascript">
			function showConfig(id) {
				$('#maTT').text(id);
				$('#yesOptionConfirm').attr('href',
						'delete?maTT=${c.maTT}' + id);
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
							Bạn có muốn xác nhan xoa DK có mã "<span id="maTT"></span>" ?
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