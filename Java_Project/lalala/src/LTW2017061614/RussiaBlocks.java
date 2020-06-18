package LTW2017061614;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
	/**游戏主程序**/
public class RussiaBlocks extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private GamePanel t ;
	private static int flag=0;
	/** 构造方法**/
	RussiaBlocks(){	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(800,100);					
		setTitle("2017061614李天伟");
		setSize(600,750);
		setResizable(true); 
	}
	/** 添加画板 开始跑Timer**/
	public void startGame(){
		t = new GamePanel();
		add(t);	
		addKeyListener(t);
		t.timer.start();
	}
	public static void main(String[] args){
		RussiaBlocks tetris = new RussiaBlocks();	
		tetris.setVisible(true);
		flag = JOptionPane.showConfirmDialog(tetris, 				//开始选择对话框
				"按【Y】开始新游戏\n按【N】退出游戏", "new Game", JOptionPane.YES_NO_OPTION);	
		if(flag==JOptionPane.YES_OPTION){
			tetris.startGame();
			tetris.setVisible(true);
		}
		else{
			tetris.dispose();
			System.exit(0);
		}							
	}
}

