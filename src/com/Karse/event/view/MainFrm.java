package com.Karse.event.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import java.awt.Color;

public class MainFrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrm frame = new MainFrm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	

	/**
	 * Create the frame.
	 */
	public MainFrm() {
		setTitle("LOL\u9009\u7968\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u6211\u7684");
		menu.setIcon(new ImageIcon("C:\\Users\\Karse\\Pictures\\Camera Roll\\\u6211\u7684.png"));
		menuBar.add(menu);
		
		JMenu menu_1 = new JMenu("\u4E2A\u4EBA");
		menu.add(menu_1);
		
		JMenuItem menuItem = new JMenuItem("\u6211\u7684\u4FE1\u606F");
		menu_1.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u6211\u7684\u8D26\u6237");
		menu_1.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u6211\u7684\u8BA2\u5355");
		menu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u9000\u51FA");
		menu.add(menuItem_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u8D5B\u4E8B");
		menuBar.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		//设置最大化
//		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public void IntoMainFrm(){
		/**
		 * 登录界面调用此方法进入主界面
		 */
		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				MainFrm frame = new MainFrm();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	}
}
