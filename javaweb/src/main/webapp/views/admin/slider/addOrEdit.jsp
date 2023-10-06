<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-slider" />
<c:url var="NewURL" value="/admin-slider" />
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
		<c:if test="${not empty messageResponse}">
			<div class="alert alert-${alert}">${messageResponse}</div>
		</c:if>
		<form id="formSubmit" enctype="multipart/form-data">
			<!-- <div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input name="email"
					type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email"> <small
					id="emailHelp" class="form-text text-muted">We'll never
					share your email with anyone else.</small>
			</div> -->
			<div class="form-group">
				<label for="name">Name slider</label> <input type="text" name="name"
					value="${slider.name}" class="form-control" id="name"
					placeholder="Enter name slider">

			</div>
			<div class="form-group">
				<input type="file" class="form-control" name="image" id="image" />
			</div>
			<%-- 	<div class="form-group">
				<label for="image">Image slider</label> <input type="text"
					name="image" value="${slider.image}" class="form-control"
					id="image" placeholder="Enter name slider">
			</div> --%>
			<%-- <div class="form-group">
				<label for="content">Content</label> <input type="text" name="content"
					class="form-control" id="content" value="${slider.content }" placeholder="Enter Content">
			</div> --%>
			<div class="form-group">
				<label for="content">Content Slider</label>
				<div>
					<textarea rows="" cols="" id="content" name="content"
						style="width: 100%; height: 300px">${slider.content}</textarea>
				</div>
			</div>


			<input type="hidden" id="id" name="id" value="${slider.id}">
			<!-- <div class="form-group form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Check me
					out</label>
			</div> -->

			<c:if test="${not empty slider.id}">
				<button type="button" class="btn btn-primary" id="btnAddOrEdit">Edit</button>
			</c:if>
			<c:if test="${empty slider.id}">
				<button type="button" class="btn btn-primary" id="btnAddOrEdit">Add</button>
			</c:if>
		</form>
	</div>
	<script>
	/* var image = $('image').addEventListener("change", (event) => {
		const { files } = event.target;
		return files[0].name;
	}) */
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
		
		 var image ;
		 $('#image').change((event) => {
        	const { files } = event.target;
        	image = files[0].name;
    		});
		 $('#btnAddOrEdit').click(function (e) {
		        e.preventDefault();
		        var data = {};
		        var formData = $('#formSubmit').serializeArray();
		        $.each(formData, function (i, v) {
		            data[""+v.name+""] = v.value;
		        });
		     	data['image'] = image;
		     	data['content'] = myEditor.getData();
		        var id = $('#id').val();
		        if (id == "") {
		            addNew(data);
		        } else {
		            updateNew(data);
		        }
		    });
		    function addNew(data) {
		        $.ajax({
		            url: '${APIurl}',
		            type: 'POST',
		            contentType: 'application/json',
		            data: JSON.stringify(data),
		            dataType: 'json',
		            success: function (result) {
		            	window.location.href = "${NewURL}?action=insert&id="+result.id+"&message=insert_success";
		            },
		            error: function (error) {
		            	window.location.href = "${NewURL}?maxPageItem=2&page=1&message=error_system";
		            }
		        });
		    }
		    function updateNew(data) {
		        $.ajax({
		            url: '${APIurl}',
		            type: 'PUT',
		            contentType: 'application/json',
		            data: JSON.stringify(data),
		            dataType: 'json',
		            success: function (result) {
		            	window.location.href = "${NewURL}?action=edit&id="+result.id+"&message=update_success";
		            },
		            error: function (error) {
		            	window.location.href = "${NewURL}?maxPageItem=2&page=1&message=error_system";
		            }
		        });
		    }
    </script>
</body>
</html>