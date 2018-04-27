package com.cqut.housingrental.entity.user_role;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class User_role extends Entity{
	
	@ID
	private String id;
	private String user_id;
	private String role_id;
	
	public String getId() {
		return id;
	}	
	
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}	
	
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getRole_id() {
		return role_id;
	}	
	
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	
	@Override
	public String toString() {
		return "User_role [" +  "id=" + id  + ", " +  "user_id=" + user_id  + ", " +  "role_id=" + role_id  + ", "   + "]";
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "user_role";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}
}
