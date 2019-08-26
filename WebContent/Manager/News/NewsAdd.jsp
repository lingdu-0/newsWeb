<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
<meta http-equiv="Content-Language" content="zh-CN" />

<title>添加新闻</title>
<link href="../Style/Css.css" rel="stylesheet" type="text/css" />

<script language="javascript">
  String.prototype.Trim  =  function()
  {
		return  this.replace(/(^\s*)|(\s*$)/g,"");  
	}
	
	function goto()
	{
		if(check()){
	    	document.form1.submit();
		}
	}

	function check()
	{
		if(document.all.form1.title.value.Trim()==""){
			alert("请填写标题!");
			return false;
		 }

		 return true;
	}
	
	function back()
	{
		document.all.form1.action="news?flag=3";
		document.form1.submit();
	}
</script>
</head>

<body>
	<h3 class="subTitle">添加新闻</h3>

	<form id="form1" name="form1"
		action="news" method="post">
		<table width="90%" border="0" align="center" cellpadding="0"
			class="table2" cellspacing="0">
			<tr>
				<th width="15%" align="right">新闻类别</th>
				<td><select name="ncategory">
					<c:forEach items="${cateList}" var="cate">
						<option value="${cate.cname}" selected="selected">${cate.cname}</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th align="right">文章标题</th>
				<td><input name="ntitle" type="text" class="input1" id="header" />
					<input name="flag" type="hidden" value="0" /></td>
			</tr>
			<tr>
				<th align="right" valign="top">文章内容</th>
				<td><input name="nid" type="hidden" class="input1" id="text" />
					<textarea cols="80" rows="20" name="ncontent"></textarea></td>
			</tr>
		</table>
		<table width="90%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="yesno">
			<tr>
				<td height="50" align="center"><input type="submit"
					name="Submit" value="添加" /> <input type="reset" name="Submit2"
					value="重置" /> <input type="button" name="Submit" value="取消"
					onclick="back()" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
