package web;

public class cartBean {

    private String name = null;
    private int price = 0;
    private int stock = 0;
    private int num = 0;
    private double d = 0;


    public int getStock() {
        return stock;
    }
    public void setStock(int count) {
        this.stock = count;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public double getD() {
        return d;
    }
    public void setD(double d) {
        this.d = d;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

}