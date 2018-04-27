package com.cqut.housingrental.service.room;

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
import com.cqut.housingrental.entity.room.Room;
import com.cqut.service.base.SearchService;

import com.cqut.tool.treeNode.Node;
import com.cqut.tool.treeNode.NodeList;
import com.cqut.tool.util.EntityIDFactory;

@Service
public class RoomService extends SearchService implements IRoomService{
	
	@Resource(name="entityDao")
	EntityDao entityDao;
	
	@Resource(name="searchDao")
	SearchDao searchDao;
	
	@Resource(name="baseEntityDao")
	BaseEntityDao baseEntityDao;

	@Override
	public String getBaseEntityName() {
		return "room";
	}

	@Override
	public String getBasePrimaryKey() {
		return "room.id";
	}
	@Override
	public Map<String, Object> getWithPaging(int limit, int offset,
			String order, String sort, String searchText) {
		int index = limit;//每行显示条数
		int pageNum = offset ;//页码
		String baseEntity = "room";//查询的条件和表
		String[] properties = new String[] {
				"room.id," +
				"roomNo," +
				"to_houseid," +
				"house.houseName," +
				"to_tenant," +
				"tenant.tenantName," +
				"house.houseAdress as address," +
				"rent," +
				"size," +
				"status," +
				"house_type," +
				"has_WC" 
		};//查询的列名
		String joinEntity = "LEFT JOIN house ON room.to_houseid = house.id " +
				"LEFT JOIN tenant on tenant.id=room.to_tenant " ;
		String condition="1=1 ";
		if(StringUtils.isNotBlank(searchText)&&!searchText.equals("undefined")){
			condition= "and houseName like '%"+searchText+"%' or houseAdress like '%"+searchText+"%'";
		}
		//condition += " and fileinformation.uploaderID = '20170220xiji'";
		List<Map<String, Object>> result = entityDao.searchWithpaging(
				properties, baseEntity, joinEntity, null, condition, null,
				order,  sort,index, pageNum);
		
		int count = entityDao.searchForeign(properties, baseEntity, joinEntity, null, condition).size();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", result);
		return map;
	}
	@Override
	public int deleteByHouseid(String[] houseid){
		String ids="";
		for(int i=0;i<houseid.length;i++){
			ids+="'"+houseid[i]+"',";
		}
		ids=ids.substring(0, ids.length()-1);
		return entityDao.deleteByCondition(" to_houseid in ( "+ids+")", Room.class);
	}
	
	@Override
	public Map<String, Object> getRoomInfo(String houseid) {
		String baseEntity = "room";//查询的条件和表
		String[] properties = new String[] {
				"*,"+
				"path" 
		};//查询的列名
		String joinEntity = "LEFT JOIN " +
				"(SELECT	" +
				"tenant.id AS to_tenant,	" +
				"picture.path AS path " +
				"FROM tenant " +
				"LEFT JOIN picture ON tenant.headImg = picture.id) as a " +
				"on a.to_tenant=room.to_tenant" ;
		String condition="1=1 ";
		if(StringUtils.isNotBlank(houseid)){
			condition= "and to_houseid = '"+houseid+"'";
		}
		//condition += " and fileinformation.uploaderID = '20170220xiji'";
		List<Map<String, Object>> result = entityDao.searchForeign(
				properties, baseEntity, joinEntity, null, condition);
		
		int count = entityDao.searchForeign(properties, baseEntity, joinEntity, null, condition).size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", result);
		return map;
	}
	
	@Override
	public Map<String, Object> getRoomInfoByID(String roomid) {
		String baseEntity = "room";//查询的条件和表
		String[] properties = new String[] {
				"*,"+
				"path" 
		};//查询的列名
		String joinEntity = "LEFT JOIN " +
				"(SELECT	" +
				"tenant.id AS to_tenant,	" +
				"picture.path AS path " +
				"FROM tenant " +
				"LEFT JOIN picture ON tenant.headImg = picture.id) as a " +
				"on a.to_tenant=room.to_tenant" ;
		String condition="1=1 ";
		
		condition= "and id = '"+roomid+"'";
		
		//condition += " and fileinformation.uploaderID = '20170220xiji'";
		List<Map<String, Object>> result = entityDao.searchForeign(
				properties, baseEntity, joinEntity, null, condition);
		
		int count = result.size();
		Map<String, Object> map = new HashMap<String, Object>();
		if(count==1){
			map.put("rows", result.get(0));
		}
		else{
			map.put("error", "no information");
		}
		return map;
	}
	@Override
	public Map<String, Object> getInfoByID(String roomid) {
		Room room=entityDao.getByID(roomid,Room.class);
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(room.getId())){	
			House house=entityDao.getByID(room.getTo_houseid(), House.class);
			Manager manager=entityDao.getByID(house.getTo_manager(), Manager.class);
			map.put("room", room);
			map.put("house", house);
			map.put("manager", manager);
			return map;
		}
		else{
			map.put("error", "no information");
			return map;
		}
		
	}
	
	
}
