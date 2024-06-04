public class Seller extends Person{
    public int active_product_count=0;
    public int sold_product_count=0;
    Product []active_product=new Product[100000];
    Product []sold_product=new Product[100000];



    public void set_active_products(Product p)
    {
        active_product[active_product_count]=new Product();
        active_product[active_product_count]=p;

        Main.all_products_sell[Main.active_product_index]=new Product();
        Main.all_products_sell[Main.active_product_index]=p;

        active_product_count++;
        Main.active_product_index++;
    }


    public void set_sold_products(Product p)
    {
        sold_product[sold_product_count]=new Product();
        sold_product[sold_product_count]=p;
        sold_product_count++;
    }

}


