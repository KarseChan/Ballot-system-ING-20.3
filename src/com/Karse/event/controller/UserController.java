package com.Karse.event.controller;
import com.Karse.event.entity.User;
import com.Karse.event.service.UserService;
import com.Karse.event.service.impl.UserServiceImpl;;
/**
 * 
 * @author Karse
 *
 */
public class UserController {
	
	private static UserService userService = new UserServiceImpl();
	
	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 */
	public User login(String userName,String password){
		User user = userService.login( userName, password);
		if(user != null){
			return user;
		}else{
			System.out.println("传回来的用户为空");
			return null;
		}
	}
	
	/**
	 * 用户注册(判断是否有该用户）
	 * @param userName
	 * @return
	 */
	public boolean register(String userName){
		boolean isNameEmpty = userService.register(userName);
		return isNameEmpty;
		
	}
	
	/**
	 * 成功注册
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean successRegister(String userName,String password){
		boolean successRegister = userService.successRegister(userName,password);
		return successRegister;
	}
}
