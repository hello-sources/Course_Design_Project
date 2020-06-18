package Design;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Delete extends JFrame{
	Button but1,but2;
	JTextField jt1,jt2,jt3;
	
	public Delete() {
		setSize(Login.Width,Login.Heigth);
		setLocation(800,700);
		setTitle(new String("Delete:"));
		setLayout(new FlowLayout());
		Container con = getContentPane();
		jt1 = new JTextField(20);
		Label lb1 = new Label("Cid:");
		but1 = new Button("Confirm");
		but1.addActionListener(new Enter());
		but2 = new Button("Cancel");
		add(lb1);
		add(jt1);
		add(but1);
		add(but2);
	}
	
	class Enter implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Container con = getContentPane();
			if(e.getActionCommand().equals("Confirm")) {
				con.setBackground(Color.green);
				Connection sin = LinkDB.getconnection();
				String Cid = jt1.getText();
				
					//PreparedStatement stmt;
					//stmt = sin.prepareStatement("delete * from Client where Cid = ?");
					//stmt.setObject(1, Cid);
					//stmt.execute();
				LinkDB.delete(sin, Cid);
				
				dispose();
				
			}
		}
	}
}
