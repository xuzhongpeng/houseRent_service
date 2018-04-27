package com.cqut.housingrental.service.tenant;

import java.util.Map;

import com.cqut.housingrental.entity.tenant.Tenant;

public interface ITenantService {

	Map<String, Object> getWithPaging(int i, int offset, String order,
			String sort, String searchText);
	
}
