package com.Karse.event.entity;
/**
 * �û���Ϣ
 * @author Karse
 *
 */
public class UserInfo {
	public int id;  //���
	public String name;   //�û�����
	public int age;   //����
	public enum sex{  //�Ա�
		��,Ů
	}
	public double account;  //�˻����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getAccount() {
		return account;
	}
	public void setAccount(double account) {
		this.account = account;
	}
}
