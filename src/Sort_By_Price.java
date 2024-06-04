import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sort_By_Price implements ActionListener {
    public JFrame by_price_frame = new JFrame("Sorted product list");

    JLabel price_text = new JLabel("BY PRICE PRODUCTS");

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

    static String s;
    Sort_By_Price(GUI temp,String s) {
        this.temp = temp;
        this.s=s;

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
        Back_Button();
    }

    void frame_setting() {
        by_price_frame.setBounds(500, 50, 500, 520);
        by_price_frame.setVisible(true);
        by_price_frame.setResizable(false);
        by_price_frame.setLayout(null);
        by_price_frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        by_price_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void price_text() {
        price_text.setBounds(130, 0, 500, 50);
        price_text.setFont(f1);
        by_price_frame.add(price_text);
    }

    void label() {
        your_balance.setBounds(400,0,200,50);
        by_price_frame.add(your_balance);

        balance.setBounds(400,20,200,50);
        balance.setText(String.valueOf(Main.b[Main.buy_index].balance));
        balance.setVisible(true);
        by_price_frame.add(balance);

        Id.setBounds(20,35,500,50);
        by_price_frame.add(Id);

        price.setBounds(20,65,500,50);
        by_price_frame.add(price);

        product_weight.setBounds(20,95,500,50);
        by_price_frame.add(product_weight);

        product_name.setBounds(20,125,500,50);
        by_price_frame.add(product_name);

        l1.setBounds(20,155,500,50);
        l1.setVisible(false);
        by_price_frame.add(l1);

        l2.setBounds(20,185,500,50);
        l2.setVisible(false);
        by_price_frame.add(l2);

        l3.setBounds(20,215,500,50);
        l3.setVisible(false);
        by_price_frame.add(l3);

        l4.setBounds(20,245,500,50);
        l4.setVisible(false);
        by_price_frame.add(l4);

        by_price_frame.add(DO);
        by_price_frame.add(M);
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

        tf_Id.setBounds(120, 50, 330, 25);
        tf_Id.setEditable(false);
        tf_Id.setText(Product_Filter.by_price[i].product_ID);
        tf_Id.setBorder(null);
        tf_Id.setBackground(Color.lightGray);
        by_price_frame.add(tf_Id);

        tf_price.setBounds(120, 80, 330, 25);
        tf_price.setText(String.valueOf(Product_Filter.by_price[i].price));
        tf_price.setEditable(false);
        tf_price.setBorder(null);
        tf_price.setBackground(Color.lightGray);
        by_price_frame.add(tf_price);

        tf_product_weight.setBounds(120, 110, 330, 25);
        tf_product_weight.setText(String.valueOf(Product_Filter.by_price[i].weight));
        tf_product_weight.setEditable(false);
        tf_product_weight.setBorder(null);
        tf_product_weight.setBackground(Color.lightGray);
        by_price_frame.add(tf_product_weight);

        tf_product_name.setBounds(120, 140, 330, 25);
        tf_product_name.setText(Product_Filter.by_price[i].name);
        tf_product_name.setEditable(false);
        tf_product_name.setBorder(null);
        tf_product_name.setBackground(Color.lightGray);
        by_price_frame.add(tf_product_name);

        t1.setBounds(120, 170, 330, 25);
        //t1.setVisible(false);
        t1.setEditable(false);
        t1.setBorder(null);
        t1.setBackground(Color.lightGray);
        by_price_frame.add(t1);

        t2.setBounds(120, 200, 330, 25);
        //t2.setVisible(false);
        t2.setEditable(false);
        t2.setBorder(null);
        t2.setBackground(Color.lightGray);
        by_price_frame.add(t2);

        t3.setBounds(120, 230, 330, 25);
        // t3.setVisible(false);
        t3.setEditable(false);
        t3.setBorder(null);
        t3.setBackground(Color.lightGray);
        by_price_frame.add(t3);

        t4.setBounds(120, 260, 330, 25);
        // t4.setVisible(false);
        t4.setEditable(false);
        t4.setBorder(null);
        t4.setBackground(Color.lightGray);
        by_price_frame.add(t4);


        tf_date_of_manufacture.setEditable(false);
        tf_date_of_manufacture.setBackground(Color.lightGray);
        tf_date_of_manufacture.setBorder(null);
        by_price_frame.add(tf_date_of_manufacture);


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
            t1.setText(String.valueOf(Product_Filter.by_price[i].laptop.memory));
            t2.setText(String.valueOf(Product_Filter.by_price[i].laptop.Battery_life));
            t3.setText(Product_Filter.by_price[i].laptop.company);

            DO.setBounds(20, 245, 500, 50);
            M.setBounds(20, 260, 500, 50);

            tf_date_of_manufacture.setBounds(120, 265, 330, 25);
            tf_date_of_manufacture.setText(Product_Filter.by_price[i].laptop.date_of_manufacture.getDay() + "/" + Product_Filter.by_price[i].laptop.date_of_manufacture.getMonth() + "/" + Product_Filter.by_price[i].laptop.date_of_manufacture.getYear());

            if (Product_Filter.by_price[i].laptop.installment != null) {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20, 285, 500, 50);
                by_price_frame.add(advance);

                tf_advance.setBounds(120, 295, 330, 25);
                by_price_frame.add(tf_advance);


                interest.setBounds(20, 315, 500, 50);
                by_price_frame.add(interest);

                tf_interest.setBounds(120, 325, 330, 25);
                by_price_frame.add(tf_interest);


                month_price.setBounds(20, 345, 500, 50);
                by_price_frame.add(month_price);

                tf_monthly_price.setBounds(120, 355, 330, 25);
                by_price_frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(Product_Filter.by_price[i].laptop.installment.advance));
                tf_interest.setText(String.valueOf(Product_Filter.by_price[i].laptop.installment.interest));
                tf_monthly_price.setText(String.valueOf(Product_Filter.by_price[i].laptop.installment.price_per_month));
            }

            if (Product_Filter.by_price[i].rent != null) {
                days.setVisible(true);
                tf_days.setVisible(true);

                days.setBounds(20, 285, 500, 50);
                by_price_frame.add(days);

                tf_days.setBounds(120, 295, 330, 25);
                by_price_frame.add(tf_days);
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
            t1.setText(String.valueOf(Product_Filter.by_price[i].mobile.storage));
            t2.setText(String.valueOf(Product_Filter.by_price[i].mobile.length));
            t3.setText(String.valueOf(Product_Filter.by_price[i].mobile.width));
            t4.setText(Product_Filter.by_price[i].mobile.company);

            DO.setBounds(20, 275, 500, 50);
            M.setBounds(20, 290, 500, 50);

            tf_date_of_manufacture.setBounds(120, 290, 330, 25);
            tf_date_of_manufacture.setText(Product_Filter.by_price[i].mobile.date_of_manufacture.getDay() + "/" + Product_Filter.by_price[i].mobile.date_of_manufacture.getMonth() + "/" + Product_Filter.by_price[i].mobile.date_of_manufacture.getYear());

            if (Product_Filter.by_price[i].mobile.installment != null) {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20, 315, 500, 50);
                by_price_frame.add(advance);

                tf_advance.setBounds(120, 325, 330, 25);
                by_price_frame.add(tf_advance);


                interest.setBounds(20, 345, 500, 50);
                by_price_frame.add(interest);

                tf_interest.setBounds(120, 355, 330, 25);
                by_price_frame.add(tf_interest);


                month_price.setBounds(20, 375, 500, 50);
                by_price_frame.add(month_price);

                tf_monthly_price.setBounds(120, 385, 330, 25);
                by_price_frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(Product_Filter.by_price[i].mobile.installment.advance));
                tf_interest.setText(String.valueOf(Product_Filter.by_price[i].mobile.installment.interest));
                tf_monthly_price.setText(String.valueOf(Product_Filter.by_price[i].mobile.installment.price_per_month));

            }

            if (Product_Filter.by_price[i].rent != null) {
                days.setVisible(true);
                tf_days.setVisible(true);

                days.setBounds(20, 315, 500, 50);
                by_price_frame.add(days);

                tf_days.setBounds(120, 325, 330, 25);
                by_price_frame.add(tf_days);
            }
        }
        else if (tf_product_name.getText().equals("Air conditioner"))
        {

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
            t1.setText(String.valueOf(Product_Filter.by_price[i].air_conditioner.power));
            t2.setText(String.valueOf(Product_Filter.by_price[i].air_conditioner.energy_efficiency));
            t3.setText(Product_Filter.by_price[i].air_conditioner.company);

            DO.setBounds(20, 245, 500, 50);
            M.setBounds(20, 260, 500, 50);

            tf_date_of_manufacture.setBounds(120, 265, 330, 25);
            tf_date_of_manufacture.setText(Product_Filter.by_price[i].air_conditioner.date_of_manufacture.getDay() + "/" + Product_Filter.by_price[i].air_conditioner.date_of_manufacture.getMonth() + "/" + Product_Filter.by_price[i].air_conditioner.date_of_manufacture.getYear());

            if (Product_Filter.by_price[i].air_conditioner.installment != null) {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20, 285, 500, 50);
                by_price_frame.add(advance);

                tf_advance.setBounds(120, 295, 330, 25);
                by_price_frame.add(tf_advance);


                interest.setBounds(20, 315, 500, 50);
                by_price_frame.add(interest);

                tf_interest.setBounds(120, 325, 330, 25);
                by_price_frame.add(tf_interest);


                month_price.setBounds(20, 345, 500, 50);
                by_price_frame.add(month_price);

                tf_monthly_price.setBounds(120, 355, 330, 25);
                by_price_frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(Product_Filter.by_price[i].air_conditioner.installment.advance));
                tf_interest.setText(String.valueOf(Product_Filter.by_price[i].air_conditioner.installment.interest));
                tf_monthly_price.setText(String.valueOf(Product_Filter.by_price[i].air_conditioner.installment.price_per_month));
            }

            if(Product_Filter.by_price[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                days.setBounds(20,285,500,50);
                by_price_frame.add(days);

                tf_days.setBounds(120,295,330,25);
                by_price_frame.add(tf_days);
            }

        }
        else if (tf_product_name.getText().equals("Car"))
        {

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
            t1.setText(Product_Filter.by_price[i].car.Brand);
            t2.setText(Product_Filter.by_price[i].car.Model);
            t3.setText(String.valueOf(Product_Filter.by_price[i].car.MaximumSpeed));
            t4.setText(Product_Filter.by_price[i].car.Color);

            DO.setBounds(20, 275, 500, 50);
            M.setBounds(20, 290, 500, 50);

            tf_date_of_manufacture.setBounds(120, 290, 330, 25);
            tf_date_of_manufacture.setText(Product_Filter.by_price[i].car.date_of_manufacture.getDay() + "/" + Product_Filter.by_price[i].car.date_of_manufacture.getMonth() + "/" + Product_Filter.by_price[i].car.date_of_manufacture.getYear());

            if (Product_Filter.by_price[i].car.installment != null) {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20, 315, 500, 50);
                by_price_frame.add(advance);

                tf_advance.setBounds(120, 325, 330, 25);
                by_price_frame.add(tf_advance);


                interest.setBounds(20, 345, 500, 50);
                by_price_frame.add(interest);

                tf_interest.setBounds(120, 355, 330, 25);
                by_price_frame.add(tf_interest);


                month_price.setBounds(20, 375, 500, 50);
                by_price_frame.add(month_price);

                tf_monthly_price.setBounds(120, 385, 330, 25);
                by_price_frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(Product_Filter.by_price[i].car.installment.advance));
                tf_interest.setText(String.valueOf(Product_Filter.by_price[i].car.installment.interest));
                tf_monthly_price.setText(String.valueOf(Product_Filter.by_price[i].car.installment.price_per_month));
            }

            if(Product_Filter.by_price[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                days.setBounds(20,315,500,50);
                by_price_frame.add(days);

                tf_days.setBounds(120,325,330,25);
                by_price_frame.add(tf_days);
            }

        }
        else if (tf_product_name.getText().equals("Bike"))
        {

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
            t1.setText(Product_Filter.by_price[i].bike.Brand);
            t2.setText(Product_Filter.by_price[i].bike.Model);
            t3.setText(String.valueOf(Product_Filter.by_price[i].bike.MaximumSpeed));
            t4.setText(Product_Filter.by_price[i].bike.Color);

            DO.setBounds(20, 275, 500, 50);
            M.setBounds(20, 290, 500, 50);

            tf_date_of_manufacture.setBounds(120, 290, 330, 25);
            tf_date_of_manufacture.setText(Product_Filter.by_price[i].bike.date_of_manufacture.getDay() + "/" + Product_Filter.by_price[i].bike.date_of_manufacture.getMonth() + "/" + Product_Filter.by_price[i].bike.date_of_manufacture.getYear());

            if (Product_Filter.by_price[i].bike.installment != null) {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20, 315, 500, 50);
                by_price_frame.add(advance);

                tf_advance.setBounds(120, 325, 330, 25);
                by_price_frame.add(tf_advance);


                interest.setBounds(20, 345, 500, 50);
                by_price_frame.add(interest);

                tf_interest.setBounds(120, 355, 330, 25);
                by_price_frame.add(tf_interest);


                month_price.setBounds(20, 375, 500, 50);
                by_price_frame.add(month_price);

                tf_monthly_price.setBounds(120, 385, 330, 25);
                by_price_frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(Product_Filter.by_price[i].installment.advance));
                tf_interest.setText(String.valueOf(Product_Filter.by_price[i].installment.interest));
                tf_monthly_price.setText(String.valueOf(Product_Filter.by_price[i].installment.price_per_month));
            }

            if(Product_Filter.by_price[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                days.setBounds(20,315,500,50);
                by_price_frame.add(days);

                tf_days.setBounds(120,325,330,25);
                by_price_frame.add(tf_days);
            }

        }
        else if (tf_product_name.getText().equals("Chair"))
        {

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
            t1.setText(Product_Filter.by_price[i].chair.Material);
            t2.setText(Product_Filter.by_price[i].chair.Color);

            DO.setBounds(20, 220, 500, 50);
            M.setBounds(20, 235, 500, 50);

            tf_date_of_manufacture.setBounds(120, 235, 330, 30);
            tf_date_of_manufacture.setText(Product_Filter.by_price[i].chair.date_of_manufacture.getDay() + "/" + Product_Filter.by_price[i].chair.date_of_manufacture.getMonth() + "/" + Product_Filter.by_price[i].chair.date_of_manufacture.getYear());

            if (Product_Filter.by_price[i].installment != null) {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20, 265, 500, 50);
                by_price_frame.add(advance);

                tf_advance.setBounds(120, 275, 330, 25);
                by_price_frame.add(tf_advance);


                interest.setBounds(20, 295, 500, 50);
                by_price_frame.add(interest);

                tf_interest.setBounds(120, 305, 330, 25);
                by_price_frame.add(tf_interest);


                month_price.setBounds(20, 325, 500, 50);
                by_price_frame.add(month_price);

                tf_monthly_price.setBounds(120, 335, 330, 25);
                by_price_frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(Product_Filter.by_price[i].installment.advance));
                tf_interest.setText(String.valueOf(Product_Filter.by_price[i].installment.interest));
                tf_monthly_price.setText(String.valueOf(Product_Filter.by_price[i].installment.price_per_month));
            }

            if(Product_Filter.by_price[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                days.setBounds(20,265,500,50);
                by_price_frame.add(days);

                tf_days.setBounds(120,275,330,25);
                by_price_frame.add(tf_days);
            }

        }
        else if (tf_product_name.getText().equals("Table"))
        {

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
            t1.setText(Product_Filter.by_price[i].table.Material);
            t2.setText(Product_Filter.by_price[i].table.Color);

            DO.setBounds(20, 220, 500, 50);
            M.setBounds(20, 235, 500, 50);

            tf_date_of_manufacture.setBounds(120, 235, 330, 30);
            tf_date_of_manufacture.setText(Product_Filter.by_price[i].table.date_of_manufacture.getDay() + "/" + Product_Filter.by_price[i].table.date_of_manufacture.getMonth() + "/" + Product_Filter.by_price[i].table.date_of_manufacture.getYear());

            if (Product_Filter.by_price[i].installment != null) {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20, 265, 500, 50);
                by_price_frame.add(advance);

                tf_advance.setBounds(120, 275, 330, 25);
                by_price_frame.add(tf_advance);


                interest.setBounds(20, 295, 500, 50);
                by_price_frame.add(interest);

                tf_interest.setBounds(120, 305, 330, 25);
                by_price_frame.add(tf_interest);


                month_price.setBounds(20, 325, 500, 50);
                by_price_frame.add(month_price);

                tf_monthly_price.setBounds(120, 335, 330, 25);
                by_price_frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(Product_Filter.by_price[i].installment.advance));
                tf_interest.setText(String.valueOf(Product_Filter.by_price[i].installment.interest));
                tf_monthly_price.setText(String.valueOf(Product_Filter.by_price[i].installment.price_per_month));
            }

            if(Product_Filter.by_price[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                days.setBounds(20,265,500,50);
                by_price_frame.add(days);

                tf_days.setBounds(120,275,330,25);
                by_price_frame.add(tf_days);
            }

        }
        else if (tf_product_name.getText().equals("Bed"))
        {

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
            t1.setText(Product_Filter.by_price[i].bed.Material);
            t2.setText(Product_Filter.by_price[i].bed.Color);

            DO.setBounds(20, 220, 500, 50);
            M.setBounds(20, 235, 500, 50);

            tf_date_of_manufacture.setBounds(120, 235, 330, 30);
            tf_date_of_manufacture.setText(Product_Filter.by_price[i].bed.date_of_manufacture.getDay() + "/" + Product_Filter.by_price[i].bed.date_of_manufacture.getMonth() + "/" + Product_Filter.by_price[i].bed.date_of_manufacture.getYear());

            if (Product_Filter.by_price[i].installment != null)
            {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20, 265, 500, 50);
                by_price_frame.add(advance);

                tf_advance.setBounds(120, 275, 330, 25);
                by_price_frame.add(tf_advance);


                interest.setBounds(20, 295, 500, 50);
                by_price_frame.add(interest);

                tf_interest.setBounds(120, 305, 330, 25);
                by_price_frame.add(tf_interest);


                month_price.setBounds(20, 325, 500, 50);
                by_price_frame.add(month_price);

                tf_monthly_price.setBounds(120, 335, 330, 25);
                by_price_frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(Product_Filter.by_price[i].installment.advance));
                tf_interest.setText(String.valueOf(Product_Filter.by_price[i].installment.interest));
                tf_monthly_price.setText(String.valueOf(Product_Filter.by_price[i].installment.price_per_month));
            }

            if(Product_Filter.by_price[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                days.setBounds(20,265,500,50);
                by_price_frame.add(days);

                tf_days.setBounds(120,275,330,25);
                by_price_frame.add(tf_days);
            }

        }
    }
    private void buy_Button() {
        buy_product.setBounds(75, 415, 100, 40);
        buy_product.addActionListener(this);
        by_price_frame.add(buy_product);
    }

    private void back_Button() {
        back.setBounds(185, 415, 100, 40);
        back.addActionListener(this);
        by_price_frame.add(back);
    }

    private void next_Button() {
        next.setBounds(295, 415, 100, 40);
        by_price_frame.add(next);
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
        if(s.equals("sell"))
        {
            index_text.setText("Product "+(i+1)+" of "+Main.active_product_index);
        }
        else if(s.equals("rent"))
        {
            index_text.setText("Product "+(i+1)+" of "+Main.active_rent_index);
        }

        by_price_frame.add(index_text);

    }

    public void next_button_func()
    {
        next.setEnabled(true);
        if(s.equals("sell")) {
            if ((i + 1) == Main.active_product_index) {
                next.setEnabled(false);
            }
        }
        else if(s.equals("rent")) {
            if ((i + 1) == Main.active_rent_index) {
                next.setEnabled(false);
            }
        }
    }

    private void Back_Button(){
        ImageIcon back=new ImageIcon("E:\\back.jpeg");
        Image b=back.getImage();
        Image b1=b.getScaledInstance(20,20,10);
        back.setImage(b1);

        back_b=new JButton(back);
        back_b.setBounds(10,10,30,30);
        back_b.setBackground(Color.lightGray);
        back_b.setBorderPainted(false);
        back_b.addActionListener(this);
        by_price_frame.add(back_b);
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
            if(Product_Filter.by_price[i].rent!=null)
            {
                if(tf_days.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Enter number of days");
                }
                else
                {
                    Product_Filter.by_price[i].rent.setNo_of_days(tf_days.getText());
                    Product_Filter.by_price[i].setPrice(Float.parseFloat(tf_days.getText())*Float.parseFloat(tf_price.getText()));
                    Product_Filter.Product_index=i;
                    new Buy_Product(temp,Product_Filter.by_price[i].product_ID,tf_days.getText(),s);
                    by_price_frame.dispose();
                }
            }
            else
            {
                Product_Filter.Product_index=i;
                new Buy_Product(temp,Product_Filter.by_price[i].product_ID,"0",s);
                by_price_frame.dispose();
            }

        }
        else if(e.getSource().equals(back_b))
        {
            by_price_frame.dispose();
            Product_Filter.f_frame.setVisible(true);
        }
    }
}