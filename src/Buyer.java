public class Buyer extends Person{

    public int buy_product_count=0;
    Product []buy_product=new Product[100000];



    public void set_buy_products(Product p)
    {
        buy_product[buy_product_count]=new Product();
        buy_product[buy_product_count]=p;
        buy_product_count++;
    }

}


