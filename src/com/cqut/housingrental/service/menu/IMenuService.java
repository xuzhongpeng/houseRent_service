package com.cqut.housingrental.service.menu;

import java.util.Map;

import com.cqut.housingrental.entity.menu.Menu;
import com.cqut.housingrental.entity.menu.MenuTool;

public interface IMenuService {

	Map<String,Object> getMenuList(String userid);

	Map<String, Object> getMenuWithPaging(int limit, int offset,
			String order, String sort, String searchText);

	int update(Menu menu);

	int save(Menu menu);

	int delete(String[] IDs);
	
}
