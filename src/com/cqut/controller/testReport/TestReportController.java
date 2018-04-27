package com.cqut.controller.testReport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.service.testReport.ITestReportService;
import com.cqut.tool.util.JToolWeb;

@Controller
@RequestMapping("/testReportController")
public class TestReportController {

	@Resource(name = "testReportService")
	ITestReportService service;
	
	/**
	 * 
	 * @discription 检测报告管理页面数据
	 * @author zt
	 * @created 2016-11-21 下午9:12:22
	 * @param limit
	 * @param offset
	 * @param order
	 * @param sort
	 * @param transitreceiptNumber
	 * @param client
	 * @param reportName
	 * @param beginTime
	 * @param endTime
	 * @param selectPart
	 * @return
	 */
	@RequestMapping("/getTestReportWithPaging")
	@ResponseBody
	public JSONObject getTestReportWithPaging(int limit, int offset,
			String order, String sort, String name,HttpServletRequest req) {
		Object session = req.getSession().getAttribute("EMPLOYEEID");
		String uploader = "";
		if (session != null) {
			uploader = session.toString();
		}
		Map<String, Object> result = service.getTestReportWithPaging(limit,
				offset, order, sort, name);
		return JSONObject.fromObject(result);
	}
	/***
	 * 
	 * @description 单文件下载
	 * @author zt
	 * @created 2016-10-10 下午8:27:28
	 * @param request
	 * @param response
	 * @param ID
	 * @throws IOException
	 */
	@RequestMapping("/filedownload")
	@ResponseBody
	public void filedownload(HttpServletRequest request,
			HttpServletResponse response, String ID) throws IOException {
		//response.reset();// 可以加也可以不加,注意加了之后tomcate需要配置UTF-8否则乱码
		response.setContentType("application/x-download");
		String fileTurePath = "F:\\文档\\简历\\简历\\简历.pdf";
		int length = fileTurePath.length();
		int x = fileTurePath.lastIndexOf("\\");
		x++;
		String filedisplay = fileTurePath.substring(x, length);// "给用户提供的下载文件名";
		// String filedisplay = new
		// String(request.getParameter("name").getBytes("iso8859-1"), "utf-8");
		if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {// 火狐
			filedisplay = JToolWeb.processFileName(request, filedisplay);
		} else {
			filedisplay = URLEncoder.encode(filedisplay, "UTF-8");
		}
		response.addHeader("Content-Disposition", "attachment;filename="
				+ filedisplay);
		OutputStream outp = null;
		FileInputStream in = null;
		try {
			outp = response.getOutputStream();
			in = new FileInputStream(fileTurePath);
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = in.read(b)) > 0) {
				outp.write(b, 0, i);
			}
			outp.flush();
			outp.close();
		} catch (Exception e) {
			
			System.err.println("下载出错!"+e);
		} finally {

			if (in != null) {
				in.close();
				in = null;
			}
			if (outp != null) {
				outp.close();
				outp = null;
			}
		}
	}
	@RequestMapping("/gethost")
	@ResponseBody
	public int gethost(HttpServletRequest request,
			HttpServletResponse response)
	{
		String ip=request.getRemoteAddr();
		String host=request.getRemoteHost();
		int result=service.SaveIP(ip,host);
		System.out.println("有访客："+ip+" 访问您的简历！"+result);
		return result;
	}
	@RequestMapping("/testName")
	@ResponseBody
	public int testName(HttpServletRequest request,
			HttpServletResponse response)
	{
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String girlName="",boyName="";
		try {
			girlName= new String(request.getParameter("girlName").getBytes("iso8859-1"),"utf-8");
			boyName=new String(request.getParameter("boyName").getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 try{
		int result=service.SaveName(girlName,boyName);
		 }
		 catch(Exception E){
			 return 10;
		 }
		String cover=convertHanzi2Pinyin(girlName,true);
		String cover2=convertHanzi2Pinyin(boyName,true);
		byte[] bytestr = (cover+cover2).getBytes();  
        int sum = 0;  
        for(int i=0;i<bytestr.length;i++){  
            sum += bytestr[i];  
        }  
        int aa=sum%10;
        
       
        if(cover.equals("wangnengneng")&&cover2.equals("xuzhongpeng")){
        	aa=9;
        }
        else if(cover.equals("wangnengneng")&&!cover2.equals("xuzhongpeng")){
        	aa=sum%4;
        	System.out.println("jinliale");
        }
        System.out.println(girlName+","+boyName+","+aa); 
		return aa;
	}
	/***
	 * 将汉字转成拼音(取首字母或全拼)
	 * @param hanzi
	 * @param full 是否全拼
	 * @return
	 */
	 public static String convertHanzi2Pinyin(String hanzi,boolean full)
	 {
		 /***
		 * ^[\u2E80-\u9FFF]+$ 匹配所有东亚区的语言 
		 * ^[\u4E00-\u9FFF]+$ 匹配简体和繁体 
		 * ^[\u4E00-\u9FA5]+$ 匹配简体
		 */
		 String regExp="^[\u4E00-\u9FFF]+$";
		 StringBuffer sb=new StringBuffer();
		 if(hanzi==null||"".equals(hanzi.trim()))
		 {
			 return "";
		 }
		 String pinyin="";
		 for(int i=0;i<hanzi.length();i++)
		 {
			 char unit=hanzi.charAt(i);
			 if(match(String.valueOf(unit),regExp))//是汉字，则转拼音
			 {
				 pinyin=convertSingleHanzi2Pinyin(unit);
				 if(full)
				 {
					 sb.append(pinyin);
				 }
				 else
				 {
				  sb.append(pinyin.charAt(0));
				 }
			 }
			 else
			 {
			 sb.append(unit);
			 }
		 }
		 return sb.toString();		 
	 }
	/***
	 * 将单个汉字转成拼音
	 * @param hanzi
	 * @return
	 */
	 private static String convertSingleHanzi2Pinyin(char hanzi)
	 {
		 HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
		 outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		 String[] res;
		 StringBuffer sb=new StringBuffer();
		 try {
			 res = PinyinHelper.toHanyuPinyinStringArray(hanzi,outputFormat);
			 sb.append(res[0]);//对于多音字，只用第一个拼音
		 } catch (Exception e) {
			 e.printStackTrace();
			 return "";
		 }
		 return sb.toString();
	 }
  
	 /***
	 * @param str 源字符串
	 * @param regex 正则表达式
	 * @return 是否匹配
	 */
	 public static boolean match(String str,String regex)
	 {
		 Pattern pattern=Pattern.compile(regex);
		 Matcher matcher=pattern.matcher(str);
		 return matcher.find();
	 }
		 
	 public static void Main(String[] args) {
		 System.out.println(convertHanzi2Pinyin("我是中国人123abc",true));
	 }
}
