[TOC]



### dos命令

- mysql -uroot -p  回车

输入密码

- mysql > exit    退出
- 显示所有数据库：show databases;
- 对数据进行操作：use  databasesName;
- 显示当前使用的数据库：SELECT DATABASE();
- 创建数据库：create databases;
- 删除数据库：drop databases;
- 查看表的结构：describe   tableName； （desc   tableName)插入值：INSERT tableName VALUES(  );
- 查询表：SELECT * FROM  tableName  ;

1. ​    SELECT    id   FROM  tableName ;  //查询某项数据
2. ​    SELECT  * FROM t_student WHERE id=1;   //查询id为1的数据
3. ​    SELECT  * FROM t_student WHERE age>20;   //查询年龄大于20
4. ​    SELECT  * FROM t_student WHERE age IN (20,23);   //查询年龄为20或23
5.  SELECT  * FROM t_student WHERE age NOT IN (18);  //查询年龄不是18的
6. SELECT  * FROM t_student WHERE age BETWEEN 18 AND 22;/查询年龄为18至22的
7. SELECT  * FROM t_student WHERE age NOT BETWEEN 18 AND 22;   //查询年龄不在18至22的
8. SELECT  * FROM t_student WHERE stuName LIKE '赵_'; //查询赵开头，两个字的名字
9. SELECT  * FROM t_student WHERE stuName LIKE '%王%'; //查询名字包含王的
10. SELECT  * FROM t_student WHERE age  IS NULL; //查询年龄为空
11.  SELECT  * FROM t_student WHERE gradeName="一年级" AND age = 23;  //查询满足年级和年龄
12. SELECT  * FROM t_student WHERE gradeName="一年级" OR age = 23;  //查询满足年级或年龄
13. SELECT  * FROM t_student ORDER BY gradeName; //按年级排序表
14. SELECT  * FROM t_student ORDER BY age ASC; //升序排列
15. SELECT  * FROM t_student ORDER BY age DESC; //降序排列
16. SELECT  gradeName,GROUP_CONCAT(stuName) FROM t_student GROUP BY gradeName;   //以年级为单位，排列名字
17. SELECT  gradeName,COUNT(stuName) FROM t_student GROUP BY gradeName;   //每个年级有多少学生
18. SELECT * FROM t_student LIMIT 0,5;  //分页查询，每页5个，从第0个（不计入）开始
19. 

- 修改表结构![image-20200408161540529](C:\Users\Karse\AppData\Roaming\Typora\typora-user-images\image-20200408161540529.png)
- 删除表：drop   tableName;

### Mysql语句规范

- 关键字与函数名称全部大写
- 数据库名称、表名称、字段名称全部小写
- SQL语句必须以分号结尾



### 数据类型

#### 整型

​                             有符号↓          无符号↓

TINYINT 1字节 (-128，127) (0，255) 小整数值

SMALLINT 2 字节 (-32 768，32 767) (0，65 535) 大整数值

#### 浮点型

FLOAT[(M,D)] :  M是数字总位数，D是小数点后面的位数

#### 字符型

varchar()则是不定长的,没有达到"()"中的上限则会自动去掉后面的空格

#### enum类型和set类型

enum(枚举)指定数据只能取指定范围内的值。enum类型最多可以有65535个成员，但只能从成员中选一个

set最多包含64个成员，但可以选择多个

例：选择性别用enum,选择爱好（可以有多个)用set

#### text类型和blob类型

text类型只能存储字符数据，而blob类型可以存储二进制数据。若要存储文章等纯文字，用text类型。存储图片用blob类型。



### 三大范式

#### 第一范式：所有属性不可再分

#### 第二范式：



### 约束

#### 非空约束(NOT NULL)

#### 主键约束(PRIMARY KEY)

- 每张数据表只能存在一个主键
- 主键保证记录的唯一性
- 主键自动为NOT NULL
- 自增前提：是主键

#### 唯一约束 (UNIQUE KEY)

- 可以保证记录的唯一性
- 唯一约束的字段可以为控制（NULL）
- 每张数据表可以存在多个唯一约束

#### 默认约束 (DEFAULT)

#### 外键约束(FOREIGN KEYp)

- 父表和子表必须使用相同的存储引擎，而且禁止使用临时表
- 数据表的存储引擎只能为InnoDB
- 外键列和参照列必须具有相似的数据类型，其中







### 创建表（dos创建）

表是数据库存储数据的基本单位。一个表包含若干字段或记录

表：TABLE  

```mysql
CREATE TABLE t_bookType2(
	id int primary key auto_increment,
	bookTypeName varchar(20),
	bookTypeDesc varchar(200)
);
```

每次定义后用逗号不用分号，

#### 插入值

```
INSERT INTO 表名 VALUES(值1..值2..  );
```

