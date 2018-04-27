package com.cqut.housingrental.service.facilities;

import java.util.List;

import javax.annotation.Resource;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import com.cqut.dao.base.BaseEntityDao;
import com.cqut.dao.base.EntityDao;
import com.cqut.dao.base.SearchDao;
import com.cqut.housingrental.entity.administrators.Administrators;
import com.cqut.housingrental.entity.facilities.Facilities;
import com.cqut.housingrental.entity.house_pic.House_pic;
import com.cqut.service.base.SearchService;

import com.cqut.tool.treeNode.Node;
import com.cqut.tool.treeNode.NodeList;
import com.cqut.tool.util.EntityIDFactory;

@Service
public class FacilitiesService extends SearchService implements IFacilitiesService{
	
	@Resource(name="entityDao")
	EntityDao entityDao;
	
	@Resource(name="searchDao")
	SearchDao searchDao;
	
	@Resource(name="baseEntityDao")
	BaseEntityDao baseEntityDao;

	@Override
	public String getBaseEntityName() {
		return "facilities";
	}

	@Override
	public String getBasePrimaryKey() {
		return "facilities.id";
	}
	@Override
	public int update(Facilities entity){		
		int count=entityDao.getCountByCondition("house_id='"+entity.getHouse_id()+"'", Facilities.class);
		if(count>0)
			return entityDao.updatePropByCondition(entity, "house_id='"+entity.getHouse_id()+"'");	
		else{
			return entityDao.save(entity);
		}
	}
	@Override
	public int deleteByHouseid(String[] houseid){
		String ids="";
		for(int i=0;i<houseid.length;i++){
			ids+="'"+houseid[i]+"',";
		}
		ids=ids.substring(0, ids.length()-1);
		return entityDao.deleteByCondition(" house_id in ( "+ids+")", Facilities.class);
	}

	@Override
	public List<Facilities> getFacilitiesBuHouseid(String houseid) {
		List<Facilities> result=entityDao.getByCondition("house_id='"+houseid+"'", Facilities.class);
		return result;
	}
}
