package LTW2017061614;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
	/**��Ϸ������**/
public class RussiaBlocks extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private GamePanel t ;
	private static int flag=0;
	/** ���췽��**/
	RussiaBlocks(){	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(800,100);					
		setTitle("2017061614����ΰ");
		setSize(600,750);
		setResizable(true); 
	}
	/** ��ӻ��� ��ʼ��Timer**/
	public void startGame(){
		t = new GamePanel();
		add(t);	
		addKeyListener(t);
		t.timer.start();
	}
	public static void main(String[] args){
		RussiaBlocks tetris = new RussiaBlocks();	
		tetris.setVisible(true);
		flag = JOptionPane.showConfirmDialog(tetris, 				//��ʼѡ��Ի���
				"����Y����ʼ����Ϸ\n����N���˳���Ϸ", "new Game", JOptionPane.YES_NO_OPTION);	
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

