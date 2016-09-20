<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link href="<c:url value="/static/css/bootstrap.css"/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<c:url value="/static/css/bootstrap.min.js"/>">
	
</script>
<script type="text/javascript"
	src="<c:url value="/static/ckeditor/ckeditor.js"/>">
	
</script>
<link href="static/css/bootstrap.css"
	rel="stylesheet" type="text/css"></link>
<link href="static/css/app.css" rel="stylesheet" type="text/css"></link>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div class="navbar-collapse collapse">
          <form class="nav navbar-nav" role="form">
           <li class="active"><a href="/SpringSecurityHibernateRoleBasedLoginExample/admin">Quản lí địa điểm</a></li>
            <li><a href="#">Quản lí người dùng</a></li>
          </form>
           <form class="navbar-form navbar-right" role="form">
           <a class="btn btn-sm btn-info" href="<c:url value="/logout"/>">Đăng xuất</a>
             </form>
        </div><!--/.navbar-collapse -->
      </div>
    </div><!--/ navigation -->
    
    <!--*************************************************** -->
      <br>
      <br>
      <div class="alert alert-info" role="alert">
        <h2><center>Địa Điểm</center></h2>
        </div>
   

    <!--*************************************************** -->
     <div class="container">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="alert alert-info" role="alert">
				<span class="lead">Danh sách địa điểm </span>
                <span class="navbar-form navbar-right" role="search" style="margin:0; pading:0;">
         <form action="search">
        <div class="form-group">
        	<input type="text" name="ad" class="form-control" placeholder="Tên địa điểm">
          	<button type="submit" class="btn btn-success" value="Search-${ad}">Tìm kiếm</button>    
        </div>
        </form>
        
      </span>
			</div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Tên</th>
						<th>Địa chỉ</th>
						<th>Số điện thoại</th>
						<th>Giá</th>
						<th>Giá khuyến mãi</th>
						<th>Hình</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td><a data-toggle="modal" data-target="#myModal">${user.ten}</a></td>
							<td>${user.diachi}</td>
							<td>0${user.sdt}</td>
							<td>${user.gia1}</td>
							<td>${user.gia2}</td>
							<td>${user.hinh}</td>
							<td><img alt="" src="Dell_logo-2.gif"></td>
							<td><a href="<c:url value='/edit-${user.id}' />"class="btn btn-success custom-width">Sửa</a></td>
							<td><a href="<c:url value='/delete-${user.id}' />"class="btn btn-danger custom-width">Xóa</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		
		<div class="alert alert-info" role="alert">
			<a href="<c:url value='/newuser' />">Thêm mới cơ sở</a>
		</div>
        </div>
    </div>

<div class="container">
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
     
<!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Giới Thiệu</h4>
        </div>
        <div class="modal-body">
        <!-- ---------------- -->
        <div class="panel panel-default">
			<form action="upload">
				<textarea name="description" id="editor1" rows="10" cols="80">${MoTa}</textarea>
				<script>
					CKEDITOR.replace('editor1');
				</script>
				<button type="submit" class="btn btn-default">Lưu</button>
			</form>
		</div>
          <!-- ---------- -->
        </div>
      </div>
      
    </div>
  </div>
  </div>
</body>
</html>