```
INSERT INTO 表名(属性1..属性2..) VALUES(值1,值2,值3);
```

```
INSERT INTO 表名(属性1..属性2..)
VALUES(值1,值2,值3)
...
(值1,值2,值3);
```



#### 修改表结构

```
alter table t_book rename t_book3;
alter table t_book change bookName bookName2 varchar(20);
alter table t_book add testField int after author;
alter table t_book add testField int first;
```

#### 聚合函数

##### COUNT();

SELECT stuName,COUNT(*) FROM  t_grade GROUP BY stuName;

+---------+----------+
| stuName | COUNT(*) |
+---------+----------+
| 王五    |        2 |
| 絮儿    |        1 |
| 阿强    |        1 |
| 雪儿    |        1 |
+---------+----------+

##### SUM();  （总和）

- SELECT stuName,SUM(score) FROM t_grade WHERE stuName="王五";

+---------+------------+
| stuName | SUM(score) |
+---------+------------+
| 王五    |        183 |
+---------+------------+

- SELECT stuName,SUM(score) FROM t_grade GROUP BY stuName;

+---------+------------+
| stuName | SUM(score) |
+---------+------------+
| 王五    |        183 |
| 絮儿    |         88 |
| 阿强    |         85 |
| 雪儿    |         95 |
+---------+------------+

##### AVG();  (平均)

- SELECT stuName,AVG(score) FROM t_grade WHERE stuName="王五"
- SELECT stuName,AVG(score) FROM t_grade GROUP BY stuName;

##### MAX();

- SELECT stuName,course,MAX(score) FROM t_grade WHERE stuName="王五"
- SELECT stuName,course,MAX(score) FROM t_grade GROUP BY stuName;

+---------+--------+------------+
| stuName | course | MAX(score) |
+---------+--------+------------+
| 王五    | 数学   |         93 |
| 絮儿    | 语文   |         88 |
| 阿强    | 物理   |         85 |
| 雪儿    | 英语   |         95 |
+---------+--------+------------+

#### MIN();

- SELECT stuName,course,MIN(score) FROM t_grade WHERE stuName="王五"
- SELECT stuName,course,MIN(score) FROM t_grade GROUP BY stuName;



## 查询

### 连接查询

现有两张表

t_book  ↓

+----+--------------+--------+----------+----------+
| id | bookName     | price  | author   | bookType |
+----+--------------+--------+----------+----------+
|  1 | JAVA编程思想 | 100.00 | 埃史尔   | 1        |
|  2 | 生物学       |  27.00 | 生物老师 | 3        |
|  3 | 白鹿原       |  30.00 | 陈忠实   | 2        |
|  4 | 惊悚乐园     |  36.00 | 三天一觉 | 5        |
+----+--------------+--------+----------+----------+

t_bookyupe  ↓

+----+--------------+
| id | bookTypeName |
+----+--------------+
|  1 | 计算机类     |
|  2 | 文学类       |
|  3 | 教育类       |
+----+--------------+

表一bookType  对应表二id 

#### 内连接

多张表之间数据连接查询，为避免笛卡尔乘积现象，需要添加有有效的连接条件

```mysql
SELECT bookName,author,bookTypeName,price FROM t_book,t_booktype WHERE t_book.`bookType`=t_booktype.`id`;
```

**连接条件：`t_book`.bookType=t_booktype.`id`**

+--------------+----------+--------------+--------+
| bookName     | author   | bookTypeName | price  |
+--------------+----------+--------------+--------+
| JAVA编程思想 | 埃史尔   | 计算机类     | 100.00 |
| 生物学       | 生物老师 | 教育类       |  27.00 |
| 白鹿原       | 陈忠实   | 文学类       |  30.00 |
+--------------+----------+--------------+--------+

```
SELECT b.bookName,b.author,t.bookTypeName,b.price FROM t_book b,t_booktype t 
WHERE b.`bookType`=t.`id`;
```

暂时重命名t_book 为 b， t_booktype 为 t 



#### 外连接

查出某张表所有信息

##### 左连接: 查出表1所有信息

```
SELECT * FROM t_book LEFT JOIN t_booktype ON t_book.`bookType`=t_booktype.`id`;
SELECT * FROM t_book b LEFT JOIN t_booktype t ON b.`bookType`=t.`id`; //用别名
```

+----+--------------+--------+----------+----------+------+--------------+
| id | bookName     | price  | author   | bookType | id   | bookTypeName |
+----+--------------+--------+----------+----------+------+--------------+
|  1 | JAVA编程思想 | 100.00 | 埃史尔   | 1        |    1 | 计算机类     |
|  3 | 白鹿原       |  30.00 | 陈忠实   | 2        |    2 | 文学类       |
|  2 | 生物学       |  27.00 | 生物老师 | 3        |    3 | 教育类       |
|  4 | 惊悚乐园     |  36.00 | 三天一觉 | 5        | NULL | NULL         |
+----+--------------+--------+----------+----------+------+--------------+

