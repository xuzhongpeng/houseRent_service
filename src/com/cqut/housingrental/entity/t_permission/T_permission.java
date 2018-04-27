package com.cqut.housingrental.entity.t_permission;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class T_permission extends Entity{
	
	@ID
	private String id;
	private String name;
	private String permission_number;
	private String description;
	private String permission_id;
	public String getId() {
		return id;
	}	
	
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getPermission_number() {
		return permission_number;
	}	
	
	public void setPermission_number(String permission_number) {
		this.permission_number = permission_number;
	}
	public String getDescription() {
		return description;
	}	
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "T_permission [" +  "id=" + id  + ", " +  "name=" + name  + ", " +  "permission_number=" + permission_number  + ", " +  "description=" + description  + ", "   +"permission_id=" + permission_id  + ", "   + "]";
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "t_permission";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}

	public String getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(String permission_id) {
		this.permission_id = permission_id;
	}
}
