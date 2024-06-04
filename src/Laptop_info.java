import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Laptop_info implements ActionListener {

    JFrame laptop_frame=new JFrame("Laptop");
    JLabel laptop_l = new JLabel("LAPTOP INFO");
    JLabel id=new JLabel("Product ID : ");
    JLabel price=new JLabel("Price : ");
    JLabel weight=new JLabel("Weight : ");
    JLabel company =new JLabel("Company : ");
    JLabel memory=new JLabel("Memory : ");
    JLabel battery_life=new JLabel("Battery life : ");
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
    JTextField tf_memory=new JTextField(20);
    JTextField tf_battery=new JTextField(20);


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


    Laptop_info(GUI temp,String s)
    {
        this.temp=temp;
        this.s=s;


        frame_setting();
        laptop_text();
        labels();
        text_fields();
        Submit_Button();
        Clear_Button();
        back_button();
        combo_boxes();
    }


    private void laptop_text()
    {
        laptop_l.setBounds(190, 0, 500, 50);
        laptop_l.setFont(f1);
        laptop_frame.add(laptop_l);
    }
    private void frame_setting()
    {
        laptop_frame.setBounds(500, 50, 600, 600);
        laptop_frame.setLayout(null);
        laptop_frame.getContentPane().setBackground(Color.lightGray);
        laptop_frame.setVisible(true);
        laptop_frame.setResizable(false);
        laptop_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void labels()
    {
        id.setBounds(20, 50, 500, 50);
        laptop_frame.add(id);

        if(s.equals("Renter"))
        {
            price.setText("Price per Day : ");
        }
        price.setBounds(20, 90, 500, 50);
        laptop_frame.add(price);

        weight.setBounds(20, 130, 500, 50);
        laptop_frame.add(weight);

        company.setBounds(20, 170, 500, 50);
        laptop_frame.add(company);

        memory.setBounds(20, 210, 500, 50);
        laptop_frame.add(memory);

        battery_life.setBounds(20, 250, 500, 50);
        laptop_frame.add(battery_life);

        DO.setBounds(20, 310, 500, 50);
        laptop_frame.add(DO);

        M.setBounds(20,325,500,50);
        laptop_frame.add(M);

        day.setBounds(120, 290, 500, 50);
        laptop_frame.add(day);

        month.setBounds(170, 290, 500, 50);
        laptop_frame.add(month);

        year.setBounds(230, 290, 500, 50);
        laptop_frame.add(year);


    }


    private void combo_boxes()
    {
        date();
        Day=new JComboBox<>(d);
        Month=new JComboBox<>(m);
        Year=new JComboBox<>(y);


        Day.setBounds(120, 330, 40, 30);
        laptop_frame.add(Day);

        Month.setBounds(170, 330, 50, 30);
        laptop_frame.add(Month);

        Year.setBounds(230, 330, 60, 30);
        laptop_frame.add(Year);
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
            tf_id.setText("R"+Main.active_rent_index);
        }
        laptop_frame.add(tf_id);

        tf_price.setBounds(120, 100, 330, 30);
        laptop_frame.add(tf_price);
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
        laptop_frame.add(tf_weight);
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
        laptop_frame.add(tf_company);

        tf_memory.setBounds(120, 220, 330, 30);
        laptop_frame.add(tf_memory);
        tf_memory.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tf_memory.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
            }
        });

        tf_memory.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tf_memory.setEditable(true);
            }
        });

        tf_battery.setBounds(120, 260, 330, 30);
        laptop_frame.add(tf_battery);
        tf_battery.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tf_battery.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
            }
        });

        tf_battery.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tf_battery.setEditable(true);
            }
        });
    }

    private void Submit_Button()
    {
        submit.setBounds(130, 400, 100, 40);
        laptop_frame.add(submit);
        submit.addActionListener(this);
    }

    private void Clear_Button()
    {
        clear.setBounds(270, 400, 100, 40);
        laptop_frame.add(clear);
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
        laptop_frame.add(back_b);
    }

    private void Clear ()
    {
        tf_price.setText("");
        tf_weight.setText("");
        tf_company.setText("");
        tf_battery.setText("");
        tf_memory.setText("");
        Day.setSelectedIndex(0);
        Month.setSelectedIndex(0);
        Year.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(back_b)){
            Category.category_frame.setVisible(true);
            laptop_frame.dispose();
        }

        else if(e.getSource().equals(clear)){
            Clear();
        }

        else if(e.getSource().equals(submit)){

            if(tf_price.getText().equals("") || tf_weight.getText().equals("") || tf_company.getText().equals("")|| tf_battery.getText().equals("") || tf_memory.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Fill All Data");
            }
            else
            {
                Laptop l=new Laptop();

                if(s.equals("Seller")) {
                    l.set_laptop_data("P"+Main.active_product_index,tf_price.getText(),tf_company.getText(),tf_weight.getText(),tf_memory.getText(),tf_battery.getText(),Day.getSelectedIndex()+1,Month.getSelectedIndex()+1,Year.getSelectedIndex()+1992);
                    Main.s[Main.sell_index].set_active_products(l);
                    if (Main.sell_index == Main.sell_count)
                    {
                        Main.sell_count++;
                    }
                }
                else if(s.equals("Renter"))
                {
                    l.set_laptop_data("R"+Main.active_rent_index,tf_price.getText(),tf_company.getText(),tf_weight.getText(),tf_memory.getText(),tf_battery.getText(),Day.getSelectedIndex()+1,Month.getSelectedIndex()+1,Year.getSelectedIndex()+1992);
                    l.rent=new Rent();
                    l.rent.setPrice_per_day(tf_price.getText());
                    Main.r[Main.rent_index].add_Rented_Product(l);
                    if(Main.rent_index==Main.rent_count)
                    {
                        Main.rent_count++;
                    }
                }

                JOptionPane.showMessageDialog(null,"Successfully Added");

                laptop_frame.dispose();
                Category.category_frame.setVisible(true);
            }
        }
    }
}
