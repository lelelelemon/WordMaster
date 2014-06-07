package GUI.Start;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import GUI.Query.QueryPage;
import GUI.Recite.RecitePage;
import GUI.Set.SettingPage;
import InterfaceOfModel.InterfaceOfUser;
import Model.*;

//�����ʼ����
public class StartPage{
	private JFrame frame;
	private JPanel northPanel;
	private JPanel southPanel;
	private JLabel label;//ͼ��
	private JButton start;//��ʼ������
	private JButton set;//����
	private JButton query;//��ѯ�������
	private JButton exit;//�˳�
	private InterfaceOfUser user;

	//������������ִ�����
	public static void main(String[] args){
		new StartPage(new User(26,"dictionnary.txt"));
	}
	
	public StartPage(final InterfaceOfUser user) {
		this.user = user;
		//��ʼ�����o��ͼ��
		label = new JLabel(new ImageIcon("picture/icon.jpg"));
		start = new JButton("������");
		set =  new JButton("����");
		query = new JButton("ͳ������");
		exit = new JButton("�˳�");
        //��ʼ�������ϰ벿��
		northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		northPanel.add(label, "Center");
		//��ʼ�������°벿��
		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(2,2,10,5));
		southPanel.add(start);
		southPanel.add(set);
		southPanel.add(query);
		southPanel.add(exit);
		//��ʼ������
		frame = new JFrame("WordMaster");
		frame.setSize(400, 300);
		int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;  
		int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;  
		frame.setLocation((screen_width - frame.getWidth()) / 2, (screen_height - frame.getHeight()) / 2);
		frame.setResizable(false);//��������
		frame.setVisible(true);
		
		frame.setLayout(new BorderLayout());
		frame.add(northPanel,"North");
		frame.add(southPanel,"South");
		
		//����¼�
		//���ڹر�ʱ�������˳�
		frame.addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent e) { 
                System.exit(0);// �˳�����  
            }  
        });
		//��������ʣ�ת������ҳ�棬��ʼ������
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new RecitePage();
			}	
		});
		//������ã�ת������ҳ�棬��������
		set.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SettingPage();
			}	
		});
		//���ͳ�����ݣ�ת����ѯҳ�棬��ѯ�������
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new QueryPage(user);
			}	
		});
		//����˳���ť�������˳�
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}	
		});
	}
}
