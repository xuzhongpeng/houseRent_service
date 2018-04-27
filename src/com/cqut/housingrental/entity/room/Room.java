package com.cqut.housingrental.entity.room;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class Room extends Entity{
	
	@ID
	private String id;
	private String roomNo;
	private String to_houseid;
	private String roomImg;
	private String to_tenant;
	private String rent;
	private String size;
	private String status;
	private String house_type;
	private String has_WC;
	
	public String getId() {
		return id;
	}	
	
	public void setId(String id) {
		this.id = id;
	}
	public String getRoomNo() {
		return roomNo;
	}	
	
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getTo_houseid() {
		return to_houseid;
	}	
	
	public void setTo_houseid(String to_houseid) {
		this.to_houseid = to_houseid;
	}
	public String getRoomImg() {
		return roomImg;
	}	
	
	public void setRoomImg(String roomImg) {
		this.roomImg = roomImg;
	}
	public String getTo_tenant() {
		return to_tenant;
	}	
	
	public void setTo_tenant(String to_tenant) {
		this.to_tenant = to_tenant;
	}
	public String getRent() {
		return rent;
	}	
	
	public void setRent(String rent) {
		this.rent = rent;
	}
	public String getSize() {
		return size;
	}	
	
	public void setSize(String size) {
		this.size = size;
	}
	public String getStatus() {
		return status;
	}	
	
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHouse_type() {
		return house_type;
	}	
	
	public void setHouse_type(String house_type) {
		this.house_type = house_type;
	}
	public String getHas_WC() {
		return has_WC;
	}	
	
	public void setHas_WC(String has_WC) {
		this.has_WC = has_WC;
	}
	
	@Override
	public String toString() {
		return "Room [" +  "id=" + id  + ", " +  "roomNo=" + roomNo  + ", " +  "to_houseid=" + to_houseid  + ", " +  "roomImg=" + roomImg  + ", " +  "to_tenant=" + to_tenant  + ", " +  "rent=" + rent  + ", " +  "size=" + size  + ", " +  "status=" + status  + ", " +  "house_type=" + house_type  + ", " +  "has_WC=" + has_WC  + ", "   + "]";
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "room";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}
}
