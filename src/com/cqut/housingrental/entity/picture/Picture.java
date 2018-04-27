package com.cqut.housingrental.entity.picture;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class Picture extends Entity{
	
	@ID
	private String id;
	private String path;
	private String discription;
	
	public String getId() {
		return id;
	}	
	
	public void setId(String id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}	
	
	public void setPath(String path) {
		this.path = path;
	}
	public String getDiscription() {
		return discription;
	}	
	
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	@Override
	public String toString() {
		return "Picture [" +  "id=" + id  + ", " +  "path=" + path  + ", " +  "discription=" + discription  + ", "   + "]";
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "picture";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}
}
