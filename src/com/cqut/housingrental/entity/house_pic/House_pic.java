package com.cqut.housingrental.entity.house_pic;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class House_pic extends Entity{
	
	@ID
	private String id;
	private String picturename;
	private String path;
	private String base64;
	private String house_id;
	
	public String getId() {
		return id;
	}	
	
	public void setId(String id) {
		this.id = id;
	}
	public String getPicturename() {
		return picturename;
	}	
	
	public void setPicturename(String picturename) {
		this.picturename = picturename;
	}
	public String getPath() {
		return path;
	}	
	
	public void setPath(String path) {
		this.path = path;
	}
	public String getBase64() {
		return base64;
	}	
	
	public void setBase64(String base64) {
		this.base64 = base64;
	}
	public String getHouse_id() {
		return house_id;
	}	
	
	public void setHouse_id(String house_id) {
		this.house_id = house_id;
	}
	
	@Override
	public String toString() {
		return "House_pic [" +  "id=" + id  + ", " +  "picturename=" + picturename  + ", " +  "path=" + path  + ", " +  "base64=" + base64  + ", " +  "house_id=" + house_id  + ", "   + "]";
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "house_pic";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}
}
