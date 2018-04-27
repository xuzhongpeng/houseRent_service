package com.cqut.housingrental.controller.manager;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.housingrental.entity.manager.Manager;
import com.cqut.housingrental.service.manager.IManagerService;
import com.cqut.housingrental.service.publicService.IPublicService;

@Controller
@RequestMapping("/managerController")
public class ManagerController{
	
	@Resource(name="managerService")
	IManagerService service;
	
	@Resource(name="publicService")
	IPublicService publicService;
	
	@RequestMapping("/getall")
	@ResponseBody
	public JSONObject getall(HttpServletRequest request) {
		Map<String,Object> result=new HashMap<String, Object>();
		
			result=publicService.getWithPaging(1000, 0, null, null, null,"manager","id");
		
		/*catch(Exception e){
			result.put("type","error");
			result.put("error", e);
			
		}*/
		return JSONObject.fromObject(result);
	}
	@RequestMapping("/getManagerByid")
	@ResponseBody
	public JSONObject getManagerByid(String id) {
		Manager result=publicService.getByID(id,Manager.class);
		return JSONObject.fromObject(result);
	
	}
}
