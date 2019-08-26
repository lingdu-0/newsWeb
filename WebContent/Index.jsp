<%@ page import="com.wb.util.DBPage" %>
<%@ page import="com.wb.entity.News" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body>
<div id="wrapper">
    <div id="header">
        <div id="logo">
            <a href="Index.jsp" title="新闻发布系统">新闻发布系统</a>
        </div>
        <!--[if !IE]>logo 结束<![endif]-->
        <div class="search">
            <form id="form1" method="post" action="reception?flag=3">
                <input type="text" name="ntitle" id="textfield" class="iText"/>
                <select name="select">
                    <option selected="selected">标题</option>
                    <option>内容</option>
                </select> <input type="submit" name="Submit" class="btn" value="搜索"/>
            </form>
        </div>
        <!--[if !IE]>search 结束<![endif]-->
    </div>
    <!--[if !IE]>header 结束<![endif]-->
    <div id="main" class="wrapfix">
        <div id="mostlyCon">
            <div class="newslist">
                <div class="hd">
                    <h3>新闻头条</h3>
                </div>
                <div class="bd">
                    <ul class="list">
                        <c:forEach items="${dbPage.list}" var="n">
                            <li><span class="category">${n.ncategory}</span>
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
            <div class="newslist">
                <div class="hd">
                    <h3>热点新闻</h3>
                </div>
                <div class="bd">
                    <ul class="list">
                        <c:forEach items="${dbPage.list}" var="n">
                            <li><span class="category">${n.ncategory}</span>
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
        </div>
        <!--[if !IE]>mostlyCon 结束<![endif]-->
        <div id="sideCon">
            <div id="nav">
                <h3>新闻类别</h3>
                <ul>
                    <c:forEach items="${cateList}" var="cate">
                        <li><a href="reception?flag=2&cid=${cate.cid}">${cate.cname}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <!--[if !IE]>sideCon 结束<![endif]-->
    </div>
    <!--[if !IE]>main 结束<![endif]-->
    <div id="footer">
        <p>版权所有</p>
    </div>
    <!--[if !IE]>main 结束<![endif]-->
</div>
</body>
</html>