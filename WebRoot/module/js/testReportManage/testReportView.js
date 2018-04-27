$(function() {
	var ID = getUrlParam("testReportID");
	$.post("testReportController/getCilentInfo.do", {
		testReportID : ID
	}, function(result) {
		result = JSON.parse(result);
		result = checkReportData(result[0]);
		$("#schFactoryCode").text(result.receiptlistCode);
		$("#clientCompany").text(result.companyname);
		$("#clientPerson").text(result.linkman);
		$("#clientTime").text(result.createTime);
		$("#finishTime").text(result.completeTime);
		$("#contactNumber").text(result.linkPhone);
		$("#contactAddress").text(result.address);
		$("#isClassified").text(result.isClassified);
		$("#secretLevel").text(result.classifiedLevel);
		$("#accordingInfo").text(result.requires);
	});
	
	// 获取样品相关信息
	$("#sampleInfoTable").bootstrapTable({
		striped : true,// 隔行变色效果
     	pageSize : 5,// 页面数据条数
		pageNumber : 1,// 首页页码
		clickToSelect : true,// 设置true 将在点击行时，自动选择rediobox 和 checkbox
		cache : false,// 禁用 AJAX 数据缓存
    	sortName : 'ID',// 定义排序列
    	sortOrder : 'DESC',// 定义排序方式
		url : 'testReportController/getSampleInfoWithPaging.do',// 服务器数据的加载地址
		sidePagination : 'server',// 设置在哪里进行分页
		contentType : 'application/json',// 发送到服务器的数据编码类型
		dataType : 'json',// 服务器返回的数据类型
		queryParams: queryParams, //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数
	    queryParamsType: "limit", 
		selectItemName : '',// radio or checkbox 的字段名
		columns : [{
			checkbox : true,
			width :"1%",// 宽度
			formatter : function(value, row, index) {
				 checkSampleData(row);	 // 验证数据合理性
		  }
		},{
			field : 'factoryCode',// 返回值名称
			title : '出厂编号',// 列名
			align : 'center',// 水平居中显示
			valign : 'middle',// 垂直居中显示
			width : "19%"// 宽度
		},{
			field : 'sampleName',// 返回值名称
			title : '名称',// 列名
			align : 'center',// 水平居中显示
		    valign : 'middle',// 垂直居中显示
			width : "20%",// 宽度
		},{
			field : 'specifications',// 返回值名称
			title : '型号/规格/代号',// 列名
			align : 'center',// 水平居中显示
		    valign : 'middle',// 垂直居中显示
			width : "20%",// 宽度
		},{
			field : 'testProjectName',// 返回值名称
			title : '检测/校准项目',// 列名
			align : 'center',// 水平居中显示
		    valign : 'middle',// 垂直居中显示
			width : "20%",// 宽度
		},{
			field : 'employeeName',// 返回值名称
			title : '检测/校准人',// 列名
			align : 'center',// 水平居中显示
		    valign : 'middle',// 垂直居中显示
			width : "20%",// 宽度
		}]
	});
	
	// 请求数据时的额外参数
	function queryParams(){
		var searchCondition = {
			limit : 5,
			offset : 0,
			sort : 'ID',
			order : 'asc',
			testReportID :ID
		};
	    return searchCondition;
	}
	
	// 得到检测报告对应文件的信息
	$("#testReportFile")
			.bootstrapTable(
					{
						striped : true,// 隔行变色效果
						pageSize : 5,// 页面数据条数
						pageNumber : 1,// 首页页码
						clickToSelect : true,// 设置true 将在点击行时，自动选择rediobox 和
												// checkbox
						cache : false,// 禁用 AJAX 数据缓存
						sortName : 'ID',// 定义排序列
						sortOrder : 'DESC',// 定义排序方式
						url : 'testReportController/getTestReportFileInfoWithPaging.do',// 服务器数据的加载地址
						sidePagination : 'server',// 设置在哪里进行分页
						contentType : 'application/json',// 发送到服务器的数据编码类型
						dataType : 'json',// 服务器返回的数据类型
						queryParams : search,
						queryParamsType : "limit", // 参数格式,发送标准的RESTFul类型的参数请求
						columns : [
								{
									checkbox : true,
									width : "1%",// 宽度
									formatter : function(value, row, index) {
										checkData(row); // 验证数据合理性
									}
								},
								{
									field : 'ID',// 返回值名称
									title : '检测报告ID',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : '10%',// 宽度
									visible : false
								},
								{
									field : 'fileID',// 返回值名称
									title : '文件ID',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : '10%',// 宽度
									visible : false
								},
								{
									field : 'taskID',// 返回值名称
									title : '任务ID',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : '10%',// 宽度
									visible : false
								},
								{
									field : 'fileName',// 返回值名称
									title : '文件名',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : '13%'// 宽度
								},
								{
									field : 'uploadTime',// 返回值名称
									title : '上传时间',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : '12%'// 宽度
								},
								{
									field : 'versionNumber',// 返回值名称
									title : '版本号',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : '12%'// 宽度
								},
								{
									field : 'versionInformation',// 返回值名称
									title : '版本信息',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : '13%'// 宽度
								},
								{
									field : 'uploadTime',// 返回值名称
									title : '上传时间',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : '13%'// 宽度
								},
								{
									field : 'state',// 返回值名称
									title : '审核状态',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : '13%'// 宽度
								},
								{
									field : 'remarks',// 返回值名称
									title : '备注信息',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : '13%'// 宽度
								},
								{
									title : '操作',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : '10%',// 宽度
									formatter : function(value, row, index) {
										return "<img src ='module/img/download_icon.png'  title='下载' style='cursor:pointer;padding-right:8px;' onclick='downTestReport(\""
												+ row.fileID
												+ "\")'>"
												+ "</img>"
												+ "</img>&nbsp;"
												+ "<img src ='module/img/view_icon.png'  title='查看'  style='cursor:pointer;padding-right:8px;' onclick='onlineView(\""
												+ row.fileID
												+ "\",\""
												+ row.ID
												+ "\")'>"
												+ "</img>"
												+ "</img>&nbsp;"
												+ "<img src ='module/img/delete_icon.png' title='删除' style='cursor:pointer;padding-right:8px;' onclick='deleteTestReport(\""
												+ row.fileID
												+ "\",\""
												+ row.ID
												+ "\",\""
												+ row.taskID
												+ "\")'>" + "</img>";
									}
								} ]
					});

	// 请求数据时的额外参数
	function search() {
		var searchCondition = {
			limit : 5,
			offset : 0,
			sort : 'ID',
			order : 'asc',
			testReportID : ID
		};
		return searchCondition;
	}

});

