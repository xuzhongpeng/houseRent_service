package com.cqut.housingrental.service.house_pic;

import java.util.List;

import javax.annotation.Resource;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import com.cqut.dao.base.BaseEntityDao;
import com.cqut.dao.base.EntityDao;
import com.cqut.dao.base.SearchDao;
import com.cqut.housingrental.entity.administrators.Administrators;
import com.cqut.housingrental.entity.house_pic.House_pic;
import com.cqut.service.base.SearchService;

import com.cqut.tool.treeNode.Node;
import com.cqut.tool.treeNode.NodeList;
import com.cqut.tool.util.EntityIDFactory;

@Service
public class House_picService extends SearchService implements IHouse_picService{
	
	@Resource(name="entityDao")
	EntityDao entityDao;
	
	@Resource(name="searchDao")
	SearchDao searchDao;
	
	@Resource(name="baseEntityDao")
	BaseEntityDao baseEntityDao;

	@Override
	public String getBaseEntityName() {
		return "house_pic";
	}

	@Override
	public String getBasePrimaryKey() {
		return "house_pic.id";
	}

	@Override
	public void save(House_pic pic) {
		// TODO Auto-generated method stub
		entityDao.save(pic);
	}
	
	@Override
	public List<House_pic> getbyid(String id) {
		return entityDao.getByCondition(" house_id ='"+id+"'",  House_pic.class);
	
	}
	@Override
	public int deleteByHouseid(String[] houseid){
		String ids="";
		for(int i=0;i<houseid.length;i++){
			ids+="'"+houseid[i]+"',";
		}
		ids=ids.substring(0, ids.length()-1);
		return entityDao.deleteByCondition(" house_id in ( "+ids+")", House_pic.class);
	}
}
