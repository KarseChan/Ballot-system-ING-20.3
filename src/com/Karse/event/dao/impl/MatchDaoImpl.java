package com.Karse.event.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.Karse.event.dao.MatchDao;
import com.Karse.event.entity.Match;
import com.mysql.jdbc.StringUtils;

/**
 * 封装对赛事进行增删改查的方法
 * @author Karse
 *
 */

public class MatchDaoImpl implements MatchDao{
	//注册驱动放在构造方法里，因为只需执行一次
	public MatchDaoImpl(){
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
	
	public boolean addMatch(String team1,String team2,String time,String price){
		/**
		 * 将对象信息插入数据库
		 */
		boolean flag = true;
		String sql = "insert into t_match values(null,?,?,?,?)";	
		try(Connection conn = getConnection() ;PreparedStatement ps = conn.prepareStatement(sql)) {
			//插入数据
			ps.setString(1, team1);
			ps.setString(2, team2);
			ps.setString(3, time);
			ps.setString(4, price);
			//执行sql语句
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
	
	
//	public ResultSet list(Connection conn,Match match)throws Exception{
//		/**
//		 * 模糊查询，查询单字查询时间都能得到
//		 */
//		StringBuffer sb = new StringBuffer("salect * from t_match");
//		if(com.Karse.event.util.isEmpty(match.getName()))){
//			sb.append(" and ")
//		}
//		
//	}
}
