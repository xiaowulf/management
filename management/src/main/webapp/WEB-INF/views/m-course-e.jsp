<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="zh">
<%@ include file="constants.jsp"%>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;"
	name="viewport" />
<title><%=appName%></title>
<script src="js/echarts.min.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="./css/main.css" />
<link type="text/css" rel="stylesheet" href="./css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="./themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./themes/icon.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
</head>

<body style="background-color: #ffffff;">
	<div class="easyui-tabs" style="width: 100%; height: 800px;">
		<div title="<spring:message code="course.management.detail"/>"
			style="padding: 10px">
			<form action="saveCourse.html" method="post"
				enctype="multipart/form-data">
				<div class="container">
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2"
							style="border: 1px solid #4B306C; height: 30px;">
							<label style="height: 25px; margin-top: 2px; text-align: right;"><spring:message
									code="course.chinesename" /></label>
						</div>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10"
							style="border: 1px solid #4B306C; height: 30px;">
							<input type="text" name="truename"
								style="height: 25px; width: 500px; margin-top: 2px;"
								value='<c:out value="${tbCourse.coursename}"/>'><span
								class="requireText">*</span>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2"
							style="border: 1px solid #4B306C; height: 30px;">
							<label style="height: 25px; margin-top: 2px; text-align: right;"><spring:message
									code="course.category.name" /></label>
						</div>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10"
							style="border: 1px solid #4B306C; height: 30px;">
							<select name="status" id="status_id">
								<c:forEach  items="${dataList}" var="dataList"  varStatus="userStatus">
									<c:if test="${dataList.id eq tbCourse.coursecategoryid}">
										<option value="0" selected="selected"><c:out value="${dataList.category_name}"/></option>
									</c:if>
									<c:if test="${dataList.id ne tbCourse.coursecategoryid}">
										<option value="0"><c:out value="${dataList.category_name}"/></option>
									</c:if>
								</c:forEach>
							</select>
							
							<span class="requireText">*</span>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2"
							style="border: 1px solid #4B306C; height: 30px;">
							<label style="height: 25px; margin-top: 2px; text-align: right;"><spring:message
									code="teacher.status" /></label>
						</div>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10"
							style="border: 1px solid #4B306C; height: 30px;">
							<select name="status" id="status_id">
								<c:if test="${tbCourse.status eq '0'}">
									<option value="0" selected="selected"><spring:message
											code="course.status.off" /></option>
									<option value="1"><spring:message
											code="course.status.on" /></option>
								</c:if>
								<c:if test="${tbCourse.status eq '1'}">
									<option value="0"><spring:message
											code="course.status.off" /></option>
									<option value="1" selected="selected"><spring:message
											code="course.status.on" /></option>
								</c:if>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2"
							style="border: 1px solid #4B306C; height: 260px;">
							<label style="height: 25px; margin-top: 2px; text-align: right;"><spring:message
									code="course.descrption" /></label>
						</div>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10"
							style="border: 1px solid #4B306C; height: 260px;">
							<textarea rows="10" name="resume" cols="68"><c:out
									value="${tbCourse.description}" /></textarea>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"
							style="border: 1px solid #4B306C; height: 50px; padding-top: 5px; text-align: center;">
							<input type="hidden" name="id" value="${tbCourse.id}">
							<button class="btn btn-success" type="submit">
								<spring:message code="system.save" />
							</button>
							<!-- 
							<button class="btn btn-success" type="button"
								onclick="submitForm()">
								<spring:message code="system.close" />
							</button>
							 -->
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- end row -->
	<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/main.js" type="text/javascript"></script>
</body>
</html>