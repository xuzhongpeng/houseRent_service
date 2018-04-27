package com.cqut.service.testReport;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.cqut.dao.base.BaseEntityDao;
import com.cqut.dao.base.EntityDao;
import com.cqut.dao.base.SearchDao;
import com.cqut.entity.testReport.TestReport;
import com.cqut.entity.testReport.fangke;
import com.cqut.entity.testReport.testName;
import com.cqut.service.base.SearchService;
import com.cqut.tool.util.EntityIDFactory;
import com.cqut.tool.util.PropertiesTool;

@Service
public class TestReportService extends SearchService implements
		ITestReportService {

	@Resource(name = "entityDao")
	EntityDao entityDao;

	@Resource(name = "searchDao")
	SearchDao searchDao;

	@Resource(name = "baseEntityDao")
	BaseEntityDao baseEntityDao;
	
	
	@Override
	public String getBaseEntityName() {
		return "testReport";
	}

	@Override
	public String getBasePrimaryKey() {
		return "testReport.ID";
	}

	@Override
	public Map<String, Object> getTestReportWithPaging(int limit, int offset,
			String order, String sort, String name) {
		int index = limit;
		int pageNum = offset / limit ;
		String baseEntity = "user";//查询的条件和表
		String[] properties = new String[] {"*"};//查询的列名

		//String joinEntity = " LEFT JOIN fileinformation ON c.fileID = fileinformation.ID   ";
		String condition = "";
		
		
		//condition += " and fileinformation.uploaderID = '20170220xiji'";
		List<Map<String, Object>> result = entityDao.searchWithpaging(
				properties, baseEntity, null, null, condition, null, sort,
				order, index, pageNum);
		int count = entityDao.searchForeign(properties, baseEntity, null, null, condition).size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", result);
		return map;
	}
	@Override
	public int SaveIP(String ip,String host){
		fangke fangke=new fangke();
		fangke.setIp(ip);
		fangke.setHost(host);
		int result = entityDao.save(fangke);
		int count=entityDao.getCountByCondition(null,fangke.class);
		return count;
	}
	@Override
	public int SaveName(String girlName,String boyName){
		testName testName=new testName();
		testName.setGirlName(girlName);
		testName.setBoyName(boyName);
		int result = entityDao.save(testName);
		return result;
	}

}
