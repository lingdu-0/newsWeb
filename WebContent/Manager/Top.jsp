<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.wb.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>top</title>
<link href="Style/Top.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%
		User user = (User) session.getAttribute("user");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
		Calendar cal = Calendar.getInstance(); // 获得一个日历
		Date date = new Date();
		String time = null;
		try {
			time = sdf.format(date);
			cal.setTime(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
		if (w < 0)
			w = 0;
	%>
	<div id="top">
		<div id="time">
			您好<%=user.getUname()%>今天是<span id="date"><%=time%>&nbsp;<%=weekDays[w]%></span>
		</div>
		<script type="text/javascript">
			var d = new Date()
			document.getElementById("date").innerHTML = d.getFullYear() + "年"
					+ (d.getMonth() + 1) + "月" + d.getDate() + "日" + " 星期"
					+ "天一二三四五六 ".charAt(d.getDay());
		</script>
	</div>
	<div id="menuBg">
		<div id="name">管理员</div>
		<div id="menu">
			<a href="Main.jsp" target="mainFrame" id="home">首页</a> <a
				href="Login.jsp" target="_parent" id="quit">退出</a>
		</div>
	</div>
</body>
</html>
