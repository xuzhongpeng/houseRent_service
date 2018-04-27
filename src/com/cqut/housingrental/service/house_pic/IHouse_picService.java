package com.cqut.housingrental.service.house_pic;

import java.util.List;

import com.cqut.housingrental.entity.house_pic.House_pic;

public interface IHouse_picService {

	void save(House_pic pic);

	 List<House_pic> getbyid(String id);

	int deleteByHouseid(String[] houseid);
	
}
