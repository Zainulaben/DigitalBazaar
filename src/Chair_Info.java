import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Chair_Info implements ActionListener {
    JFrame chair_frame=new JFrame("Chair Info");
    JLabel chair_label=new JLabel("CHAIR INFORMATION");
    JLabel id=new JLabel("Product ID : ");
    JLabel chair_price=new JLabel("Price : ");
    JLabel chair_size=new JLabel("Size : ");
    JLabel chair_weight=new JLabel("Weight : ");
    JLabel category=new JLabel();
    JLabel chair_color=new JLabel("Color : ");
    JLabel chair_material =new JLabel("Material : ");
    JLabel DO=new JLabel("Date Of");
    JLabel M=new JLabel("Manufacture : ");
    JLabel day =new JLabel("Day");
    JLabel month=new JLabel("Month");
    JLabel year=new JLabel("Year");

    JTextField tf_id=new JTextField(20);
    JTextField tf_price=new JTextField(20);
    JTextField tf_size=new JTextField(20);
    JTextField tf_weight=new JTextField(20);
    JTextField tf_color=new JTextField(20);
    JTextField tf_material=new JTextField(20);

    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);

    GUI temp;
    String s;

    String []d=new String[31];
    String[]m=new String[12];
    String[]y=new String[31];

    JComboBox<String> Day = new JComboBox<>();
    JComboBox<String> Month = new JComboBox<>();
    JComboBox<String> Year = new JComboBox<>();

    JButton submit = new JButton("Submit");
    JButton clear = new JButton("Clear");
    JButton back_b;


    Chair_Info(GUI temp,String s)
    {
        this.temp=temp;
        this.s=s;

        category.setText("Chair");

        frame_setting();
        Bed_text();
        labels();
        text_fields();
        back_button();
        Clear_Button();
        Submit_Button();
        combo_boxes();

    }
    private void Bed_text()
    {
        chair_label.setBounds(170, 0, 500, 50);
        chair_label.setFont(f1);
        chair_frame.add(chair_label);
    }

    private void frame_setting()
    {
        chair_frame.setBounds(500, 50, 500, 500);
        chair_frame.setLayout(null);
        chair_frame.getContentPane().setBackground(Color.lightGray);
        chair_frame.setVisible(true);
        chair_frame.setResizable(false);
        chair_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void labels()
    {
        id.setBounds(20, 50, 500, 50);
        chair_frame.add(id);

        if(s.equals("Renter"))
        {
            chair_price.setText("Price per Day : ");
        }
        chair_price.setBounds(20, 90, 500, 50);
        chair_frame.add(chair_price);

        chair_weight.setBounds(20, 130, 500, 50);
        chair_frame.add(chair_weight);

        chair_size.setBounds(20, 170, 500, 50);
        chair_frame.add(chair_size);

        chair_color.setBounds(20,210,500,50);
        chair_frame.add(chair_color);

        chair_material.setBounds(20,250,500,50);
        chair_frame.add(chair_material);

        DO.setBounds(20, 310, 500, 50);
        chair_frame.add(DO);

        M.setBounds(20,325,500,50);
        chair_frame.add(M);

        day.setBounds(120, 290, 500, 50);
        chair_frame.add(day);

        month.setBounds(170, 290, 500, 50);
        chair_frame.add(month);

        year.setBounds(230, 290, 500, 50);
        chair_frame.add(year);
    }


    private void combo_boxes()
    {
        date();
        Day=new JComboBox<>(d);
        Month=new JComboBox<>(m);
        Year=new JComboBox<>(y);


        Day.setBounds(120, 330, 40, 30);
        chair_frame.add(Day);

        Month.setBounds(170, 330, 50, 30);
        chair_frame.add(Month);

        Year.setBounds(230, 330, 60, 30);
        chair_frame.add(Year);
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
        chair_frame.add(tf_id);

        tf_price.setBounds(120, 100, 330, 30);
        chair_frame.add(tf_price);
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
        chair_frame.add(tf_weight);
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


        tf_size.setBounds(120, 180, 330, 30);
        chair_frame.add(tf_size);


        tf_color.setBounds(120, 220, 330, 30);
        chair_frame.add(tf_color);

        tf_material.setBounds(120, 260, 330, 30);
        chair_frame.add(tf_material);

    }

    private void Submit_Button()
    {
        submit.setBounds(130, 400, 100, 40);
        chair_frame.add(submit);
        submit.addActionListener(this);
    }

    private void Clear_Button()
    {
        clear.setBounds(270, 400, 100, 40);
        chair_frame.add(clear);
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
        chair_frame.add(back_b);
    }


    public void Clear()
    {
        tf_material.setText("");
        tf_weight.setText("");
        tf_color.setText("");
        tf_price.setText("");
        tf_size.setText("");
        Day.setSelectedIndex(0);
        Month.setSelectedIndex(0);
        Year.setSelectedIndex(0);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(clear))
        {
            Clear();
        }
        else if(e.getSource().equals(back_b))
        {
            chair_frame.dispose();
            Category.category_frame.setVisible(true);
        }
        else if(e.getSource().equals(submit))
        {
            if(tf_price.getText().equals("") || tf_weight.getText().equals("") || tf_material.getText().equals("")|| tf_color.getText().equals("") || tf_size.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Fill All Data");
            }
            else
            {
                Chair c=new Chair();

                if(s.equals("Seller")) {
                    c.set_chair_data("P" + Main.active_product_index, tf_price.getText(), tf_weight.getText(), tf_color.getText(), tf_material.getText(), Day.getSelectedIndex() + 1, Month.getSelectedIndex(), Year.getSelectedIndex() + 1992);
                    Main.s[Main.sell_index].set_active_products(c);
                    if (Main.sell_index == Main.sell_count) {
                        Main.sell_count++;
                    }
                }
                else if(s.equals("Renter"))
                {
                    c.set_chair_data("R"+Main.active_rent_index,tf_price.getText(),tf_weight.getText(),tf_color.getText(),tf_material.getText(),Day.getSelectedIndex()+1,Month.getSelectedIndex(),Year.getSelectedIndex()+1992);
                    c.rent=new Rent();
                    c.rent.setPrice_per_day(tf_price.getText());
                    Main.r[Main.rent_index].add_Rented_Product(c);
                    if(Main.rent_index==Main.rent_count)
                    {
                        Main.rent_count++;
                    }
                }

                JOptionPane.showMessageDialog(null,"Successfully Added");

                chair_frame.dispose();

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