<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta name="Keywords" content="关键词1,关键词2，关键词3,关键词4,……" />
<meta name="Description" content="你网页的简述" />
<meta name="Robots" content="All" />
<meta name="Generator" content="Dreamweaver" />
<meta name="Author" content="FifthMouse，email" />
<meta name="Copyright" content="Strong Software All Rights Reserved" />
<title>新闻发布后台管理系统</title>
<link href="Style/Login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="wrapper">
		<form id="form1" name="form1"
			action="${pageContext.request.contextPath}/UserServlet">
			<div class="login">
				<table>
					<tr>
						<td>用户名 <input type="hidden" name="flag" value="2"></input></td>

						<td><input name="name"></td>
					</tr>
					<tr>
					<%
						String msg = request.getParameter("msg");
					%> 
					<font color='red'> 
					<%
 						if (msg != null&&Integer.valueOf(msg)==0)
 						out.print("用户名或密码错误！");
 					%>
					</font>
					</tr>
					<tr>
						<td>密&nbsp;&nbsp;&nbsp;&nbsp;码</td>
						<td><input name="pwd" type="password"></td>
					</tr>
				</table>
				<div class="button">
					<a href="reg.jsp">注册</a> <input type="submit" name="Submit"
						value="登录" /> <input type="reset" name="Submit" value="重置" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>
