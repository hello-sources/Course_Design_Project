package Design;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Modify extends JFrame implements ActionListener{
	private JFrame frmMo;
	public Modify() {
		frmMo = new JFrame();
		setTitle("Modify");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("ModifeyClient");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton) {
					ModifyClient modc = new ModifyClient();
					modc.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(133, 52, 137, 27);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ModifyRoom");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton_1) {
					ModifyRoom modr = new ModifyRoom();
					modr.setVisible(true);
				}
			}
		});
		btnNewButton_1.setBounds(133, 92, 137, 27);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ModifyInhotel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton_2) {
					ModifyInhotel modi = new ModifyInhotel();
					modi.setVisible(true);
				}
			}
		});
		btnNewButton_2.setBounds(133, 132, 137, 27);
		getContentPane().add(btnNewButton_2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Modify mod = new Modify();
	}
}