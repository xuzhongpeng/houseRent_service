package com.cqut.housingrental.service.role_permission;

import java.util.Map;

import com.cqut.housingrental.entity.role_permission.Role_permission;

public interface IRole_permissionService {

	Role_permission getRole_permissionByRole(String RoleID);

	Map<String, Object> getall();
	
}
