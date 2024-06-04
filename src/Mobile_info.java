import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mobile_info implements ActionListener {
    JFrame mobile_frame=new JFrame("Mobile");
    JLabel mobile_l = new JLabel("MOBILE INFO");
    JLabel id=new JLabel("Product ID : ");
    JLabel price=new JLabel("Price : ");
    JLabel weight=new JLabel("Weight : ");
    JLabel company =new JLabel("Company : ");
    JLabel storage=new JLabel("Storage : ");
    JLabel length=new JLabel("Length : ");
    JLabel width=new JLabel("Width ");
    JLabel DO=new JLabel("Date Of");
    JLabel M=new JLabel("Manufacture : ");
    JLabel day =new JLabel("Day");
    JLabel month=new JLabel("Month");
    JLabel year=new JLabel("Year");

    JButton submit = new JButton("Submit");
    JButton clear = new JButton("Clear");

    JTextField tf_id=new JTextField(20);
    JTextField tf_price=new JTextField(20);
    JTextField tf_weight=new JTextField(20);
    JTextField tf_company=new JTextField(20);
    JTextField tf_storage=new JTextField(20);
    JTextField tf_length=new JTextField(20);
    JTextField tf_width=new JTextField(20);

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

    Mobile_info(GUI temp,String s)
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
        mobile_l.setBounds(170, 0, 500, 50);
        mobile_l.setFont(f1);
        mobile_frame.add(mobile_l);
    }
    private void frame_setting()
    {
        mobile_frame.setBounds(500, 50, 500, 500);
        mobile_frame.setLayout(null);
        mobile_frame.getContentPane().setBackground(Color.lightGray);
        mobile_frame.setVisible(true);
        mobile_frame.setResizable(false);
        mobile_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void labels()
    {
        id.setBounds(20, 50, 500, 50);
        mobile_frame.add(id);

        if(s.equals("Renter"))
        {
            price.setText("Price per Day : ");
        }
        price.setBounds(20, 90, 500, 50);
        mobile_frame.add(price);

        weight.setBounds(20, 130, 500, 50);
        mobile_frame.add(weight);

        company.setBounds(20, 170, 500, 50);
        mobile_frame.add(company);

        storage.setBounds(20,210,500,50);
        mobile_frame.add(storage);

        length.setBounds(20,250,500,50);
        mobile_frame.add(length);

        width.setBounds(20,290,500,50);
        mobile_frame.add(width);

        DO.setBounds(20, 350, 500, 50);
        mobile_frame.add(DO);

        M.setBounds(20,365,500,50);
        mobile_frame.add(M);

        day.setBounds(120, 330, 500, 50);
        mobile_frame.add(day);

        month.setBounds(170, 330, 500, 50);
        mobile_frame.add(month);

        year.setBounds(230, 330, 500, 50);
        mobile_frame.add(year);
    }

    private void combo_boxes()
    {
        date();
        Day=new JComboBox<>(d);
        Month=new JComboBox<>(m);
        Year=new JComboBox<>(y);


        Day.setBounds(120, 370, 40, 30);
        mobile_frame.add(Day);

        Month.setBounds(170, 370, 50, 30);
        mobile_frame.add(Month);

        Year.setBounds(230, 370, 60, 30);
        mobile_frame.add(Year);
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
        mobile_frame.add(tf_id);

        tf_price.setBounds(120, 100, 330, 30);
        mobile_frame.add(tf_price);
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
        mobile_frame.add(tf_weight);
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


        tf_company.setBounds(120, 180, 330, 30);
        mobile_frame.add(tf_company);

        tf_storage.setBounds(120, 220, 330, 30);
        mobile_frame.add(tf_storage);
        tf_storage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tf_storage.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
            }
        });

        tf_storage.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tf_storage.setEditable(true);
            }
        });


        tf_length.setBounds(120, 260, 330, 30);
        mobile_frame.add(tf_length);
        tf_length.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tf_length.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
            }
        });

        tf_length.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tf_length.setEditable(true);
            }
        });


        tf_width.setBounds(120,300,330,30);
        mobile_frame.add(tf_width);
        tf_width.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tf_width.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
            }
        });

        tf_width.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tf_width.setEditable(true);
            }
        });

    }


    private void Submit_Button()
    {
        submit.setBounds(130, 410, 100, 40);
        mobile_frame.add(submit);
        submit.addActionListener(this);
    }

    private void Clear_Button()
    {
        clear.setBounds(270, 410, 100, 40);
        mobile_frame.add(clear);
        clear.addActionListener(this);
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
        mobile_frame.add(back_b);
    }

    private void Clear ()
    {
        tf_price.setText("");
        tf_weight.setText("");
        tf_company.setText("");
        tf_width.setText("");
        tf_storage.setText("");
        tf_length.setText("");
        Day.setSelectedIndex(0);
        Month.setSelectedIndex(0);
        Year.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(back_b)){
            Category.category_frame.setVisible(true);
            mobile_frame.dispose();
        }

        if(e.getSource().equals(clear))
        {
            Clear();
        }

        if(e.getSource()==submit){
            if(tf_price.getText().equals("") || tf_weight.getText().equals("") || tf_company.getText().equals("")|| tf_width.getText().equals("") || tf_storage.getText().equals("") || tf_length.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Fill All Data");
            }
            else
            {
                Mobile m=new Mobile();

                if(s.equals("Seller")) {
                    m.set_Mobile_data("P" + Main.active_product_index, tf_price.getText(), tf_weight.getText(), tf_company.getText(), tf_storage.getText(), tf_length.getText(), tf_width.getText(), Day.getSelectedIndex() + 1, Month.getSelectedIndex() + 1, Year.getSelectedIndex() + 1992);
                    Main.s[Main.sell_index].set_active_products(m);
                    if (Main.sell_index == Main.sell_count) {
                        Main.sell_count++;
                    }
                }
                else if(s.equals("Renter"))
                {
                    m.set_Mobile_data("R"+Main.active_rent_index,tf_price.getText(),tf_weight.getText(),tf_company.getText(),tf_storage.getText(),tf_length.getText(),tf_width.getText(),Day.getSelectedIndex()+1,Month.getSelectedIndex()+1,Year.getSelectedIndex()+1992);
                    m.rent=new Rent();
                    m.rent.setPrice_per_day(tf_price.getText());
                    Main.r[Main.rent_index].add_Rented_Product(m);
                    if(Main.rent_index==Main.rent_count)
                    {
                        Main.rent_count++;
                    }
                }

                JOptionPane.showMessageDialog(null,"Successfully Added");

                mobile_frame.dispose();

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
