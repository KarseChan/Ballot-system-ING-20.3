[TOC]

### 异常

- Error：JVM系统内部错误，资源耗尽等严重情况

- Exception：其他因编程错误或偶然的外在因素导致的一般性问题（分母不为0，对象不为空，数组不越界）

#### 异常的处理：捕获

![image-20200404113831916](C:\Users\Karse\AppData\Roaming\Typora\typora-user-images\image-20200404113831916.png)

```java
public class Test {
	public static void main(String[] args) {
		Teacher t = null;
		String[] strs = new String[]{"a","b"};
		
		try{       //可能出现异常的代码 
			System.out.println(t.age);    //对象为空
			System.out.println(strs[2]);  //数组越界
		}catch(NullPointerException e){      //所有异常的父类Exception
			e.printStackTrace();    //追踪异常位置（堆栈的内容）
			System.out.println(e.getMessage());  //输出异常类型
		}catch(ArrayIndexOutOfBoundsException e1){
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}finally {   //finally可写可不写，代码一定执行
			System.out.println(6);
		}
		
	}
}
```

有多异常捕获catch时，如果前面代码出现异常，就不会执行后面的

#### 遇到异常不打算处理：抛出throws/throw

throws用于方法声明时,   throw用于方法内部

人工抛出异常

```java
/**
 * 人工抛出异常
 * @author Karse
 *
 */
public class Test{
	int age;
	public void getAge(int age) throws Exception{  //方法声明用throws
		if(age>=0 && age<=150){
			this.age = age;
			System.out.println("输入的年龄为"+this.age);
		}
		else{
			throw new Exception("输入的年龄应该为0-150");  //方法内部用throw
		}
	}
	
	
	public static void main(String[] args) {
		Test t = new Test();
		try{                           //处理抛出的异常 
			t.getAge(20);
		}catch(Exception e){ 
			e.printStackTrace();       //输出异常路径
		}
	}
}	
```

#### 自定义异常类

```java
public class Test{
	int age;
	public void getAge1(int age) throws Exception{  //方法声明用throws
		if(age>=0 && age<=150){
			this.age = age;
			System.out.println("输入的年龄为"+this.age);
		}
		else{
			throw new Exception("输入的年龄应该为0-150");  //方法内部用throw
		}
	}
	
	public void getAge2(int age) throws MyException{  //方法声明用throws
		if(age>=0 && age<=150){
			this.age = age;
			System.out.println("输入的年龄为"+this.age);
		}
		else{
			throw new MyException("输入的年龄应该为0-150");  //方法内部用throw
		}
	}
	
	
	public static void main(String[] args) {
		Test t = new Test();
		try{                           //处理抛出的异常 
			t.getAge2(-2);   //这里异常了，下面getAge1就不运行了
			t.getAge1(-1);
		}catch(Exception e){ 
			e.printStackTrace();       //输出异常路径
		}
	}
}	

class MyException extends Exception{  //自定义异常类继承父类Exception
	public MyException(String msg){  //构造方法
		super(msg);
	}
	
}
```

java提供的异常的类一般是够用的，只有特殊情况可能需要自己编写异常类，但这种情况很少见



### 集合（用来存放对象的容器）

- 若存放基本类型，则自动转换成对于引用类型

如存入int型数据1，则自动转换成Integer类后存入

- 集合可以存放不同类型、不限数量的数据类型
- 集合存放的是多个对象的引用，对象本身还是存放在堆内存中

#### Java集合可分为Set、List、Map

- Set: 无序，不可重复的集合
- List: 有序，可重复的集合
- Map：具体映射关系的集合



![image-20200404154217925](C:\Users\Karse\AppData\Roaming\Typora\typora-user-images\image-20200404154217925.png)

不保证排列顺序：存在set集合哪个位置由hashcode决定

不可重复：hashcode不相同

![image-20200404154712719](C:\Users\Karse\AppData\Roaming\Typora\typora-user-images\image-20200404154712719.png)

HashSet类中的方法最终都来自于Collection

