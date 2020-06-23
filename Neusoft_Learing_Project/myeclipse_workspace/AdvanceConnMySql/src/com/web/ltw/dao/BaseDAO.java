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
			//����ע�͵Ĵ�����Ҫ��Ϊ�˷�ֹ����һֱ���ִ���
			//JOptionPane.showMessageDialog(null, "�������ӳɹ��Ĵ���");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	/**
	 * 
	 * @param sql ����-�ַ��� ��ѯ���
	 * @param objs������ ����
	 * @return ���ؽ��������
	 * 
	 */
	public ResultSet executeQuery(String sql,Object[] objs){
		ResultSet rs = null;
		try{
			//3:����Ԥ�������
			PreparedStatement ps = getCon().prepareStatement(sql);
			for( int i = 0;i < objs.length;i++){
				//Ԥ��������г��ֵģ���������1��ʼ��ֵ�Ǵ�����Ϊ0��ʼ
				ps.setObject(i+1,objs[i]);
			}
			rs = ps.executeQuery();
		}catch(Exception e){
			//���try�еĴ������쳣һ��ִ�е�����ʾ��صĴ�����Ϣ
			//e.getMessage
			System.out.println(e.getMessage());
		}	
		return rs;
	}
	
	/**
	 * 
	 * @param sql�����ַ��� ��ɾ�����
	 * @param objs ��ɾ�ĵ������ֵı����� ����
	 */
	public void executeUpdate(String sql,Object[] objs){
		try{
			//3:����Ԥ�������
			PreparedStatement ps = getCon().prepareStatement(sql);
			for( int i = 0;i < objs.length;i++){
				//Ԥ��������г��ֵģ���������1��ʼ��ֵ�Ǵ�����Ϊ0��ʼ
				ps.setObject(i+1,objs[i]);
			}
			ps.executeUpdate();//��ɾ��ʹ��ͬһ������
		}catch(Exception e){
			//���try�еĴ������쳣һ��ִ�е�����ʾ��صĴ�����Ϣ
			//e.getMessage
			System.out.println(e.getMessage());
		}	
	}
}
