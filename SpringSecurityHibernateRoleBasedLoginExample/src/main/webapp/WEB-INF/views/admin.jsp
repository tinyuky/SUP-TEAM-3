<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin page</title>
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
          <a class="navbar-brand" href="#">Admin</a>
        </div>
        <div class="navbar-collapse collapse">
          <form class="nav navbar-nav" role="form">
           <li class="active"><a href="#">QL Địa Điểm</a></li>
            <li><a href="#">QL Người Dùng</a></li>
          </form>
           <form class="navbar-form navbar-right" role="form">
           <a class="btn btn-sm btn-info" href="<c:url value="/logout"/>">Logout</a>
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
				<span class="lead">List of Products </span>
                <span class="navbar-form navbar-right" role="search" style="margin:0; pading:0;">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Search</button>
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
							<td>${user.ten}</td>
							<td>${user.diachi}</td>
							<td>${user.sdt}</td>
							<td>${user.gia1}</td>
							<td>${user.gia2}</td>
							<td>${user.hinh}</td>
							<td><a href="<c:url value='/edit-${user.id}' />"class="btn btn-success custom-width">edit</a></td>
							<td><a href="<c:url value='/delete-${user.id}' />"class="btn btn-danger custom-width">delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		
		<div class="alert alert-info" role="alert">
			<a href="<c:url value='/newuser' />">Add New Co So</a>
		</div>
        </div>
    </div>
</body>
</html>