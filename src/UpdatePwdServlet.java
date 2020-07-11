import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * @Auther: tzl
 * @Date: 2020/7/11 08:57
 * @Description:
 */
@WebServlet(name = "UpdatePwdServlet", urlPatterns = {"/updatePwd"})
public class UpdatePwdServlet extends HttpServlet {
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
        String pass = request.getParameter("password");
        String pass1 = request.getParameter("password1");
        String pass2 = request.getParameter("password2");
        String user = request.getParameter("username");
        if(pass1.equals(pass2)){
            String sql = "select * from admin where username=? and password=?";
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_tzl?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", username, password);
                ps = con.prepareStatement(sql);
                ps.setString(1, user);
                ps.setString(2, pass);
                rs = ps.executeQuery();
                if (rs.next()) {//原来的密码正确
                    String s = "UPDATE admin set password=? WHERE username=?";
                    ps = con.prepareStatement(s);
                    ps.setString(1,pass1);
                    ps.setString(2,user);
                    int rs = ps.executeUpdate();
                    if(rs>0){
                        System.out.println("密码修改成功");
                        request.setAttribute("msg", "密码修改成功，请重新登录");
                        request.getRequestDispatcher("/login/login.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("msg", "原密码错误");
                    request.getRequestDispatcher( "/login/updatePwd.jsp?username="+user).forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            request.setAttribute("msg","两次密码不一致");
            request.getRequestDispatcher( "/login/updatePwd.jsp?username="+user).forward(request, response);
        }
    }
}
