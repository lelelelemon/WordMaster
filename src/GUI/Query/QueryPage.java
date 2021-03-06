package GUI.Query;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

import GUI.Gui;
import InterfaceOfModel.InterfaceOfUser;

//查询页面，查询背诵情况，可选显示形式：表格，饼图，柱状图
public class QueryPage{
	private JFrame frame;
	private JPanel group;//单选框组合在一起排版
	private JLabel label1;
	private JTextField libname;//词库名输入处
	private JLabel label2;
	private ButtonGroup bg;//选择统计数据的表现形式
	private JRadioButton form;//表格
	private JRadioButton pie;//饼图
	private JRadioButton bar;//柱状图
	private JButton confirm;//确认按钮
	private JButton exit;
	private InterfaceOfUser user;
	private JComboBox	comboBox;
	public QueryPage(final InterfaceOfUser user){
		//初始化标签
		label1 = new JLabel("请选择词库名：");
		label2 = new JLabel("请选择统计数据的表现形式：");
		
		//初始化输入框
		libname = new JTextField();
		libname.setText("a");
		Vector<String> charList = new Vector<String>();
		for (int i = 0; i < 10; i++) {
			String listName = user.getAllList().getListName(i);
			charList.add(listName);
		}
		charList.add("all");
		comboBox = new JComboBox(charList);
		comboBox.setBounds(6, 6, 360, 27);
		//初始化单选框
		form = new JRadioButton("表格");
		pie = new JRadioButton("饼图");
		bar = new JRadioButton("柱状图");
		bg = new ButtonGroup();
		bg.add(form);
		bg.add(pie);
		bg.add(bar);
		form.setSelected(true);
		
		//初始化按钮
		confirm = new JButton("确认");
		exit = new JButton("取消");
		
		//初始化单选框组合
		group = new JPanel();
		group.setLayout(new GridLayout(1,3));
		group.add(form);
		group.add(pie);
		group.add(bar);
		
		//初始化窗口
		frame = new JFrame("WordMaster");
		frame.setSize(400, 150);
		int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;  
		int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;  
		frame.setLocation((screen_width - frame.getWidth()) / 2, (screen_height - frame.getHeight()) / 2);
		frame.setResizable(false);//不可缩放
		frame.setVisible(true);
		
		frame.setLayout(new GridLayout(3,2));
		frame.add(label1);
		//frame.add(libname);
		frame.add(comboBox);
		frame.add(label2);
		frame.add(group);
		frame.add(confirm);
		frame.add(exit);
		
		
		//添加事件
		//点击确认,判断词库名是否符合格式，不符合则提示，符合则根据用户输入显示统计数据
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name;
				String type="";
				if(form.isSelected()){
					type = "form";
				}
				if(pie.isSelected()){
					type = "pie";
				}
				if(bar.isSelected()){
					type = "bar";
				}
				try{
					try{
						name = libname.getText();
					}catch (Exception e) {  
                        throw new Exception();  
                    }
					/*
					if(name.length()>1){
						throw new Exception("词库名应为一个字母！");
					}else if(name.charAt(0)<'a' || name.charAt(0)>'z'){
						throw new Exception("词库名应为a-z！");
					}
					*/
					int choosenListIndex = comboBox.getSelectedIndex();				
					new Gui(user).getChart(choosenListIndex, type);; 
				} catch (Exception ex) {
					if(ex.getMessage().equals("String index out of range: 0")){
						JOptionPane.showMessageDialog(frame, "词库名不得为空！",
								"错误", JOptionPane.ERROR_MESSAGE);  
					}else{
						JOptionPane.showMessageDialog(frame, ex.getMessage(),
								"错误", JOptionPane.ERROR_MESSAGE);
					}		  
				} 
			}	
		});
		//点击取消，窗口关闭
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}	
		});
	}
}
