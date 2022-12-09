package test;

/**
 * @Author: chenlj
 * @CreateTime: 2021-03-11 15:25
 * @Description:
 */
public class Item {
    private int i;
    private String name;

    private double money;

    public Item(int i, String name, double money) {
        this.i = i;
        this.name = name;
        this.money = money;
    }

    public int getId() {
        return i;
    }

    @Override
    public String toString() {
        return "Item{" +
                "i=" + i +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
