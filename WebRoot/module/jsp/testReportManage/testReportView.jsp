<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看检测报告</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="module/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="module/css/bootstrap-table.css">
    <link rel="stylesheet" type="text/css" href="module/css/testReportManage/testReportView.css">
	<link rel="stylesheet"  type="text/css" href="module/css/wait.css">
	<link rel="stylesheet" type="text/css" href="module/css/sweetalert.css">
	<link rel="stylesheet" type="text/css" href="module/css/commonSystem/commonSystem.css" />

    
	<script src="module/js/jquery-2.1.1.min.js"></script>
	<script src="module/js/bootstrap.js"></script>
	<script src="module/js/bootstrap-table.js"></script>
	<script src="module/js/bootstrap-table-zh-CN.js"></script>
    <script src="assets/js/autoPage.js"></script>
  </head>
  
   <body>
	<div class="content">
		<div class="title">
			<label>检测报告</label> <label style="float:right"> 
			    <span>交接单编号：</span>
				<span name="schFactoryCode" id="schFactoryCode"></span>
			</label>
			<hr class="hrStyle">
		</div>
		<div class="clientInfo">
			<div class="row ">
				<div class="col-xs-3 col-md-3 col-lg-3">
					<label>委托单位:</label> <span name="clientCompany" id="clientCompany"></span>
				</div>
				<div class="col-xs-3 col-md-3 col-lg-3">
					<label>委托人:</label> <span name="clientPerson" id="clientPerson"></span>
				</div>
				<div class="col-xs-3 col-md-3 col-lg-3">
					<label>委托时间:</label> <span name="clientTime" id="clientTime"></span>
				</div>
				<div class="col-xs-3 col-md-3 col-lg-3">
					<label>完成时间:</label> <span name="finishTime" id="finishTime"></span>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-3 col-md-3 col-lg-3">
					<label>联系电话:</label> <span name="contactNumber" id="contactNumber"></span>
				</div>
				<div class="col-xs-3 col-md-3 col-lg-3">
					<label>通讯地址:</label> <span name="contactAddress"
						id="contactAddress"></span>
				</div>

				<div class="col-xs-3 col-md-3 col-lg-3">
					<label>是否涉密:</label> <span name="isClassified" id="isClassified"></span>
				</div>
				<div class="col-xs-3 col-md-3 col-lg-3">
					<label>密级:</label> <span name="secretLevel" id="secretLevel"></span>
				</div>
			</div>
			<hr class="hrStyle">
		</div>

		<div class="sampleInfo">
			<div >
				<label>样品信息</label>
				<div class="row sampleInfoDiv">
					<table name="sampleInfoTable" id="sampleInfoTable">
					</table>
				</div>
				<hr class="hrStyle">
			</div>
		</div>

		<div class="testReportFile">
			<div>
				<label>报告信息</label>
				<hr class="hrStyle">
				<div>
					<table id="testReportFile">
					</table>
				</div>
			</div>
		</div>
		
		<div class="footer">
			<div class="col-xs-12 col-md-12 col-lg-12 ">
				<div style="float:right;margin-top:10px;">
					<button type="button" onclick="turnBack()" class="btn btn-primary">返回</button>
				</div>
			</div>
		</div>

	</div>

	<div id="wait_img">
		<img src="module/img/wait.jpg" style="width:48px;height:48px;" />
	</div>
	<div id="mask"></div>
	
	<script src="module/js/wait.js"></script>
	<script src="module/js/testReportManage/testReportView.js"></script>
	<script src="module/js/fileManage/fileManage.js"></script>
	<script>
		$("#mask").click(function() {
			hideDiv();
		});
	</script>
</body>
</html>
