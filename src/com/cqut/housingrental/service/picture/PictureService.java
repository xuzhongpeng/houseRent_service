package com.cqut.housingrental.service.picture;

import javax.annotation.Resource;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import com.cqut.dao.base.BaseEntityDao;
import com.cqut.dao.base.EntityDao;
import com.cqut.dao.base.SearchDao;
import com.cqut.housingrental.entity.administrators.Administrators;
import com.cqut.housingrental.entity.picture.Picture;
import com.cqut.housingrental.entity.room.Room;
import com.cqut.service.base.SearchService;

import com.cqut.tool.treeNode.Node;
import com.cqut.tool.treeNode.NodeList;
import com.cqut.tool.util.EntityIDFactory;

@Service
public class PictureService extends SearchService implements IPictureService{
	
	@Resource(name="entityDao")
	EntityDao entityDao;
	
	@Resource(name="searchDao")
	SearchDao searchDao;
	
	@Resource(name="baseEntityDao")
	BaseEntityDao baseEntityDao;

	@Override
	public String getBaseEntityName() {
		return "picture";
	}

	@Override
	public String getBasePrimaryKey() {
		return "picture.id";
	}

	@Override
	public Picture getPicByRoomid(String roomid) {
		Room room=entityDao.getByID(roomid, Room.class);
		Picture pic=entityDao.getByID(room.getId(),Picture.class);
		return pic;
	}
	
}
