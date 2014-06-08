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
		//初始化窗口
		frame = new JFrame("WordMaster");
		screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;  
		screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;  
		frame.setResizable(false);//不可缩放
		frame.setVisible(true);
	}
	
	//生成图表
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
	
	//生成表格
	private void getForm(String libname) {
		//获取数据
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
		String percent = rate+"%";//转化正确率以百分数显示
		
		//初始化表格
		Object[][] cellData = {{"词库名", libname},{"词库单词总数", new Integer(total)},
				{"已背单词数",new Integer(recited)},{"正确单词数",new Integer(right)},
				{"错误单词数",new Integer(wrong)},{"正确率",percent}};
		String[] columnNames = {"项目", "数据"};
		JTable table = new JTable(cellData, columnNames);
		table.setRowHeight(20);
		table.setRowSelectionAllowed(false);
		
		//将表格加入窗口中
		JScrollPane pane = new JScrollPane (table);
		frame.setSize(300,180);
		frame.setLocation((screen_width - frame.getWidth()) / 2, (screen_height - frame.getHeight()) / 2);
		frame.add(pane);
	}
	
	//生成饼图
	private void getPie(String libname) {
		//获取数据
		//当前词库
		int total = statics.getTotalWordNum(libname); 
		int recited = statics.getRecitedWordNum(libname);
		int right = statics.getRightWordNum(libname);
		int wrong = statics.getWrongWordNum(libname);
		//全部词库
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
		
		//饼图1：当前词库单词背诵情况
		String piename1 = "词库" + libname + "单词背诵情况";
		DefaultPieDataset data1 = new DefaultPieDataset();
		data1.setValue("已背单词数", recited);
		data1.setValue("未背单词数", total - recited);
		//饼图2：当前词库已背单词情况
		String piename2 = "词库" + libname + "已背单词情况";
		DefaultPieDataset data2 = new DefaultPieDataset();
		data2.setValue("正确单词数", right);
		data2.setValue("错误单词数", wrong);
		//饼图3：全部词库单词背诵情况
		String piename3 = "全部词库单词背诵情况";
		DefaultPieDataset data3 = new DefaultPieDataset();
		data3.setValue("已背单词数", allrecited);
		data3.setValue("未背单词数", alltotal - allrecited);
		//饼图4：全部词库已背单词情况
		String piename4 = "全部词库已背单词情况";
		DefaultPieDataset data4 = new DefaultPieDataset();
		data4.setValue("正确单词数", allright);
		data4.setValue("错误单词数", allwrong);
		
		//获取
		ChartPanel pie1 = getPiePanel(piename1,data1);
		ChartPanel pie2 = getPiePanel(piename2,data2);
		ChartPanel pie3 = getPiePanel(piename3,data3);
		ChartPanel pie4 = getPiePanel(piename4,data4);
		
		//添加
		frame.setSize(800, 600);
		frame.setLocation((screen_width - frame.getWidth()) / 2, (screen_height - frame.getHeight()) / 2);
		frame.setLayout(new GridLayout(2,2,10,10));
		frame.add(pie1);
		frame.add(pie2);
		frame.add(pie3);
		frame.add(pie4);
	}
	
	//根据图名和数据生成对应饼图
	private ChartPanel getPiePanel(String piename, DefaultPieDataset dataSet){
		JFreeChart chart = ChartFactory.createPieChart3D(piename,dataSet,true,false,false);  
		//设置格式，解决中文乱码
		chart.getTitle().setFont(new Font("宋体",Font.BOLD,15));
		chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
		
		PiePlot pieplot = (PiePlot) chart.getPlot();
		pieplot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码
		//设置显示百分比
		DecimalFormat df = new DecimalFormat("0.00%");
		NumberFormat nf = NumberFormat.getNumberInstance();
		StandardPieSectionLabelGenerator sp = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);
		pieplot.setLabelGenerator(sp);
		//设置无数据时的显示
		pieplot.setNoDataMessage("无相关数据");  
		pieplot.setCircular(false);  
		pieplot.setLabelGap(0.02D);

		ChartPanel pie = new ChartPanel (chart,true);
		return pie;
	}
	
	//生成柱状图
	private void getBar(String libname) {
		//获取数据
		//当前词库 
		int recited = statics.getRecitedWordNum(libname);
		double rate = statics.getRightRate(libname);
		//全部词库
		int allrecited = statics.getRecitedWordNum("all");
		double allrate = statics.getRightRate("all");
//		int recited = 30;
//		double rate = 0.6667;
//		int allrecited = 440;
//		double allrate = 0.5000;
		
		//柱状图1：当前词库及全部词库已背单词数对比
		String barname1 = "当前词库及全部词库已背单词数";
		String dirlabel1 = "范围";
		String valuelabel1 = "已背单词数";
		DefaultCategoryDataset data1 = new DefaultCategoryDataset();
		data1.addValue(recited, "词库"+libname, "词库"+libname);
		data1.addValue(allrecited, "全部词库", "全部词库");
		//柱状图2：当前词库及全部词库背诵正确率对比
		String barname2 = "当前词库及全部词库背诵正确率";
		String dirlabel2 = "范围";
		String valuelabel2 = "背诵正确率";
		DefaultCategoryDataset data2 = new DefaultCategoryDataset();
		data2.addValue(rate, "词库"+libname, "词库"+libname);
		data2.addValue(allrate, "全部词库", "全部词库");
		
		//获取
		ChartPanel bar1 = getBarPanel(barname1,dirlabel1,valuelabel1,data1);
		ChartPanel bar2 = getBarPanel(barname2,dirlabel2,valuelabel2,data2);
		
		//添加
		frame.setSize(500, 300);
		frame.setLocation((screen_width - frame.getWidth()) / 2, (screen_height - frame.getHeight()) / 2);
		frame.setLayout(new GridLayout(1,2,10,10));
		frame.add(bar1);
		frame.add(bar2);
	}
	
	//根据图名，目录标签，数值标签和数据生成对应柱状图
	private ChartPanel getBarPanel(String barname, String dirlabel, 
			String valuelabel, CategoryDataset dataSet){
		JFreeChart chart = ChartFactory.createBarChart3D(barname, dirlabel, 
				valuelabel, dataSet, PlotOrientation.VERTICAL, true, false, false);
		//设置格式，解决中文乱码
		chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));
		chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
		
		CategoryPlot plot=chart.getCategoryPlot();
		CategoryAxis domainAxis=plot.getDomainAxis();
		domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));
		domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));
		ValueAxis rangeAxis=plot.getRangeAxis();
		rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
		
		ChartPanel bar = new ChartPanel (chart,true);
		return bar;
	}
}
