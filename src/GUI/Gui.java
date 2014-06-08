package GUI;

import java.awt.*;
import java.math.BigDecimal;
import java.text.*;

import javax.swing.*;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;  
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;  
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import Controller.*;
import InterfaceOfModel.InterfaceOfAllList;
import InterfaceOfModel.InterfaceOfUser;

public class Gui {
	private JFrame frame;
	private QueryController statics;
	private int screen_width;
	private int screen_height;
	
	public Gui(InterfaceOfUser user){
		InterfaceOfAllList allList = user.getAllList();
		statics = new QueryControl(allList);
		//��ʼ������
		frame = new JFrame("WordMaster");
		screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;  
		screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;  
		frame.setResizable(false);//��������
		frame.setVisible(true);
	}
	
	//����ͼ��
	public void getChart(String libname, String type){
		switch (type){
		case "form":
			getForm(libname);
			break;
		case "pie":
			getPie(libname);
			break;
		case "bar":
			getBar(libname);
			break;
		}
	}
	
	//���ɱ��
	private void getForm(String libname) {
		//��ȡ����
		int total = statics.getTotalWordNum(libname); 
		int recited = statics.getRecitedWordNum(libname);
		int right = statics.getRightWordNum(libname);
		int wrong = statics.getWrongWordNum(libname);
		double rate = statics.getRightRate(libname);
//		int total = 50; 
//		int recited = 30;
//		int right = 20;
//		int wrong = 10;
//		double rate = 0.6667;
		
		rate = rate*100;
		BigDecimal b = new BigDecimal(rate);
		rate = b.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
		String percent = rate+"%";//ת����ȷ���԰ٷ�����ʾ
		
		//��ʼ�����
		Object[][] cellData = {{"�ʿ���", libname},{"�ʿⵥ������", new Integer(total)},
				{"�ѱ�������",new Integer(recited)},{"��ȷ������",new Integer(right)},
				{"���󵥴���",new Integer(wrong)},{"��ȷ��",percent}};
		String[] columnNames = {"��Ŀ", "����"};
		JTable table = new JTable(cellData, columnNames);
		table.setRowHeight(20);
		table.setRowSelectionAllowed(false);
		
		//�������봰����
		JScrollPane pane = new JScrollPane (table);
		frame.setSize(300,180);
		frame.setLocation((screen_width - frame.getWidth()) / 2, (screen_height - frame.getHeight()) / 2);
		frame.add(pane);
	}
	
	//���ɱ�ͼ
	private void getPie(String libname) {
		//��ȡ����
		//��ǰ�ʿ�
		int total = statics.getTotalWordNum(libname); 
		int recited = statics.getRecitedWordNum(libname);
		int right = statics.getRightWordNum(libname);
		int wrong = statics.getWrongWordNum(libname);
		//ȫ���ʿ�
		int alltotal = statics.getTotalWordNum("all"); 
		int allrecited = statics.getRecitedWordNum("all");
		int allright = statics.getRightWordNum("all");
		int allwrong = statics.getWrongWordNum("all");
//		int total = 50;
//		int recited = 30;
//		int right = 20;
//		int wrong = 10;
//		int alltotal = 1444;
//		int allrecited = 443;
//		int allright = 223;
//		int allwrong = 220;
		
		//��ͼ1����ǰ�ʿⵥ�ʱ������
		String piename1 = "�ʿ�" + libname + "���ʱ������";
		DefaultPieDataset data1 = new DefaultPieDataset();
		data1.setValue("�ѱ�������", recited);
		data1.setValue("δ��������", total - recited);
		//��ͼ2����ǰ�ʿ��ѱ��������
		String piename2 = "�ʿ�" + libname + "�ѱ��������";
		DefaultPieDataset data2 = new DefaultPieDataset();
		data2.setValue("��ȷ������", right);
		data2.setValue("���󵥴���", wrong);
		//��ͼ3��ȫ���ʿⵥ�ʱ������
		String piename3 = "ȫ���ʿⵥ�ʱ������";
		DefaultPieDataset data3 = new DefaultPieDataset();
		data3.setValue("�ѱ�������", allrecited);
		data3.setValue("δ��������", alltotal - allrecited);
		//��ͼ4��ȫ���ʿ��ѱ��������
		String piename4 = "ȫ���ʿ��ѱ��������";
		DefaultPieDataset data4 = new DefaultPieDataset();
		data4.setValue("��ȷ������", allright);
		data4.setValue("���󵥴���", allwrong);
		
		//��ȡ
		ChartPanel pie1 = getPiePanel(piename1,data1);
		ChartPanel pie2 = getPiePanel(piename2,data2);
		ChartPanel pie3 = getPiePanel(piename3,data3);
		ChartPanel pie4 = getPiePanel(piename4,data4);
		
		//���
		frame.setSize(800, 600);
		frame.setLocation((screen_width - frame.getWidth()) / 2, (screen_height - frame.getHeight()) / 2);
		frame.setLayout(new GridLayout(2,2,10,10));
		frame.add(pie1);
		frame.add(pie2);
		frame.add(pie3);
		frame.add(pie4);
	}
	
