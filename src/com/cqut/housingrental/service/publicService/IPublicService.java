package com.cqut.housingrental.service.publicService;

import java.util.List;
import java.util.Map;

import com.cqut.entity.base.Entity;
import com.cqut.housingrental.entity.manager.Manager;
import com.cqut.housingrental.entity.picture.Picture;
import com.cqut.housingrental.entity.t_permission.T_permission;

public interface IPublicService {
	int save(Entity entity);

	int update(Entity entity, String id);

	<T extends Entity> int delete(String[] IDs, Class<T> t);

	Map<String, Object> getWithPaging(int limit, int offset, String order,
			String sort, String searchText, String baseEntity,
			String SearchField);

	<T extends Entity> T getByID(String id, Class<T> t);

	
	
}
