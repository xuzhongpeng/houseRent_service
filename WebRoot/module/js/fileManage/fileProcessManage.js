// 请求数据时的额外参数
var param = {};

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
						clickToSelect : true,// 设置true 将在点击行时，自动选择rediobox 和  checkbox
						cache : false,// 禁用 AJAX 数据缓存
						sortName : 'uploadTime',// 定义排序列
						sortOrder : 'DESC',// 定义排序方式
						url : 'fileInformationController/getFileWithPaging.do',// 服务器数据的加载地址
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
									field : 'ID',// 返回值名称
									title : '文件ID',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : "10%",// 宽度
									visible : false
								},
								{
									field : 'fileName',// 返回值名称
									title : '文件名称',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : "18%"// 宽度

								},
								{
									field : 'uploadTime',// 返回值名称
									title : '上传时间',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : "18%",// 宽度
								},
								{
									field : 'type',// 返回值名称
									title : '文件类型',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : "18%"// 宽度
								},
								{
									field : 'remarks',// 返回值名称
									title : '备注',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : "21%"// 宽度
								},
								{
									field : 'employeeName',// 返回值名称
									title : '上传人',// 列名
									align : 'center',// 水平居中显示
									valign : 'middle',// 垂直居中显示
									width : "15%"// 宽度
								},
								{
									title : '操作',// 列名
									align : 'center',// 水平居中显示            
									valign : 'middle',// 垂直居中显示                               
									width : "10%",// 宽度
									formatter : function(value, row, index) {
										return "<img src ='module/img/view_icon.png'  onclick='viewFile(\""+row.ID+"\",\""+row.fileName+"\")'   title='预览文件' style='cursor:pointer;padding-right:8px;'></img> "
												+ "<img src ='module/img/download_icon.png'  onclick='downFile(\"" + row.ID + "\")'  title='下载报告'  style='cursor:pointer;padding-right:8px;'></img> "
									}
								} ]
					});
	uploadFile();
});

// 查询
function search() {
	var additionalCondition = {
		fileName : $.trim($('#fileName').val()),
		projectID : $.trim($('#projectID').val()),
		uploadName : $.trim($('#uploadName').val()),
		beginTime : $.trim($('#beginTime').val()),
		endTime : $.trim($('#endTime').val()),
		selectPart : $.trim($('#selectPart').val()),
	};
	$('#table').bootstrapTable('refresh', {
		silent : true,
		url : "fileInformationController/getFileWithPaging.do",
		query : additionalCondition
	});
}

// 下载文件
function downFile() {
	var fileID = arguments[0];
	downOneFile(fileID);
}

// 预览文件
function viewFile() {
	var fileID = arguments[0], fileNames = arguments[1];
	fileSuffixName = "";
	fileNames = fileNames.split(".");
	fileSuffixName = fileNames[fileNames.length - 1].toLowerCase();
	if (fileSuffixName == "png" || fileSuffixName == "jpg" || fileSuffixName == "gif") {
		alert("查看图片请下载下来直接查看");
	} else {
		displayDiv();
		$.post("fileOperateController/onlinePreview.do", {
			ID : fileID
		}, function(result) {
			result = JSON.parse(result);
			if (result != null && result != "null" && result != "") {
				window.location.href = "module/jsp/documentOnlineView.jsp";
			} else {
				alert("无法查看");
			}
		});
	}

}

// 上传报告模版(临时)
function openModal(){
	param.firstDirectoryName = "模版文件";
	param.secondDirectoryName = "报告模版";
	param.thirdDirectoryName = "";
	param.type = 1;
	$("#chooseFile").removeAttr("disabled");
	$("#recoverReport").modal("show");
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

// 上传文件
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
	}).bind('fileuploaddone', function(e, data) {
		reload();
	});
	
	// 文件上传前触发事件,如果需要额外添加参数可以在这里添加
	$('#files').bind('fileuploadsubmit', function(e, data) {
		data.formData = {
			TypeNumber : param.type,
			firstDirectory : param.firstDirectoryName,
			secondDirectory : param.secondDirectoryName,
			thirdDirectory : param.thirdDirectoryName
		}
	});
}

// 查看文件路径
function viewFilePath() {
	var rows = $("#table").bootstrapTable('getSelections');
	if (rows.length === 0) {
		alert("必须选择一条数据");
	}
	if (rows.length > 1) {
		alert("只能选择一条数据");
	} else {
		$.post("fileOperateController/viewFilePath.do", 
		{
			fileID : rows[0].ID
		}, function(result) {
			result = JSON.parse(result);
			$("#fileDetailPath").text(result);
			$("#filePathModal").modal("show");
		});
	}
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
	if (!dataObj.hasOwnProperty("fileName") || dataObj.fileName == null
			|| dataObj.fileName.trim() == "NULL") {
		dataObj.fileName = "";
	}
	if (!dataObj.hasOwnProperty("uploadTime") || dataObj.uploadTime == null
			|| dataObj.uploadTime == undefined) {
		dataObj.uploadTime = "";
	}
	if (!dataObj.hasOwnProperty("type") || dataObj.type == null
			|| dataObj.type.trim() == "NULL") {
		dataObj.type = "";
	}
	if (!dataObj.hasOwnProperty("path") || dataObj.path == null
			|| dataObj.path == undefined) {
		dataObj.path = "";
	}
	if (!dataObj.hasOwnProperty("remarks") || dataObj.remarks == null
			|| dataObj.remarks == undefined) {
		dataObj.remarks = "";
	}
	if (!dataObj.hasOwnProperty("employeeName") || dataObj.employeeName == null
			|| dataObj.employeeName.trim() == "NULL") {
		dataObj.employeeName = "";
	}

}