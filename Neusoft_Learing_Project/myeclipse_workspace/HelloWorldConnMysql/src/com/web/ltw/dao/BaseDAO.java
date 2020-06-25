package com.web.ltw.dao;

import java.sql.*;//导入数据库的相关包

public class BaseDAO {
	public static void main(String args[]){
		new BaseDAO().getCon();
	}
	private Connection getCon()
	{
		Connection con = null;//习惯局部变量赋初值
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/db_heu";
		String user = "root";
		String password = "111111";
		try{
			//1：加载链接数据库的驱动类
			Class.forName(className);
			//2：获取链接数据库的链接对象
			con = DriverManager.getConnection(url,user,password);
			//syserr alt+?
			System.err.println("连接数据库成功！");//syserr alt+?
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return con;
		
	}

	/**
	 * 
	 * @param sql 参数-字符串 查询语句
	 * @para objs参数集 数组
	 * @return 返回结果集对象
	 * 
	 */
	public ResultSet executeQuery(String sql,Object[] objs){
		ResultSet rs = null;
		try{
			//3:创建预编译对象
			PreparedStatement ps = getCon().prepareStatement(sql);
			for( int i = 0;i < objs.length;i++){
				//预编译语句中出现的？，索引从1开始，值是从数组为0开始
				ps.setObject(i+1,objs[i]);
			}
			rs = ps.executeQuery();
		}catch(Exception e){
			//如果try中的代码有异常一定执行到才显示相关的错误信息
			//e.getMessage
			System.out.println(e.getMessage());
		}	
		return rs;
	}
	
	/**
	 * 
	 * @param sql参数字符串 增删改语句
	 * @param objs 增删改的语句出现的变量集 数组
	 */
	public void executeUpdate(String sql,Object[] objs){
		try{
			//3:创建预编译对象
			PreparedStatement ps = getCon().prepareStatement(sql);
			for( int i = 0;i < objs.length;i++){
				//预编译语句中出现的？，索引从1开始，值是从数组为0开始
				ps.setObject(i+1,objs[i]);
			}
			ps.executeUpdate();//增删改使用同一个命令
		}catch(Exception e){
			//如果try中的代码有异常一定执行到才显示相关的错误信息
			//e.getMessage
			System.out.println(e.getMessage());
		}	
	}
}
