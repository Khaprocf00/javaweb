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
						<a href="<c:url value='/admin-product'/>">product</a>
					</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">product</a></li>
						<li class="breadcrumb-item active">Add</li>
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
		<form action="" method="post" id="formSubmit"
			enctype="multipart/form-data">
			<div class="form-group">
			<c:if test="${checkName == false}">
				<div class="alert alert-danger" role="alert">Edit Error</div>
			</c:if>
			<c:if test="${checkName == true}">
				<div class="alert alert-success" role="alert">Edit Success</div>
			</c:if>
			</div>
			<div class="form-group">
				<label for="name">Name product</label> <input type="text"
					name="name"
					value="<c:if test='${product != null}'>${product.name}</c:if>"
					class="form-control" id="name" placeholder="Enter name product">
				<c:if test="${checkName == false}">
				<div class="alert alert-danger" role="alert">${product.name} Infected</div>
			</c:if>
			</div>
			<div class="form-group d-flex">
				<div class="mr-5">
					<label for="discount">Discount product</label> <input type="text"
						name="discount"
						value="<c:if test='${product != null}'>${product.discount}</c:if>"
						class="form-control" id="discount"
						placeholder="Enter discount product">
				</div>
				<div class="mr-5">
					<label for="price">Price product</label> <input type="text"
						name="price"
						value="<c:if test='${product != null}'>${product.price}</c:if>"
						class="form-control" id="price" placeholder="Enter price product">
				</div>

				<div>
					<label for="sku">Sku product</label> <input type="text" name="sku"
						value="<c:if test='${product != null}'>${product.sku}</c:if>"
						class="form-control" id="sku" placeholder="Enter sku product">

				</div>
			</div>
			
			<div class="form-group">
				
				<label for="imagePath">image product</label> <img width="100px" height="80px" alt="" src="<c:url value='uploads/product/${product.imagePath}'/>"> <span>${product.imagePath}</span> <input type="file"
					name="imagePath" class="form-control" id="imagePath">
			</div>
			
			<div class="form-group">
				<label for="shortDescription">Short Description product</label> <input
					type="text" name="shortDescription"
					value="<c:if test='${product != null}'>${product.shortDescription}</c:if>"
					class="form-control" id="shortDescription"
					placeholder="Enter short description product">
			</div>
			<div class="form-group">
				<label for="content">Content product</label>
				<div>
					<textarea rows="" cols="" id="content" name="content"
						style="width: 100%; height: 300px">${product.content}</textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="category">Choose Category</label> <select id="category"
					name="categoryId">
					<option value="">--Chose category--</option>
					<c:forEach var="item" items="${category}">
						<option <c:if test='${item.id == product.categoryId }'>selected="selected"</c:if> value="${item.id}">${item.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="brand">Choose Brand</label> <select id="brand"
					name="brandId">
					<option value="">--Choose brand--</option>
					<c:forEach var="item" items="${brand}">
						<option <c:if test='${item.id == product.brandId }'>selected="selected"</c:if> value="${item.id}">${item.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="slider">Choose Slider</label> <select id="slider"
					name="sliderId">
					<option value="">--Choose slider--</option>
					<c:forEach var="item" items="${slider}">
						<option <c:if test='${item.id == product.sliderId }'>selected="selected"</c:if> value="${item.id}">${item.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="tag">Choose Tag</label> <select id="tag" name="tagId">
					<option value="">--Choose tag--</option>
					<c:forEach var="item" items="${tag}">
						<option <c:if test='${item.id == product.tagId }'>selected="selected"</c:if> value="${item.id}">${item.name}</option>
					</c:forEach>
				</select>
			</div>


			<button type="submit" class="btn btn-primary">Add</button>
			
		</form>
	</div>

	<script>
	var myEditor;
	ClassicEditor
     .create(document.querySelector('#content'))
     .then( editor => {
        console.log( 'Editor was initialized', editor );
        myEditor = editor;
    	} )
     .catch(error => {
         console.error(error);
     });
	</script>
</body>
</html>