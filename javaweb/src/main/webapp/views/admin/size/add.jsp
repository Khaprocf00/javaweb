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
						<a href="<c:url value='/admin-size'/>">size</a>
					</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">size</a></li>
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
		<form action="" method="post" id="formSubmit">
			<!-- <div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input name="email"
					type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email"> <small
					id="emailHelp" class="form-text text-muted">We'll never
					share your email with anyone else.</small>
			</div> -->
			<div class="form-group">
				<label for="name">Name size</label> <input type="text" name="name"
					value="<c:if test='${oldName != null}'>${oldName}</c:if>"
					class="form-control" id="name" placeholder="Enter name size">
				<c:if test="${checkName == false}">
					<div class="alert alert-danger" role="alert">size này đã có
						rồi !</div>
				</c:if>
				<c:if test="${checkName == true}">
					<div class="alert alert-success" role="alert">Đã thêm thành
						công size " ${oldName} "</div>
				</c:if>

			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="text"
					name="text" class="form-control" id="password"
					placeholder="Password">
			</div>
			<div class="form-group">
				<label for="role">Role</label> <input type="text"
					name="text" class="form-control" id="role" placeholder="Role">
			</div>
			<!-- <div class="form-group form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Check me
					out</label>
			</div> -->


			<button type="submit" class="btn btn-primary">Add</button>
		</form>
	</div>
</body>
</html>