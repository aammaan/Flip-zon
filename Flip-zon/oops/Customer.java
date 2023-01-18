package oops;
import java.awt.*;
import java.util.*;


import java.io.*;
import java.util.List;

public class Customer {
    static Scanner input = new Scanner(System.in);
    private static String name;
    private static String password;
    private static String email;
    private static String phone;
    private static int age;
    private int accountbalance = 1000;
    private String status = "NORMAL";
    public static List<Cart> cart = new ArrayList<Cart>();

    public static Scanner getInput() {
        return input;
    }

    public static void setInput(Scanner input) {
        Customer.input = input;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Customer.name = name;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Customer.password = password;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Customer.email = email;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        Customer.phone = phone;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        Customer.age = age;
    }

    public int getAccountbalance() {
        return accountbalance;
    }

    public void setAccountbalance(int accountbalance) {
        this.accountbalance = accountbalance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static List<Cart> getCart() {
        return cart;
    }

    public static void setCart(List<Cart> cart) {
        Customer.cart = cart;
    }

    public ArrayList<Integer> getCoupons() {
        return coupons;
    }

    public void setCoupons(ArrayList<Integer> coupons) {
        this.coupons = coupons;
    }

    public ArrayList<Integer> coupons = new ArrayList<Integer>();



    public Customer(String name1, String password1, String email1, String phone1, int age1) {
        this.name = name1;
        this.password = password1;
        this.email = email1;
        this.phone = phone1;
        this.age = age1;
        this.accountbalance = accountbalance;
        this.status = status;
        coupons.add(0);
    }

    public static void print() {
        System.out.println("1) Sign up\n" +
                "2) Log in\n" +
                "3) Back");
    }

    public static void signup() {
        System.out.println("Enter the name of the Customer: ");
        Scanner input11 = new Scanner(System.in);
        name = input11.next();
        Scanner input1 = new Scanner(System.in);
        System.out.println("Set the password: ");
        password = input1.next();
        System.out.println("Enter the email of the Customer: ");
        Scanner input2 = new Scanner(System.in);
        email = input2.next();
        System.out.println("Enter the phone number of the Customer: ");
        Scanner input3 = new Scanner(System.in);
        phone = input3.next();
        System.out.println("Enter the age of the Customer: ");
        Scanner input4 = new Scanner(System.in);
        age = input4.nextInt();
        Customer customer1 = new Customer(name, password, email, phone, age);
        Storeroom.listofcustomer.add(customer1);
        Storeroom.registeredcustomer++;

    }

    public static String login() {
        System.out.println("Enter the name of the Customer: ");
        Scanner input111 = new Scanner(System.in);
        String name1 = input111.next();
        System.out.println("Set the password: ");
        Scanner input10 = new Scanner(System.in);
        String password1 = input10.next();
        System.out.println("Enter the email of the Customer: ");
        Scanner input13 = new Scanner(System.in);
        String email1 = input13.next();
        if (Storeroom.searchcustomer(email1) == -1) {
            return "-1";
            // no such user with this email exist
        }
        if (Storeroom.listofcustomer.get(Storeroom.searchcustomer(email)).password.equals(password1) && Storeroom.listofcustomer.get(Storeroom.searchcustomer(email)).name.equals(name1)) {
            return Storeroom.listofcustomer.get(Storeroom.searchcustomer(email)).email;
            //everything is right
        } else {
            return "-2";
            //Either password or name do not match
        }
    }

    public static void upradestatus(int i) {
        System.out.print("Current Status: ");
        String old = Storeroom.listofcustomer.get(i).status;
        System.out.println(Storeroom.listofcustomer.get(i).status);
        System.out.print("Choose new status: ");
        String naw = input.next();
        Storeroom.listofcustomer.get(i).status = naw;
        int a = 0;
        if (naw.equals("ELITE") && old.equals("NORMAL")) {
            a = 300;
        } else if (naw.equals("ELITE") && old.equals("PRIME")) {
            a = 100;
        } else if (naw.equals("PRIME") && old.equals("NORMAL")) {
            a = 200;
        }
        Storeroom.listofcustomer.get(i).accountbalance -= a;
        System.out.println("Status update to " + naw);
        System.out.println("Your account balance is " + Storeroom.listofcustomer.get(i).accountbalance);

    }

    public static void browseproducts() {
        int u = 1;
        for (Product i : Category.getListofproducts()) {
            System.out.println(u + ") " + i.getPname());
            System.out.println(i.getPid());
            System.out.println(i.getPrice());
            System.out.println(i.getDescription() + "\n\n");

        }
    }

    public static void browsedeal() {
        int u = 1;
        for (Combined i : Storeroom.listofcombined) {
            System.out.println(u + ") " + i.getName());
            System.out.printf("COMBINED PRICE: " + i.getCombinedprice() + "\n\n");
        }
    }

    public static void addproducttocart(int id) {
        System.out.println("Enter Category ID ");
        int Cid = input.nextInt();
        System.out.println("Enter product ID ");
        Double Pid = input.nextDouble();
        System.out.printf("Enter the quantity ");
        int quantity = input.nextInt();
        int p = Storeroom.searchproduct(Cid, Pid);
        if(Storeroom.listofcategory.get(Storeroom.searchcategory(Cid)).listofproducts.get(p).getCount()<quantity){
            System.out.println("Only "+Storeroom.listofcategory.get(Storeroom.searchcategory(Cid)).listofproducts.get(p).getCount()+" products left");
        }else {
            Cart cart1 = new Cart(Storeroom.listofcategory.get(Storeroom.searchcategory(Cid)).listofproducts.get(p).getPname(), quantity, Storeroom.listofcategory.get(Storeroom.searchcategory(Cid)).listofproducts.get(p).getPrice(), "p");
            Storeroom.listofcustomer.get(id).cart.add(cart1);
            System.out.println("Items successfully added to cart!");

        }

    }

    public static void adddealtocart(int id) {
        System.out.println("Enter Deal no. ");
        Scanner input43 = new Scanner(System.in);
        int Cid = input43.nextInt();
        System.out.printf("Enter the quantity ");
        Scanner input44 = new Scanner(System.in);

        int quantity = input44.nextInt();
        Cart cart1 = new Cart(Storeroom.listofcombined.get(Cid - 1).getName(), quantity, Storeroom.listofcombined.get(Cid - 1).getCombinedprice(), "d");
        Storeroom.listofcustomer.get(id).cart.add(cart1);

    }

    public static void viewcoupons(int id) {
        System.out.println("Available discount coupon in % : ");
        for (int i : Storeroom.listofcustomer.get(id).coupons) {

            System.out.print(i + " ");
        }
    }

    public static void addmoneytowallet(int id) {
        System.out.println("Enter the amount you want to add: ");
        int amount = input.nextInt();
        Storeroom.listofcustomer.get(id).accountbalance += amount;
        System.out.println("Amount added successfully!!");
        System.out.println("New account balance is " + Storeroom.listofcustomer.get(id).accountbalance);
    }

    public static void emptycart(int id) {
        Storeroom.listofcustomer.get(id).cart.clear();
        System.out.println("Cart successfully empited!");
    }

//    public static void viewcart(int id) {
//        int u = 0;
//        for (int i = 0; i < Storeroom.listofcustomer.get(id).cart.size(); i++) {
//            if(Storeroom.listofcustomer.get(id).cart.get(i).pord.equals("p")){
//                System.out.println("Product name: "+Storeroom.listofcustomer.get(id).cart.get(i).);
//                System.out.print("Product ID: ");
//                System.out.print("Product Price: ");
//                System.out.println("Enter Product Description in one line: ");
//
//            }
////            System.out.println(u+") "+Storeroom.listofcustomer.get(id).cart.p;
//
//        }
//    }


    public static void viewcart(int id) {
        for (Cart i : Storeroom.listofcustomer.get(id).cart) {
            System.out.println(i.getQuantity()+" quantity of "+i.getName());
            System.out.println("Price: "+i.getPrice());

        }
    }
    public static void Discount(int customerid,double productid){

    }
    public static void checkoutcart(int id) {
        if (Storeroom.listofcustomer.get(id).cart.size() == 0) {
            System.out.println("Cart is Empty!!");
        } else {
            int carttotal = 0;
            int deliverycharges = 0;
            for (Cart i : Storeroom.listofcustomer.get(id).cart) {
                carttotal += i.getQuantity() * i.getPrice();
            }
            if (Storeroom.listofcustomer.get(id).accountbalance < carttotal) {
                System.out.println("Insufficient balance!! Please try again");
            } else {
                for (Cart i : Storeroom.listofcustomer.get(id).cart) {
                    System.out.println("Product: " + i.getName());
                    System.out.println("Product price: " + i.getPrice());
                    System.out.println("Product Quantity: " + i.getQuantity());
                }
                System.out.println("Cart Value: " + carttotal);


                System.out.print("Delivery charges: ");
                if (Storeroom.listofcustomer.get(id).status.equals("ELITE")) {
                    System.out.println("Rs 100");
                    deliverycharges += 100;
                } else if (Storeroom.listofcustomer.get(id).status.equals("NORMAL")) {
                    System.out.print("Rs 100 + ");
                    int a = (5 * carttotal) / 100;
                    System.out.println(a);
                    deliverycharges += 100 + a;
                } else if (Storeroom.listofcustomer.get(id).status.equals("PRIME")) {
                    System.out.print("Rs 100");
                    int a = (2 * carttotal) / 100;
                    System.out.println(a);
                    deliverycharges += 100 + a;
                }
                double deal =0;
                for( Cart i: Storeroom.listofcustomer.get(id).cart){
                    if(i.getPord().equals("d")){
                        deal+=i.getPrice();
                    }
                }

                System.out.print("Discount: ");
                int discount = Collections.max(Storeroom.listofcustomer.get(id).coupons);
                if(Storeroom.listofcustomer.get(id).status.equals("ELITE")){
                    if(discount<10){
                        discount =10;
                    }
                }else if(Storeroom.listofcustomer.get(id).status.equals("PRIME")){
                    if(discount<5){
                        discount =5;
                    }
                }
                double real = (discount * (carttotal-deal) )/ 100;
                carttotal+=deal;
                System.out.println(discount + "% of " + carttotal + " = " + real);
                carttotal += real;
                carttotal += deliverycharges;
                System.out.println("Total Cost ( Including Delivery Charges) = Rs " + carttotal);
                if (Storeroom.listofcustomer.get(id).status.equals("ELITE")) {
                    System.out.println("Your order will be delivered within 2 days.");
                } else if (Storeroom.listofcustomer.get(id).status.equals("NORMAL")) {
                    System.out.println("Your order will be delivered within 7 to 10 days.");
                } else if (Storeroom.listofcustomer.get(id).status.equals("PRIME")) {
                    System.out.println("Your order will be delivered within 3 to 6 days.");
                }
                Storeroom.listofcustomer.get(id).accountbalance -= carttotal;
                Storeroom.listofcustomer.get(id).cart.clear();
                int a=0;
                int b=0;
                if (carttotal >= 5000) {
                    a = Storeroom.random();
                    b = Storeroom.random();

                    Storeroom.listofcustomer.get(id).coupons.add(a);
                    Storeroom.listofcustomer.get(id).coupons.add(b);

                    System.out.println("You have won two coupons of " + a + "% and " + b + "% discount. Congrats!!");
                }
            }
        }
    }

}
