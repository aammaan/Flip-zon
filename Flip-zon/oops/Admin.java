package oops;

import java.awt.*;
import java.util.Scanner;

public class Admin {
    Scanner input = new Scanner((System.in));

    private static String name="Aman";
    private static String  password="Admin";

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Admin.name = name;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Admin.password = password;
    }

    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }
    static public int admincheck(String name1, String password1){
        if(name1.equals(name) && password1.equals(password) ){
            return 1;
        }else{
            return 0;
        }
    }
    public void addcategory(String name,int id){
        Category category1 = new Category(name,id);
        Storeroom.listofcategory.add(category1);
        System.out.println("Category successfully added!!");
    }
    public void deletecategory(int id){
        int j = Storeroom.searchcategory(id);
        Storeroom.listofcategory.remove(j);
        System.out.println("Category successfully deleted!!");
    }

    public void addproduct(int id){
        System.out.println("Add a Product:- ");
        System.out.print("Product name: ");
        String pname = input.next();
        System.out.print("Product ID: ");
        double  pid = input.nextDouble ();
        System.out.print("Product Price: ");
        double  price = input.nextDouble ();
        System.out.println("Product Quantity: ");
        int count = input.nextInt();
        System.out.println("Enter Product Description in one line: ");
        String Des = input.next();
        Product product1 = new Product(pname,pid,Des,price,count);
        int k = Storeroom.searchcategory(id);
        Storeroom.listofcategory.get(k).listofproducts.add(product1);
        System.out.println("Product successfully added!!");
    }

    public void deleteproduct(int Cid,double  Pid){
        int l = Storeroom.searchcategory(Cid);
        Storeroom.listofcategory.get(l).listofproducts.remove(Storeroom.searchproduct(Cid,Pid));
        System.out.println("Product successfully deleted!!");
        if(Storeroom.listofcategory.get(l).listofproducts.size()==0){
            System.out.println("As their were no product left in this category, we deleted this category. ");
            deletecategory(l);
        }

    }

    public void Discountonproduct(){
        System.out.println("Dear Admin give the Product ID you want to add discount for ");
        System.out.println("Enter the Product ID: ");
        double  Pid = input.nextDouble ();
        System.out.println("Enter discount for Elite, Prime and Normal customers respectively (in % terms)");
        System.out.print(" Discount for ELITE: ");
        double  elite = input.nextDouble ();
        System.out.print(" Discount for PRIME: ");
        double  prime = input.nextDouble ();
        System.out.print(" Discount for NORMAL: ");
        double  normal = input.nextDouble ();
        int Cid = (int)Pid;
        int l = Storeroom.searchcategory(Cid);
        if(elite >=10) {
            Storeroom.listofcategory.get(l).listofproducts.get(Storeroom.searchproduct(Cid, Pid)).setDiscountelite(elite);
        }
        if(prime>=5) {
            Storeroom.listofcategory.get(l).listofproducts.get(Storeroom.searchproduct(Cid, Pid)).setDiscountprime(prime);
        }
        if(normal>=0) {
            Storeroom.listofcategory.get(l).listofproducts.get(Storeroom.searchproduct(Cid, Pid)).setDiscountnormal(normal);
        }


    }
    public void addgiveawaydeal(){
        System.out.println("Dear Admin give the Product IDs you want to combine and giveaway a deal for :");
        System.out.println("Enter the first Category ID: ");
        Scanner input1 = new Scanner((System.in));
        int  firstid = input1.nextInt();
        System.out.println("Enter the first Product ID: ");
        Scanner input2 = new Scanner((System.in));

        double  first = input2.nextDouble ();
        System.out.println("Enter the second Category ID: ");
        Scanner input3 = new Scanner((System.in));

        int secondid = input3.nextInt();

        System.out.println("Enter the second Product ID: ");
        Scanner input4 = new Scanner((System.in));
        double  second = input4.nextDouble ();
        int a = Storeroom.searchproduct(firstid,first);
        int b = Storeroom.searchproduct(secondid,second);
        double both = Storeroom.listofcategory.get(firstid).listofproducts.get(a).getPrice() + Storeroom.listofcategory.get(firstid).listofproducts.get(b).getPrice();

        System.out.println("Enter the combined price(Should be less than their combined price) :");
        double Combinedprice = 0;
        while(true) {
            Combinedprice = input.nextDouble();
            if(Combinedprice < both){
                break;
            }else{
                System.out.println("Please, Enter the amount lesser than "+both);
            }
        }
        System.out.println("Enter the new ID: ");
        Scanner input8 = new Scanner(System.in);
        double idd = input8.nextDouble();
        String ch=Storeroom.listofcategory.get(Storeroom.searchcategory(firstid)).listofproducts.get(a).getPname()+" and " +Storeroom.listofcategory.get(Storeroom.searchcategory(secondid)).listofproducts.get(b).getPname();
        Combined combined1 = new Combined(ch,idd,Combinedprice );
        Storeroom.listofcombined.add(combined1);
    }


}
