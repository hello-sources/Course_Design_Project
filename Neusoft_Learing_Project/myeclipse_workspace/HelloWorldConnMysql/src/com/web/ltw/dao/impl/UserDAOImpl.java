package com.web.ltw.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.web.ltw.bean.User;
import com.web.ltw.dao.BaseDAO;
import com.web.ltw.dao.UserDAO;

public class UserDAOImpl extends BaseDAO implements UserDAO{
	public List<User> queryUsers(){
		List<User> users = new ArrayList<User>();
		String sql = "select *from t_user";
		Object[] objs = {};
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
				user.setRegdt(rs.getString("u.regdt"));
				user.setRole(rs.getInt("u_role"));
				user.setMark(rs.getString("u_mark"));
				users.add(user);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return users;
	}

	public Integer login(User user) throws Exception {
		Integer result = 0;
		String sql = "select count(*) r from t_user " + 
			"where u_name = ? and u_pwd = ? and u_role = ?";
		Object[] objs = {user.getName(),user.getPwd(),user.getRole()};
		try{
			ResultSet rs = executeQuery(sql,objs);
			if(rs.next())
			{
				result = rs.getInt("r");//r是别名
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return result;
	}

	public void register(User user) throws Exception {
		String sql = "insert into t_user(u_name,u_pwd,"+
		"u_realname,u_phone,u_role,u_mark)"+
		" values(?,?,?,?,?,?)";
		Object[] objs = {user.getName(),user.getPwd(),user.getRealname(),
				user.getPhone(),user.getRole(),user.getMark()};
		this.executeUpdate(sql,objs);
	}
}
