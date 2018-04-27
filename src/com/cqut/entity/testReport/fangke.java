package com.cqut.entity.testReport;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class fangke extends Entity{
	@ID
	private String ID;
	private String ip;
	private String host;
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "fangke";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "ID";
	}

	

}
