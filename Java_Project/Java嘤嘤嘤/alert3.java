
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
