package com.cqut.housingrental.controller.tourists;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.housingrental.entity.tourists.Tourists;
import com.cqut.housingrental.service.publicService.IPublicService;
import com.cqut.housingrental.service.tourists.ITouristsService;
import com.cqut.tool.util.EntityIDFactory;

@Controller
@RequestMapping("/touristsController")
public class TouristsController{
	
	@Resource(name="touristsService")
	ITouristsService service;
	
	@Resource(name="publicService")
	IPublicService publicService;
	
	@RequestMapping("/getWithPaging")
	@ResponseBody
	public JSONObject getWithPaging(String searchText,int offset,String order,String sort,HttpServletRequest request) {
		Map<String,Object> result=new HashMap<String, Object>();
		result=publicService.getWithPaging(10, offset, order, sort, searchText,"tourists","name");
		try{
			
		}
		catch(Exception e){
			result.put("type","error");
			result.put("error", e);
			
		}
		return JSONObject.fromObject(result);
	}
	@RequestMapping("/update")
	@ResponseBody
	public JSONObject update(Tourists entity) {		
		
		int result=publicService.update(entity,entity.getId());
		Map<String,Object> returnObj=new HashMap<String, Object>();
		returnObj.put("type", "success");
		returnObj.put("result", result);
		return JSONObject.fromObject(returnObj);
	}
	@RequestMapping("/save")
	@ResponseBody
	public JSONObject save(Tourists entity) {	
		entity.setId(EntityIDFactory.createId());
		int result=publicService.save(entity);
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
			result=publicService.delete(idStrings,Tourists.class);
			returnObj.put("result",result);
		}
		catch(NumberFormatException e){
			returnObj.put("type", "success");
			returnObj.put("result", e);
			
		}	
		
		return JSONObject.fromObject(returnObj);
	}
}
