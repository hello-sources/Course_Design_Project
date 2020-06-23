package com.web.ltw.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.web.ltw.bean.User;
import com.web.ltw.dao.BaseDAO;
import com.web.ltw.dao.UserDAO;

public class UserDAOImpl extends BaseDAO implements UserDAO {

	public String login(User user) {
		String pwd = "";
		String sql = "select u_pwd from t_user where u_name = ? and u_role = ?";
		Object[] objs ={user.getName(),user.getRole()};
		try{
			ResultSet rs = super.executeQuery(sql, objs);
			if(rs.next()){
				pwd = rs.getString("u_pwd");//u_pwd表的列名
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return pwd;
	}

	public List<User> pagination(Integer pageIndex, Integer pageSize) {
		List<User> users = new ArrayList<User>();
		/*limit限定行，第一个参数是开始的索引，0为从第一行开始，第二个参数为每一页的大小*/
		String sql="select * from t_user limit ?,?";
		/*如果是第一页(pageIndex-1)*pageSize=0
		 * 如果是第二页(pageIndex-1)*pageSize就是页的大小*/
		Object[] objs = {(pageIndex-1)*pageSize,pageSize};
		try{
			ResultSet rs = executeQuery(sql,objs);
			//利用循环读取每一行，只要有数据为真
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("u_id"));//u_id为列名
				user.setName(rs.getString("u_name"));
				user.setPwd(rs.getString("u_pwd"));
				user.setRealname(rs.getString("u_realname"));
				user.setPhone(rs.getString("u_phone"));
				user.setRegdt(rs.getString("u_regdt"));
				user.setRole(rs.getInt("u_role"));
				user.setMark(rs.getString("u_mark"));
				users.add(user);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return users;
	}

	
	public void register(User user) {
		String sql = "insert into t_user(u_name,u_pwd,"+
		"u_realname,u_phone,u_role,u_mark)"+
		" values(?,?,?,?,?,?)";
		Object[] objs = {user.getName(),user.getPwd(),user.getRealname(),
				user.getPhone(),user.getRole(),user.getMark()};
		this.executeUpdate(sql,objs);

	}
	
	
	//统计总行数
	public Integer totalRow() {
		Integer row = 0;
		String sql = "select count(*) r from t_user";
		Object[] objs =  {};
		try{
			ResultSet rs = super.executeQuery(sql, objs);
			if(rs.next()){
				row = rs.getInt("r");//u_pwd表的列名
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return row;
	}

}