	//����ͼ�����������ɶ�Ӧ��ͼ
	private ChartPanel getPiePanel(String piename, DefaultPieDataset dataSet){
		JFreeChart chart = ChartFactory.createPieChart3D(piename,dataSet,true,false,false);  
		//���ø�ʽ�������������
		chart.getTitle().setFont(new Font("����",Font.BOLD,15));
		chart.getLegend().setItemFont(new Font("����",Font.BOLD,10));
		
		PiePlot pieplot = (PiePlot) chart.getPlot();
		pieplot.setLabelFont(new Font("����",Font.BOLD,10));//�������
		//������ʾ�ٷֱ�
		DecimalFormat df = new DecimalFormat("0.00%");
		NumberFormat nf = NumberFormat.getNumberInstance();
		StandardPieSectionLabelGenerator sp = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);
		pieplot.setLabelGenerator(sp);
		//����������ʱ����ʾ
		pieplot.setNoDataMessage("���������");  
		pieplot.setCircular(false);  
		pieplot.setLabelGap(0.02D);

		ChartPanel pie = new ChartPanel (chart,true);
		return pie;
	}
	
	//������״ͼ
	private void getBar(String libname) {
		//��ȡ����
		//��ǰ�ʿ� 
		int recited = statics.getRecitedWordNum(libname);
		double rate = statics.getRightRate(libname);
		//ȫ���ʿ�
		int allrecited = statics.getRecitedWordNum("all");
		double allrate = statics.getRightRate("all");
//		int recited = 30;
//		double rate = 0.6667;
//		int allrecited = 440;
//		double allrate = 0.5000;
		
		//��״ͼ1����ǰ�ʿ⼰ȫ���ʿ��ѱ��������Ա�
		String barname1 = "��ǰ�ʿ⼰ȫ���ʿ��ѱ�������";
		String dirlabel1 = "��Χ";
		String valuelabel1 = "�ѱ�������";
		DefaultCategoryDataset data1 = new DefaultCategoryDataset();
		data1.addValue(recited, "�ʿ�"+libname, "�ʿ�"+libname);
		data1.addValue(allrecited, "ȫ���ʿ�", "ȫ���ʿ�");
		//��״ͼ2����ǰ�ʿ⼰ȫ���ʿⱳ����ȷ�ʶԱ�
		String barname2 = "��ǰ�ʿ⼰ȫ���ʿⱳ����ȷ��";
		String dirlabel2 = "��Χ";
		String valuelabel2 = "������ȷ��";
		DefaultCategoryDataset data2 = new DefaultCategoryDataset();
		data2.addValue(rate, "�ʿ�"+libname, "�ʿ�"+libname);
		data2.addValue(allrate, "ȫ���ʿ�", "ȫ���ʿ�");
		
		//��ȡ
		ChartPanel bar1 = getBarPanel(barname1,dirlabel1,valuelabel1,data1);
		ChartPanel bar2 = getBarPanel(barname2,dirlabel2,valuelabel2,data2);
		
		//���
		frame.setSize(500, 300);
		frame.setLocation((screen_width - frame.getWidth()) / 2, (screen_height - frame.getHeight()) / 2);
		frame.setLayout(new GridLayout(1,2,10,10));
		frame.add(bar1);
		frame.add(bar2);
	}
	
	//����ͼ����Ŀ¼��ǩ����ֵ��ǩ���������ɶ�Ӧ��״ͼ
	private ChartPanel getBarPanel(String barname, String dirlabel, 
			String valuelabel, CategoryDataset dataSet){
		JFreeChart chart = ChartFactory.createBarChart3D(barname, dirlabel, 
				valuelabel, dataSet, PlotOrientation.VERTICAL, true, false, false);
		//���ø�ʽ�������������
		chart.getTitle().setFont(new Font("����",Font.BOLD,20));
		chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
		
		CategoryPlot plot=chart.getCategoryPlot();
		CategoryAxis domainAxis=plot.getDomainAxis();
		domainAxis.setLabelFont(new Font("����",Font.BOLD,14));
		domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));
		ValueAxis rangeAxis=plot.getRangeAxis();
		rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));
		
		ChartPanel bar = new ChartPanel (chart,true);
		return bar;
	}
}
