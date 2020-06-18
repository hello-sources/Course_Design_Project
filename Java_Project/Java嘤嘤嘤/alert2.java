
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
