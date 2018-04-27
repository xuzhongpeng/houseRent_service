package com.cqut.housingrental.service.room;

import java.util.Map;

import com.cqut.housingrental.entity.room.Room;

public interface IRoomService {

	Map<String, Object> getWithPaging(int limit, int offset, String order,
			String sort, String searchText);

	int deleteByHouseid(String[] houseid);

	Map<String, Object> getRoomInfo(String houseid);

	Map<String, Object> getRoomInfoByID(String roomid);

	Map<String, Object> getInfoByID(String roomid);
	
}
