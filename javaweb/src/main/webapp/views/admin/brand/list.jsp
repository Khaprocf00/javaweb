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
					<h1 class="m-0">
						<a href="<c:url value='/admin-brand'/>">Brand</a>
					</h1>
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
	<form action="<c:url value='/admin-brand'/>" method="get" id="formSubmit">
		<section class="content">
			<section class="ftco-section">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<div class="table-wrap">
								<table class="table">
									<thead class="thead-primary">
										<tr>
											<th>&nbsp;</th>
											<th>Name</th>
											<th>&nbsp;</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${model.listResult}">
											<tr class="alert" role="alert">
												<td><label class="checkbox-wrap checkbox-primary">
														<input type="checkbox" checked> <span
														class="checkmark"></span>
												</label></td>
												<td>${item.name}</td>

												<td class="d-flex flex-row-reverse">
													<a href="<c:url value='/admin-brand?action=delete&id=${item.id}'/>" >
														<button type="button" class="btn btn-danger" >
															<span aria-hidden="true"><i class="fa fa-close"></i></span>
														</button>
													</a>
													<a href="<c:url value='/admin-brand?action=edit&id=${item.id}' />">
														<button type="button" class="btn btn-primary mr-2" >
															<span aria-hidden="true"><i
																class="fa-solid fa-pen-to-square"></i></span>
														</button>
													</a>
													
												</td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
								<div class="d-flex flex-row-reverse">
									<ul class="pagination" id="pagination"></ul>
									<input type="hidden" value="" name="page" id="page" /> <input
										type="hidden" value="" name="maxPageItem" id="maxPageItem" />
									<input type="hidden" value="" name="sortName" id="sortName">
									<input type="hidden" value="" name="sortBy" id="sortBy">
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</section>
	</form>
	<script type="text/javascript">
		var currentPage = ${model.page};
		var totalPage = ${model.totalPage};
		var limit = ${model.maxPageItem};
		var sortName = "${model.sortName}";
		var sortBy = "${model.sortBy}";
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPage,
				visiblePages : 3,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#page').val(page);
						$('#maxPageItem').val(limit);
						$('#sortName').val(sortName);
						$('#sortBy').val(sortBy);
						$('#formSubmit').submit();
					}
				}
			});
		});
	</script>

</body>
</html>