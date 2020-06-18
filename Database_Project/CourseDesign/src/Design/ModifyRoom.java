package Design;

import java.awt.*;
import javax.swing.*;

import Design.AddRoom.Enter;

import java.awt.event.*;
import java.sql.*;

public class ModifyRoom extends JFrame{
	Button but1,but2;
	JTextField jt1,jt2,jt3,jt4,jt5,jt6;
	
	public ModifyRoom() {
		setSize(320,300);
		setLocation(800,700);
		setTitle(new String("ModifyRoom"));
		setLayout(new FlowLayout());
		Container con = getContentPane();
		jt1 = new JTextField(20);
		Label lb1 = new Label("   Rno:");
		jt2 = new JTextField(20);
		Label lb2 = new Label("  Rsize:");
		jt3 = new JTextField(20);
		Label lb3 = new Label(" Rprice:");
		jt4 = new JTextField(20);
		Label lb4 = new Label("  Rtype:");
		jt5 = new JTextField(20);
		Label lb5 = new Label(" Rcond:");
		jt6 = new JTextField(20);
		Label lb6 = new Label(" Rfloor:");
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
				String Rno = jt1.getText();
				String Rsize = jt2.getText();
				String Rprice = jt3.getText();
				String Rtype = jt4.getText();
				String Rcond = jt5.getText();
				String Rfloor = jt6.getText();
					Connection sin = LinkDB.getconnection();
					try {
						String sql = "update Room set Rsize = '"+Rsize+"',Rprice = '"+Rprice+"',Rtype = '"+Rtype+"',Rcond'"+Rcond+"',Rfloor = '"+Rfloor+"'where Rno = "+Rno;
						Statement state = sin.createStatement();
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
