package com.cqut.housingrental.service.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.cqut.dao.base.BaseEntityDao;
import com.cqut.dao.base.EntityDao;
import com.cqut.dao.base.SearchDao;
import com.cqut.housingrental.entity.administrators.Administrators;
import com.cqut.housingrental.entity.menu.Menu;
import com.cqut.housingrental.entity.menu.MenuTool;
import com.cqut.housingrental.entity.role_permission.Role_permission;
import com.cqut.housingrental.entity.t_permission.T_permission;
import com.cqut.housingrental.entity.user_role.User_role;
import com.cqut.housingrental.service.role_permission.IRole_permissionService;
import com.cqut.housingrental.service.t_permission.IT_permissionService;
import com.cqut.housingrental.service.t_role.IT_roleService;
import com.cqut.housingrental.service.user_role.IUser_roleService;
import com.cqut.service.base.SearchService;
import com.cqut.service.testReport.ITestReportService;

import com.cqut.tool.treeNode.Node;
import com.cqut.tool.treeNode.NodeList;
import com.cqut.tool.util.EntityIDFactory;
@Service
public class MenuService extends SearchService implements IMenuService{
	
	@Resource(name="entityDao")
	EntityDao entityDao;
	
	@Resource(name="searchDao")
	SearchDao searchDao;
	
	@Resource(name="baseEntityDao")
	BaseEntityDao baseEntityDao;

	@Override
	public String getBaseEntityName() {
		return "menu";
	}

	@Override
	public String getBasePrimaryKey() {
		return "menu.id";
	}
	@Resource(name = "user_roleService")
	IUser_roleService iUser_roleService;
	
	@Resource(name = "t_permissionService")
	IT_permissionService iT_permissionService;
	
	@Resource(name = "role_permissionService")
	IRole_permissionService iRole_permissionService;
	
	
	/**
	 * 根据userid生成菜单
	 */
	@Override
	public Map<String,Object> getMenuList(String userid){
		User_role user_role=iUser_roleService.getRole(userid).get(0);
		Role_permission role_permission =iRole_permissionService.getRole_permissionByRole(user_role.getRole_id());
		List<T_permission> permissionList=iT_permissionService.getRole(role_permission.getPermission_id());
		
		List<MenuTool> rootMenu=new ArrayList<>();//未组装的menu
		for(T_permission permission:permissionList){ 
			MenuTool menutool=new MenuTool();
			Menu menu=entityDao.getByID(permission.getPermission_number(), Menu.class);
			menutool.setId(menu.getId());
			menutool.setDescription(menu.getDescription());
			menutool.setIs_over(menu.getIs_over());
			menutool.setLevel(menu.getLevel());
			menutool.setMenu_name(menu.getMenu_name());
			menutool.setParent_menu_id(menu.getParent_menu_id());
			menutool.setPath(menu.getPath());
			menutool.setPermission_id(menu.getPermission_id());
			menutool.setIcon(menu.getIcon());
			rootMenu.add(menutool);		
			
		}
		
		 // 最后的结果
	    List<MenuTool> menuList = new ArrayList<MenuTool>();
	    // 先找到所有的一级菜单
	    for (int i = 0; i < rootMenu.size(); i++) {
	        // 一级菜单没有parentId
	        if (rootMenu.get(i).getLevel().equals("1")) {
	            menuList.add(rootMenu.get(i));
	        }
	    }
	    // 为一级菜单设置子菜单，getChild是递归调用的
	    for (MenuTool menu : menuList) {
	        menu.setChildMenus(getChild(menu.getId(), rootMenu));
	    }
	    Map<String,Object> jsonMap = new HashMap<>();
	    jsonMap.put("menu", menuList);
	    System.out.println(JSONObject.fromObject(jsonMap));		
		return jsonMap;
	}
	/**
	 * 读取菜单信息
	 * @param limit
	 * @param offset
	 * @param order
	 * @param sort
	 * @param name
	 * @return
	 */
	@Override
	public Map<String, Object> getMenuWithPaging(int limit, int offset,
			String order, String sort, String searchText) {
		int index = limit;//每行显示条数
		int pageNum = offset ;//页码
		String baseEntity = "menu";//查询的条件和表
		String[] properties = new String[] {"*"};//查询的列名
		//String joinEntity = " LEFT JOIN fileinformation ON c.fileID = fileinformation.ID   ";
		String condition="";
		if(StringUtils.isNotBlank(searchText)){
			condition= "1=1 and menu_name like '%"+searchText+"%'";
		}
		//condition += " and fileinformation.uploaderID = '20170220xiji'";
		List<Map<String, Object>> result = entityDao.searchWithpaging(
				properties, baseEntity, null, null, condition, null,
				order,  sort,index, pageNum);
		int count = entityDao.searchForeign(properties, baseEntity, null, null, condition).size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", result);
		return map;
	}
	@Override
	public int update(Menu menu){
		return entityDao.updatePropByID(menu, menu.getId());
	}
	@Override
	public int save(Menu menu){
		menu.setId(EntityIDFactory.createId());
		return entityDao.save(menu);
	}
	@Override
	public int delete(String[] IDs){
		return entityDao.deleteEntities(IDs, Menu.class);
	}
	private static List<MenuTool> getChild(String id, List<MenuTool> rootMenu) {
	    // 子菜单
	    List<MenuTool> childList = new ArrayList<>();
	    for (MenuTool menu : rootMenu) {
	        // 遍历所有节点，将父菜单id与传过来的id比较
	        if (StringUtils.isNotBlank(menu.getParent_menu_id())) {
	            if (menu.getParent_menu_id().equals(id)) {
	                childList.add(menu);
	            }
	        }
	    }
	    // 把子菜单的子菜单再循环一遍
	    for (MenuTool menu : childList) {// 没有url子菜单还有子菜单
	        if (StringUtils.isNotBlank(menu.getIs_over())) {
	            // 递归
	            menu.setChildMenus(getChild(menu.getId(), rootMenu));
	        }
	    } // 递归退出条件
	    if (childList.size() == 0) {
	        return null;
	    }
	    return childList;
	}
	
	
}
