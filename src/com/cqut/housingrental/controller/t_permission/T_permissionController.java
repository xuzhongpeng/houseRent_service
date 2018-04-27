package com.cqut.housingrental.controller.t_permission;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.housingrental.entity.menu.Menu;
import com.cqut.housingrental.entity.t_permission.T_permission;
import com.cqut.housingrental.service.t_permission.IT_permissionService;

@Controller
@RequestMapping("/t_permissionController")
public class T_permissionController{
	
	@Resource(name="t_permissionService")
	IT_permissionService service;
	
	@RequestMapping("/getWithPaging")
	@ResponseBody
	public JSONObject getWithPaging(String searchText,int offset,String order,String sort,HttpServletRequest request) {
		Map<String,Object> result=new HashMap<String, Object>();
		/*try{*/
			result=service.getWithPaging(10, offset, order, sort, searchText);
		/*}
		catch(Exception e){
			result.put("type","error");
			result.put("error", e);
			
		}*/
		return JSONObject.fromObject(result);
	}
	@RequestMapping("/update")
	@ResponseBody
	public JSONObject update(T_permission t_permission) {		
		int result=service.update(t_permission);
		Map<String,Object> returnObj=new HashMap<String, Object>();
		returnObj.put("type", "success");
		returnObj.put("result", result);
		return JSONObject.fromObject(returnObj);
	}
	@RequestMapping("/save")
	@ResponseBody
	public JSONObject save(T_permission t_permission) {		
		int result=service.save(t_permission);
		Map<String,Object> returnObj=new HashMap<String, Object>();
		returnObj.put("type", "success");
		returnObj.put("result", result);
		return JSONObject.fromObject(returnObj);
	}
	@RequestMapping("/delete")
	@ResponseBody
	public JSONObject delete(String ids) {
		String[] idStrings=ids.replace("[","").replace("]", "").replace("\"","").split(",");
		Map<String,Object> returnObj=new HashMap<String, Object>();
		int result=0;
		try{
			result=service.delete(idStrings);
			returnObj.put("result",result);
		}
		catch(NumberFormatException e){
			returnObj.put("type", "success");
			returnObj.put("result", e);
			
		}	
		
		return JSONObject.fromObject(returnObj);
	}
	
}
