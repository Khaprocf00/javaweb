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
						<a href="<c:url value='/admin-slider'/>">slider</a>
					</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">slider</a></li>
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
	<h1>${uploadPath }</h1>
		<form action="" method="post" id="formSubmit"
			enctype="multipart/form-data">
			<!-- <div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input name="email"
					type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email"> <small
					id="emailHelp" class="form-text text-muted">We'll never
					share your email with anyone else.</small>
			</div> -->
			<div class="form-group">
				<label for="name">Name slider</label> <input type="text" name="name"
					value="<c:if test='${model != null}'>${model.name}</c:if>"
					class="form-control" id="name" placeholder="Enter name slider">


			</div>
			<div class="form-group">
				<label for="image" class="d-block">image slider</label> 
				<img style="width: 100px" alt="" src="<c:url value='/uploads/${model.image }'/>">
				<input type="file"
			
					name="image" value="${model.image}" class="form-control" id="image" required >
			</div>

			<div class="form-group">
				<label for="content">Content Slider</label>
				<div>
					<textarea rows="" cols="" id="content" name="content"
						style="width: 100%; height: 300px">${model.content}</textarea>
				</div>
			</div>


			<!-- <div class="form-group">
				<label for="password">Password</label> <input type="password" name="password"
					class="form-control" id="password" placeholder="Password">
			</div>
			<div class="form-group">
				<label for="role">Role</label> <input type="password" name="password"
					class="form-control" id="role" placeholder="Role">
			</div> -->
			<!-- <div class="form-group form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Check me
					out</label>
			</div> -->


			<button type="submit" class="btn btn-primary">Add</button>
			<c:if test="${checkName == false}">
				<div class="alert alert-danger" role="alert">slider này đã có
					rồi !</div>
			</c:if>
			<c:if test="${checkName == true}">
				<div class="alert alert-success" role="alert">Đã thêm thành
					công slider " ${slider.name}"</div>
			</c:if>
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