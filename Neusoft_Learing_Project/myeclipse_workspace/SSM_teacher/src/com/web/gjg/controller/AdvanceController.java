package com.web.gjg.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//Ϊ����springMVC�ҵ����࣬һ������ע��,�൱��ʵ����Controller�ӿ�
@Controller
public class AdvanceController {
	 /*
	  * ���ص�ֵ�������������չ���������ļ�����
	  * �������������⵫�����ظ���������
	  * �����ڵĲ����������Model,Map,HashMap,Request,Session��
	  * ���Դ���ֵ�Ե��඼����ͨ������Զ�ע�ᣨʵ��������ͨ��
	  * ��ֵ�����������������
	  * ����Ǿ�������ͣ����ƺ�jsp����һ�£�����ֱ�ӽ��ղ���
	  * ���������󣬿���ֱ�ӽ���jsp��������ڵ�get�������ֵ
	  */
	 //Ϊ���ܹ�������ַ���Դ˴�ͨ��ע����������ӳ��
	 @RequestMapping("/adv")
     public String anyname(Map  map,int id)
     {
		 InternalResourceViewResolver d;
    	 //id������������֮��ͬ��jsp���ݹ����Ĳ���
    	 map.put("msg", id);//���������������
    	 
    	 return "ok";
     }
}
