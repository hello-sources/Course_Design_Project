
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

 

public class Game extends JPanel implements MouseListener{//创建开始就放张图片,并且打乱，点击开始游戏计时并展示图片,当跑到最终结果时退出线程

	private ImageIcon imagecon;

	private ImageIcon []pi;

	Thread runner;

	boolean ok=false;

	int time;//判断是第几次调用repaint函数

	int []a;//数组里存储着第i个位置放着第几张切割的图片如果是9则为空着的图片.

	int currentx;//当前为空的横坐标

	int currenty;//当前为空的纵坐标

	int number;//当前是第几个位置为空

    int n;//n行

	int m;//m列

	public Game(){

		 imagecon=new ImageIcon("./picture/bg2.png");//记录完整图片

		 time=1;

		 repaint();

	}

	public void init(int n,int m){//初始化图片位置信息(1~9个位置存储9张图片中的12张),要保证逆序对为偶数(注意计算机n行m列与人是颠倒的)

		int flag,c;

		boolean f=true;

		pi=new ImageIcon[n*m+1];

		while(f)//若m为奇数，则逆序对为偶数可行，如果为偶数，则空格行数的差值与逆序对差值奇偶性一样

		{

			System.out.println("n为"+n+"m为"+m);

		for (int i=1;i<=n*m;i++)

		{    

			a[i]=(int)(1+Math.random()*(n*m-1+1));//随机一个1到n*m的数

			flag=1;

			for (int j=1;j<i;j++)

				if (a[i]==a[j])//判重

					flag=0;

			if (flag==0)//如果不符合

				  i--;

		}

		int sum=0;//计算逆序对

		number=0;

		for (int i=1;i<=n*m;i++)

		{    

			if (a[i]==n*m)

			{

				number=i;//记录下是第几个为空

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

		if ((sum%2==0)&&(m%2==1))//如果是奇数有解

		 f=false;

		else

		 if ((m%2==0)&&(n-(number-1)/m-1)%2==sum%2)//如果是偶数

		 f=false;

	   for (c=1;c<=n;c++)//不能一样

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

		 g.drawImage(r,0,0,600,600,this);//画出原来的完整图案

		 }

		 else  if (!isfinish()){

		    g.clearRect(0,0,600,600);

		    for (int i=1;i<=n*m;i++)

		    {

		    if (a[i]!=n*m)

		    {

		    int temp=a[i];//第i个位置是第原来的第a[i]块图片	 

		    Image r=pi[temp].getImage();

			g.drawImage(r,(i-1)%m*(600/m),(i-1)/m*(600/n),600/m,600/n,this);

			}

		    else

		    {

		    currentx=(i-1)%m*(600/m);

		    currenty=(i-1)/m*(600/n);//空格的横纵左上角坐标

		    g.clearRect((i-1)%m*(600/m),(i-1)/m*(600/n),600/m,600/n);//设置第9为空格

		    }

		    }

 }

		 else{

			 g.clearRect(0,0,600,600);

			 for (int i=1;i<=n*m;i++)//全部输出

			 {   

				 Image r=pi[i].getImage();

				 g.drawImage(r,(i-1)%m*(600/m),(i-1)/m*(600/n),600/m,600/n,this);

			 }

			 Progress.value=-10000;//游戏结束让进度条设为负值

			 new alert();

		 }

	}  

	public void start(int n,int m,String file)//传入m行n列，开始切图

		{  

		   this.n=n;

		   this.m=m;

		   a=new int[n*m+1];//n行m列

		   init(n,m);

		   String srcImageFile=file;

		   int cols,rows;

		   cols=m;

		   rows=n;

		   Progress.value=0;

		   if (time==1)

		   time=2;

		   try{

	            // 读取源图像

	            BufferedImage bi = ImageIO.read(new File(srcImageFile));

	            // 源图宽度

	            int srcWidth = bi.getWidth(); 

	            // 源图高度

	            int srcHeight = bi.getHeight(); 

	            if (cols >= 1 && rows >=1){

	                Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);

	                // 切片横向数量

	                // 切片纵向数量

	                // 计算切片的横向和纵向数量

	                double destWidth = srcWidth / cols;

	                double destHeight = srcHeight /rows;

	                Image img;

	                ImageFilter cropFilter;

	                // 循环建立切片

	                for (int i = 0; i < rows; i++){

	                    for (int j = 0; j < cols; j++){

	                        // 四个参数分别为图像起点坐标和宽高

	                        cropFilter = new CropImageFilter((int)(j * destWidth), (int)(i * destHeight),

	                                (int)((j+1)* destWidth), (int)((i+1) * destHeight));

	                        img = Toolkit.getDefaultToolkit().createImage(

	                                        new FilteredImageSource(image.getSource(), cropFilter));

	                        BufferedImage tag = new BufferedImage((int)destWidth, (int)destHeight,

	                                BufferedImage.TYPE_INT_RGB);

	                        Graphics g = tag.getGraphics();

	                        g.drawImage(img, 0, 0, null); // 绘制缩小后的图

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

	  public boolean isfinish(){//说明已经完成了

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

		   System.out.println("鼠标触摸");

		   tempx=e.getX();//当前所在位置

		   tempy=e.getY();//

		   System.out.println(tempx);

		   System.out.println(tempy);

		   System.out.println("原来的长度为:"+currentx+"原来的高度:"+currenty);

		   if ((tempx-currentx>=0)&&(tempx-currentx<=600/m)&&(currenty-tempy<=600/n)&&(currenty-tempy>=0)){//如果点击按钮在当前的上方

					int temp=a[number];//上下交换自己的图片

					a[number]=a[number-m];

					a[number-m]=temp;

					number=number-m;//更新当前所在的位置

					currentx=tempx/(600/m)*(600/m);//第几行

					currenty=tempy/(600/n)*(600/n);//第几列

					System.out.println("向上边"+currentx+"  "+currenty);

  				}

				 else if ((currentx-tempx>=0)&&(currentx-tempx<=600/m)&&(tempy-currenty>=0)&&(tempy-currenty<=600/n)){//如果点击按钮在当前的左边

					 int temp=a[number];

					 a[number]=a[number-1];

					 a[number-1]=temp;

					 number=number-1;

					 currentx=tempx/(600/m)*(600/m);

					 currenty=tempy/(600/n)*(600/n);

					 System.out.println("向左边"+currentx+"  "+currenty);

				}

				 else if ((tempx-currentx<=2*(600/m))&&(tempx-currentx>=600/m)&&(tempy-currenty>=0)&&(tempy-currenty<=600/n)){//如果点击按钮在当前的右边

					 int temp=a[number];

					 a[number]=a[number+1];

					 a[number+1]=temp;

					 number=number+1;

					 currentx=tempx/(600/m)*(600/m);

					 currenty=tempy/(600/n)*(600/n);

					 System.out.println("向右边"+currentx+"  "+currenty);

				 }

				 else if ((tempy-currenty>=600/n)&&(tempy-currenty<=2*(600/n))&&(tempx-currentx>=0)&&(tempx-currentx<=600/m)){//如果点击按钮在当前的下边

					 int temp=a[number];

					 a[number]=a[number+m];

					 a[number+m]=temp;

					 number=number+m;

					 currentx=tempx/(600/m)*(600/m);

					 currenty=tempy/(600/n)*(600/n);

					 System.out.println("向下边"+currentx+"  "+currenty);

				 }

			repaint();//至于要在每一次最后重新绘制即可

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

		    imagecon=new ImageIcon(s);//记录完整图片

			time=1;

			repaint();

		}

		public class display extends  JDialog{//展示图片

			Congra  jp;

			public display(String s){

				setTitle("展示图片");

				setLayout(null);

				setBounds(400,300,300,300);

				Container container=getContentPane();

				JLabel jl= new JLabel("原图片");

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

 
