package com.Karse.event.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Karse.event.controller.UserController;
import com.Karse.event.dao.impl.UserDaoImpl;
import com.Karse.event.entity.User;
import com.Karse.event.util.*;

import javax.imageio.spi.RegisterableService;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField PasswordTxt;
	
	private static UserController userController = new UserController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setBackground(Color.WHITE);
		setTitle("\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 509);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLol = new JLabel("LOL\u9009\u7968\u7CFB\u7EDF");
		lblLol.setIcon(new ImageIcon("C:\\Users\\Karse\\Pictures\\Camera Roll\\LOL.jpg"));
		lblLol.setFont(new Font("微软雅黑", Font.PLAIN, 44));
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setIcon(new ImageIcon("C:\\Users\\Karse\\Pictures\\Camera Roll\\\u7528\u6237\u540D.png"));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u5BC6 \u7801\uFF1A");
		label_1.setIcon(new ImageIcon("C:\\Users\\Karse\\Pictures\\Camera Roll\\\u5BC6\u7801.png"));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		userNameTxt = new JTextField();
		userNameTxt.setBackground(Color.WHITE);
		userNameTxt.setColumns(10);
		
		PasswordTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Karse\\Pictures\\Camera Roll\\\u767B\u5F55.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//增加登录监听，创建登录方法
				LoginActionPerformed (e);
				
			}
		});
		
		JButton button = new JButton("\u6CE8\u518C");
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//增加注册监听，创建注册方法
				registerActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\Karse\\Pictures\\Camera Roll\\\u6CE8\u518C.png"));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Karse\\Pictures\\Camera Roll\\\u8FD4\u56DE.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(216)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1)
								.addComponent(btnNewButton))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(PasswordTxt, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
										.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
									.addGap(16))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(45)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(button)
							.addGap(56))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(142)
							.addComponent(lblLol, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(184, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(lblLol, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(PasswordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(70))
		);
		contentPane.setLayout(gl_contentPane);
	}

	
	protected void resetValueActionPerformed(ActionEvent e) {
		// 重置事件处理
		this.userNameTxt.setText("");
		this.PasswordTxt.setText("");
		
	}
	

	public void LoginActionPerformed(ActionEvent e) {
		String userName = this.userNameTxt.getText();
		String password = this.PasswordTxt.getText();

		User user = userController.login(userName, password);
		
		if(user != null){
			new MainFrm().IntoMainFrm();
		}else if(isEmpty.isEmpty(userName)){
			//用户名输入为空
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;  //结束
		}else if(isEmpty.isEmpty(password)){
			//密码输入为空
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;	
		}		
			
		
//		else if(new UserDaoImpl().isNameEmpty(userName) && new UserDaoImpl().isPasswordEmpty(password)){
//			//判断是否为管理员
//			if(!new UserDaoImpl().adminNameEmpty(userName)){
//				//调用创建主界面类MainFrm的方法
//				new MainFrm().IntoMainFrm();
//				return;
//			}
//			else {
//				//调用创建管理员主界面AdminMainFrm的方法
//				new AdminMainFrm().IntoAdminMainFrm();
//			}
//		}
//			}

	}	

	protected void registerActionPerformed(ActionEvent e) {
		// 调用创建注册界面类RegisterFrm的方法
		new RegisterFrm().IntoRegisterFrm();	
		
	}
}
