<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>新闻发布系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
<meta http-equiv="Content-Language" content="zh-CN" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="Keywords" content="关键字" />
<meta name="Description" content="描述" />
<link rel="stylesheet" href="Style/Main.css" type="text/css"
	media="screen, projection" />
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<div id="logo">
				<a href="reception" title="新闻发布系统">新闻发布系统</a>
			</div>
			<!--[if !IE]>logo 结束<![endif]-->
			<div class="search">
				<form id="form1" method="post" action="reception?flag=3">
					<input type="text" name="textfield" id="textfield" class="iText" />
					<input type="submit" name="Submit" class="btn" value="搜索" />
				</form>
			</div>
			<!--[if !IE]>search 结束<![endif]-->
		</div>
		<!--[if !IE]>header 结束<![endif]-->
		<div id="main">
			<div class="doc-info-view">
				<div class="hd">
					<h1>${news.ntitle}</h1>
				</div>
				<hr class="double" />
				<!--[if !IE]>文章属性<![endif]-->
				<div class="doc-parameter">
					<div>作者：赵明宇</div>
					<div>${sdf.format(news.ndate)}</div>
					<div>来源：《北京娱乐信报》</div>
				</div>
				<!--[if !IE]>正文<![endif]-->
				<div class="doc-text">
					${news.ncontent}
				</div>
				<!--[if !IE]>评论<![endif]-->
				<hr class="double" />
				<div class="comment">
					<div class="hd">
						<h3>最新评论</h3>
					</div>
					<!--[if !IE]>评论列表 开始<![endif]-->
					<ol class="com-list">
						<li>
							<p class="title wrapfix">
								<span class="num">1.</span><span class="name">游客</span><span
									class="time">2009-04-17 2:41</span>
							</p>
							<div class="com-body">林风眠拍品质疑引业内追踪谁是名家赝品现元凶</div>
						</li>
						<li>
							<p class="title wrapfix">
								<span class="num">2.</span><span class="name">游客</span><span
									class="time">2009-04-17 2:41</span>
							</p>
							<div class="com-body">林风眠拍品质疑引业内追踪谁是名家赝品现元凶</div>
						</li>
						<li>
							<p class="title wrapfix">
								<span class="num">3.</span><span class="name">游客</span><span
									class="time">2009-04-17 2:41</span>
							</p>
							<div class="com-body">林风眠拍品质疑引业内追踪谁是名家赝品现元凶</div>
						</li>
					</ol>
					<!--[if !IE]>评论列表 结束<![endif]-->
					<!--[if !IE]>填写评论 开始<![endif]-->
					<div class="com-form">
						<hr class="double" />
						<div class="hd">
							<h3>发表评论</h3>
						</div>
						<p class="tips">请自觉遵守互联网相关政策法规，评论不得超过250字。</p>
						<form id="form1" method="post" action="">
							<p>
								<textarea name="textarea" id="textarea" rows="5"
									class="textarea"></textarea>
							</p>
							<p>
								<label for="username">昵称</label><input type="text"
									name="username" size="10" id="username" class="iText" /> <input
									type="submit" name="Submit" class="btn" value="发表评论" />
							</p>
						</form>
					</div>
					<!--[if !IE]>填写评论 开始<![endif]-->
				</div>
			</div>
			<!--[if !IE]>新闻详情 结束<![endif]-->
		</div>
		<!--[if !IE]>main 结束<![endif]-->
		<div id="footer">
			<p>版权所有</p>
		</div>
		<!--[if !IE]>main 结束<![endif]-->
	</div>
</body>
</html>