
public class puzzle extends JFrame implements ActionListener{

	Game g;

	private JButton jb,jb2,jb3;//����Ϊ��ʼ��Ϸ,��ʾ��ȷͼƬ

	private JTextField jt,jt2;//�����и������������

	JProgressBar progressbar;//������

	Progress p;

	String file;

	public puzzle(){

		setTitle("�ҵ�ƴͼ");//Ӧ�ñ���

		setLayout(null);

		setBounds(0,0,900,700);//ƴͼ����ķ�Χ

		g= new Game();//����Ժ�ѡ��ͼƬ�ʹ�������ѡ���url��url����ȥ(game�ж�����캯��)

		g.setBounds(0,0,600,600);

		Container container=getContentPane();

	    jb = new JButton("��ʼ��Ϸ");

	    jb.setBounds(650,50,200,100);

	    jb.addActionListener(this);

	    jb2 = new JButton("��ʾ��ȷͼƬ");

	    jb2.setBounds(650,175,200,100);

	    jb2.addActionListener(this);

	    jb3=new JButton("ѡ��ͼƬ");

	    jb3.setBounds(650,300,200,100);

	    jb3.addActionListener(this);

	    JLabel jl= new JLabel("�����и�����");

	    jl.setBounds(650,400,200,50);

	    container.add(jl);

	    jt=new JTextField("");

	    jt.setBounds(650,450,200,50);

	    JLabel jl2=new JLabel("�����и�����");

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

	     if (e.getSource()==jb){//����ǿ�ʼ��Ϸ(���n��,m��)

			String s1=jt.getText();

			String s2=jt2.getText();

			if (s1.matches("\\d+")&&s2.matches("\\d+"))//���������

			{

			n=Integer.parseInt(s1);

			m=Integer.parseInt(s2);

			//System.out.println(s1+""+s2);

			//new picturecut(n,m);

			if(file==null)

			new alert4();

			else

			{

			g.start(n,m,file);//����n��,m��

			if (p==null)//ֻ����һ��

			{

			p=new Progress(progressbar);

			p.start();

			}

			else //���֮ǰ�߳��ѿ���

			{  

				if ((Progress.value>=100)||(Progress.value<0))//���֮ǰ�Ǹ��߳�������

				{

					progressbar.setValue(0);

				    Progress.value=0;

				    

				}

				else

				//System.out.println("�µ�p");//�ر�֮ǰ���̣߳������µ��µ��̵߳ķ���,��Ҫ�����µ��̣߳�ֱ����֮ǰ���Ǹ���ֻ�����޸������valueֵ��

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

		 if (e.getSource()==jb2){//�������ʾͼƬ

			g.Display(file);

		 }

		 if (e.getSource()==jb3){

			 JFileChooser  fileChooser;

			 {

			 fileChooser =new JFileChooser();

			 FileFilter filter =new FileNameExtensionFilter("ͼ���ļ�(ֻ����PNG��JPG)", "JPG","PNG");

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

		setTitle("��Ϸ����!");

		setLayout(null);

		setBounds(400,300,450,400);

		Container container=getContentPane();

		container.setBackground(Color.white);

		JLabel jl= new JLabel("ʱ�䵽����Ϸ����!");

	    jl.setBounds(50,50,200,100);

		container.add(jl);

	    setVisible(true);

	    }

	

}

public class alert3 extends JDialog {

	 public alert3(){

		setTitle("ע��");

		setLayout(null);

		setBounds(400,300,300,200);

		Container container=getContentPane();

		container.setBackground(Color.white);

		JLabel jl= new JLabel("��������ȷ�ĺ��������и�����!");

	    jl.setBounds(50,50,200,100);

		container.add(jl);

	    setVisible(true);

	    }

	

}

public class alert4 extends JDialog {

	 public alert4(){

		setTitle("ע��!");

		setLayout(null);

		setBounds(400,300,300,200);

		Container container=getContentPane();

		container.setBackground(Color.white);

		JLabel jl= new JLabel("����ѡ��ͼƬ");

	    jl.setBounds(50,50,200,100);

		container.add(jl);

	    setVisible(true);

	    }

	

}


