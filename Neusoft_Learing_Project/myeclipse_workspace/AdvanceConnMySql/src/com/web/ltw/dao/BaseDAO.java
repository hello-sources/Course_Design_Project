package com.web.ltw.dao;

import java.sql.*;

public class BaseDAO implements DAO {
	public static void main(String args[]){
		new BaseDAO().getCon();
	}
	private Connection getCon(){
		Connection con = null;
		try{
			Class.forName(CLASSNAME);
			
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			//下面注释的代码主要是为了防止后面一直出现窗口
			//JOptionPane.showMessageDialog(null, "弹出连接成功的窗口");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	/**
	 * 
	 * @param sql 参数-字符串 查询语句
	 * @param objs参数集 数组
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
