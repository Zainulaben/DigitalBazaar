import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.zip.GZIPInputStream;

public class Active_Product_List implements ActionListener {
    public JFrame edit_frame = new JFrame("Active product list");

    JLabel active_text = new JLabel("ACTIVE PRODUCTS");

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


    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);

    JButton back = new JButton("Back");
    JButton next = new JButton("Next");

    JButton back_b;

    GUI temp;
    static int i = 0;

    String s;

    Active_Product_List(GUI temp,String s) {
        this.temp = temp;
        i=0;
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
        edit_frame.setBounds(500, 50, 500, 520);
        edit_frame.setVisible(true);
        edit_frame.setResizable(false);
        edit_frame.setLayout(null);
        edit_frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        edit_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void edit_text() {
        active_text.setBounds(130, 0, 500, 50);
        active_text.setFont(f1);
        edit_frame.add(active_text);
    }

    void label() {
        Id.setBounds(20,35,500,50);
        edit_frame.add(Id);

        if(s.equals("Renter"))
        {
            price.setText("Price per Day : ");
        }

        price.setBounds(20,65,500,50);
        edit_frame.add(price);

        product_weight.setBounds(20,95,500,50);
        edit_frame.add(product_weight);

        product_name.setBounds(20,125,500,50);
        edit_frame.add(product_name);

        l1.setBounds(20,155,500,50);
        l1.setVisible(false);
        edit_frame.add(l1);

        l2.setBounds(20,185,500,50);
        l2.setVisible(false);
        edit_frame.add(l2);

        l3.setBounds(20,215,500,50);
        l3.setVisible(false);
        edit_frame.add(l3);

        l4.setBounds(20,245,500,50);
        l4.setVisible(false);
        edit_frame.add(l4);


        edit_frame.add(DO);
        edit_frame.add(M);
    }

    void field() {
        advance.setVisible(false);
        interest.setVisible(false);
        month_price.setVisible(false);

        tf_advance.setVisible(false);
        tf_advance.setBorder(null);
        tf_advance.setBackground(Color.LIGHT_GRAY);

        tf_interest.setVisible(false);
        tf_interest.setBorder(null);
        tf_interest.setBackground(Color.LIGHT_GRAY);

        tf_monthly_price.setVisible(false);
        tf_monthly_price.setBorder(null);
        tf_monthly_price.setBackground(Color.LIGHT_GRAY);

        tf_monthly_price.setEditable(false);
        tf_interest.setEditable(false);
        tf_advance.setEditable(false);


        tf_Id.setBounds(120,50,330,25);
        tf_Id.setEditable(false);
        if(s.equals("Seller")) {
            tf_Id.setText(Main.s[Main.sell_index].active_product[i].product_ID);
        }
        else if(s.equals("Renter"))
        {
            tf_Id.setText(Main.r[Main.rent_index].active_product_List[i].product_ID);
        }
        tf_Id.setBorder(null);
        tf_Id.setBackground(Color.LIGHT_GRAY);
        edit_frame.add(tf_Id);


        tf_price.setBounds(120,80,330,25);
        if(s.equals("Seller")) {
            tf_price.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].price));
        }
        else if(s.equals("Renter"))
        {
            tf_price.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[i].price));
        }
        tf_price.setEditable(false);
        tf_price.setBorder(null);
        tf_price.setBackground(Color.LIGHT_GRAY);
        edit_frame.add(tf_price);


        tf_product_weight.setBounds(120,110,330,25);
        tf_product_weight.setBackground(Color.LIGHT_GRAY);
        tf_product_weight.setBorder(null);
        if(s.equals("Seller")) {
            tf_product_weight.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].weight));
        }
        else if(s.equals("Renter"))
        {
            tf_product_weight.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[i].weight));
        }
        tf_product_weight.setEditable(false);
        edit_frame.add(tf_product_weight);


        tf_product_name.setBounds(120,140,330,25);
        tf_product_name.setBackground(Color.LIGHT_GRAY);
        tf_product_name.setBorder(null);
        if(s.equals("Seller")) {
            tf_product_name.setText(Main.s[Main.sell_index].active_product[i].name);
        }
        else if(s.equals("Renter"))
        {
            tf_product_name.setText(Main.r[Main.rent_index].active_product_List[i].name);
        }
        tf_product_name.setEditable(false);
        edit_frame.add(tf_product_name);


        t1.setBounds(120,170,330,25);
        t1.setEditable(false);
        t1.setBackground(Color.LIGHT_GRAY);
        t1.setBorder(null);
        edit_frame.add(t1);

        t2.setBounds(120,200,330,25);
        edit_frame.add(t2);
        t2.setBackground(Color.LIGHT_GRAY);
        t2.setBorder(null);
        t2.setEditable(false);

        t3.setBounds(120,230,330,25);
        edit_frame.add(t3);
        t3.setBorder(null);
        t3.setBackground(Color.LIGHT_GRAY);
        t3.setEditable(false);

        t4.setBounds(120,260,330,25);
        edit_frame.add(t4);
        t4.setBackground(null);
        t4.setBorder(null);
        t4.setEditable(false);

        tf_date_of_manufacture.setEditable(false);
        tf_date_of_manufacture.setBackground(Color.LIGHT_GRAY);
        tf_date_of_manufacture.setBorder(null);
        edit_frame.add(tf_date_of_manufacture);


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

            DO.setBounds(20, 255, 500, 50);
            M.setBounds(20,265,500,50);


            if(s.equals("Seller")) {

                t1.setText(Main.s[Main.sell_index].active_product[i].laptop.memory);
                t2.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].laptop.Battery_life));
                t3.setText(Main.s[Main.sell_index].active_product[i].laptop.company);
                tf_date_of_manufacture.setBounds(120,270,330,25);
                tf_date_of_manufacture.setText(Main.s[Main.sell_index].active_product[i].laptop.date_of_manufacture.getDay()+"/"+Main.s[Main.sell_index].active_product[i].laptop.date_of_manufacture.getMonth()+"/"+Main.s[Main.sell_index].active_product[i].laptop.date_of_manufacture.getYear());


                if(Main.s[Main.sell_index].active_product[i].installment!=null)
                {
                    advance.setVisible(true);
                    interest.setVisible(true);
                    month_price.setVisible(true);

                    tf_advance.setVisible(true);
                    tf_interest.setVisible(true);
                    tf_monthly_price.setVisible(true);

                    advance.setBounds(20,285,500,50);
                    edit_frame.add(advance);

                    tf_advance.setBounds(120,295,330,25);
                    edit_frame.add(tf_advance);

                    interest.setBounds(20,315,500,50);
                    edit_frame.add(interest);

                    tf_interest.setBounds(120,325,330,25);
                    edit_frame.add(tf_interest);

                    month_price.setBounds(20,345,500,50);
                    edit_frame.add(month_price);

                    tf_monthly_price.setBounds(120,355,330,25);
                    edit_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].laptop.installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].laptop.installment.price_per_month));
                }
            }
            else if(s.equals("Renter"))
            {
                advance.setVisible(false);
                interest.setVisible(false);
                month_price.setVisible(false);

                tf_advance.setVisible(false);
                tf_interest.setVisible(false);
                tf_monthly_price.setVisible(false);

                t1.setText(Main.r[Main.rent_index].active_product_List[i].laptop.memory);
                t2.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[i].laptop.Battery_life));
                t3.setText(Main.r[Main.rent_index].active_product_List[i].laptop.company);

                tf_date_of_manufacture.setBounds(120,270,330,25);
                tf_date_of_manufacture.setText(Main.r[Main.rent_index].active_product_List[i].laptop.date_of_manufacture.getDay()+"/"+Main.r[Main.rent_index].active_product_List[i].laptop.date_of_manufacture.getMonth()+"/"+Main.r[Main.rent_index].active_product_List[i].laptop.date_of_manufacture.getYear());
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

            DO.setBounds(20, 285, 500, 50);
            M.setBounds(20,295,500,50);


            if(s.equals("Seller")) {
                t1.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].mobile.storage));
                t2.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].mobile.length));
                t3.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].mobile.width));
                t4.setText(Main.s[Main.sell_index].active_product[i].mobile.company);

                tf_date_of_manufacture.setBounds(120,300,330,25);
                tf_date_of_manufacture.setText(Main.s[Main.sell_index].active_product[i].mobile.date_of_manufacture.getDay()+"/"+Main.s[Main.sell_index].active_product[i].mobile.date_of_manufacture.getMonth()+"/"+Main.s[Main.sell_index].active_product[i].mobile.date_of_manufacture.getYear());



                if(Main.s[Main.sell_index].active_product[i].installment!=null)
                {
                    advance.setVisible(true);
                    interest.setVisible(true);
                    month_price.setVisible(true);

                    tf_advance.setVisible(true);
                    tf_interest.setVisible(true);
                    tf_monthly_price.setVisible(true);

                    advance.setBounds(20,315,500,50);
                    edit_frame.add(advance);

                    tf_advance.setBounds(120,325,330,25);
                    edit_frame.add(tf_advance);

                    interest.setBounds(20,345,500,50);
                    edit_frame.add(interest);

                    tf_interest.setBounds(120,355,330,25);
                    edit_frame.add(tf_interest);

                    month_price.setBounds(20,375,500,50);
                    edit_frame.add(month_price);

                    tf_monthly_price.setBounds(120,385,330,25);
                    edit_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.price_per_month));
                }
            }
            else if(s.equals("Renter"))
            {

                advance.setVisible(false);
                interest.setVisible(false);
                month_price.setVisible(false);

                tf_advance.setVisible(false);
                tf_interest.setVisible(false);
                tf_monthly_price.setVisible(false);


                t1.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[i].mobile.storage));
                t2.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[i].mobile.length));
                t3.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[i].mobile.width));
                t4.setText(Main.r[Main.rent_index].active_product_List[i].mobile.company);

                tf_date_of_manufacture.setBounds(120,300,330,25);
                tf_date_of_manufacture.setText(Main.r[Main.rent_index].active_product_List[i].mobile.date_of_manufacture.getDay()+"/"+Main.r[Main.rent_index].active_product_List[i].mobile.date_of_manufacture.getMonth()+"/"+Main.r[Main.rent_index].active_product_List[i].mobile.date_of_manufacture.getYear());

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

            if(s.equals("Seller")) {
                t1.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].air_conditioner.power));
                t2.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].air_conditioner.energy_efficiency));
                t3.setText(Main.s[Main.sell_index].active_product[i].air_conditioner.company);

                tf_date_of_manufacture.setBounds(120,265,330,25);
                tf_date_of_manufacture.setText(Main.s[Main.sell_index].active_product[i].air_conditioner.date_of_manufacture.getDay()+"/"+Main.s[Main.sell_index].active_product[i].air_conditioner.date_of_manufacture.getMonth()+"/"+Main.s[Main.sell_index].active_product[i].air_conditioner.date_of_manufacture.getYear());

                if(Main.s[Main.sell_index].active_product[i].installment!=null)
                {
                    advance.setVisible(true);
                    interest.setVisible(true);
                    month_price.setVisible(true);

                    tf_advance.setVisible(true);
                    tf_interest.setVisible(true);
                    tf_monthly_price.setVisible(true);

                    advance.setBounds(20,285,500,50);
                    edit_frame.add(advance);

                    tf_advance.setBounds(120,295,330,25);
                    edit_frame.add(tf_advance);

                    interest.setBounds(20,315,500,50);
                    edit_frame.add(interest);

                    tf_interest.setBounds(120,325,330,25);
                    edit_frame.add(tf_interest);

                    month_price.setBounds(20,345,500,50);
                    edit_frame.add(month_price);

                    tf_monthly_price.setBounds(120,355,330,25);
                    edit_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.price_per_month));
                }
            }
            else if(s.equals("Renter"))
            {
                advance.setVisible(false);
                interest.setVisible(false);
                month_price.setVisible(false);

                tf_advance.setVisible(false);
                tf_interest.setVisible(false);
                tf_monthly_price.setVisible(false);

                t1.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[i].air_conditioner.power));
                t2.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[i].air_conditioner.energy_efficiency));
                t3.setText(Main.r[Main.rent_index].active_product_List[i].air_conditioner.company);

                tf_date_of_manufacture.setBounds(120,270,330,25);
                tf_date_of_manufacture.setText(Main.r[Main.rent_index].active_product_List[i].air_conditioner.date_of_manufacture.getDay()+"/"+Main.r[Main.rent_index].active_product_List[i].air_conditioner.date_of_manufacture.getMonth()+"/"+Main.r[Main.rent_index].active_product_List[i].air_conditioner.date_of_manufacture.getYear());

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

            DO.setBounds(20, 285, 500, 50);
            M.setBounds(20,295,500,50);

            if(s.equals("Seller")) {
                t1.setText(Main.s[Main.sell_index].active_product[i].car.Brand);
                t2.setText(Main.s[Main.sell_index].active_product[i].car.Model);
                t3.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].car.MaximumSpeed));
                t4.setText(Main.s[Main.sell_index].active_product[i].car.Color);

                tf_date_of_manufacture.setBounds(120,300,330,25);
                tf_date_of_manufacture.setText(Main.s[Main.sell_index].active_product[i].car.date_of_manufacture.getDay()+"/"+Main.s[Main.sell_index].active_product[i].car.date_of_manufacture.getMonth()+"/"+Main.s[Main.sell_index].active_product[i].car.date_of_manufacture.getYear());

                if(Main.s[Main.sell_index].active_product[i].installment!=null)
                {
                    advance.setVisible(true);
                    interest.setVisible(true);
                    month_price.setVisible(true);

                    tf_advance.setVisible(true);
                    tf_interest.setVisible(true);
                    tf_monthly_price.setVisible(true);

                    advance.setBounds(20,315,500,50);
                    edit_frame.add(advance);

                    tf_advance.setBounds(120,325,330,25);
                    edit_frame.add(tf_advance);

                    interest.setBounds(20,345,500,50);
                    edit_frame.add(interest);

                    tf_interest.setBounds(120,355,330,25);
                    edit_frame.add(tf_interest);

                    month_price.setBounds(20,375,500,50);
                    edit_frame.add(month_price);

                    tf_monthly_price.setBounds(120,385,330,25);
                    edit_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.price_per_month));
                }
            }
            else if(s.equals("Renter"))
            {
                advance.setVisible(false);
                interest.setVisible(false);
                month_price.setVisible(false);

                tf_advance.setVisible(false);
                tf_interest.setVisible(false);
                tf_monthly_price.setVisible(false);

                t1.setText(Main.r[Main.rent_index].active_product_List[i].car.Brand);
                t2.setText(Main.r[Main.rent_index].active_product_List[i].car.Model);
                t3.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[i].car.MaximumSpeed));
                t4.setText(Main.r[Main.rent_index].active_product_List[i].car.Color);

                tf_date_of_manufacture.setBounds(120,300,330,25);
                tf_date_of_manufacture.setText(Main.r[Main.rent_index].active_product_List[i].car.date_of_manufacture.getDay()+"/"+Main.r[Main.rent_index].active_product_List[i].car.date_of_manufacture.getMonth()+"/"+Main.r[Main.rent_index].active_product_List[i].car.date_of_manufacture.getYear());
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

            DO.setBounds(20, 285, 500, 50);
            M.setBounds(20,295,500,50);

            if(s.equals("Seller")) {
                t1.setText(Main.s[Main.sell_index].active_product[i].bike.Brand);
                t2.setText(Main.s[Main.sell_index].active_product[i].bike.Model);
                t3.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].bike.MaximumSpeed));
                t4.setText(Main.s[Main.sell_index].active_product[i].bike.Color);

                tf_date_of_manufacture.setBounds(120,300,330,25);
                tf_date_of_manufacture.setText(Main.s[Main.sell_index].active_product[i].bike.date_of_manufacture.getDay()+"/"+Main.s[Main.sell_index].active_product[i].bike.date_of_manufacture.getMonth()+"/"+Main.s[Main.sell_index].active_product[i].bike.date_of_manufacture.getYear());

                if(Main.s[Main.sell_index].active_product[i].installment!=null)
                {
                    advance.setVisible(true);
                    interest.setVisible(true);
                    month_price.setVisible(true);

                    tf_advance.setVisible(true);
                    tf_interest.setVisible(true);
                    tf_monthly_price.setVisible(true);

                    advance.setBounds(20,315,500,50);
                    edit_frame.add(advance);

                    tf_advance.setBounds(120,325,330,25);
                    edit_frame.add(tf_advance);

                    interest.setBounds(20,345,500,50);
                    edit_frame.add(interest);

                    tf_interest.setBounds(120,355,330,25);
                    edit_frame.add(tf_interest);

                    month_price.setBounds(20,375,500,50);
                    edit_frame.add(month_price);

                    tf_monthly_price.setBounds(120,385,330,25);
                    edit_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.price_per_month));
                }
            }
            else if(s.equals("Renter"))
            {
                advance.setVisible(false);
                interest.setVisible(false);
                month_price.setVisible(false);

                tf_advance.setVisible(false);
                tf_interest.setVisible(false);
                tf_monthly_price.setVisible(false);

                t1.setText(Main.r[Main.rent_index].active_product_List[i].bike.Brand);
                t2.setText(Main.r[Main.rent_index].active_product_List[i].bike.Model);
                t3.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[i].bike.MaximumSpeed));
                t4.setText(Main.r[Main.rent_index].active_product_List[i].bike.Color);

                tf_date_of_manufacture.setBounds(120,300,330,25);
                tf_date_of_manufacture.setText(Main.r[Main.rent_index].active_product_List[i].bike.date_of_manufacture.getDay()+"/"+Main.r[Main.rent_index].active_product_List[i].bike.date_of_manufacture.getMonth()+"/"+Main.r[Main.rent_index].active_product_List[i].bike.date_of_manufacture.getYear());

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

            DO.setBounds(20, 230, 500, 50);
            M.setBounds(20,240,500,50);

            if(s.equals("Seller")) {
                t1.setText(Main.s[Main.sell_index].active_product[i].chair.Material);
                t2.setText(Main.s[Main.sell_index].active_product[i].chair.Color);

                tf_date_of_manufacture.setBounds(120,245,330,30);
                tf_date_of_manufacture.setText(Main.s[Main.sell_index].active_product[i].chair.date_of_manufacture.getDay()+"/"+Main.s[Main.sell_index].active_product[i].chair.date_of_manufacture.getMonth()+"/"+Main.s[Main.sell_index].active_product[i].chair.date_of_manufacture.getYear());

                if(Main.s[Main.sell_index].active_product[i].installment!=null)
                {
                    advance.setVisible(true);
                    interest.setVisible(true);
                    month_price.setVisible(true);

                    tf_advance.setVisible(true);
                    tf_interest.setVisible(true);
                    tf_monthly_price.setVisible(true);

                    advance.setBounds(20,265,500,50);
                    edit_frame.add(advance);

                    tf_advance.setBounds(120,275,330,25);
                    edit_frame.add(tf_advance);

                    interest.setBounds(20,295,500,50);
                    edit_frame.add(interest);

                    tf_interest.setBounds(120,305,330,25);
                    edit_frame.add(tf_interest);

                    month_price.setBounds(20,325,500,50);
                    edit_frame.add(month_price);

                    tf_monthly_price.setBounds(120,335,330,25);
                    edit_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.price_per_month));
                }
            }
            else if(s.equals("Renter"))
            {
                advance.setVisible(false);
                interest.setVisible(false);
                month_price.setVisible(false);

                tf_advance.setVisible(false);
                tf_interest.setVisible(false);
                tf_monthly_price.setVisible(false);

                t1.setText(Main.r[Main.rent_index].active_product_List[i].chair.Material);
                t2.setText(Main.r[Main.sell_index].active_product_List[i].chair.Color);

                tf_date_of_manufacture.setBounds(120,245,330,30);
                tf_date_of_manufacture.setText(Main.r[Main.rent_index].active_product_List[i].chair.date_of_manufacture.getDay()+"/"+Main.r[Main.rent_index].active_product_List[i].chair.date_of_manufacture.getMonth()+"/"+Main.r[Main.rent_index].active_product_List[i].chair.date_of_manufacture.getYear());
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

            DO.setBounds(20, 230, 500, 50);
            M.setBounds(20,240,500,50);

            if(s.equals("Seller")) {
                t1.setText(Main.s[Main.sell_index].active_product[i].table.Material);
                t2.setText(Main.s[Main.sell_index].active_product[i].table.Color);

                tf_date_of_manufacture.setBounds(120,245,330,30);
                tf_date_of_manufacture.setText(Main.s[Main.sell_index].active_product[i].table.date_of_manufacture.getDay()+"/"+Main.s[Main.sell_index].active_product[i].table.date_of_manufacture.getMonth()+"/"+Main.s[Main.sell_index].active_product[i].table.date_of_manufacture.getYear());

                if(Main.s[Main.sell_index].active_product[i].installment!=null)
                {
                    advance.setVisible(true);
                    interest.setVisible(true);
                    month_price.setVisible(true);

                    tf_advance.setVisible(true);
                    tf_interest.setVisible(true);
                    tf_monthly_price.setVisible(true);

                    advance.setBounds(20,265,500,50);
                    edit_frame.add(advance);

                    tf_advance.setBounds(120,275,330,25);
                    edit_frame.add(tf_advance);

                    interest.setBounds(20,295,500,50);
                    edit_frame.add(interest);

                    tf_interest.setBounds(120,305,330,25);
                    edit_frame.add(tf_interest);

                    month_price.setBounds(20,325,500,50);
                    edit_frame.add(month_price);

                    tf_monthly_price.setBounds(120,335,330,25);
                    edit_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.price_per_month));
                }
            }
            else if(s.equals("Renter"))
            {
                advance.setVisible(false);
                interest.setVisible(false);
                month_price.setVisible(false);

                tf_advance.setVisible(false);
                tf_interest.setVisible(false);
                tf_monthly_price.setVisible(false);

                t1.setText(Main.r[Main.rent_index].active_product_List[i].table.Material);
                t2.setText(Main.r[Main.rent_index].active_product_List[i].table.Color);

                tf_date_of_manufacture.setBounds(120,245,330,30);
                tf_date_of_manufacture.setText(Main.r[Main.rent_index].active_product_List[i].table.date_of_manufacture.getDay()+"/"+Main.r[Main.rent_index].active_product_List[i].table.date_of_manufacture.getMonth()+"/"+Main.r[Main.rent_index].active_product_List[i].table.date_of_manufacture.getYear());
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

            if(s.equals("Seller")) {
                t1.setText(Main.s[Main.sell_index].active_product[i].bed.Material);
                t2.setText(Main.s[Main.sell_index].active_product[i].bed.Color);

                tf_date_of_manufacture.setBounds(120,245,330,30);
                tf_date_of_manufacture.setText(Main.s[Main.sell_index].active_product[i].bed.date_of_manufacture.getDay()+"/"+Main.s[Main.sell_index].active_product[i].bed.date_of_manufacture.getMonth()+"/"+Main.s[Main.sell_index].active_product[i].bed.date_of_manufacture.getYear());

                if(Main.s[Main.sell_index].active_product[i].installment!=null)
                {
                    advance.setVisible(true);
                    interest.setVisible(true);
                    month_price.setVisible(true);

                    tf_advance.setVisible(true);
                    tf_interest.setVisible(true);
                    tf_monthly_price.setVisible(true);

                    advance.setBounds(20,265,500,50);
                    edit_frame.add(advance);

                    tf_advance.setBounds(120,275,330,25);
                    edit_frame.add(tf_advance);

                    interest.setBounds(20,295,500,50);
                    edit_frame.add(interest);

                    tf_interest.setBounds(120,305,330,25);
                    edit_frame.add(tf_interest);

                    month_price.setBounds(20,325,500,50);
                    edit_frame.add(month_price);

                    tf_monthly_price.setBounds(120,335,330,25);
                    edit_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].active_product[i].installment.price_per_month));
                }
            }
            else if(s.equals("Renter"))
            {
                advance.setVisible(false);
                interest.setVisible(false);
                month_price.setVisible(false);

                tf_advance.setVisible(false);
                tf_interest.setVisible(false);
                tf_monthly_price.setVisible(false);

                t1.setText(Main.r[Main.rent_index].active_product_List[i].bed.Material);
                t2.setText(Main.r[Main.rent_index].active_product_List[i].bed.Color);

                tf_date_of_manufacture.setBounds(120,245,330,30);
                tf_date_of_manufacture.setText(Main.r[Main.rent_index].active_product_List[i].bed.date_of_manufacture.getDay()+"/"+Main.r[Main.rent_index].active_product_List[i].bed.date_of_manufacture.getMonth()+"/"+Main.r[Main.rent_index].active_product_List[i].bed.date_of_manufacture.getYear());
            }
        }
    }

    private void back_Button() {
        back.setBounds(130, 415, 90, 30);
        back.addActionListener(this);
        edit_frame.add(back);
    }

    private void next_Button() {
        next.setBounds(270, 415, 90, 30);
        edit_frame.add(next);
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

        if(s.equals("Seller")) {
            index_text.setText("Product " + (i + 1) + " of " + Main.s[Main.sell_index].active_product_count);
        }
        else if(s.equals("Renter"))
        {
            index_text.setText((" Product " + (i+1) + " of " + Main.r[Main.rent_index].active_Product_List_count) );
        }
        edit_frame.add(index_text);
    }

    public void next_button_func()
    {
        next.setEnabled(true);
        if(s.equals("Seller")) {
            if ((i + 1) == Main.s[Main.sell_index].active_product_count) {
                next.setEnabled(false);
            }
        }
        else if(s.equals("Renter")) {
            if ((i + 1) == Main.r[Main.rent_index].active_Product_List_count)
            {
                next.setEnabled(false);
            }
        }
    }

    void back_button(){
        ImageIcon back=new ImageIcon("back.png");
        Image b=back.getImage();
        Image b1=b.getScaledInstance(20,20,10);
        back.setImage(b1);

        back_b=new JButton(back);
        back_b.setBounds(10,10,30,30);
        back_b.setBackground(Color.lightGray);
        back_b.setBorderPainted(false);
        back_b.addActionListener(this);
        edit_frame.add(back_b);
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
            if(s.equals("Seller"))
            {
                Sell_product_panel.sell_frame.setVisible(true);
                edit_frame.dispose();
            }
            else if(s.equals("Renter"))
            {
                Rent_Product_panel.rent_frame.setVisible(true);
                edit_frame.dispose();
            }
        }
    }
}