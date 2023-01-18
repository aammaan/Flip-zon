package oops;
import jdk.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Storeroom {
    public static   List<Customer> listofcustomer = new ArrayList<Customer>() ;
    public static   List<Category> listofcategory = new ArrayList<Category>() ;
    static   List<Combined> listofcombined = new ArrayList<Combined>() ;


    static int registeredcustomer = 0;

    static public int searchcustomer(String email){
        int dd=-1;
        for(int i=0;i<Storeroom.listofcustomer.size();i++){
            if(Storeroom.listofcustomer.get(i).getEmail().equals(email)){
                dd=i;
                break;
            }
        }
        return dd;
    }
    static public int searchcategory(int id){
        int dd=-1;
        for(int i=0;i<Storeroom.listofcategory.size();i++){
            if(Storeroom.listofcategory.get(i).getCid() == id){
                dd=i;
                break;
            }
        }
        return dd;
    }
    static public int searchproduct(int cid,double  id){
        int o= Storeroom.searchcategory(cid);
        int dd=-1;

        for (Product i: Storeroom.listofcategory.get(o).listofproducts){
            if (i.getPid()==id){
                return Storeroom.listofcategory.get(o).listofproducts.indexOf(i);
            }
        }
        return dd;
    }
    public static int random() {
        List<Integer> range = Arrays.asList(5,6,7,8,9,10,11,12,13,14,15);
        Random rand = new Random();
        int r = range.get(rand.nextInt(range.size()));
        return r;
    }

}
