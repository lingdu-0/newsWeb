<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb18030"/>
    <meta http-equiv="Content-Language" content="zh-CN"/>

    <title>新闻列表</title>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/jquery.js">

    </script>

    <link href="../Style/Css.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h3 class="subTitle">新闻资讯</h3>
<ul class="button">
    <li><a href="news?flag=5">添加新闻</a></li>
</ul>

<table width="90%" border="0" align="center" cellpadding="0"
       cellspacing="0" class="table">
    <tr>
        <th width="8%" nowrap="nowrap">序号</th>
        <th nowrap="nowrap">标题</th>
        <th width="15%" nowrap="nowrap">日期</th>
        <th width="12%">修改</th>
        <th width="12%">删除</th>
    </tr>
    <c:forEach items="${dbPage.list}" var="n">
        <tr>
            <td align="center">${n.nid}
            </td>
            <td align="center">${n.ntitle}
            </td>
            <c:if test="${n!=null}">
            <td align="center">${sdf.format(n.ndate)}
            </td>
            </c:if>
            <td align="center"><a
                    href="news?flag=4&nid=${n.nid}">修改</a></td>
            <td align="center"><a
                    href="news?flag=2&nid=${n.nid}">删除</a></td>
        </tr>

    </c:forEach>

</table>

<table width="90%" border="0" align="center" cellpadding="0"
       cellspacing="0" class="page">
    <tr>
        <td width="50%" align="left">共有${dbPage.totalCount}条记录，<span
                style="font-family: 宋体; font-size: 9.0pt; color: black;">第</span><span
                style="font-family: Tahoma; font-size: 9.0pt; color: black;">
					${dbPage.currPageNo}/${dbPage.totalPageCount}
			</span><span style="font-family: 宋体; font-size: 9.0pt; color: black;">页</span></td>
        <td width="50%" align="right"><a href="news?flag=3&pageNo=<%=1%>">首页</a> <a
                href="news?flag=3&pageNo=${(pageNo - 1) < 1 ? pageNo : (pageNo - 1)}">上一页</a> <a
                href="news?flag=3&pageNo=${(pageNo + 1) > dbPage.totalPageCount ? pageNo : (pageNo + 1)}">下一页</a>
            <a href="news?flag=3&pageNo=${dbPage.totalPageCount}">尾页</a>跳转到 <select
                    name="select2" onchange="window.location=this.value;">
                <c:forEach var="i" begin="1" end="${dbPage.totalPageCount}">
                    <option value="news?flag=3&pageNo=${i}">${i}
                    </option>
                </c:forEach>
            </select></td>
    </tr>
</table>

</body>
</html>
