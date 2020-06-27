package com.web.ltw.ui; 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
import com.web.ltw.bean.Subject;
import com.web.ltw.service.impl.SubjectServiceImpl;
public class SpringManager { 
	public static void main(String[] args) {
		ApplicationContext ac=new 
		ClassPathXmlApplicationContext("com/web/gjg/spring/spring.xml");
		SubjectServiceImpl ssi=ac.getBean(SubjectServiceImpl.class);
		System.out.println("科目编号:\t科目名称:");
		for(Subject s:ssi.querySubjects())
		{
			System.out.println(s.getId()+"\t\t"+s.getName());
		}
	}

}
