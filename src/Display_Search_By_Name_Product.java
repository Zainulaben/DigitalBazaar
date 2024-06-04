import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display_Search_By_Name_Product implements ActionListener {
    public JFrame by_name_frame = new JFrame("By name products");

    JLabel name_text = new JLabel("BY NAME PRODUCTS");

    JLabel Id = new JLabel("Product ID : ");
    JTextField tf_Id = new JTextField(20);

    JLabel price = new JLabel("Price : ");
    JTextField tf_price = new JTextField(20);

    JLabel product_weight = new JLabel("Weight : ");
    JTextField tf_product_weight = new JTextField(20);

    JLabel product_name = new JLabel("Name : ");
    JTextField tf_product_name = new JTextField(20);

    JLabel DO=new JLabel("Date Of");
    JLabel M=new JLabel("Manufacture : ");

    JTextField tf_date_of_manufacture=new JTextField(20);
    JLabel index_text=new JLabel();

    JLabel l1 = new JLabel();
    JLabel l2 = new JLabel();
    JLabel l3 = new JLabel();
    JLabel l4 = new JLabel();

    JTextField t1 = new JTextField(20);
    JTextField t2 = new JTextField(20);
    JTextField t3 = new JTextField(20);
    JTextField t4 = new JTextField(20);

    JLabel advance=new JLabel("Advance : ");
    JTextField tf_advance=new JTextField(20);

    JLabel interest =new JLabel("Interest : ");
    JTextField tf_interest=new JTextField(20);
    JLabel month_price=new JLabel("Monthly_price : ");
    JTextField tf_monthly_price=new JTextField(20);

    JLabel days=new JLabel("No. of Days : ");
    JTextField tf_days=new JTextField(20);


    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);

    JButton back = new JButton("Back");
    JButton next = new JButton("Next");
    JButton buy_product=new JButton("Buy");

    JLabel your_balance=new JLabel("Your balance");
    JLabel balance=new JLabel();
    JButton back_b;

    GUI temp;
    static int i = 0;

    Product []by_name;
    int select_name_count;
    static String s;

    Display_Search_By_Name_Product(GUI temp,String s,Product []p,int n) {
        this.temp = temp;
        this.s=s;
        by_name=p;
        select_name_count=n;

        if(s.equals("rent"))
        {
            buy_product.setText("Rent");
        }

        frame_setting();
        price_text();
        label();
        field();
        back_Button();
        next_Button();
        back_button_func();
        next_button_func();
        buy_Button();
        back_button();

    }

    void frame_setting() {
        by_name_frame.setBounds(500, 50, 500, 520);
        by_name_frame.setVisible(true);
        by_name_frame.setResizable(false);
        by_name_frame.setLayout(null);
        by_name_frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        by_name_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void price_text() {
        name_text.setBounds(130, 0, 500, 50);
        name_text.setFont(f1);
        by_name_frame.add(name_text);
    }

    void label() {
        your_balance.setBounds(400,0,200,50);
        by_name_frame.add(your_balance);

        balance.setBounds(400,20,200,50);
        balance.setText(String.valueOf(Main.b[Main.buy_index].balance));

        by_name_frame.add(balance);

        Id.setBounds(20,35,500,50);
        by_name_frame.add(Id);

        price.setBounds(20,65,500,50);
        by_name_frame.add(price);

        if(s.equals("rent"))
        {
            price.setText("Price Per Day : ");
        }

        product_weight.setBounds(20,95,500,50);
        by_name_frame.add(product_weight);

        product_name.setBounds(20,125,500,50);
        by_name_frame.add(product_name);

        l1.setBounds(20,155,500,50);
        l1.setVisible(false);
        by_name_frame.add(l1);

        l2.setBounds(20,185,500,50);
        l2.setVisible(false);
        by_name_frame.add(l2);

        l3.setBounds(20,215,500,50);
        l3.setVisible(false);
        by_name_frame.add(l3);

        l4.setBounds(20,245,500,50);
        l4.setVisible(false);
        by_name_frame.add(l4);


        by_name_frame.add(DO);
        by_name_frame.add(M);
    }

    void field() {

        advance.setVisible(false);
        interest.setVisible(false);
        month_price.setVisible(false);
        days.setVisible(false);

        tf_advance.setVisible(false);
        tf_advance.setEditable(false);
        tf_advance.setBorder(null);
        tf_advance.setBackground(Color.lightGray);

        tf_interest.setVisible(false);
        tf_interest.setEditable(false);
        tf_interest.setBorder(null);
        tf_interest.setBackground(Color.lightGray);

        tf_monthly_price.setVisible(false);
        tf_monthly_price.setEditable(false);
        tf_monthly_price.setBorder(null);
        tf_monthly_price.setBackground(Color.lightGray);

        tf_days.setVisible(false);

        tf_Id.setBounds(140,50,330,25);
        tf_Id.setEditable(false);
        tf_Id.setText(by_name[i].product_ID);
        tf_Id.setBorder(null);
        tf_Id.setBackground(Color.lightGray);
        by_name_frame.add(tf_Id);

        tf_price.setBounds(140,80,330,25);
        tf_price.setText(String.valueOf(by_name[i].price));
        if(s.equals("rent"))
        {

            tf_price.setText(String.valueOf(by_name[i].rent.price_per_day));
        }
        tf_price.setEditable(false);
        tf_price.setBorder(null);
        tf_price.setBackground(Color.lightGray);
        by_name_frame.add(tf_price);

        tf_product_weight.setBounds(140,110,330,25);
        tf_product_weight.setText(String.valueOf(by_name[i].weight));
        tf_product_weight.setEditable(false);
        tf_product_weight.setBorder(null);
        tf_product_weight.setBackground(Color.lightGray);
        by_name_frame.add(tf_product_weight);

        tf_product_name.setBounds(140,140,330,25);
        tf_product_name.setText(by_name[i].name);
        tf_product_name.setEditable(false);
        tf_product_name.setBorder(null);
        tf_product_name.setBackground(Color.lightGray);
        by_name_frame.add(tf_product_name);

        t1.setBounds(140,170,330,25);
        t1.setEditable(false);
        t1.setBorder(null);
        t1.setBackground(Color.lightGray);
        by_name_frame.add(t1);

        t2.setBounds(140,200,330,25);
        //t2.setVisible(false);
        t2.setEditable(false);
        t2.setBorder(null);
        t2.setBackground(Color.lightGray);
        by_name_frame.add(t2);

        t3.setBounds(140,230,330,25);
        // t3.setVisible(false);
        t3.setEditable(false);
        t3.setBorder(null);
        t3.setBackground(Color.lightGray);
        by_name_frame.add(t3);

        t4.setBounds(140,260,330,25);
        // t4.setVisible(false);
        t4.setEditable(false);
        t4.setBorder(null);
        t4.setBackground(Color.lightGray);
        by_name_frame.add(t4);


        tf_date_of_manufacture.setEditable(false);
        tf_date_of_manufacture.setBackground(Color.lightGray);
        tf_date_of_manufacture.setBorder(null);
        by_name_frame.add(tf_date_of_manufacture);


        if (tf_product_name.getText().equals("Laptop")) {

            l1.setVisible(true);
            l2.setVisible(true);
            l3.setVisible(true);
            l4.setVisible(false);
            l1.setText("Memory : ");
            l2.setText("Battery Life : ");
            l3.setText("Company : ");


            t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(true);
            t4.setVisible(false);
            t1.setText(String.valueOf(by_name[i].laptop.memory));
            t2.setText(String.valueOf(by_name[i].laptop.Battery_life));
            t3.setText(by_name[i].laptop.company);

            DO.setBounds(20, 245, 500, 50);
            M.setBounds(20,260,500,50);

            tf_date_of_manufacture.setBounds(140,265,330,25);
            tf_date_of_manufacture.setText(by_name[i].laptop.date_of_manufacture.getDay()+"/"+by_name[i].laptop.date_of_manufacture.getMonth()+"/"+by_name[i].laptop.date_of_manufacture.getYear());

            if(by_name[i].laptop.installment!=null)
            {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20,285,500,50);
                by_name_frame.add(advance);

                tf_advance.setBounds(140,295,330,25);
                by_name_frame.add(tf_advance);

                interest.setBounds(20,315,500,50);
                by_name_frame.add(interest);

                tf_interest.setBounds(140,325,330,25);
                by_name_frame.add(tf_interest);

                month_price.setBounds(20,345,500,50);
                by_name_frame.add(month_price);

                tf_monthly_price.setBounds(140,355,330,25);
                by_name_frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(by_name[i].laptop.installment.advance));
                tf_interest.setText(String.valueOf(by_name[i].laptop.installment.interest));
                tf_monthly_price.setText(String.valueOf(by_name[i].laptop.installment.price_per_month));
            }

            if(by_name[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                days.setBounds(20,285,500,50);
                by_name_frame.add(days);

                tf_days.setBounds(140,295,330,25);
                by_name_frame.add(tf_days);
            }

        } else if (tf_product_name.getText().equals("Mobile")) {

            l1.setVisible(true);
            l2.setVisible(true);
            l3.setVisible(true);
            l4.setVisible(true);
            l1.setText("Storage : ");
            l2.setText("Length : ");
            l3.setText("Width : ");
            l4.setText("Company : ");

            t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(true);
            t4.setVisible(true);
            t1.setText(String.valueOf(by_name[i].mobile.storage));
            t2.setText(String.valueOf(by_name[i].mobile.length));
            t3.setText(String.valueOf(by_name[i].mobile.width));
            t4.setText(by_name[i].mobile.company);

            DO.setBounds(20, 275, 500, 50);
            M.setBounds(20,290,500,50);

            tf_date_of_manufacture.setBounds(140,290,330,25);
            tf_date_of_manufacture.setText(by_name[i].mobile.date_of_manufacture.getDay()+"/"+by_name[i].mobile.date_of_manufacture.getMonth()+"/"+by_name[i].mobile.date_of_manufacture.getYear());

            if(by_name[i].mobile.installment!=null)
            {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20,315,500,50);
                by_name_frame.add(advance);

                tf_advance.setBounds(140,325,330,25);
                by_name_frame.add(tf_advance);

                interest.setBounds(20,345,500,50);
                by_name_frame.add(interest);

                tf_interest.setBounds(140,355,330,25);
                by_name_frame.add(tf_interest);

                month_price.setBounds(20,375,500,50);
                by_name_frame.add(month_price);

                tf_monthly_price.setBounds(140,385,330,25);
                by_name_frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(by_name[i].mobile.installment.advance));
                tf_interest.setText(String.valueOf(by_name[i].mobile.installment.interest));
                tf_monthly_price.setText(String.valueOf(by_name[i].mobile.installment.price_per_month));
            }

            if(by_name[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                days.setBounds(20,315,500,50);
                by_name_frame.add(days);

                tf_days.setBounds(140,325,330,25);
                by_name_frame.add(tf_days);
            }

        } else if (tf_product_name.getText().equals("Air conditioner")) {

            l1.setVisible(true);
            l2.setVisible(true);
            l3.setVisible(true);
            l4.setVisible(false);
            l1.setText("Power : ");
            l2.setText("Energy Efficiency : ");
            l3.setText("Company : ");

            t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(true);
            t4.setVisible(false);
            t1.setText(String.valueOf(by_name[i].air_conditioner.power));
            t2.setText(String.valueOf(by_name[i].air_conditioner.energy_efficiency));
            t3.setText(by_name[i].air_conditioner.company);

            DO.setBounds(20, 245, 500, 50);
            M.setBounds(20,260,500,50);

            tf_date_of_manufacture.setBounds(140,265,330,25);
            tf_date_of_manufacture.setText(by_name[i].air_conditioner.date_of_manufacture.getDay()+"/"+by_name[i].air_conditioner.date_of_manufacture.getMonth()+"/"+by_name[i].air_conditioner.date_of_manufacture.getYear());

            if(by_name[i].air_conditioner.installment!=null)
            {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20,285,500,50);
                by_name_frame.add(advance);

                tf_advance.setBounds(140,295,330,25);
                by_name_frame.add(tf_advance);

                interest.setBounds(20,315,500,50);
                by_name_frame.add(interest);

                tf_interest.setBounds(140,325,330,25);
                by_name_frame.add(tf_interest);

                month_price.setBounds(20,345,500,50);
                by_name_frame.add(month_price);

                tf_monthly_price.setBounds(140,355,330,25);
                by_name_frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(by_name[i].air_conditioner.installment.advance));
                tf_interest.setText(String.valueOf(by_name[i].air_conditioner.installment.interest));
                tf_monthly_price.setText(String.valueOf(by_name[i].air_conditioner.installment.price_per_month));
            }

            if(by_name[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                days.setBounds(20,285,500,50);
                by_name_frame.add(days);

                tf_days.setBounds(140,295,330,25);
                by_name_frame.add(tf_days);
            }

        } else if (tf_product_name.getText().equals("Car")) {

            l1.setVisible(true);
            l2.setVisible(true);
            l3.setVisible(true);
            l4.setVisible(true);
            l1.setText("Brand : ");
            l2.setText("Model : ");
            l3.setText("Maximum Speed : ");
            l4.setText("Colour : ");

            t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(true);
            t4.setVisible(true);
            t1.setText(by_name[i].car.Brand);
            t2.setText(by_name[i].car.Model);
            t3.setText(String.valueOf(by_name[i].car.MaximumSpeed));
            t4.setText(by_name[i].car.Color);

            DO.setBounds(20, 275, 500, 50);
            M.setBounds(20,290,500,50);

            tf_date_of_manufacture.setBounds(140,290,330,25);
            tf_date_of_manufacture.setText(by_name[i].car.date_of_manufacture.getDay()+"/"+by_name[i].car.date_of_manufacture.getMonth()+"/"+by_name[i].car.date_of_manufacture.getYear());

            if(by_name[i].car.installment!=null)
            {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20,315,500,50);
                by_name_frame.add(advance);

                tf_advance.setBounds(140,325,330,25);
                by_name_frame.add(tf_advance);



                interest.setBounds(20,345,500,50);
                by_name_frame.add(interest);

                tf_interest.setBounds(140,355,330,25);
                by_name_frame.add(tf_interest);



                month_price.setBounds(20,375,500,50);
                by_name_frame.add(month_price);

                tf_monthly_price.setBounds(140,385,330,25);
                by_name_frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(by_name[i].installment.advance));
                tf_interest.setText(String.valueOf(by_name[i].installment.interest));
                tf_monthly_price.setText(String.valueOf(by_name[i].installment.price_per_month));
            }

            if(by_name[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                days.setBounds(20,315,500,50);
                by_name_frame.add(days);

                tf_days.setBounds(140,325,330,25);
                by_name_frame.add(tf_days);
            }

        } else if (tf_product_name.getText().equals("Bike")) {

            l1.setVisible(true);
            l2.setVisible(true);
            l3.setVisible(true);
            l4.setVisible(true);
            l1.setText("Brand : ");
            l2.setText("Model : ");
            l3.setText("Maximum Speed:");
            l4.setText("Colour : ");

            t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(true);
            t4.setVisible(true);
            t1.setText(by_name[i].bike.Brand);
            t2.setText(by_name[i].bike.Model);
            t3.setText(String.valueOf(by_name[i].bike.MaximumSpeed));
            t4.setText(by_name[i].bike.Color);

            DO.setBounds(20, 275, 500, 50);
            M.setBounds(20,290,500,50);

            tf_date_of_manufacture.setBounds(140,290,330,25);
            tf_date_of_manufacture.setText(by_name[i].bike.date_of_manufacture.getDay()+"/"+by_name[i].bike.date_of_manufacture.getMonth()+"/"+by_name[i].bike.date_of_manufacture.getYear());

            if(by_name[i].bike.installment!=null)
            {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20,315,500,50);
                by_name_frame.add(advance);

                tf_advance.setBounds(140,325,330,25);
                by_name_frame.add(tf_advance);



                interest.setBounds(20,345,500,50);
                by_name_frame.add(interest);

                tf_interest.setBounds(140,355,330,25);
                by_name_frame.add(tf_interest);



                month_price.setBounds(20,375,500,50);
                by_name_frame.add(month_price);

                tf_monthly_price.setBounds(140,385,330,25);
                by_name_frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(by_name[i].installment.advance));
                tf_interest.setText(String.valueOf(by_name[i].installment.interest));
                tf_monthly_price.setText(String.valueOf(by_name[i].installment.price_per_month));
            }

            if(by_name[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                days.setBounds(20,315,500,50);
                by_name_frame.add(days);

                tf_days.setBounds(140,325,330,25);
                by_name_frame.add(tf_days);
            }

        } else if (tf_product_name.getText().equals("Chair")) {

            l1.setVisible(true);
            l2.setVisible(true);
            l3.setVisible(false);
            l4.setVisible(false);
            l1.setText("Material : ");
            l2.setText("Colour : ");

            t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(false);
            t4.setVisible(false);
            t1.setText(by_name[i].chair.Material);
            t2.setText(by_name[i].chair.Color);

            DO.setBounds(20, 220, 500, 50);
            M.setBounds(20,235,500,50);

            tf_date_of_manufacture.setBounds(140,235,330,30);
            tf_date_of_manufacture.setText(by_name[i].chair.date_of_manufacture.getDay()+"/"+by_name[i].chair.date_of_manufacture.getMonth()+"/"+by_name[i].chair.date_of_manufacture.getYear());
            if(by_name[i].installment!=null)
            {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20,265,500,50);
                by_name_frame.add(advance);

                tf_advance.setBounds(140,275,330,25);
                by_name_frame.add(tf_advance);



                interest.setBounds(20,295,500,50);
                by_name_frame.add(interest);

                tf_interest.setBounds(140,305,330,25);
                by_name_frame.add(tf_interest);



                month_price.setBounds(20,325,500,50);
                by_name_frame.add(month_price);

                tf_monthly_price.setBounds(140,335,330,25);
                by_name_frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(by_name[i].installment.advance));
                tf_interest.setText(String.valueOf(by_name[i].installment.interest));
                tf_monthly_price.setText(String.valueOf(by_name[i].installment.price_per_month));
            }

            if(by_name[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                days.setBounds(20,265,500,50);
                by_name_frame.add(days);

                tf_days.setBounds(140,275,330,25);
                by_name_frame.add(tf_days);
            }

        } else if (tf_product_name.getText().equals("Table")) {

            l1.setVisible(true);
            l2.setVisible(true);
            l3.setVisible(false);
            l4.setVisible(false);
            l1.setText("Material : ");
            l2.setText("Colour : ");

            t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(false);
            t4.setVisible(false);
            t1.setText(by_name[i].table.Material);
            t2.setText(by_name[i].table.Color);

            DO.setBounds(20, 220, 500, 50);
            M.setBounds(20,235,500,50);

            tf_date_of_manufacture.setBounds(140,235,330,30);
            tf_date_of_manufacture.setText(by_name[i].table.date_of_manufacture.getDay()+"/"+by_name[i].table.date_of_manufacture.getMonth()+"/"+by_name[i].table.date_of_manufacture.getYear());

            if(by_name[i].installment!=null)
            {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20,265,500,50);
                by_name_frame.add(advance);

                tf_advance.setBounds(140,275,330,25);
                by_name_frame.add(tf_advance);



                interest.setBounds(20,295,500,50);
                by_name_frame.add(interest);

                tf_interest.setBounds(140,305,330,25);
                by_name_frame.add(tf_interest);



                month_price.setBounds(20,325,500,50);
                by_name_frame.add(month_price);

                tf_monthly_price.setBounds(140,335,330,25);
                by_name_frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(by_name[i].installment.advance));
                tf_interest.setText(String.valueOf(by_name[i].installment.interest));
                tf_monthly_price.setText(String.valueOf(by_name[i].installment.price_per_month));
            }

            if(by_name[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                days.setBounds(20,265,500,50);
                by_name_frame.add(days);

                tf_days.setBounds(140,275,330,25);
                by_name_frame.add(tf_days);
            }

        } else if (tf_product_name.getText().equals("Bed")) {

            l1.setVisible(true);
            l2.setVisible(true);
            l3.setVisible(false);
            l4.setVisible(false);
            l1.setText("Material : ");
            l2.setText("Colour : ");

            t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(false);
            t4.setVisible(false);
            t1.setText(by_name[i].bed.Material);
            t2.setText(by_name[i].bed.Color);

            DO.setBounds(20, 220, 500, 50);
            M.setBounds(20,235,500,50);

            tf_date_of_manufacture.setBounds(140,235,330,30);
            tf_date_of_manufacture.setText(by_name[i].bed.date_of_manufacture.getDay()+"/"+by_name[i].bed.date_of_manufacture.getMonth()+"/"+by_name[i].bed.date_of_manufacture.getYear());

            if(by_name[i].installment!=null)
            {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20,265,500,50);
                by_name_frame.add(advance);

                tf_advance.setBounds(140,275,330,25);
                by_name_frame.add(tf_advance);



                interest.setBounds(20,295,500,50);
                by_name_frame.add(interest);

                tf_interest.setBounds(140,305,330,25);
                by_name_frame.add(tf_interest);



                month_price.setBounds(20,325,500,50);
                by_name_frame.add(month_price);

                tf_monthly_price.setBounds(140,335,330,25);
                by_name_frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(by_name[i].installment.advance));
                tf_interest.setText(String.valueOf(by_name[i].installment.interest));
                tf_monthly_price.setText(String.valueOf(by_name[i].installment.price_per_month));
            }

            if(by_name[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                days.setBounds(20,265,500,50);
                by_name_frame.add(days);

                tf_days.setBounds(140,275,330,25);
                by_name_frame.add(tf_days);
            }

        }
    }

    private void buy_Button() {
        buy_product.setBounds(75, 415, 100, 40);
        buy_product.addActionListener(this);
        by_name_frame.add(buy_product);
    }

    private void back_Button() {
        back.setBounds(185, 415, 100, 40);
        back.addActionListener(this);
        by_name_frame.add(back);
    }

    private void next_Button() {
        next.setBounds(295, 415, 100, 40);
        by_name_frame.add(next);
        next.addActionListener(this);
    }

    public void back_button_func()
    {
        back.setEnabled(true);
        if(i==0)
        {
            back.setEnabled(false);
        }

        index_text.setBounds(200, 445, 100, 40);
        index_text.setText("Product "+(i+1)+" of "+select_name_count);
        by_name_frame.add(index_text);

    }

    public void next_button_func()
    {
        next.setEnabled(true);
        if((i+1)==select_name_count)
        {
            next.setEnabled(false);
        }
    }
    private void back_button(){
        ImageIcon back=new ImageIcon("back.png");
        Image b=back.getImage();
        Image b1=b.getScaledInstance(20,20,10);
        back.setImage(b1);

        back_b=new JButton(back);
        back_b.setBounds(10,10,30,30);
        back_b.setBackground(Color.lightGray);
        back_b.setBorderPainted(false);
        back_b.addActionListener(this);
        by_name_frame.add(back_b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(back)) {
            i--;
            field();
            back_button_func();
            next_button_func();
        }
        else if(e.getSource().equals(next))
        {
            i++;
            field();
            back_button_func();
            next_button_func();
        }
        else if(e.getSource().equals(buy_product))
        {
            if(by_name[i].rent!=null)
            {
                if(tf_days.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Enter number of days");
                }
                else
                {
                    Product_Filter.Product_index=i;
                    new Buy_Product(temp,by_name[i].product_ID,tf_days.getText(),s);
                    by_name_frame.dispose();
                }
            }
            else
            {
                Product_Filter.Product_index=i;
                new Buy_Product(temp,by_name[i].product_ID,"0",s);
                by_name_frame.dispose();
            }
        }
        else if(e.getSource().equals(back_b))
        {
            by_name_frame.dispose();
            Product_Category.p_frame.setVisible(true);
        }
    }
}