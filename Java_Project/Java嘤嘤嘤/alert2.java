
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
