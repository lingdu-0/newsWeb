<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>新闻发布系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gb18030"/>
    <meta http-equiv="Content-Language" content="zh-CN"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta name="Keywords" content="关键字"/>
    <meta name="Description" content="描述"/>
    <link rel="stylesheet" href="Style/Main.css" type="text/css"
          media="screen, projection"/>
</head>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    session.setAttribute("sdf", sdf);
%>
<body>
<div id="wrapper">
    <div id="header">
        <div id="logo">
            <a href="index.htm" title="新闻发布系统">新闻发布系统</a>
        </div>
        <!--[if !IE]>logo 结束<![endif]-->
        <div class="search">
            <form id="form1" method="post" action="reception?flag=3">
                <input type="text" name="ntitle" id="textfield" class="iText"/>
                <input type="submit" name="Submit" class="btn" value="搜索"/>
            </form>
        </div>
        <!--[if !IE]>search 结束<![endif]-->
    </div>
    <!--[if !IE]>header 结束<![endif]-->
    <div id="main">
        <div class="newslist">
            <div class="hd">
                <h3>搜索结果</h3>
            </div>
            <div class="bd">
                <ul class="list">
                    <c:forEach items="${dbPage.list}" var="n">
                        <li>
                            <span class="category">${n.ncategory}</span>
                            <a href="reception?flag=1&nid=${n.nid}" target="_blank">${n.ntitle}</a>
                            <c:if test="${n!=null}">
                                <span class="date">${sdf.format(n.ndate)}</span>
                            </c:if>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <!--[if !IE]>newslist 结束<![endif]-->
        <div class="paging wrapfix">
            <div class="total">
                共有${dbPage.totalCount}条记录&nbsp;当前${dbPage.currPageNo}/${dbPage.totalPageCount}页
            </div>
            <div class="pn">
                <a
                        href="reception?flag=3&pageNo=${(pageNo - 1) < 1 ? pageNo : (pageNo - 1)}"
                        title="上一页" class="nobar">上一页</a>
                <c:choose><%--总页数是否小于10全部显示--%>
                    <c:when test="${dbPage.totalPageCount<=10}">
                        <c:set var="begin" value="1"></c:set>
                        <c:set var="end" value="${dbPage.totalPageCount}"/>
                    </c:when>
                    <c:otherwise>
                        <%--求页码列表范围--%>
                        <c:set var="begin" value="${dbPage.currPageNo-5}"/>
                        <c:set var="end" value="${dbPage.currPageNo+4}"/>
                        <%--头部超出--%>
                        <c:if test="${begin<1}">
                            <c:set var="begin" value="1"/>
                            <c:set var="end" value="10"/>
                        </c:if>
                        <%--尾部超出--%>
                        <c:if test="${end>dbPage.totalPageCount}">
                            <c:set var="begin" value="${dbPage.totalPageCount-9}"/>
                            <c:set var="end" value="${dbPage.totalPageCount}"/>
                        </c:if>
                    </c:otherwise>
                </c:choose>
                <c:forEach begin="${begin}" end="${end}" var="i">
                    <%--当前页码--%>
                    <c:choose>
                        <c:when test="${i==dbPage.currPageNo}">
                            <font color="blue" size="3px">${i}</font>
                        </c:when>
                        <c:otherwise>
                            <a href="reception?flag=3&pageNo=${i}">${i}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <a href="reception?flag=3&pageNo=${(pageNo + 1) > dbPage.totalPageCount ? pageNo : (pageNo + 1)}"
                   title="下一页" class="nobar">下一页</a>
            </div>
        </div>
        <!--[if !IE]>paging 结束<![endif]-->

    </div>
    <!--[if !IE]>main 结束<![endif]-->
    <div id="footer">
        <p>版权所有</p>
    </div>
    <!--[if !IE]>main 结束<![endif]-->
</div>
</body>
</html>