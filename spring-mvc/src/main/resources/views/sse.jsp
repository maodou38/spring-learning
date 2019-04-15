<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"	content="text/html;charset=UTF-8">
<title>服务器端推送消息</title>
</head>
<body>
	<div id="msgFromPush"></div>
	<script type="text/javascript"
		src="<c:url value="assets/js/jquery.js"/>"></script>
	<script type="text/javascript">
		if (!!window.EventSource) {
			var source = new EventSource('push');
			s = '';
			source.addEventListener('message', function(e) {
				s += e.data + " <br/>";
				$("#msgFromPush").html(s);
			});
			source.addEventListener('open', function(e) {
				console.log("连接打开.");
			}, false);
			source.addEventListener('error', function(e) {
				if (e.readyState == EventSource.CLOSED) {
					console.log("连接关闭");
				} else {
					console.log(e.readyState);
				}
			}, false);
		} else {
			console.log("你 的 浏 览 器 不 支 持 SSE");
		}
	</script>
</body>
</html>