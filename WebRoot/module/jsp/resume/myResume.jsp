<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>许中鹏的简历</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="icon" href="module/jsp/resume/img/iconHeader.ico" type="image/x-icon"/> 
	<link rel="stylesheet" href="module/jsp/resume/jianli.css">
	<link rel="stylesheet" href="module/jsp/resume/touxiang.css">
</head>
<body>
	<div class="zx-preview-ld resetEditStyle">
				<div class="no_edit_background"></div>
			<div class="wbdCv-baseStyle" id="resume_base" data_color="j1" data_font_name="yahei" data_font_size="14" data_line_height="1" data_font_type="0" resume_sort='{"left":["resume_head","base_info","base_home","base_social","resume_skill","resume_hobby"],"top":[],"right":["resume_name","resume_job_preference","resume_edu","resume_work","resume_internship","resume_volunteer","resume_project","resume_honor","resume_summary","resume_portfolio","resume_recoment","resume_qrcode"],"bottom":[]}' wap_resume_sort='' template_set='{"left":[{"key":"resume_head","isShow":true},{"key":"base_info","isShow":true},{"key":"base_home","isShow":true},{"key":"base_social","isShow":true},{"key":"resume_skill","isShow":true},{"key":"resume_hobby","isShow":true}],"top":[],"right":[{"key":"resume_name","isShow":true},{"key":"resume_job_preference","isShow":true},{"key":"resume_edu","isShow":true},{"key":"resume_work","isShow":true},{"key":"resume_internship","isShow":false},{"key":"resume_volunteer","isShow":false},{"key":"resume_project","isShow":false},{"key":"resume_honor","isShow":false},{"key":"resume_summary","isShow":true},{"key":"resume_portfolio","isShow":false},{"key":"resume_recoment","isShow":false},{"key":"resume_qrcode","isShow":false}],"bottom":[]}' data_itemid="365">
				<!--封面模块-->
				<div class="wbdCv-cover hidden" id="resume_cover">
					<div class="coverItem  moduleItem">
						<dl>
							<dt><div contenteditable="false" data-textLang="cover">封面</div></dt>
							<dd>
								<div class="cover-con">
								</div>
							</dd>
						</dl>
					</div>
				</div>
                <!--自荐书模块-->
				<div class="wbdCv-letter hidden" id="resume_letter">
					<div class="letterItem moduleItem">
						<dl>
							<dt><div contenteditable="false" data-textLang="letter">自荐信</div></dt>
							<dd>
								<div contenteditable="true" data-placeholder="在这里添加描述..."></div>
							</dd>
						</dl>
					</div>					
				</div>
				<div class="wbdCv-resume clearfix">
					<div class="wbdCv-baseTop"></div>
					<div class="wbdCv-baseLeft" id="foo">
						<!--头像模块-->
						<div class="headItem moduleItem resume_sort " id="resume_head">
							<dl>
								<dt class="clearfix">
									<a class="wbdfont divIconFont" for-key="resume_head">&#xe880;</a>
									<span><div class="item-title module_item_title" contenteditable="false" data-placeholder="头像" data-textLang="head">头像</div></span>
								</dt>
								<dd class="clearfix">	
									<div class="head-con">
										<a class="img-preview-hover"> </a>
										<div class="img-preview"><img src="module/jsp/resume/img/header.jpg"/></div>
									</div>
								</dd>
							</dl>
						</div>
						<!--基本信息模块-->
						<div class="infoItem bInfoItem moduleItem resume_sort" id="base_info" >
							<dl>
								<dt class="clearfix" >
									<a class="wbdfont divIconFont" for-key="base_info">&#xe855;</a>
									<span><div class="resume_lang module_item_title" for-key="info_title" contenteditable="false" data-placeholder="基本信息" data-placeLang="baseMsg" data-textLang="baseMsg">基本信息</div></span>
								</dt>
								<dd class="clearfix">		
									<div class="info-con">
									<!-- 渲染时 从工作年限开始没有内容的 div 添加 hidden 类  身高 & 体重 要加小写单位 -->
										<div class="info-sex info-list moduleItemList hidden" id="sex"><a class="wbdfont divIconFont" for-key="sex"></a><span></span></div>
										<div class="info-age info-list moduleItemList" id="birth"><a class="wbdfont divIconFont" for-key="birth"></a><span data-placeLang="age" data-value="1996.03" data-placeholder="生日">21岁</span></div>
										<div class="info-nation info-list moduleItemList " id="nation"><a class="wbdfont divIconFont" for-key="nation"></a><span>汉族</span></div>
										<div class="info-highedu info-list moduleItemList hidden" id="education"><a class="wbdfont divIconFont" for-key="education"></a><span data-value=""></span></div>
										<div class="info-marital info-list moduleItemList hidden" id="marriageStatus"><a class="wbdfont divIconFont" for-key="marriageStatus"></a><span data-value=""></span></div>
										<div class="info-height info-list moduleItemList hidden" id="height"><a class="wbdfont divIconFont" for-key="height"></a><span data-value="">cm</span></div>
										<div class="info-status info-list moduleItemList hidden" id="politicalStatus"><a class="wbdfont divIconFont" for-key="politicalStatus"></a><span data-value=""></span></div>
										<div class="info-city info-list moduleItemList "  id="city"><a class="wbdfont divIconFont" for-key="city"></a><span data-placeLang="city" data-value="1947" data-placeholder="所在城市">重庆市</span></div>
										<div class="info-work info-list moduleItemList hidden" id="jobYear"><a class="wbdfont divIconFont" for-key="jobYear"></a><span data-value=""></span></div>
										<div class="info-phone info-list moduleItemList " id="mobile"><a class="wbdfont divIconFont" for-key="mobile"></a><span data-placeLang="phone" data-placeholder="联系电话">18983716857       </span></div>
										<div class="info-email info-list moduleItemList " id="email"><a class="wbdfont divIconFont" for-key="email"></a><span data-placeLang="email" data-placeholder="电子邮箱">1452754335@qq.com</span></div>
										<div class="info-weight info-list moduleItemList hidden" id="weight"><a class="wbdfont divIconFont" for-key="weight"></a><span data-value="">kg</span></div>
									</div>
								</dd>
							</dl>
						</div>
						<!--个人主页模块-->
						<div class="homeItem bInfoItem moduleItem resume_sort hidden" id="base_home">
							<dl>
								<dt class="clearfix">
									<a class="wbdfont divIconFont" for-key="base_home">&#xf192;</a>
									<span><div class="resume_lang module_item_title" for-key="base_home" contenteditable="false" data-placeholder="个人主页" data-placeLang="homePage" data-textLang="homePage">个人主页</div></span>
								</dt>
								<dd class="clearfix">	
									<div class="home-con">
									</div>
								</dd>
							</dl>
						</div>
						<!--社交账号模块-->
						<div class="socialItem bInfoItem moduleItem resume_sort" id="base_social">
							<dl>
								<dt class="clearfix">
									<a class="wbdfont divIconFont" for-key="base_social">&#xe64b;</a>
									<span><div class="resume_lang module_item_title" for-key="base_social" contenteditable="false" data-placeholder="社交账号" data-placeLang="social" data-textLang="social">社交账号</div></span>
								</dt>
								<dd class="clearfix">		
									<div class="social-con">
										<div class="social-wx social-list moduleItemList" style="display:block;margin-bottom: 10px"><a class="hvr-buzz" href="javascript:;" data-title="微信"></a><span style="position:relative;top:-10px">微信:18983716857</span></div>
										<div class="social-qq social-list moduleItemList" style="display:block"><a class="hvr-buzz" href="javascript:;" data-title="QQ"></a><span style="position:relative;top:-10px">QQ:1452754335</span></div>
									</div>										
								</dd>
							</dl>
						</div>														
						<!--技能特长模块-->
						<div class="skillItem baseItem moduleItem resume_sort " id="resume_skill">
							<dl>
								<dt class="clearfix ">
									<a class="wbdfont divIconFont" for-key="resume_skill"></a>
									<span><div class="resume_lang module_item_title" for-key="resume_skill" contenteditable="false" data-placeholder="技能特长" data-placeLang="social" data-textLang="social">技能特长</div></span>
								</dt>
								<dd class="clearfix">
									<div class="skill-con">										
										<div class="skill-list moduleItemList" data-id="">
											<span class="skill-title item_title">HTML/XHTML</span>
											<span class="skill-slider item_level" data_level="advanced">
												<s><i data-skill-width="1" style="width:80%"></i></s><span>熟练</span>
											</span>
										</div>
										<div class="skill-list moduleItemList" data-id="">
											<span class="skill-title item_title">CSS</span>
											<span class="skill-slider item_level" data_level="advanced">
												<s><i data-skill-width="1" style="width:80%"></i></s><span>熟练</span>
											</span>
										</div>
										<div class="skill-list moduleItemList" data-id="">
											<span class="skill-title item_title">JavaScript</span>
											<span class="skill-slider item_level" data_level="advanced">
												<s><i data-skill-width="1" style="width:70%"></i></s><span>熟练</span>
											</span>
										</div>
										<div class="skill-list moduleItemList" data-id="">
											<span class="skill-title item_title">jquery</span>
											<span class="skill-slider item_level" data_level="advanced">
												<s><i data-skill-width="1" style="width:70%"></i></s><span>熟练</span>
											</span>
										</div>
										<div class="skill-list moduleItemList" data-id="">
											<span class="skill-title item_title">Ajax</span>
											<span class="skill-slider item_level" data_level="advanced">
												<s><i data-skill-width="1" style="width:80%"></i></s><span>熟练</span>
											</span>
										</div>
										<div class="skill-list moduleItemList" data-id="">
											<span class="skill-title item_title">java</span>
											<span class="skill-slider item_level" data_level="advanced">
												<s><i data-skill-width="1" style="width:70%"></i></s><span>熟练</span>
											</span>
										</div>
										<div class="skill-list moduleItemList" data-id="">
											<span class="skill-title item_title">C#</span>
											<span class="skill-slider item_level" data_level="advanced">
												<s><i data-skill-width="1" style="width:80%"></i></s><span>熟练</span>
											</span>
										</div>
										<div class="skill-list moduleItemList" data-id="">
											<span class="skill-title item_title">bootstrap</span>
											<span class="skill-slider item_level" data_level="advanced">
												<s><i data-skill-width="1" style="width:70%"></i></s><span>了解</span>
											</span>
										</div>
										<div class="skill-list moduleItemList" data-id="">
											<span class="skill-title item_title">Spring MVC</span>
											<span class="skill-slider item_level" data_level="advanced">
												<s><i data-skill-width="1" style="width:80%"></i></s><span>熟练</span>
											</span>
										</div>
										<div class="skill-list moduleItemList" data-id="">
											<span class="skill-title item_title">react+node.js</span>
											<span class="skill-slider item_level" data_level="advanced">
												<s><i data-skill-width="1" style="width:50%"></i></s><span>了解</span>
											</span>
										</div>
									</div>
								</dd>
							</dl>
						</div>						
						<!--兴趣爱好模块-->
						<div class="hobbyItem baseItem moduleItem resume_sort "  id="resume_hobby">
							<dl>
								<dt class="clearfix ">
									<a class="wbdfont divIconFont" for-key="resume_hobby"></a>
									<span><div class="resume_lang module_item_title" for-key="resume_hobby" contenteditable="false" data-placeholder="兴趣爱好" data-placeLang="hobby" data-textLang="hobby">兴趣爱好</div></span>
								</dt>
								<dd class="clearfix">
									<div class="hobby-con">										
										<div class="hobby-list moduleItemList" data-id="" id="8cae972c9712e30282a410df251b1950">
                                            <a class="wbdfont divIconFont" for-key="8cae972c9712e30282a410df251b1950"></a>
                                            <span class="hobby-title item_title">阅读</span>
                                        </div>
										<div class="hobby-list moduleItemList" data-id="" id="9110e1334bacc196b9b04bc49e2f63d1">
                                            <a class="wbdfont divIconFont" for-key="9110e1334bacc196b9b04bc49e2f63d1"></a>
                                            <span class="hobby-title item_title">自行车</span>
                                        </div>
										<div class="hobby-list moduleItemList" data-id="" id="3df9ded596a38db887f491dadb7cdd3b">
                                            <a class="wbdfont divIconFont" for-key="3df9ded596a38db887f491dadb7cdd3b"></a>
                                            <span class="hobby-title item_title"> 户外</span>
                                        </div>
										<div class="hobby-list moduleItemList" data-id="" id="0b0130acbb5ba0cc8e95e13b65cdb351">
                                            <a class="wbdfont divIconFont" ></a>
                                            <span class="hobby-title item_title">游戏</span>
                                        </div>
										<div class="hobby-list moduleItemList" data-id="" >
                                            <a class="wbdfont divIconFont" ></a>
                                            <span class="hobby-title item_title"> 音乐</span>
                                        </div> 
										<div class="hobby-list moduleItemList" data-id="" id="">
                                            <a class="wbdfont divIconFont" for-key=""></a>
                                            <span class="hobby-title item_title">足球</span>
                                        </div>
									</div>									
								</dd>
							</dl>
						</div>
						
					</div>
					<div class="wbdCv-baseRight" id="bar">
						<!--姓名一句话模块-->
						<div class="nameItem bInfoItem resume_sort" id="resume_name">
							<dl>
								<dt class="clearfix">
									
								</dt>
								<dd class="clearfix">	
									<div class="name-con">
										<div class="name resume_lang" for-key="name" contenteditable="false" data-placeholder="你的名字" data-placeLang="name">许中鹏</div>
										<div class="word resume_lang" for-key="word" contenteditable="false" data-placeholder="一句话介绍自己，告诉HR为什么选择你而不是别人" data-placeLang="word">保持一颗学习上进的心。</div>
									</div>
								</dd>
							</dl>
						</div>													
						<!--求职意向模块-->
						<div class="inteItem baseItem moduleItem resume_sort "  id="resume_job_preference">
							<dl>
								<dt class="clearfix ">
									<a class="wbdfont divIconFont" for-key="resume_job_preference"></a>
									<span><div class="resume_lang module_item_title" for-key="resume_job_preference" contenteditable="false" data-placeholder="求职意向" data-placeLang="job" data-textLang="job">求职意向</div></span>
								</dt>
								<dd class="clearfix">
									<div class="inte-con">
										<div class="inte-job inte-list moduleItemList " id="jobFunction"><a class="wbdfont divIconFont" for-key="jobFunction">&#xf053;</a><span data-placeholder="意向岗位" data-placeLang="jobFun">前端开发工程师</span></div>
										<div class="inte-type inte-list moduleItemList hidden" id="jobType"><a class="wbdfont divIconFont" for-key="jobType">&#xf214;</a><span data-value="" data-placeholder="职业类型" data-placeLang="jobType"></span></div>
										<div class="inte-city inte-list moduleItemList" id="jobCity"><a class="wbdfont divIconFont" for-key="jobCity">&#xe852;</a><span data-placeholder="意向城市" data-value="" data-placeLang="jobCity">重庆 成都</span></div>
										<div class="inte-price inte-list moduleItemList hidden" id="jobSalary"><a class="wbdfont divIconFont" for-key="jobSalary">&#xe627;</a><span data-placeholder="薪资要求" data-placeLang="jobSalary"></span></div>
										<div class="inte-time inte-list moduleItemList hidden" id="jobTime"><a class="wbdfont divIconFont" for-key="jobTime">&#xe7cb;</a><span data-value="" data-placeholder="入职时间" data-placeLang="jobTime"></span></div>
									</div>
								</dd>
							</dl>
						</div>
                        <!--教育背景模块-->
						<div class="eduItem baseItem timeItem moduleItem resume_sort " id="resume_edu">
							<dl>
								<dt class="clearfix ">
									<a class="wbdfont divIconFont" for-key="resume_edu"></a>
									<span><div class="resume_lang module_item_title" for-key="resume_edu" contenteditable="false" data-placeholder="教育背景" data-placeLang="edu" data-textLang="edu">教育背景</div></span>
								</dt>
								<dd class="clearfix">
									<div class="dd-content moduleItemList" data-id="">
										<div class="dd-title clearfix ">
											<span class="time"><div contenteditable="false" data-placeholder="设置时间..." data-placeLang="time"><i class="time-start">2014.09</i>-<i class="time-end">2018.06</i></div></span>
											<span class="company"><div contenteditable="true" data-placeholder="填写学校名称..." data-placeLang="school">重庆理工大学<br></div></span>
											<span class="post"><div contenteditable="true" data-placeholder="填写专业名称..." data-placeLang="major"> 信息管理与信息系统<br></div></span>
										</div>
										<div class="dd-text clearfix  ">
											<div class="resume_lang resume_content" contenteditable="true" for-key="exper_content" data-placeholder="在这里详细描述你在校期间所学的专业，主要包括课程内容，校内任职，校内荣誉等内容..." data-placeLang="description"><p>主修课程：<span style="line-height: 1.5;">管理学、经济学、信息经济学、计算机开发技术、数据库原理与应用、运筹学、应用统计学、组织行为学、信息系统开发项目管理、计算机网络与通信、企业资源计划（ERP）原理及应用、ERP原理与实施、市场营销学、财务管理学、会计学、C语言基础、面向对象方法、计算机网络体系结构、信息系统开发与管理、软件质量保证与测试、c#编程、Java编程原理、高级网页制作、数据结构、大学英语等。</span></p>
											</div>
										</div>
									</div>
								</dd>
							</dl>
						</div>
						<!--工作经历模块-->
						<div class="experItem baseItem timeItem moduleItem resume_sort " id="resume_work">
							<dl>
								<dt class="clearfix ">
									<a class="wbdfont divIconFont" for-key="resume_work"></a>
									<span><div class="resume_lang module_item_title" for-key="resume_work" contenteditable="false" data-placeholder="工作经验" data-placeLang="exper" data-textLang="exper">学习经历</div></span>
								</dt>
								<dd class="clearfix">
									<div class="dd-content moduleItemList" data-id="">
										<div class="dd-title clearfix ">
											<span class="time"><div contenteditable="false" data-placeholder="设置时间..." data-placeLang="time"><i class="time-start">2015.6</i>-<i class="time-end">至今</i></div></span>
											<span class="company"><div contenteditable="true" data-placeholder="填写公司名称..." data-placeLang="organization">学校实验室 </div></span>
											
										</div>
										<div class="dd-text clearfix ">
											<div class="resume_lang resume_content" contenteditable="true" for-key="exper_content" data-placeholder="在这里详细描述你的职责范围、工作任务以及取得的成绩等..." data-placeLang="description"><p>内容描述：</p>
											<p>从2015年暑假开始在学校创新实验室学习网页制作相关的内容，从简单的html、css到后台的Java再到springMVC框架的使用，从做项目的一个小模块到后来需求分析、数据库设计、对项目有一个大致的掌握然后划分成多个模块。这两年从实验室学习了很多，做了好几个项目，积累了不错的经验。</p>
											</div>
										</div>
									</div>
									
								</dd>
							</dl>
						</div>
						<!--技能指数模块-->
						<div class="intexperItem baseItem timeItem moduleItem resume_sort " id="resume_internship">
							<dl>
								<dt class="clearfix ">
									<a class="wbdfont divIconFont" for-key="resume_internship"></a>
									<span><div class="resume_lang module_item_title" for-key="resume_internship" contenteditable="false" data-placeholder="技能指数" data-placeLang="intexper" data-textLang="intexper">技能指数</div></span>
								</dt>
								<dd class="clearfix">
									<div class="dd-content moduleItemList" data-id="">										
										<div class="dd-text clearfix ">
											<div class="resume_lang resume_content" contenteditable="true" for-key="exper_content" data-placeholder="在这里添加实习描述..." data-placeLang="description">
											<ul>
												<li>了解HTTP、HTTPS协议</li>
												<li>掌握MyEclipse、Sublime Text等开发工具，chrome调试工具，SVN、git代码托管工具</li>
												<li>熟悉掌握Java Web开发，包括页面的快速编写，以及前后端的衔接处理</li>
												<li>熟练掌握HTML(5)、CSS(3)、JavaScript、Ajax等Web前端技术，对于ES6标准也有基本的认识</li>
												<li>熟悉使用jQuery、bootstrap、easyui、了解react.js等前端框架</li>
												<li>熟悉SpringMVC、Mybatis等框架的整合使用</li>
												<li>了解node.js、C#等其它服务端语言，了解基于C#或node.js的Web系统开发(能独立完成一个模块)</li>
												<li>对sql server、Oracle有一定的了解，熟练mysql数据库，掌握Redis数据库的使用</li>
											</ul></div>
										</div>
									</div>
								</dd>
							</dl>
						</div>
						
						<!--项目经验模块-->
						<div class="proexperItem baseItem timeItem moduleItem resume_sort" id="resume_project">
							<dl>								
								<dt class="clearfix ">
									<a class="wbdfont divIconFont" for-key="resume_project"></a>
									<span><div class="resume_lang module_item_title" for-key="resume_project" contenteditable="false" data-placeholder="项目经验" data-placeLang="proexper" data-textLang="proexper">项目经验</div></span>
								</dt>
								<dd class="clearfix">
									<div class="dd-content moduleItemList">		
										<div class="dd-title clearfix ">
											<span class="time"><div contenteditable="false" data-placeholder="设置时间..." data-placeLang="time"><i class="time-start">2016.6</i>-<i class="time-end">2017.1</i></div></span>
											<span class="company"><div contenteditable="true" data-placeholder="填写公司名称..." data-placeLang="organization">西计实验室项目</div></span>
											
										</div>							
										<div class="dd-text clearfix">
											<div class="resume_lang resume_content" contenteditable="true" for-key="exper_content" data-placeholder="在这里添加描述..." data-placeLang="description">
												<p>项目描述: </p>
												<p>西南计算机实验室系统(以下简称西计)，包括西计的门户网站，以及包括公司内部的后台管理系统。前台作为司的门户展示给用户使用,后台部分属于内部管理系统，录入基本数据后对整个公司的工作流程进行管理或整合</p> 
												<p>职责描述:</p>
												<p>前期需求分析讨论设计，包括前后台搭建、应用技术以及前端每个页面的具体呈现等负责任务管理、检测报告管理、检测报告审核、签发人管理、文件管理等模块的开发以及后期bug测试负责部分接口或公共方法的书写和维护协调沟通、互相监督、人人核心，顺利完成项目开发</p>
											</div>
										</div>
										<div class="dd-title clearfix" >
											<span class="time" style="margin-top:20px;"><div contenteditable="false" ><i class="time-start">2017.2</i>-<i class="time-end">2017.5</i></div></span>
											<span class="company" style="margin-top:20px;"><div contenteditable="true" data-placeholder="填写公司名称..." data-placeLang="organization">微信图片打赏开发</div></span>											
										</div>
										<div class="dd-text clearfix">
											<div class="resume_lang resume_content" contenteditable="true" for-key="exper_content" data-placeholder="在这里添加描述..." data-placeLang="description">
												<p>项目描述: </p>
												<p>微信图片打赏项目是实现微信用户通过关注微信公众号，发送需求图片，图片上传到阿里云鉴黄，通过后在后台利用高斯模糊处理图片后加上打赏网页的二维码再返回给用户，用户可把图片分享到朋友圈，朋友扫描图片上的二维码获得打赏的链接，打赏一定金额后可看到完整图片。用户可查看各个图片对应的打赏金额及打赏人，还可把收益提现到自己的银行卡。</p> 
												<p>职责描述:</p>
												<p>前期需求分析，包括数据库设计，网页功能设计及任务分工，实现服务器与微信对接，菜单生成，微信消息处理及消息回复，用户关注实现自动注册，网页授权，用户打赏金额及打赏人的获取，最后整个项目的完善及在服务器上的发布测试。</p>
											</div>
										</div>
									</div>
								</dd>									
							</dl>
						</div>						
						<!--自我评价模块-->
						<div class="evalItem baseItem moduleItem descItem resume_sort " id="resume_summary">
							<dl>
								<dt class="clearfix ">
									<a class="wbdfont divIconFont" for-key="resume_summary"></a>
									<span><div class="resume_lang module_item_title" for-key="resume_summary" contenteditable="false" data-placeholder="自我评价" data-placeLang="self" data-textLang="self">自我评价</div></span>
								</dt>
								<dd class="clearfix">		
									<div class="dd-content moduleItemList">
										<div class="dd-text clearfix">
											<p>我一直深信不断学习，就会提升更多，我也一直把高级前端工程师当做目标，在不断学习过程中也遇到了很多困难，我大部分都是通过上网查询解决的，所以我自认为我的自学能力很强。工作中我喜欢倾听别人的意见，然后再发表自己的看法。如果产生分歧，在了解别人的想法后我还认为自己的比较棒，我就会坚持自己的见解，我认为一个合格的程序员应该有自己的想法。我很喜欢挑战自己，希望能做很多有挑战性的任务。对于安排的任务，我都会按时按量完成，不喜欢把任务拖到下一天。</p>
										</div>
									</div>									
								</dd>
							</dl>
						</div>
						<!--作品展示模块-->
						<div class="workItem baseItem moduleItem resume_sort hidden" id="resume_portfolio">
							<dl>
								<dt class="clearfix ">
									<a class="wbdfont divIconFont" for-key="resume_portfolio"></a>
									<span><div class="resume_lang module_item_title" for-key="resume_portfolio" data-placeholder="作品展示" data-placeLang="portfolio" data-textLang="portfolio">作品展示</div></span>
								</dt>
								<dd class="clearfix">
									<div class="work-con">
										<div class="baseItem-null" style="display: block;"><div class="baseItem-nullcon"><i>+</i><span data-textLang="addPortfolio">添加我的作品</span></div></div>
                                    		<div class="work-con-img clearfix">
											</div>
											<div class="work-con-link clearfix">
                                            </div>
									</div>
								</dd>
							</dl>
						</div>
						<!--推荐信模块-->
						<div class="recomentItem baseItem moduleItem resume_sort hidden" id="resume_recoment">
							<dl>
								<dt class="clearfix ">
									<a class="wbdfont divIconFont" for-key="resume_recoment"></a>
									<span><div class="resume_lang module_item_title" for-key="resume_recoment" data-placeholder="推荐信" data-placeLang="recoment" data-textLang="recoment">推荐信</div></span>
								</dt>
								<dd class="clearfix">
									<div class="recoment-con">
										<div class="baseItem-null" style="display:block;"><div class="baseItem-nullcon"><i>+</i><a target="_blank" data-textLang="requestRecomment">邀请别人为你写推荐信</a></div></div>
									</div>
								</dd>
							</dl>
						</div>		
				</div>
			</div>
			<footer>
			<p>本简历被访问次数：<var id="count"></var> 次<p>
			<a  id="downLoadPdf" style="margin-bottom:30px;padding:10px;float:right;color:blue;cursor:pointer">下载PDF</a>
		</footer>
		</div>
		
	</div>
<script src="module/js/jquery-2.1.1.min.js"></script>
<script>
$(function(){
	$.ajax({
		  url: "testReportController/gethost.do", 
        type: "post",
        dataType: "json",
        success:function(data){
        		$("#count").html(data);
        }
	})
	$('#downLoadPdf').click(function(){
		window.location.href ="testReportController/filedownload.do";
	})
})
	
</script>
</body>
</html>