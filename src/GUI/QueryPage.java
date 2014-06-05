package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//��ѯҳ�棬��ѯ�����������ѡ��ʾ��ʽ����񣬱�ͼ����״ͼ
public class QueryPage{
	private JFrame frame;
	private JPanel group;//��ѡ�������һ���Ű�
	private JLabel label1;
	private JTextField libname;//�ʿ������봦
	private JLabel label2;
	private ButtonGroup bg;//ѡ��ͳ�����ݵı�����ʽ
	private JRadioButton form;//���
	private JRadioButton pie;//��ͼ
	private JRadioButton bar;//��״ͼ
	private JButton confirm;//ȷ�ϰ�ť
	private JButton exit;
	
	public QueryPage(){
		//��ʼ����ǩ
		label1 = new JLabel("������ʿ�������ĸa-z����");
		label2 = new JLabel("��ѡ��ͳ�����ݵı�����ʽ��");
		
		//��ʼ�������
		libname = new JTextField();
		
		//��ʼ����ѡ��
		form = new JRadioButton("���");
		pie = new JRadioButton("��ͼ");
		bar = new JRadioButton("��״ͼ");
		bg = new ButtonGroup();
		bg.add(form);
		bg.add(pie);
		bg.add(bar);
		form.setSelected(true);
		
		//��ʼ����ť
		confirm = new JButton("ȷ��");
		exit = new JButton("ȡ��");
		
		//��ʼ����ѡ�����
		group = new JPanel();
		group.setLayout(new GridLayout(1,3));
		group.add(form);
		group.add(pie);
		group.add(bar);
		
		//��ʼ������
		frame = new JFrame("WordMaster");
		frame.setSize(400, 150);
		int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;  
		int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;  
		frame.setLocation((screen_width - frame.getWidth()) / 2, (screen_height - frame.getHeight()) / 2);
		frame.setResizable(false);//��������
		frame.setVisible(true);
		
		frame.setLayout(new GridLayout(3,2));
		frame.add(label1);
		frame.add(libname);
		frame.add(label2);
		frame.add(group);
		frame.add(confirm);
		frame.add(exit);
		
		//����¼�
		//���ȷ��,�жϴʿ����Ƿ���ϸ�ʽ������������ʾ������������û�������ʾͳ������
		confirm.addActionListener(new ActionListener() {
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
					if(name.length()>1){
						throw new Exception("�ʿ���ӦΪһ����ĸ��");
					}else if(name.charAt(0)<'a' || name.charAt(0)>'z'){
						throw new Exception("�ʿ���ӦΪa-z��");
					}
					new Gui(name,type); 
				} catch (Exception ex) {
					if(ex.getMessage().equals("String index out of range: 0")){
						JOptionPane.showMessageDialog(frame, "�ʿ�������Ϊ�գ�",
								"����", JOptionPane.ERROR_MESSAGE);  
					}else{
						JOptionPane.showMessageDialog(frame, ex.getMessage(),
								"����", JOptionPane.ERROR_MESSAGE);
					}		  
				} 
			}	
		});
		//���ȡ�������ڹر�
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}	
		});
	}
}
