package GUI.Recite;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import Model.Task;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReciteFrame extends JFrame {

	Task task;
	int pastNum = 0;
	int rightNum = 0;
	
	JLabel chineseLbl;
	private JPanel	contentPane;
	private JTextField englishTxtField;
	private JLabel lblToGo;

	/**
	 * Create the frame.
	 */
	public ReciteFrame(Task task) {
		this();
		this.task = task;
		displayNext();
	}
	
	public ReciteFrame() {
		setResizable(false);
		setTitle("±³ËÐ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		chineseLbl = new JLabel("hello world");
		chineseLbl.setHorizontalAlignment(SwingConstants.CENTER);
		chineseLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		chineseLbl.setBounds(35, 31, 380, 57);
		contentPane.add(chineseLbl);
		
		englishTxtField = new JTextField();
		englishTxtField.setBounds(87, 100, 276, 28);
		contentPane.add(englishTxtField);
		englishTxtField.setColumns(10);
		
		JButton btnNext = new JButton("ÏÂÒ»¸ö");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputEng = englishTxtField.getText();
				String realEng = task.getEnglish();
				
				// update pastNum and rightNum
				pastNum++;
				// show right answer
				if (!inputEng.equals(realEng)) {
					task.update(false);
					JOptionPane.showMessageDialog(null, "Answer is: " + realEng, 
							"Answer", JOptionPane.OK_OPTION);
				}else {
					rightNum++;
					task.update(true);
				}
				
				if (pastNum < task.getTotal()) {
					// not finished
					task.next();
					displayNext();
				}else {
					// finished
					if (task.checkFinish()) {
						JOptionPane.showMessageDialog(null, "You've finished this list!");
					}
					int wordListIndex = task.getWordList().getWordList();
					char wordListChar = (char) ('A' + wordListIndex);
					
					ReciteFormFrame formFrame = new ReciteFormFrame(wordListChar, 
							pastNum, rightNum);
					setVisible(false);
					formFrame.setVisible(true);
				}
			}
		});
		btnNext.setBounds(166, 158, 117, 29);
		contentPane.add(btnNext);
		
		lblToGo = new JLabel("6 TO GO");
		lblToGo.setHorizontalAlignment(SwingConstants.CENTER);
		lblToGo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblToGo.setBounds(181, 192, 88, 28);
		contentPane.add(lblToGo);
	}
	
	/**
	 * Help methods
	 */
	void displayNext() {
		// display remain
		int remain = task.getTotal() - this.pastNum;
		this.lblToGo.setText(remain + " TO GO");
		
		// get word's info
		String chineseStr = task.getChinese();
		// display chinese
		this.chineseLbl.setText(chineseStr);
		// clear english
		this.englishTxtField.setText("");
		this.englishTxtField.requestFocus();
	}
}
