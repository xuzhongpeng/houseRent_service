package com.cqut.housingrental.controller.role_permission;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.housingrental.service.role_permission.IRole_permissionService;

@Controller
@RequestMapping("/role_permissionController")
public class Role_permissionController{
	
	@Resource(name="role_permissionService")
	IRole_permissionService service;
	
	@RequestMapping("/getall")
	@ResponseBody
	public JSONObject getall(HttpServletRequest request) {
		
		Map<String,Object> result=service.getall();		
		return JSONObject.fromObject(result);
	}
}
