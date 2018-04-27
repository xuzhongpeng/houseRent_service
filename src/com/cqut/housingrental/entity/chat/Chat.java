package com.cqut.housingrental.entity.chat;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class Chat extends Entity{
	
	@ID
	private String id;
	private String tenant_id;
	private String senderid;
	private String receiverid;
	private String content;
	private String sendtime;
	private String is_Read;
	private String extended;
	
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
	public String getSenderid() {
		return senderid;
	}	
	
	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}
	public String getReceiverid() {
		return receiverid;
	}	
	
	public void setReceiverid(String receiverid) {
		this.receiverid = receiverid;
	}
	public String getContent() {
		return content;
	}	
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getSendtime() {
		return sendtime;
	}	
	
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
	public String getIs_Read() {
		return is_Read;
	}	
	
	public void setIs_Read(String is_Read) {
		this.is_Read = is_Read;
	}
	public String getExtended() {
		return extended;
	}	
	
	public void setExtended(String extended) {
		this.extended = extended;
	}
	
	@Override
	public String toString() {
		return "Chat [" +  "id=" + id  + ", " +  "tenant_id=" + tenant_id  + ", " +  "senderid=" + senderid  + ", " +  "receiverid=" + receiverid  + ", " +  "content=" + content  + ", " +  "sendtime=" + sendtime  + ", " +  "is_Read=" + is_Read  + ", " +  "extended=" + extended  + ", "   + "]";
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "chat";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}
}
