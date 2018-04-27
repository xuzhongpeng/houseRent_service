package com.cqut.housingrental.entity.house;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class House extends Entity{
	
	@ID
	private String id;
	private String landlord_id;
	private String houseNo;
	private String houseName;
	private String houseAdress;
	private String houseImg;
	private String to_manager;
	private String latitude;
	private String longitude;
	
	public String getId() {
		return id;
	}	
	
	public void setId(String id) {
		this.id = id;
	}
	public String getLandlord_id() {
		return landlord_id;
	}	
	
	public void setLandlord_id(String landlord_id) {
		this.landlord_id = landlord_id;
	}
	public String getHouseNo() {
		return houseNo;
	}	
	
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getHouseName() {
		return houseName;
	}	
	
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getHouseAdress() {
		return houseAdress;
	}	
	
	public void setHouseAdress(String houseAdress) {
		this.houseAdress = houseAdress;
	}
	public String getHouseImg() {
		return houseImg;
	}	
	
	public void setHouseImg(String houseImg) {
		this.houseImg = houseImg;
	}
	public String getTo_manager() {
		return to_manager;
	}	
	
	public void setTo_manager(String to_manager) {
		this.to_manager = to_manager;
	}
	public String getLatitude() {
		return latitude;
	}	
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}	
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return "House [" +  "id=" + id  + ", " +  "landlord_id=" + landlord_id  + ", " +  "houseNo=" + houseNo  + ", " +  "houseName=" + houseName  + ", " +  "houseAdress=" + houseAdress  + ", " +  "houseImg=" + houseImg  + ", " +  "to_manager=" + to_manager  + ", " +  "latitude=" + latitude  + ", " +  "longitude=" + longitude  + ", "   + "]";
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "house";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}
}
