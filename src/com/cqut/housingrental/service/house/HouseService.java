package com.cqut.housingrental.service.house;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.cqut.dao.base.BaseEntityDao;
import com.cqut.dao.base.EntityDao;
import com.cqut.dao.base.SearchDao;
import com.cqut.housingrental.entity.administrators.Administrators;
import com.cqut.housingrental.entity.house.House;
import com.cqut.housingrental.entity.house_pic.House_pic;
import com.cqut.housingrental.entity.manager.Manager;
import com.cqut.housingrental.entity.picture.Picture;
import com.cqut.housingrental.entity.room.Room;
import com.cqut.service.base.SearchService;

import com.cqut.tool.treeNode.Node;
import com.cqut.tool.treeNode.NodeList;
import com.cqut.tool.util.EntityIDFactory;

@Service
public class HouseService extends SearchService implements IHouseService{
	
	@Resource(name="entityDao")
	EntityDao entityDao;
	
	@Resource(name="searchDao")
	SearchDao searchDao;
	
	@Resource(name="baseEntityDao")
	BaseEntityDao baseEntityDao;

	@Override
	public String getBaseEntityName() {
		return "house";
	}

	@Override
	public String getBasePrimaryKey() {
		return "house.id";
	}
	
	@Override
	public Map<String,Object> gethouseByid(String id){
		House house=entityDao.getByID(id, House.class);
		
		List<Room> room=entityDao.getByCondition("to_houseid = '"+id+"'", Room.class);
		String picCondition="house_id in (''";
		for(int n=0;n<room.size();n++){
			String roomid=room.get(n).getId();
			picCondition+=",'"+roomid+"'";
		}
		picCondition+=")";
		List<House_pic> pic=entityDao.getByCondition(picCondition, House_pic.class);
		Manager manager=null;
		float average=0;
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			manager=entityDao.getByID(house.getTo_manager(), Manager.class);			
			if(room.size()!=0){
				average=Float.parseFloat(room.get(0).getRent());
				for(int i=1;i<room.size();i++){
					average=(average+Float.parseFloat(room.get(i).getRent()))/2;
				}
			}
			map.put("housePic", pic);
			map.put("averageRent", average);
			map.put("manager", manager);
			map.put("house", house);
			return map;
		}
		catch(Exception e){
			 map.put("error", e.toString());
			 return map;
		}
	}
	
	
}