```java
import java.util.Set;     //导入Set 和 HashSet包
import java.util.HashSet;
import java.util.Iterator; //导入Iterator迭代器

public class TestSet {
	public static void main(String[] args) {
		Set set = new HashSet();   //面向接口，向上传入
		set.add(1);                //add：增加元素
		set.add(2);
		set.add(3);
		set.add(3);      //已存入了3，不会再次存入
		set.add(null);    //可以存入空
		set.add("a");
		set.remove("a");             //remove：删除元素
		System.out.println(set);
		
		Iterator it = set.iterator();   //运用迭代器(需要导入)，遍历输出集合
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		for(Object o : set){      //for each迭代输出集合，set的每个值取出来，赋给o，直到循环集合的所有值
			 System.out.println(o);
		}
		
		System.out.println("一共有"+set.size()+"个元素");  //输出集合的元素个数
	}
}
```

推荐使用for each 迭代输出



#### 泛型（规定集合存入的对象类型）

```java
import java.util.Set;   
import java.util.HashSet;

public class Test1 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		//泛型： Set< >
		set.add("1");
		//set.add(1) 会报错
	}
}
```



#### TreeSet

![image-20200404165041685](C:\Users\Karse\AppData\Roaming\Typora\typora-user-images\image-20200404165041685.png)

- 排序方式: 自然排序和定制排序

自然排序：能按数据大小自动排序，前提：数据类型要一样（用泛型定义）

```java
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();  //TreeSet要泛型定义输入类型
		set.add(2);
		set.add(6);
		set.add(4);
		System.out.println(set);
		
		Iterator<Integer> i = set.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		for(Object o : set){
			System.out.println(o);
		}
	}
}
```



#### List接口， 实现类ArrayList

![image-20200405150000969](C:\Users\Karse\AppData\Roaming\Typora\typora-user-images\image-20200405150000969.png)

```java
import java.util.List;
import java.util.ArrayList;

public class TestList {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		list1.add("a");
		list1.add("a");
		list1.add(1,"b");
		System.out.println(list1);
		System.out.println(list1.get(1));  //get得到该索引位置的数据
		
		List<String> list2 = new ArrayList<String>();
		list2.add("aa");
		list1.addAll(2,list2);    //在索引为2的位置增添一个集合
		System.out.println(list1);
		
		System.out.println(list1.indexOf("a")); //获取指定元素在集合中第一次出现的索引下标
		System.out.println(list1.lastIndexOf("a")); //获取指定元素在集合中最后一次出现的索引下标
		
		list1.remove(1); //移除指定索引下标的元素
		list1.set(1, "b"); //根据索引下标修改元素
	}
		
```

![image-20200405153529394](C:\Users\Karse\AppData\Roaming\Typora\typora-user-images\image-20200405153529394.png)



#### Map接口 ,实现类（HashMap

![image-20200405153934989](C:\Users\Karse\AppData\Roaming\Typora\typora-user-images\image-20200405153934989.png)

- key值不能重复，且Key对应唯一的一个value

```java
public class TestMap {
	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		
		map.put(1, "a");    //增添用put
		map.put(2, "b");
		map.put(3, "c");
		System.out.println(map);
		
		System.out.println(map.get(2));  //得到key值对应的数据
		
		map.remove(3);
		System.out.println(map);  //移除
		
		System.out.println(map.size());  //大小
		
		System.out.println(map.containsKey(2)); //判断集合是否有这个key值
		System.out.println(map.containsValue("d")); //判断集合是否有这个value值
		
		Set<Integer> keys = map.keySet();  //map.keySet()返回Key组成的集合
		for(Integer k : keys){
			System.out.println("key: "+k+",value: "+map.get(k));  //map.get(k)，k对应的value值
		}
	}
}
```

![image-20200405161607035](C:\Users\Karse\AppData\Roaming\Typora\typora-user-images\image-20200405161607035.png)

![image-20200405161725637](C:\Users\Karse\AppData\Roaming\Typora\typora-user-images\image-20200405161725637.png)

TreeMap 可以让Key按大小排序



#### Collections工具类

![image-20200405181715173](C:\Users\Karse\AppData\Roaming\Typora\typora-user-images\image-20200405181715173.png)

![image-20200405181914449](C:\Users\Karse\AppData\Roaming\Typora\typora-user-images\image-20200405181914449.png)



### IO （input output)

java.io.File (计算机操作系统中的文件和文件夹)

流：比如通过程序将一个图片放进文件夹，图片会转化成以恶搞数据集一点一点传到文件夹，这个传递过程类似水的流动

IO原理及流的分类

- 文件流（File开头，基于文件的操作）
- 缓冲流（基于内存的操作） 

![image-20200405183933924](C:\Users\Karse\AppData\Roaming\Typora\typora-user-images\image-20200405183933924.png)

