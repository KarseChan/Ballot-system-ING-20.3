package com.Karse.event.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Karse.event.controller.MatchController;
import com.Karse.event.dao.MatchDao;
import com.Karse.event.util.isEmpty;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class MatchAdd extends JFrame {

	private JPanel contentPane;
	private JTextField team1; //战队1
	private JTextField team2; //战队2
	private JTextField matchTime;  //赛事时间
	private JTextField matchPrice;
	
	private static MatchController matchController = new MatchController();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchAdd frame = new MatchAdd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void IntoMatchAdd(){
		/**
		 * 创建赛事添加窗口
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchAdd frame = new MatchAdd();
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
	public MatchAdd() {
		setTitle("\u8D5B\u4E8B\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8D5B\u4E8B\u540D\u79F0\uFF1A");
		
		team1 = new JTextField();
		team1.setColumns(10);
		
		JLabel label = new JLabel("\u8D5B\u4E8B\u65F6\u95F4\uFF1A");
		
		JLabel label_1 = new JLabel("\u8D5B\u4E8B\u4EF7\u683C\uFF1A");
		
		matchTime = new JTextField();
		matchTime.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//监听对输入的赛事名称和时间和描述进行插入数据库的操作
				addActionPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//监听赛事添加信息重置
				resetValueActionPerformed(e);
			}
		});
		
		team2 = new JTextField();
		team2.setColumns(10);
		
		JLabel lblVs = new JLabel("vs");
		
		matchPrice = new JTextField();
		matchPrice.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(125)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(team1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblVs)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(team2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(180)
							.addComponent(button)
							.addGap(55)
							.addComponent(button_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(123)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_1)
									.addGap(18)
									.addComponent(matchPrice, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addGap(18)
									.addComponent(matchTime, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(168, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(team1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVs)
						.addComponent(team2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(matchTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(matchPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(69)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(button))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(button_1)))
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void resetValueActionPerformed(ActionEvent e) {
		// 处理重置事件
		team1.setText("");
		team2.setText("");
		matchTime.setText("");
		matchPrice.setText("");
		
	}

	protected void addActionPerformed(ActionEvent e) {
		// 处理赛事添加事件
		String team1 = this.team1.getText();
		String team2 = this.team2.getText();
		String matchTime = this.matchTime.getText();
		String matchPrice = this.matchPrice.getText();
		 if(isEmpty.isEmpty(team1) || isEmpty.isEmpty(team2)){
			//参赛战队输入为空
			JOptionPane.showMessageDialog(null, "赛事名称不能为空");
			return;  //结束
		}else if(isEmpty.isEmpty(matchTime)){
			//赛事时间为空
			JOptionPane.showMessageDialog(null, "赛事时间不能为空");
			return;	
		}else if(isEmpty.isEmpty(matchPrice)){
			//赛事价格输入为空
			JOptionPane.showMessageDialog(null, "赛事价格不能为空");
			return;	
		}else if(matchController.addMatch(team1, team2, matchTime, matchPrice)){
			JOptionPane.showMessageDialog(null, "赛事添加成功");
		}
			
		
			
	}
}
