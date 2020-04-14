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
 * ��¼����,�����˺�����ɹ�ʱ������һ����
 * @author Karse
 *
 */
public class LoginFrm {

	public static void main(String[] args) {
		//���������У�ʵ����LoginFrm��Ķ��󣬵��ó�ʼ������ķ���
		LoginFrm loginfrm = new LoginFrm();
		loginfrm.initUI();
	}
	
	
	//�����ж����ʼ������ķ���
	public void initUI(){
		JFrame frame = new JFrame();
		//���ô������ı��⡢��С����ʾλ�á��رղ��������֡���ֹ������С
		frame.setTitle("LOLѡƱϵͳ");
		frame.setSize(400, 650); //���ô����С
		frame.setDefaultCloseOperation(3); //���ô���Ĺرղ�����3��ʾ�رմ����˳�����
		frame.setLocationRelativeTo(null); //����λ��Ĭ�Ͼ���
		frame.setResizable(false);  //���ý�ֹ�������ڴ�С
		
		//ʵ����FlowLayout��ʽ���������ָ�����뷽ʽΪ���ж��룬���֮��ļ��Ϊ5������
		FlowLayout f1 = new FlowLayout(FlowLayout.CENTER,10,10);
		//ʵ������ʽ������Ķ���
		frame.setLayout(f1);
		
		//ʵ����Ԫ��������󣬽�Ԫ�����������ӵ�������
		//ʵ����ImageIconͼ����Ķ���
		ImageIcon icon = new ImageIcon("C:/Users/Karse/Pictures/Camera Roll/lplͼ��2.jpg");
		//�ñ�ǩ����ͼƬ
		JLabel labIcon = new JLabel(icon);
		//���ñ�ǩ��С
		Dimension dim = new Dimension(400,300);
		labIcon.setPreferredSize(dim);
		//��labIcon��ǩ��ӵ�������
		frame.add(labIcon);
		
		//ʵ����JLabel��ǩ���󣬸ö�����ʾ���˺ţ���
		JLabel labName = new JLabel("�˺ţ�");
		//��LabName��ӵ�����
		frame.add(labName);
		
		//ʵ����JTextField��ǩ����
		JTextField textname = new JTextField();
		Dimension dim1 = new Dimension(300,30);
		textname.setPreferredSize(dim1);
		frame.add(textname);
		
		//ʵ����JLabel��ǩ���󣬸ö�����ʾ���˺ţ���
		JLabel labpass= new JLabel("���룺");
		frame.add(labpass);
		
		//ʵ����JPasswordField��ǩ����
		JPasswordField textword=new JPasswordField();
		textword.setPreferredSize(dim1); //���������С
		frame.add(textword);
		
		//ʵ����JButton���
		JButton button=new JButton();
		Dimension dim2 = new Dimension(100,30);
		button.setText("��¼");
		button.setSize(dim2);
		frame.add(button);
		frame.setVisible(true);  //���ô���Ϊ�ɼ�
		
		
		//���Ӱ�ť�����������¼��
		button.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�õ���Ӧ���ݿ���select����User����
				User u = new UserDaoImpl().login(textname.getText(), textword.getText());
				//����get��������ȡ�˺ź����������ı���Ϣ������equal���������ж�
				if(textname.getText().equals(u.name)&& textword.getText().equals(u.password)){
					
					//��������ʱ������һ���µĽ���
					javax.swing.JFrame jf = new javax.swing.JFrame();
					jf.setSize(340, 500);
					jf.setTitle("LOLѡƱϵͳ");
					jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					jf.setLocationRelativeTo(null); //����
					jf.setResizable(false);
					jf.setVisible(true);
					
					// ͨ�����ǻ�ȡ�ĵ�¼���������dispose�����ر���
					frame.dispose();
					
				}
			}	
		});
		
//		//���Ӽ��̼�����enter��¼
//		frame.addKeyListener(new KeyListener() {
//			
//			//�õ���Ӧ���ݿ���select����User����
//			User u = new UserDaoImpl().login(textname.getText(), textword.getText());
//			
//			//��������
//			@Override
//			public void keyTyped(KeyEvent e) {			
//			}
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// 10������"enter"
//				if(e.getKeyCode() ==13){
//					
//					//��������ʱ������һ���µĽ���
//					javax.swing.JFrame jf = new javax.swing.JFrame();
//					jf.setSize(340, 500);
//					jf.setTitle("LOLѡƱϵͳ");
//					jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//					jf.setLocationRelativeTo(null); //����
//					jf.setResizable(false);
//					jf.setVisible(true);
//					
//					// ͨ�����ǻ�ȡ�ĵ�¼���������dispose�����ر���
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
