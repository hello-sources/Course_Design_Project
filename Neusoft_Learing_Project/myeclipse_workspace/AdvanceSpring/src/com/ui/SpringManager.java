package com.ui;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class SpringManager {
	public static void main(String[] args) {
		//��֯ ��˾ ���� database connection pool ���ݿ����ӳ�
		//org.apache.commons.dbcp.BasicDataSource
		BasicDataSource d;
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext("spring.xml");
		try {
			BasicDataSource dataSource = 
				ac.getBean("dataSource", BasicDataSource.class);
			Connection con = dataSource.getConnection();
			System.out.println("ok");
			String sql = "select * from t_subject";
			java.sql.PreparedStatement ps = con.prepareStatement(sql);
			java.sql.ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("s_id")+"\t"+rs.getString("s_name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�������ݿ�ʧ��");
		}
		
		
	}
}
