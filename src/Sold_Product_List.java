import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sold_Product_List implements ActionListener {
    public JFrame sold_frame = new JFrame("Edit Product");

    JLabel sold_text = new JLabel("SOLD PRODUCTS");

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


    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);

    JButton back = new JButton("Back");
    JButton next = new JButton("Next");

    JLabel advance=new JLabel("Advance : ");
    JTextField tf_advance=new JTextField(20);

    JLabel interest =new JLabel("Interest : ");
    JTextField tf_interest=new JTextField(20);
    JLabel month_price=new JLabel("Monthly_price : ");
    JTextField tf_monthly_price=new JTextField(20);

    JButton back_b;

    GUI temp;
    static int i = 0;
    String s;
    Sold_Product_List(GUI temp,String s)
    {
        this.temp = temp;
        this.s=s;

        frame_setting();
        edit_text();
        label();
        field();
        back_Button();
        next_Button();
        back_button_func();
        next_button_func();
        back_button();

    }

    void frame_setting() {
        sold_frame.setBounds(500, 50, 500, 550);
        sold_frame.setVisible(true);
        sold_frame.setResizable(false);
        sold_frame.setLayout(null);
        sold_frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        sold_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void edit_text() {
        sold_text.setBounds(130, 0, 500, 50);
        sold_text.setFont(f1);
        sold_frame.add(sold_text);
    }

    void label() {
        Id.setBounds(20, 50, 500, 30);
        sold_frame.add(Id);

        if(s.equals("rent"))
        {
            price.setText("Price per Day :");
        }
        price.setBounds(20, 80, 500, 30);
        sold_frame.add(price);

        product_weight.setBounds(20, 110, 500, 30);
        sold_frame.add(product_weight);

        product_name.setBounds(20, 140, 500, 30);
        sold_frame.add(product_name);

        l1.setBounds(20, 170, 500, 30);
        l1.setVisible(false);
        sold_frame.add(l1);

        l2.setBounds(20, 200, 500, 30);
        l2.setVisible(false);
        sold_frame.add(l2);

        l3.setBounds(20, 230, 500, 30);
        l3.setVisible(false);
        sold_frame.add(l3);

        l4.setBounds(20, 260, 500, 30);
        l4.setVisible(false);
        sold_frame.add(l4);

        sold_frame.add(DO);
        sold_frame.add(M);
    }

    void field() {
        tf_Id.setBounds(120, 50, 330, 30);
        tf_Id.setBackground(Color.lightGray);
        tf_Id.setEditable(false);
        if(s.equals("sell")) {
            tf_Id.setText(Main.s[Main.sell_index].sold_product[i].product_ID);
        }
        else if(s.equals("rent"))
        {
            tf_Id.setText(Main.r[Main.rent_index].sold_product_list[i].product_ID);
        }
        tf_Id.setBorder(null);
        sold_frame.add(tf_Id);

        tf_price.setBounds(120, 80, 330, 30);
        tf_price.setBackground(Color.LIGHT_GRAY);
        if(s.equals("sell")) {
            tf_price.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].price));
        }
        else if(s.equals("rent"))
        {
            tf_price.setText(String.valueOf(Main.r[Main.rent_index].sold_product_list[i].price));
        }
        sold_frame.add(tf_price);
        tf_price.setBorder(null);
        tf_price.setEditable(false);

        tf_product_weight.setBounds(120, 110, 330, 30);
        tf_product_weight.setBackground(Color.lightGray);
        if(s.equals("sell")) {
            tf_product_weight.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].weight));
        }
        else if(s.equals("rent"))
        {
            tf_product_weight.setText(String.valueOf(Main.r[Main.rent_index].sold_product_list[i].weight));
        }
        sold_frame.add(tf_product_weight);
        tf_product_weight.setBorder(null);
        tf_product_weight.setEditable(false);

        tf_product_name.setBounds(120, 140, 330, 30);
        tf_product_name.setBackground(Color.LIGHT_GRAY);
        if(s.equals("sell")) {
            tf_product_name.setText(Main.s[Main.sell_index].sold_product[i].name);
        }
        else if(s.equals("rent"))
        {
            tf_product_name.setText(Main.r[Main.rent_index].sold_product_list[i].name);
        }
        tf_product_name.setEditable(false);
        tf_product_name.setBorder(null);
        sold_frame.add(tf_product_name);

        t1.setBounds(120, 170, 330, 30);
        t1.setBackground(Color.LIGHT_GRAY);
        t1.setEditable(false);
        t1.setBorder(null);
        sold_frame.add(t1);

        t2.setBounds(120, 200, 330, 30);
        t2.setBackground(Color.LIGHT_GRAY);
        t2.setEditable(false);
        t2.setBorder(null);
        sold_frame.add(t2);

        t3.setBounds(120, 230, 330, 30);
        t3.setBackground(Color.LIGHT_GRAY);
        t3.setBorder(null);
        t3.setEditable(false);
        sold_frame.add(t3);

        t4.setBounds(120, 260, 330, 30);
        t4.setBorder(null);
        t4.setBackground(Color.LIGHT_GRAY);
        t4.setEditable(false);
        sold_frame.add(t4);

        tf_date_of_manufacture.setEditable(false);
        tf_date_of_manufacture.setBackground(Color.LIGHT_GRAY);
        tf_date_of_manufacture.setBorder(null);
        sold_frame.add(tf_date_of_manufacture);

        tf_interest.setEditable(false);
        tf_interest.setBorder(null);
        tf_interest.setBackground(Color.LIGHT_GRAY);

        tf_advance.setEditable(false);
        tf_advance.setBackground(Color.LIGHT_GRAY);
        tf_advance.setBorder(null);

        tf_monthly_price.setEditable(false);
        tf_monthly_price.setBackground(Color.LIGHT_GRAY);
        tf_monthly_price.setBorder(null);

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

            DO.setBounds(20, 260, 500, 30);
            M.setBounds(20,270,500,30);

            if(s.equals("sell")) {

                t1.setText(Main.s[Main.sell_index].sold_product[i].laptop.memory);
                t2.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].laptop.Battery_life));
                t3.setText(Main.s[Main.sell_index].sold_product[i].laptop.company);

                tf_date_of_manufacture.setBounds(120,270,330,30);
                tf_date_of_manufacture.setText(Main.s[Main.sell_index].sold_product[i].laptop.date_of_manufacture.getDay()+"/"+Main.s[Main.sell_index].sold_product[i].laptop.date_of_manufacture.getMonth()+"/"+Main.s[Main.sell_index].sold_product[i].laptop.date_of_manufacture.getYear());


                if(Main.s[Main.sell_index].sold_product[i].installment!=null)
                {
                    advance.setVisible(true);
                    interest.setVisible(true);
                    month_price.setVisible(true);

                    tf_advance.setVisible(true);
                    tf_interest.setVisible(true);
                    tf_monthly_price.setVisible(true);

                    advance.setBounds(20,300,500,30);
                    sold_frame.add(advance);

                    tf_advance.setBounds(120,300,330,30);
                    sold_frame.add(tf_advance);

                    interest.setBounds(20,330,500,30);
                    sold_frame.add(interest);

                    tf_interest.setBounds(120,330,330,30);
                    sold_frame.add(tf_interest);

                    month_price.setBounds(20,360,500,30);
                    sold_frame.add(month_price);

                    tf_monthly_price.setBounds(120,360,330,30);
                    sold_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].laptop.installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].laptop.installment.price_per_month));
                }
            }
            else if(s.equals("rent"))
            {
                advance.setVisible(false);
                interest.setVisible(false);
                month_price.setVisible(false);

                tf_advance.setVisible(false);
                tf_interest.setVisible(false);
                tf_monthly_price.setVisible(false);


                t1.setText(Main.r[Main.rent_index].sold_product_list[i].laptop.memory);
                t2.setText(String.valueOf(Main.r[Main.rent_index].sold_product_list[i].laptop.Battery_life));
                t3.setText(Main.r[Main.rent_index].sold_product_list[i].laptop.company);

                tf_date_of_manufacture.setBounds(120,270,330,30);
                tf_date_of_manufacture.setText(Main.r[Main.rent_index].sold_product_list[i].laptop.date_of_manufacture.getDay()+"/"+Main.r[Main.rent_index].sold_product_list[i].laptop.date_of_manufacture.getMonth()+"/"+Main.r[Main.rent_index].sold_product_list[i].laptop.date_of_manufacture.getYear());
            }

        }
        else if (tf_product_name.getText().equals("Mobile")) {

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

            DO.setBounds(20, 290, 500, 30);
            M.setBounds(20,300,500,30);


            if(s.equals("sell")) {
                t1.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].mobile.storage));
                t2.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].mobile.length));
                t3.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].mobile.width));
                t4.setText(Main.s[Main.sell_index].sold_product[i].mobile.company);

                tf_date_of_manufacture.setBounds(120,300,330,30);
                tf_date_of_manufacture.setText(Main.s[Main.sell_index].sold_product[i].mobile.date_of_manufacture.getDay()+"/"+Main.s[Main.sell_index].sold_product[i].mobile.date_of_manufacture.getMonth()+"/"+Main.s[Main.sell_index].sold_product[i].mobile.date_of_manufacture.getYear());


                if(Main.s[Main.sell_index].sold_product[i].installment!=null)
                {
                    advance.setVisible(true);
                    interest.setVisible(true);
                    month_price.setVisible(true);

                    tf_advance.setVisible(true);
                    tf_interest.setVisible(true);
                    tf_monthly_price.setVisible(true);

                    advance.setBounds(20,330,500,30);
                    sold_frame.add(advance);

                    tf_advance.setBounds(120,330,330,30);
                    sold_frame.add(tf_advance);

                    interest.setBounds(20,360,500,30);
                    sold_frame.add(interest);

                    tf_interest.setBounds(120,360,330,30);
                    sold_frame.add(tf_interest);

                    month_price.setBounds(20,390,500,30);
                    sold_frame.add(month_price);

                    tf_monthly_price.setBounds(120,390,330,30);
                    sold_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.price_per_month));
                }
            }
            else if(s.equals("rent"))
            {

                advance.setVisible(false);
                interest.setVisible(false);
                month_price.setVisible(false);

                tf_advance.setVisible(false);
                tf_interest.setVisible(false);
                tf_monthly_price.setVisible(false);


                t1.setText(String.valueOf(Main.r[Main.rent_index].sold_product_list[i].mobile.storage));
                t2.setText(String.valueOf(Main.r[Main.rent_index].sold_product_list[i].mobile.length));
                t3.setText(String.valueOf(Main.r[Main.rent_index].sold_product_list[i].mobile.width));
                t4.setText(Main.r[Main.rent_index].sold_product_list[i].mobile.company);

                tf_date_of_manufacture.setBounds(120,300,330,25);
                tf_date_of_manufacture.setText(Main.r[Main.rent_index].sold_product_list[i].mobile.date_of_manufacture.getDay()+"/"+Main.r[Main.rent_index].sold_product_list[i].mobile.date_of_manufacture.getMonth()+"/"+Main.r[Main.rent_index].sold_product_list[i].mobile.date_of_manufacture.getYear());

            }

        }
        else if (tf_product_name.getText().equals("Air conditioner")) {

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

            DO.setBounds(20, 260, 500, 50);
            M.setBounds(20,270,500,50);

            if(s.equals("sell")) {
                t1.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].air_conditioner.power));
                t2.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].air_conditioner.energy_efficiency));
                t3.setText(Main.s[Main.sell_index].sold_product[i].air_conditioner.company);

                tf_date_of_manufacture.setBounds(120,265,330,30);
                tf_date_of_manufacture.setText(Main.s[Main.sell_index].sold_product[i].air_conditioner.date_of_manufacture.getDay()+"/"+Main.s[Main.sell_index].sold_product[i].air_conditioner.date_of_manufacture.getMonth()+"/"+Main.s[Main.sell_index].sold_product[i].air_conditioner.date_of_manufacture.getYear());

                if(Main.s[Main.sell_index].sold_product[i].installment!=null)
                {
                    advance.setVisible(true);
                    interest.setVisible(true);
                    month_price.setVisible(true);

                    tf_advance.setVisible(true);
                    tf_interest.setVisible(true);
                    tf_monthly_price.setVisible(true);

                    advance.setBounds(20,290,500,30);
                    sold_frame.add(advance);

                    tf_advance.setBounds(120,290,330,30);
                    sold_frame.add(tf_advance);

                    interest.setBounds(20,320,500,30);
                    sold_frame.add(interest);

                    tf_interest.setBounds(120,320,330,30);
                    sold_frame.add(tf_interest);

                    month_price.setBounds(20,350,500,30);
                    sold_frame.add(month_price);

                    tf_monthly_price.setBounds(120,350,330,30);
                    sold_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.price_per_month));
                }
            }
            else if(s.equals("rent"))
            {
                advance.setVisible(false);
                interest.setVisible(false);
                month_price.setVisible(false);

                tf_advance.setVisible(false);
                tf_interest.setVisible(false);
                tf_monthly_price.setVisible(false);


                t1.setText(String.valueOf(Main.r[Main.rent_index].sold_product_list[i].air_conditioner.power));
                t2.setText(String.valueOf(Main.r[Main.rent_index].sold_product_list[i].air_conditioner.energy_efficiency));
                t3.setText(Main.r[Main.rent_index].sold_product_list[i].air_conditioner.company);

                tf_date_of_manufacture.setBounds(120,265,330,30);
                tf_date_of_manufacture.setText(Main.r[Main.rent_index].sold_product_list[i].air_conditioner.date_of_manufacture.getDay()+"/"+Main.r[Main.rent_index].sold_product_list[i].air_conditioner.date_of_manufacture.getMonth()+"/"+Main.r[Main.rent_index].sold_product_list[i].air_conditioner.date_of_manufacture.getYear());

            }

        }
        else if (tf_product_name.getText().equals("Car")) {

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

            DO.setBounds(20, 290, 500, 30);
            M.setBounds(20,300,500,30);

            if(s.equals("sell")) {
                t1.setText(Main.s[Main.sell_index].sold_product[i].car.Brand);
                t2.setText(Main.s[Main.sell_index].sold_product[i].car.Model);
                t3.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].car.MaximumSpeed));
                t4.setText(Main.s[Main.sell_index].sold_product[i].car.Color);

                tf_date_of_manufacture.setBounds(120,295,330,30);
                tf_date_of_manufacture.setText(Main.s[Main.sell_index].sold_product[i].car.date_of_manufacture.getDay()+"/"+Main.s[Main.sell_index].sold_product[i].car.date_of_manufacture.getMonth()+"/"+Main.s[Main.sell_index].sold_product[i].car.date_of_manufacture.getYear());

                if(Main.s[Main.sell_index].sold_product[i].installment!=null)
                {
                    advance.setVisible(true);
                    interest.setVisible(true);
                    month_price.setVisible(true);

                    tf_advance.setVisible(true);
                    tf_interest.setVisible(true);
                    tf_monthly_price.setVisible(true);

                    advance.setBounds(20,330,500,30);
                    sold_frame.add(advance);

                    tf_advance.setBounds(120,330,330,30);
                    sold_frame.add(tf_advance);

                    interest.setBounds(20,360,500,30);
                    sold_frame.add(interest);

                    tf_interest.setBounds(120,360,330,30);
                    sold_frame.add(tf_interest);

                    month_price.setBounds(20,390,500,30);
                    sold_frame.add(month_price);

                    tf_monthly_price.setBounds(120,390,330,30);
                    sold_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.price_per_month));
                }
            }
            else if(s.equals("rent"))
            {
                advance.setVisible(false);
                interest.setVisible(false);
                month_price.setVisible(false);

                tf_advance.setVisible(false);
                tf_interest.setVisible(false);
                tf_monthly_price.setVisible(false);


                t1.setText(Main.r[Main.rent_index].sold_product_list[i].car.Brand);
                t2.setText(Main.r[Main.rent_index].sold_product_list[i].car.Model);
                t3.setText(String.valueOf(Main.r[Main.rent_index].sold_product_list[i].car.MaximumSpeed));
                t4.setText(Main.r[Main.rent_index].sold_product_list[i].car.Color);

                tf_date_of_manufacture.setBounds(120,295,330,30);
                tf_date_of_manufacture.setText(Main.r[Main.rent_index].sold_product_list[i].car.date_of_manufacture.getDay()+"/"+Main.r[Main.rent_index].sold_product_list[i].car.date_of_manufacture.getMonth()+"/"+Main.r[Main.rent_index].sold_product_list[i].car.date_of_manufacture.getYear());
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

            DO.setBounds(20, 290, 500, 30);
            M.setBounds(20,300,500,30);

            if(s.equals("sell")) {
                t1.setText(Main.s[Main.sell_index].sold_product[i].bike.Brand);
                t2.setText(Main.s[Main.sell_index].sold_product[i].bike.Model);
                t3.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].bike.MaximumSpeed));
                t4.setText(Main.s[Main.sell_index].sold_product[i].bike.Color);

                tf_date_of_manufacture.setBounds(120,295,330,30);
                tf_date_of_manufacture.setText(Main.s[Main.sell_index].sold_product[i].bike.date_of_manufacture.getDay()+"/"+Main.s[Main.sell_index].sold_product[i].bike.date_of_manufacture.getMonth()+"/"+Main.s[Main.sell_index].sold_product[i].bike.date_of_manufacture.getYear());

                if(Main.s[Main.sell_index].sold_product[i].installment!=null)
                {
                    advance.setVisible(true);
                    interest.setVisible(true);
                    month_price.setVisible(true);

                    tf_advance.setVisible(true);
                    tf_interest.setVisible(true);
                    tf_monthly_price.setVisible(true);

                    advance.setBounds(20,330,500,30);
                    sold_frame.add(advance);

                    tf_advance.setBounds(120,330,330,30);
                    sold_frame.add(tf_advance);

                    interest.setBounds(20,360,500,30);
                    sold_frame.add(interest);

                    tf_interest.setBounds(120,360,330,30);
                    sold_frame.add(tf_interest);

                    month_price.setBounds(20,390,500,30);
                    sold_frame.add(month_price);

                    tf_monthly_price.setBounds(120,390,330,30);
                    sold_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.price_per_month));
                }
            }
            else if(s.equals("rent"))
            {
                advance.setVisible(false);
                interest.setVisible(false);
                month_price.setVisible(false);

                tf_advance.setVisible(false);
                tf_interest.setVisible(false);
                tf_monthly_price.setVisible(false);

                t1.setText(Main.r[Main.rent_index].sold_product_list[i].bike.Brand);
                t2.setText(Main.r[Main.rent_index].sold_product_list[i].bike.Model);
                t3.setText(String.valueOf(Main.r[Main.rent_index].sold_product_list[i].bike.MaximumSpeed));
                t4.setText(Main.r[Main.rent_index].sold_product_list[i].bike.Color);

                tf_date_of_manufacture.setBounds(120,295,330,30);
                tf_date_of_manufacture.setText(Main.r[Main.rent_index].sold_product_list[i].bike.date_of_manufacture.getDay()+"/"+Main.r[Main.rent_index].sold_product_list[i].bike.date_of_manufacture.getMonth()+"/"+Main.r[Main.rent_index].sold_product_list[i].bike.date_of_manufacture.getYear());

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

            DO.setBounds(20, 230, 500, 30);
            M.setBounds(20,240,500,30);

            if(s.equals("sell")) {
                t1.setText(Main.s[Main.sell_index].sold_product[i].chair.Material);
                t2.setText(Main.s[Main.sell_index].sold_product[i].chair.Color);

                tf_date_of_manufacture.setBounds(120,235,330,30);
                tf_date_of_manufacture.setText(Main.s[Main.sell_index].sold_product[i].chair.date_of_manufacture.getDay()+"/"+Main.s[Main.sell_index].sold_product[i].chair.date_of_manufacture.getMonth()+"/"+Main.s[Main.sell_index].sold_product[i].chair.date_of_manufacture.getYear());

                if(Main.s[Main.sell_index].sold_product[i].installment!=null)
                {
                    advance.setVisible(true);
                    interest.setVisible(true);
                    month_price.setVisible(true);

                    tf_advance.setVisible(true);
                    tf_interest.setVisible(true);
                    tf_monthly_price.setVisible(true);

                    advance.setBounds(20,260,500,50);
                    sold_frame.add(advance);

                    tf_advance.setBounds(120,260,330,30);
                    sold_frame.add(tf_advance);

                    interest.setBounds(20,290,500,30);
                    sold_frame.add(interest);

                    tf_interest.setBounds(120,290,330,30);
                    sold_frame.add(tf_interest);

                    month_price.setBounds(20,320,500,30);
                    sold_frame.add(month_price);

                    tf_monthly_price.setBounds(120,320,330,20);
                    sold_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.price_per_month));
                }
            }
            else if(s.equals("rent"))
            {
                advance.setVisible(false);
                interest.setVisible(false);
                month_price.setVisible(false);

                tf_advance.setVisible(false);
                tf_interest.setVisible(false);
                tf_monthly_price.setVisible(false);

                t1.setText(Main.r[Main.rent_index].sold_product_list[i].chair.Material);
                t2.setText(Main.r[Main.sell_index].sold_product_list[i].chair.Color);

                tf_date_of_manufacture.setBounds(120,235,330,30);
                tf_date_of_manufacture.setText(Main.r[Main.rent_index].sold_product_list[i].chair.date_of_manufacture.getDay()+"/"+Main.r[Main.rent_index].sold_product_list[i].chair.date_of_manufacture.getMonth()+"/"+Main.r[Main.rent_index].sold_product_list[i].chair.date_of_manufacture.getYear());
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

            DO.setBounds(20, 230, 500, 30);
            M.setBounds(20,240,500,30);

            if(s.equals("sell")) {
                t1.setText(Main.s[Main.sell_index].sold_product[i].table.Material);
                t2.setText(Main.s[Main.sell_index].sold_product[i].table.Color);

                tf_date_of_manufacture.setBounds(120,235,330,30);
                tf_date_of_manufacture.setText(Main.s[Main.sell_index].sold_product[i].table.date_of_manufacture.getDay()+"/"+Main.s[Main.sell_index].sold_product[i].table.date_of_manufacture.getMonth()+"/"+Main.s[Main.sell_index].sold_product[i].table.date_of_manufacture.getYear());

                if(Main.s[Main.sell_index].sold_product[i].installment!=null)
                {
                    advance.setVisible(true);
                    interest.setVisible(true);
                    month_price.setVisible(true);

                    tf_advance.setVisible(true);
                    tf_interest.setVisible(true);
                    tf_monthly_price.setVisible(true);

                    advance.setBounds(20,260,500,30);
                    sold_frame.add(advance);

                    tf_advance.setBounds(120,260,330,30);
                    sold_frame.add(tf_advance);

                    interest.setBounds(20,290,500,30);
                    sold_frame.add(interest);

                    tf_interest.setBounds(120,290,330,30);
                    sold_frame.add(tf_interest);

                    month_price.setBounds(20,320,500,30);
                    sold_frame.add(month_price);

                    tf_monthly_price.setBounds(120,320,330,30);
                    sold_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.price_per_month));
                }
            }
            else if(s.equals("rent"))
            {
                advance.setVisible(false);
                interest.setVisible(false);
                month_price.setVisible(false);

                tf_advance.setVisible(false);
                tf_interest.setVisible(false);
                tf_monthly_price.setVisible(false);

                t1.setText(Main.r[Main.rent_index].sold_product_list[i].table.Material);
                t2.setText(Main.r[Main.rent_index].sold_product_list[i].table.Color);

                tf_date_of_manufacture.setBounds(120,235,330,30);
                tf_date_of_manufacture.setText(Main.r[Main.rent_index].sold_product_list[i].table.date_of_manufacture.getDay()+"/"+Main.r[Main.rent_index].sold_product_list[i].table.date_of_manufacture.getMonth()+"/"+Main.r[Main.rent_index].sold_product_list[i].table.date_of_manufacture.getYear());
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

            DO.setBounds(20, 230, 500, 30);
            M.setBounds(20,240,500,30);

            if(s.equals("sell")) {
                t1.setText(Main.s[Main.sell_index].sold_product[i].bed.Material);
                t2.setText(Main.s[Main.sell_index].sold_product[i].bed.Color);

                tf_date_of_manufacture.setBounds(120,235,330,30);
                tf_date_of_manufacture.setText(Main.s[Main.sell_index].sold_product[i].bed.date_of_manufacture.getDay()+"/"+Main.s[Main.sell_index].sold_product[i].bed.date_of_manufacture.getMonth()+"/"+Main.s[Main.sell_index].sold_product[i].bed.date_of_manufacture.getYear());

                if(Main.s[Main.sell_index].sold_product[i].installment!=null)
                {
                    advance.setVisible(true);
                    interest.setVisible(true);
                    month_price.setVisible(true);

                    tf_advance.setVisible(true);
                    tf_interest.setVisible(true);
                    tf_monthly_price.setVisible(true);

                    advance.setBounds(20,260,500,30);
                    sold_frame.add(advance);

                    tf_advance.setBounds(120,260,330,30);
                    sold_frame.add(tf_advance);

                    interest.setBounds(20,260,500,30);
                    sold_frame.add(interest);

                    tf_interest.setBounds(120,260,330,30);
                    sold_frame.add(tf_interest);

                    month_price.setBounds(20,290,500,30);
                    sold_frame.add(month_price);

                    tf_monthly_price.setBounds(120,290,330,25);
                    sold_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].sold_product[i].installment.price_per_month));
                }
            }
            else if(s.equals("rent"))
            {
                advance.setVisible(false);
                interest.setVisible(false);
                month_price.setVisible(false);

                tf_advance.setVisible(false);
                tf_interest.setVisible(false);
                tf_monthly_price.setVisible(false);

                t1.setText(Main.r[Main.rent_index].sold_product_list[i].bed.Material);
                t2.setText(Main.r[Main.rent_index].sold_product_list[i].bed.Color);

                tf_date_of_manufacture.setBounds(120,235,330,30);
                tf_date_of_manufacture.setText(Main.r[Main.rent_index].sold_product_list[i].bed.date_of_manufacture.getDay()+"/"+Main.r[Main.rent_index].sold_product_list[i].bed.date_of_manufacture.getMonth()+"/"+Main.r[Main.rent_index].sold_product_list[i].bed.date_of_manufacture.getYear());
            }

        }
    }

    private void back_Button() {
        back.setBounds(130, 435, 90, 30);
        back.addActionListener(this);
        sold_frame.add(back);
    }

    private void next_Button() {
        next.setBounds(270, 435, 90, 30);
        sold_frame.add(next);
        next.addActionListener(this);

    }

    public void back_button_func()
    {
        back.setEnabled(true);
        if(i==0)
        {
            back.setEnabled(false);
        }
        index_text.setBounds(200, 470, 100, 40);

        if(s.equals("sell")) {
            index_text.setText("Product " + (i + 1) + " of " + Main.s[Main.sell_index].sold_product_count);
        }
        else if(s.equals("rent"))
        {
            index_text.setText("Product " + (i + 1) + " of " + Main.r[Main.rent_index].sold_Product_List_count);
        }
        sold_frame.add(index_text);
    }

    void next_button_func()
    {
        next.setEnabled(true);

        if(s.equals("sell")) {
            if ((i + 1) == Main.s[Main.sell_index].sold_product_count) {
                next.setEnabled(false);
            }
        }
        else if(s.equals("rent"))
        {
            if ((i + 1) == Main.r[Main.rent_index].sold_Product_List_count) {
                next.setEnabled(false);
            }
        }
    }

    void back_button(){
        ImageIcon back=new ImageIcon("E:\\back.jpeg");
        Image b=back.getImage();
        Image b1=b.getScaledInstance(20,20,10);
        back.setImage(b1);

        back_b=new JButton(back);
        back_b.setBounds(10,10,30,30);
        back_b.setBackground(Color.lightGray);
        back_b.setBorderPainted(false);
        back_b.addActionListener(this);
        sold_frame.add(back_b);
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
        else if(e.getSource().equals(back_b))
        {
            sold_frame.dispose();
            Sell_product_panel.sell_frame.setVisible(true);
        }

    }
}