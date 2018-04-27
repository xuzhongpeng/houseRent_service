package com.cqut.housingrental.service.administrators;

import java.util.List;
import java.util.Map;

import com.cqut.housingrental.entity.administrators.Administrators;

public interface IAdministratorsService {

	List<Map<String, Object>> getAdmin(String userName,String password);

	Map<String, Object> getWithPaging(int i, int offset, String order,
			String sort, String searchText);

	int update(Administrators entity);

	int save(Administrators entity);

	int delete(String[] idStrings);
	
}
