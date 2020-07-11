/**
 * @Auther: tzl
 * @Date: 2020/7/11 08:11
 * @Description:
 */
public class Product {

    int id;

    int num;

    String name;

    double price;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", num=" + num +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
