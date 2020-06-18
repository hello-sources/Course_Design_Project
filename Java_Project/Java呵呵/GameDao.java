
package com.rookie.dao;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.rookie.view.GamerView;

public class GameDao implements ActionListener{
    //按钮组
    private JButton []buttons = new JButton[9];
    //按钮初始化组表
    private final int x = 30;
    private final int y = 55;
    //按钮大小
    private final int width = 73;
    private final int height = 107;
    private boolean beFlag = true;
    private JButton beButton = null;
    private int []randomNum = new int[9];
    private Point p[] = new Point[9];
    private Point ps;
    public GameDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void initButton(JPanel panel) {
        panel.setLayout(null);
        int wNum = 0;
        int hNum = 0;
        for(int i=0;i< buttons.length;i++) {    
            buttons[i] = new JButton();
            buttons[i].setVisible(true);
            p[i] = new Point( y+width*wNum++,x+height*hNum);
            buttons[i].setBounds(p[i].x, p[i].y, width, height);
            if((i+1)%3==0) {
                hNum++;
                wNum=0;
            }
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);        
        }        
    }
    
    public void randomLoadPic(int picId) {
        int rNum = 0;
        randomNum = new int[9];
        for(int i=0;i < buttons.length;i++) {
            try {
                rNum = (int)(Math.random()*9);
                while(buttons[rNum].getIcon() != null) {
                    rNum = (int)(Math.random()*9)%9;
                }
                randomNum[i] = rNum;
                StringBuffer str = new StringBuffer(
                        "/LoadImage/image_" + picId + "/simple/image_" + picId + "_0" + (i+1) + ".png");
                buttons[rNum].setIcon(new ImageIcon(GamerView.class.getResource(str.toString())));    
                buttons[rNum].setActionCommand(""+rNum);
                randomNum[i] = rNum;
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, "异常错误，即将退出");
                System.exit(0);
            }
            
        }
    }
    
    public void resetButton() {
        for(int i=0;i < buttons.length;i++) {
            try {
                buttons[i].setIcon(null);
                buttons[i].setVisible(false);
                buttons[i] = null;
            }catch(NullPointerException e) {
                JOptionPane.showMessageDialog(null, "发生错误！！");
            }
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        if(beFlag == true) {        //第一次点击
             beButton = (JButton)e.getSource();
             beFlag = false;
        }else {
            JButton nowButton = (JButton)e.getSource();
            int nX = nowButton.getX();
            int nY = nowButton.getY();
            int bX = beButton.getX();
            int bY = beButton.getY();
              
            if((Math.abs(nX-bX)<width && Math.abs(nY-bY)<=height)||(Math.abs(nX-bX)<=width && Math.abs(nY-bY)<height)) {    
                beButton.setBounds(nX, nY, width, height);
                nowButton.setBounds(bX,bY,width,height);
            }else {
                JOptionPane.showMessageDialog(null, "选取错误！！！");
            }
            this.successGame();
        }
    }
    
    public void successGame() {
        for(int i=0;i<9;i++) {
            ps = buttons[randomNum[i]].getLocation();
            if( ps.x == p[i].x && ps.y == p[i].y) {

            }else {
                return ;
            }
        }            
        JOptionPane.showMessageDialog(null, "胜利！");
        GamerView.resetGame();
    }
}

