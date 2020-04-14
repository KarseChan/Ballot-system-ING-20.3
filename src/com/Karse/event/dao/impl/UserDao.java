package com.Karse.event.dao.impl;

import com.Karse.event.entity.User;

public interface UserDao {
	
	User login(String name,String password);
}
