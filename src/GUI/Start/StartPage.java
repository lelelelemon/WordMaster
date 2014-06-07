package GUI.Start;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import GUI.Query.QueryPage;
import GUI.Recite.RecitePage;
import GUI.Set.SettingPage;
import InterfaceOfModel.InterfaceOfUser;
import Model.*;

//软件开始界面
public class StartPage{
	private JFrame frame;
	private JPanel northPanel;
	private JPanel southPanel;
	private JLabel label;//图标
	private JButton start;//开始背单词
	private JButton set;//设置
	private JButton query;//查询背诵情况
	private JButton exit;//退出
	private InterfaceOfUser user;

	//主方法，程序执行入口
	public static void main(String[] args){
		new StartPage(new User(26,"dictionnary.txt"));
	}
	
	public StartPage(final InterfaceOfUser user) {
		this.user = user;
		//初始化按鈕及图标
		label = new JLabel(new ImageIcon("picture/icon.jpg"));
		start = new JButton("背单词");
		set =  new JButton("设置");
		query = new JButton("统计数据");
		exit = new JButton("退出");
        //初始化窗口上半部分
		northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		northPanel.add(label, "Center");
		//初始化窗口下半部分
		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(2,2,10,5));
		southPanel.add(start);
		southPanel.add(set);
		southPanel.add(query);
		southPanel.add(exit);
		//初始化窗口
		frame = new JFrame("WordMaster");
		frame.setSize(400, 300);
		int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;  
		int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;  
		frame.setLocation((screen_width - frame.getWidth()) / 2, (screen_height - frame.getHeight()) / 2);
		frame.setResizable(false);//不可缩放
		frame.setVisible(true);
		
		frame.setLayout(new BorderLayout());
		frame.add(northPanel,"North");
		frame.add(southPanel,"South");
		
		//添加事件
		//窗口关闭时，程序退出
		frame.addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent e) { 
                System.exit(0);// 退出程序  
            }  
        });
		//点击背单词，转到背诵页面，开始背单词
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new RecitePage();
			}	
		});
		//点击设置，转到设置页面，进行设置
		set.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SettingPage();
			}	
		});
		//点击统计数据，转到查询页面，查询背诵情况
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new QueryPage(user);
			}	
		});
		//点击退出按钮，程序退出
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}	
		});
	}
}
