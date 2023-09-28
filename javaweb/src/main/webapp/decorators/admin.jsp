<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><dec:title default="Admin | Home" /></title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/plugins/fontawesome-free/css/all.min.css'/> ">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Tempusdominus Bootstrap 4 -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css'/> ">
<!-- iCheck -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/plugins/icheck-bootstrap/icheck-bootstrap.min.css'/> ">
<!-- JQVMap -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/plugins/jqvmap/jqvmap.min.css'/> ">
<!-- Theme style -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/dist/css/adminlte.min.css'/> ">
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/plugins/overlayScrollbars/css/OverlayScrollbars.min.css'/> ">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/plugins/daterangepicker/daterangepicker.css'/> ">
<!-- summernote -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/plugins/summernote/summernote-bs4.min.css'/> ">

<link rel="stylesheet"
	href="<c:url value = 'template/table/css/style.css'/> ">

<link
	href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>	
	
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<!-- header -->
		<%@include file="/common/admin/header.jsp"%>
		<!-- /.header -->


		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a href="index3.html" class="brand-link"> <img
				src=" <c:url value='/template/admin/dist/img/AdminLTELogo.png'/> "
				alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
				style="opacity: .8"> <span
				class="brand-text font-weight-light">AdminLTE 3</span>
			</a>

			<!-- Sidebar -->
			<%@include file="/common/admin/sidebar.jsp"%>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->

			<dec:body />
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- footer -->
		<%@include file="/common/admin/header.jsp"%>
		<!-- /.footer -->


		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>

	<script src="<c:url value='template/admin/plugins/jquery/jquery.min.js'/> "></script>
	<script src="<c:url value='template/admin/plugins/jquery-ui/jquery-ui.min.js'/> "></script>
	<script> $.widget.bridge('uibutton', $.ui.button) </script>
	<script src="<c:url value='template/admin/plugins/bootstrap/js/bootstrap.bundle.min.js'/> "></script>
	<script src="<c:url value='template/admin/plugins/chart.js/Chart.min.js'/> "></script>
	<script src="<c:url value='template/admin/plugins/sparklines/sparkline.js'/> "></script>
	<script src="<c:url value='template/admin/plugins/jqvmap/jquery.vmap.min.js'/> "></script>
	<script src="<c:url value='template/admin/plugins/jqvmap/maps/jquery.vmap.usa.js'/> "></script>
	<script src="<c:url value='template/admin/plugins/jquery-knob/jquery.knob.min.js'/> "></script>
	<script src="<c:url value='template/admin/plugins/moment/moment.min.js'/> "></script>
	<script src="<c:url value='template/admin/plugins/daterangepicker/daterangepicker.js'/> "></script>
	<script src="<c:url value='template/admin/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js'/> "></script>
	<script src="<c:url value='template/admin/plugins/summernote/summernote-bs4.min.js'/> "></script>
	<script src="<c:url value='template/admin/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js'/> "></script>
	<script src="<c:url value='template/admin/dist/js/adminlte.js'/> "></script>
	<script src="<c:url value='template/admin/dist/js/demo.js'/> "></script>
	<script src="<c:url value='template/admin/dist/js/pages/dashboard.js'/> "></script>
	<script src="<c:url value = 'template/table/js/jquery.min.js'/>"></script>
	<script src="<c:url value = 'template/table/js/popper.js'/>"></script>
	<script src="<c:url value = 'template/table/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value = 'template/table/js/main.js'/>"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="<c:url value = 'template/paging/jquery.twbsPagination.js'/>"  type="text/javascript"></script>
</body>

</html>