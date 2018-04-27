/**
 * 
 */

//得到URL参数
function getURLParameter() {
 	var para  = {};
 	var data = decodeURIComponent(window.location.search);
 	data = data.substring(1,data.length);
 	if(data.length >= 1){
 		para = analysisUrl(data);
 	}
     return para; 
 }
//分隔路径
 function analysisUrl(data){
 	var datas = data.split("&");
 	var para ={};
 	for (var i = 0 ; i < datas.length ; i++){
 		var s = datas[i].split("=");
 		if(s.length == 1){
 			para[s[0]] = null;
 		}else{
 			para[s[0]] = s[1];
 		}
 	}
 	return para;
 }
 //验证手机号格式是否正确
 function isNoramlPhone(phone){
		if(phone == undefined || phone == null || phone ==""){
			return false ;
		}
		else {
			 var reg = /^1(3|4|5|7|8)\d{9}$/;
			 if (reg.test(phone)) {
			     return true;
			 }else{
				 return false;
			 }
		}
	}
 //判断对象是否为空
 function isEmptyObject(e) {  
	    var t;  
	    for (t in e)  
	        return !1;  
	    return !0  
	}  
 //深度复制对象
function deepCopy(source) {
	   var result={};
	   for (var key in source) {
		   result[key] = typeof source[key]==='object' ? deepCopy(source[key]): source[key];
	   }
	   return result; 
}

//显示加载图片
function loadingData(){
	if($("#loading").size() == 0){
		var _loadingData = "<div id=\"loading\" style=\"display:none\"><img src=\"./moudle/img/loading.gif\"/></div>";
		$("body").append(_loadingData);
		var _tipWidth = parseInt($("#loading").css("width")) / 2;	
		var _tipLeft = parseInt($("#loading").css("left")) / 100 * parseInt($(window).width()) ;
		var _tipLeftM = _tipLeft -_tipWidth;
		$("#loading").css("left",_tipLeftM+"px");
		$("#loading").css("display","block");
	}
}
//移除加载图片
function removeLoadingData(){
	$("#loading").hide(300).remove();
}	   
