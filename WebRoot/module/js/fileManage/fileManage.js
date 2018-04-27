var array = [];

// 文件上传
function fileUpload(selectorName, filePath, fileTypeNumber, fileBelongID,
		fileFirstDirectory, fileSecondDirectory, fileThirdDirectory,
		fileOtherInfo, fileRemarks) {
	array = [];
	path = filePath; // 文件上传路径，如果此参数没有值，则使用firstDirectoryName,secondDirectoryName,thirdDirectoryName
	type = fileTypeNumber; // 文件类型
	belongID = fileBelongID;// 文件所属ID
	firstDirectoryName = fileFirstDirectory; // 一级目录
	secondDirectoryName = fileSecondDirectory; // 二级目录
	thirdDirectoryName = fileThirdDirectory // 三级目录
	otherInfo = fileOtherInfo; // 其他参数
	remarks = fileRemarks; // 备注
	$(selectorName).uploadify('upload', '*');
}

// 返回文件ID,延迟执行
function fielIdReturn() {
	return array;
}

// 上传文件
function fileUploadInit(selectorName) {
	$(selectorName).uploadify({
		'async' : false,
		'method' : 'post',
		'auto' : false,// 是否自动上传 true or false
		'successTimeout' : 99999,// 超时时间上传成功后，将等待服务器的响应时间。在此时间后，若服务器未响应，则默认为成功(因为已经上传,等待服务器的响应)单位：秒
		'onUploadStart' : function(file) {
			$("#file_upload").uploadify("settings", "formData", {
				filePath : path, // 文件路径
				belongtoID : belongID,// 文件所属ID
				// 如果文件路径为空，则使用下面的参数
				firstDirectory : firstDirectoryName, // 一级路径
				secondDirectory : secondDirectoryName,// 二级路径
				thirdDirectory : thirdDirectoryName,// 三级路径
				TypeNumber : type, // 文件类型,必须
				content : otherInfo,// 文件内容描述
				remark : remarks
			// 备注
			});
		},
		'swf' : "module/js/uploadify.swf", // flash

		'queueID' : 'uploadfileQueue', // 文件选择后的容器div的id值

		'fileObjName' : 'files', // 将要上传的文件对象的名称 必须与后台controller中抓取的文件名保持一致

		'uploader' : '/laboratorySystem/fileOperateController/upload.do', // 上传地址

		'width' : '100', // 浏览按钮的宽度

		'height' : '32', // 浏览按钮的高度

		'fileTypeDesc' : '支持的格式:', // 在浏览窗口底部的文件类型下拉菜单中显示的文本

		'fileTypeExts' : '*.jpg;*.gif;*.png;*.doc;*.docx;*.xls;*.xlsx',// 允许上传的文件后缀

		'queueSizeLimit' : 1,// 允许上传的文件的最大数量。当达到或超过这个数字，onSelectError事件被触发。

		'onUploadSuccess' : function(file, data, response) {
			var re = new RegExp("\"", "g");
			data = data.replace(re, "");
			array.push(data);
		},
		'onUploadError' : function(file, errorCode, erorMsg, errorString) {
		},

		'onQueueComplete' : function(queueData) {
		}
	});
}

// 下载一个文件的方法,参数为文件ID
function downOneFile(fileID) {
	$.post("/laboratorySystem/fileOperateController/filecheck.do", {
		ID : fileID
	}, function(result) {
		result = eval(result);
		if (result == "OK") {
			window.location.href = "/laboratorySystem/fileOperateController/filedownload.do?ID="
					+ fileID;
		} else {
			alert(result);
		}
	});
}

// 下载选中的所有文件,参数为文件ID
function fileDownAll(ids) {
	window.location.href = "fileOperateController/downloadFiles.do?IDs=" + ids;
}

// 删除所选文件
function deleteFile(ids) {
	jQuery.ajaxSettings.traditional = true;
	$.post("fileOperateController/deleteFiles.do", {
		IDs : ids
	}, function(result) {
		if (result == true || result == "true") {
			alert("删除成功");
		} else {
			alert("删除失败");
		}
	});
}