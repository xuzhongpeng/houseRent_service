package com.cqut.housingrental.controller.house;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.housingrental.entity.house.House;
import com.cqut.housingrental.service.facilities.IFacilitiesService;
import com.cqut.housingrental.service.house.IHouseService;
import com.cqut.housingrental.service.house_pic.IHouse_picService;
import com.cqut.housingrental.service.publicService.IPublicService;
import com.cqut.housingrental.service.room.IRoomService;
import com.cqut.tool.util.EntityIDFactory;

@Controller
@RequestMapping("/houseController")
public class HouseController{
	
	@Resource(name="houseService")
	IHouseService service;
	
	@Resource(name="house_picService")
	IHouse_picService house_picService;
	
	@Resource(name="roomService")
	IRoomService roomService;
	
	@Resource(name="facilitiesService")
	IFacilitiesService facilitiesService;
		
	@Resource(name="publicService")
	IPublicService publicService;
	
	@RequestMapping("/getWithPaging")
	@ResponseBody
	public JSONObject getWithPaging(String searchText,int offset,String order,String sort,HttpServletRequest request) {
		Map<String,Object> result=new HashMap<String, Object>();
		try{
			result=publicService.getWithPaging(10, offset, order, sort, searchText,"house","houseName");
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
		
			result=publicService.getWithPaging(1000, 0, null, null, null,"house","id");
		
		/*catch(Exception e){
			result.put("type","error");
			result.put("error", e);
			
		}*/
		return JSONObject.fromObject(result);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public JSONObject update(House entity) {
		int result=publicService.update(entity,entity.getId());
		Map<String,Object> returnObj=new HashMap<String, Object>();
		returnObj.put("type", "success");
		returnObj.put("result", result);
		return JSONObject.fromObject(returnObj);
	}
	@RequestMapping("/save")
	@ResponseBody
	public JSONObject save(House entity) {	
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
		int result=0,
			pictureResult=0,
			facilitiesResult=0;
		try{
			result=publicService.delete(idStrings,House.class);//删除房子表
			pictureResult=house_picService.deleteByHouseid(idStrings);//删除关联的照片
			facilitiesResult=facilitiesService.deleteByHouseid(idStrings);//删除房屋配置表
			roomService.deleteByHouseid(idStrings);//删除房子关联的房间表
			returnObj.put("result",result);
			returnObj.put("pictureResult",pictureResult);
			returnObj.put("facilitiesResult",facilitiesResult);
		}
		catch(NumberFormatException e){
			returnObj.put("type", "success");
			returnObj.put("result", e);
			
		}	
		
		return JSONObject.fromObject(returnObj);
	}
	
	@RequestMapping("/getHouseByid")
	@ResponseBody
	public JSONObject getHouseByid(String id) {
		Map<String,Object> map=service.gethouseByid(id);
		
		return JSONObject.fromObject(map);
	}
}
