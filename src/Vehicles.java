public class Vehicles extends Product{
    String Brand;
    String Model;
    float MaximumSpeed;
    String Color;

    Vehicles()
    {
        Brand="NULL";
        Model="NULL";
        MaximumSpeed=0;
        Color="NULL";
        category="Vehicle";
    }

    public void set_Vehicle_data(String i,String p,String w,String brand, String model,String maximumSpeed,String color,int d,int m,int y)
    {
        set_product_data(i,p,w,category,d,m,y);
        setBrand(brand);
        setModel(model);
        setMaximumSpeed(Float.parseFloat(maximumSpeed));
        setColor(color);
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public void setColor(String color) {
        Color = color;
    }


    public void setMaximumSpeed(Float maximumSpeed) {
        MaximumSpeed = maximumSpeed;
    }

    public void setModel(String model) {
        Model = model;
    }
}

class Car extends Vehicles
{
    Car(){
        name="Car";
    }
    public void set_Car_data(String i,String p,String w,String brand,String model ,String maximum_speed,String color,int d,int m,int y)
    {
        set_Vehicle_data(i,p,w,brand,model,maximum_speed,color,d,m,y);
        addProduct(this);
    }

    @Override
    public void display_product() {
        System.out.println("Product ID : "+product_ID);
        System.out.println("Name : "+name);
        System.out.println("Price of product : "+price);
        System.out.println("Weight of product : "+weight);
        System.out.println("Category : "+category);
        System.out.println("Brand : "+Brand);
        System.out.println("Model : "+Model);
        System.out.println("Maximum Speed : "+MaximumSpeed);
        System.out.println("Colour : "+Color);
    }
}

class Bike extends Vehicles
{
    Bike()
    {
        name="Bike";
    }
    public void set_Bike_data(String i,String p,String w,String brand,String model ,String maximum_speed,String color,int d,int m,int y)
    {
        set_Vehicle_data(i,p,w,brand,model,maximum_speed,color,d,m,y);
        addProduct(this);
    }

    @Override
    public void display_product() {
        System.out.println("Product ID : "+product_ID);
        System.out.println("Name : "+name);
        System.out.println("Price of product : "+price);
        System.out.println("Weight of product : "+weight);
        System.out.println("Category : "+category);
        System.out.println("Brand : "+Brand);
        System.out.println("Model : "+Model);
        System.out.println("Maximum Speed : "+MaximumSpeed);
        System.out.println("Colour : "+Color);
    }
}