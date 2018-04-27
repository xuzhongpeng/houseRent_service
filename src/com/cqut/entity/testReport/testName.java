package com.cqut.entity.testReport;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class testName extends Entity{
	@ID
	private String ID;
	private String girlName;
	private String boyName;
	

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getGirlName() {
		return girlName;
	}

	public void setGirlName(String girlName) {
		this.girlName = girlName;
	}

	public String getBoyName() {
		return boyName;
	}

	public void setBoyName(String boyName) {
		this.boyName = boyName;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "testName";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "ID";
	}

	

}

