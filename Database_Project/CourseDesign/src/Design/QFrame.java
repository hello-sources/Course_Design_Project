package Design;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

class QFrame extends JFrame implements ActionListener{
	JPanel contentPane;
	BorderLayout borderlayout1 = new BorderLayout(6,10);
	//Label prompt;
	JTextField jt;
	Button but1;
	
	public static final TextArea result = new TextArea(10,10);
	public static final TextArea result1 = new TextArea(10,10);
	
	public QFrame() {
		contentPane = (JPanel)this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		this.setTitle("Hotel room manage system!");
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//prompt = new Label("Process language£º");
		but1 = new Button("Start£º");
		result.setEditable(false);
		result1.setEditable(false);
		jt = new JTextField(100);
		JPanel option = new JPanel();
		
		
		
		
		Button add = new Button("Add");
		option.add(add,BorderLayout.NORTH);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == add) {
					Add add1 = new Add();
					add1.setVisible(true);
				}
			}
		});
		add.addActionListener(this);
		
		
		Button delete = new Button("Delete");
		option.add(delete,BorderLayout.NORTH);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == delete) {
					Delete del = new Delete();
					del.setVisible(true);
				}
			}
		});
		delete.addActionListener(this);
		
		
		
		Button modify = new Button("Modify");
		option.add(modify,BorderLayout.NORTH);
		modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == modify) {
					Modify mod = new Modify();
					mod.setVisible(true);
				}
			}
		});
		
		
		
		
		Button query=new Button("Query");
		  option.add(query,BorderLayout.NORTH);
		  query.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					 if(e.getSource()==query){
						 Query que = new Query();
						 que.setVisible(true);
					  }
					
				}
			});
		 query.addActionListener(this);
		 modify.addActionListener(this);
		 
		 
		
		Button refresh = new Button("Refresh");
		option.add(refresh,BorderLayout.NORTH);
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == refresh) {
					Connection sin = LinkDB.getconnection();
					ResultSet rs = LinkDB.query(sin);
					ResultSet rs2 = LinkDB.query_1(sin);
					try {
						result.setText("Refresh Client succeed!\n\n\n\n");
						result1.setText("Refresh Room succeed!\n\n\n\n");
						while(rs.next())
						{
							String msg = rs.getString("Cid")+"\t"+rs.getString("Cage")+"\t"+rs.getString("Cname")+"\t"+rs.getString("Csex")+"\t"+rs.getString("Ctel")+"\t"+rs.getString("Cadd")+"\n";
							result.append(msg);
						}
						while(rs2.next())
						{
							String msg1 = rs2.getString("Rno")+"\t"+rs2.getString("Rsize")+"\t"+rs2.getString("Rprice")+"\t"+rs2.getString("Rtype")+"\t"+rs2.getString("Rcond")+"\t"+rs2.getString("Rfloor")+"\n";
							result1.append(msg1);
						}
						sin.close();
						rs.close();
						rs2.close();
					}catch(Exception h) {
						h.printStackTrace();
					}
				}
			}
		});
		modify.addActionListener(this);
		
		
		Button logout = new Button("Exit");
		option.add(logout,BorderLayout.NORTH);
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == logout) {
					System.exit(0);
				}
			}
		});
		
		
		//contentPane.add(prompt,BorderLayout.WEST);
		//contentPane.add(jt,BorderLayout.CENTER);
		//contentPane.add(but1,BorderLayout.EAST);
		contentPane.add(result,BorderLayout.CENTER);
		contentPane.add(option,BorderLayout.NORTH);
		contentPane.add(result1,BorderLayout.SOUTH);
		but1.addActionListener(this);
	}
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == but1) {
				String url = "jdbc:sqlserver://localhost:1433;DatabaseName = CourseDesign";
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					String user = "sa";
					String password = "123456";
					Connection con = DriverManager.getConnection(url, user, password);
					//String msg1 = "Link succeed!";
					result.setText("Link succeed!\n\n\n");
					
					String yuju = jt.getText();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(yuju);
					while(rs.next()) {
						String msg = rs.getString("Cid")+"\t"+rs.getString("Cname")+"\t"+rs.getString("Cage")+"\n";
						result.append(msg);
					}
					rs.close();
					st.close();
					con.close();
				}catch(SQLException sqle) {
					result.setText(sqle+"Link error!");
				}
			catch(Exception h) {
				result.setText(h+"error");
			}
		}
	}
}