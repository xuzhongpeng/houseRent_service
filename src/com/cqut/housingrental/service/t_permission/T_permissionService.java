package com.cqut.housingrental.service.t_permission;

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
import com.cqut.housingrental.entity.menu.Menu;
import com.cqut.housingrental.entity.t_permission.T_permission;
import com.cqut.housingrental.entity.user_role.User_role;
import com.cqut.service.base.SearchService;

import com.cqut.tool.treeNode.Node;
import com.cqut.tool.treeNode.NodeList;
import com.cqut.tool.util.EntityIDFactory;

@Service
public class T_permissionService extends SearchService implements IT_permissionService{
	
	@Resource(name="entityDao")
	EntityDao entityDao;
	
	@Resource(name="searchDao")
	SearchDao searchDao;
	
	@Resource(name="baseEntityDao")
	BaseEntityDao baseEntityDao;

	@Override
	public String getBaseEntityName() {
		return "t_permission";
	}

	@Override
	public String getBasePrimaryKey() {
		return "t_permission.id";
	}
	@Override
	public List<T_permission> getRole(String permissionid){
		return entityDao.getByCondition("permission_id="+permissionid,T_permission.class);
	}
	
	@Override
	public Map<String, Object> getWithPaging(int limit, int offset,
			String order, String sort, String searchText) {
		int index = limit;//每行显示条数
		int pageNum = offset ;//页码
		String baseEntity = "t_permission ";//查询的条件和表
		String[] properties = new String[] {"" +
				"t_permission.id," +
				"t_permission.permission_id," +
				"menu.menu_name," +
				"t_permission.name," +
				"permission_number," +
				"t_role.name as roleName"
				
		};//查询的列名
		baseEntity += " LEFT JOIN menu ON menu.id = t_permission.permission_number";
		baseEntity += " LEFT JOIN t_role ON t_role.id = t_permission.permission_id";
		String condition="1=1 ";
		if(StringUtils.isNotBlank(searchText)){
			condition= " and id like '%"+searchText+"%'";
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
	public int update(T_permission t_permission){
		return entityDao.updatePropByID(t_permission, t_permission.getId());
	}
	@Override
	public int save(T_permission t_permission){
		t_permission.setId(EntityIDFactory.createId());
		return entityDao.save(t_permission);
	}
	@Override
	public int delete(String[] IDs){
		return entityDao.deleteEntities(IDs, T_permission.class);
	}
}
