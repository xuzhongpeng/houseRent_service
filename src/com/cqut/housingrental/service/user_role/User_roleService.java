package com.cqut.housingrental.service.user_role;

import java.util.List;

import javax.annotation.Resource;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import com.cqut.dao.base.BaseEntityDao;
import com.cqut.dao.base.EntityDao;
import com.cqut.dao.base.SearchDao;
import com.cqut.housingrental.entity.administrators.Administrators;
import com.cqut.housingrental.entity.user_role.User_role;
import com.cqut.service.base.SearchService;

import com.cqut.tool.treeNode.Node;
import com.cqut.tool.treeNode.NodeList;
import com.cqut.tool.util.EntityIDFactory;

@Service
public class User_roleService extends SearchService implements IUser_roleService{
	
	@Resource(name="entityDao")
	EntityDao entityDao;
	
	@Resource(name="searchDao")
	SearchDao searchDao;
	
	@Resource(name="baseEntityDao")
	BaseEntityDao baseEntityDao;

	@Override
	public String getBaseEntityName() {
		return "user_role";
	}

	@Override
	public String getBasePrimaryKey() {
		return "user_role.id";
	}
	@Override
	public List<User_role> getRole(String userid){
		return entityDao.getByCondition("user_id="+userid,User_role.class);
	}
	
}
