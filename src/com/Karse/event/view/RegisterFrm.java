package com.Karse.event.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Karse.event.dao.impl.UserDaoImpl;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RegisterFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField; //用户名输入
	private JPasswordField passwordField;  //密码输入
	private JPasswordField passwordField_1;  //确认密码
	private JButton button;
	private JButton button_1;
	private JLabel label_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrm frame = new RegisterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void IntoRegisterFrm(){
		/**
		 * 登录界面调用此方法进入注册界面
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrm frame = new RegisterFrm();
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
	public RegisterFrm() {
		setTitle("\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 509);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u7528\u6237\u6CE8\u518C");
		label.setIcon(new ImageIcon("C:\\Users\\Karse\\Pictures\\Camera Roll\\\u6CE8\u518C2.png"));
		label.setFont(new Font("微软雅黑", Font.BOLD, 30));
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_1.setIcon(new ImageIcon("C:\\Users\\Karse\\Pictures\\Camera Roll\\\u7528\u6237\u540D.png"));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("\u5BC6 \u7801\uFF1A");
		label_2.setIcon(new ImageIcon("C:\\Users\\Karse\\Pictures\\Camera Roll\\\u5BC6\u7801.png"));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_3.setIcon(new ImageIcon("C:\\Users\\Karse\\Pictures\\Camera Roll\\\u5BC6\u7801.png"));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		
		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//增加”成功注册“监听
				SuccessRegisterPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		
		
		//布局
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(310)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(201)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label_1)
										.addComponent(label_3))
									.addGap(37)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
										.addComponent(passwordField, 191, 191, 191)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))))))
					.addGap(304))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(327)
					.addComponent(button)
					.addGap(74)
					.addComponent(button_1)
					.addContainerGap(316, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addComponent(label)
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap(89, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void SuccessRegisterPerformed(ActionEvent e) {
		// 调用UserDaoImpl里的  判断是否存在该用户名方法		
		if(new UserDaoImpl().isNameEmpty(textField.getText()) == true){
		    //该账户存在，则在界面输出”该账户已存在“
			JLabel j1 = new JLabel();
			j1.setText("该用户名已存在！");
			j1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
			j1.setForeground(Color.RED);
			j1.setLocation(435, 290);
			
					
		}
		else if(passwordField.getText().equals(passwordField_1.getText())){
			//判断输入密码和确认密码相同，将用户名密码插入数据库
			new UserDaoImpl().addUser(textField.getText(), passwordField.getText());
			//在界面输出”注册成功“
			JLabel j2 = new JLabel();
			j2.setText("注册成功！");
			j2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
			j2.setForeground(Color.RED);
			j2.setLocation(435, 290);
			
		}
		
	}
}
