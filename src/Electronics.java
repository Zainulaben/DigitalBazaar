public class Electronics extends Product {
    protected String company;
    Electronics() {
        price = 0;
        weight = 0;
        msg_count = 0;
        category = "Electronics";
        company = "NULL";
    }

    void setCompany(String c) {
        company = c;
    }

    String getCompany() {
        return company;
    }

    public void set_electronics_data(String i, String  p, String  w, String comp,int d,int m,int y) {
        set_product_data(i, p, w, category,d,m,y);
        setCompany(comp);
    }


}

class Laptop extends Electronics{
    String memory;
    float Battery_life;


    Laptop() {
        memory = "0GB";
        Battery_life = 0;
        name="Laptop";
    }

    void set_memory(String m) {
        memory = m;
    }

    void set_battery_life(float b) {
        Battery_life = b;
    }

    void set_laptop_data(String i, String p,  String comp,String w, String mem, String b,int d,int m,int y) {
        set_electronics_data(i, p,w, comp,d,m,y);
        set_memory(mem);
        set_battery_life(Float.parseFloat(b));
        date_of_manufacture.Set_ALL_Data_of_Date(d,m,y);
        addProduct(this);
    }

    String getMemory() {
        return memory;
    }

    public float getBattery_life() {
        return Battery_life;
    }



    @Override
    public void display_product() {
        System.out.println("Product ID : "+product_ID);
        System.out.println("Name : "+name);
        System.out.println("Price of product : "+price);
        System.out.println("Weight of product : "+weight);
        System.out.println("Category : "+category);
        System.out.println("Company" + company);
        System.out.println("Memory" + memory);
        System.out.println("Battery life" + Battery_life);
        if(installment!=null)
        {
            System.out.println("\nInstallments : ");
            System.out.println("Advance : "+installment.getAdvance());
            System.out.println("Interest : "+installment.getInterest());
            System.out.println("Monthly price : "+installment.getPrice_per_month());
        }
    }
}

class Mobile extends Electronics {
    float storage;
    float length;
    float width;

    public Mobile() {
        storage = 0;
        length = 0;
        width = 0;
        name="Mobile";
    }

    public void set_Mobile_data(String i, String p, String w, String comp, String s, String l, String width,int d,int m,int y) {
        set_electronics_data(i, p, w, comp,d,m,y);
        setLength(Float.parseFloat(l));
        setStorage(Float.parseFloat(s));
        setWidth(Float.parseFloat(width));
        addProduct(this);
    }

    public void setStorage(float storage) {
        this.storage = storage;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public void display_product() {
        System.out.println("Product ID : "+product_ID);
        System.out.println("Name : "+name);
        System.out.println("Price of product : "+price);
        System.out.println("Weight of product : "+weight);
        System.out.println("Category : "+category);
        System.out.println("Company" + company);
        System.out.println("Mobile Storage : "+storage);
        System.out.println("Mobile Length : "+length);
        System.out.println("Mobile Width : "+width);
        if(installment!=null)
        {
            System.out.println("\nInstallments : ");
            System.out.println("Advance : "+installment.getAdvance());
            System.out.println("Interest : "+installment.getInterest());
            System.out.println("Monthly price : "+installment.getPrice_per_month());
        }

    }
}


class Air_conditioner extends Electronics
{
    float power;
    float energy_efficiency;

    public Air_conditioner()
    {
        power=0;
        energy_efficiency=0;
        name="Air conditioner";
    }

    public void set_Air_Conditioner_data(String i, String p, String w, String comp,String power,String energy,int d,int m,int y)
    {
        set_electronics_data(i, p, w, comp,d,m,y);
        setEnergy_efficiency(Float.parseFloat(energy));
        setPower(Float.parseFloat(power));
        addProduct(this);
    }

    public void setEnergy_efficiency(float energy_efficiency) {
        this.energy_efficiency = energy_efficiency;
    }

    public void setPower(float power) {
        this.power = power;
    }

    @Override
    public void display_product() {
        System.out.println("Product ID : "+product_ID);
        System.out.println("Name : "+name);
        System.out.println("Price of product : "+price);
        System.out.println("Weight of product : "+weight);
        System.out.println("Category : "+category);
        System.out.println("Company" + company);
        System.out.println("Power : "+power);
        System.out.println("Energy efficiency : "+energy_efficiency);
        if(installment!=null)
        {
            System.out.println("\nInstallments : ");
            System.out.println("Advance : "+installment.getAdvance());
            System.out.println("Interest : "+installment.getInterest());
            System.out.println("Monthly price : "+installment.getPrice_per_month());
        }

    }
}