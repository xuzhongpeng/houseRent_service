// 请求数据时的额外参数
var param = {
		path : "",
		type : 2,
		taskID : "",
		flag : false
};

// 初始化数据
$(function() {
	$("#table")
			.bootstrapTable(
					{
						striped : false,// 隔行变色效果
						pagination : true,// 在表格底部显示分页条
						pageSize : 10,// 页面数据条数
						pageNumber : 1,// 首页页码
						pageList : [ 10, 20 ],// 设置可供选择的页面数据条数
						clickToSelect : true,// 设置true 将在点击行时，自动选择rediobox 和 // checkbox
						cache : false,// 禁用 AJAX 数据缓存
						sortName : 'id',// 定义排序列
						sortOrder : 'DESC',// 定义排序方式
						url : 'testReportController/getTestReportWithPaging.do',// 服务器数据的加载地址
						sidePagination : 'server',// 设置在哪里进行分页
						contentType : 'application/json',// 发送到服务器的数据编码类型
						dataType : 'json',// 服务器返回的数据类型
						queryParams : function queryParams(params) { // 请求服务器数据时,添加一些额外的参数
							param.limit = params.limit;// 页面大小
							param.offset = params.offset; // 偏移量
							param.sort = params.sort; // 排序列名
							param.order = params.order; // 排位方式
							return param;
						},
						queryParamsType : "limit",
						selectItemName : '',// radio or checkbox 的字段名
						columns : [
								{
									checkbox : true,
									width : "1%",// 宽度
									formatter : function(value, row, index) {
										checkData(row); // 验证数据合理性
									}
								},
								{
									field : '',
									title : '序号',
									width : '1%',
									align : 'center',
									valign : 'middle',
									formatter : function(value, row, index) {
										return index + 1;
									}
								},
								{
									field : 'id',// 返回值名称
									title : 'id',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : "20%"// 宽度
								},
								{
									field : 'name',// 返回值名称
									title : 'name',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : "20%"// 宽度
								},
								{
									field : 'password',// 返回值名称
									title : '密码',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : "20%"// 宽度
								},
								{
									field : 'age',// 返回值名称
									title : '年龄',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : "20%"// 宽度
								},
								{
									title : '操作',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : "10%",// 宽度
									formatter : function(value, row, index) {
										return "<img src ='module/img/download_icon.png'  onclick='fileDown(\""
												+ row.fileID
												+ "\")'  title='下载报告'  style='cursor:pointer;'></img> "
												+ "<img src ='module/img/point.png'  onclick='submitReport(\""
												+ row.ID
												+ "\",\""
												+ row.taskID
												+ "\")'   title='提交审核'  style='cursor:pointer;width:18x;height:18px'></spimgan> "
												+ "<img src ='module/img/contractDetail_icon.png' onclick='showSendReportModal(\""
												+ row.ID
												+ "\")'  title='发送报告'  style='cursor:pointer;'></img>";
									}
								} ]
					});
	uploadFile();
});

// 查询
function search() {
	var additionalCondition = {
		receiptlistCode : $.trim($('#transitreceiptNumber').val()),
		client : $.trim($('#client').val()),
		reportName : $.trim($('#reportName').val()),
		beginTime : $.trim($('#beginTime').val()),
		endTime : $.trim($('#endTime').val()),
		selectPart : $.trim($('#selectPart').val())
	};
	$('#table').bootstrapTable('refresh', {
		silent : true,
		url : "testReportController/getTestReportWithPaging.do",
		query : additionalCondition
	});
}

// 提交审核
function submitReport() {
	var keyID = arguments[0], 
	    taskID = arguments[1];
	if (confirm("是否提交审核?")) {
		$.post("testReportController/submitReportCheck.do", 
		{
			ID : keyID
		}, 
		function(result) {
			if (result == true || result == "true") {
				$.post("testReportController/submitReport.do", 
				{
					ID : keyID,
					taskID : taskID
				}, 
				function(result) {
					if (result == true || result == "true") {
						refresh();
						alert("提交成功");
					} else {
						refresh();
						alert("提交失败");
					}
				});
			} else {
				refresh();
				alert("当前报告不可提交审核！请核对报告检测状态或是指定报告审核人");
			}
		});
	}
}

// 发送报告
function showSendReportModal() {
	var testReportID = arguments[0];
	if (confirm("确定发送报告?")) {
		$.post("testReportController/setReportSendCheck.do", 
		{
			ID : testReportID
		}, 
		function(result) {
			if (result == true || result == "true") {
				$("#testReportID").text(testReportID);
				$("#sendReport").modal("show");
			} else {
				alert("不能发送当前报告");
			}
		});
	}
}

