package GUI.Recite;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.border.SoftBevelBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import InterfaceOfModel.InterfaceOfUser;
import InterfaceOfModel.InterfaceOfWord;
import InterfaceOfModel.InterfaceOfWordList;
import Model.Task;
import Model.User;
import Model.Word;
import Model.WordList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ChooseFrame extends JFrame {
	private InterfaceOfUser		user;

	private JComboBox	comboBox;
	private JPanel		contentPane;
	private JTextField	startWordTxtField;
	private JLabel		hintLbl;
	private JTextField	numberTxtField;

	/**
	 * Create the frame.
	 */
	public ChooseFrame(){
		
	}
	public ChooseFrame(InterfaceOfUser us) {
		this.user = us;
		int i;

		setResizable(false);
		setTitle("选择词库");
		setBounds(100, 100, 372, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Vector<String> charList = new Vector<String>();
		for (i = 0; i < 7; i++) {
			String listName = user.getAllList().getListName(i);
			charList.add(listName);
		}
		comboBox = new JComboBox(charList);
		comboBox.setBounds(6, 6, 360, 27);
		contentPane.add(comboBox);

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel.setBounds(16, 45, 338, 121);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblStartFrom = new JLabel("开始单词:");
		lblStartFrom.setBounds(6, 18, 77, 16);
		panel.add(lblStartFrom);

		startWordTxtField = new JTextField();
		startWordTxtField.setBounds(97, 12, 235, 28);
		startWordTxtField.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent evt) {
		    }
		 
		    public void keyReleased(KeyEvent evt) {
				String text = startWordTxtField.getText();
				int choosenListIndex = comboBox.getSelectedIndex();
				WordList wlist = (WordList) user.getAllList().getWordList(choosenListIndex);
				String hint = wlist.searchFirst(text);
				hintLbl.setText(hint);
			}
		    
			public void keyTyped(KeyEvent arg0) {
			}
		});
		panel.add(startWordTxtField);
		startWordTxtField.setColumns(10);
		
		hintLbl = new JLabel("");
		hintLbl.setBounds(97, 44, 235, 28);
		panel.add(hintLbl);

		JLabel lblNumber = new JLabel("背诵数量:");
		lblNumber.setBounds(6, 88, 67, 16);
		panel.add(lblNumber);

		numberTxtField = new JTextField();
		numberTxtField.setColumns(10);
		numberTxtField.setBounds(97, 82, 235, 28);
		panel.add(numberTxtField);

		JButton btnContinue = new JButton("续背");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!Debug.debug) {
					int wordListNum = getListNumber();
					int reciteNum = getReciteNumber();

					if (reciteNum == 0) {
						return;
					}
					
					user.setCurList(wordListNum);
					InterfaceOfWordList wordList = user.getAllList().getWordList(
							wordListNum);
					int startIndex = wordList.getOffset();

					// start a new task
					startTask(wordList, startIndex, reciteNum);
				} else {
					startTask(new WordList(), 1, 4);
				}
			}
		});
		btnContinue.setBounds(6, 178, 117, 29);
		contentPane.add(btnContinue);

		JButton btnStart = new JButton("开始");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int wordListNum = getListNumber();
				String startWordStr = getStartWord();
				int reciteNum = getReciteNumber();

				if (startWordStr == null || reciteNum <= 0) {
					return;
				}
				
				user.setCurList(wordListNum);
				
				int startIndex = 0;
				InterfaceOfWordList wordList = user.getAllList().getWordList(wordListNum);
				InterfaceOfWord startWord = user.search(startWordStr);
				if (startWord != null) {
					startIndex = startWord.getOffset();
				}else {
					JOptionPane.showMessageDialog(null, "找不到该起始单词，自动从头开始。");
				}

				// start a new task
				startTask(wordList, startIndex, reciteNum);
			}
		});
		btnStart.setBounds(127, 178, 117, 29);
		contentPane.add(btnStart);

		JButton btnBack = new JButton("返回");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(249, 178, 117, 29);
		contentPane.add(btnBack);
		this.setVisible(true);
	}
/*
	public ChooseFrame(InterfaceOfUser user) {
		this();
		this.user = user;
		this.setVisible(true);
	}
*/
	/**
	 * Help methods
	 */
	int getListNumber() {
		int n = comboBox.getSelectedIndex();
		return n;
	}

	String getStartWord() {
		String word = this.startWordTxtField.getText();
		if (word.equals("")) {
			return null;
		}
		return word;
	}

	int getReciteNumber() {
		Integer n = 0;
		String numStr = this.numberTxtField.getText();
		try {
			n = Integer.parseInt(numStr);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "背诵数量有误。");
		}
		return n;
	}

	void startTask(InterfaceOfWordList wordList, int start, int length) {
		// judge whether start+length is out of bound
		if (!user.judgeNumber(length)) {
			JOptionPane.showMessageDialog(null,
					"没有这么多单词，已自动调整.", "Warning",
					JOptionPane.OK_OPTION);
		}
		Task task = new Task(wordList, start, length);
		
		ReciteFrame reciteFrame = new ReciteFrame(task);
		this.setVisible(false);
		reciteFrame.setVisible(true);
	}
}
