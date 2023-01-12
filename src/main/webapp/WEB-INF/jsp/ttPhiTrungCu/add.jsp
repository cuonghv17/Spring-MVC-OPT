<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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

		<h3>Them moi</h3>
		<div align="center" style="margin: 10px">

			<form:form
				action="${pageContext.request.contextPath}/ttPhiTrungCu/save"
				method="post" modelAttribute="ttPhiTrungCuForm">


				<div class="form-group justify-content-md-center">
					<div class=" row justify-content-md-center">
						<form:label class="col-2 col-form-label" path="maCanHo"> ma Can Ho</form:label>
						<form:input class="form-control col-sm-4" path="maCanHo" />
					</div>
					<form:errors cssClass="error" path="maCanHo" />
				</div>
				<div class="form-group justify-content-md-center">
					<div class=" row justify-content-md-center">
						<form:label class="col-2 col-form-label" path="dienTich"> Dien tich</form:label>
						<form:input type="number" class="form-control col-sm-4"
							path="dienTich" />
					</div>
					<form:errors cssClass="error" path="dienTich" />
				</div>
				


				<div class=" justify-content-md-center mb-3">
					<div class=" input-group row justify-content-md-center">

						<form:label class="col-sm-2" path="ToaNha.maToaNha">Ma toa nha</form:label>

						<form:select class="custom-select col-sm-4"
							id="inputGroupSelect01" path="ToaNha.maToaNha"
							items="${toaNhas}" itemValue="maToaNha" itemLabel="maToaNha">

						</form:select>
					</div>
						
							<form:errors cssClass="error" path="ToaNha.maToaNha" />
				</div>
				
				<div class="form-group justify-content-md-center">
					<div class=" row justify-content-md-center">
						<form:label class="col-2 col-form-label" path="hoTenChuHo"> Ho ten chu ho </form:label>
						<form:input class="form-control col-sm-4" path="hoTenChuHo" />
					</div>
					<form:errors cssClass="error" path="hoTenChuHo" />
				</div>
				
				<div class="form-group justify-content-md-center">
					<div class=" row justify-content-md-center">
						<form:label class="col-2 col-form-label" path="soDienThoai"> So dien thoai </form:label>
						<form:input class="form-control col-sm-4" path="soDienThoai" id="soDienThoai" />
					</div>
					<form:errors cssClass="error" path="soDienThoai" />
					<span class="text-danger" id="soDienThoaiErr"></span>
				</div>

				<div class="form-group justify-content-md-center">
					<div class=" row justify-content-md-center">
						<form:label class="col-2 col-form-label" path="thangBD"> Thang bat dau</form:label>
						<form:input type="date" class="form-control col-sm-4"
							path="thangBD" required="required" />
					</div>
					<form:errors  cssClass="error" path="thangBD" />
				</div>

				<div class="form-group justify-content-md-center">
					<div class=" row justify-content-md-center">
						<form:label class="col-2 col-form-label" path="soThang"> So Thang</form:label>
						<form:input class="form-control col-sm-4" path="soThang"
							 />
					</div>
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
				
				
				
				
				<div class="form-group">
					<form:button class="btn btn-outline-success col-sm-1" value="Add">Add</form:button>
				</div>


			</form:form>
		</div>
		

<script type="text/javascript">

	$('#ttPhiTrungCuForm').submit(function (event) {
	    
	    
	    const soDienThoai = $(this.soDienThoai);
	   
	    let isValid = true;
	  
	    if (
	        !handleDisplayError(
	        		soDienThoai,
	        	checkSDT,
	            $('#soDienThoaiErr'),
	            'So dien thoai chua dung'
	        )
	    ) {
	        isValid = false;
	    } 
        if(!isValid){
        	event.preventDefault();
        }
	    
	});
	function handleDisplayError(element, validateFunc, element_err, message) {
	    if (validateFunc(element.val())) {
	        element.addClass('is-invalid');
	        element_err.text(message);
	        return false;
	    }
	    element.removeClass('is-invalid');
	    element_err.text('');
	    return true;
	}
	function isEmpty(value) {
	    return !value || !value.trim();
	}
	
	function checkSDT(value) {
		var vnf_regex = /((09|03|07|08|05)+([0-9]{8})\b)/g;
	   
	    return !value || !value.trim() || !value.match(vnf_regex);
	}
	function checMail(value) {
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	   
	    return !value || !value.trim() || !value.match(mailformat);
	}
	
	function checkLengthh(value) {
	    return value.length > 50;
	}
	</script>


	</div>


</body>
</html>