// 确定发送
function sendReportSure() {
	var receiveMan = $.trim($("#receiveMan").val());
	$.post("testReportController/setReportSendInfo.do", 
	{
		ID : $("#testReportID").text(),
		receiveMan : receiveMan
	}, 
	function(result) {
		if (result == true || result == "true") {
			refresh();
			alert("发送成功");
		} else {
			refresh();
			alert("发送失败");
		}
	});
	$("#sendReport").modal("hide");
}

// 检查是否可以合并报告
function recoatCheck() {
	var rows = $("#table").bootstrapTable('getSelections');
	if (rows.length == 0) {
		alert("请选择需要合并的报告");
		return;
	}
	if (rows.length == 1) {
		alert("至少选择两个报告才能进行合并");
		return;
	} else {
		var taskIDs = [], fileIDs = [], IDs = [], projectIDs = [], stateEns = [];
		$.each(rows, function() {
			taskIDs.push(this.taskID);
		});
		$.each(rows, function() {
			fileIDs.push(this.fileID);
		});
		$.each(rows, function() {
			projectIDs.push(this.projectID);
		});
		$.each(rows, function() {
			stateEns.push(this.stateEn);
		});
		$.ajax({
			url : 'testReportController/recoatCheck.do',
			type : 'POST',
			data : {
				taskIDs : taskIDs,
				fileIDs : fileIDs,
				projectIDs : projectIDs,
				states : stateEns
			},
			traditional : true,
			success : function(result) {
				result = JSON.parse(result);
				if (result == "true" || result == true) {
					$.each(rows, function() {
						IDs.push(this.ID);
					});
					recoatReport(fileIDs, IDs, taskIDs, projectIDs);			
				} else {
					alert(result)
				}
			}
		});
	}

}

// 合并报告
function recoatReport(fileIDs, IDs, taskIDs, projectIDs) {
	var projectID = projectIDs[0];
	$.ajax({
		url : 'testReportController/recoatReport.do',
		type : 'POST',
		data : {
			fileIDs : fileIDs,
			IDs : IDs,
			taskIDs : taskIDs,
			projectID : projectID
		},
		traditional : true,
		success : function(result) {
			result = JSON.parse(result);
			if (result == null || result == "null" || result == "") {
				alert("合并失败");
			} else {
				updateTestReportFileID(IDs, result);
			}
		}
	});
}

// 更新参与合并的检测报告的文件ID
function updateTestReportFileID(IDs, result) {
	$.ajax({
		url : 'testReportController/updateTestReportFileID.do',
		type : 'POST',
		data : {
			IDs : IDs,
			fileID : result
		},
		traditional : true,
		success : function(result) {
			result = JSON.parse(result);
			if (result == true || result == "true") {
				refresh();
				alert("合并成功");
			} else {
				refresh();
				alert("合并失败");
			}
		}
	});
}

// 检查文件类型
function checkFile(o) {
	$("#chooseFile").attr("disabled", "disabled");
	var filePath = $(o).val();
	if (filePath != "" && filePath != undefined) {
		var arr = filePath.split('\\');
		var fileName = arr[arr.length - 1];
		$("#fileName").html(fileName);
	}
	if (o.value.indexOf('.doc') < 0 && o.value.indexOf('.docx') < 0) {
		alert("不能将此类型文档作为检测报告上传");
	}
} 

// 上传文件(覆盖上传)
function uploadFile() {
	$("#files").fileupload({
		autoUpload : true,
		url : 'fileOperateController/upload.do',
		dataType : 'json',
		add : function(e, data) {
		$("#ensure").click(function() {
			data.submit();
			});
		},
	}).bind('fileuploaddone',function(e, data) {
    	var fileID = JSON.parse(data.result);
		if (fileID != null && fileID != "null" && fileID != "") {
		var rows = $("#table").bootstrapTable('getSelections'), 
		fileVersionNumber = $("#fileVersionNumber").val(), 
		fileVersionInfo = $("#fileVersionNumber").val(),
		fileRemarks = $("#fileRemarks").val();
		$.post("testReportController/updateTestReport.do",
		{
			ID : rows[0].ID,
			taskID : rows[0].taskID,
			versionNumber : fileVersionNumber,
			versionInfo : fileVersionInfo,
			remarks : fileRemarks
			}, 
			function(result) {
				reload();
				});
		} else {
			alert("上传失败");
			} 
		});
	
	// 文件上传前触发事件,如果需要额外添加参数可以在这里添加
	$('#files').bind('fileuploadsubmit', function(e, data) {
		data.formData = {
			filePath : param.path,
			TypeNumber : param.type,
			belongtoID : param.taskID
		};
	});
}
	
