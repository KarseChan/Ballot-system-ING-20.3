package com.Karse.event.entity;

import java.util.ArrayList;
import java.util.List;
/**
 * 用户实体
 * @author Karse
 *
 */
public class User {
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
