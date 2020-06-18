
import java.awt.Button;

import java.awt.Color;

import java.awt.Container;

import java.awt.Graphics;

import java.awt.Image;

import java.awt.Toolkit;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;

import java.awt.image.BufferedImage;

import java.awt.image.CropImageFilter;

import java.awt.image.FilteredImageSource;

import java.awt.image.ImageFilter;

import java.io.File;

 

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;

import javax.swing.JDialog;

import javax.swing.JLabel;

import javax.swing.JPanel;

 

public class Game extends JPanel implements MouseListener{//������ʼ�ͷ���ͼƬ,���Ҵ��ң������ʼ��Ϸ��ʱ��չʾͼƬ,���ܵ����ս��ʱ�˳��߳�

	private ImageIcon imagecon;

	private ImageIcon []pi;

	Thread runner;

	boolean ok=false;

	int time;//�ж��ǵڼ��ε���repaint����

	int []a;//������洢�ŵ�i��λ�÷��ŵڼ����и��ͼƬ�����9��Ϊ���ŵ�ͼƬ.

	int currentx;//��ǰΪ�յĺ�����

	int currenty;//��ǰΪ�յ�������

	int number;//��ǰ�ǵڼ���λ��Ϊ��

    int n;//n��

	int m;//m��

	public Game(){

		 imagecon=new ImageIcon("./picture/bg2.png");//��¼����ͼƬ

		 time=1;

		 repaint();

	}

	public void init(int n,int m){//��ʼ��ͼƬλ����Ϣ(1~9��λ�ô洢9��ͼƬ�е�12��),Ҫ��֤�����Ϊż��(ע������n��m�������ǵߵ���)

		int flag,c;

		boolean f=true;

		pi=new ImageIcon[n*m+1];

		while(f)//��mΪ�������������Ϊż�����У����Ϊż������ո������Ĳ�ֵ������Բ�ֵ��ż��һ��

		{

			System.out.println("nΪ"+n+"mΪ"+m);

		for (int i=1;i<=n*m;i++)

		{    

			a[i]=(int)(1+Math.random()*(n*m-1+1));//���һ��1��n*m����

			flag=1;

			for (int j=1;j<i;j++)

				if (a[i]==a[j])//����

					flag=0;

			if (flag==0)//���������

				  i--;

		}

		int sum=0;//���������

		number=0;

		for (int i=1;i<=n*m;i++)

		{    

			if (a[i]==n*m)

			{

				number=i;//��¼���ǵڼ���Ϊ��

			    continue;

			}

			 for (int j=1;j<i;j++)

			 {

				if (j==number)

			    continue;

			 if (a[j]>a[i])

				   sum++;

			 }

		}

		System.out.println(sum);

		if ((sum%2==0)&&(m%2==1))//����������н�

		 f=false;

		else

		 if ((m%2==0)&&(n-(number-1)/m-1)%2==sum%2)//�����ż��

		 f=false;

	   for (c=1;c<=n;c++)//����һ��

			if (a[c]!=c)

				break;

		  if (c==n+1)   f=true;

		}

		for (int i=1;i<=n*m;i++)

		System.out.println(a[i]);

	}

	@Override

	 public void paint(Graphics g){

		 if (time==1)

		 {

		 Image r=imagecon.getImage();

		 g.drawImage(r,0,0,600,600,this);//����ԭ��������ͼ��

		 }

		 else  if (!isfinish()){

		    g.clearRect(0,0,600,600);

		    for (int i=1;i<=n*m;i++)

		    {

		    if (a[i]!=n*m)

		    {

		    int temp=a[i];//��i��λ���ǵ�ԭ���ĵ�a[i]��ͼƬ	 

		    Image r=pi[temp].getImage();

			g.drawImage(r,(i-1)%m*(600/m),(i-1)/m*(600/n),600/m,600/n,this);

			}

		    else

		    {

		    currentx=(i-1)%m*(600/m);

		    currenty=(i-1)/m*(600/n);//�ո�ĺ������Ͻ�����

		    g.clearRect((i-1)%m*(600/m),(i-1)/m*(600/n),600/m,600/n);//���õ�9Ϊ�ո�

		    }

		    }

 }

		 else{

			 g.clearRect(0,0,600,600);

			 for (int i=1;i<=n*m;i++)//ȫ�����

			 {   

				 Image r=pi[i].getImage();

				 g.drawImage(r,(i-1)%m*(600/m),(i-1)/m*(600/n),600/m,600/n,this);

			 }

			 Progress.value=-10000;//��Ϸ�����ý�������Ϊ��ֵ

			 new alert();

		 }

	}  

	public void start(int n,int m,String file)//����m��n�У���ʼ��ͼ

		{  

		   this.n=n;

		   this.m=m;

		   a=new int[n*m+1];//n��m��

		   init(n,m);

		   String srcImageFile=file;

		   int cols,rows;

		   cols=m;

		   rows=n;

		   Progress.value=0;

		   if (time==1)

		   time=2;

		   try{

	            // ��ȡԴͼ��

	            BufferedImage bi = ImageIO.read(new File(srcImageFile));

	            // Դͼ���

	            int srcWidth = bi.getWidth(); 

	            // Դͼ�߶�

	            int srcHeight = bi.getHeight(); 

	            if (cols >= 1 && rows >=1){

	                Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);

	                // ��Ƭ��������

	                // ��Ƭ��������

	                // ������Ƭ�ĺ������������

	                double destWidth = srcWidth / cols;

	                double destHeight = srcHeight /rows;

	                Image img;

	                ImageFilter cropFilter;

	                // ѭ��������Ƭ

	                for (int i = 0; i < rows; i++){

	                    for (int j = 0; j < cols; j++){

	                        // �ĸ������ֱ�Ϊͼ���������Ϳ��

	                        cropFilter = new CropImageFilter((int)(j * destWidth), (int)(i * destHeight),

	                                (int)((j+1)* destWidth), (int)((i+1) * destHeight));

	                        img = Toolkit.getDefaultToolkit().createImage(

	                                        new FilteredImageSource(image.getSource(), cropFilter));

	                        BufferedImage tag = new BufferedImage((int)destWidth, (int)destHeight,

	                                BufferedImage.TYPE_INT_RGB);

	                        Graphics g = tag.getGraphics();

	                        g.drawImage(img, 0, 0, null); // ������С���ͼ

	                        g.dispose();

	                        int c=j+1+i*cols;

	                        pi[c]=new ImageIcon(tag);

	                    }

	                }

	            }

	                    }catch (Exception e){

	                        e.printStackTrace();

	                    }

