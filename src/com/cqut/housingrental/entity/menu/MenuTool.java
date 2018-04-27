package com.cqut.housingrental.entity.menu;

import java.util.List;

public class MenuTool{
	private List<MenuTool> childMenus;
	private String id;
	private String menu_name;
	private String level;
	private String permission_id;
	private String parent_menu_id;
	private String path;
	private String icon;
	private String description;
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

	public List<MenuTool> getChildMenus() {
		return childMenus;
	}

	public void setChildMenus(List<MenuTool> childMenus) {
		this.childMenus = childMenus;
	}

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
