package com.cqut.housingrental.controller.tenant;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.housingrental.entity.tenant.Tenant;
import com.cqut.housingrental.service.publicService.IPublicService;
import com.cqut.housingrental.service.tenant.ITenantService;
import com.cqut.tool.util.EntityIDFactory;

@Controller
@RequestMapping("/tenantController")
public class TenantController{
	
	@Resource(name="tenantService")
	ITenantService service;
	
	@Resource(name="publicService")
	IPublicService publicService;
	
	@RequestMapping("/getWithPaging")
	@ResponseBody
	public JSONObject getWithPaging(String searchText,int offset,String order,String sort,HttpServletRequest request) {
		Map<String,Object> result=new HashMap<String, Object>();
		result=service.getWithPaging(10, offset, order, sort, searchText);
		try{
			
		}
		catch(Exception e){
			result.put("type","error");
			result.put("error", e);
			
		}
		return JSONObject.fromObject(result);
	}
	@RequestMapping("/getall")
	@ResponseBody
	public JSONObject getall(HttpServletRequest request) {
		Map<String,Object> result=new HashMap<String, Object>();
		
			result=publicService.getWithPaging(1000, 0, null, null, null,"tenant","id");
		
		/*catch(Exception e){
			result.put("type","error");
			result.put("error", e);
			
		}*/
		return JSONObject.fromObject(result);
	}
	@RequestMapping("/update")
	@ResponseBody
	public JSONObject update(Tenant entity) {		
		
		int result=publicService.update(entity,entity.getId());
		Map<String,Object> returnObj=new HashMap<String, Object>();
		returnObj.put("type", "success");
		returnObj.put("result", result);
		return JSONObject.fromObject(returnObj);
	}
	@RequestMapping("/save")
	@ResponseBody
	public JSONObject save(Tenant entity) {	
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
			result=publicService.delete(idStrings,Tenant.class);
			returnObj.put("result",result);
		}
		catch(NumberFormatException e){
			returnObj.put("type", "success");
			returnObj.put("result", e);
			
		}	
		
		return JSONObject.fromObject(returnObj);
	}
}