![image-20200405184756409](C:\Users\Karse\AppData\Roaming\Typora\typora-user-images\image-20200405184756409.png)

- file类只能操作文件本身，但不能操作文件里的内容

 

```java
import java.io.File;

public class TestFile {
	public static void main(String[] args) {
		File f = new File("D:\\shandiao.txt"); //一个/表示转义，两个才表示\
		System.out.println(f.getName());       //获取文件名
		System.out.println(f.getPath());       //获取相对路径
		System.out.println(f.getAbsolutePath()); //获取绝对路径
		f.renameTo(new File("D:\\ witcher3.txt"));  //改名字
		File f1 = new File("D:\\ witcher3.txt");
		System.out.println(f.exists());    //判断是否存在，不存在
		System.out.println(f1.exists());   //存在
		System.out.println(f1.canRead());  //是否可读
		System.out.println(f1.canWrite()); //是否可写
		System.out.println(f1.isFile());   //是否为文件
		System.out.println(f1.isDirectory());  //是否为文件夹
		System.out.println(f1.lastModified());  //获取文件最后修改时间
		 
	}
}
```

#### 创建文件

```java
import java.io.File;
import java.io.IOException;

public class TestFile {
	public static void main(String[] args) {
		File f2 = new File("D:\\ create.txt");
		if(!f2.exileists()){    //文件不存在才可以创建
			try {            //需要捕获异常
				f2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			System.out.println("该文件已存在");
		}
	}
}

```

#### 创建目录

```java
File f2 = new File("D:\\ 自创目录");
f2.mkdir();  //创建单层目录，若要创建多层就得一层一层mkdir
```

#### 输出文件目录名字

```java
File f4 = new File("D:\\");
String[] list = f4.list(); //list返回当前文件夹的子集的file对象，包括目录和文件
for(String l : list){  
	System.out.print(l);
}
```

#### IO步骤

1. 创建源（File)
2. 选择流  ( )
3. 操作
4. 释放

#### 标准步骤

```java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestFileInputStrem {
	public static void main(String[] args) {
		File src= new File("D:/shandiao/create.txt");
		InputStream is = null;
		
		try {
			is = new FileInputStream(src);
			byte[] b = new byte[10];  //缓冲容器
			int len = 0;   //接受长度
			while((len = is.read(b))!=-1){    //读入缓冲容器，返回接收长度
				System.out.println(new String(b,0,len));  //第一个参数为缓冲容器，第二个参数为从数组的第几开始读，第三个参数为接收长度
			}                                      //public String(byte[] bytes,int index,int length) 把字节数组的一部分转成字符			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
```

