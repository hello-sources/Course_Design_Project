package Design;

import java.awt.*;
import java.io.*;
import java.net.URL.*;
import javax.swing.*;
import java.sql.*;

public class LinkDB {
	public final static Connection getconnection() {
		Connection con = null;
		String url = "jdbc:sqlserver://localhost:1433;databaseName=CourseDesign";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String user = "sa";
			String password = "123456";
			con = DriverManager.getConnection(url, user, password);
			con.setCatalog("CourseDesign");
		}
		catch(SQLException sqle){
			System.out.println(sqle+"Link succeed!");
		}catch(Exception e) {
			System.out.println(e+"Link failed!");
		}
		return con;
	}
	
	public final static void insert_1(Connection con,Object obj[]) {
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("insert into Room(Rno,Rsize,Rprice,Rtype,Rcond,Rfloor)values(?,?,?,?,?,?)");
			stmt.setString(1, obj[0].toString());
			stmt.setString(2, obj[1].toString());
			stmt.setString(3, obj[2].toString());
			stmt.setString(4, obj[3].toString());
			stmt.setString(5, obj[4].toString());
			stmt.setString(6, obj[5].toString());
			stmt.execute();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Failed", "operation tips!", JOptionPane.NO_OPTION);
		}
	}
	
	
	public final static void insert_2(Connection con,Object obj[]) {
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("insert into Inhotel(Cid,Rno,ComeT,LeftT,Idays,Icost,Idis,Irealpaid)values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, obj[0].toString());
			stmt.setString(2, obj[1].toString());
			stmt.setString(3, obj[2].toString());
			stmt.setString(4, obj[3].toString());
			stmt.setString(5, obj[4].toString());
			stmt.setString(6, obj[5].toString());
			stmt.setString(7, obj[4].toString());
			stmt.setString(8, obj[5].toString());
			stmt.execute();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Failed", "operation tips!", JOptionPane.NO_OPTION);
		}
	}
	
	
	public final static void insert_3(Connection con,Object obj[]) {
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("insert into Client(Cid,Cage,Cname,Csex,Ctel,Cadd)values(?,?,?,?,?,?)");
			stmt.setString(1, obj[0].toString());
			stmt.setString(2, obj[1].toString());
			stmt.setString(3, obj[2].toString());
			stmt.setString(4, obj[3].toString());
			stmt.setString(5, obj[4].toString());
			stmt.setString(6, obj[5].toString());
			stmt.execute();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Failed", "operation tips!", JOptionPane.NO_OPTION);
		}
	}
	
	
	
	public final static ResultSet query(Connection con) {
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("select * from Client");
			rs = stmt.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	
	public final static ResultSet query_1(Connection con) {
		ResultSet rs2 = null;
		PreparedStatement stmt2 = null;
		try {
			stmt2 = con.prepareStatement("select * from Room");
			rs2 = stmt2.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs2;
	}
	
	public final static void delete(Connection con,String s) {
		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement("delete from Client where Cid = ? ");
			stmt.setObject(1, s);
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
		}
	}
	
	public final static void delete_2(Connection con,String s) {
		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement("delete from Room where Rno = ? ");
			stmt.setObject(1, s);
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
		}
	}
	
	public final static void delete_3(Connection con,String s) {
		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement("delete from Inhotel where Cid = ? ");
			stmt.setObject(1, s);
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
		}
	}
}
