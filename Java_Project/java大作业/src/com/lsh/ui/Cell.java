package com.lsh.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Cell extends JButton {

	public Cell(Icon arg0) {
		super(arg0);
		Font font=new Font("华文行楷", Font.BOLD, 30);
		this.setForeground(Color.red);
		this.setFont(font);
		this.setHorizontalTextPosition(CENTER);
		this.setVerticalTextPosition(CENTER);
		this.setBorder(new LineBorder(Color.BLUE));
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		super.setText(text);
		
	}

}
