public class Renter extends Person{
    float total_price;
    Product []active_product_List=new Product[10000];
    public int active_Product_List_count=0;

    Product[]sold_product_list=new Product[10000];
    int sold_Product_List_count=0;




    void add_Rented_Product(Product p)
    {
        active_product_List[active_Product_List_count]=new Product();
        active_product_List[active_Product_List_count]=p;

        Main.all_products_rent[Main.active_rent_index]=new Product();
        Main.all_products_rent[Main.active_rent_index]=p;

        Main.active_rent_index++;
        active_Product_List_count++;
    }

    void add_Sold_Product(Product p)
    {
        sold_product_list[sold_Product_List_count]=new Product();
        sold_product_list[sold_Product_List_count]=p;
        sold_Product_List_count++;
    }
}
