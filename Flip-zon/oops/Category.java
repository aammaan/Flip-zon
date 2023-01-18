package oops;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String Cname;
    private int Cid;

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public int getCid() {
        return Cid;
    }

    public void setCid(int cid) {
        Cid = cid;
    }

    public static List<Product> getListofproducts() {
        return listofproducts;
    }

    public static void setListofproducts(List<Product> listofproducts) {
        Category.listofproducts = listofproducts;
    }

    static List<Product> listofproducts = new ArrayList<Product>();


    public Category(String cname, int cid) {
        Cname = cname;
        Cid = cid;

    }

    public static void productcatalog() {
        int u = 1;
        for (Category i : Storeroom.listofcategory) {
            System.out.print("Category " + u + " name: ");
            System.out.println(i.Cname);
            u++;
        }

            for (Product j : Storeroom.listofcategory.get(0).listofproducts) {
                System.out.print("Product name: ");
                System.out.println(j.getPname());
                System.out.print("Product ID: ");
                System.out.println(j.getPid());
                System.out.print("Product Description: ");
                System.out.println(j.getDescription());
                System.out.print("Product Price: ");
                System.out.println(j.getPrice()+"\n\n");


            }

    }

    public static void availabledeals() {
        int u = 1;
        for (Combined i : Storeroom.listofcombined) {
            System.out.println(u + ") " + i.getName());
            System.out.println("Combined Price: " + i.getCombinedprice());
        }
    }

}
