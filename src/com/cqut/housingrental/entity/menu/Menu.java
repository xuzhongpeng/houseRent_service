package com.cqut.housingrental.entity.menu;

import java.util.Date;
import java.util.List;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class Menu extends Entity{
	
	@ID
	private String id;
	private String menu_name;
	private String level;
	private String permission_id;
	private String parent_menu_id;
	private String path;
	private String description;
	private String icon;
	private String is_over;
	public String getId() {
		return id;
	}	
	
	public void setId(String id) {
		this.id = id;
	}
	public String getMenu_name() {
		return menu_name;
	}	
	
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getLevel() {
		return level;
	}	
	
	public void setLevel(String level) {
		this.level = level;
	}
	public String getPermission_id() {
		return permission_id;
	}	
	
	public void setPermission_id(String permission_id) {
		this.permission_id = permission_id;
	}
	public String getParent_menu_id() {
		return parent_menu_id;
	}	
	
	public void setParent_menu_id(String parent_menu_id) {
		this.parent_menu_id = parent_menu_id;
	}
	public String getPath() {
		return path;
	}	
	
	public void setPath(String path) {
		this.path = path;
	}
	public String getDescription() {
		return description;
	}	
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	@Override
	public String toString() {
		return "Menu [id=" + id + ", menu_name=" + menu_name + ", level="
				+ level + ", permission_id=" + permission_id
				+ ", parent_menu_id=" + parent_menu_id + ", path=" + path
				+ ", description=" + description + ", icon=" + icon
				+ ", is_over=" + is_over + "]";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "menu";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}
	
	public void setChildMenus(List<Menu> childMenus){}

	public String getIs_over() {
		return is_over;
	}

	public void setIs_over(String is_over) {
		this.is_over = is_over;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
