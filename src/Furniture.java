public class Furniture extends Product{
    String Color;
    String Material;

    Furniture()
    {
        Color="NULL";
        Material="NULL";
        category="Furniture";
    }

    public void set_Furniture_data(String i,String  p,String  w,String color,String material,int d,int m,int y)
    {
        set_product_data(i,p,w,category,d,m,y);
        setColor(color);
        setMaterial(material);
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setMaterial(String material) {
        Material = material;
    }

}

class Bed extends Furniture
{
    Bed()
    {
        name="Bed";
    }
    void set_Bed_data(String i,String p,String w,String color,String material,int d,int m,int y)
    {
        set_Furniture_data(i,p,w,color,material,d,m,y);
        addProduct(this);
    }

    @Override
    public void display_product() {
        System.out.println("Product ID : "+product_ID);
        System.out.println("Name : "+name);
        System.out.println("Price of product : "+price);
        System.out.println("Weight of product : "+weight);
        System.out.println("Category : "+category);
        System.out.println("Colour : "+Color);
        System.out.println("Material : "+Material);
    }

}

class Chair extends Furniture
{
    Chair()
    {
        name="Chair";
    }
    void set_chair_data(String i,String p,String w,String color,String material,int d,int m,int y)
    {
        set_Furniture_data(i,p,w,color,material,d,m,y);
        addProduct(this);
    }

    @Override
    public void display_product() {
        System.out.println("Product ID : "+product_ID);
        System.out.println("Name : "+name);
        System.out.println("Price of product : "+price);
        System.out.println("Weight of product : "+weight);
        System.out.println("Category : "+category);
        System.out.println("Colour : "+Color);
        System.out.println("Material : "+Material);
    }
}

class Table extends Furniture
{
    Table()
    {
        name="Table";
    }
    void set_Table_data(String i, String p, String w, String color, String material,int d,int m,int y)
    {
        set_Furniture_data(i,p,w,color,material,d,m,y);
        addProduct(this);
    }

    @Override
    public void display_product() {
        System.out.println("Product ID : "+product_ID);
        System.out.println("Name : "+name);
        System.out.println("Price of product : "+price);
        System.out.println("Weight of product : "+weight);
        System.out.println("Category : "+category);
        System.out.println("Colour : "+Color);
        System.out.println("Material : "+Material);
    }


}