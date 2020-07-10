import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * @Auther: tzl
 * @Date: 2020/7/10 08:59
 * @Description:
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private String username;
    private String password;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void init() throws ServletException {
        //读取配置文件里面的信息
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        username = getServletConfig().getServletContext().getInitParameter("user");
        password = getServletConfig().getServletContext().getInitParameter("password");
        System.out.println("数据库-账号："+username);
        System.out.println("数据库-密码："+password);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
//        System.out.println("come in here");
//        System.out.println(user);
//        System.out.println(pass);
        String sql = "select * from admin where username=? and password =?";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_tzl?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",username,password);
            ps = con.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,pass);
            rs = ps.executeQuery();
            if(rs.next())
            {
                System.out.println("登录成功");
                request.setAttribute("data",username);
            }else{
                System.out.println("登录失败，请重新登录");
                request.setAttribute("msg","账号或密码错误");
                request.getRequestDispatcher( "/login/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
