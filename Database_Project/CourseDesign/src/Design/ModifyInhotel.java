package Design;

import java.awt.*;
import javax.swing.*;

import Design.AddInhotel.Enter;

import java.awt.event.*;
import java.sql.*;

public class ModifyInhotel extends JFrame{
	Button but1,but2;
	JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7,jt8;
	
	public ModifyInhotel() {
		setSize(320,300);
		setLocation(800,700);
		setTitle(new String("ModifyInhotel"));
		setLayout(new FlowLayout());
		Container con = getContentPane();
		jt1 = new JTextField(20);
		Label lb1 = new Label("   Rno:");
		jt2 = new JTextField(20);
		Label lb2 = new Label("      Id:");
		jt3 = new JTextField(20);
		Label lb3 = new Label("ComeT:");
		jt4 = new JTextField(20);
		Label lb4 = new Label("  LeftT:");
		jt5 = new JTextField(20);
		Label lb5 = new Label("  Idays:");
		jt6 = new JTextField(20);
		Label lb6 = new Label("  Icost:");
		jt7 = new JTextField(20);
		Label lb7 = new Label("   Idis:");
		jt8 =  new JTextField(20);
		Label lb8 = new Label("Irealpay:");
		but1 = new Button("Increase");
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
		add(lb7);
		add(jt7);
		add(lb8);
		add(jt8);
		add(but1);
		but1.addActionListener(new Enter());
		add(but2);
	}
	class Enter implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Container con = getContentPane();
			if(e.getActionCommand().equals("Increase")){
				con.setBackground(Color.red);
				String Cid = jt1.getText();
				String Rno = jt2.getText();
				String ComeT = jt3.getText();
				String LeftT = jt4.getText();
				String Idays = jt5.getText();
				String Icost = jt6.getText();
				String Idis = jt7.getText();
				String Irealpaid = jt8.getText();
					Connection sin = LinkDB.getconnection();
					PreparedStatement stmt = null;
					//ResultSet rs = null;
					try {
						String sql = "update Inhotel set Rno = '"+Rno+"',ComeT = '"+ComeT+"',LeftT = '"+LeftT+"',Idays'"+Idays+"',Icost = '"+Icost+"',Idis = '"+Idis+"',Irealpaid'"+Irealpaid+"'where Cid = "+Cid;
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
