package com.cqut.housingrental.service.role_permission;

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
import com.cqut.housingrental.entity.role_permission.Role_permission;
import com.cqut.service.base.SearchService;

import com.cqut.tool.treeNode.Node;
import com.cqut.tool.treeNode.NodeList;
import com.cqut.tool.util.EntityIDFactory;

@Service
public class Role_permissionService extends SearchService implements IRole_permissionService{
	
	@Resource(name="entityDao")
	EntityDao entityDao;
	
	@Resource(name="searchDao")
	SearchDao searchDao;
	
	@Resource(name="baseEntityDao")
	BaseEntityDao baseEntityDao;

	@Override
	public String getBaseEntityName() {
		return "role_permission";
	}

	@Override
	public String getBasePrimaryKey() {
		return "role_permission.id";
	}
	
	@Override
	public Role_permission getRole_permissionByRole(String RoleID){
		return entityDao.getByCondition("role_id="+RoleID, Role_permission.class).get(0);
	}
	@Override
	public Map<String, Object> getall() {
		String baseEntity = "role_permission";//查询的条件和表
		String[] properties = new String[] {
				"role_permission.id," +
				"role_permission.role_id,	" +
				"t_role.name as roleName,"+
				"role_permission.permission_id,	" +
				"role_permission.description"
		};//查询的列名
		String joinEntity = "LEFT JOIN t_role ON role_permission.role_id = t_role.id ";
		String condition="";
		
		//condition += " and fileinformation.uploaderID = '20170220xiji'";
		List<Map<String, Object>> result = entityDao.searchForeign(
				properties, baseEntity, joinEntity, null, condition);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", result);
		return map;
	}
	
}
