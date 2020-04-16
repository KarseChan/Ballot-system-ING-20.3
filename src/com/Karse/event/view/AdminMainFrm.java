package com.Karse.event.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMainFrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainFrm frame = new AdminMainFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void IntoAdminMainFrm(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainFrm frame = new AdminMainFrm();
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
	public AdminMainFrm() {
		setTitle("\u7BA1\u7406\u5458");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u6570\u636E\u7EF4\u62A4");
		menuBar.add(menu);
		
		JMenu menu_1 = new JMenu("\u8D5B\u4E8B\u7BA1\u7406");
		menu.add(menu_1);
		
		JMenuItem menuItem = new JMenuItem("\u8D5B\u4E8B\u6DFB\u52A0");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//赛事添加监听
				addMatchActionPerformed(e);
			}
		});
		menu_1.add(menuItem);
		
		JMenuItem menuItem_2 = new JMenuItem("\u8D5B\u4E8B\u7EF4\u62A4");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//赛事维护监听
				alterActionPerformed(e);
			}
		});
		menu_1.add(menuItem_2);
		
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA");
		menu.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	protected void alterActionPerformed(ActionEvent e) {
		// 赛事维护事件处理
		
		
	}

	protected void addMatchActionPerformed(ActionEvent e) {
		// 赛事添加事件处理
		new MatchAdd().IntoMatchAdd();
		
	}

}
