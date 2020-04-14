package com.Karse.event.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.Karse.event.dao.impl.UserDaoImpl;
import com.Karse.event.entity.User;
/**
 * 登录界面,输入账号密码成功时跳到另一界面
 * @author Karse
 *
 */
public class LoginFrm {

	public static void main(String[] args) {
		//在主函数中，实例化LoginFrm类的对象，调用初始化界面的方法
		LoginFrm loginfrm = new LoginFrm();
		loginfrm.initUI();
	}
	
	
	//在类中定义初始化界面的方法
	public void initUI(){
		JFrame frame = new JFrame();
		//设置窗体对象的标题、大小、显示位置、关闭操作、布局、禁止调整大小
		frame.setTitle("LOL选票系统");
		frame.setSize(400, 650); //设置窗体大小
		frame.setDefaultCloseOperation(3); //设置窗体的关闭操作；3表示关闭窗体退出程序
		frame.setLocationRelativeTo(null); //窗体位置默认居中
		frame.setResizable(false);  //设置禁止调整窗口大小
		
		//实例化FlowLayout流式布局类对象，指定对齐方式为居中对齐，组件之间的间隔为5个像素
		FlowLayout f1 = new FlowLayout(FlowLayout.CENTER,10,10);
		//实例化流式布局类的对象
		frame.setLayout(f1);
		
		//实例化元素组件对象，将元素组件对象添加到窗体上
		//实例化ImageIcon图标类的对象
		ImageIcon icon = new ImageIcon("C:/Users/Karse/Pictures/Camera Roll/lpl图标2.jpg");
		//用标签接收图片
		JLabel labIcon = new JLabel(icon);
		//设置标签大小
		Dimension dim = new Dimension(400,300);
		labIcon.setPreferredSize(dim);
		//将labIcon标签添加到窗体上
		frame.add(labIcon);
		
		//实例化JLabel标签对象，该对象显示“账号：”
		JLabel labName = new JLabel("账号：");
		//将LabName添加到窗体
		frame.add(labName);
		
		//实例化JTextField标签对象
		JTextField textname = new JTextField();
		Dimension dim1 = new Dimension(300,30);
		textname.setPreferredSize(dim1);
		frame.add(textname);
		
		//实例化JLabel标签对象，该对象显示“账号：”
		JLabel labpass= new JLabel("密码：");
		frame.add(labpass);
		
		//实例化JPasswordField标签对象
		JPasswordField textword=new JPasswordField();
		textword.setPreferredSize(dim1); //设置组件大小
		frame.add(textword);
		
		//实例化JButton组件
		JButton button=new JButton();
		Dimension dim2 = new Dimension(100,30);
		button.setText("登录");
		button.setSize(dim2);
		frame.add(button);
		frame.setVisible(true);  //设置窗体为可见
		
		
		//增加按钮监听（点击登录）
		button.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//得到对应数据库里select到的User对象
				User u = new UserDaoImpl().login(textname.getText(), textword.getText());
				//利用get方法来获取账号和密码对象的文本信息，并用equal方法进行判断
				if(textname.getText().equals(u.name)&& textword.getText().equals(u.password)){
					
					//满足条件时，生成一个新的界面
					javax.swing.JFrame jf = new javax.swing.JFrame();
					jf.setSize(340, 500);
					jf.setTitle("LOL选票系统");
					jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					jf.setLocationRelativeTo(null); //居中
					jf.setResizable(false);
					jf.setVisible(true);
					
					// 通过我们获取的登录界面对象，用dispose方法关闭它
					frame.dispose();
					
				}
			}	
		});
		
//		//增加键盘监听，enter登录
//		frame.addKeyListener(new KeyListener() {
//			
//			//得到对应数据库里select到的User对象
//			User u = new UserDaoImpl().login(textname.getText(), textword.getText());
//			
//			//键被弹起
//			@Override
//			public void keyTyped(KeyEvent e) {			
//			}
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// 10代表按下"enter"
//				if(e.getKeyCode() ==13){
//					
//					//满足条件时，生成一个新的界面
//					javax.swing.JFrame jf = new javax.swing.JFrame();
//					jf.setSize(340, 500);
//					jf.setTitle("LOL选票系统");
//					jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//					jf.setLocationRelativeTo(null); //居中
//					jf.setResizable(false);
//					jf.setVisible(true);
//					
//					// 通过我们获取的登录界面对象，用dispose方法关闭它
//					frame.dispose();
//				}
//				
//			}
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});

		
	}	
	
}
