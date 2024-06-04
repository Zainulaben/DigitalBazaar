public class Main {


    public static Person[] p=new Person[100000];
    public static int count;
    public static int index=0;


    public static Seller[]s=new Seller[100000];
    public static int sell_index;
    public static int sell_count;


    public static Buyer[]b=new Buyer[100000];
    public static int buy_count;
    public static int buy_index;


    public static Renter[]r=new Renter[100000];
    public static int rent_index;
    public static int rent_count;

    public static int active_rent_index=0;

    public static int active_product_index=0;

    public static Product [] all_products_sell =new Product[10000000];
    public static Product [] all_products_rent =new Product[10000000];

    Main()
    {
        sell_count=0;
        count=0;
        buy_count=0;
        buy_index=0;
    }


    public static void main(String[] args) {
        new GUI();
    }

    public static int getSell_index() {
        return sell_index;
    }


}