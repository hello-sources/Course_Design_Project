package com.web.gjg.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//为了让springMVC找到此类，一定配置注解,相当于实现了Controller接口
@Controller
public class AdvanceController {
	 /*
	  * 返回的值决定跳到哪里，扩展名由配置文件决定
	  * 方法名可以任意但不能重复不能重载
	  * 方法内的参数，如果是Model,Map,HashMap,Request,Session等
	  * 可以带键值对的类都可以通过框架自动注册（实例化），通过
	  * 键值对向服务器发送数据
	  * 如果是具体的类型，名称和jsp参数一致，可以直接接收参数
	  * 如果是类对象，可以直接接收jsp中类对象内的get方法后的值
	  */
	 //为了能够接收网址，以此处通过注解配置请求映射
	 @RequestMapping("/adv")
     public String anyname(Map  map,int id)
     {
		 InternalResourceViewResolver d;
    	 //id的名称来自与之相同的jsp传递过来的参数
    	 map.put("msg", id);//向服务器发送数据
    	 
    	 return "ok";
     }
}
