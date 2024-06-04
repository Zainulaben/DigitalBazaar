import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bike_info implements ActionListener {

    JFrame bike_frame=new JFrame("Bike");
    JLabel bike_l = new JLabel("BIKE INFO");
    JLabel id=new JLabel("Product ID : ");
    JLabel price=new JLabel("Price : ");
    JLabel weight=new JLabel("Weight : ");
    JLabel brand =new JLabel("Brand : ");
    JLabel model=new JLabel("Model : ");
    JLabel maximum_speed=new JLabel("Maximum Speed : ");
    JLabel color=new JLabel("Color : ");
    JLabel DO=new JLabel("Date Of");
    JLabel M=new JLabel("Manufacture : ");
    JLabel day =new JLabel("Day");
    JLabel month=new JLabel("Month");
    JLabel year=new JLabel("Year");

    JTextField tf_id=new JTextField(20);
    JButton submit = new JButton("Submit");
    JButton clear = new JButton("Clear");

    JTextField tf_price=new JTextField(20);
    JTextField tf_weight=new JTextField(20);
    JTextField tf_brand=new JTextField(20);
    JTextField tf_model=new JTextField(20);
    JTextField tf_maximum_speed=new JTextField(20);
    JTextField tf_color=new JTextField(20);
    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);


    String []d=new String[31];
    String[]m=new String[12];
    String[]y=new String[31];

    JComboBox<String> Day = new JComboBox<>();
    JComboBox<String> Month = new JComboBox<>();
    JComboBox<String> Year = new JComboBox<>();

    JButton back_b;

    GUI temp;
    String s;

    Bike_info(GUI temp,String s)
    {
        this.temp=temp;
        this.s=s;

        frame_setting();
        signup_text();
        labels();
        text_fields();
        Submit_Button();
        Clear_Button();
        back_button();
        combo_boxes();
    }


    private void signup_text()
    {
        bike_l.setBounds(170, 0, 500, 50);
        bike_l.setFont(f1);
        bike_frame.add(bike_l);
    }
    private void frame_setting()
    {
        bike_frame.setBounds(500, 50, 500, 500);
        bike_frame.setLayout(null);
        bike_frame.getContentPane().setBackground(Color.lightGray);
        bike_frame.setVisible(true);
        bike_frame.setResizable(false);
        bike_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void labels()
    {
        id.setBounds(20, 50, 500, 50);
        bike_frame.add(id);

        if(s.equals("Renter"))
        {
            price.setText("Price per Day : ");
        }
        price.setBounds(20, 90, 500, 50);
        bike_frame.add(price);

        weight.setBounds(20, 130, 500, 50);
        bike_frame.add(weight);

        brand.setBounds(20, 170, 500, 50);
        bike_frame.add(brand);

        model.setBounds(20, 210, 500, 50);
        bike_frame.add(model);

        maximum_speed.setBounds(20, 250, 500, 50);
        bike_frame.add(maximum_speed);

        color.setBounds(20, 290, 500, 50);
        bike_frame.add(color);

        DO.setBounds(20, 350, 500, 50);
        bike_frame.add(DO);

        M.setBounds(20,365,500,50);
        bike_frame.add(M);

        day.setBounds(120, 330, 500, 50);
        bike_frame.add(day);

        month.setBounds(170, 330, 500, 50);
        bike_frame.add(month);

        year.setBounds(230, 330, 500, 50);
        bike_frame.add(year);
    }


    private void combo_boxes()
    {
        date();
        Day=new JComboBox<>(d);
        Month=new JComboBox<>(m);
        Year=new JComboBox<>(y);


        Day.setBounds(120, 370, 40, 30);
        bike_frame.add(Day);

        Month.setBounds(170, 370, 50, 30);
        bike_frame.add(Month);

        Year.setBounds(230, 370, 60, 30);
        bike_frame.add(Year);
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


    private void text_fields()
    {
        tf_id.setBounds(120, 60, 330, 30);
        tf_id.setEditable(false);
        tf_id.setBackground(Color.lightGray);
        tf_id.setBorder(null);
        if(s.equals("Seller")) {
            tf_id.setText("P" + Main.active_product_index);
        }
        else if(s.equals("Renter"))
        {
            tf_id.setText("R" + Main.active_rent_index);
        }
        bike_frame.add(tf_id);

        tf_price.setBounds(120, 100, 330, 30);
        bike_frame.add(tf_price);
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


        tf_weight.setBounds(120, 140, 330, 30);
        bike_frame.add(tf_weight);
        tf_weight.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tf_weight.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
            }
        });

        tf_weight.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tf_weight.setEditable(true);
            }
        });


        tf_brand.setBounds(120, 180, 330, 30);
        bike_frame.add(tf_brand);

        tf_model.setBounds(120, 220, 330, 30);
        bike_frame.add(tf_model);

        tf_maximum_speed.setBounds(120, 260, 330, 30);
        bike_frame.add(tf_maximum_speed);
        tf_maximum_speed.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tf_maximum_speed.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
            }
        });

        tf_maximum_speed.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tf_maximum_speed.setEditable(true);
            }
        });


        tf_color.setBounds(120, 300, 330, 30);
        bike_frame.add(tf_color);
    }


    private void Submit_Button()
    {
        submit.setBounds(130, 410, 100, 40);
        bike_frame.add(submit);
        submit.addActionListener(this);
    }

    private void Clear_Button()
    {
        clear.setBounds(270, 410, 100, 40);
        bike_frame.add(clear);
        clear.addActionListener(this);
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
        bike_frame.add(back_b);
    }

    private void Clear ()
    {
        tf_price.setText("");
        tf_weight.setText("");
        tf_brand.setText("");
        tf_maximum_speed.setText("");
        tf_model.setText("");
        tf_color.setText("");
        Day.setSelectedIndex(0);
        Month.setSelectedIndex(0);
        Year.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(back_b)){
            Category.category_frame.setVisible(true);
            bike_frame.dispose();
        }

        if(e.getSource().equals(clear)){
            Clear();
        }
        if(e.getSource().equals(submit)){
            if(tf_price.getText().equals("") || tf_weight.getText().equals("") || tf_brand.getText().equals("")|| tf_maximum_speed.getText().equals("") || tf_model.getText().equals("") || tf_color.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Fill All Data");
            }
            else
            {
                Bike b=new Bike();

                if(s.equals("Seller")) {
                    b.set_Bike_data("P" + Main.active_product_index, tf_price.getText(), tf_weight.getText(), tf_brand.getText(), tf_model.getText(), tf_maximum_speed.getText(), tf_color.getText(), Day.getSelectedIndex() + 1, Month.getSelectedIndex() + 1, Year.getSelectedIndex() + 1992);
                    Main.s[Main.sell_index].set_active_products(b);
                    if (Main.sell_index == Main.sell_count) {
                        Main.sell_count++;
                    }
                }
                else if(s.equals("Renter"))
                {
                    b.set_Bike_data("R"+Main.active_rent_index,tf_price.getText(),tf_weight.getText(),tf_brand.getText(),tf_model.getText(),tf_maximum_speed.getText(),tf_color.getText(),Day.getSelectedIndex()+1,Month.getSelectedIndex()+1,Year.getSelectedIndex()+1992);
                    b.rent=new Rent();
                    b.rent.setPrice_per_day(tf_price.getText());
                    Main.r[Main.rent_index].add_Rented_Product(b);
                    if(Main.rent_index==Main.rent_count)
                    {
                        Main.rent_count++;
                    }
                }

                JOptionPane.showMessageDialog(null,"Successfully Added");

                bike_frame.dispose();
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
}
