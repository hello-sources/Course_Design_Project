package Design;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddInhotel extends JFrame{
	Button but1,but2;
	JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7,jt8;
	public AddInhotel() {
		//setSize(Login.Heigth,Login.Width);
		setSize(320,300);
		setLocation(800,700);
		setTitle(new String("AddInhotel"));
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
			//AddInhotel add = new AddInhotel();
			if(e.getActionCommand().equals("Increase")) {
				con.setBackground(Color.GREEN);
					String Cid = jt1.getText();
					String Rno = jt2.getText();
					String ComeT = jt3.getText();
					String LeftT = jt4.getText();
					String Idays = jt5.getText();
					String Icost = jt6.getText();
					String Idis = jt7.getText();
					String Irealpaid = jt8.getText();
					Object str[] = {Cid,Rno,ComeT,LeftT,Idays,Icost,Idis,Irealpaid};
					Connection sin = LinkDB.getconnection();
					LinkDB.insert_2(sin,str);
					JOptionPane.showMessageDialog(null, "Add Inhotel success!", "Operation tips!", JOptionPane.NO_OPTION);
				dispose();
			}
		}
	}
}
