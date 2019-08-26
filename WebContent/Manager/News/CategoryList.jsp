<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <meta http-equiv="Content-Language" content="zh-CN"/>

    <title>新闻类别管理</title>
    <link href="../Style/Css.css" rel="stylesheet" type="text/css"/>
</head>
<%--<%
    DBPage<Category> dbPage = (DBPage<Category>) session.getAttribute("dbPage");
    int pageNo = (Integer) session.getAttribute("pageNo");
%>--%>
<body>
<h3 class="subTitle">新闻类别</h3>

<ul class="button">
    <li><a href="CategoryAdd.jsp">添加类别</a></li>
</ul>

<form id="form2" name="form2" method="post" action="">
    <table width="90%" border="0" align="center" cellpadding="0"
           cellspacing="0" class="table">
        <tr>
            <th width="8%" nowrap="nowrap">序号</th>
            <th nowrap="nowrap">类别名称</th>
            <th width="12%" nowrap="nowrap">修改</th>
            <th width="12%" nowrap="nowrap">删除</th>
        </tr>
        <c:forEach items="${dbPage.list}" var="category">
            <tr>
                <td align="center">${dbPage.list.indexOf(category)}
                </td>
                <td align="center">${category.cname}
                </td>
                <td align="center"><a
                        href="cate?flag=4&cid=${category.cid}">修改</a></td>
                <td align="center"><a
                        href="cate?flag=2&cid=${category.cid}">删除</a></td>
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
            <td width="50%" align="right"><a href="cate?flag=3&pageNo=<%=1%>">首页</a> <a
                    href="cate?flag=3&pageNo=${pageNo - 1 < 1 ? pageNo : pageNo - 1}">上一页</a> <a
                    href="cate?flag=3&pageNo=${(pageNo + 1) > dbPage.totalPageCount ? pageNo : pageNo + 1}">下一页</a>
                <a href="cate?flag=3&pageNo=${dbPage.totalPageCount}">尾页</a> 跳转到 <select
                        name="select2" onchange="window.location=this.value;">
                    <c:forEach var="i" begin="1" end="${dbPage.totalPageCount}">
                        <option value="cate?flag=3&pageNo=${i}">${i}
                        </option>
                    </c:forEach>
                </select></td>
        </tr>
    </table>
</form>
</body>
</html>
