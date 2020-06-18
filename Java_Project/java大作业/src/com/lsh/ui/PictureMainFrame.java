package com.lsh.ui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PictureMainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public static JTextField textField_1;
	private PictureCanvas canvas;
	private JComboBox<Object> comboBox=null;
	String[] items=new String[] {"人物","风景"};
	private PicturePreview preview;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PictureMainFrame() {
		setTitle("lsh的拼图");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 555);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8BBE\u7F6E", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_1);
		
		JCheckBox numTipBtn = new JCheckBox("数字提示");
		numTipBtn.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(numTipBtn.isSelected())
					canvas.reLoadPictureAddNumber();
				else 
					canvas.reLoadPictureClearNumber();
			}
		});
		
		panel_1.add(numTipBtn);
		
		JLabel lblNewLabel = new JLabel("选择图片：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()==ItemEvent.SELECTED){
					int num=comboBox.getSelectedIndex();
					
					PictureCanvas.pictureID=num+1;
					PictureCanvas.stepNum=0;
					
					textField_1.setText("步数：0");
					textField.setText("图片名称："+comboBox.getSelectedItem().toString());
					numTipBtn.setSelected(false);
					preview.repaint();
					canvas.reLoadImg();
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(items));
		panel_1.add(comboBox);
		
		JButton btnNewButton = new JButton("开始");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField_1.setText("步数：0");
				canvas.start();
			}
		});
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u72B6\u6001", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 2, 5, 5));
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("图片名称：人物");
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("步数：0");
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		addPreviewImage();
		
	}

	private void addPreviewImage() {
		// TODO Auto-generated method stub
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		
		canvas = new PictureCanvas();
		preview = new PicturePreview();
		panel.add(canvas);
		panel.add(preview);
		
		getContentPane().add(panel,BorderLayout.CENTER);
	}
}
