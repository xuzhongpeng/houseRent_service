package com.cqut.housingrental.service.tenant;

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
import com.cqut.service.base.SearchService;

import com.cqut.tool.treeNode.Node;
import com.cqut.tool.treeNode.NodeList;
import com.cqut.tool.util.EntityIDFactory;

@Service
public class TenantService extends SearchService implements ITenantService{
	
	@Resource(name="entityDao")
	EntityDao entityDao;
	
	@Resource(name="searchDao")
	SearchDao searchDao;
	
	@Resource(name="baseEntityDao")
	BaseEntityDao baseEntityDao;

	@Override
	public String getBaseEntityName() {
		return "tenant";
	}

	@Override
	public String getBasePrimaryKey() {
		return "tenant.id";
	}

	@Override
	public Map<String, Object> getWithPaging(int limit, int offset, String order,
			String sort, String searchText) {
			int index = limit;//每行显示条数
			int pageNum = offset ;//页码
			String baseEntity = "tenant";//查询的条件和表
			String[] properties = new String[] {
					"tenant.id," +
					"tenant.room_id,	" +
					"tenant.tenantNo,	" +
					"tenant.password," +
					"tenant.tenantNo," +
					"tenant.tenantName," +
					"tenant.phonenumber," +
					"adress," +
					"picture.path AS headImg," +
					"is_used"
			};//查询的列名
			String joinEntity = "LEFT JOIN picture ON tenant.headImg = picture.id ";
			String condition="";
			if(StringUtils.isNotBlank(searchText)){
				condition= "1=1 and room_id like '%"+searchText+"%'";
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
	
}
