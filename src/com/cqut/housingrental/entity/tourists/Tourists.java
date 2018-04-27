package com.cqut.housingrental.entity.tourists;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class Tourists extends Entity{
	
	@ID
	private String id;
	private String name;
	private String email;
	private String phonenumber;
	private String adress;
	private String is_deal;
	
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
	public String getEmail() {
		return email;
	}	
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}	
	
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAdress() {
		return adress;
	}	
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getIs_deal() {
		return is_deal;
	}	
	
	public void setIs_deal(String is_deal) {
		this.is_deal = is_deal;
	}
	
	@Override
	public String toString() {
		return "Tourists [" +  "id=" + id  + ", " +  "name=" + name  + ", " +  "email=" + email  + ", " +  "phonenumber=" + phonenumber  + ", " +  "adress=" + adress  + ", " +  "is_deal=" + is_deal  + ", "   + "]";
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "tourists";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}
}
