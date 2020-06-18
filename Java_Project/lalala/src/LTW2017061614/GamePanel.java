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
/*��Ϸ���滭��*/
public class GamePanel extends JPanel implements KeyListener{
	private static final long serialVersionUID = 1L;
	public int MAPCOL=13;				//��Ϸ����������	 
	public int MAPROW=22;				//��Ϸ����������     
	public int PIXEL=30;				//���أ���λ���ӵĳ�����
	public int score;
	public int map[][]=new int[MAPCOL][MAPROW];
	public Timer timer ;
	private int Level=5;				//��ʼ�Ѷ�5
	private Block block;				//����Block��
	private TimerListener timerlistener;
	/* �ڲ��࣬��timer���� */
	private class TimerListener implements ActionListener{		//ʵ�ֽӿ�

		public void actionPerformed(ActionEvent e) {
			if(!isCollied(block.x,block.y+1)){
				block.y++;			
			}else{
				block.add();		//��ײ���ײ��󣬰ѷ�����ӵ�������ȥ					
				deleteLine();
				if(true==isGameover()){
					JOptionPane.showMessageDialog(null, "Game Over\nscore:"+score);
					cleanMap();
					drawWall();
					score=0;		
				}
				block.newblock();
			}				
			repaint();				//�ػ�
		}
	}
	/* ���췽��*/
	GamePanel(){
		block = new Block(this);	//����Block�࣬������GamePanel��
		cleanMap();
		drawWall();
		block.newblock();
		timerlistener=new TimerListener();
		timer = new Timer(800, timerlistener);   //��ʱ������ָ��ʱ��������TimerListener()
	}
	/* �����Ѷ�*/
	private void upLevel(){
		if(Level<10){
			Level++;
			timer.setDelay(1300-100*Level);
			repaint();
		}
	}
	/* �����Ѷ� */
	private void downLevel(){
		if(Level>0){
			Level--;
			timer.setDelay(1300-100*Level);
			repaint();
		}
	}
	/* Χǽ�ڵĻ������㣬�൱���������*/
	private void cleanMap(){
		for(int i=1;i<MAPCOL-2;i++){			
			for(int j=0;j<MAPROW-2;j++){
				map[i][j]=0;
			}
		}     
	}
	/* ��Χǽ����2��ʾΪΧǽ*/
	private void drawWall(){			
		for(int i=0;i<MAPCOL-1;i++){
			map[i][MAPROW-2]=2;
		}
		for(int j=0;j<MAPROW-2;j++){
			map[0][j]=2;
			map[MAPCOL-2][j]=2;
		}
	}
	/* �õ���������TeTirsPanel*/
	protected void paintComponent(Graphics g) {		
		super.paintComponent(g);		
		for(int j=0;j<MAPROW-1;j++){
			for(int i=0;i<MAPCOL-1;i++){
			/*	if(2==map[i][j]){
					g.setColor(Color.ORANGE);
					g.fillRect(i*PIXEL, j*PIXEL, PIXEL, PIXEL);   //��Χǽ����
				}	*/											  //�ְ�������	
				//�����̶��õķ���
				if(1==map[i][j]){
					g.setColor(Color.GREEN);
					g.fill3DRect(i*PIXEL, j*PIXEL, PIXEL, PIXEL,true);   
				}
			}
		}
		//������
		for(int i=1;i<MAPCOL-1;i++){	
			g.setColor(Color.BLACK);
			g.drawLine(i*PIXEL, 0, i*PIXEL, (MAPROW-2)*PIXEL);		
		}
		//������
		for(int j=0;j<MAPROW-1;j++){	
			g.setColor(Color.BLACK);
			g.drawLine(PIXEL*1, j*PIXEL, (MAPCOL-2)*PIXEL, j*PIXEL);
		}
		//��δ�̶����飬16��shapes����ĵ�һά����
		//x,y�Ƿ��������ڵ�����(��ʾxҪ��1)
		for(int i=0;i<16;i++){											
			if(1==block.shapes[block.blockType][block.blockState][i]){
				g.setColor(Color.BLUE);
				g.fill3DRect((block.x+1+i%4)*PIXEL,(block.y+i/4)*PIXEL,PIXEL,PIXEL,true);	//��shapes��������������
			}
		}	
		g.setColor(Color.darkGray);
		g.setFont(new Font("����", Font.BOLD, 30)); 
		g.drawString("score��"+score,MAPCOL*PIXEL,3*PIXEL-35);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3.0f));
		g2.drawLine(MAPCOL*PIXEL-30, 3*PIXEL-85, MAPCOL*PIXEL+170, 3*PIXEL-85);			//����1
		g2.drawLine(MAPCOL*PIXEL-30, 3*PIXEL, MAPCOL*PIXEL+170, 3*PIXEL);				//����2
		g2.drawLine(MAPCOL*PIXEL-30, 3*PIXEL-85, MAPCOL*PIXEL-30, 3*PIXEL);				//����1
		g2.drawLine(MAPCOL*PIXEL+170, 3*PIXEL-85, MAPCOL*PIXEL+170, 3*PIXEL);			//����2	
		
		g2.drawLine(MAPCOL*PIXEL-30, 5*PIXEL-40, MAPCOL*PIXEL+170, 5*PIXEL-40);			//����1
		g2.drawLine(MAPCOL*PIXEL-30, 5*PIXEL+20, MAPCOL*PIXEL+170, 5*PIXEL+20);			//����2
		g2.drawLine(MAPCOL*PIXEL-30, 7*PIXEL+20, MAPCOL*PIXEL+170, 7*PIXEL+20);			//����3
		g2.drawLine(MAPCOL*PIXEL-30, 9*PIXEL+20, MAPCOL*PIXEL+170, 9*PIXEL+20);			//����4
		g2.drawLine(MAPCOL*PIXEL-30, 11*PIXEL+20, MAPCOL*PIXEL+170, 11*PIXEL+20);		//����5
		g2.drawLine(MAPCOL*PIXEL-30, 13*PIXEL+20, MAPCOL*PIXEL+170, 13*PIXEL+20);		//����6
		g2.drawLine(MAPCOL*PIXEL-30, 15*PIXEL+20, MAPCOL*PIXEL+170, 15*PIXEL+20);		//����7
		g2.drawLine(MAPCOL*PIXEL-30, 17*PIXEL+20, MAPCOL*PIXEL+170, 17*PIXEL+20);		//����8
		g2.drawLine(MAPCOL*PIXEL-30, 19*PIXEL+20, MAPCOL*PIXEL+170, 19*PIXEL+20);		//����9
		g2.drawLine(MAPCOL*PIXEL-30, 5*PIXEL-40, MAPCOL*PIXEL-30, 19*PIXEL+20);			//����1
		g2.drawLine(MAPCOL*PIXEL+170, 5*PIXEL-40, MAPCOL*PIXEL+170, 19*PIXEL+20);		//����2
		
		g.setFont(new Font("����", Font.BOLD, 22));
		g.drawString("operationa", MAPCOL*PIXEL, 5*PIXEL);
		g.drawString("��   overturn",MAPCOL*PIXEL,7*PIXEL);
		g.drawString("��   down",MAPCOL*PIXEL,9*PIXEL);
		g.drawString("��   left",MAPCOL*PIXEL,11*PIXEL);
		g.drawString("��   right",MAPCOL*PIXEL,13*PIXEL);
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
	/* �ж��Ƿ���ײ*/
	public boolean isCollied(int x,int y){			
		for(int a=0;a<4;a++){			//����
			for(int b=0;b<4;b++){
				if((block.shapes[block.blockType][block.blockState][a*4+b]==1)&&(map[x+1+b][y+a]==1)){	//�ж��Ƿ��غ�
					return true;
				}else if((block.shapes[block.blockType][block.blockState][a*4+b]==1)&&(map[x+1+b][y+a]==2)){	//��Χǽ 
					return true;
				}
			}
		}
		return false;
	}
	/* �ж��Ƿ������Ϸ*/
	public boolean isGameover(){
		for(int i=1;i<MAPCOL-3;i++){
			if(map[i][0]==1){
				return true;		
			}
		}
		return false;
	}
	/* ����*/
	public void deleteLine(){
		int count = 0;
		for(int i=0;i<MAPROW-2;i++){
			for(int j=1;j<MAPCOL-2;j++){
				if(map[j][i]==1){
					count++;
					if(count==MAPCOL-3){			//һ�ж����Ļ�������ΪMAPCOL-3��������������
						score+=10;
						for(int a=i;a>0;a--){			//�ӵ�i�п�ʼ
							for(int b=1;b<MAPCOL-2;b++){
								map[b][a]=map[b][a-1];   //��ǰ�е�����һ��
							}
						}
					}
				}
			}
			count=0;
		}
	}
}

