package com.cqut.housingrental.controller.facilities;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.housingrental.entity.administrators.Administrators;
import com.cqut.housingrental.entity.facilities.Facilities;
import com.cqut.housingrental.service.facilities.IFacilitiesService;
import com.cqut.housingrental.service.publicService.IPublicService;
import com.cqut.tool.util.EntityIDFactory;

@Controller
@RequestMapping("/facilitiesController")
public class FacilitiesController{
	
	@Resource(name="facilitiesService")
	IFacilitiesService service;
	
	@Resource(name="publicService")
	IPublicService publicService;
	
	@RequestMapping("/save")
	@ResponseBody
	public JSONObject save(Facilities entity) {	
		entity.setId(EntityIDFactory.createId());		
		int result=publicService.save(entity);
		Map<String,Object> returnObj=new HashMap<String, Object>();
		returnObj.put("type", "success");
		returnObj.put("result", result);
		return JSONObject.fromObject(returnObj);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public JSONObject update(Facilities entity) {				
		int result=service.update(entity);
		Map<String,Object> returnObj=new HashMap<String, Object>();
		returnObj.put("type", "success");
		returnObj.put("result", result);
		return JSONObject.fromObject(returnObj);
	}
	@RequestMapping("/getFacilitiesByHouseid")
	@ResponseBody
	public JSONArray getFacilitiesByHouseid(String houseid) {	
		
		return JSONArray.fromObject(service.getFacilitiesBuHouseid(houseid));
	}
}
