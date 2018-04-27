package com.cqut.housingrental.controller.menu;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.housingrental.entity.menu.Menu;
import com.cqut.housingrental.service.menu.IMenuService;

@Controller
@RequestMapping("/menuController")
public class MenuController{
	
	@Resource(name="menuService")
	IMenuService service;
	
	
	@RequestMapping("/getMenuTree")
	@ResponseBody
	public JSONObject getMenuTree(String userid,HttpServletRequest request) {
		String uid=request.getParameter("userid");
		Map<String,Object> result=service.getMenuList(userid);		
		return JSONObject.fromObject(result);
	}
	@RequestMapping("/getall")
	@ResponseBody
	public JSONObject getall(HttpServletRequest request) {
		Map<String,Object> result=new HashMap<String, Object>();
		try{
			result=service.getMenuWithPaging(1000, 0, null, null, null);
		}
		catch(Exception e){
			result.put("type","error");
			result.put("error", e);
			
		}
		return JSONObject.fromObject(result);
	}
	@RequestMapping("/getMenuWithPaging")
	@ResponseBody
	public JSONObject getMenuWithPaging(String searchText,int offset,String order,String sort,HttpServletRequest request) {
		Map<String,Object> result=new HashMap<String, Object>();
		try{
			result=service.getMenuWithPaging(10, offset, order, sort, searchText);
		}
		catch(Exception e){
			result.put("type","error");
			result.put("error", e);
			
		}
		return JSONObject.fromObject(result);
	}
	@RequestMapping("/update")
	@ResponseBody
	public JSONObject update(Menu menu) {		
		int result=service.update(menu);
		Map<String,Object> returnObj=new HashMap<String, Object>();
		returnObj.put("type", "success");
		returnObj.put("result", result);
		return JSONObject.fromObject(returnObj);
	}
	@RequestMapping("/save")
	@ResponseBody
	public JSONObject save(Menu menu) {		
		int result=service.save(menu);
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
