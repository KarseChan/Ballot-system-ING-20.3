[TOC]



# JDBC

## 步骤

- 第一步：注册驱动 (告诉java要连接哪个数据库)
- 第二步：获取连接（打开通道）
- 第三步：获取数据库操作对象
- 第四步：执行SQL语句
- 第五步：处理查询结果集（只有当第四步执行的是select语句的时候，才有这第五步处理查询结果集）
- 第六步：释放资源（使用完资源一定要关闭资源，JAVA和数据库属于进程间的通信，开启之后一定要关闭）

## 驱动（Driver)

通过import 外包 Driver类，调用connection方法，返回接口

### url

http://www.baidu.com 就是url

```
String url = "jdbc:mysql://localhost:3306/db_book"; 
//协议，IP地址，端口号，数据库
//jdbc:mysql:协议
//localhost:IP地址
//3306,默认mysql端口号
//db_book，数据库
```

```java
import java.sql.Connection; 
import java.sql.Driver;  //外包
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.jdbc.Statement;

public class ConnectionTest {
	public void testConnection(){
		//为了能在finally下关闭资源，扩展到try,catch外面
		Connection conn = null; 
		Statement stmt = null;
				
		try {
			//1.注册驱动
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);  //不管用哪个数据库都能用
			
			//2.获取连接
			//url : 协议 + IP地址 + 端口号 + 数据库
			String url = "jdbc:mysql://localhost:3306/db_book"; //统一资源定位符，固定的
			String user = "root";
			String password = "123456";		
			
			conn = DriverManager.getConnection(url, user, password);  //调用类的方法，返回接口	
			
			System.out.println("数据库连接对象"+conn);
			
			//3.获取数据库操作对象（statement专门执行sql语句的）
			stmt = (Statement) conn.createStatement();
			
			//4.执行sql
			String sql = "insert into t_book(bookName,price,author,bookType) values('物理',30,'陈老师',2)";
			//专门执行DML语句（inset,delete,update)
			//返回int类型，数字代表“影响数据库中的记录条数”
			int count = stmt.executeUpdate(sql); 
			//insert语句影响了1条记录
			System.out.println(count == 1 ? "保存成功" : "保存失败");
			
			//5.处理查询结果集 ，这里不查询所以不执行
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{  
			//6.处理资源 
			//为了保证资源一定释放，所以放在finally
			//并且遵循从小到大依次关闭
			//分别对其try,catch
			if(stmt != null){   //不等于空才有必要关闭
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
			if(conn != null){    //要分开try，因为第一个异常了，第二个就不执行了
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new ConnectionTest().testConnection();
	}
}


```

```
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
/**
 * 简约版
 * @author Karse
 *
 */
public class JDBCTest03 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		
		try {			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_book","root","123456");
			stat = (Statement) conn.createStatement();		
			String sql = "update t_book set bookName='java编程思想' where id=1";
			int count = stat.executeUpdate(sql);
			System.out.println(count == 1 ? "更新成功":"更新失败");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(stat != null){
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}	
	}
}
```

#### Class类的常用方法

Class forName(String name)    根据类的全类名（包名+类名）获取Class对象

#### 更常用的注册驱动方式

```
//com.mysql.jdbc是包名，Driver是类名
//由于Driver类里的registerDriver注册方法是static的，所以获取Driver对象就执行了static方法，即注册了驱动
Class.forName("com.mysql.jdbc.Driver");
//为什么这种方法更常用，因为参数是一个字符串，字符串可以写到xxx.properties文件中
//以下方法不需要接收返回值，因为我们只想用它的类加载动作。
```

#### 用properties文件绑定资源

**实际开发中不建议把连接数据库的信息写死到Java程序中**

**经过实验，properties文件最好放在bin文件的第一层**

```
ResourceBundle bundl = ResourceBundle.getBundle("jdbc");
//ResourceBundle类，资源绑定
//getBundle方法获取properties文件名jdbc.properties,扩展名.properties可以省略
//driver，url，user，password分别为properties文件里的内容
String driver = bundle.getString("driver");
String url = bundle.getString("url");
String user = bundle.getString("user");
String password = bundle.getString("password");
```

```
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
import java.util.*;

public class JDBCTest04 {
	public static void main(String[] args) {
		//资源配置器
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");
		
		Connection conn = null;
		Statement stat = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			stat = (Statement) conn.createStatement();
			String sql = "update t_book set bookName='水浒传',author='施耐庵' where id=4";
			int count = stat.executeUpdate(sql);
			System.out.println(count ==1 ? "更新成功":"更新失败");
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				if(stat != null){
					try {
						stat.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(conn != null){
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		
	}
}
```



#### 第五步：查询结果集

```
ResultSet rs = null;
//statement stat
//查询结果放在结果集中
rs = stat.executeQuery(sql);
//结果集输出
while(rs.next()){ 
	String id = rs.getString("id");
	。。。。
}
```

```
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.mysql.jdbc.Statement;

public class JDBCTest05 {
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");
		
		Connection conn = null;
//		Statement stat = null;
		//使用PreparedStatement，更安全，防止SQL注入攻击
		PreparedStatement ps = null;  
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
//			stat = (Statement) conn.createStatement();
			
			
			String sql = "select * from t_book";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			
			//next()返回布尔值，并使光标往下移一位，若有数据返回true，无返回false
			while(rs.next()){   
				//getString()不管数据是什么类型，都得到string类型，括号内为查询结果集的列名
				//括号内也可以写列数，从1开始
				//字段名若取别名，则括号内需写该别名
				String id = rs.getString("id");
               //同样也可以 int id = rs.getInt("id");
				String bookName = rs.getString("bookName");
				String price = rs.getString("price");
			   //同样也可以  Double price = rs.getDouble("price");
				String author = rs.getString("author");
				System.out.println("id:"+id+"bookName:"+bookName+"price:"+price+"author:"+author);
			}
			
		} catch (Exception e) {
			e.printStackTrace();					
		} finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
```



#### PreparedStatement如何插入数据

```
PreparedStatement ps = conn.prepareStatement(sql);
//插入数据
ps.setString(1,"西游记");
ps.setString(2,"西游记");
ps.setString(3,"西游记");
```



#### Iterator中hasNext(), next() 和ResultSet结果集的next

专门的迭代输出接口,将元素一个个进行判断,用hasNext() 判断是否有值,用next()方法把元素取出.

ResultSet 对象具有指向其当前数据行的光标.最初,光标被置于第一行之前.next 方法将光标移动到下一行；

所以两者是没有必要比较的,用的地方不一样,只要会熟练应用就够用了.



#### 自动释放资源

```
		try(Connection conn = getConnection();PreparedStatement ps = conn.prepareStatement(sql)) {
		//()内放需要释放的资源
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				total = rs.getInt("id");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return total;
	}
```

