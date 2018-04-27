var winWidth;
var winHeight;
var imgLeft;
var imgTop = 150 + "px";
window.onload = function() {
	throttle(resizeDiv);
}

// 窗口改变重新布局延迟0.1s执行
function throttle(method, context) {
	clearTimeout(method.tId);
	method.tId = setTimeout(function() {
		method.call(context);
	}, 100);
}

// 展示图片和遮罩层
function displayDiv() {
	$("#wait_img,#mask").css({
		"display" : "block"
	});
}

// 隐藏 图片和遮罩层
function hideDiv(){
	$("#wait_img,#mask").css({
		"display" : "none"
	});
}

// 重新设置宽高
function resizeDiv() {
	// 获取窗口宽度和高度
	if (window.innerWidth && window.innerHeight) { // 兼容火狐，谷歌,safari等浏览器
		winWidth = $(document).width();
		winHeight = $(document).height()
	} else if ((document.body) && (document.body.clientWidth)) { // 兼容IE浏览器
		winWidth = document.body.clientWidth;
		winHeight = document.body.clientHeight
	}
	imgLeft = winWidth / 2 + "px";
	winWidth = winWidth + "px";
	winHeight = winHeight + "px";
	$("#wait_img").css({
		"left" : imgLeft,
		"top" : imgTop
	});
	$("#mask").css({
		"height" : winHeight,
		"width" : winWidth
	});
}

// 窗口大小改变时重新布局
window.onresize = function() {
	throttle(resizeDiv);
};
