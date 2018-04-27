package com.cqut.housingrental.service.news;

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
public class NewsService extends SearchService implements INewsService{
	
	@Resource(name="entityDao")
	EntityDao entityDao;
	
	@Resource(name="searchDao")
	SearchDao searchDao;
	
	@Resource(name="baseEntityDao")
	BaseEntityDao baseEntityDao;

	@Override
	public String getBaseEntityName() {
		return "news";
	}

	@Override
	public String getBasePrimaryKey() {
		return "news.id";
	}
	
	@Override
	public Map<String, Object> getWithPaging(int limit, int offset,
			String order, String sort, String searchText) {
		int index = limit;//每行显示条数
		int pageNum = offset ;//页码
		String baseEntity = "news";//查询的条件和表
		String[] properties = new String[] {
				"news.id," +
				"news.title," +
				"path as cover_photo_id," +
				"content," +
				"push_time," +
				"push_user_id," +
				"managerName"
		};//查询的列名
		String joinEntity = "LEFT JOIN manager ON news.push_user_id = manager.id " +
				"LEFT JOIN picture ON news.cover_photo_id = picture.id ";
		String condition="1=1 ";
		if(StringUtils.isNotBlank(searchText)){
			condition= "and id like '%"+searchText+"%'";
		}
		//condition += " and fileinformation.uploaderID = '20170220xiji'";
		List<Map<String, Object>> result = entityDao.searchWithpaging(
				properties, baseEntity, joinEntity, null, condition, null,
				order,  sort,index, pageNum);
		for(Map<String,Object> a:result){
			if(a.get("push_time")!=null){
				String reTime=a.get("push_time").toString();
				a.remove("push_time");
				a.put("push_time", reTime);
			}
		}
		int count = entityDao.searchForeign(properties, baseEntity, joinEntity, null, condition).size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", result);
		return map;
	}
}
