
public class puzzle extends JFrame implements ActionListener{

	Game g;

	private JButton jb,jb2,jb3;//依次为开始游戏,显示正确图片

	private JTextField jt,jt2;//读入切割的行数和列数

	JProgressBar progressbar;//进度条

	Progress p;

	String file;

	public puzzle(){

		setTitle("我的拼图");//应用标题

		setLayout(null);

		setBounds(0,0,900,700);//拼图程序的范围

		g= new Game();//如果以后选择图片就从主界面选择好url把url传过去(game有多个构造函数)

		g.setBounds(0,0,600,600);

		Container container=getContentPane();

	    jb = new JButton("开始游戏");

	    jb.setBounds(650,50,200,100);

	    jb.addActionListener(this);

	    jb2 = new JButton("显示正确图片");

	    jb2.setBounds(650,175,200,100);

	    jb2.addActionListener(this);

	    jb3=new JButton("选择图片");

	    jb3.setBounds(650,300,200,100);

	    jb3.addActionListener(this);

	    JLabel jl= new JLabel("横向切割数量");

	    jl.setBounds(650,400,200,50);

	    container.add(jl);

	    jt=new JTextField("");

	    jt.setBounds(650,450,200,50);

	    JLabel jl2=new JLabel("纵向切割数量");

	    jl2.setBounds(650,500,200,50);

	    container.add(jl2);

	    jt2=new JTextField("");

	    jt2.setBounds(650,550,200,50);

	    progressbar =new JProgressBar();

	    progressbar.setBounds(0,600,800,75);

	    progressbar.setMinimum(0);

	    progressbar.setMaximum(100);

	    progressbar.setValue(0);

	    progressbar.setBackground(Color.blue);

	    progressbar.setBorderPainted(true);

	    container.add(progressbar);

	    container.add(jt);

	    container.add(jt2);

	    container.add(jb);

	    container.add(jb2);

	    container.add(jb3);

	    container.add(g);

	    container.setBackground(Color.white);

	    setVisible(true);

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	  }

	 public void actionPerformed(ActionEvent e){

		 int n,m;

	     if (e.getSource()==jb){//如果是开始游戏(获得n行,m列)

			String s1=jt.getText();

			String s2=jt2.getText();

			if (s1.matches("\\d+")&&s2.matches("\\d+"))//如果是整数

			{

			n=Integer.parseInt(s1);

			m=Integer.parseInt(s2);

			//System.out.println(s1+""+s2);

			//new picturecut(n,m);

			if(file==null)

			new alert4();

			else

			{

			g.start(n,m,file);//传入n行,m列

			if (p==null)//只开启一次

			{

			p=new Progress(progressbar);

			p.start();

			}

			else //如果之前线程已开启

			{  

				if ((Progress.value>=100)||(Progress.value<0))//如果之前那个线程跑完了

				{

					progressbar.setValue(0);

				    Progress.value=0;

				    

				}

				else

				//System.out.println("新的p");//关闭之前的线程，开启新的新的线程的方法,不要开启新的线程，直接用之前的那个，只不过修改里面的value值。

				{   

					progressbar.setValue(0);

				    Progress.value=0;

				}

			}

			}

			

			}

			else

				new alert3();

		   }

		 if (e.getSource()==jb2){//如果是显示图片

			g.Display(file);

		 }

		 if (e.getSource()==jb3){

			 JFileChooser  fileChooser;

			 {

			 fileChooser =new JFileChooser();

			 FileFilter filter =new FileNameExtensionFilter("图像文件(只能是PNG或JPG)", "JPG","PNG");

			 fileChooser.setFileFilter(filter);

			 }

			 int i=fileChooser.showOpenDialog(getContentPane());

			 if (i==JFileChooser.APPROVE_OPTION){

				 File SelectedFile=fileChooser.getSelectedFile();

				 file=SelectedFile.getAbsolutePath();

				 System.out.println(file);

				 g.redraw(file);

				 progressbar.setValue(0);

				 Progress.value=-10000;

			 }

		 }

	 }

	public static void main(String []args){

		new firstapplet();

		new puzzle();

	}

 

 

}

class Progress extends Thread{

	

	static int value=0;

	private JProgressBar progressBar;

	public Progress(JProgressBar progressBar)

	{

		this.progressBar=progressBar;

	}

	public void run()

	{  

		while(value<=100)

		{

			try{

				Thread.sleep(1000);

				}catch(InterruptedException e){

			e.printStackTrace();

		}

			value++;

			if (value==100)

			{

				new alert2();

			}

			progressBar.setIndeterminate(false);

			progressBar.setValue(value);

			}

	}

	

	

}

public class alert2 extends JDialog {

	 public alert2(){

		setTitle("游戏结束!");

		setLayout(null);

		setBounds(400,300,450,400);

		Container container=getContentPane();

		container.setBackground(Color.white);

		JLabel jl= new JLabel("时间到，游戏结束!");

	    jl.setBounds(50,50,200,100);

		container.add(jl);

	    setVisible(true);

	    }

	

}

public class alert3 extends JDialog {

	 public alert3(){

		setTitle("注意");

		setLayout(null);

		setBounds(400,300,300,200);

		Container container=getContentPane();

		container.setBackground(Color.white);

		JLabel jl= new JLabel("请输入正确的横向纵向切割数量!");

	    jl.setBounds(50,50,200,100);

		container.add(jl);

	    setVisible(true);

	    }

	

}

public class alert4 extends JDialog {

	 public alert4(){

		setTitle("注意!");

		setLayout(null);

		setBounds(400,300,300,200);

		Container container=getContentPane();

		container.setBackground(Color.white);

		JLabel jl= new JLabel("请先选择图片");

	    jl.setBounds(50,50,200,100);

		container.add(jl);

	    setVisible(true);

	    }

	

}


