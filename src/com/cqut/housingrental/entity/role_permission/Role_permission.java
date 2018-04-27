package com.cqut.housingrental.entity.role_permission;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class Role_permission extends Entity{
	
	@ID
	private String id;
	private String role_id;
	private String permission_id;
	private String description;
	
	public String getId() {
		return id;
	}	
	
	public void setId(String id) {
		this.id = id;
	}
	public String getRole_id() {
		return role_id;
	}	
	
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getPermission_id() {
		return permission_id;
	}	
	
	public void setPermission_id(String permission_id) {
		this.permission_id = permission_id;
	}
	public String getDescription() {
		return description;
	}	
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Role_permission [" +  "id=" + id  + ", " +  "role_id=" + role_id  + ", " +  "permission_id=" + permission_id  + ", " +  "description=" + description  + ", "   + "]";
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "role_permission";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}
}
