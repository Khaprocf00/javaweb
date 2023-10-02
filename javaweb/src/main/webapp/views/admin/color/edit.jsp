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
						<a href="<c:url value='/admin-color'/>">Color</a>
					</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Color</a></li>
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
		<form action="" method="POST" id="formSubmit">
			<!-- <div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input name="email"
					type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email"> <small
					id="emailHelp" class="form-text text-muted">We'll never
					share your email with anyone else.</small>
			</div> -->
			<div class="form-group">
				<label for="name">Name Color</label> <input type="text"
					name="name" value="${model.name}" class="form-control" id="name"
					placeholder="Enter name brand">
			</div>
			<div class="form-group">
				<label for="code">Code Color</label> <input type="text"
					name="code" value="${model.code}" class="form-control" id="code"
					placeholder="Enter name brand">
				<input type="hidden" value="${model.id}" name="id">
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


			<button type="submit" class="btn btn-primary">Update</button>
			
			<c:if test="${check == false}">
					<div class="alert alert-danger mt-2" role="alert">Name "${color.name}" hoặc Code "${color.code}"
						này đã có rồi !</div>
				</c:if>
				<c:if test="${check == true}">
					<div class="alert alert-success mt-2" role="alert">Edit thành công</div>
				</c:if>
		</form>
	</div>
</body>
</html>