##### 右连接：查出表2所有信息

```
SELECT * FROM t_book b RIGHT JOIN t_booktype t ON b.`bookType`=t.`id`; 
SELECT b.bookName,b.author,t.booktypeName FROM t_book b RIGHT JOIN t_booktype t ON b.`bookType`=t.id;   //用别名
```

+------+--------------+--------+----------+----------+----+--------------+
| id   | bookName     | price  | author   | bookType | id | bookTypeName |
+------+--------------+--------+----------+----------+----+--------------+
|    1 | JAVA编程思想 | 100.00 | 埃史尔   | 1        |  1 | 计算机类     |
|    2 | 生物学       |  27.00 | 生物老师 | 2        |  2 | 文学类       |
|    3 | 白鹿原       |  30.00 | 陈忠实   | 2        |  2 | 文学类       |
| NULL | NULL         |   NULL | NULL     | NULL     |  3 | 教育类       |
+------+--------------+--------+----------+----------+----+--------------+

##### 多连接

```
SELECT b.bookName,b.author,t.bookTypeName,b.price FROM t_book b,t_booktype t 
WHERE b.`bookType`=t.`id` AND b.`price`>40;  //
```



### 子查询（条件带括号）

用到的表

t_book  ↓

+----+--------------+--------+----------+----------+
| id | bookName     | price  | author   | bookType |
+----+--------------+--------+----------+----------+
|  1 | JAVA编程思想 | 100.00 | 埃史尔   | 1        |
|  2 | 生物学       |  27.00 | 生物老师 | 3        |
|  3 | 白鹿原       |  30.00 | 陈忠实   | 2        |
|  4 | 惊悚乐园     |  36.00 | 三天一觉 | 5        |
+----+--------------+--------+----------+----------+

t_bookyupe  ↓

+----+--------------+
| id | bookTypeName |
+----+--------------+
|  1 | 计算机类     |
|  2 | 文学类       |
|  3 | 教育类       |
+----+--------------+

t_price ↓

+----+------------+-------+--------------+
| id | priceLevel | price | description  |
+----+------------+-------+--------------+
|  1 |          1 |    80 | 价格贵的书   |
|  2 |          2 |    60 | 价格适中的书 |
|  3 |          3 |    40 | 价格便宜的书 |
+----+------------+-------+--------------+

#### IN的子查询

当查询条件在另一个SELECT里

```
SELECT * FROM t_book WHERE booktype IN (SELECT `id` FROM t_booktype);
SELECT * FROM t_book WHERE booktype NOT IN (SELECT `id` FROM t_booktype);
```

#### 带符号的子查询

```
SELECT * FROM t_book WHERE price >=(SELECT price FROM t_pricelevel WHERE priceLevel=1);
//SELECT price FROM t_pricelevel WHERE priceLevel=1 返回一个数，若返回的是数组则要用price >=any
```

#### 带Exists关键字的子查询（返回 布尔值）

```
SELECT * FROM t_book WHERE EXISTS (SELECT * FROM t_booktype);
//若SELECT * FROM t_booktype查询到结果，返回TRUE，再执行SELECT * FROM t_book
SELECT * FROM t_book WHERE NOT EXISTS (SELECT * FROM t_booktype);
//查询不到结果
```

#### 带any 关键字的子查询(满足任一即可)

```
SELECT * FROM t_book WHERE price >=ANY (SELECT price FROM t_pricelevel);
//SELECT price FROM t_pricelevel 返回的是三个数，即数组，用 price >=ANY则让Price大于最小即可
```

#### 带All关键字的子查询(满足所有条件)

```
SELECT * FROM t_book WHERE price >=ALL (SELECT price FROM t_pricelevel);
//满足price大于SELECT price FROM t_pricelevel中最大的数才行
```



### 合并查询（UNION)

将所有查询结果合并到一起，然后去除掉相同的记录

```
SELECT t_book FROM t_book UNION SELECT id FROM t_booktype;
//将t_book的id和t_booktype的id合并
SELECT id FROM t_book UNION ALL SELECT id FROM t_booktype;
//若不想合并，则用UNION ALL
```



### 取别名

表取别名:   表明 + 别名

字段取别名：字段名 +（AS)+ 别名

```
SELECT t_book.`price` AS tp FROM t_book;
```



### 更新表数据（UPDATE...SET)

```
UPDATE t_book SET bookName="M" WHERE bookName LIKE "%SQL%";
//重设数据
```

```
DELETE FROM t_book WHERE id=6;
//删除数据
```



## 索引

提高对表中数据的查询速度，类似于图书的目录，方便快速定位

- 优点：提高数据查询速度
- 缺点：创建和为何索引的时间增加了

