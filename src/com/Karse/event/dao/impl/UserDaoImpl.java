package com.Karse.event.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.Karse.event.dao.UserDao;
import com.Karse.event.entity.User;
import com.Karse.event.util.isEmpty;
import com.jgoodies.forms.factories.Borders.EmptyBorder;
/**
 * 封装jdbc用户账号信息增删改查数据库的方法
 * @author Karse
 *
 */


public class UserDaoImpl implements UserDao{
	//注册驱动放在构造方法里，因为只需执行一次
	public UserDaoImpl(){
		//注册驱动

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	
	public Connection getConnection() throws SQLException{
		/**
		 * 得到连接接口的方法
		 */
		//资源配置器
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");
		
		Connection conn = DriverManager.getConnection(url,user,password);
		return conn;
	}
	
	
	/**
	 * 登陆方法
	 * @param Username 用户名
	 * @param password 密码
	 */

	
	@Override
	public User selectUserByPassword(String name, String password) {
		User resultUser = null; //用于返回
		String sql = "select * from t_user where name=? and password=?";
		try(Connection conn = getConnection() ;PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			//判断是否有有数据
			if(rs.next()){
				resultUser = new User();
				resultUser.setId(rs.getInt("id"));
				resultUser.setName(rs.getString("name"));;
				resultUser.setPassword(rs.getString("password"));;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultUser;
	}
	
	
	public boolean adminNameEmpty(String name){
		boolean flag = true;  //扩展作用域
		String sql = "select * from t_admin where name=? ";
		try(Connection conn = getConnection() ;PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			//判断数据库是否有该账号
			if(rs.next()){
				flag = true; 				
			}
			else{
				//返回false
				flag = false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}
	
	/**
	 * 注册账号查询是否存在该用户
	 * @param name
	 * @return
	 */
	public boolean isNameEmpty(String name) {
		/**
		 * 查询t_user表中是否存在该用户名
		 */
		boolean flag = true; 
		String sql = "select * from t_user where name=? ";
		try(Connection conn = getConnection() ;PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			//判断数据库是否有该账号
			if(rs.next()){
				flag = true;
			}else{
				flag = false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
		
	}
	
	
	public boolean isPasswordEmpty(String password) {
		/**
		 * 查询t_user表中是否存在该密码
		 */
		boolean flag = true;  //扩展作用域
		String sql = "select * from t_user where password=? ";
		try(Connection conn = getConnection() ;PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, password);
			ResultSet rs = ps.executeQuery();
			//判断数据库是否有该账号
			if(rs.next()){
				flag = true; 				
			}
			else{
				//返回false
				flag = false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
		
	}
	
	public boolean addUser(String name,String password){
		/**
		 * 将对象信息插入数据库
		 */
		boolean flag = true;
		String sql = "insert into t_user values(null,?,?)";	
		try(Connection conn = getConnection() ;PreparedStatement ps = conn.prepareStatement(sql)) {

			//插入数据
			ps.setString(1, name);
			ps.setString(2,password);
			int count = ps.executeUpdate();
			if(count == 1){
				flag = true;
			}else{
				flag = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;			
	}
	
	
//	public int getTotal(){
//		/**
//		 * 得到数据总数
//		 */
//		int total = 0;
//		String sql = "select * from t_user";
//		try(Connection conn = getConnection();PreparedStatement ps = conn.prepareStatement(sql)) {
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()){
//				total = rs.getInt("id");
//			}
//		} catch (SQLException e) {
//			// TODO: handle exception
//		}
//		return total;
//	}
//	
//	
//	public User get(int id){
//		/**
//		 * 输入id，返回对象
//		 */
//		User u = null;
//		String sql = "select * from t_user where id ="+id;	
//		try(Connection conn = getConnection() ;PreparedStatement ps = conn.prepareStatement(sql)) {
//			//创建数据库对象
//			ResultSet rs = ps.executeQuery();
//			if(rs.next()){
//				//实例化对象
//				u = new User();	 
//				String name = rs.getString("name");
//				int age = rs.getInt("age");
//				String sex = rs.getString("sex");
//				//将数据库的值赋给对象的属性
//				u.name = name;
//				u.age = age;
//				u.sex = sex;
//				
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return u;					
//	}
//	

//	
//	public void delete(User u){
//		/**
//		 * 把这个User对象对应的数据删除掉
//		 */
//		String sql = "delete from t_user where id = "+u.id;
//		try (Connection conn = getConnection() ;Statement stat = conn.createStatement()){
//			
//			//执行sql语句
//			stat.execute(sql);			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//	}
//	
//	public  void update(User u){
//		/**
//		 * 更新这条User对象
//		 */
//		//资源配置器
//		String sql = "update t_user set name=?,age=?,sex=? where id=?";	
//		try(Connection conn = getConnection() ;PreparedStatement ps = conn.prepareStatement(sql)) {
//			//插入数据
//			ps.setString(1, u.name);
//			ps.setInt(2, u.age);
//			ps.setString(3, u.sex);
//			ps.setInt(4, u.id);
//			//执行sql语句
//			ps.execute();
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	
//	public List<User> list(){
//		/**
//		 * 把所有的user数据查询出来，转换为User对象后，放在一个集合中返回
//		 */
//		
//		//扩展作用域
//		List<User> users = null;
//		String sql = "select * from t_user";
//		
//		try(Connection conn = getConnection() ;PreparedStatement ps = conn.prepareStatement(sql)) {
//			
//			User u = new User();
//			users = new ArrayList<User>();
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()){
//				//转换为对象
////				int id = rs.getInt("id");
////				String name = rs.getString("name");
////				int age = rs.getInt("age");
////				String sex =  rs.getString("sex");
////				u. id = id;				
////				u.name = name;
////				u.age = age;
////				u.sex = sex;
////				//将对象放进集合
//				System.out.println(1);
//				users.add(u);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return users;
//	}

}
