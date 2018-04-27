package com.cqut.housingrental.entity.transaction;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class Transaction extends Entity{
	
	@ID
	private String id;
	private String tenant_id;
	private String deposit;
	private String rentnumber;
	private String rentingTimeType;
	
	public String getId() {
		return id;
	}	
	
	public void setId(String id) {
		this.id = id;
	}
	public String getTenant_id() {
		return tenant_id;
	}	
	
	public void setTenant_id(String tenant_id) {
		this.tenant_id = tenant_id;
	}
	public String getDeposit() {
		return deposit;
	}	
	
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getRentnumber() {
		return rentnumber;
	}	
	
	public void setRentnumber(String rentnumber) {
		this.rentnumber = rentnumber;
	}
	public String getRentingTimeType() {
		return rentingTimeType;
	}	
	
	public void setRentingTimeType(String rentingTimeType) {
		this.rentingTimeType = rentingTimeType;
	}
	
	@Override
	public String toString() {
		return "Transaction [" +  "id=" + id  + ", " +  "tenant_id=" + tenant_id  + ", " +  "deposit=" + deposit  + ", " +  "rentnumber=" + rentnumber  + ", " +  "rentingTimeType=" + rentingTimeType  + ", "   + "]";
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "transaction";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}
}
