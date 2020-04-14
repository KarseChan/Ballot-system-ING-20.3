package com.Karse.event.entity;
/**
 * 用户信息
 * @author Karse
 *
 */
public class UserInfo {
	public int id;  //编号
	public String name;   //用户姓名
	public int age;   //年龄
	public enum sex{  //性别
		男,女
	}
	public double account;  //账户余额
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
