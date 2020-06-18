
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.*;

public class Game extends JFrame implements ActionListener,KeyListener{
    
    int number_path=0;       //��¼����
    int best_recond=0;        //��ѳɼ�
    int replay=0;
    int[] num={1,2,3,4,5,6,7,8,0};
    String str="���߲�����";
    String str1="��ѳɼ���";
    static JButton[][] Buttons=new JButton[3][3];        //�Ź���
    public Game(){            
        super("�Ź�����Ϸ");
        this.setBounds(400,100,700,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3,3));
        this.init();
        this.setVisible(true);
    }
    public void init(){        //��ʼ��ʹ���㷨ʹ��������֣�����Ӹ����Լ��¼������ͼ��̼���
        for(int i = 0;i < 8;i++)
        {
            this.num[i] = i+1;
        }
        this.num[8] = -1;
        this.num[5] = -1;
        this.num[8] = 6;
        for(int i = 0;i < 8;i++)
        {
            int idx =(int) (Math.random() * 8);
            int tmp = this.num[7];
            this.num[7] = this.num[idx];
            this.num[idx] = tmp;
        }
        for(int i = 0;i < 3;i++)
        {
            for(int j = 0;j < 3;j++)
            {
                if(this.num[i * 3 + j] != -1)
                {
                    Game.Buttons[i][j] =  new JButton("" + this.num[i * 3 + j]);
                    Game.Buttons[i][j].addActionListener(this);
                    Game.Buttons[i][j].addKeyListener(this);
                    this.getContentPane().add(Game.Buttons[i][j]);
                }
                else
                {
                    Game.Buttons[i][j] =  new JButton("");
                    Game.Buttons[i][j].addActionListener(this); 
                    Game.Buttons[i][j].addKeyListener(this);
                    this.getContentPane().add(Game.Buttons[i][j]);
                    Game.Buttons[i][j].setEnabled(false);
                }
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {    //����¼������������������ݲ�����1
        int i,j;
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                if(e.getSource()==Buttons[i][j]){
                    if(i+1!=3&&Buttons[i+1][j].getText()==""){
                        Buttons[i+1][j].setText(Buttons[i][j].getText());
                        Buttons[i+1][j].setEnabled(true);
                        Buttons[i][j].setText("");
                        Buttons[i][j].setEnabled(false);
                        number_path++;
                    }
                    if(i-1!=-1&&Buttons[i-1][j].getText()==""){
                        Buttons[i-1][j].setText(Buttons[i][j].getText());
                        Buttons[i-1][j].setEnabled(true);
                        Buttons[i][j].setText("");
                        Buttons[i][j].setEnabled(false);
                        number_path++;
                    }
                    if(j+1!=3&&Buttons[i][j+1].getText()==""){
                        Buttons[i][j+1].setText(Buttons[i][j].getText());
                        Buttons[i][j+1].setEnabled(true);
                        Buttons[i][j].setText("");
                        Buttons[i][j].setEnabled(false);
                        number_path++;
                    }
                    if(j-1!=-1&&Buttons[i][j-1].getText()==""){
                        Buttons[i][j-1].setText(Buttons[i][j].getText());
                        Buttons[i][j-1].setEnabled(true);
                        Buttons[i][j].setText("");
                        Buttons[i][j].setEnabled(false);
                        number_path++;
                    }
                }
            }
        }
        if(winfail()){    //�ж���β������Ƿ�ʤ����������ѳɼ������ж��Ƿ���Ƽ�¼
            try {
                FileInputStream  fin=new FileInputStream("bestrecond.int");
                DataInputStream din=new DataInputStream(fin);
                best_recond=din.readInt();
                din.close();
                fin.close();
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            if(number_path>best_recond){
                JOptionPane.showConfirmDialog(this,"��̫�����ˣ�����ô�Ѷ���Ӯ������������"+Integer.toString(number_path)+"������Ȼ����û�д��Ƽ�¼����ʷ��ѳɼ��ǣ�"+Integer.toString(best_recond));
                if(replay==JOptionPane.YES_OPTION){
                    Game G=new Game();
                }
            }
            else{
                JOptionPane.showConfirmDialog(this,"��̫�����ˣ�����ô�Ѷ���Ӯ������������"+Integer.toString(number_path)+"��������������ʷ��¼������ʷ��ѳɼ��ǣ�"+Integer.toString(best_recond));
                try {
                    FileOutputStream  fin=new FileOutputStream("bestrecond.int");
                    DataOutputStream din=new DataOutputStream(fin);
                    din.writeInt(number_path);
                    din.close();
                    fin.close();
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                if(replay==JOptionPane.YES_OPTION){
                    Game G=new Game();
                }
            }
        }
    }
    public void keyPressed(KeyEvent e){        //�����¼������������������ݲ�����1
        int i,j;
        boolean b=false;
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                if(Buttons[i][j].getText()==""){
                    if(i+1!=3&&e.getKeyCode()==KeyEvent.VK_UP){
                        Buttons[i][j].setEnabled(true);
                        Buttons[i][j].setText(Buttons[i+1][j].getText());
                        Buttons[i+1][j].setText("");
                        Buttons[i+1][j].setEnabled(false);
                        number_path++;
                        b=true;break;
                    }
                    if(i-1!=-1&&e.getKeyCode()==KeyEvent.VK_DOWN){
                        Buttons[i][j].setEnabled(true);
                        Buttons[i][j].setText(Buttons[i-1][j].getText());
                        Buttons[i-1][j].setText("");
                        Buttons[i-1][j].setEnabled(false);
                        number_path++;
                        b=true;break;
                    }
                    if(j+1!=3&&e.getKeyCode()==KeyEvent.VK_LEFT){
                        Buttons[i][j].setEnabled(true);
                        Buttons[i][j].setText(Buttons[i][j+1].getText());
                        Buttons[i][j+1].setText("");
                        Buttons[i][j+1].setEnabled(false);
                        number_path++;
                        b=true;break;
                    }
                    if(j-1!=-1&&e.getKeyCode()==KeyEvent.VK_RIGHT){
                        Buttons[i][j].setEnabled(true);
                        Buttons[i][j].setText(Buttons[i][j-1].getText());
                        Buttons[i][j-1].setText("");
                        Buttons[i][j-1].setEnabled(false);
                        number_path++;
                        b=true;break;
                    }
                }
            } 
            if(b) break;
        }
        if(winfail()){        //�ж���β������Ƿ�ʤ����������ѳɼ������ж��Ƿ���Ƽ�¼
            try {
                FileInputStream  fin=new FileInputStream("bestrecond.int");
                DataInputStream din=new DataInputStream(fin);
                best_recond=din.readInt();
                din.close();
                fin.close();
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            if(number_path>best_recond){
                JOptionPane.showConfirmDialog(this, "��̫�����ˣ�����ô�Ѷ���Ӯ������������"+Integer.toString(number_path)+"������Ȼ����û�д��Ƽ�¼����ʷ��ѳɼ��ǣ�"+Integer.toString(best_recond));
                if(replay==JOptionPane.YES_OPTION){
                    Game G=new Game();
                }
            }
            else{
                JOptionPane.showConfirmDialog(this, "��̫�����ˣ�����ô�Ѷ���Ӯ������������"+Integer.toString(number_path)+"��������������ʷ��¼������ʷ��ѳɼ��ǣ�"+Integer.toString(best_recond));
                try {
                    FileOutputStream  fin=new FileOutputStream("bestrecond.int");
                    DataOutputStream din=new DataOutputStream(fin);
                    din.writeInt(number_path);
                    din.close();
                    fin.close();
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                if(replay==JOptionPane.YES_OPTION){
                    Game G=new Game();
                }
            }
        }
    }
    public static boolean winfail(){     //�ж���Ӯ������ÿ������ַ������ϼ���
        int i,j,k=1,n=0;
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                if(Buttons[i][j].getText().equals(Integer.toString(k++))){
                    n++;
                }
            }
        }
        if(n>=8) return true;
        return false;
    }
    public static void main(String[] args) {
        
        Game G=new Game();
    }
    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}