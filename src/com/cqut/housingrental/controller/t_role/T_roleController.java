package com.cqut.housingrental.controller.t_role;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.housingrental.service.t_role.IT_roleService;

@Controller
@RequestMapping("/t_roleController")
public class T_roleController{
	
	@Resource(name="t_roleService")
	IT_roleService service;
}
