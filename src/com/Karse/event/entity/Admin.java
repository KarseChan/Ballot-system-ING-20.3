package com.Karse.event.entity;
/**
 * 管理员账号数据
 * @author Karse
 *
 */
public class Admin {
	public int id;  //编号
	public String name;  //账号名
	public String password; //密码
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
