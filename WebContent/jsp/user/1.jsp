<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@page import="org.springframework.web.socket.client.WebSocketConnectionManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   import="java.util.UUID"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基于SSM+Shiro+Redis+Solr的医疗服务平台</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resource/jquery-3.2.1.js"></script>
<style>
	html,body
	{
		height:100%;
		width:100%;
	}
</style>
</head>
<body>
<div id="log-container" style="height: 100%; overflow-y: scroll;  padding: 10px;">
        <div>
        </div>
    </div>
</body>
<script>
    $(document).ready(function() {
        // 指定websocket路径
        var sid=1;
        var websocket = new WebSocket("ws://localhost:8080/tnt/ws.do?uid="+sid);
        websocket.onmessage = function(event) {
            // 接收服务端的实时日志并添加到HTML页面中
            $("#log-container div").append(event.data + "<p> </p>");
            // 滚动条滚动到最低部
            $("#log-container").scrollTop($("#log-container div").height() - $("#log-container").height());
        };
    });
</script>
</html>