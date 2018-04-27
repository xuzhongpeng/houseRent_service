package com.cqut.housingrental.entity.facilities;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class Facilities extends Entity{
	
	@ID
	private String id;
	private String house_id;
	private String wifi;
	private String air_conditioner;
	private String fridge;
	private String wired_network;
	private String sofa;
	private String wardrobe;
	private String television;
	
	public String getId() {
		return id;
	}	
	
	public void setId(String id) {
		this.id = id;
	}
	public String getHouse_id() {
		return house_id;
	}	
	
	public void setHouse_id(String house_id) {
		this.house_id = house_id;
	}
	public String getWifi() {
		return wifi;
	}	
	
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
	public String getAir_conditioner() {
		return air_conditioner;
	}	
	
	public void setAir_conditioner(String air_conditioner) {
		this.air_conditioner = air_conditioner;
	}
	public String getFridge() {
		return fridge;
	}	
	
	public void setFridge(String fridge) {
		this.fridge = fridge;
	}
	public String getWired_network() {
		return wired_network;
	}	
	
	public void setWired_network(String wired_network) {
		this.wired_network = wired_network;
	}
	public String getSofa() {
		return sofa;
	}	
	
	public void setSofa(String sofa) {
		this.sofa = sofa;
	}
	public String getWardrobe() {
		return wardrobe;
	}	
	
	public void setWardrobe(String wardrobe) {
		this.wardrobe = wardrobe;
	}
	public String getTelevision() {
		return television;
	}	
	
	public void setTelevision(String television) {
		this.television = television;
	}
	
	@Override
	public String toString() {
		return "Facilities [" +  "id=" + id  + ", " +  "house_id=" + house_id  + ", " +  "wifi=" + wifi  + ", " +  "air_conditioner=" + air_conditioner  + ", " +  "fridge=" + fridge  + ", " +  "wired_network=" + wired_network  + ", " +  "sofa=" + sofa  + ", " +  "wardrobe=" + wardrobe  + ", " +  "television=" + television  + ", "   + "]";
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "facilities";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}
}
