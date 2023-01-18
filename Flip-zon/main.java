import oops.Admin;
import oops.Category;
import oops.Customer;
import oops.Storeroom;

import java.nio.file.LinkPermission;
import java.util.Calendar;
import java.util.Scanner;

public class main{
    static public void print() {
        System.out.println("\u001B[31m"+"WELCOME TO FLIPZON: \n\n" +
                "1) Enter as Admin \n" +
                "2) Explore the Product Catalog\n" +
                "3) Show Available Deals\n" +
                "4) Enter as Customer\n" +
                "5) Exit the Application\n "+"\u001B[0m");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while(true) {
            print();
            int a = input.nextInt();
            if(a == 1){
                String Adminname;
                String Adminpassword;
                int count1=0;
                System.out.println("Dear Admin,\n \n" +
                        "Please enter your username and passwrod ");
                while(true) {

                    String name = input.next();
                    String password = input.next();
                    Adminname=name;
                    Adminpassword=password;
                    int check = Admin.admincheck(name, password);


                    if(count1 == 2){
                        System.out.println("Sorry, You tried 3 times!\n" +
                                "Now its over, It's me, Not you.");
                        break;
                    }
                    if (check == 0) {
                        System.out.println("Sorry, Are you really the Admin!!\n" +
                                "Please try again");
                        count1++;
                    }else if(check == 1){
                        System.out.printf("Welcome Aman!!\n");
                        break;
                    }
                }

                if(count1 == 2){
                    break;
                }while(true) {
                    System.out.println("\u001B[36m"+"Please choose any one of the following actions:\n" +
                            "1) Add category\n" +
                            "2) Delete category\n" +
                            "3) Add Product\n" +
                            "4) Delete Product\n" +
                            "5) Set Discount on Product\n" +
                            "6) Add giveaway deal\n" +
                            "7) Back"+"\u001B[0m");
                    int aa = input.nextInt();
                    Admin admin = new Admin(Adminname,Adminpassword);

                    if (aa == 1) {
                        System.out.printf("Add Category ID: ");

                        int Cid = input.nextInt();

                        while (true) {
                            int u = Cid;
                            if (Storeroom.searchcategory(u)== -1) {
                                break;
                            } else {
                                System.out.println("Dear Admin, the category ID is already used!!! Please set a different and a unique category ID ");

                                System.out.printf("Add Category ID: ");
                                u = input.nextInt();

                            }
                            Cid = u;

                        }
                        System.out.println("Add category name: ");
                        String Cname = input.next();
                        admin.addcategory(Cname, Cid);


                        admin.addproduct(Cid);


                    } else if (aa == 2) {
                        System.out.println("Enter the Category you wanted to delete: ");
                        int cat = input.nextInt();
                        if (Storeroom.searchcategory(cat)== -1) {
                            System.out.println("This category doesn't exist.");

                        }else {
                            admin.deletecategory(cat);
                        }

                    } else if (aa == 3) {
                        System.out.println("Enter the Category in which you wanted to add a product: ");

                        int cat = input.nextInt();
                        if (Storeroom.searchcategory(cat)== -1) {
                            System.out.println("No such category exist!");

                        }else {
                            admin.addproduct(cat);
                        }

                    } else if (aa == 4) {
                        System.out.println("Enter Category id: ");
                        int cid = input.nextInt();
                        System.out.println("Enter Product id: ");
                        double  pid = input.nextDouble ();
                        if (Storeroom.searchproduct(cid,pid) == -1) {
                            System.out.println("No such product exist!");

                        }else {
                            admin.deleteproduct(cid, pid);
                        }

                    } else if (aa == 5) {
                        admin.Discountonproduct();
                    } else if (aa == 6) {
                        admin.addgiveawaydeal();
                    } else if (aa == 7) {
                        break;
                    } else {
                        System.out.printf("Invalid input");
                    }
                }

            }if(a == 2){
                Category.productcatalog();
            }if(a == 3){
                Category.availabledeals();
            }if(a == 4){
                while(true){
                    Customer.print();
                    int c=input.nextInt();
                    if(c == 1){
                        Customer.signup();
                    }else if(c == 2){
                        String  j =  Customer.login();
                        if( j.equals("-1")){
                            System.out.println("No such user exist!");
                        } else if ( j.equals("-2")) {
                            System.out.println("Either password or name do not match!");
                        }else {
                            int id = Storeroom.searchcustomer(j);
                            while(true){
                                System.out.println("\u001B[35m"+"Welcome "+ Storeroom.listofcustomer.get(Storeroom.searchcustomer(j)).getName()+" !!");
                                System.out.println("1) Browse products\n" +
                                        "2) Browse deals\n" +
                                        "3) Add a product to cart\n" +
                                        "4) Add products in deal to cart\n" +
                                        "5) View coupons\n" +
                                        "6) Check account balance\n" +
                                        "7) View cart\n" +
                                        "8) Empty cart\n" +
                                        "9) Checkout cart\n" +
                                        "10) Upgrade customer status\n" +
                                        "11) Add amount to wallet\n" +
                                        "12) Back"+"\u001B[0m");
                                int y=input.nextInt();
                                if(y == 1){
                                    Customer.browseproducts();
                                }else if( y == 2){
                                    Customer.browsedeal();
                                }else if( y == 3){
                                    Customer.addproducttocart(id);
                                }else if( y == 4){
                                    Customer.adddealtocart(id);
                                }else if( y == 5){
                                    Customer.viewcoupons(id);
                                }else if( y == 6 ){
                                    System.out.println("Current account balance is Rupees "+Storeroom.listofcustomer.get(id).getAccountbalance());

                                }else if( y == 7){
                                    Customer.viewcart(id);
                                }else if( y == 8){
                                    Customer.emptycart(id);
                                }else if( y == 9){
                                    Customer.checkoutcart(id);
                                }else if( y == 10){
                                    Customer.upradestatus(id);
                                }else if( y == 11){
                                    Customer.addmoneytowallet(id);
                                }else if( y == 12){
                                    break;
                                }
                            }
                        }
                    } else if (c == 3) {
                        break;
                    }
                }
            }else if(a == 5){
                System.out.println("Thank you for visiting FLIPZON!!");
                break;
            }
        }

    }

}
