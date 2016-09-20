<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Registration Form</title>
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
	<div class="alert alert-info" role="alert">
		<div class="alert alert-warning" role="alert"><h4>Đăng kí địa điểm</h4></div>
		<form:form method="POST" modelAttribute="fileBucket" enctype="multipart/form-data"
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
							<input type="submit" value="Cập nhật"
								class="btn btn-primary btn-sm" />     <a
								href="<c:url value='/admin' />">Hủy</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Đăng kí"
								class="btn btn-primary btn-sm" />     <a
								href="<c:url value='/admin'/> "/>Hủy</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	</div>
    </div>
    </div>
</body>
</html>