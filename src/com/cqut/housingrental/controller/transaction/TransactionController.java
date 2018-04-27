package com.cqut.housingrental.controller.transaction;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.housingrental.service.transaction.ITransactionService;

@Controller
@RequestMapping("/transactionController")
public class TransactionController{
	
	@Resource(name="transactionService")
	ITransactionService service;
}
