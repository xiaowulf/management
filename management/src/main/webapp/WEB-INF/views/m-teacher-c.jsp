<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="zh">
<%@ include file="constants.jsp"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
    <title><%=appName%></title>
	<script src="js/echarts.min.js" type="text/javascript"></script>
	<link type="text/css" rel="stylesheet" href="./css/main.css" />
	<link type="text/css" rel="stylesheet" href="./css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="./themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="./themes/icon.css">
	<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
</head>

<body style="background-color: #ffffff;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div id="mainTable">
				   	 <table class="tableClass">
				   	 	<thead>
				   	 		<tr>
				   	 			<th width="10%">
				   	 				<spring:message code="comment.student.name"/>
				   	 			</th>
				   	 			<th width="10%">
				   	 				<spring:message code="comment.create_date"/>
				   	 			</th>
				   	 			<th width="10%">
				   	 				<spring:message code="comment.create_time"/>
				   	 			</th>
				   	 			<th width="70%">
				   	 				<spring:message code="comment.comment"/>
				   	 			</th>
				   	 		</tr>
				   	 	</thead>
				   	 	<tbody id="tableContent">
				   	 		<c:forEach  items="${dataList}" var="dataList"  varStatus="userStatus">
				   	 		<c:if test="${userStatus.index%2==0}">
				   	 			<tr style="background-color:#ffffff;" onmouseover="style.backgroundColor='#f2f288'" onmouseout="style.backgroundColor='#FFFFFF'" id='tableContent${dataList.id}'> 
				   	 		</c:if>
				   	 			
				   	 		<c:if test="${userStatus.index%2==1}">
				   	 			<tr style="background-color:#e0ecff;" onmouseover="style.backgroundColor='#f2f288'" onmouseout="style.backgroundColor='#e0ecff'" id='tableContent${dataList.id}'>
				   	 		</c:if>
				   	 			<td>
				   	 				<c:out value="${dataList.student_name}"></c:out>
					   	 		</td>
				   	 			<td>
				   	 				<c:out value="${dataList.create_date}"></c:out>
					   	 		</td>
					   	 		<td>
					   	 			<c:out value="${dataList.create_time}"></c:out>
					   	 		</td>
					   	 		<td>
					   	 			<c:out value="${dataList.comment}"></c:out>
					   	 		</td>
					   	 		
				   	 		</tr>
				   	 		</c:forEach>
				   	 	</tbody>
				   	 	
				   	 	<tfoot>
				   	 		<tr>
				   	 			<td colspan="9">
				   	 				<%@ include file="page.jsp"%>
				   	 			</td>
				   	 		</tr>
				   	 	</tfoot>
				   	 </table>
				  </div>
			</div>
		</div>
		<!-- end row -->
	</div>
<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/main.js" type="text/javascript"></script>
</body>
</html>