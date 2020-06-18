package Design;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Query extends JFrame{
	Button but1,but2;
	JTextField jt1,jt2,jt3;
	
	public Query() {
		setSize(Login.Width,Login.Heigth);
		setLocation(800,700);
		setTitle(new String("Query£º"));
		setLayout(new FlowLayout());
		Container con = getContentPane();
		jt1 = new JTextField(20);
		Label lb1 = new Label("Id card£º");
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
				con.setBackground(Color.yellow);
				Connection sin = LinkDB.getconnection();
						String Cid = jt1.getText();
						ResultSet rs = null;
						PreparedStatement stmt = null;
						try {
							stmt = sin.prepareStatement("select * from Client where Cid= ?");
							stmt.setObject(1, Cid);
							rs = stmt.executeQuery();
							while(rs.next()) {
								String msg = rs.getString("Cid")+"\t"+rs.getString("Cname")+"\t"+rs.getString("Csex")+"\n";
								JOptionPane.showMessageDialog(null, msg, "result",JOptionPane.NO_OPTION);
							}
						}catch(SQLException h) {
							h.printStackTrace();
						}
			}
		dispose();
		}
	}
}
