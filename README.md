# JSP实现登录、注册、购物车

## 1项目准备

- git创建仓库
- 上传项目

## 2解决方案

- Github仓库创建以及上传README.md测试
- JSP项目搭建
- 登录、注册、修改密码的实现
- 查询购物车列表

## 3具体实现 

  + XML封装数据库信息
    ` <context-param>
           <param-name>user</param-name>
           <param-value>root</param-value>
       </context-param>
       <context-param>
           <param-name>password</param-name>
           <param-value>123456</param-value>
       </context-param>`

   + Servlet的使用采用注入的方式使用
     
```java
     @WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
```

   + Servlet携带信息跳转到jsp页面

     ```java
     request.setAttribute("msg","账号或密码错误");request.getRequestDispatcher( "/login/login.jsp").forward(request, response);
     ```

- 数据库查询操作

  ```java
  String sql = "select * from admin where username=? and password =?";
  ps = con.prepareStatement(sql);
              ps.setString(1,user);
              ps.setString(2,pass);
              rs = ps.executeQuery();
  ```

- 数据库插入操作

  ```java
  String s = "INSERT INTO admin(username,password,email) value(?,?,?)";ps = con.prepareStatement(s);ps.setString(1, user);ps.setString(2, pass);ps.setString(3, email);
  ```

- 查询购物车的列表并对结果集处理

  ```java
  String s = "select * from cart where aid=?";ps = con.prepareStatement(s);ps.setInt(1,aid);rs = ps.executeQuery();List<Cart> cartList = new ArrayList<Cart> ();while(rs.next()){    int id = rs.getInt("id");    int num = rs.getInt("num");    double price = rs.getDouble("price");    String name = rs.getString("name");    Cart cart = new Cart();    cart.setId(id);    cart.setName(name);    cart.setNum(num);    cart.setPrice(price);    System.out.println(cart);    cartList.add(cart);}
  ```

- 数据库更新操作

  ```java
  String s = "UPDATE admin set password=? WHERE username=?";ps = con.prepareStatement(s);ps.setString(1,pass1);ps.setString(2,user);int rs = ps.executeUpdate();if(rs>0){    System.out.println("密码修改成功");    request.setAttribute("msg", "密码修改成功，请重新登录");    request.getRequestDispatcher("/login/login.jsp").forward(request, response);}
  ```