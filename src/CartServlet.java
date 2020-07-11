import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: tzl
 * @Date: 2020/7/11 12:56
 * @Description:
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {
    private String username;
    private String password;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        username = getServletConfig().getServletContext().getInitParameter("user");
        password = getServletConfig().getServletContext().getInitParameter("password");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String sql = "select * from admin where username=?";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_tzl?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",username,password);
            ps = con.prepareStatement(sql);
            ps.setString(1,user);
            rs = ps.executeQuery();
            if(rs.next())
            {
                int aid = rs.getInt("id");
                //获取购物车列表
                String s = "select * from cart where aid=?";
                ps = con.prepareStatement(s);
                ps.setInt(1,aid);
                rs = ps.executeQuery();
                List<Cart> cartList = new ArrayList<Cart>();
                while(rs.next()){
                    int id = rs.getInt("id");
                    int num = rs.getInt("num");
                    double price = rs.getDouble("price");
                    String name = rs.getString("name");
                    Cart cart = new Cart();
                    cart.setId(id);
                    cart.setName(name);
                    cart.setNum(num);
                    cart.setPrice(price);
                    System.out.println(cart);
                    cartList.add(cart);
                }
                request.setAttribute("username",user);
                request.setAttribute("data",cartList);
                request.getRequestDispatcher( "/cart/list.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
