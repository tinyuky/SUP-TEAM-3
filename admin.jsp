<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin page</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	Dear
	<strong>${user}</strong>, Welcome to Admin Page.
	<a href="<c:url value="/logout" />">Logout</a>
	<div class="generic-container">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Products </span>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Tên</th>
						<th>Địa chỉ</th>
						<th>Số điện thoại</th>
						<th>Giá</th>
						<th>Giá khuyến mãi</th>
						<th>Giới thiệu</th>
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
							<td>${user.pr}</td>
							<td><a href="<c:url value='/edit-${user.id}' />"
								class="btn btn-success custom-width">edit</a></td>
							<td><a href="<c:url value='/delete-${user.id}' />"
								class="btn btn-danger custom-width">delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="well">
			<a href="<c:url value='/newuser' />">Add New Co So</a>
		</div>
	</div>
</body>
</html>