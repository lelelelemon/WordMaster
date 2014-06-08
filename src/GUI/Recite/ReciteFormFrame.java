package GUI.Recite;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReciteFormFrame extends JFrame {

	private JPanel	contentPane;
	private JLabel charLbl;
	private JLabel correctLbl;
	private JLabel wrongLbl;
	private JLabel totalLbl;
	private JLabel rateLbl;


	/**
	 * Create the frame.
	 */
	
	public ReciteFormFrame(char listName, int total, int right) {
		int wrong = total - right;
		int rate = (int) (1.0 * right / total * 10000.0); // 2 digits after dot
		
		setResizable(false);
		setTitle("统计结果");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		charLbl = new JLabel("" + listName);
		charLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		charLbl.setHorizontalAlignment(SwingConstants.CENTER);
		charLbl.setBounds(181, 21, 61, 16);
		contentPane.add(charLbl);
		
		JLabel lblCorrectNum = new JLabel("正确词数:");
		lblCorrectNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorrectNum.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCorrectNum.setBounds(67, 59, 122, 25);
		contentPane.add(lblCorrectNum);
		
		JLabel lblWrongNum = new JLabel("错误次数:");
		lblWrongNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblWrongNum.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblWrongNum.setBounds(67, 96, 122, 25);
		contentPane.add(lblWrongNum);
		
		JLabel lblTotalNum = new JLabel("总次数:");
		lblTotalNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalNum.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTotalNum.setBounds(67, 133, 122, 25);
		contentPane.add(lblTotalNum);
		
		JLabel lblCorrectRate = new JLabel("正确率:");
		lblCorrectRate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorrectRate.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCorrectRate.setBounds(67, 170, 122, 25);
		contentPane.add(lblCorrectRate);
		
		correctLbl = new JLabel("" + right);
		correctLbl.setHorizontalAlignment(SwingConstants.CENTER);
		correctLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		correctLbl.setBounds(225, 59, 122, 25);
		contentPane.add(correctLbl);
		
		wrongLbl = new JLabel("" + wrong);
		wrongLbl.setHorizontalAlignment(SwingConstants.CENTER);
		wrongLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		wrongLbl.setBounds(225, 96, 122, 25);
		contentPane.add(wrongLbl);
		
		totalLbl = new JLabel("" + total);
		totalLbl.setHorizontalAlignment(SwingConstants.CENTER);
		totalLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		totalLbl.setBounds(225, 133, 122, 25);
		contentPane.add(totalLbl);
		
		rateLbl = new JLabel(rate / 100.0 + "%");
		rateLbl.setHorizontalAlignment(SwingConstants.CENTER);
		rateLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		rateLbl.setBounds(225, 170, 122, 25);
		contentPane.add(rateLbl);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnOk.setBounds(151, 226, 117, 29);
		contentPane.add(btnOk);
	}
}
