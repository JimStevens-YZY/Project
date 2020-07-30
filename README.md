# Ordering System
订餐系统(大一下java课程设计作业)
## 设计内容
##### &emsp;课程设计的主要目的是设计一个智慧订餐系统，通过智慧订餐系统，用户可以在订餐界面浏览食品菜单和图片介绍，并且在订餐界面输入了个人信息之后可以进行订餐和付款，在这之后程序会将订单输入到后台订单管理系统。而管理员用户可以通过登录管理员账户浏览输入到订单系统当中的用户订单，进而为用户准备食物以及后续配送服务。
#### 该系统分为四大界面：
##### 一、注册界面：注册界面可以注册一个用户的账号，程序会将注册的账户和密码写入后台的数据库。
##### 二、登录界面：登陆界面的登录入口分为用户登录和管理员登录，用户登录需要通过注册账户进行登录，只有使用了成功注册了的账户才能登录。而管理员登录则是使用专门的管理员账户进行登录。
##### 三、订餐界面：用户使用用户账户登录之后可以进入点餐界面进行点餐。
##### 四、后台订单界面：管理员通过管理员账户登录之后可以看见各用户的订单情况并进行统计和订单的删除和修改。
## 功能描述
本次课程设计主要是用Java语言编写。采用了Swing 界面，下面是具体功能：
<br>一、登录与注册功能
<br>&emsp;(1)用户可以进行账户的注册。然后在后台数据库中，每个用户单独具有一张表记录个人信息。
<br>&emsp;(2)用户仅可以通过注册过的用户账户和密码登录。
<br>二、订餐功能
<br>&emsp;(1)订餐界面上方含有菜单栏，用户可以在此菜单栏中进行个人订单、个人信息的查看，以及查看订餐服务的营业时间和商家联系方式
<br>&emsp;(2)下方的左侧为食品菜单，右侧为食品详情，包括食品的图片、价格，和食品配料。并且订餐界面实现了联动的功能，在左边选择食品后，右边会自动跳转到点击的相应食品的详情信息。
<br>&emsp;(3)在右侧，用户点击订餐按钮之后，会跳出两个结账操作的界面，一个为输入要点餐的食品的编号和数量的界面，另一个为统计点餐项和总价格的结账界面。用户在点击了结账功能后会跳转至付款二维码界面供用户进行结账操作。
<br>三、后台订单管理功能
<br>&emsp;管理员通过登录管理员账户之后，可以进入管理员后台订单界面，其中的订单均来自用户订餐后产生的订单，管理员可以将后台订单中的数据进行删除和修改，并将更改后的数据重新保存到数据库。
### 主要界面
#### a.登录界面
![image](https://github.com/JimStevens-YZY/Project/blob/master/photo/pic1.png)
#### b.注册界面
![image](https://github.com/JimStevens-YZY/Project/blob/master/photo/pic2.png)
#### c.点餐界面
![image](https://github.com/JimStevens-YZY/Project/blob/master/photo/pic3.png)
#### d.购物车界面
###### 个人信息填写
![image](https://github.com/JimStevens-YZY/Project/blob/master/photo/pic4.png)
###### 输入餐品编号
![image](https://github.com/JimStevens-YZY/Project/blob/master/photo/pic5.png)
###### 购物清单
![image](https://github.com/JimStevens-YZY/Project/blob/master/photo/pic6.png)
#### e.支付界面
![image](https://github.com/JimStevens-YZY/Project/blob/master/photo/pic7.png)
### 功能模块图
![image](https://github.com/JimStevens-YZY/Project/blob/master/photo/pic9.png)
### 程序流程图
![image](https://github.com/JimStevens-YZY/Project/blob/master/photo/pic10.png)

