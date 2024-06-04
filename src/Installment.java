public class Installment {
    float advance;
    float interest;
    float price_per_month;

    Installment()
    {
        advance=0;
        interest=0;
        price_per_month=0;
    }

    public void set_inst_data(float a,float i,float p)
    {
        advance=a;
        interest=i;
        price_per_month=p;
    }

    public float getAdvance() {
        return advance;
    }

    public float getInterest() {
        return interest;
    }

    public float getPrice_per_month() {
        return price_per_month;
    }


}
