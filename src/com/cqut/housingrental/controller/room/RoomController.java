package com.cqut.housingrental.controller.room;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.housingrental.entity.news.News;
import com.cqut.housingrental.entity.room.Room;
import com.cqut.housingrental.service.publicService.IPublicService;
import com.cqut.housingrental.service.room.IRoomService;
import com.cqut.tool.util.EntityIDFactory;

@Controller
@RequestMapping("/roomController")
public class RoomController{
	
	@Resource(name="roomService")
	IRoomService service;
	
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
	public JSONObject update(Room entity) {		
		
		int result=publicService.update(entity,entity.getId());
		Map<String,Object> returnObj=new HashMap<String, Object>();
		returnObj.put("type", "success");
		returnObj.put("result", result);
		return JSONObject.fromObject(returnObj);
	}
	@RequestMapping("/save")
	@ResponseBody
	public JSONObject save(Room entity) {	
		//entity.setId(EntityIDFactory.createId());
		
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
			result=publicService.delete(idStrings,Room.class);
			returnObj.put("result",result);
		}
		catch(NumberFormatException e){
			returnObj.put("type", "success");
			returnObj.put("result", e);
			
		}	
		
		return JSONObject.fromObject(returnObj);
	}
	@RequestMapping("/getRoomInfo")
	@ResponseBody
	public JSONObject getRoomInfo(String houseid) {
		Map<String,Object> result=new HashMap<String, Object>();
		/*try{*/
			result=service.getRoomInfo(houseid);
		/*}
		catch(Exception e){
			result.put("type","error");
			result.put("error", e);
			
		}*/
		
		return JSONObject.fromObject(result);		
	}
	
	@RequestMapping("/getRoomInfoByID")
	@ResponseBody
	public JSONObject getRoomInfoByID(String roomid) {
		Map<String,Object> a=service.getRoomInfoByID(roomid);
		return JSONObject.fromObject(a);
	}
	
	@RequestMapping("/getInfoByID")
	@ResponseBody
	public JSONObject getInfoByID(String roomid) {
		Map<String,Object> a=service.getInfoByID(roomid);
		return JSONObject.fromObject(a);
	}
	
	
}
