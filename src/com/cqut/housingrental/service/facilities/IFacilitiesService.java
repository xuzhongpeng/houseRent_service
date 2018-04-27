package com.cqut.housingrental.service.facilities;

import java.util.List;

import com.cqut.housingrental.entity.facilities.Facilities;

public interface IFacilitiesService {

	int update(Facilities entity);

	int deleteByHouseid(String[] houseid);
	
	List<Facilities> getFacilitiesBuHouseid(String houseid);
	
}