// 下载检测报告
function downTestReport() {
	var fileID = arguments[0];
	downOneFile(fileID);
}

//预览检测报告
function onlineView() {
	displayDiv();
	var fileID = arguments[0];
	$.post("fileOperateController/onlinePreview.do", 
	{
		ID : fileID
	}, 
	function(result) {
		result = JSON.parse(result); 
		if (result != null && result != "null" && result != "") {
			window.location.href = "module/jsp/documentOnlineView.jsp";
		} else {
			hideDiv();
			alert("无法查看");
		}
	});
}

// 删除检测报告
function deleteTestReport() {
	var fileID = arguments[0],
	    testReportID = arguments[1],
	    taskID = arguments[2];
	if (confirm("确定删除?")) {
		$.post("testReportController/deleteCheck.do", 
		{
			ID : testReportID
		}, 
		function(result) {
			if (result == true || result == "true") {
				deleteFile(fileID);
				$.post("testReportController/deleteOtherTableInfo.do", 
				{
					ID : testReportID,
					taskID : taskID
				});
				refresh();
			} else {
				alert("当前审核状态不能删除");
			}
		});
	}
	refresh();
}

// 获取地址栏的检测报告ID
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) {
		return decodeURI(r[2]);
	} else {
		return null;
	}
}

// 返回
function turnBack() {
	window.history.back(-1);
}

// 刷新页面
function refresh() {
	$('#sampleInfoTable').bootstrapTable('refresh', null);
	$('#testReportFile').bootstrapTable('refresh', null);
}

