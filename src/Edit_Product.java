import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Edit_Product implements ActionListener {
    public JFrame edit_frame=new JFrame("Edit Product");

    JLabel edit_text=new JLabel("EDIT PRODUCT");

    JLabel Id=new JLabel("Product ID : ");
    JTextField tf_Id=new JTextField(20);

    JLabel price=new JLabel("Price : ");
    JTextField tf_price=new JTextField(20);

    JLabel product_weight=new JLabel("Weight : ");
    JTextField tf_product_weight=new JTextField(20);

    JLabel product_name=new JLabel("Name : ");
    JTextField tf_product_name=new JTextField(20);

    JLabel DO=new JLabel("Date Of");
    JLabel M=new JLabel("Manufacture : ");
    JLabel day =new JLabel("Day");
    JLabel month=new JLabel("Month");
    JLabel year=new JLabel("Year");

    JLabel advance=new JLabel("Advance : ");
    JTextField tf_advance=new JTextField(20);

    JLabel interest =new JLabel("Interest : ");
    JTextField tf_interest=new JTextField(20);
    JLabel month_price=new JLabel("Monthly_price : ");
    JTextField tf_monthly_price=new JTextField(20);

    String []d=new String[31];
    String[]m=new String[12];
    String[]y=new String[31];

    JComboBox<String> Day = new JComboBox<>();
    JComboBox<String> Month = new JComboBox<>();
    JComboBox<String> Year = new JComboBox<>();



    JLabel l1=new JLabel();
    JLabel l2=new JLabel();
    JLabel l3=new JLabel();
    JLabel l4=new JLabel();



    JTextField t1=new JTextField(20);
    JTextField t2=new JTextField(20);
    JTextField t3=new JTextField(20);
    JTextField t4=new JTextField(20);


    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);

    JButton submit=new JButton("Submit");
    JButton back_b;

    GUI temp;
    String s;

    Edit_Product(GUI temp,String s)
    {
        this.temp=temp;
        this.s=s;

        frame_setting();
        edit_text();
        combo_boxes();
        label();
        field();
        Button();
        back_button();
    }

    void frame_setting()
    {
        edit_frame.setBounds(500,50,500,520);
        edit_frame.setVisible(true);
        edit_frame.setResizable(false);
        edit_frame.setLayout(null);
        edit_frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        edit_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void edit_text()
    {
        edit_text.setBounds(130,0,500,50);
        edit_text.setFont(f1);
        edit_frame.add(edit_text);
    }

    void label()
    {
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
        edit_frame.add(day);
        edit_frame.add(month);
        edit_frame.add(year);
    }

    private void combo_boxes()
    {
        date();
        Day=new JComboBox<>(d);
        Month=new JComboBox<>(m);
        Year=new JComboBox<>(y);


        edit_frame.add(Day);
        edit_frame.add(Month);
        edit_frame.add(Year);
    }


    private void date()
    {
        for(int i=0;i<31;i++)
        {
            d[i]=Integer.toString(i+1);
        }
        for(int i=0;i<12;i++)
        {
            m[i]=Integer.toString(i+1);
        }
        for(int i=0;i<31;i++)
        {
            y[i]=Integer.toString(1992+i);
        }
    }
    void field()
    {
        tf_Id.setBounds(120,50,330,25);
        tf_Id.setEditable(false);
        if(s.equals("Seller")) {
            tf_Id.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].product_ID);
        }
        else if(s.equals("Renter"))
        {
            tf_Id.setText(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].product_ID);
        }
        tf_Id.setBorder(null);
        edit_frame.add(tf_Id);

        tf_price.setBounds(120,80,330,25);
        if(s.equals("Seller")) {
            tf_price.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].price));
        }
        else if(s.equals("Renter"))
        {
            tf_price.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].price));
        }
        edit_frame.add(tf_price);
        tf_price.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tf_price.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
            }
        });

        tf_price.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tf_price.setEditable(true);
            }
        });

        tf_product_weight.setBounds(120,110,330,25);
        if(s.equals("Seller")) {
            tf_product_weight.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].weight));
        }
        else if(s.equals("Renter"))
        {
            tf_product_weight.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].weight));
        }
        edit_frame.add(tf_product_weight);
        tf_product_weight.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tf_product_weight.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
            }
        });

        tf_product_weight.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tf_product_weight.setEditable(true);
            }
        });

        tf_product_name.setBounds(120,140,330,25);
        if(s.equals("Seller")) {
            tf_product_name.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].name);
        }
        else if(s.equals("Renter"))
        {
            tf_product_name.setText(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].name);
        }
        tf_product_name.setEditable(false);
        tf_product_name.setBorder(null);
        edit_frame.add(tf_product_name);

        t1.setBounds(120,170,330,25);
        edit_frame.add(t1);

        t2.setBounds(120,200,330,25);
        edit_frame.add(t2);

        t3.setBounds(120,230,330,25);
        edit_frame.add(t3);

        t4.setBounds(120,260,330,25);
        edit_frame.add(t4);

        if (tf_product_name.getText().equals("Laptop")) {

            l1.setVisible(true);
            l2.setVisible(true);
            l3.setVisible(true);
            l4.setVisible(false);
            l1.setText("Memory : ");
            l2.setText("Battery Life : ");
            l3.setText("Company : ");


            t1.setVisible(true);
            t1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    t1.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
                }
            });

            t1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    t1.setEditable(true);
                }
            });

            t2.setVisible(true);
            t2.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    t2.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
                }
            });

            t2.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    t2.setEditable(true);
                }
            });

            t3.setVisible(true);
            t4.setVisible(false);


            DO.setBounds(20, 250, 500, 50);
            M.setBounds(20,265,500,50);
            day.setBounds(120, 242, 500, 50);
            month.setBounds(170, 242, 500, 50);
            year.setBounds(230, 242, 500, 50);


            Day.setBounds(120, 275, 40, 25);
            Month.setBounds(170, 275, 50, 25);
            Year.setBounds(230, 275, 60, 25);

            if(s.equals("Seller")) {

                t1.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].laptop.memory);
                t2.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].laptop.Battery_life));
                t3.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].laptop.company);
                Day.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].laptop.date_of_manufacture.getDay() - 1);
                Month.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].laptop.date_of_manufacture.getMonth() - 1);
                Year.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].laptop.date_of_manufacture.getYear() - 1992);

                if(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment!=null)
                {
                    advance.setBounds(20,295,500,50);
                    edit_frame.add(advance);

                    tf_advance.setBounds(120,305,330,25);
                    edit_frame.add(tf_advance);



                    interest.setBounds(20,325,500,50);
                    edit_frame.add(interest);

                    tf_interest.setBounds(120,335,330,25);
                    edit_frame.add(tf_interest);



                    month_price.setBounds(20,355,500,50);
                    edit_frame.add(month_price);

                    tf_monthly_price.setBounds(120,365,330,25);
                    edit_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.price_per_month));
                }
            }
            else if(s.equals("Renter"))
            {
                t1.setText(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].laptop.memory);
                t2.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].laptop.Battery_life));
                t3.setText(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].laptop.company);
                Day.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].laptop.date_of_manufacture.getDay() - 1);
                Month.setSelectedIndex(Main.r[Main.sell_index].active_product_List[Search_ID.Product_index].laptop.date_of_manufacture.getMonth() - 1);
                Year.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].laptop.date_of_manufacture.getYear() - 1992);

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
            t1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    t1.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
                }
            });

            t1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    t1.setEditable(true);
                }
            });

            t2.setVisible(true);
            t2.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    t2.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
                }
            });

            t2.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    t2.setEditable(true);
                }
            });

            t3.setVisible(true);
            t3.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    t3.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
                }
            });

            t3.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    t3.setEditable(true);
                }
            });

            t4.setVisible(true);

            DO.setBounds(20, 280, 500, 50);
            M.setBounds(20,295,500,50);
            day.setBounds(120, 272, 500, 50);
            month.setBounds(170, 272, 500, 50);
            year.setBounds(230, 272, 500, 50);


            Day.setBounds(120, 305, 40, 25);
            Month.setBounds(170, 305, 50, 25);
            Year.setBounds(230, 305, 60, 25);

            if(s.equals("Seller")) {
                t1.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].mobile.storage));
                t2.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].mobile.length));
                t3.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].mobile.width));
                t4.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].mobile.company);
                Day.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].mobile.date_of_manufacture.getDay() - 1);
                Month.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].mobile.date_of_manufacture.getMonth() - 1);
                Year.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].mobile.date_of_manufacture.getYear() - 1992);

                if(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment!=null)
                {
                    advance.setBounds(20,325,500,50);
                    edit_frame.add(advance);

                    tf_advance.setBounds(120,335,330,25);
                    edit_frame.add(tf_advance);



                    interest.setBounds(20,355,500,50);
                    edit_frame.add(interest);

                    tf_interest.setBounds(120,365,330,25);
                    edit_frame.add(tf_interest);



                    month_price.setBounds(20,385,500,50);
                    edit_frame.add(month_price);

                    tf_monthly_price.setBounds(120,395,330,25);
                    edit_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.price_per_month));
                }
            }
            else if(s.equals("Renter"))
            {
                t1.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].mobile.storage));
                t2.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].mobile.length));
                t3.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].mobile.width));
                t4.setText(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].mobile.company);
                Day.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].mobile.date_of_manufacture.getDay() - 1);
                Month.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].mobile.date_of_manufacture.getMonth() - 1);
                Year.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].mobile.date_of_manufacture.getYear() - 1992);

            }
        }
        else if (tf_product_name.getText().equals("Air conditioner")) {

            l1.setVisible(true);
            l2.setVisible(true);
            l3.setVisible(true);
            l3.setVisible(false);
            l1.setText("Power : ");
            l2.setText("Energy Efficiency : ");
            l3.setText("Company : ");

            t1.setVisible(true);
            t1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    t1.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
                }
            });

            t1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    t1.setEditable(true);
                }
            });

            t2.setVisible(true);
            t2.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    t2.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
                }
            });

            t2.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    t2.setEditable(true);
                }
            });

            t3.setVisible(true);
            t4.setVisible(false);

            DO.setBounds(20, 250, 500, 50);
            M.setBounds(20,265,500,50);
            day.setBounds(120, 242, 500, 50);
            month.setBounds(170, 242, 500, 50);
            year.setBounds(230, 242, 500, 50);


            Day.setBounds(120, 275, 40, 25);
            Month.setBounds(170, 275, 50, 25);
            Year.setBounds(230, 275, 60, 25);

            if(s.equals("Seller")) {
                t1.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].air_conditioner.power));
                t2.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].air_conditioner.energy_efficiency));
                t3.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].air_conditioner.company);
                Day.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].air_conditioner.date_of_manufacture.getDay() - 1);
                Month.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].air_conditioner.date_of_manufacture.getMonth() - 1);
                Year.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].air_conditioner.date_of_manufacture.getYear() - 1992);

                if(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment!=null)
                {
                    advance.setBounds(20,295,500,50);
                    edit_frame.add(advance);

                    tf_advance.setBounds(120,305,330,25);
                    edit_frame.add(tf_advance);



                    interest.setBounds(20,325,500,50);
                    edit_frame.add(interest);

                    tf_interest.setBounds(120,335,330,25);
                    edit_frame.add(tf_interest);



                    month_price.setBounds(20,355,500,50);
                    edit_frame.add(month_price);

                    tf_monthly_price.setBounds(120,365,330,25);
                    edit_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.price_per_month));
                }
            }
            else if(s.equals("Renter"))
            {
                t1.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].air_conditioner.power));
                t2.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].air_conditioner.energy_efficiency));
                t3.setText(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].air_conditioner.company);
                Day.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].air_conditioner.date_of_manufacture.getDay() - 1);
                Month.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].air_conditioner.date_of_manufacture.getMonth() - 1);
                Year.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].air_conditioner.date_of_manufacture.getYear() - 1992);

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
            t3.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    t3.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
                }
            });

            t3.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    t3.setEditable(true);
                }
            });

            t4.setVisible(true);

            DO.setBounds(20, 280, 500, 50);
            M.setBounds(20,295,500,50);
            day.setBounds(120, 272, 500, 50);
            month.setBounds(170, 272, 500, 50);
            year.setBounds(230, 272, 500, 50);


            Day.setBounds(120, 305, 40, 25);
            Month.setBounds(170, 305, 50, 25);
            Year.setBounds(230, 305, 60, 25);

            if(s.equals("Seller")) {
                t1.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].car.Brand);
                t2.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].car.Model);
                t3.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].car.MaximumSpeed));
                t4.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].car.Color);
                Day.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].car.date_of_manufacture.getDay() - 1);
                Month.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].car.date_of_manufacture.getMonth() - 1);
                Year.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].car.date_of_manufacture.getYear() - 1992);

                if(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment!=null)
                {
                    advance.setBounds(20,325,500,50);
                    edit_frame.add(advance);

                    tf_advance.setBounds(120,335,330,25);
                    edit_frame.add(tf_advance);



                    interest.setBounds(20,355,500,50);
                    edit_frame.add(interest);

                    tf_interest.setBounds(120,365,330,25);
                    edit_frame.add(tf_interest);



                    month_price.setBounds(20,385,500,50);
                    edit_frame.add(month_price);

                    tf_monthly_price.setBounds(120,395,330,25);
                    edit_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.price_per_month));
                }
            }
            else if(s.equals("Renter"))
            {
                t1.setText(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].car.Brand);
                t2.setText(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].car.Model);
                t3.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].car.MaximumSpeed));
                t4.setText(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].car.Color);
                Day.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].car.date_of_manufacture.getDay() - 1);
                Month.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].car.date_of_manufacture.getMonth() - 1);
                Year.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].car.date_of_manufacture.getYear() - 1992);

            }
        }
        else if (tf_product_name.getText().equals("Bike")) {

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
            t3.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    t3.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
                }
            });

            t3.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    t3.setEditable(true);
                }
            });

            t4.setVisible(true);

            DO.setBounds(20, 280, 500, 50);
            M.setBounds(20,295,500,50);
            day.setBounds(120, 272, 500, 50);
            month.setBounds(170, 272, 500, 50);
            year.setBounds(230, 272, 500, 50);


            Day.setBounds(120, 305, 40, 25);
            Month.setBounds(170, 305, 50, 25);
            Year.setBounds(230, 305, 60, 25);

            if(s.equals("Seller")) {
                t1.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].bike.Brand);
                t2.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].bike.Model);
                t3.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].bike.MaximumSpeed));
                t4.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].bike.Color);
                Day.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].bike.date_of_manufacture.getDay() - 1);
                Month.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].bike.date_of_manufacture.getMonth() - 1);
                Year.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].bike.date_of_manufacture.getYear() - 1992);

                if(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment!=null)
                {
                    advance.setBounds(20,325,500,50);
                    edit_frame.add(advance);

                    tf_advance.setBounds(120,335,330,25);
                    edit_frame.add(tf_advance);



                    interest.setBounds(20,355,500,50);
                    edit_frame.add(interest);

                    tf_interest.setBounds(120,365,330,25);
                    edit_frame.add(tf_interest);



                    month_price.setBounds(20,385,500,50);
                    edit_frame.add(month_price);

                    tf_monthly_price.setBounds(120,395,330,25);
                    edit_frame.add(tf_monthly_price);

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.price_per_month));
                }
            }
            else if(s.equals("Renter"))
            {
                t1.setText(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].bike.Brand);
                t2.setText(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].bike.Model);
                t3.setText(String.valueOf(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].bike.MaximumSpeed));
                t4.setText(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].bike.Color);
                Day.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].bike.date_of_manufacture.getDay() - 1);
                Month.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].bike.date_of_manufacture.getMonth() - 1);
                Year.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].bike.date_of_manufacture.getYear() - 1992);

            }
        }
        else if (tf_product_name.getText().equals("Chair")) {

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

            DO.setBounds(20, 220, 500, 50);
            M.setBounds(20,235,500,50);
            day.setBounds(120, 212, 500, 50);
            month.setBounds(170, 212, 500, 50);
            year.setBounds(230, 212, 500, 50);


            Day.setBounds(120, 245, 40, 25);
            Month.setBounds(170, 245, 50, 25);
            Year.setBounds(230, 245, 60, 25);

            if(s.equals("Seller")) {
                t1.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].chair.Material);
                t2.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].chair.Color);
                Day.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].chair.date_of_manufacture.getDay() - 1);
                Month.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].chair.date_of_manufacture.getMonth() - 1);
                Year.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].chair.date_of_manufacture.getYear() - 1992);

                if(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment!=null)
                {
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

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.price_per_month));
                }
            }
            else if(s.equals("Renter"))
            {
                t1.setText(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].chair.Material);
                t2.setText(Main.r[Main.sell_index].active_product_List[Search_ID.Product_index].chair.Color);
                Day.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].chair.date_of_manufacture.getDay() - 1);
                Month.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].car.date_of_manufacture.getMonth() - 1);
                Year.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].chair.date_of_manufacture.getYear() - 1992);
            }


        }
        else if (tf_product_name.getText().equals("Table")) {

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

            DO.setBounds(20, 220, 500, 50);
            M.setBounds(20,235,500,50);
            day.setBounds(120, 212, 500, 50);
            month.setBounds(170, 212, 500, 50);
            year.setBounds(230, 212, 500, 50);


            Day.setBounds(120, 245, 40, 25);
            Month.setBounds(170, 245, 50, 25);
            Year.setBounds(230, 245, 60, 25);

            if(s.equals("Seller")) {
                t1.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].table.Material);
                t2.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].table.Color);
                Day.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].table.date_of_manufacture.getDay() - 1);
                Month.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].table.date_of_manufacture.getMonth() - 1);
                Year.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].table.date_of_manufacture.getYear() - 1992);

                if(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment!=null)
                {
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

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.price_per_month));
                }
            }
            else if(s.equals("Renter"))
            {
                t1.setText(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].table.Material);
                t2.setText(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].table.Color);
                Day.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].table.date_of_manufacture.getDay() - 1);
                Month.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].table.date_of_manufacture.getMonth() - 1);
                Year.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].table.date_of_manufacture.getYear() - 1992);
            }

        }
        else if (tf_product_name.getText().equals("Bed")) {

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

            DO.setBounds(20, 220, 500, 50);
            M.setBounds(20,235,500,50);
            day.setBounds(120, 212, 500, 50);
            month.setBounds(170, 212, 500, 50);
            year.setBounds(230, 212, 500, 50);


            Day.setBounds(120, 245, 40, 25);
            Month.setBounds(170, 245, 50, 25);
            Year.setBounds(230, 245, 60, 25);

            if(s.equals("Seller")) {
                t1.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].bed.Material);
                t2.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].bed.Color);
                Day.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].bed.date_of_manufacture.getDay() - 1);
                Month.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].bed.date_of_manufacture.getMonth() - 1);
                Year.setSelectedIndex(Main.s[Main.sell_index].active_product[Search_ID.Product_index].bed.date_of_manufacture.getYear() - 1992);

                if(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment!=null)
                {
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

                    tf_advance.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.advance));
                    tf_interest.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.interest));
                    tf_monthly_price.setText(String.valueOf(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.price_per_month));
                }
            }
            else if(s.equals("Renter"))
            {
                t1.setText(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].bed.Material);
                t2.setText(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].bed.Color);
                Day.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].bed.date_of_manufacture.getDay() - 1);
                Month.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].bed.date_of_manufacture.getMonth() - 1);
                Year.setSelectedIndex(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].bed.date_of_manufacture.getYear() - 1992);
            }


        }
    }

    void Button()
    {
        submit.setBounds(200,430,100,40);
        edit_frame.add(submit);
        submit.addActionListener(this);
    }

    private void back_button(){
        ImageIcon back=new ImageIcon("E:\\back.jpeg");
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

        if (e.getSource().equals(submit)) {
            if(tf_product_name.getText().equals("Laptop"))
            {
                Laptop l=new Laptop();
                l.set_laptop_data(tf_Id.getText(),tf_price.getText(),t3.getText(),tf_product_weight.getText(),t1.getText(), t2.getText(),Day.getSelectedIndex()+1,Month.getSelectedIndex()+1,Year.getSelectedIndex()+1992);

                if(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment!=null) {
                    l.installment.set_inst_data(Float.parseFloat(tf_advance.getText()), Float.parseFloat(tf_interest.getText()), Float.parseFloat(tf_monthly_price.getText()));
                }

                if(s.equals("Seller")) {
                    Main.s[Main.sell_index].active_product[Search_ID.Product_index] = l;
                }
                else if(s.equals("Renter"))
                {
                    Main.r[Main.rent_index].active_product_List[Search_ID.Product_index]=l;
                }
            }
            else if (tf_product_name.getText().equals("Mobile"))
            {
                Mobile m=new Mobile();
                m.set_Mobile_data(tf_Id.getText(),tf_price.getText(),tf_product_weight.getText(),t4.getText(),t1.getText(),t2.getText(),t3.getText(),Day.getSelectedIndex()+1,Month.getSelectedIndex()+1,Year.getSelectedIndex()+1992);

                if(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment!=null) {
                    m.installment.set_inst_data(Float.parseFloat(tf_advance.getText()), Float.parseFloat(tf_interest.getText()), Float.parseFloat(tf_monthly_price.getText()));
                }

                if(s.equals("Seller")) {
                    Main.s[Main.sell_index].active_product[Search_ID.Product_index] = m;
                }
                else if(s.equals("Renter"))
                {
                    Main.r[Main.rent_index].active_product_List[Search_ID.Product_index]=m;
                }
            }
            else if (tf_product_name.getText().equals("Air conditioner"))
            {
                Air_conditioner ac=new Air_conditioner();
                ac.set_Air_Conditioner_data(tf_Id.getText(),tf_price.getText(),tf_product_weight.getText(),t3.getText(),t1.getText(),t2.getText(),Day.getSelectedIndex()+1,Month.getSelectedIndex()+1,Year.getSelectedIndex()+1992);

                if(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment!=null) {
                    ac.installment.set_inst_data(Float.parseFloat(tf_advance.getText()), Float.parseFloat(tf_interest.getText()), Float.parseFloat(tf_monthly_price.getText()));
                }

                if(s.equals("Seller")) {
                    Main.s[Main.sell_index].active_product[Search_ID.Product_index] = ac;
                }
                else if(s.equals("Renter"))
                {
                    Main.r[Main.rent_index].active_product_List[Search_ID.Product_index]=ac;
                }
            }
            else if(tf_product_name.getText().equals("Chair"))
            {
                Chair c=new Chair();
                c.set_chair_data(tf_Id.getText(),tf_price.getText(),tf_product_weight.getText(), t2.getText(), t1.getText(),Day.getSelectedIndex()+1,Month.getSelectedIndex()+1,Year.getSelectedIndex()+1992);

                if(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment!=null) {
                    c.installment.set_inst_data(Float.parseFloat(tf_advance.getText()), Float.parseFloat(tf_interest.getText()), Float.parseFloat(tf_monthly_price.getText()));
                }

                if(s.equals("Seller")) {
                    Main.s[Main.sell_index].active_product[Search_ID.Product_index] = c;
                }
                else if(s.equals("Renter"))
                {
                    Main.r[Main.rent_index].active_product_List[Search_ID.Product_index]=c;
                }
            }
            else if(tf_product_name.getText().equals("Table"))
            {
                Table t=new Table();
                t.set_Table_data(tf_Id.getText(),tf_price.getText(),tf_product_weight.getText(), t2.getText(), t1.getText(),Day.getSelectedIndex()+1,Month.getSelectedIndex()+1,Year.getSelectedIndex()+1992);

                if(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment!=null) {
                    t.installment.set_inst_data(Float.parseFloat(tf_advance.getText()), Float.parseFloat(tf_interest.getText()), Float.parseFloat(tf_monthly_price.getText()));
                }

                if(s.equals("Seller")) {
                    Main.s[Main.sell_index].active_product[Search_ID.Product_index] = t;
                }
                else if(s.equals("Renter"))
                {
                    Main.r[Main.rent_index].active_product_List[Search_ID.Product_index]=t;
                }
            }
            else if (tf_product_name.getText().equals("Bed"))
            {
                Bed b=new Bed();
                b.set_Bed_data(tf_Id.getText(),tf_price.getText(),tf_product_weight.getText(), t2.getText(), t1.getText(),Day.getSelectedIndex()+1,Month.getSelectedIndex()+1,Year.getSelectedIndex()+1992);

                if(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment!=null) {
                    b.installment.set_inst_data(Float.parseFloat(tf_advance.getText()), Float.parseFloat(tf_interest.getText()), Float.parseFloat(tf_monthly_price.getText()));
                }

                if(s.equals("Seller")) {
                    Main.s[Main.sell_index].active_product[Search_ID.Product_index] = b;
                }
                else if(s.equals("Renter"))
                {
                    Main.r[Main.rent_index].active_product_List[Search_ID.Product_index] = b;
                }
            }
            else if(tf_product_name.getText().equals("Car"))
            {
                Car c=new Car();
                c.set_Car_data(tf_Id.getText(),tf_price.getText(),tf_product_weight.getText(), t1.getText(),t2.getText(),t3.getText(),t4.getText(),Day.getSelectedIndex()+1,Month.getSelectedIndex()+1,Year.getSelectedIndex()+1992);

                if(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment!=null) {
                    c.installment.set_inst_data(Float.parseFloat(tf_advance.getText()), Float.parseFloat(tf_interest.getText()), Float.parseFloat(tf_monthly_price.getText()));
                }

                if(s.equals("Seller")) {
                    Main.s[Main.sell_index].active_product[Search_ID.Product_index] = c;
                }
                else if(s.equals("Renter"))
                {
                    Main.r[Main.rent_index].active_product_List[Search_ID.Product_index] = c;
                }
            }
            else if(tf_product_name.getText().equals("Bike"))
            {
                Bike b=new Bike();
                b.set_Bike_data(tf_Id.getText(),tf_price.getText(),tf_product_weight.getText(), t1.getText(),t2.getText(),t3.getText(),t4.getText(),Day.getSelectedIndex()+1,Month.getSelectedIndex()+1,Year.getSelectedIndex()+1992);

                if(Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment!=null) {
                    b.installment.set_inst_data(Float.parseFloat(tf_advance.getText()), Float.parseFloat(tf_interest.getText()), Float.parseFloat(tf_monthly_price.getText()));
                }

                if(s.equals("Seller")) {
                    Main.s[Main.sell_index].active_product[Search_ID.Product_index] = b;
                }
                else if(s.equals("Renter"))
                {
                    Main.r[Main.rent_index].active_product_List[Search_ID.Product_index] = b;
                }
            }

            if(s.equals("Seller"))
            {
                JOptionPane.showMessageDialog(null, "Successfully Edit");
                edit_frame.dispose();
                Product_info.prod_frame.setVisible(true);
            }
            else if(s.equals("Renter"))
            {
                JOptionPane.showMessageDialog(null, "Successfully Edit");
                edit_frame.dispose();
                Rent_Product_Info.r_prod_frame.setVisible(true);
            }
        }
        else if(e.getSource().equals(back_b))
        {
            edit_frame.dispose();
            if(s.equals("Seller")) {
                Product_info.prod_frame.setVisible(true);
            }
            else if(s.equals("Renter"))
            {
                Rent_Product_Info.r_prod_frame.setVisible(true);
            }
        }

    }

}