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
 * @Date: 2020/7/11 13:06
 * @Description:
 */
@WebServlet(name = "DeleteProductServlet", urlPatterns = {"/deleteProduct"})
public class DeleteProductServlet extends HttpServlet {
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
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            String str = "DELETE from cart where id=?";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_tzl?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",username,password);
            ps = con.prepareStatement(str);
            ps.setInt(1, id);
            int rs1 = ps.executeUpdate();
            if (rs1 > 0) {
                System.out.println("删除成功");
            }
            String sss = "select * from admin where username=?";
            ps = con.prepareStatement(sss);
            ps.setString(1, user);
            rs = ps.executeQuery();
            int aid=0;
            if (rs.next()){
                aid=rs.getInt("id");
            }
            String s = "select * from cart where aid=?";
            ps = con.prepareStatement(s);
            ps.setInt(1,aid);
            rs = ps.executeQuery();
            List<Cart> cartList = new ArrayList<Cart>();
            while(rs.next()){
                int id1 = rs.getInt("id");
                int num = rs.getInt("num");
                double price = rs.getDouble("price");
                String name = rs.getString("name");
                Cart cart = new Cart();
                cart.setId(id1);
                cart.setName(name);
                cart.setNum(num);
                cart.setPrice(price);
                cartList.add(cart);
            }
            request.setAttribute("username",user);
            request.setAttribute("msg","删除成功");
            request.setAttribute("data",cartList);
            request.getRequestDispatcher( "/cart/list.jsp").forward(request, response);

        } catch (SQLException e) {

        }
    }
}
