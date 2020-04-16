package com.Karse.event.service;

import com.Karse.event.entity.User;
/**
 * 
 * @author Karse
 *
 */
public interface UserService {
	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	User login(String userName,String password);
	
	boolean register(String userName);
	
	boolean successRegister(String userName,String password);
}
