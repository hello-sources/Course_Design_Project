package Design;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddRoom extends JFrame{
	Button but1,but2;
	JTextField jt1,jt2,jt3,jt4,jt5,jt6;
	public AddRoom() {
		//setSize(Login.Heigth,Login.Width);
		setSize(320,300);
		setLocation(800,700);
		setTitle(new String("AddRoom"));
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
		add(but1);
		but1.addActionListener(new Enter());
		add(but2);
	}
	class Enter implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Container con = getContentPane();
			//AddRoom add = new AddRoom();
			if(e.getActionCommand().equals("Increase")) {
				con.setBackground(Color.GREEN);
					String Rno = jt1.getText();
					String Rsize = jt2.getText();
					String Rprice = jt3.getText();
					String Rtype = jt4.getText();
					String Rcond = jt5.getText();
					String Rfloor = jt6.getText();
					Object str[] = {Rno,Rsize,Rprice,Rtype,Rcond,Rfloor};
					Connection sin = LinkDB.getconnection();
					LinkDB.insert_1(sin,str);
					JOptionPane.showMessageDialog(null, "Add room success!", "Operation tips!", JOptionPane.NO_OPTION);
				//dispose();
			}
		}
	}
}
