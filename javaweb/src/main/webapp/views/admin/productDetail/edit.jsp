<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">
						<a href="<c:url value='/admin-product-detail'/>">productDetail</a>
					</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">productDetail</a></li>
						<li class="breadcrumb-item active">Edit</li>
					</ol>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->

	<!-- Main content -->
	<div class="container">
		<form action="" method="POST">
			<div class="form-group d-flex">
				<div class="mr-3">
					<label for="product">Choose Slider</label> <select id="product"
						name="productId">
						<option value="">--Choose slider--</option>
						<c:forEach var="item" items="${product}">
							<option
								<c:if test = "${productDetail.productId == item.id }">selected="selected"</c:if>
								value="${item.id}">${item.name}</option>
						</c:forEach>
					</select>
				</div>

				<div>
					<label for="size">Choose Size</label> <select id="size"
						name="sizeId">
						<option value="">--Choose size--</option>
						<c:forEach var="item" items="${size}">
							<option
								<c:if test = "${productDetail.sizeId == item.id }">selected="selected"</c:if>
								value="${item.id}">${item.name}</option>
						</c:forEach>
					</select>
				</div>

			</div>

			<div class="form-group d-flex">
				<label for="">Choose color</label>
				<div class="ml-3">
					<c:forEach var="item" items="${color}">
						<label class="d-flex align-items-center" for="${item.name}"><input
							<c:if test = "${productDetail.colorId == item.id }">checked</c:if>
							type="radio" name="colorId" id="${item.name}" value="${item.id}">
							<div class="mx-2"
								style="width: 15px; height: 15px; background: ${item.code};"></div>
							${item.name} </label>
					</c:forEach>
				</div>
			</div>

			<div class="form-group">
				<div class="mr-5">
					<label for="qty">Qty productDetail</label> <input type="text"
						name="qty"
						value="<c:if test='${productDetail != null}'>${productDetail.qty}</c:if>"
						class="form-control" id="qty"
						placeholder="Enter qty productDetail">
				</div>
			</div>
			<%-- <div class="form-group">
				<div class="mr-5">
					<label for="qty">Qty productDetail</label> <input type="text"
						name="qty"
						value="<c:if test='${productDetail != null}'>${productDetail.qty}</c:if>"
						class="form-control" id="qty"
						placeholder="Enter qty productDetail">
				</div>
			</div>

			<div class="form-group">
				<label for="color">Choose Product</label> <select id="color"
					name="colorId">
					<option value="">--Choose product--</option>
					<c:forEach var="item" items="${color}">
						<option
							<c:if test = "${productDetail.sliderId == item.id }">selected="selected"</c:if>
							value="${item.id}">${item.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="product">Choose Slider</label> <select id="product"
					name="productId">
					<option value="">--Choose slider--</option>
					<c:forEach var="item" items="${product}">
						<option
							<c:if test = "${productDetail.sliderId == item.id }">selected="selected"</c:if>
							value="${item.id}">${item.name}</option>
					</c:forEach>
				</select>
			</div> 

			<div class="form-group">
				<label for="size">Choose Slider</label> <select id="size"
					name="sizeId">
					<option value="">--Choose size--</option>
					<c:forEach var="item" items="${size}">
						<option
							<c:if test = "${productDetail.sliderId == item.id }">selected="selected"</c:if>
							value="${item.id}">${item.name}</option>
					</c:forEach>
				</select>
			</div> --%>

			<button type="submit" class="btn btn-primary">Edit</button>
			<c:if test="${checkName == false}">
				<div class="alert alert-danger" role="alert">productDetail này
					đã có rồi !</div>
			</c:if>
			<c:if test="${checkName == true}">
				<div class="alert alert-success" role="alert">Đã thêm thành
					công productDetail</div>
			</c:if>
		</form>
	</div>


</body>
</html>