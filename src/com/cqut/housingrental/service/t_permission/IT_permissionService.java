package com.cqut.housingrental.service.t_permission;

import java.util.List;
import java.util.Map;

import com.cqut.housingrental.entity.t_permission.T_permission;

public interface IT_permissionService {

	List<T_permission> getRole(String permissionid);

	Map<String, Object> getWithPaging(int limit, int offset, String order,
			String sort, String searchText);

	int update(T_permission t_permission);

	int save(T_permission t_permission);

	int delete(String[] IDs);
	
}
