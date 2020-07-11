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
 * @Date: 2020/7/11 09:21
 * @Description:
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String sql = "select * from product";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_tzl?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",username,password);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Product> productList = new ArrayList<>();
            while(rs.next())
            {
                Product product = new Product();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int num = rs.getInt("num");
                double price = rs.getDouble("price");
                product.setId(id);
                product.setName(name);
                product.setNum(num);
                product.setPrice(price);
                productList.add(product);
            }
            request.setAttribute("username",user);
            request.setAttribute("data",productList);
            request.getRequestDispatcher( "/cart/product.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
