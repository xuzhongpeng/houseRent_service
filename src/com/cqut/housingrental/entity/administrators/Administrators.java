package com.cqut.housingrental.entity.administrators;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class Administrators extends Entity{
	
	@ID
	private String id;
	private String name;
	private String password;
	private String headImg;
	private String registration_time;
	
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
	public String getPassword() {
		return password;
	}	
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHeadImg() {
		return headImg;
	}	
	
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getRegistration_time() {
		return registration_time;
	}	
	
	public void setRegistration_time(String registration_time) {
		this.registration_time = registration_time;
	}
	
	@Override
	public String toString() {
		return "Administrators [" +  "id=" + id  + ", " +  "name=" + name  + ", " +  "password=" + password  + ", " +  "headImg=" + headImg  + ", " +  "registration_time=" + registration_time  + ", "   + "]";
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "administrators";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}
}
