package com.lsh.ui;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class PictureCanvas extends JPanel implements ActionListener {
	
	private Cell[] cell=new Cell[12];
	public static int pictureID=1;
	public static int stepNum=0;
	private JButton oldButton=null;
	private int addx=110;
	private int addy=110;
	/**
	 * Create the panel.
	 */
	public PictureCanvas() {
		setLayout(null);
		addx = 110;
		addy = 110;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				ImageIcon icon=new ImageIcon(String.format("picture/p%d/p%d_%02d.jpg",PictureCanvas.pictureID,PictureCanvas.pictureID,i*3+j+1));
				cell[i*3+j]=new Cell(icon);
				cell[i*3+j].setBounds(5+j*addx, 5+i*addy,addx, addy);
				this.add(cell[i*3+j]);
				
			}
		}
	}
	public void reLoadPictureAddNumber(){
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				cell[i*3+j].setText(i*3+j+1+"");
			}
		}
	}
	
	public void reLoadPictureClearNumber(){
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				ImageIcon icon=new ImageIcon(String.format("picture/p%d/p%d_%02d.jpg",PictureCanvas.pictureID,PictureCanvas.pictureID,i*3+j+1));
				cell[i*3+j].setIcon(icon);
				cell[i*3+j].setText("");
			}
		}
	}
	public void reLoadImg(){
		if(oldButton!=null)
			oldButton.setBorder(new LineBorder(Color.BLUE));
		oldButton=null;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				ImageIcon icon=new ImageIcon(String.format("picture/p%d/p%d_%02d.jpg",PictureCanvas.pictureID,PictureCanvas.pictureID,i*3+j+1));
				cell[i*3+j].setIcon(icon);
				cell[i*3+j].setBounds(5+j*addx, 5+i*addy,addx, addy);
				cell[i*3+j].removeActionListener(this);
			}
		}
	}
	public void start() {
		int size=cell.length;
		stepNum=0;
		//变异
		for (int i = 0; i < size; i++) {
			Random random=new Random();
			int i1=random.nextInt(size);
			int i2=random.nextInt(size);
			switchCell(cell[i1], cell[i2]);
		}
		for (Cell cell2 : cell) {
			cell2.removeActionListener(this);
			cell2.addActionListener(this);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton=(JButton)e.getSource();
		if(oldButton==null){
			jButton.setBorder(new LineBorder(Color.RED));
			oldButton=jButton;
		}else{
			switchCell(oldButton, jButton);
			stepNum++;
			PictureMainFrame.textField_1.setText("步数："+stepNum);
			if(isFinish()){
				JOptionPane.showMessageDialog(this, "SUCCESS!");
				if(oldButton!=null)
					oldButton.setBorder(new LineBorder(Color.BLUE));
				oldButton=null;
				for (Cell cell2 : cell) {
					cell2.removeActionListener(this);
				}
			}		
		}
	}
	private boolean isFinish() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				Cell ce=cell[i*3+j];
				if(ce.getX()!=5+j*110||ce.getY()!=5+i*110){
					return false;
				}
			}
		}
		return true;
	}
	private void switchCell(JButton cell1,JButton cell2){
		if(cell1==cell2)
			return;
		Point point=cell1.getLocation();
//		Point point2=cell2.getLocation();
//		if(Math.abs(point.x-point2.x)>110||Math.abs(point.y-point2.y)>110)//8格中移动
//			return;
//		if(Math.abs(point.x-point2.x)==Math.abs(point.y-point2.y))//对角，4格中移动
//			return;
		cell1.setLocation(cell2.getLocation());
		cell2.setLocation(point);
	}
}
