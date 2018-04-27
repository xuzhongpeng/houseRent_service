package com.cqut.housingrental.controller.house_pic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cqut.housingrental.entity.house.House;
import com.cqut.housingrental.entity.house_pic.House_pic;
import com.cqut.housingrental.entity.picture.Picture;
import com.cqut.housingrental.service.house_pic.IHouse_picService;
import com.cqut.housingrental.service.publicService.IPublicService;
import com.cqut.tool.util.EntityIDFactory;

@Controller
@RequestMapping("/house_picController")
public class House_picController{
	
	@Resource(name="house_picService")
	IHouse_picService service;
	
	@Resource(name="publicService")
	IPublicService publicService;
	
/*图片上传*/
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/upload")
	@ResponseBody
	public JSONObject addFile(String house_id,HttpServletRequest request,
			HttpServletResponse response)
			throws IllegalStateException, IOException {
		String ii=house_id;
		String uid=request.getParameter("house_id");//获取uid
		String pid=request.getParameter("pid");//获取jsp id参数
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					String myFileName = file.getOriginalFilename();
					if (myFileName.trim() != "") {
						String fileName = file.getOriginalFilename();
						String fileExt = fileName.substring(
								fileName.lastIndexOf(".") + 1).toLowerCase();
						SimpleDateFormat df = new SimpleDateFormat(
								"yyyyMMddHHmmss");
						String newFileName = df.format(new Date());
						String fileNames = newFileName
								+ new Random().nextInt(1000) + "." + fileExt;
						String path1 = request.getContextPath();
						 //String path = request.getSession().getServletContext().getRealPath("/").replace("housingrental\\", "")
							//	 +"picture\\"+fileNames;//上传路径
						 String path="E:\\java\\picture\\housePic\\"+fileNames;
						File localFile = new File(path);
						if (!localFile.exists()) {// 如果文件夹不存在，自动创建
							localFile.mkdirs();
						}
						file.transferTo(localFile);
						House_pic pic=new House_pic();
						System.out.println(path);
						pic.setId(EntityIDFactory.createId());
						pic.setPath("housePic//"+fileNames);
						pic.setHouse_id(house_id);
						service.save(pic);
						return JSONObject.fromObject(pic);
					}
				}
			}			
		}
		return JSONObject.fromObject("0");
	}	
	
	@RequestMapping("/delete")
	@ResponseBody
	public JSONObject delete(String ids) {
		String[] idStrings=ids.replace("[","").replace("]", "").replace("\"","").split(",");
		Map<String,Object> returnObj=new HashMap<String, Object>();
		int result=0;
		try{
			result=publicService.delete(idStrings,House_pic.class);
			returnObj.put("result",result);
		}
		catch(NumberFormatException e){
			returnObj.put("type", "success");
			returnObj.put("result", e);
			
		}	
		
		return JSONObject.fromObject(returnObj);
	}
	@RequestMapping("/getById")
	@ResponseBody
	public JSONObject getById(String id) {
		List<House_pic> pic=service.getbyid(id);
		Map<String,Object> returnObj=new HashMap<String, Object>();
		returnObj.put("result",pic);
		return JSONObject.fromObject(returnObj);
	}
	
	
}