#### 文件字节输出流

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestOutputStream {
	public static void main(String[] args) {
		
		
		try {
			OutputStream os = null;
			os = new FileOutputStream("D:/shandiao/create.txt"); //指定文件输出
			String str = "witcher3";     //要输入的内容
			os.write(str.getBytes());  //由于write里要用byte型，则将string用getbyte转换
			os.flush(); //把内存中的数据刷写到硬盘
			os.close();

		} catch (Exception e){ 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
```

#### 文件复制

 

```java
public class InAndOut {
	public static void main(String[] args) {
		InAndOut test = new InAndOut();
		test.copy("D:/shandiao/create.txt","D:/shandiao/witcher3.txt");
	}
	
	
	public void copy(String input,String output){  //定义复制方法
		try {  
			FileInputStream is = new FileInputStream(input);  //文件字节输入流
			FileOutputStream os = new FileOutputStream(output);  //文件字节输出流
			
			byte[] b = new byte[100];  //缓冲容器
			int len = 0;          //接收长度
			while((len = is.read(b)) != -1){  //将内容读入缓冲容器
				os.write(b,0,len);    //将缓冲容器的内容输出
			}
			os.flush();    //把写到内存的数据刷到硬盘
			
			is.close();   //释放输入流
			os.close();   //释放输出流
			
		} catch (Exception e) {
			e.printStackTrace();
		}					
	}
	
}
```

文件字节流非常通用，可以用来操作字符的文档，还可以操作任何的其他类型文件（如图片，压缩包）

#### 文件字符流

像txt文件或文档里的内容都是字符，就适合用字符流

```java
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
/**
 * 文件字符流（和字节流类似）
 * @author Karse
 *
 */
public class FileReadAndWrite {
	public static void main(String[] args) {
		FileReadAndWrite fraw = new FileReadAndWrite();
		fraw.copyFile("D:/shandiao/create.txt","D:/shandiao/witcher3.txt");
		
	}
	
	public void copyFile(String in,String out){
		
		try {
			FileReader fr = new FileReader(in);
			FileWriter fw = new FileWriter(out);
			
			char[] c = new char[100];  //字符流缓冲容器为字符数组
			int len = 0;
			
			while((len = fr.read(c)) != -1){
				fw.write(c, 0, len);
			}
			fw.flush();
			fw.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
```

- 在读取文件时，必须保证文件已存在，否则出异常
- 在写入一个文件，如果目录下有同名文件将被覆盖



文件字节流：FileInputSream    FileOutputSream 

文件字符流：FileReader     FileWriter

这些都时计算机与硬盘之间发生的io操作，基于硬盘的读写相对时比较慢的，这个操作受到硬盘读写速度的制约，为了能提高读写速度，一定程度绕过硬盘的仙志，java提供了一种缓冲流来实现

#### 缓冲流

先把数据缓冲内存里，在内存中去做io操作，基于内存的io操作大概能比基于硬盘的io操作快7.5w多倍

```java
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 缓冲字节流实现文件复制
 * @author Karse
 *
 */
public class Buffered {
	public static void main(String[] args) {
		try {    //处理异常
			new Buffered().copy("D:/shandiao/create.txt","D:/shandiao/witcher3.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void copy(String in ,String out) throws Exception{  //可以先把异常抛出去
		FileInputStream is = new FileInputStream(in);
		FileOutputStream os = new FileOutputStream(out);
		
		BufferedInputStream br = new BufferedInputStream(is);  //缓冲字节输入流 读入文件字节输入流
		BufferedOutputStream bw = new BufferedOutputStream(os);//缓冲字节输出流 读入文件字节输出流
		
		byte[] b = new byte[100];
		int len = 0;
		while((len = br.read(b)) != -1){
			bw.write(b, 0, len);
		}
		bw.flush();   //将内存的数据刷到硬盘
		bw.close();   //实现缓冲流要将最晚开的流最早关，其他依次关闭
		br.close();
		os.close();
		is.close();
	}
}
```

- 缓冲流读入文件流
- 最晚开的流最早关，其他依次关闭

同理缓冲字符流也一样，这里就不写了



#### 转换流（InputStreamReader）

提供了字节流和字符流之间的转换，若字节流中的数据都是字符时，转换成字符流操作更高效，转换时要将字节流中读取到的字节按字符集解码成字符。这里就涉及到编码

##### 编码

所有文件都有编码格式，对我们来说txt,java文件一般有3中编码格式

- ISO8859-1  ，西欧编码，是纯粹英文编码，不适应汉字
- GBK  ，适用于中文和英文
- UTF-8  ，适用于中文和英文

我们一般用UTF-8编码

```java
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 转换流
 * @author Karse
 *
 */
public class TestInputStreamReader {
	public static void main(String[] args) {
		try {
			new TestInputStreamReader().change("D:/project/demo/src/io/test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void change(String in) throws Exception{
		FileInputStream is = new FileInputStream(in);
		InputStreamReader isr = new InputStreamReader(is,"GBK"); //第一参数为字节流对象，第二参数为编码
     //设置的字符集编码要与文件数据的编码相同，如这里读取的文件编码是GBK的，则UTF-8编码不出来
		
		char[] b = new char[1024];
		int len = 0;
		while((len = isr.read(b)) != -1){
			System.out.println(new String(b,0,len));
		}
		
		isr.close();
		is.close();
	}
}
```



### 标准输入输出流

标准输入流: 输入到控制台上

标准输出流：输出到控制台上，就是sysout

```java
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 标准输入输出流
 * 控制台输入，并输出输入的内容
 * @author Karse
 *
 */
public class SystemIn {
	public static void main(String[] args) {
		try {
			new SystemIn().systemIn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void systemIn() throws Exception{
		//控制台输入用System.in,默认为字节流，要转换成字符流输入
		InputStream in = System.in;   
		
		//转换成字符流输入
		InputStreamReader isr = new InputStreamReader(in); 
		
		//把输入流放进缓冲流
		BufferedReader bf = new BufferedReader(isr);
		
		String str = "";   //定义一个临时接收数据的字符串
		
		while((str = bf.readLine()) != null){   //readline返回字符串，若后面没有字符则返回null
			System.out.println(str);
		}
		isr.close();
		in.close();
		
	}
}
```

