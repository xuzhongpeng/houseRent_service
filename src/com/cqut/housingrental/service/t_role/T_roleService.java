package com.cqut.housingrental.service.t_role;

import javax.annotation.Resource;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import com.cqut.dao.base.BaseEntityDao;
import com.cqut.dao.base.EntityDao;
import com.cqut.dao.base.SearchDao;
import com.cqut.housingrental.entity.administrators.Administrators;
import com.cqut.housingrental.entity.t_role.T_role;
import com.cqut.service.base.SearchService;

import com.cqut.tool.treeNode.Node;
import com.cqut.tool.treeNode.NodeList;
import com.cqut.tool.util.EntityIDFactory;
@Service
public class T_roleService extends SearchService implements IT_roleService{
	
	@Resource(name="entityDao")
	EntityDao entityDao;
	
	@Resource(name="searchDao")
	SearchDao searchDao;
	
	@Resource(name="baseEntityDao")
	BaseEntityDao baseEntityDao;

	@Override
	public String getBaseEntityName() {
		return "t_role";
	}

	@Override
	public String getBasePrimaryKey() {
		return "t_role.id";
	}
	@Override
	public T_role getinfobyId(String id) {
		return entityDao.getByID(id, T_role.class);
	}
}
