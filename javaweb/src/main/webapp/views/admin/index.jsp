<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin | Home</title>
<link
	href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="<c:url value = 'template/table/css/style.css'/> ">
</head>
<body>
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">Home</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">List</li>
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
	<section class="content">

		<section class="ftco-section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="table-wrap">
							<div class="d-flex flex-row-reverse mb-2" >
								<a class="btn btn-primary r-0 thead-primary" style="color: #fff; background: #99b19c; border: none">Add product</a>
							</div>
							<table class="table">
								<thead class="thead-primary">
									<tr>
										<th>&nbsp;</th>
										<th>&nbsp;</th>
										<th>Product</th>
										<th>Price</th>
										<th>Quantity</th>
										<th>total</th>
										<th>&nbsp;</th>
									</tr>
								</thead>
								<tbody>
									<tr class="alert" role="alert">
										<td><label class="checkbox-wrap checkbox-primary">
												<input type="checkbox" checked> <span
												class="checkmark"></span>
										</label></td>
										<td>
											<div class="img"
												style="background-image: url(<c:url value='template/table/images/product-1.png'/> );"></div>
										</td>
										<td>
											<div class="email">
												<span>Sneakers Shoes 2020 For Men </span> <span>Fugiat
													voluptates quasi nemo, ipsa perferendis</span>
											</div>
										</td>
										<td>$44.99</td>
										<td class="quantity">
											<div class="input-group">
												<input type="text" name="quantity"
													class="quantity form-control input-number" value="2"
													min="1" max="100">
											</div>
										</td>
										<td>$89.98</td>
										<td>
											<button type="button" class="close" data-dismiss="alert"
												aria-label="Close">
												<span aria-hidden="true"><i class="fa fa-close"></i></span>
											</button>
										</td>
									</tr>

									<tr class="alert" role="alert">
										<td><label class="checkbox-wrap checkbox-primary">
												<input type="checkbox"> <span class="checkmark"></span>
										</label></td>
										<td>
											<div class="img"
												style="background-image: url(<c:url value='template/table/images/product-2.png'/> );"></div>
										</td>
										<td>
											<div class="email">
												<span>Sneakers Shoes 2020 For Men </span> <span>Fugiat
													voluptates quasi nemo, ipsa perferendis</span>
											</div>
										</td>
										<td>$30.99</td>
										<td class="quantity">
											<div class="input-group">
												<input type="text" name="quantity"
													class="quantity form-control input-number" value="1"
													min="1" max="100">
											</div>
										</td>
										<td>$30.99</td>
										<td>
											<button type="button" class="close" data-dismiss="alert"
												aria-label="Close">
												<span aria-hidden="true"><i class="fa fa-close"></i></span>
											</button>
										</td>
									</tr>

									<tr class="alert" role="alert">
										<td><label class="checkbox-wrap checkbox-primary">
												<input type="checkbox"> <span class="checkmark"></span>
										</label></td>
										<td>
											<div class="img"
												style="background-image: url(<c:url value='template/table/images/product-3.png'/> );"></div>
										</td>
										<td>
											<div class="email">
												<span>Sneakers Shoes 2020 For Men </span> <span>Fugiat
													voluptates quasi nemo, ipsa perferendis</span>
											</div>
										</td>
										<td>$35.50</td>
										<td class="quantity">
											<div class="input-group">
												<input type="text" name="quantity"
													class="quantity form-control input-number" value="1"
													min="1" max="100">
											</div>
										</td>
										<td>$35.50</td>
										<td>
											<button type="button" class="close" data-dismiss="alert"
												aria-label="Close">
												<span aria-hidden="true"><i class="fa fa-close"></i></span>
											</button>
										</td>
									</tr>

									<tr class="alert" role="alert">
										<td><label class="checkbox-wrap checkbox-primary">
												<input type="checkbox"> <span class="checkmark"></span>
										</label></td>
										<td>
											<div class="img"
												style="background-image: url(<c:url value='template/table/images/product-4.png'/> );"></div>
										</td>
										<td>
											<div class="email">
												<span>Sneakers Shoes 2020 For Men </span> <span>Fugiat
													voluptates quasi nemo, ipsa perferendis</span>
											</div>
										</td>
										<td>$76.99</td>
										<td class="quantity">
											<div class="input-group">
												<input type="text" name="quantity"
													class="quantity form-control input-number" value="1"
													min="1" max="100">
											</div>
										</td>
										<td>$76.99</td>
										<td>
											<button type="button" class="close" data-dismiss="alert"
												aria-label="Close">
												<span aria-hidden="true"><i class="fa fa-close"></i></span>
											</button>
										</td>
									</tr>

									<tr class="alert" role="alert">
										<td class="border-bottom-0"><label
											class="checkbox-wrap checkbox-primary"> <input
												type="checkbox"> <span class="checkmark"></span>
										</label></td>
										<td class="border-bottom-0">
											<div class="img"
												style="background-image: url(<c:url value='template/table/images/product-1.png'/> );"></div>
										</td>
										<td class="border-bottom-0">
											<div class="email">
												<span>Sneakers Shoes 2020 For Men </span> <span>Fugiat
													voluptates quasi nemo, ipsa perferendis</span>
											</div>
										</td>
										<td class="border-bottom-0">$40.00</td>
										<td class="quantity border-bottom-0">
											<div class="input-group">
												<input type="text" name="quantity"
													class="quantity form-control input-number" value="1"
													min="1" max="100">
											</div>
										</td>
										<td class="border-bottom-0">$40.00</td>
										<td class="border-bottom-0">
											<button type="button" class="close" data-dismiss="alert"
												aria-label="Close">
												<span aria-hidden="true"><i class="fa fa-close"></i></span>
											</button>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</section>
	</section>
	<script src="js/jquery.min.js"></script>
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>

</body>
</html>