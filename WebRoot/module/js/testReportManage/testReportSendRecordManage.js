// 请求数据时的额外参数
var param = {};

//初始化数据
$(function() {
		$("#table").bootstrapTable({
			striped : false,// 隔行变色效果
			pagination : true,// 在表格底部显示分页条
			pageSize : 10,// 页面数据条数
			pageNumber : 1,// 首页页码
			pageList : [ 10,20 ],// 设置可供选择的页面数据条数
			clickToSelect : true,// 设置true 将在点击行时，自动选择rediobox 和 checkbox
			cache : false,// 禁用 AJAX 数据缓存
			url : 'testReportController/getTestReportSendRecord.do',// 服务器数据的加载地址
			sidePagination : 'server',// 设置在哪里进行分页
			contentType : 'application/json',// 发送到服务器的数据编码类型
			dataType : 'json',// 服务器返回的数据类型
			queryParams: function queryParams(params) { //请求服务器数据时,添加一些额外的参数
				param.limit = params.limit;// 页面大小
				param.offset = params.offset; // 偏移量
				param.sort = params.sort; // 排序列名
				param.order = params.order; // 排位方式
				return param;
			},
		    queryParamsType: "limit", 
			selectItemName : '',// radio or checkbox 的字段名
			columns : [ {
				checkbox : true,
				width :"1%",// 宽度
				formatter : function(value, row, index) {
					 checkData(row);	 // 验证数据合理性
			  }
			},{
				field: '',
		        title: '序号',
		        width:'1%',
		        align:'center',
		        valign:'middle',
		        formatter: function (value, row, index) {
		              return index+1;
		        }
			},{
				field : 'ID',// 返回值名称
				title : '检测报告ID',// 列名
				align : 'center',// 水平居中显示
				valign : 'middle',// 垂直居中显示
				width : "10%",// 宽度
				visible : false
			},{
				field : 'fileID',// 返回值名称
				title : '文件ID',// 列名
				align : 'center',// 水平居中显示
			    valign : 'middle',// 垂直居中显示
				width : "10%",// 宽度
				visible : false
			},{
				field : 'receiptlistCode',// 返回值名称
				title : '交接单号',// 列名
				align : 'center',// 水平居中显示
			    valign : 'middle',// 垂直居中显示
				width : "14%",// 宽度
				
			},{
				field : 'companyName',// 返回值名称
				title : '委托单位',// 列名
				align : 'center',// 水平居中显示
			    valign : 'middle',// 垂直居中显示
				width : "15%"// 宽度
			},{
				field : 'fileName',// 返回值名称
				title : '报告名称',// 列名
				align : 'center',// 水平居中显示
				valign : 'middle',// 垂直居中显示
				width : "15%"// 宽度
		    },{
				field : 'versionNumber',// 返回值名称
				title : '报告版本',// 列名
				align : 'center',// 水平居中显示
				valign : 'middle',// 垂直居中显示
				width : "10%",// 宽度
			},{
				field : 'sendMan',// 返回值名称
				title : '发送人',// 列名
				align : 'center',// 水平居中显示
				valign : 'middle',// 垂直居中显示
				width : "10%"// 宽度
			},{
				field : 'sendTime',// 返回值名称
				title : '发送时间',// 列名
				align : 'center',// 水平居中显示
				valign : 'middle',// 垂直居中显示
				width :"15%"// 宽度
			},{
				field : 'receiveMan',// 返回值名称
				title : '接受人',// 列名
				align : 'center',// 水平居中显示
				valign : 'middle',// 垂直居中显示
				width : "10%"// 宽度
			},{
				title : '操作',// 列名
				align : 'center',// 水平居中显示
				valign : 'middle',// 垂直居中显示
				width : "10%",// 宽度
				formatter : function(value, row, index) {
					return "<img src ='module/img/exit_icon.png'   onclick='pigeonholeReport(\""+row.ID+"\")'  title='归档'  style='cursor:pointer;padding-right:8px;'></img> "
					+"<img src ='module/img/view_icon.png'   onclick='checkReport(\""+row.ID+"\")'  title='查看' style='cursor:pointer;padding-right:8px;'></img> "
				}
			}]
		});
	
});

//查询
function search(){
	var additionalCondition = {
			receiptlistCode : $.trim($('#transitreceiptNumber').val()),
			client : $.trim($('#client').val()),
			reportName : $.trim($('#reportName').val()),
			beginTime : $.trim($('#beginTime').val()),
			endTime : $.trim($('#endTime').val()),
			receiveManName : $.trim($('#receiveManName').val()),
		};
		$('#table').bootstrapTable('refresh', {
			silent : true,
			url : "testReportController/getTestReportSendRecord.do",
			query : additionalCondition
		});
}

// 归档
function pigeonholeReport() {
	var testReportID = arguments[0];
	if (confirm("是否设置归档?")) {
		$.post("testReportController/pigeonholeReport.do", {
			ID : testReportID
		}, function(result) {
			if (result == true || result == "true") {
				refresh();
				alert("设置归档成功");
			} else {
				refresh();
				alert("设置归档失败");
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

// 刷新页面
function refresh() {
	var additionalCondition = {
			receiptlistCode : "",
			client : "",
			reportName : "",
			beginTime : "",
			endTime : "",
			receiveManName : "",
		};
		$("#table").bootstrapTable('refresh', {
			silent : true,
			url : "testReportController/getTestReportSendRecord.do",
			query : additionalCondition
		});
}

//检查数据合理性
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
	if (!dataObj.hasOwnProperty("sendTime") || dataObj.sendTime == null
			|| dataObj.sendTime.trim() == "NULL") {
		dataObj.sendTime = "";
	}
	if (!dataObj.hasOwnProperty("receiveMan") || dataObj.receiveMan == null
			|| dataObj.receiveMan == undefined) {
		dataObj.receiveMan = "";
	}
	if (!dataObj.hasOwnProperty("sendMan") || dataObj.sendMan == null
			|| dataObj.sendMan == undefined) {
		dataObj.sendMan = "";
	}
	if (!dataObj.hasOwnProperty("receiptlistCode")
			|| dataObj.receiptlistCode == null
			|| dataObj.receiptlistCode.trim() == "NULL") {
		dataObj.receiptlistCode = "";
	}
	if (!dataObj.hasOwnProperty("companyName") || dataObj.companyName == null
			|| dataObj.companyName.trim() == "NULL") {
		dataObj.companyName = "";
	}
	if (!dataObj.hasOwnProperty("fileName") || dataObj.fileName == null
			|| dataObj.fileName.trim() == "NULL") {
		dataObj.fileName = "";
	}
}