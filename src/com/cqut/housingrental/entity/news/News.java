package com.cqut.housingrental.entity.news;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class News extends Entity{
	
	@ID
	private String id;
	private String title;
	private String cover_photo_id;
	private String content;
	private String push_time;
	private String push_user_id;
	
	public String getId() {
		return id;
	}	
	
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}	
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCover_photo_id() {
		return cover_photo_id;
	}	
	
	public void setCover_photo_id(String cover_photo_id) {
		this.cover_photo_id = cover_photo_id;
	}
	public String getContent() {
		return content;
	}	
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getPush_time() {
		return push_time;
	}	
	
	public void setPush_time(String push_time) {
		this.push_time = push_time;
	}
	public String getPush_user_id() {
		return push_user_id;
	}	
	
	public void setPush_user_id(String push_user_id) {
		this.push_user_id = push_user_id;
	}
	
	@Override
	public String toString() {
		return "News [" +  "id=" + id  + ", " +  "title=" + title  + ", " +  "cover_photo_id=" + cover_photo_id  + ", " +  "content=" + content  + ", " +  "push_time=" + push_time  + ", " +  "push_user_id=" + push_user_id  + ", "   + "]";
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "news";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}
}
