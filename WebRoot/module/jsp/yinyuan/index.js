 $(function(){ 	
    $("#go").click(function(){
    	$("#result").css("display","none");
    	$("#resultScort").html("");
    	var girlName=$("#girl").val();
    	var boyName=$("#boy").val();
    	if(girlName!=""&&boyName!=""){    	
	    	$.ajax({
	    		url: "testReportController/testName.do?girlName="+girlName+"&boyName="+boyName, 
		        type: "post",
		        dataType: "json",
		        contentType: "application/json;charset=utf-8",
		        success:function(data){
		        	var e = document.getElementById("result");
		        	var count=data;
		         	$("#result").css("display","block");
		            if(count=="0")
		            	count="0%<br/>同情你";
		            else if(count=="1")
		            	count="10%";
		            else if(count=="2"){
		            	count="20%";
		            }
		            else if(count=="3"){
		            	count="30%";
		            }
		            else if(count=="10"){
		            	count="你妈炸了，乱写什么";
		            }
		            else {
		            	count=data+"0%";
		            }
		            
		        	e.addEventListener("animationend", function() {  
		                $("#resultScort").html(count); 
		            }); 
		        }
	    	})    	
    	}
    })
 })
 