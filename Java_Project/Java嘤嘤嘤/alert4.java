
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
