package Design;

import java.awt.*;
import javax.swing.*;

//import Design.AddClient.Enter;

import java.awt.event.*;
import java.sql.*;

public class ModifyClient extends JFrame{
	Button but1,but2;
	JTextField jt1,jt2,jt3,jt4,jt5,jt6;
	
	public ModifyClient() {
		setSize(320,300);
		setLocation(500,400);
		setTitle(new String("ModifyClient"));
		setLayout(new FlowLayout());
		Container con = getContentPane();
		jt1 = new JTextField(20);
		Label lb1 = new Label("       Id:");
		jt2 = new JTextField(20);
		Label lb2 = new Label("    Age:");
		jt3 = new JTextField(20);
		Label lb3 = new Label("Name:");
		jt4 = new JTextField(20);
		Label lb4 = new Label("    Sex:");
		jt5 = new JTextField(20);
		Label lb5 = new Label("     Tel:");
		jt6 = new JTextField(20);
		Label lb6 = new Label("   Add:");
		but1 = new Button("Confirm");
		but2 = new Button("Cancel");
		add(lb1);
		add(jt1);
		add(lb2);
		add(jt2);
		add(lb3);
		add(jt3);
		add(lb4);
		add(jt4);
		add(lb5);
		add(jt5);
		add(lb6);
		add(jt6);
		add(but1);
		but1.addActionListener(new Enter());
		add(but2);
	}
	class Enter implements ActionListener{
		@SuppressWarnings("null")
		public void actionPerformed(ActionEvent e) {
			Container con = getContentPane();
			if(e.getActionCommand().equals("Confirm")){
				con.setBackground(Color.red);
				String Cid = jt1.getText();
				String Cage = jt2.getText();
				String Cname = jt3.getText();
				String Csex = jt4.getText();
				String Ctel = jt5.getText();
				String Cadd = jt6.getText();
					Connection sin = LinkDB.getconnection();
					PreparedStatement stmt = null;
					try {
						String sql = "update Client set Cage = '"+Cage+"',Cname = '"+Cname+"',Csex = '"+Csex+"',Ctel = '"+Ctel+"',Cadd = '"+Cadd+"'where Cid = "+Cid;
						Statement state = sin.createStatement();
						//stmt.setObject(10, Cid);
						state.executeUpdate(sql);
						sin.close();
					}catch(SQLException h) {
						h.printStackTrace();
					}
					}
			//dispose();
			}
		}
}
