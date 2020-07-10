import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @Auther: tzl
 * @Date: 2020/7/10 08:59
 * @Description:
 */
@WebServlet(name = "RegistServlet", urlPatterns = {"/regist"})
public class RegistServlet extends HttpServlet {
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
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String pass2 = request.getParameter("password2");
        if(pass.equals(pass2)){
            String email = request.getParameter("email");
            String sql = "select * from admin where username=?";
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_tzl?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", username, password);
                ps = con.prepareStatement(sql);
                ps.setString(1, user);
                rs = ps.executeQuery();
                if (rs.next()) {
                    request.setAttribute("msg", "该用户名已存在");
                    request.getRequestDispatcher("/login/regist.jsp").forward(request, response);
                } else {
                    String s = "INSERT INTO admin(username,password,email) value(?,?,?)";
                    ps = con.prepareStatement(s);
                    ps.setString(1, user);
                    ps.setString(2, pass);
                    ps.setString(3, email);
                    int rs = ps.executeUpdate();
                    if (rs > 0) {
                        System.out.println("注册成功");
                        request.setAttribute("msg", "注册成功，请登录");
                        request.getRequestDispatcher("/login/login.jsp").forward(request, response);
                    } else {
                        System.out.println("注册失败");
                        request.setAttribute("msg", "注册失败，请重新注册");
                        request.getRequestDispatcher("/login/regist.jsp").forward(request, response);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            request.setAttribute("msg","两次密码不一致");
            request.getRequestDispatcher( "/login/regist.jsp").forward(request, response);
        }
    }
}
