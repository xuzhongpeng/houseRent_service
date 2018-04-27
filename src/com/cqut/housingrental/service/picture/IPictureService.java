package com.cqut.housingrental.service.picture;

import com.cqut.housingrental.entity.picture.Picture;

public interface IPictureService {
	Picture getPicByRoomid(String roomid);
}
