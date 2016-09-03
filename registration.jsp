<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Registration Form</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

	<div class="generic-container">
		<div class="well lead">Co So Registration Form</div>
		<form:form method="POST" modelAttribute="fileBucket"  enctype="multipart/form-data"
			class="form-horizontal">
			<form:input type="hidden" path="id" id="id" />

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="ten">Tên</label>
					<div class="col-md-7">
						<form:input type="text" path="ten" id="ten"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="ten" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="diachi">Địa chỉ</label>
					<div class="col-md-7">
						<form:input type="text" path="diachi" id="diachi"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="diachi" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="sdt">Số điện thoại</label>
					<div class="col-md-7">
						<form:input type="INTEGER" path="sdt" id="sdt"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="sdt" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="gia1">Giá</label>
					<div class="col-md-7">
						<form:input type="float" path="gia1" id="gia1"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="gia1" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="gia2">Giá khuyến mãi</label>
					<div class="col-md-7">
						<form:input type="FLOAT" path="gia2" id="gia2"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="gia2" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="pr">Giới thiệu</label>
					<div class="col-md-7">
						<form:input type="FLOAT" path="pr" id="pr"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="pr" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="file">Upload a file</label>
						<div class="col-md-7">
							<form:input type="file" path="file" id="file" />
							<div class="has-error">
								<form:errors path="file" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
		
	

			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"
								class="btn btn-primary btn-sm" /> or <a
								href="<c:url value='/admin' />">Cancel</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"
								class="btn btn-primary btn-sm" /> or <a
								href="<c:url value='/admin' />">Cancel</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>