package oops;

public class Product {
    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public double getPid() {
        return Pid;
    }

    public void setPid(double pid) {
        Pid = pid;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getDiscountelite() {
        return discountelite;
    }

    public void setDiscountelite(double discountelite) {
        this.discountelite = discountelite;
    }

    public double getDiscountprime() {
        return discountprime;
    }

    public void setDiscountprime(double discountprime) {
        this.discountprime = discountprime;
    }

    public double getDiscountnormal() {
        return discountnormal;
    }

    public void setDiscountnormal(double discountnormal) {
        this.discountnormal = discountnormal;
    }

    private String Pname;
    private double  Pid;
    private String Description;
    private double  Price;
    private int count;
    private double  discountelite = 10.0;
    private double  discountprime = 5.0;
    private double  discountnormal = 0.0;

    public Product(String pname, double  pid, String description, double  price,int count) {
        this.Pname = pname;
        this.Pid = pid;
        this.Description = description;
        this.Price = price;
        this.count = count;
    }
}
