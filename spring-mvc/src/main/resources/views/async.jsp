<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"	content="text/html;charset=UTF-8">
<title>Servlet 3.0+async实现服务器推送</title>
</head>
<body>
	<div id="msgFromPush"></div>
	<script type="text/javascript"	src="<c:url value="assets/js/jquery.js"/>"></script>
	<script type="text/javascript">
		s='';
		deferred();
		function deferred(){
			$.get('defer',function(data){
				s+=data+ " <br/>";
				$('#msgFromPush').html(s);
				deferred();
			})
		}
	</script>
</body>
</html>