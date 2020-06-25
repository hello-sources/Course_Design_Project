package com.web.ltw.dao;

import java.sql.*;//�������ݿ����ذ�

public class BaseDAO {
	public static void main(String args[]){
		new BaseDAO().getCon();
	}
	private Connection getCon()
	{
		Connection con = null;//ϰ�߾ֲ���������ֵ
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/db_heu";
		String user = "root";
		String password = "111111";
		try{
			//1�������������ݿ��������
			Class.forName(className);
			//2����ȡ�������ݿ�����Ӷ���
			con = DriverManager.getConnection(url,user,password);
			//syserr alt+?
			System.err.println("�������ݿ�ɹ���");//syserr alt+?
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return con;
		
	}

	/**
	 * 
	 * @param sql ����-�ַ��� ��ѯ���
	 * @para objs������ ����
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
