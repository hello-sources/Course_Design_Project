package Design;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;
import javax.swing.*;

public class Login extends JFrame{
	public final static int Heigth = 270;
	public final static int Width = 300;
	JTextField jt1;
	JPasswordField jt2;
	JButton but1,but2;
	//String power;
	String imagePath = "D:\\Programe softwares\\JAVAfiles\\CourseDesign\\src\\Design\\hello.jpg";
	Image img = Toolkit.getDefaultToolkit().createImage(imagePath);
	Login(){
		Container con = getContentPane();
		
		Label lb1 = new Label("username£º");
		Label lb2 = new Label("password£º");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel(){
			protected void paintChildren(Graphics g) {
				g.drawImage(img, 0, 0, this);
				super.paintChildren(g);
			}
		};
		jt1 = new JTextField(15);
		jt2 = new JPasswordField(15);
		but1 = new JButton("login");
		but2 = new JButton("reset");
		p2.add(lb1);
		p2.add(jt1);
		p2.setBorder(new MatteBorder(0,0,0,0,Color.red));
		p2.setBackground(Color.BLUE);
		p3.add(lb2);
		p3.add(jt2);
		p3.setBackground(Color.green);
		p3.setBorder(new MatteBorder(0,0,0,0,Color.YELLOW));
		p4.add(but1);
		p4.add(but2);
		p4.setBorder(new MatteBorder(-3,-3,-3,-3,Color.blue));
		p4.setBackground(Color.orange);
		p5.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		p5.add(p2);
		p5.add(p3);
		p5.add(p4);
		con.add(p5,BorderLayout.CENTER);
		
		but1.addActionListener(new Enter());
		but2.addActionListener(new ReWrite());
		addWindowListener(new winClose());
	}
	
	public static void main(String args[]) {
		Login log = new Login();
		log.setTitle("Login interface");
		log.setLocation(600,400);
		log.setSize(400,300);
		log.setVisible(true);
	}
	
	class Enter implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if((jt1.getText()).equals("hello")&&String.valueOf((jt2.getPassword())).equals("123456"))
			{
				JOptionPane.showMessageDialog(null, "login succeed!");
				//power = "administrator";
				QFrame frame = new QFrame();
				frame.setLocation(400,300);
				frame.setSize(500,400);
				frame.setVisible(true);
				dispose();
			}
			else if((jt1.getText()).equals("world")&&String.valueOf((jt2.getPassword())).equals("123456"))
			{
				JOptionPane.showMessageDialog(null, "login succeed!");
				//power = "administrator";
				QFrame frame = new QFrame();
				frame.setLocation(400,300);
				frame.setSize(500,400);
				frame.setVisible(true);
				dispose();
			}
			else JOptionPane.showMessageDialog(null, "login failed!");
		}
			/*KeyListener key_Listener = new KeyListener() {
				public void keyTyped(KeyEvent e) {}
				public void keyReleased(keyEvent e) {}
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar() == KeyEvent.VK_ENTER)
				}
			}*/
	}
	
	class ReWrite implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			jt1.setText("");
			jt2.setText("");
			jt1.requestFocus();
		}
	}
	
	class winClose extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			e.getWindow().dispose();
			System.exit(0);
		}
	}
}