// 检查报告数据合理性
function checkReportData(dataObj) {
	if (!dataObj.hasOwnProperty("receiptlistCode") || dataObj.receiptlistCode == null
			|| dataObj.receiptlistCode.trim() == "NULL") {
		dataObj.receiptlistCode = "";
	}
	if (!dataObj.hasOwnProperty("companyname") || dataObj.companyname == null
			|| dataObj.companyname.trim() == "NULL") {
		dataObj.companyname = "";
	}
	if (!dataObj.hasOwnProperty("linkman")
			|| dataObj.linkman == null
			|| dataObj.linkman == undefined) {
		dataObj.linkman = ""; 
	}
	if (!dataObj.hasOwnProperty("createTime")
			|| dataObj.createTime == null
			|| dataObj.createTime.trim() == "NULL") {
		dataObj.createTime = "";
	}
	if (!dataObj.hasOwnProperty("completeTime") || dataObj.completeTime == null
			|| dataObj.completeTime == undefined) {
		dataObj.completeTime = ""; 
	}
	if (!dataObj.hasOwnProperty("linkPhone") || dataObj.linkPhone == null
			|| dataObj.linkPhone.trim() == "NULL") {
		dataObj.linkPhone = "";
	}
	if (!dataObj.hasOwnProperty("address") || dataObj.address == null
			|| dataObj.address.trim() == "NULL") {
		dataObj.address = "";
	}
	if (!dataObj.hasOwnProperty("isClassified") || dataObj.isClassified == null
			|| dataObj.isClassified.trim() == "NULL") {
		dataObj.isClassified = "";
	}
	if (!dataObj.hasOwnProperty("classifiedLevel") || dataObj.classifiedLevel == null
			|| dataObj.classifiedLevel.trim() == "NULL") {
		dataObj.classifiedLevel = "";
	}
	if (!dataObj.hasOwnProperty("requires") || dataObj.requires == null
			|| dataObj.requires.trim() == "NULL") {
		dataObj.requires = "";
	}
	return dataObj;
}

// 检查样本数据合理性
function checkSampleData(dataObj) {
	if (!dataObj.hasOwnProperty("ID") || dataObj.ID == null
			|| dataObj.ID.trim() == "NULL") {
		dataObj.ID = "";
	}
	if (!dataObj.hasOwnProperty("factoryCode") || dataObj.factoryCode == null
			|| dataObj.factoryCode.trim() == "NULL") {
		dataObj.factoryCode = "";
	}
	if (!dataObj.hasOwnProperty("testProjectName")
			|| dataObj.testProjectName == null
			|| dataObj.testProjectName.trim() == "NULL") {
		dataObj.testProjectName = "";
	}
	if (!dataObj.hasOwnProperty("sampleName") || dataObj.sampleName == null
			|| dataObj.sampleName.trim() == "NULL") {
		dataObj.sampleName = "";
	}
	if (!dataObj.hasOwnProperty("specifications")
			|| dataObj.specifications == null
			|| dataObj.specifications.trim() == "NULL") {
		dataObj.specifications = "";
	}
	if (!dataObj.hasOwnProperty("employeeName") || dataObj.employeeName == null
			|| dataObj.employeeName.trim() == "NULL") {
		dataObj.employeeName = "";
	}
}

// 检查文件数据合理性
function checkData(dataObj) {
	if (!dataObj.hasOwnProperty("ID") || dataObj.ID == null
			|| dataObj.ID.trim() == "NULL") {
		dataObj.ID = "";
	}
	if (!dataObj.hasOwnProperty("fileID") || dataObj.fileID == null
			|| dataObj.fileID.trim() == "NULL") {
		dataObj.fileID = "";
	}
	if (!dataObj.hasOwnProperty("versionNumber")
			|| dataObj.versionNumber == null
			|| dataObj.versionNumber == undefined) {
		dataObj.versionNumber = ""; 
	}
	if (!dataObj.hasOwnProperty("versionInformation")
			|| dataObj.versionInformation == null
			|| dataObj.versionInformation.trim() == "NULL") {
		dataObj.versionInformation = "";
	}
	if (!dataObj.hasOwnProperty("state") || dataObj.state == null
			|| dataObj.state == undefined) {
		dataObj.state = ""; 
	}
	if (!dataObj.hasOwnProperty("remarks") || dataObj.remarks == null
			|| dataObj.remarks.trim() == "NULL") {
		dataObj.remarks = "";
	}
	if (!dataObj.hasOwnProperty("taskID") || dataObj.taskID == null
			|| dataObj.taskID.trim() == "NULL") {
		dataObj.taskID = "";
	}
	if (!dataObj.hasOwnProperty("uploadTime") || dataObj.uploadTime == null
			|| dataObj.uploadTime.trim() == "NULL") {
		dataObj.uploadTime = "";
	}
	if (!dataObj.hasOwnProperty("fileName") || dataObj.fileName == null
			|| dataObj.fileName.trim() == "NULL") {
		dataObj.fileName = "";
	}
	if (!dataObj.hasOwnProperty("employeeName") || dataObj.employeeName == null
			|| dataObj.employeeName.trim() == "NULL") {
		dataObj.employeeName = "";
	}
}