package com.cqut.housingrental.entity.landlord;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;
public class Landlord  extends Entity{

	@ID
	private String id;
	private String phonenumber;
	private String password;
	private String name;
	private String address;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Landlord [id=" + id + ", phonenumber=" + phonenumber
				+ ", password=" + password + ", name=" + name + ", address="
				+ address + "]";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "landlord";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}

}
