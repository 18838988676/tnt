<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head> 
<%@include file="../common/quote-login.jsp"%>
<meta charset="utf-8">
<title>基于SSM+Shiro+Redis+Solr的医疗服务平台</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "";
%>
<!-- CSS -->
<link rel="stylesheet" href="<%=basePath%>/assets/tx/css/login/supersized.css" />
<link rel="stylesheet" href="<%=basePath%>/assets/tx/css/login/style.css" />
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="<%=basePath%>/js/common/html5shiv.js"></script>
        <![endif]-->
<style>
canvas {
	position: fixed;
	top: 0px;
	left: 0px;
}
</style>
</head>

<body id="body">
<script type="text/javascript" src="../../acssjsbymy/login.js" ></script>
	<div class="page-container" style=" position: absolute; top: -190px; right: 340px;">
		<h1 style="color: red;">基于SSM+Shiro+Redis+Solr的医疗服务平台</h1>
		
		<form id="validation-form">
		
		<div style=" position:relative; width: 180px; height: 60px;"> 
			 <input type="text" name="employeecode" class="employeecode"  placeholder="username">
		</div>
		
		<div style="position:relative;width: 180px; height: 60px;"> 
			 <input type="password" name="psw" class="psw" placeholder="password" >
		</div>
			
			<button id="btnsubmit" type="submit" style="display: none;">隐藏的提交按钮</button>
		</form>
		
		<button type="button" onclick="isubmit()">登录</button>
		<button type="button" id="register" class="register">Register</button>

		<!-- <div class="error">
			<span>+</span>
		</div> -->

		<form action="${ctx}/indexController/toindex.do" method="post"></form>

	</div>
	<!-- Javascript -->
	<script src="<%=basePath%>/assets/tx/js/common/supersized.3.2.7.min.js"></script>
	<script src="<%=basePath%>/assets/tx/js/common/supersized-init.js"></script>
</body>

<script type="text/javascript">
	$(function() {
		//开启表单验证
		formValidate();
		$("input[name='employeecode']")[0].focus();
	});

	function spsw() {
		hint("请联系管理员");
	}

	//弹出框提示
	function hint(result) {
		$.gritter.add({
			// (string | mandatory) the heading of the notification
			title : '温馨提示',
			// (string | mandatory) the text inside the notification
			text : result,
			class_name : 'gritter-success'
					+ (!$('#gritter-light').get(0).checked ? 'gritter-light'
							: '')
		});
		return false;
	}

	//表单验证
	function formValidate() {
		$("#validation-form").validate({
			rules : {
				employeecode : {
					required : true,
					codeChar : true,
					minlength : 1,
					maxlength : 6,
					remote : {
						url : "${ctx}/indexController/verify.do", //后台处理程序
						type : "post", //数据发送方式
						dataType : "json", //接受数据格式   
						data : { //要传递的数据
							employeecode : $("#employeecode").val()
						},
						dataFilter : function(data, type) {
							//判断控制器返回的内容
							var json = JSON.parse(data);
							if (json.valid == "1") {
								return true;
							} else if (json.valid == "0") {
								return false;
							}
						}
					}
				},
				psw : {
					required : true,
					passChar : true,
					minlength : 1,
					maxlength : 6
				}
			},
			messages : {
				employeecode : {
					required : "请输入用户名",
					remote : "用户名不存在"
				},
				psw : {
					required : "请输入密码"
				}
			},
			//重写提交方式
			submitHandler : function() {
				formSubmit();
			}
		});
	}

	//提交事件
	function isubmit() {
		$("#btnsubmit").click();
	}

	//ajax提交
	function formSubmit() {
		$.post("${ctx}/indexController/login.do", {
			employeecode : $("input[name='employeecode']").val(),
			psw : $("input[name='psw']").val()
		}, function(data) {
			if (data.msg == "1") {
				document.forms[1].submit();
			} else {
				hint(data.msg);
				$("input[name='psw']").val("");
			}
		});
	}
</script>
</html>


