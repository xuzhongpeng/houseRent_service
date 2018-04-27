package com.cqut.housingrental.service.administrators;

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
import com.cqut.entity.testReport.testName;
import com.cqut.housingrental.entity.administrators.Administrators;
import com.cqut.service.base.SearchService;

import com.cqut.tool.treeNode.Node;
import com.cqut.tool.treeNode.NodeList;
import com.cqut.tool.util.EntityIDFactory;

@Service
public class AdministratorsService extends SearchService implements IAdministratorsService{
	
	@Resource(name="entityDao")
	EntityDao entityDao;
	
	@Resource(name="searchDao")
	SearchDao searchDao;
	
	@Resource(name="baseEntityDao")
	BaseEntityDao baseEntityDao;

	@Override
	public String getBaseEntityName() {
		return "administrators";
	}

	@Override
	public String getBasePrimaryKey() {
		return "administrators.id";
	}
	@Override
	public List<Map<String, Object>>  getAdmin(String userName,String password) {
		String baseEntity = "administrators";//查询的条件和表
		String[] properties = new String[] {
				"administrators.id," +
				"administrators.name,	" +
				"administrators.password,	" +
				"picture.path AS headImg," +
				"administrators.registration_time"
		};//查询的列名
		String joinEntity = "LEFT JOIN picture ON administrators.headImg = picture.id ";
		String condition = "name='"+userName+"' and password='" +password+"'";
		String managerBaseEntity = "manager";//查询的条件和表
		String[] managerProperties=new String[]{
				"manager.id," +
				"manager.managerNo," +
				"manager.managerName as name," +
				"manager.phonenumber," +
				"manager.email," +
				"manager.adress," +
				"manager.is_used," +
				"manager.is_admin," +
				"manager.password," +
				"extended," +
				"picture.path AS headImg"
		};
		String managerJoinEntity = "LEFT JOIN picture ON manager.extended = picture.id ";
		String condition1 = "managerNo='"+userName+"' and password='" +password+"'";
		List<Map<String, Object>> result=entityDao.searchForeign(properties, baseEntity, joinEntity, null, condition);
		if(result.size()==0){
			result=entityDao.searchForeign(managerProperties, managerBaseEntity, managerJoinEntity, null,condition1 );
		}
		for(Map<String,Object> a:result){
			if(a.get("registration_time")!=null){
				String reTime=a.get("registration_time").toString();
				a.remove("registration_time");
				a.put("registration_time", reTime);
			}
		}
		return result;
	}
	@Override
	public Map<String, Object> getWithPaging(int limit, int offset,
			String order, String sort, String searchText) {
		int index = limit;//每行显示条数
		int pageNum = offset ;//页码
		String baseEntity = "administrators";//查询的条件和表
		String[] properties = new String[] {
				"administrators.id," +
				"administrators.name,	" +
				"administrators.password,	" +
				"picture.path AS headImg," +
				"administrators.registration_time"
		};//查询的列名
		String joinEntity = "LEFT JOIN picture ON administrators.headImg = picture.id ";
		String condition="";
		if(StringUtils.isNotBlank(searchText)){
			condition= "1=1 and id like '%"+searchText+"%'";
		}
		//condition += " and fileinformation.uploaderID = '20170220xiji'";
		List<Map<String, Object>> result = entityDao.searchWithpaging(
				properties, baseEntity, joinEntity, null, condition, null,
				order,  sort,index, pageNum);
		for(Map<String,Object> a:result){
			if(a.get("registration_time")!=null){
				String reTime=a.get("registration_time").toString();
				a.remove("registration_time");
				a.put("registration_time", reTime);
			}
		}
		int count = entityDao.searchForeign(properties, baseEntity, joinEntity, null, condition).size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", result);
		return map;
	}
	@Override
	public int update(Administrators entity){
		return entityDao.updatePropByID(entity, entity.getId());
	}
	@Override
	public int save(Administrators entity){
		entity.setId(EntityIDFactory.createId());
		return entityDao.save(entity);
	}
	@Override
	public int delete(String[] IDs){
		return entityDao.deleteEntities(IDs, Administrators.class);
	}
	
}
