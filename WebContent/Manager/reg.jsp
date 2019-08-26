<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js">
	
</script>
<script type="text/javascript">
	$(function() {//用户名验证
		$("input[name='name']").blur(yanzheng);//失去焦点时调用
	});
	function yanzheng() {
		$.ajax({
			url : "${pageContext.request.contextPath}/UserServlet?flag=0",
			type : "post",
			data : {
				name : $("input[name='name']").val()
			},
			dataType : "json",//设置返回数据类型
			success : function(msg) {
				if (msg.nameJudge) {
					$("#nameJudge").html("<font color='green'>用户名可用</font>");
				} else {
					$("#nameJudge").html("<font color='red'>用户名已被使用</font>");
				}
			}
		});
	}
</script>

</head>
<body>
	<!-- 	<h3>注册界面</h3> -->
	<!-- <div style="width: 100% ;height: 100%;text-align: center;margin: 0;"> -->
	<div style="width: 250px;height: 100%;text-align: center;">
		<form action="${pageContext.request.contextPath}/UserServlet?flag=1"
			method="post">
			<table>
				<tr>
					<td>用户名</td>
					<td><input name="name"></td>
				</tr>
				<tr><td colspan="3"><div id="nameJudge"></div></td></tr>
				<tr>
					<td>密&nbsp;&nbsp;&nbsp;&nbsp;码</td>
					<td><input name="pwd" type="password"></td>
				</tr>
				<tr>
					<td><input type="reset" value="重置"></td>
					<td><input type="submit" value="注册"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>