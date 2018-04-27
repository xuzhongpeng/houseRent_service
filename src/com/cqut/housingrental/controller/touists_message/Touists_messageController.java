package com.cqut.housingrental.controller.touists_message;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.housingrental.service.touists_message.ITouists_messageService;

@Controller
@RequestMapping("/touists_messageController")
public class Touists_messageController{
	
	@Resource(name="touists_messageService")
	ITouists_messageService service;
}
