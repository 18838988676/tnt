<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../common/quote.jsp"%>
<%@include file="../common/list-btn-limit.jsp"%>

<script type="text/javascript" src="http://localhost:8080/tnt/acssjsbymy/sockjs.js"></script>
<script type="text/javascript">

//指定发送
function toonly() {
	
	$.post("${ctx}/websocket/send.do", {
		sessionid : $("#sessionid").val(),
		content : $("#content").val()
	}, function(data) {
		if (data.msg == "1") {
			
		} else {
			
		}
	});
}
	



//消息群发
function toall() {
	$.post("${ctx}/websocket/sendtoall.do", {
		sessionid : $("#myid").val(),
		content : $("#allc").val()
	}, function(data) {
		if (data.msg == "1") {
			
		} else {
			
		}
	});
}
	
    

</script>

<style type="text/css">
table.tftable {
azimuth:center;
	font-size: 12px;
	color: #333333;
	width: 100%;
	border-width: 1px;
	border-color: #9dcc7a;
	border-collapse: collapse;
}

table.tftable th {
	font-size: 12px;
	background-color: #abd28e;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #9dcc7a;
	text-align: left;
}

table.tftable tr {
	background-color: #ffffff;
}

table.tftable td {
	font-size: 12px;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #9dcc7a;
}
</style>
<script type="text/javascript">
window.onload=function(){
	 var tfrow = document.getElementById('tfhover').rows.length;
	 var tbRow=[];
	 for (var i=1;i<tfrow;i++) {
	 tbRow[i]=document.getElementById('tfhover').rows[i];
	 tbRow[i].onmouseover = function(){
	 this.style.backgroundColor = '#f3f8aa';
	 };
	 tbRow[i].onmouseout = function() {
	 this.style.backgroundColor = '#ffffff';
	 };
	 }
	};
</script>


</head>

<body>
<div style="position: absolute;top: 30px;left:270px; width: 800px;height: 300px;" >
	<table id="tfhover" class="tftable" border="1" >
		<tr>
			<th>在线ID</th>
			<th>用户名</th>
			<th>部门</th>
			<th>职务</th>
			<th>是否本人</th>
			<th>发送信息</th>
		</tr>
		
		<c:forEach items="${whos}" var="a">
				<c:if test="${pfuserinfo.employeename==a.employeename}">
					<tr style="color: red">
						<td>${a.sessionID}<input type="hidden" value="${a.sessionID}" id="myid"></td>
						<td>${a.employeename }</td>
						<td>${a.departmentname }</td>
						<td>${a.jobtitlename }</td>
						<td>是</td>
						<td>不能发给自己</td>
					</tr>
				</c:if>

				<c:if test="${pfuserinfo.employeename!=a.employeename}">
					<tr>
						<td>${a.sessionID}</td>
						<td>${a.employeename }</td>
						<td>${a.departmentname }</td>
						<td>${a.jobtitlename }</td>
						<td><a href="${ctx}/websocket/makedown.do?sessionId=${a.sessionID }">强制下线</a></td>
						<td><input type="hidden" value="${a.sessionID }" id="sessionid"> <input type="text" id="content">
							<button onclick="toonly(${a.sessionID })">发送信息</button></td>
					</tr>
				</c:if>
			</c:forEach>
		
	</table>
	
	&nbsp;&nbsp;&nbsp;&nbsp;
		发送给所有人：<input type="text" id="allc">
		<button onclick="toall()">发送给所有人</button>
</div>
</body>
</html>
