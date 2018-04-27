package com.cqut.housingrental.controller.user_role;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.housingrental.service.user_role.IUser_roleService;

@Controller
@RequestMapping("/user_roleController")
public class User_roleController{
	
	@Resource(name="user_roleService")
	IUser_roleService service;
}
