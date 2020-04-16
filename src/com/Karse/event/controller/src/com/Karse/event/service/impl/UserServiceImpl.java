package com.Karse.event.service.impl;

import com.Karse.event.dao.UserDao;
import com.Karse.event.dao.impl.UserDaoImpl;
import com.Karse.event.entity.User;
import com.Karse.event.service.UserService;

/**
 * 
 * @author Karse
 *
 */
public class UserServiceImpl implements UserService{
	
	private static UserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(String userName, String password) {
		if(userName == null || password == null){
			System.out.println("请求参数有误");
		}
		//。。
		//从数据库中查找记录是否唯一
		User user = userDao.selectUserByPassword(userName, password);
		return user;
	}
	
	@Override
	public boolean register(String userName) {
		if(userName == null){
			System.out.println("请求参数有误");
		}
				
		boolean isNameEmpty = userDao.isNameEmpty(userName);
		return isNameEmpty;
	}
	
	@Override
	public boolean successRegister(String userName, String password) {
		if(userName == null || password == null){
			System.out.println("请求参数有误");
		}
		
		boolean successRegister = userDao.addUser(userName,password);
		return successRegister;
	}	
}
