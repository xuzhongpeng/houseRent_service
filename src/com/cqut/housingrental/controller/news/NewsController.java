package com.cqut.housingrental.controller.news;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.housingrental.entity.administrators.Administrators;
import com.cqut.housingrental.entity.news.News;
import com.cqut.housingrental.service.news.INewsService;
import com.cqut.housingrental.service.publicService.IPublicService;
import com.cqut.tool.util.EntityIDFactory;

@Controller
@RequestMapping("/newsController")
public class NewsController{
	
	@Resource(name="newsService")
	INewsService service;
	
	@Resource(name="publicService")
	IPublicService publicService;
	
	
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
	public JSONObject update(News entity) {		
		if(StringUtils.isBlank(entity.getPush_time())){
			entity.setPush_time(null);
		}
		int result=publicService.update(entity,entity.getId());
		Map<String,Object> returnObj=new HashMap<String, Object>();
		returnObj.put("type", "success");
		returnObj.put("result", result);
		return JSONObject.fromObject(returnObj);
	}
	@RequestMapping("/save")
	@ResponseBody
	public JSONObject save(News entity) {	
		//entity.setId(EntityIDFactory.createId());
		if(StringUtils.isBlank(entity.getPush_time())){
			entity.setPush_time(null);
		}
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
			result=publicService.delete(idStrings,News.class);
			returnObj.put("result",result);
		}
		catch(NumberFormatException e){
			returnObj.put("type", "success");
			returnObj.put("result", e);
			
		}	
		
		return JSONObject.fromObject(returnObj);
	}
}
