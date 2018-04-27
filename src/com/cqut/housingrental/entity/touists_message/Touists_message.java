package com.cqut.housingrental.entity.touists_message;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class Touists_message extends Entity{
	
	@ID
	private String id;
	private String tourists_id;
	private String content;
	private String is_deal;
	private String deal_manager;
	
	public String getId() {
		return id;
	}	
	
	public void setId(String id) {
		this.id = id;
	}
	public String getTourists_id() {
		return tourists_id;
	}	
	
	public void setTourists_id(String tourists_id) {
		this.tourists_id = tourists_id;
	}
	public String getContent() {
		return content;
	}	
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getIs_deal() {
		return is_deal;
	}	
	
	public void setIs_deal(String is_deal) {
		this.is_deal = is_deal;
	}
	public String getDeal_manager() {
		return deal_manager;
	}	
	
	public void setDeal_manager(String deal_manager) {
		this.deal_manager = deal_manager;
	}
	
	@Override
	public String toString() {
		return "Touists_message [" +  "id=" + id  + ", " +  "tourists_id=" + tourists_id  + ", " +  "content=" + content  + ", " +  "is_deal=" + is_deal  + ", " +  "deal_manager=" + deal_manager  + ", "   + "]";
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "touists_message";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}
}
