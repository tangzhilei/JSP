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
 * @Date: 2020/7/11 13:05
 * @Description:
 */
@WebServlet(name = "BuyProductServlet", urlPatterns = {"/buyProduct"})
public class BuyProductServlet extends HttpServlet {
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
        int num = Integer.parseInt(request.getParameter("num"))-1;
        String name1 = request.getParameter("name");
        double price1 = Double.parseDouble(request.getParameter("price"));
        String sql = "UPDATE product set num=? WHERE id=?";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_tzl?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", username, password);
            ps = con.prepareStatement(sql);
            ps.setInt(1, num);
            ps.setInt(2, id);
            int rs1 = ps.executeUpdate();
            if(rs1>0){
                System.out.println("商品购买成功");
                request.setAttribute("msg", "购买成功");
                request.setAttribute("username", user);
            }
            String sss = "select * from admin where username=?";
            ps = con.prepareStatement(sss);
            ps.setString(1, user);
            rs = ps.executeQuery();
            int aid=0;
            if (rs.next()){
                aid=rs.getInt("id");
            }
            String ss = "INSERT INTO cart(aid,name,price,num) value(?,?,?,?)";
            ps = con.prepareStatement(ss);
            ps.setInt(1, aid);
            ps.setString(2, name1);
            ps.setDouble(3, price1);
            ps.setInt(4, 1);
            int rs2 = ps.executeUpdate();
            if (rs2 > 0) {
                System.out.println("插入购物车商品成功");
            }

            String s = "select * from product";
            ps = con.prepareStatement(s);
            rs = ps.executeQuery();
            List<Product> productList = new ArrayList<>();
            while(rs.next())
            {
                Product product = new Product();
                int id2 = rs.getInt("id");
                String name = rs.getString("name");
                int num2 = rs.getInt("num");
                double price = rs.getDouble("price");
                product.setId(id2);
                product.setName(name);
                product.setNum(num2);
                product.setPrice(price);
                productList.add(product);
            }
            request.setAttribute("data",productList);
            request.getRequestDispatcher( "/cart/product.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
