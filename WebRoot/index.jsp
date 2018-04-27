<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>测一测</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="module/jsp/yinyuan/testYou.css">
	<script src="module/jsp/yinyuan/jquery-3.1.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="module/jsp/yinyuan/index.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<div class="main">
	<p class="headerFont">测一测你和他（她）的姻缘</p>
	<div style="width:100%;height: 400px">
		<div class="result" id="result">
			<p id="resultScort"></p>
		</div>
	</div>
	<div class="getInput">	
			<p class="font Fgirl">女生姓名：</p>
			<p class="font Fboy">男生姓名：</p>
			<div style="width:100%;clear:both">			
				<input type="text" id="girl" class="input girl" />	
				<input type="text" id="boy" class="input boy" />
			</div>
	</div>
	<div style="width:100%">
		<button class="go" id="go"></button>
	</div>
	</div>

</body>
</html>