// 重新覆盖
function recover() {
	var rows = $("#table").bootstrapTable('getSelections');
	if (rows.length == 0) {
		alert("请选择需要重新覆盖的文件");
		return;
	}
	if (rows.length > 1) {
		alert("只能选择一条数据");
		return;
	} else {
		$.post("testReportController/recoverCheck.do", 
		{
			ID : rows[0].ID
		},
		function(result) {
			if (result == true || result == "true") {
				$.post("fileOperateController/getFileDecryptPath.do",
				{
					ID : rows[0].fileID
				}, 
				function(result) {
					result = JSON.parse(result);
					if (result == null || result == "null" || result == "") {
						alert("没有记录");
					} else {
						var path = result[0].path;
						var i = path.lastIndexOf("\\");
						path = path.substring(i + 1, length);
						$.post("fileOperateController/getFilesInfo.do", 
						{
							ID : rows[0].fileID
						}, 
						function(fileInfos) {
							fileInfos = JSON.parse(fileInfos);
							if (fileInfos != null && fileInfos != "null" && fileInfos != "") {
								$("#chooseFile").removeAttr("disabled");
								$("#fileName").html("");
								param.path = path;
							    param.type = fileInfos[0].type;
							    param.taskID = rows[0].taskID;
							}
						});
					}
				});
				$("#recoverReport").modal("show");
			} else {
				alert("当前审核状态不可以重新覆盖");
			}
		});
	}
}

// 查看检测报告
function checkReport() {
	var rows = $("#table").bootstrapTable('getSelections');
	if (rows.length == 0) {
		alert("请选择要查看的检测报告");
		return;
	}
	if (rows.length > 1) {
		alert("请选择一条数据");
		return;
	} else {
		var testReportID = rows[0].ID;
		if (testReportID != "") {
			window.location.href = "module/jsp/testReportManage/testReportView.jsp?testReportID="
					+ testReportID;
		}
	}
}

// 下载文件
function fileDown() {
	var fileID = arguments[0];
	downOneFile(fileID);
}

// 刷新页面
function refresh() {
	var additionalCondition = {
		receiptlistCode : "",
		client : "",
		reportName : "",
		beginTime : "",
		endTime : "",
		selectPart : ""
	};
	$("#table").bootstrapTable('refresh', {
		silent : true,
		url : "testReportController/getTestReportWithPaging.do",
		query : additionalCondition
	});
}

// 重新加载页面
function reload() {
	window.location.reload();
}

// 检查数据合理性
function checkData(dataObj) {
	if (!dataObj.hasOwnProperty("ID") || dataObj.ID == null
			|| dataObj.ID.trim() == "NULL") {
		dataObj.ID = "";
	}
	if (!dataObj.hasOwnProperty("receiptlistCode")
			|| dataObj.receiptlistCode == null
			|| dataObj.receiptlistCode.trim() == "NULL") {
		dataObj.receiptlistCode = "";
	}
	if (!dataObj.hasOwnProperty("taskID") || dataObj.taskID == null
			|| dataObj.taskID == undefined) {
		dataObj.taskID = "";
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
	if (!dataObj.hasOwnProperty("state") || dataObj.state == null
			|| dataObj.state == undefined) {
		dataObj.state = "";
	}
	if (!dataObj.hasOwnProperty("companyName") || dataObj.companyName == null
			|| dataObj.companyName.trim() == "NULL") {
		dataObj.companyName = "";
	}
	if (!dataObj.hasOwnProperty("fileName") || dataObj.fileName == null
			|| dataObj.fileName.trim() == "NULL") {
		dataObj.fileName = "";
	}
	if (!dataObj.hasOwnProperty("uploadTime") || dataObj.uploadTime == null
			|| dataObj.uploadTime.trim() == "NULL") {
		dataObj.uploadTime = "";
	}
	if (!dataObj.hasOwnProperty("dismissreason2")
			|| dataObj.dismissreason2 == null
			|| dataObj.dismissreason2.trim() == "NULL") {
		dataObj.dismissreason2 = "";
	}
	if (!dataObj.hasOwnProperty("dismissreason3")
			|| dataObj.dismissreason3 == null
			|| dataObj.dismissreason3.trim() == "NULL") {
		dataObj.dismissreason3 = "";
	}
	if (!dataObj.hasOwnProperty("remarks") || dataObj.remarks == null
			|| dataObj.remarks.trim() == "NULL") {
		dataObj.remarks = "";
	}
}