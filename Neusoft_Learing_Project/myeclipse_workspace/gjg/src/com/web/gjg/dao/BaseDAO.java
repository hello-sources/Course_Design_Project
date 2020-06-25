package com.web.gjg.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.web.gjg.bean.User;
import com.web.gjg.mapper.UserMapper;

public class BaseDAO {
	public SqlSession getSession()
	{
		SqlSession sqlSession=null;
		try {			
			String resource = "com/web/gjg/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession=sqlSessionFactory.openSession();
			//System.out.println("ok");				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sqlSession;
	}
}
