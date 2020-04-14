package com.Karse.event.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Karse.event.dao.impl.UserDaoImpl;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
/**
 * 舍弃用RegisterFrm代替
 * @author Karse
 *
 */
public class RegisterFra extends JFrame {

	private JPanel contentPane;
	private JTextField textField;  //用户名输入
	private JPasswordField passwordField;  //密码输入
	private JPasswordField passwordField_1;  //确认密码
	private JButton button;
	private JButton button_1;
	private JLabel label_4;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegisterFra frame = new RegisterFra();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public void IntoRegisterFra(){
		/**
		 * 登录界面调用此方法进入注册界面
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFra frame = new RegisterFra();
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
	public RegisterFra() {
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
		
		button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//增加”成功注册“监听
				SuccessRegisterPerformed(e);
			}
		});
		
		button_1 = new JButton("\u8FD4\u56DE");
		
		
		//布局
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(278)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label_1)
										.addComponent(label_3)
										.addComponent(label_2))
									.addGap(40))
								.addComponent(button))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(passwordField, 193, 193, 193)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
									.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(48)
									.addComponent(button_1))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(317)
							.addComponent(label)))
					.addGap(222))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(398, Short.MAX_VALUE)
					.addComponent(label_4)
					.addGap(373))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addComponent(label)
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(27)
					.addComponent(label_4)
					.addGap(34))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void SuccessRegisterPerformed(ActionEvent e) {
		// 调用UserDaoImpl里的  判断是否存在该用户名方法		
		if(new UserDaoImpl().isNameEmpty(textField.getText()) == true){
			//该账户存在，则在界面输出”该账户已存在“
			
			
		}
		else{
			//该账户不存在，则在界面输出”注册成功“

			new UserDaoImpl().addUser(textField.getText(), passwordField.getText());
		}
				
	}

}