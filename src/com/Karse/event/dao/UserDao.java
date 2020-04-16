package com.Karse.event.dao;

import com.Karse.event.controller.UserController;
import com.Karse.event.entity.User;

public interface UserDao {

	
	User selectUserByPassword(String name,String password);
	
	boolean isNameEmpty(String name);
	
	boolean isPasswordEmpty(String password);
	
	boolean addUser(String name,String password);
}
