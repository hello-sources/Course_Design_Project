
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