		   this.addMouseListener(this);

		   repaint();

		}

	  public boolean isfinish(){//˵���Ѿ������

			for (int i=1;i<=n*m;i++)

			{

				if (a[i]!=i)

				return false;

			}

			return true;

		}

	  @Override

	   public void mousePressed(MouseEvent e){

		   int tempx,tempy;

		   System.out.println("��괥��");

		   tempx=e.getX();//��ǰ����λ��

		   tempy=e.getY();//

		   System.out.println(tempx);

		   System.out.println(tempy);

		   System.out.println("ԭ���ĳ���Ϊ:"+currentx+"ԭ���ĸ߶�:"+currenty);

		   if ((tempx-currentx>=0)&&(tempx-currentx<=600/m)&&(currenty-tempy<=600/n)&&(currenty-tempy>=0)){//��������ť�ڵ�ǰ���Ϸ�

					int temp=a[number];//���½����Լ���ͼƬ

					a[number]=a[number-m];

					a[number-m]=temp;

					number=number-m;//���µ�ǰ���ڵ�λ��

					currentx=tempx/(600/m)*(600/m);//�ڼ���

					currenty=tempy/(600/n)*(600/n);//�ڼ���

					System.out.println("���ϱ�"+currentx+"  "+currenty);

  				}

				 else if ((currentx-tempx>=0)&&(currentx-tempx<=600/m)&&(tempy-currenty>=0)&&(tempy-currenty<=600/n)){//��������ť�ڵ�ǰ�����

					 int temp=a[number];

					 a[number]=a[number-1];

					 a[number-1]=temp;

					 number=number-1;

					 currentx=tempx/(600/m)*(600/m);

					 currenty=tempy/(600/n)*(600/n);

					 System.out.println("�����"+currentx+"  "+currenty);

				}

				 else if ((tempx-currentx<=2*(600/m))&&(tempx-currentx>=600/m)&&(tempy-currenty>=0)&&(tempy-currenty<=600/n)){//��������ť�ڵ�ǰ���ұ�

					 int temp=a[number];

					 a[number]=a[number+1];

					 a[number+1]=temp;

					 number=number+1;

					 currentx=tempx/(600/m)*(600/m);

					 currenty=tempy/(600/n)*(600/n);

					 System.out.println("���ұ�"+currentx+"  "+currenty);

				 }

				 else if ((tempy-currenty>=600/n)&&(tempy-currenty<=2*(600/n))&&(tempx-currentx>=0)&&(tempx-currentx<=600/m)){//��������ť�ڵ�ǰ���±�

					 int temp=a[number];

					 a[number]=a[number+m];

					 a[number+m]=temp;

					 number=number+m;

					 currentx=tempx/(600/m)*(600/m);

					 currenty=tempy/(600/n)*(600/n);

					 System.out.println("���±�"+currentx+"  "+currenty);

				 }

			repaint();//����Ҫ��ÿһ��������»��Ƽ���

  }    

		@Override

		public void mouseClicked(MouseEvent e) {

			// TODO Auto-generated method stub

			

		}

		@Override

		public void mouseEntered(MouseEvent e) {

			// TODO Auto-generated method stub

			

		}

		@Override

		public void mouseExited(MouseEvent e) {

			// TODO Auto-generated method stub

			

		}

		@Override

		public void mouseReleased(MouseEvent e) {

			// TODO Auto-generated method stub

			

		}

		public void Display(String file){

			String s=file;

			new display(s);

		}

		public void redraw(String s) {

		    imagecon=new ImageIcon(s);//��¼����ͼƬ

			time=1;

			repaint();

		}

		public class display extends  JDialog{//չʾͼƬ

			Congra  jp;

			public display(String s){

				setTitle("չʾͼƬ");

				setLayout(null);

				setBounds(400,300,300,300);

				Container container=getContentPane();

				JLabel jl= new JLabel("ԭͼƬ");

			    jl.setBounds(50,50,300,200);

				container.add(jl);

				container.setBackground(Color.white);

				jp=new Congra(s);

				jp.setBounds(0,0,250,250);

				container.add(jp);

			    setVisible(true);

			}

		}

     public class alert extends JDialog {

			ImageIcon li;

			public alert(){

				win g=new win();

				g.setBounds(0,0,400,400);

				setTitle("you win!");

				setLayout(null);

				setBounds(400,300,450,400);

				Container container=getContentPane();

				container.add(g);

				container.setBackground(Color.white);

			    setVisible(true);

			    }

			

	}

     public class win extends JPanel{

    	 ImageIcon li;

    	 public win(){

    		 li=new ImageIcon("./picture/you win.png");

    		 repaint();

    	 }

    	 public void paint(Graphics g)

    	 {

    		 Image r=li.getImage();

    	     g.drawImage(r,0,0,400,400,this);

    	 }

     }

	

}

 
