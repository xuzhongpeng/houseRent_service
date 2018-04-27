package com.cqut.housingrental.service.publicService;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.cqut.dao.base.EntityDao;
import com.cqut.dao.base.SearchDao;
import com.cqut.entity.base.Entity;
import com.cqut.housingrental.entity.t_permission.T_permission;
import com.cqut.housingrental.service.t_permission.IT_permissionService;
import com.cqut.service.base.SearchService;
import com.cqut.tool.util.EntityIDFactory;


@Service
public class PublicService extends SearchService implements IPublicService{
	@Override
	public String getBaseEntityName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getBasePrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}
	@Resource(name="entityDao")
	EntityDao entityDao;
	
	@Resource(name="searchDao")
	SearchDao searchDao;
	
	
	@Override
	public Map<String, Object> getWithPaging(int limit, int offset,
			String order, String sort, String searchText,String baseEntity,String SearchField) {
		int index = limit;//每行显示条数
		int pageNum = offset ;//页码
		//String baseEntity = "t_permission";//查询的条件和表
		String[] properties = new String[] {"*"};//查询的列名
		//String joinEntity = " LEFT JOIN fileinformation ON c.fileID = fileinformation.ID   ";
		String condition="";
		if(StringUtils.isNotBlank(searchText)){
			condition= "1=1 and "+SearchField+" like '%"+searchText+"%'";
		}
		//condition += " and fileinformation.uploaderID = '20170220xiji'";
		List<Map<String, Object>> result = entityDao.searchWithpaging(
				properties, baseEntity, null, null, condition, null,
				order,  sort,index, pageNum);
		int count = entityDao.searchForeign(properties, baseEntity, null, null, condition).size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", result);
		return map;
	}
	@Override
	public int update(Entity entity,String id){
		//this.fillter(entity);
		Field[] field = entity.getClass().getDeclaredFields();
		 for(int j=0 ; j<field.length ; j++){
			 String name=field[j].getName();
			 char firstChar=name.charAt(0);
			 char changeChar=Character.toUpperCase(firstChar);
			 String Name=name.replaceFirst(String.valueOf(name.charAt(0)), String.valueOf(changeChar));
			 try{
				 Method m = entity.getClass().getMethod("get"+Name);
				 String value = (String) m.invoke(entity);
				 if(value.equals("undefined")){
					 Method n = entity.getClass().getMethod("set"+Name, new Class[] {String.class});
					 n.invoke(entity,new Object[] {new String("")});
				 }
			 }catch(Exception e){
				 System.out.println(e);
			 }
		 }	
		return entityDao.updatePropByID(entity, id);
	}
	@Override
	public int save(Entity entity){
		this.fillter(entity);
		return entityDao.save(entity);
	}
	@Override
	public  <T extends Entity>  int delete(String[] IDs, Class<T> t){
		return entityDao.deleteEntities(IDs, t);
	}
	
	public Entity fillter(Entity entity){
		Field[] field = entity.getClass().getDeclaredFields();
		 for(int j=0 ; j<field.length ; j++){
			 String name=field[j].getName();
			 char firstChar=name.charAt(0);
			 char changeChar=Character.toUpperCase(firstChar);
			 String Name=name.replaceFirst(String.valueOf(name.charAt(0)), String.valueOf(changeChar));
			 try{
				 Method m = entity.getClass().getMethod("get"+Name);
				 String value = (String) m.invoke(entity);
				 if(value!=null){
					 if(value.equals("undefined")){
						 Method n = entity.getClass().getMethod("set"+Name, new Class[] {String.class});
						 n.invoke(entity,new Object[] {new String("")});
					 }
				 }
			 }catch(Exception e){
				 System.out.println(e);
			 }
		 }		
		return entity;
	}
	@Override
	public <T extends Entity> T getByID(String id, Class<T> t) {
		return entityDao.getByID(id, t);
	}
	
	
}
