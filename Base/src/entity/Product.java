package entity;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-11 15:41
 * @Description:
 */
public class Product {

    private Integer price;

    private String color;

    public Product() {
    }

    public Product(Integer price) {
        this.price = price;
    }

    public Product(Integer price, String color) {
        this.price = price;
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
