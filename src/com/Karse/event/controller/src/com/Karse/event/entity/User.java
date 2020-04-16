package com.Karse.event.entity;

import java.util.ArrayList;
import java.util.List;
/**
 * 用户实体
 * @author Karse
 *
 */
public class User {
	private int id;  //编号
	private String name;  //账号名
	private String password; //密码
	private int role; //权限
	
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
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	


}
