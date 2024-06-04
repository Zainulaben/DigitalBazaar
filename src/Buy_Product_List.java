import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buy_Product_List implements ActionListener {
    JFrame frame = new JFrame("Buy product list");

    JLabel buy_text = new JLabel("BOUGHT PRODUCTS");

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

    JButton back_b;

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

    JLabel days=new JLabel("No. of days : ");
    JTextField tf_days=new JTextField(20);

    JLabel price_per_day=new JLabel("Price Per Day : ");
    JTextField tf_price_per_day=new JTextField(20);

    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);

    JButton back = new JButton("Back");
    JButton next = new JButton("Next");


    GUI temp;
    static int i = 0;

    Buy_Product_List(GUI temp) {
        this.temp = temp;


        frame_setting();
        edit_text();
        label();
        field();
        Back_Button();
        back_Button();
        next_Button();
        back_button_func();
        next_button_func();

    }

    void frame_setting() {
        frame.setBounds(500, 50, 500, 520);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void edit_text() {
        buy_text.setBounds(130, 0, 500, 50);
        buy_text.setFont(f1);
        frame.add(buy_text);
    }

    void label() {
        Id.setBounds(20,35,500,50);
        frame.add(Id);

        price.setBounds(20,65,500,50);
        frame.add(price);

        product_weight.setBounds(20,95,500,50);
        frame.add(product_weight);

        product_name.setBounds(20,125,500,50);
        frame.add(product_name);

        l1.setBounds(20,155,500,50);
        l1.setVisible(false);
        frame.add(l1);

        l2.setBounds(20,185,500,50);
        l2.setVisible(false);
        frame.add(l2);

        l3.setBounds(20,215,500,50);
        l3.setVisible(false);
        frame.add(l3);

        l4.setBounds(20,245,500,50);
        l4.setVisible(false);
        frame.add(l4);


        frame.add(DO);
        frame.add(M);
    }

    void field() {
        advance.setVisible(false);
        interest.setVisible(false);
        month_price.setVisible(false);
        days.setVisible(false);
        price_per_day.setVisible(false);

        tf_advance.setVisible(false);
        tf_advance.setEditable(false);
        tf_advance.setBorder(null);
        tf_advance.setBackground(Color.lightGray);

        tf_interest.setVisible(false);
        tf_interest.setEditable(false);
        tf_interest.setBorder(null);
        tf_interest.setBackground(Color.lightGray);

        tf_monthly_price.setEditable(false);
        tf_monthly_price.setBorder(null);
        tf_monthly_price.setBackground(Color.lightGray);
        tf_monthly_price.setVisible(false);

        tf_days.setVisible(false);
        tf_days.setBorder(null);
        tf_days.setEditable(false);
        tf_days.setBackground(Color.lightGray);

        tf_price_per_day.setVisible(false);
        tf_price_per_day.setBorder(null);
        tf_price_per_day.setEditable(false);
        tf_price_per_day.setBackground(Color.lightGray);



        tf_Id.setBounds(120,50,330,25);
        tf_Id.setEditable(false);
        tf_Id.setText(Main.b[Main.buy_index].buy_product[i].product_ID);
        tf_Id.setBorder(null);
        tf_Id.setBackground(Color.lightGray);
        frame.add(tf_Id);

        tf_price.setBounds(120,80,330,25);
        tf_price.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].price));
        tf_price.setEditable(false);
        tf_price.setBorder(null);
        tf_price.setBackground(Color.lightGray);
        frame.add(tf_price);

        tf_product_weight.setBounds(120,110,330,25);
        tf_product_weight.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].weight));
        tf_product_weight.setEditable(false);
        tf_product_weight.setBorder(null);
        tf_product_weight.setBackground(Color.lightGray);
        frame.add(tf_product_weight);

        tf_product_name.setBounds(120,140,330,25);
        tf_product_name.setText(Main.b[Main.buy_index].buy_product[i].name);
        tf_product_name.setEditable(false);
        tf_product_name.setBorder(null);
        tf_product_name.setBackground(Color.lightGray);
        frame.add(tf_product_name);

        t1.setBounds(120,170,330,25);
        t1.setEditable(false);
        t1.setBorder(null);
        t1.setBackground(Color.lightGray);
        frame.add(t1);

        t2.setBounds(120,200,330,25);
        t2.setEditable(false);
        t2.setBorder(null);
        t2.setBackground(Color.lightGray);
        frame.add(t2);

        t3.setBounds(120,230,330,25);
        t3.setEditable(false);
        t3.setBorder(null);
        t3.setBackground(Color.lightGray);
        frame.add(t3);

        t4.setBounds(120,260,330,25);
        t4.setEditable(false);
        t4.setBorder(null);
        t4.setBackground(Color.lightGray);
        frame.add(t4);


        tf_date_of_manufacture.setEditable(false);
        tf_date_of_manufacture.setBorder(null);
        tf_date_of_manufacture.setBackground(Color.lightGray);
        frame.add(tf_date_of_manufacture);


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
            t1.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].laptop.memory));
            t2.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].laptop.Battery_life));
            t3.setText(Main.b[Main.buy_index].buy_product[i].laptop.company);

            DO.setBounds(20, 245, 500, 50);
            M.setBounds(20,260,500,50);

            tf_date_of_manufacture.setBounds(120,265,330,25);
            tf_date_of_manufacture.setText(Main.b[Main.buy_index].buy_product[i].laptop.date_of_manufacture.getDay()+"/"+Main.b[Main.buy_index].buy_product[i].laptop.date_of_manufacture.getMonth()+"/"+Main.b[Main.buy_index].buy_product[i].laptop.date_of_manufacture.getYear());

            if(Main.b[Main.buy_index].buy_product[i].installment!=null)
            {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20,285,500,50);
                frame.add(advance);

                tf_advance.setBounds(120,295,330,25);
                frame.add(tf_advance);



                interest.setBounds(20,315,500,50);
                frame.add(interest);

                tf_interest.setBounds(120,325,330,25);
                frame.add(tf_interest);



                month_price.setBounds(20,345,500,50);
                frame.add(month_price);

                tf_monthly_price.setBounds(120,355,330,25);
                frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.advance));
                tf_interest.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].laptop.installment.interest));
                tf_monthly_price.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].laptop.installment.price_per_month));
            }

            if(Main.b[Main.buy_index].buy_product[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                price_per_day.setVisible(true);
                tf_price_per_day.setVisible(true);

                days.setBounds(20,285,500,50);
                frame.add(days);

                tf_days.setBounds(120,295,330,25);
                frame.add(tf_days);

                price_per_day.setBounds(20,315,500,50);
                frame.add(price_per_day);

                tf_price_per_day.setBounds(120,325,330,25);
                frame.add(tf_price_per_day);

                tf_days.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].rent.no_of_days));
                tf_price_per_day.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].rent.price_per_day));

                price.setText("Total Price : ");

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
            t1.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].mobile.storage));
            t2.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].mobile.length));
            t3.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].mobile.width));
            t4.setText(Main.b[Main.buy_index].buy_product[i].mobile.company);

            DO.setBounds(20, 275, 500, 50);
            M.setBounds(20,290,500,50);

            tf_date_of_manufacture.setBounds(120,290,330,25);
            tf_date_of_manufacture.setText(Main.b[Main.buy_index].buy_product[i].mobile.date_of_manufacture.getDay()+"/"+Main.b[Main.buy_index].buy_product[i].mobile.date_of_manufacture.getMonth()+"/"+Main.b[Main.buy_index].buy_product[i].mobile.date_of_manufacture.getYear());


            if(Main.b[Main.buy_index].buy_product[i].installment!=null)
            {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20,315,500,50);
                frame.add(advance);

                tf_advance.setBounds(120,325,330,25);
                frame.add(tf_advance);



                interest.setBounds(20,345,500,50);
                frame.add(interest);

                tf_interest.setBounds(120,355,330,25);
                frame.add(tf_interest);



                month_price.setBounds(20,375,500,50);
                frame.add(month_price);

                tf_monthly_price.setBounds(120,385,330,25);
                frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.advance));
                tf_interest.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.interest));
                tf_monthly_price.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.price_per_month));
            }

            if(Main.b[Main.buy_index].buy_product[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                price_per_day.setVisible(true);
                tf_price_per_day.setVisible(true);

                days.setBounds(20,315,500,50);
                frame.add(days);

                tf_days.setBounds(120,325,330,25);
                frame.add(tf_days);

                price_per_day.setBounds(20,345,500,50);
                frame.add(price_per_day);

                tf_price_per_day.setBounds(120,355,330,25);
                frame.add(tf_price_per_day);

                tf_days.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].rent.no_of_days));
                tf_price_per_day.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].rent.price_per_day));

                price.setText("Total Price : ");

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
            t1.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].air_conditioner.power));
            t2.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].air_conditioner.energy_efficiency));
            t3.setText(Main.b[Main.buy_index].buy_product[i].air_conditioner.company);

            DO.setBounds(20, 245, 500, 50);
            M.setBounds(20,260,500,50);

            tf_date_of_manufacture.setBounds(120,265,330,25);
            tf_date_of_manufacture.setText(Main.b[Main.buy_index].buy_product[i].air_conditioner.date_of_manufacture.getDay()+"/"+Main.b[Main.buy_index].buy_product[i].air_conditioner.date_of_manufacture.getMonth()+"/"+Main.b[Main.buy_index].buy_product[i].air_conditioner.date_of_manufacture.getYear());

            if(Main.b[Main.buy_index].buy_product[i].installment!=null)
            {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20,285,500,50);
                frame.add(advance);

                tf_advance.setBounds(120,295,330,25);
                frame.add(tf_advance);



                interest.setBounds(20,315,500,50);
                frame.add(interest);

                tf_interest.setBounds(120,325,330,25);
                frame.add(tf_interest);



                month_price.setBounds(20,345,500,50);
                frame.add(month_price);

                tf_monthly_price.setBounds(120,355,330,25);
                frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.advance));
                tf_interest.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.interest));
                tf_monthly_price.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.price_per_month));
            }

            if(Main.b[Main.buy_index].buy_product[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                price_per_day.setVisible(true);
                tf_price_per_day.setVisible(true);

                days.setBounds(20,285,500,50);
                frame.add(days);

                tf_days.setBounds(120,295,330,25);
                frame.add(tf_days);

                price_per_day.setBounds(20,315,500,50);
                frame.add(price_per_day);

                tf_price_per_day.setBounds(120,325,330,25);
                frame.add(tf_price_per_day);

                tf_days.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].rent.no_of_days));
                tf_price_per_day.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].rent.price_per_day));

                price.setText("Total Price : ");

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
            t1.setText(Main.b[Main.buy_index].buy_product[i].car.Brand);
            t2.setText(Main.b[Main.buy_index].buy_product[i].car.Model);
            t3.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].car.MaximumSpeed));
            t4.setText(Main.b[Main.buy_index].buy_product[i].car.Color);

            DO.setBounds(20, 275, 500, 50);
            M.setBounds(20,290,500,50);

            tf_date_of_manufacture.setBounds(120,290,330,25);
            tf_date_of_manufacture.setText(Main.b[Main.buy_index].buy_product[i].car.date_of_manufacture.getDay()+"/"+Main.b[Main.buy_index].buy_product[i].car.date_of_manufacture.getMonth()+"/"+Main.b[Main.buy_index].buy_product[i].car.date_of_manufacture.getYear());

            if(Main.b[Main.buy_index].buy_product[i].installment!=null)
            {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20,315,500,50);
                frame.add(advance);

                tf_advance.setBounds(120,325,330,25);
                frame.add(tf_advance);



                interest.setBounds(20,345,500,50);
                frame.add(interest);

                tf_interest.setBounds(120,355,330,25);
                frame.add(tf_interest);



                month_price.setBounds(20,375,500,50);
                frame.add(month_price);

                tf_monthly_price.setBounds(120,385,330,25);
                frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.advance));
                tf_interest.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.interest));
                tf_monthly_price.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.price_per_month));
            }

            if(Main.b[Main.buy_index].buy_product[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                price_per_day.setVisible(true);
                tf_price_per_day.setVisible(true);

                days.setBounds(20,315,500,50);
                frame.add(days);

                tf_days.setBounds(120,325,330,25);
                frame.add(tf_days);

                price_per_day.setBounds(20,345,500,50);
                frame.add(price_per_day);

                tf_price_per_day.setBounds(120,355,330,25);
                frame.add(tf_price_per_day);

                tf_days.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].rent.no_of_days));
                tf_price_per_day.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].rent.price_per_day));

                price.setText("Total Price : ");

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
            t1.setText(Main.b[Main.buy_index].buy_product[i].bike.Brand);
            t2.setText(Main.b[Main.buy_index].buy_product[i].bike.Model);
            t3.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].bike.MaximumSpeed));
            t4.setText(Main.b[Main.buy_index].buy_product[i].bike.Color);

            DO.setBounds(20, 275, 500, 50);
            M.setBounds(20,290,500,50);

            tf_date_of_manufacture.setBounds(120,290,330,25);
            tf_date_of_manufacture.setText(Main.b[Main.buy_index].buy_product[i].bike.date_of_manufacture.getDay()+"/"+Main.b[Main.buy_index].buy_product[i].bike.date_of_manufacture.getMonth()+"/"+Main.b[Main.buy_index].buy_product[i].bike.date_of_manufacture.getYear());


            if(Main.b[Main.buy_index].buy_product[i].installment!=null)
            {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20,315,500,50);
                frame.add(advance);

                tf_advance.setBounds(120,325,330,25);
                frame.add(tf_advance);



                interest.setBounds(20,345,500,50);
                frame.add(interest);

                tf_interest.setBounds(120,355,330,25);
                frame.add(tf_interest);



                month_price.setBounds(20,375,500,50);
                frame.add(month_price);

                tf_monthly_price.setBounds(120,385,330,25);
                frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.advance));
                tf_interest.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.interest));
                tf_monthly_price.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.price_per_month));
            }


            if(Main.b[Main.buy_index].buy_product[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                price_per_day.setVisible(true);
                tf_price_per_day.setVisible(true);

                days.setBounds(20,315,500,50);
                frame.add(days);

                tf_days.setBounds(120,325,330,25);
                frame.add(tf_days);

                price_per_day.setBounds(20,345,500,50);
                frame.add(price_per_day);

                tf_price_per_day.setBounds(120,355,330,25);
                frame.add(tf_price_per_day);

                tf_days.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].rent.no_of_days));
                tf_price_per_day.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].rent.price_per_day));

                price.setText("Total Price : ");

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
            t1.setText(Main.b[Main.buy_index].buy_product[i].chair.Material);
            t2.setText(Main.b[Main.buy_index].buy_product[i].chair.Color);

            DO.setBounds(20, 220, 500, 50);
            M.setBounds(20,235,500,50);

            tf_date_of_manufacture.setBounds(120,235,330,30);
            tf_date_of_manufacture.setText(Main.b[Main.buy_index].buy_product[i].chair.date_of_manufacture.getDay()+"/"+Main.b[Main.buy_index].buy_product[i].chair.date_of_manufacture.getMonth()+"/"+Main.b[Main.buy_index].buy_product[i].chair.date_of_manufacture.getYear());

            if(Main.b[Main.buy_index].buy_product[i].installment!=null)
            {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20,265,500,50);
                frame.add(advance);

                tf_advance.setBounds(120,275,330,25);
                frame.add(tf_advance);



                interest.setBounds(20,295,500,50);
                frame.add(interest);

                tf_interest.setBounds(120,305,330,25);
                frame.add(tf_interest);



                month_price.setBounds(20,325,500,50);
                frame.add(month_price);

                tf_monthly_price.setBounds(120,335,330,25);
                frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.advance));
                tf_interest.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.interest));
                tf_monthly_price.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.price_per_month));
            }


            if(Main.b[Main.buy_index].buy_product[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                price_per_day.setVisible(true);
                tf_price_per_day.setVisible(true);

                days.setBounds(20,265,500,50);
                frame.add(days);

                tf_days.setBounds(120,275,330,25);
                frame.add(tf_days);

                price_per_day.setBounds(20,295,500,50);
                frame.add(price_per_day);

                tf_price_per_day.setBounds(120,305,330,25);
                frame.add(tf_price_per_day);

                tf_days.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].rent.no_of_days));
                tf_price_per_day.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].rent.price_per_day));

                price.setText("Total Price : ");

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
            t1.setText(Main.b[Main.buy_index].buy_product[i].table.Material);
            t2.setText(Main.b[Main.buy_index].buy_product[i].table.Color);

            DO.setBounds(20, 220, 500, 50);
            M.setBounds(20,235,500,50);

            tf_date_of_manufacture.setBounds(120,235,330,30);
            tf_date_of_manufacture.setText(Main.b[Main.buy_index].buy_product[i].table.date_of_manufacture.getDay()+"/"+Main.b[Main.buy_index].buy_product[i].table.date_of_manufacture.getMonth()+"/"+Main.b[Main.buy_index].buy_product[i].table.date_of_manufacture.getYear());

            if(Main.b[Main.buy_index].buy_product[i].installment!=null)
            {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20,265,500,50);
                frame.add(advance);

                tf_advance.setBounds(120,275,330,25);
                frame.add(tf_advance);



                interest.setBounds(20,295,500,50);
                frame.add(interest);

                tf_interest.setBounds(120,305,330,25);
                frame.add(tf_interest);



                month_price.setBounds(20,325,500,50);
                frame.add(month_price);

                tf_monthly_price.setBounds(120,335,330,25);
                frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.advance));
                tf_interest.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.interest));
                tf_monthly_price.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.price_per_month));
            }

            if(Main.b[Main.buy_index].buy_product[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                price_per_day.setVisible(true);
                tf_price_per_day.setVisible(true);

                days.setBounds(20,265,500,50);
                frame.add(days);

                tf_days.setBounds(120,275,330,25);
                frame.add(tf_days);

                price_per_day.setBounds(20,295,500,50);
                frame.add(price_per_day);

                tf_price_per_day.setBounds(120,305,330,25);
                frame.add(tf_price_per_day);

                tf_days.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].rent.no_of_days));
                tf_price_per_day.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].rent.price_per_day));

                price.setText("Total Price : ");

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
            t1.setText(Main.b[Main.buy_index].buy_product[i].bed.Material);
            t2.setText(Main.b[Main.buy_index].buy_product[i].bed.Color);

            DO.setBounds(20, 220, 500, 50);
            M.setBounds(20,235,500,50);

            tf_date_of_manufacture.setBounds(120,235,330,30);
            tf_date_of_manufacture.setText(Main.b[Main.buy_index].buy_product[i].bed.date_of_manufacture.getDay()+"/"+Main.b[Main.buy_index].buy_product[i].bed.date_of_manufacture.getMonth()+"/"+Main.b[Main.buy_index].buy_product[i].bed.date_of_manufacture.getYear());

            if(Main.b[Main.buy_index].buy_product[i].installment!=null)
            {
                advance.setVisible(true);
                interest.setVisible(true);
                month_price.setVisible(true);

                tf_advance.setVisible(true);
                tf_interest.setVisible(true);
                tf_monthly_price.setVisible(true);

                advance.setBounds(20,265,500,50);
                frame.add(advance);

                tf_advance.setBounds(120,275,330,25);
                frame.add(tf_advance);



                interest.setBounds(20,295,500,50);
                frame.add(interest);

                tf_interest.setBounds(120,305,330,25);
                frame.add(tf_interest);



                month_price.setBounds(20,325,500,50);
                frame.add(month_price);

                tf_monthly_price.setBounds(120,335,330,25);
                frame.add(tf_monthly_price);

                tf_advance.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.advance));
                tf_interest.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.interest));
                tf_monthly_price.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].installment.price_per_month));
            }


            if(Main.b[Main.buy_index].buy_product[i].rent!=null)
            {
                days.setVisible(true);
                tf_days.setVisible(true);

                price_per_day.setVisible(true);
                tf_price_per_day.setVisible(true);

                days.setBounds(20,265,500,50);
                frame.add(days);

                tf_days.setBounds(120,275,330,25);
                frame.add(tf_days);

                price_per_day.setBounds(20,295,500,50);
                frame.add(price_per_day);

                tf_price_per_day.setBounds(120,305,330,25);
                frame.add(tf_price_per_day);

                tf_days.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].rent.no_of_days));
                tf_price_per_day.setText(String.valueOf(Main.b[Main.buy_index].buy_product[i].rent.price_per_day));

                price.setText("Total Price : ");

            }
        }
    }

    void back_Button() {
        back.setBounds(130, 415, 90, 30);
        back.addActionListener(this);
        frame.add(back);
    }

    void next_Button() {
        next.setBounds(270, 415, 90, 30);
        frame.add(next);
        next.addActionListener(this);
    }

    void back_button_func()
    {
        back.setEnabled(true);
        if(i==0)
        {
            back.setEnabled(false);
        }
        index_text.setBounds(200, 445, 100, 40);
        index_text.setText("Product " + (i+1) + " of " + Main.b[Main.buy_index].buy_product_count);
        frame.add(index_text);
    }


    void next_button_func()
    {
        next.setEnabled(true);
        if((i+1)==Main.b[Main.buy_index].buy_product_count)
        {
            next.setEnabled(false);
        }
    }


    void Back_Button(){
        ImageIcon back=new ImageIcon("back.png");
        Image b=back.getImage();
        Image b1=b.getScaledInstance(20,20,10);
        back.setImage(b1);

        back_b=new JButton(back);
        back_b.setBounds(10,10,30,30);
        back_b.setBackground(Color.lightGray);
        back_b.setBorderPainted(false);
        back_b.addActionListener(this);
        frame.add(back_b);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(back_b))
        {
            new Buy_product_panel(temp);
            frame.dispose();
        }
        if (e.getSource().equals(back))
        {
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

    }

}