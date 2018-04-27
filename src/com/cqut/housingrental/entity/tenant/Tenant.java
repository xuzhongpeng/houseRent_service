package com.cqut.housingrental.entity.tenant;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class Tenant extends Entity{
	
	@ID
	private String id;
	private String room_id;
	private String tenantNo;
	private String tenantName;
	private String phonenumber;
	private String adress;
	private String headImg;
	private String is_used;
	private String password;
	
	public String getId() {
		return id;
	}	
	
	public void setId(String id) {
		this.id = id;
	}
	public String getRoom_id() {
		return room_id;
	}	
	
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getTenantNo() {
		return tenantNo;
	}	
	
	public void setTenantNo(String tenantNo) {
		this.tenantNo = tenantNo;
	}
	public String getTenantName() {
		return tenantName;
	}	
	
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
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
	public String getHeadImg() {
		return headImg;
	}	
	
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getIs_used() {
		return is_used;
	}	
	
	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	
	@Override
	public String toString() {
		return "Tenant [" +  "id=" + id  + ", " +  "room_id=" + room_id  + ", " +  "tenantNo=" + tenantNo  + ", " +  "tenantName=" + tenantName  + ", " +  "phonenumber=" + phonenumber  + ", " +  "adress=" + adress  + ", " +  "headImg=" + headImg  + ", " +  "is_used=" + is_used  + ", " + "password=" + password  + ", "   + "]";
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "tenant";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
