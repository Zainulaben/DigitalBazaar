public class Product {

    protected String product_ID;
    protected float price;
    protected static int msg_count = 0;
    protected static String[] messages_list;
    protected float weight;
    protected String category;
    protected String name;
    protected Installment installment;
    protected Rent rent;

    protected Date date_of_manufacture = new Date();

    public Laptop laptop;
    public Mobile mobile;
    public Air_conditioner air_conditioner;
    public Car car;
    public Bike bike;
    public Chair chair;
    public Table table;
    public Bed bed;


    public Product() {
        product_ID = "P0";
        price = 0;
        weight = 0;
        msg_count = 0;
        category = "NULL";
        name = "NULL";
    }

    public void set_product_data(String i, String p, String w, String c, int d, int m, int y) {
        product_ID = i;
        price = Float.parseFloat(p);
        weight = Float.parseFloat(w);
        category = c;
        date_of_manufacture.Set_ALL_Data_of_Date(d, m, y);
    }

    public void setPrice(float i)
    {
        price=i;
    }



    public void setMessages_list(String m)
    {
        messages_list= new String[msg_count+1];
        messages_list[msg_count]=m;
        msg_count++;
    }


    public void display_product()
    {
        System.out.println("Product ID : "+product_ID);
        System.out.println("Name : "+name);
        System.out.println("Price of product : "+price);
        System.out.println("Weight of product : "+weight);
        System.out.println("Category : "+category);

    }

    public void addProduct(Mobile mobile)
    {
        this.mobile=mobile;
    }
    public void addProduct(Laptop laptop)
    {
        this.laptop=laptop;
    }
    public void addProduct(Air_conditioner air_conditioner)
    {
        this.air_conditioner=air_conditioner;
    }
    public void addProduct(Car car)
    {
        this.car=car;
    }
    public void addProduct(Bike bike)
    {
        this.bike=bike;
    }
    public void addProduct(Chair chair)
    {
        this.chair=chair;
    }
    public void addProduct(Table table)
    {
        this.table=table;
    }
    public void addProduct(Bed bed)
    {
        this.bed=bed;
    }

}