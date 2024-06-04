import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Price_range implements ActionListener {
    JFrame price_range_frame=new JFrame("Profile");
    JLabel price_range = new JLabel("PRICE RANGE");
    JLabel min=new JLabel("Minimum : ");
    JLabel max=new JLabel("Maximum : ");
    JButton submit = new JButton("Submit");


    JTextField tf_min=new JTextField(20);
    JTextField tf_max=new JTextField(20);

    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);


    JButton back_b;

    GUI temp;

    static String s;
    Price_range(GUI temp,String s)
    {
        this.temp=temp;
        this.s=s;

        frame_setting();
        price_text();
        labels();
        text_fields();
        submit_Button();
        back_button();
    }


    private void price_text()
    {
        price_range.setBounds(200, 0, 500, 50);
        price_range.setFont(f1);
        price_range_frame.add(price_range);
    }
    private void frame_setting()
    {
        price_range_frame.setBounds(500, 50, 500, 500);
        price_range_frame.setLayout(null);
        price_range_frame.getContentPane().setBackground(Color.lightGray);
        price_range_frame.setVisible(true);
        price_range_frame.setResizable(false);
        price_range_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void labels()
    {

        min.setBounds(20, 60, 500, 50);
        price_range_frame.add(min);

        max.setBounds(20, 120, 500, 50);
        price_range_frame.add(max);


    }


    private void text_fields()
    {

        tf_min.setBounds(120, 70, 330, 30);
        price_range_frame.add(tf_min);

        tf_max.setBounds(120, 130, 330, 30);
        price_range_frame.add(tf_max);

        tf_min.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if((e.getKeyChar()>='0' && e.getKeyChar()<='9' ) || e.getKeyChar()==8 || e.getKeyChar()=='.')
                {
                    tf_min.setEditable(true);
                }
                else
                {
                    tf_min.setEditable(false);
                }
            }
        });

        tf_max.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if((e.getKeyChar()>='0' && e.getKeyChar()<='9' ) || e.getKeyChar()==8 || e.getKeyChar()=='.')
                {
                    tf_max.setEditable(true);
                }
                else
                {
                    tf_max.setEditable(false);
                }
            }
        });

        tf_min.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tf_min.setEditable(true);
            }
        });

        tf_max.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tf_max.setEditable(true);
            }
        });
    }


    private void submit_Button()
    {
        submit.setBounds(200, 350, 100, 40);
        // submit.setBackground(Color.gray);
        price_range_frame.add(submit);
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
        price_range_frame.add(back_b);
    }


    public static Product []by_range=new Product[1000000];
    public static int r=0;
    void by_range()
    {
        int i;

        if(Product_Category.s.equals("sell")) {
            by_range = new Product[Main.active_product_index];

            for (i = 0; i < Main.active_product_index; i++) {
                if (Main.all_products_sell[i].price >= Float.parseFloat(tf_min.getText()) && Main.all_products_sell[i].price <= Float.parseFloat(tf_max.getText())) {
                    by_range[r] = Main.all_products_sell[i];
                    r++;
                }
            }
        }
        else if(Product_Category.s.equals("rent"))
        {
            by_range = new Product[Main.active_rent_index];

            for (i = 0; i < Main.active_rent_index; i++) {
                if (Main.all_products_rent[i].price >= Float.parseFloat(tf_min.getText()) && Main.all_products_rent[i].price <= Float.parseFloat(tf_max.getText())) {
                    by_range[r] = Main.all_products_rent[i];
                    r++;
                }
            }
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(submit))
        {
            by_range();
            if(by_range[0]!=null)
            {
                new Sort_By_Range(temp,s);
                price_range_frame.dispose();
            }

        }
        if(e.getSource().equals(back_b))
        {
            new Product_Filter(temp,s);
            price_range_frame.dispose();
        }

    }
}
