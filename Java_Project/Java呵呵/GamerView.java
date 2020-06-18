package com.rookie.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import com.rookie.dao.PicloadDao;
import com.rookie.dao.GameDao;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class GamerView extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private static JTextField textField_time;
    private static JButton bt_GameBegin = null;
    private static JLabel jl_loadImage = null;
    private static JComboBox comboBox_SelectPic = null;
    private static JRadioButton rb_simple = null;
    private static JRadioButton rb_difficulty = null;
    private static JPanel panel_beginGame = null;
    private static GameDao gameChoseDao;
    private static int time = 0;
    private static Timer timer;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GamerView frame = new GamerView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public GamerView() {
        setResizable(false);
        setTitle("\u62FC\u56FE\u6E38\u620F(\u6D4B\u8BD5\u7248)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 710, 550);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu m_About = new JMenu("\u5173\u4E8E");
        menuBar.add(m_About);
        
        JMenuItem mI_aboutMe = new JMenuItem("\u56E2\u961F\u4ECB\u7ECD");
        mI_aboutMe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAboutActionListener(e);
            }
        });
        m_About.add(mI_aboutMe);
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(mainPanel);
        
        JPanel panel_checkGame = new JPanel();
        panel_checkGame.setBorder(new TitledBorder(null, "\u6E38\u620F\u9009\u9879\uFF1A", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
        
        JPanel panel_loadPic = new JPanel();
        panel_loadPic.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u539F\u56FE\u52A0\u8F7D\uFF1A", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
        panel_loadPic.setToolTipText("");
        
        panel_beginGame = new JPanel();
        panel_beginGame.setBorder(new TitledBorder(null, "\u6E38\u620F\u5F00\u59CB\uFF1A", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
        GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
        gl_mainPanel.setHorizontalGroup(
            gl_mainPanel.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_mainPanel.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
                        .addComponent(panel_checkGame, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                        .addGroup(Alignment.LEADING, gl_mainPanel.createSequentialGroup()
                            .addComponent(panel_loadPic, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(panel_beginGame, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
        );
        gl_mainPanel.setVerticalGroup(
            gl_mainPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_mainPanel.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel_checkGame, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(panel_loadPic, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                        .addComponent(panel_beginGame, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
                    .addContainerGap())
        );
        
        jl_loadImage = new JLabel("");
        jl_loadImage.setIcon(null);
        panel_loadPic.add(jl_loadImage);
        


        GroupLayout gl_panel_beginGame = new GroupLayout(panel_beginGame);
        gl_panel_beginGame.setHorizontalGroup(
            gl_panel_beginGame.createParallelGroup(Alignment.LEADING)
                .addGap(0, 320, Short.MAX_VALUE)
        );
        gl_panel_beginGame.setVerticalGroup(
            gl_panel_beginGame.createParallelGroup(Alignment.LEADING)
                .addGap(0, 322, Short.MAX_VALUE)
        );
        panel_beginGame.setLayout(gl_panel_beginGame);
        
        JLabel label = new JLabel("\u6E38\u620F\u96BE\u5EA6\uFF1A");
        label.setForeground(Color.BLUE);
        
        rb_simple = new JRadioButton("\u7B80\u5355");
        buttonGroup.add(rb_simple);
        
        rb_difficulty = new JRadioButton("\u56F0\u96BE");
        buttonGroup.add(rb_difficulty);
        
        rb_simple.setSelected(true);
        
        JLabel label_1 = new JLabel("\u56FE\u7247\u9009\u62E9\uFF1A");
        label_1.setForeground(Color.BLUE);
        
        comboBox_SelectPic = new JComboBox();
        comboBox_SelectPic.setModel(new DefaultComboBoxModel(new String[] {"\u98CE\u666F", "\u7F8E\u5973", "\u8C6A\u8F66", "\u6E38\u620F"}));
        comboBox_SelectPic.setMaximumRowCount(5);
        
        JLabel label_2 = new JLabel("\u6E38\u620F\u65F6\u95F4\uFF1A");
        label_2.setForeground(Color.BLUE);
        
        textField_time = new JTextField();
        textField_time.setHorizontalAlignment(SwingConstants.RIGHT);
        textField_time.setText("0");
        textField_time.setEditable(false);
        textField_time.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("\u79D2");
        lblNewLabel.setForeground(Color.BLUE);
        
        bt_GameBegin = new JButton("\u5F00\u59CB\u6E38\u620F");
        bt_GameBegin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
                buttonClickAction(eve);
            }
        });
        GroupLayout gl_panel_checkGame = new GroupLayout(panel_checkGame);
        gl_panel_checkGame.setHorizontalGroup(
            gl_panel_checkGame.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_checkGame.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label)
                    .addGap(6)
                    .addGroup(gl_panel_checkGame.createParallelGroup(Alignment.TRAILING)
                        .addComponent(rb_difficulty)
                        .addGroup(gl_panel_checkGame.createSequentialGroup()
                            .addComponent(rb_simple)
                            .addPreferredGap(ComponentPlacement.RELATED)))
                    .addGap(18)
                    .addComponent(label_1)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(comboBox_SelectPic, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                    .addGap(32)
                    .addComponent(label_2)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(textField_time, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblNewLabel)
                    .addGap(52)
                    .addComponent(bt_GameBegin, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(76, Short.MAX_VALUE))
        );
        gl_panel_checkGame.setVerticalGroup(
            gl_panel_checkGame.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_checkGame.createSequentialGroup()
                    .addGroup(gl_panel_checkGame.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_checkGame.createSequentialGroup()
                            .addComponent(rb_simple)
                            .addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                            .addComponent(rb_difficulty))
                        .addGroup(gl_panel_checkGame.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(gl_panel_checkGame.createParallelGroup(Alignment.BASELINE)
                                .addComponent(label_1)
                                .addComponent(comboBox_SelectPic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField_time, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNewLabel)
                                .addComponent(label_2)
                                .addComponent(bt_GameBegin, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(gl_panel_checkGame.createSequentialGroup()
                            .addGap(22)
                            .addComponent(label)))
                    .addContainerGap())
        );
        panel_checkGame.setLayout(gl_panel_checkGame);
        mainPanel.setLayout(gl_mainPanel);
    }

    private void showAboutActionListener(ActionEvent e) {
        // TODO Auto-generated method stub
        JOptionPane.showMessageDialog(null, "QQ：523980553");
    }
    
    private void buttonClickAction(ActionEvent eve) {
        // TODO Auto-generated method stub
        //设置按钮标题
        if( bt_GameBegin.getText().equals("开始游戏") ) {
            beginGame();
            timer = new Timer();
            timer.scheduleAtFixedRate(new MyTase(), 0, 900);
        }
        else {
            resetGame();
            
        }

    }
    
    public static void beginGame() {
        bt_GameBegin.setText("重置游戏");
        //获取ComBox选项
        int picId = comboBox_SelectPic.getSelectedIndex();
        //加载图片
        PicloadDao pic = new PicloadDao();
        pic.loadPic(picId, jl_loadImage);
        //获取难易度
        if(rb_simple.isSelected()) {
            gameChoseDao = new GameDao();
            gameChoseDao.initButton(panel_beginGame);
            gameChoseDao.randomLoadPic(picId);
            
        }else if(rb_difficulty.isSelected()) {
            
        }
    }
    
    public static void resetGame() {
        bt_GameBegin.setText("开始游戏");
        rb_simple.setSelected(true);
        comboBox_SelectPic.setSelectedIndex(0);
        textField_time.setText(""+0);
        jl_loadImage.setIcon(null);
        gameChoseDao.resetButton();
        time = 0;
        timer.cancel(); 
    }
    
    class MyTase extends TimerTask{
        @Override
        public void run() {
            // TODO Auto-generated method stub
            time ++;
            textField_time.setText("" + time);
            if(time == 60) {
                JOptionPane.showMessageDialog(null, "挑战失败！！！");
                resetGame();
            }
        }    
    }    
}
