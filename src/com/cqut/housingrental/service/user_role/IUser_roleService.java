package com.cqut.housingrental.service.user_role;

import java.util.List;

import com.cqut.housingrental.entity.user_role.User_role;

public interface IUser_roleService {

	List<User_role> getRole(String userid);
	
}
