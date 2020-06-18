package Design;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Add extends JFrame implements ActionListener{
	private JFrame frmHello;
	public Add() {
		frmHello = new JFrame();
		setBackground(new Color(120, 120, 120));
		setTitle("hello");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("AddClient");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton) {
					AddClient addc = new AddClient();
					addc.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(138, 58, 130, 27);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AddRoom");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton_1) {
					AddRoom addr = new AddRoom();
					addr.setVisible(true);
				}
			}
		});
		btnNewButton_1.setBounds(138, 98, 130, 27);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("AddInhotel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton_2) {
					AddInhotel addi = new AddInhotel();
					addi.setVisible(true);
				}
			}
		});
		btnNewButton_2.setBounds(138, 138, 130, 27);
		getContentPane().add(btnNewButton_2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new Add();
	}

}