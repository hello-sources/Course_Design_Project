package LTW2017061614;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
/*游戏界面画板*/
public class GamePanel extends JPanel implements KeyListener{
	private static final long serialVersionUID = 1L;
	public int MAPCOL=13;				//游戏画布的列数	 
	public int MAPROW=22;				//游戏画布的行数     
	public int PIXEL=30;				//像素，单位格子的长、宽
	public int score;
	public int map[][]=new int[MAPCOL][MAPROW];
	public Timer timer ;
	private int Level=5;				//初始难度5
	private Block block;				//引用Block类
	private TimerListener timerlistener;
	/* 内部类，被timer触发 */
	private class TimerListener implements ActionListener{		//实现接口

		public void actionPerformed(ActionEvent e) {
			if(!isCollied(block.x,block.y+1)){
				block.y++;			
			}else{
				block.add();		//碰撞到底部后，把方块添加到画布上去					
				deleteLine();
				if(true==isGameover()){
					JOptionPane.showMessageDialog(null, "Game Over\nscore:"+score);
					cleanMap();
					drawWall();
					score=0;		
				}
				block.newblock();
			}				
			repaint();				//重画
		}
	}
	/* 构造方法*/
	GamePanel(){
		block = new Block(this);	//引用Block类，参数是GamePanel类
		cleanMap();
		drawWall();
		block.newblock();
		timerlistener=new TimerListener();
		timer = new Timer(800, timerlistener);   //计时器，在指定时间间隔触发TimerListener()
	}
	/* 增加难度*/
	private void upLevel(){
		if(Level<10){
			Level++;
			timer.setDelay(1300-100*Level);
			repaint();
		}
	}
	/* 降低难度 */
	private void downLevel(){
		if(Level>0){
			Level--;
			timer.setDelay(1300-100*Level);
			repaint();
		}
	}
	/* 围墙内的画面置零，相当于清除画面*/
	private void cleanMap(){
		for(int i=1;i<MAPCOL-2;i++){			
			for(int j=0;j<MAPROW-2;j++){
				map[i][j]=0;
			}
		}     
	}
	/* 画围墙，用2标示为围墙*/
	private void drawWall(){			
		for(int i=0;i<MAPCOL-1;i++){
			map[i][MAPROW-2]=2;
		}
		for(int j=0;j<MAPROW-2;j++){
			map[0][j]=2;
			map[MAPCOL-2][j]=2;
		}
	}
	/* 得到画笔来画TeTirsPanel*/
	protected void paintComponent(Graphics g) {		
		super.paintComponent(g);		
		for(int j=0;j<MAPROW-1;j++){
			for(int i=0;i<MAPCOL-1;i++){
			/*	if(2==map[i][j]){
					g.setColor(Color.ORANGE);
					g.fillRect(i*PIXEL, j*PIXEL, PIXEL, PIXEL);   //画围墙格子
				}	*/											  //现把其隐藏	
				//画出固定好的方块
				if(1==map[i][j]){
					g.setColor(Color.GREEN);
					g.fill3DRect(i*PIXEL, j*PIXEL, PIXEL, PIXEL,true);   
				}
			}
		}
		//画竖线
		for(int i=1;i<MAPCOL-1;i++){	
			g.setColor(Color.BLACK);
			g.drawLine(i*PIXEL, 0, i*PIXEL, (MAPROW-2)*PIXEL);		
		}
		//画横线
		for(int j=0;j<MAPROW-1;j++){	
			g.setColor(Color.BLACK);
			g.drawLine(PIXEL*1, j*PIXEL, (MAPCOL-2)*PIXEL, j*PIXEL);
		}
		//画未固定方块，16是shapes数组的第一维长度
		//x,y是方块正处于的坐标(提示x要加1)
		for(int i=0;i<16;i++){											
			if(1==block.shapes[block.blockType][block.blockState][i]){
				g.setColor(Color.BLUE);
				g.fill3DRect((block.x+1+i%4)*PIXEL,(block.y+i/4)*PIXEL,PIXEL,PIXEL,true);	//用shapes数组来画出方块
			}
		}	
		g.setColor(Color.darkGray);
		g.setFont(new Font("黑体", Font.BOLD, 30)); 
		g.drawString("score："+score,MAPCOL*PIXEL,3*PIXEL-35);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3.0f));
		g2.drawLine(MAPCOL*PIXEL-30, 3*PIXEL-85, MAPCOL*PIXEL+170, 3*PIXEL-85);			//横线1
		g2.drawLine(MAPCOL*PIXEL-30, 3*PIXEL, MAPCOL*PIXEL+170, 3*PIXEL);				//横线2
		g2.drawLine(MAPCOL*PIXEL-30, 3*PIXEL-85, MAPCOL*PIXEL-30, 3*PIXEL);				//竖线1
		g2.drawLine(MAPCOL*PIXEL+170, 3*PIXEL-85, MAPCOL*PIXEL+170, 3*PIXEL);			//竖线2	
		
		g2.drawLine(MAPCOL*PIXEL-30, 5*PIXEL-40, MAPCOL*PIXEL+170, 5*PIXEL-40);			//横线1
		g2.drawLine(MAPCOL*PIXEL-30, 5*PIXEL+20, MAPCOL*PIXEL+170, 5*PIXEL+20);			//横线2
		g2.drawLine(MAPCOL*PIXEL-30, 7*PIXEL+20, MAPCOL*PIXEL+170, 7*PIXEL+20);			//横线3
		g2.drawLine(MAPCOL*PIXEL-30, 9*PIXEL+20, MAPCOL*PIXEL+170, 9*PIXEL+20);			//横线4
		g2.drawLine(MAPCOL*PIXEL-30, 11*PIXEL+20, MAPCOL*PIXEL+170, 11*PIXEL+20);		//横线5
		g2.drawLine(MAPCOL*PIXEL-30, 13*PIXEL+20, MAPCOL*PIXEL+170, 13*PIXEL+20);		//横线6
		g2.drawLine(MAPCOL*PIXEL-30, 15*PIXEL+20, MAPCOL*PIXEL+170, 15*PIXEL+20);		//横线7
		g2.drawLine(MAPCOL*PIXEL-30, 17*PIXEL+20, MAPCOL*PIXEL+170, 17*PIXEL+20);		//横线8
		g2.drawLine(MAPCOL*PIXEL-30, 19*PIXEL+20, MAPCOL*PIXEL+170, 19*PIXEL+20);		//横线9
		g2.drawLine(MAPCOL*PIXEL-30, 5*PIXEL-40, MAPCOL*PIXEL-30, 19*PIXEL+20);			//竖线1
		g2.drawLine(MAPCOL*PIXEL+170, 5*PIXEL-40, MAPCOL*PIXEL+170, 19*PIXEL+20);		//竖线2
		
		g.setFont(new Font("黑体", Font.BOLD, 22));
		g.drawString("operationa", MAPCOL*PIXEL, 5*PIXEL);
		g.drawString("↑   overturn",MAPCOL*PIXEL,7*PIXEL);
		g.drawString("↓   down",MAPCOL*PIXEL,9*PIXEL);
		g.drawString("←   left",MAPCOL*PIXEL,11*PIXEL);
		g.drawString("→   right",MAPCOL*PIXEL,13*PIXEL);
		g.drawString("F1  pause", MAPCOL*PIXEL, 15*PIXEL);
		g.drawString("F2 increasedif", MAPCOL*PIXEL, 17*PIXEL);
		g.drawString("F3 lowerdif", MAPCOL*PIXEL, 19*PIXEL);
	}
	
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:		
				block.turnState();
				break;
		case KeyEvent.VK_LEFT:		
				block.left();
				break;

		case KeyEvent.VK_DOWN:		
				block.down();
				break;
				
		case KeyEvent.VK_RIGHT:		
				block.right();
				break;

		case KeyEvent.VK_F1:		
				timer.stop();
				JOptionPane.showMessageDialog(null, "please confirm to pause");
				timer.restart();
				break;
				
		case KeyEvent.VK_F2:		
				upLevel();
				break;

		case KeyEvent.VK_F3: 		
				downLevel();
				break;
		}
	}
	public void keyTyped(KeyEvent e) {
	}


	public void keyReleased(KeyEvent e) {	
	}
	/* 判断是否碰撞*/
	public boolean isCollied(int x,int y){			
		for(int a=0;a<4;a++){			//遍历
			for(int b=0;b<4;b++){
				if((block.shapes[block.blockType][block.blockState][a*4+b]==1)&&(map[x+1+b][y+a]==1)){	//判断是否重合
					return true;
				}else if((block.shapes[block.blockType][block.blockState][a*4+b]==1)&&(map[x+1+b][y+a]==2)){	//与围墙 
					return true;
				}
			}
		}
		return false;
	}
	/* 判断是否结束游戏*/
	public boolean isGameover(){
		for(int i=1;i<MAPCOL-3;i++){
			if(map[i][0]==1){
				return true;		
			}
		}
		return false;
	}
	/* 消行*/
	public void deleteLine(){
		int count = 0;
		for(int i=0;i<MAPROW-2;i++){
			for(int j=1;j<MAPCOL-2;j++){
				if(map[j][i]==1){
					count++;
					if(count==MAPCOL-3){			//一行都满的话，总数为MAPCOL-3个，满足则消行
						score+=10;
						for(int a=i;a>0;a--){			//从第i行开始
							for(int b=1;b<MAPCOL-2;b++){
								map[b][a]=map[b][a-1];   //当前行等于上一行
							}
						}
					}
				}
			}
			count=0;
		}
	}
}

