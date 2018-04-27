package com.cqut.housingrental.controller.chat;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.housingrental.service.chat.IChatService;

@Controller
@RequestMapping("/chatController")
public class ChatController{
	
	@Resource(name="chatService")
	IChatService service;
}
