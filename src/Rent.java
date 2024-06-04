public class Rent {

    public float price_per_day;
    public int no_of_days;

    public Rent()
    {
        price_per_day=0;
        no_of_days=0;
    }

    public void setNo_of_days(String no_of_days)
    {
        this.no_of_days = Integer.parseInt(no_of_days);
    }

    public void setPrice_per_day(String price_per_day)
    {
        this.price_per_day = Float.parseFloat(price_per_day);
    }

    public int getNo_of_days()
    {
        return no_of_days;
    }

    public float getPrice_per_day()
    {
        return price_per_day;
    }
}
