package com.Karse.event.entity;
/**
 * 用户信息
 * @author Karse
 *
 */
public class UserInfo {
	private int id;  //编号
	private String name;   //用户姓名
	private int age;   //年龄
	private int sex;
	private double account;  //账户余额
	
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
