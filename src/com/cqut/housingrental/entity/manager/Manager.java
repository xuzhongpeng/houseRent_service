package com.cqut.housingrental.entity.manager;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class Manager extends Entity{
	
	@ID
	private String id;
	private String managerNo;
	private String managerName;
	private String phonenumber;
	private String email;
	private String adress;
	private String is_used;
	private String is_admin;
	private String password;
	private String extended;
	
	public String getId() {
		return id;
	}	
	
	public void setId(String id) {
		this.id = id;
	}
	public String getManagerNo() {
		return managerNo;
	}	
	
	public void setManagerNo(String managerNo) {
		this.managerNo = managerNo;
	}
	public String getManagerName() {
		return managerName;
	}	
	
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getPhonenumber() {
		return phonenumber;
	}	
	
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}	
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdress() {
		return adress;
	}	
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getIs_used() {
		return is_used;
	}	
	
	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	public String getIs_admin() {
		return is_admin;
	}	
	
	public void setIs_admin(String is_admin) {
		this.is_admin = is_admin;
	}
	public String getPassword() {
		return password;
	}	
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getExtended() {
		return extended;
	}	
	
	public void setExtended(String extended) {
		this.extended = extended;
	}
	
	@Override
	public String toString() {
		return "Manager [" +  "id=" + id  + ", " +  "managerNo=" + managerNo  + ", " +  "managerName=" + managerName  + ", " +  "phonenumber=" + phonenumber  + ", " +  "email=" + email  + ", " +  "adress=" + adress  + ", " +  "is_used=" + is_used  + ", " +  "is_admin=" + is_admin  + ", " +  "password=" + password  + ", " +  "extended=" + extended  + ", "   + "]";
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "manager";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}
}
