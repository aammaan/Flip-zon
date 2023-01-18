package oops;


public class Combined {

    private String name;
    private double ID;
    private double  Combinedprice;

    public Combined(String name,double ID, double  combinedprice) {
        this.name = name;
        this.ID = ID;
        Combinedprice = combinedprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getID() {
        return ID;
    }

    public void setID(double ID) {
        this.ID = ID;
    }

    public double getCombinedprice() {
        return Combinedprice;
    }

    public void setCombinedprice(double combinedprice) {
        Combinedprice = combinedprice;
    }
}
//    int carttotal = 9000;
//    Customer customer = new Customer("1","1","1","1",1);
//        Storeroom.listofcustomer.add(customer);
//                if(carttotal >= 5000.0 ){
//                Storeroom.listofcustomer.get(0).coupons.add(Storeroom.random());
//                Storeroom.listofcustomer.get(0).coupons.add(Storeroom.random());
//
//                }
//                System.out.println(Storeroom.listofcustomer.get(0).coupons);
//                }