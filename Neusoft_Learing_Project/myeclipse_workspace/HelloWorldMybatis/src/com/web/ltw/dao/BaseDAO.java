package com.web.ltw.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.web.ltw.bean.User;
import com.web.ltw.mapper.UserMapper;

public class BaseDAO {
	public SqlSession getSession(){
		SqlSession sqlSession = null;
		try{
			String resource = "com/web/ltw/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource); 
			SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			System.out.println("ok");
			//queryUsers����UserMapper.xml�е�Ψһ��id��ֵ
//			List<User> users = sqlSession.selectList("queryUsers");
//			for(User user:users){
//				System.out.println(user.getName());
//			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return sqlSession;
	}
	
	
	static UserMapper um= new BaseDAO().getSession().getMapper(UserMapper.class);
	public static Integer totalRow(){
		//System.out.println("row = "+um);
		return um.getRow();//�ӿڵķ�������mybatis������ȥ�ҽ�getRow��id
	}
	
	
	public static User queryUserById(Integer id){
		return um.queryUserById(id);
	}
	
	public static void main(String args[]){
//		try{
//			String resource = "com/web/ltw/config/mybatis-config.xml";
//			InputStream inputStream = Resources.getResourceAsStream(resource); 
//			SqlSessionFactory sqlSessionFactory = 
//				new SqlSessionFactoryBuilder().build(inputStream);
//			SqlSession sqlSession = sqlSessionFactory.openSession();
//			//queryUsers����UserMapper.xml�е�Ψһ��id��ֵ
//			List<User> users = sqlSession.selectList("queryUsers");
//			for(User user:users){
//				System.out.println(user.getName());
//			}
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//		}
		System.out.println("�������� "+totalRow());
		User user = queryUserById(1);
		System.out.println(user.getName()+user.getPwd()+user.getRealname());
	}
}
