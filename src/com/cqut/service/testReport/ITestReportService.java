package com.cqut.service.testReport;

import java.util.List;
import java.util.Map;

public interface ITestReportService {
	public Map<String, Object> getTestReportWithPaging(int limit, int offset,
			String order, String sort, String name);

	public int SaveIP(String ip,String host);

	public int SaveName(String girlName, String boyName);
	
}
