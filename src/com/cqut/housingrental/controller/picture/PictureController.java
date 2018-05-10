package com.cqut.housingrental.controller.picture;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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

import com.cqut.housingrental.entity.manager.Manager;
import com.cqut.housingrental.entity.picture.Picture;
import com.cqut.housingrental.service.picture.IPictureService;
import com.cqut.housingrental.service.publicService.IPublicService;
import com.cqut.tool.util.EntityIDFactory;

@Controller
@RequestMapping("/pictureController")
public class PictureController{
	
	@Resource(name="pictureService")
	IPictureService service;
	
	@Resource(name="publicService")
	IPublicService publicService;
	
/*图片上传*/
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/upload")
	@ResponseBody
	public JSONObject addFile(HttpServletRequest request,
			HttpServletResponse response)
			throws IllegalStateException, IOException {
		String uid=request.getParameter("uid");//获取uid
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
						 String path="E:\\java\\picture\\"+fileNames;
						File localFile = new File(path);
						if (!localFile.exists()) {// 如果文件夹不存在，自动创建
							localFile.mkdirs();
						}
						file.transferTo(localFile);
						Picture pic=new Picture();
						System.out.println(path);
						pic.setId(EntityIDFactory.createId());
						pic.setPath(fileNames);
						pic.setDiscription("");
						publicService.save(pic);
						return JSONObject.fromObject(pic);
					}
				}
			}			
		}
		return JSONObject.fromObject("{result:0}");
	}	
	@RequestMapping("/getPicByid")
	@ResponseBody
	public JSONObject getPicByid(String id) {
		Picture result=publicService.getByID(id,Picture.class);
		return JSONObject.fromObject(result);
	
	}
	
}
