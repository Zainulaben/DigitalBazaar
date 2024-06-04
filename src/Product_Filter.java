import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Product_Filter implements ActionListener {
    static public JFrame f_frame=new JFrame("Product Filter");
    JLabel f_label=new JLabel("PRODUCT FILTER");

    JButton sort_by_date=new JButton("Sort By Date");
    JButton sort_by_price=new JButton("Sort By Price");
    JButton price_range=new JButton("Price Range");
    JButton select_by_Id=new JButton("Select By ID");
    JButton goto_menu=new JButton("Go to Back Menu");

    JLabel max=new JLabel("Max : ");
    JFormattedTextField tf_max=new JFormattedTextField();
    JLabel min=new JLabel("Min : ");
    JFormattedTextField tf_min=new JFormattedTextField();

    Font f1=new Font(Font.SERIF,Font.BOLD,20);
    GUI temp;

    static int Product_index;

    static String s;
    Product_Filter(GUI temp,String s)
    {
        this.temp=temp;
        this.s=s;

        frame_setting();
        text();
        S_B_Date();
        S_B_Price();
        Price_Range();
        B_ID();
        range();
        Menu();
    }

    void frame_setting()
    {
        f_frame.setVisible(true);
        f_frame.setResizable(false);
        f_frame.setLayout(null);
        f_frame.setBounds(500,50,500,500);
        f_frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        f_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    void text()
    {
        f_label.setBounds(150,20,500,50);
        f_label.setFont(f1);
        f_frame.add(f_label);
    }
    void S_B_Date()
    {
        sort_by_date.setBounds(150,130,180,50);
        sort_by_date.addActionListener(this);
        f_frame.add(sort_by_date);
    }
    void S_B_Price()
    {
        sort_by_price.setBounds(150,190,180,50);
        sort_by_price.addActionListener(this);
        f_frame.add(sort_by_price);
    }
    void Price_Range()
    {
        price_range.setBounds(150,250,180,50);
        price_range.addActionListener(this);
        f_frame.add(price_range);
    }
    void B_ID()
    {
        select_by_Id.setBounds(150,310,180,50);
        select_by_Id.addActionListener(this);
        f_frame.add(select_by_Id);
    }

    void Menu()
    {
        goto_menu.setBounds(150,370,180,50);
        goto_menu.addActionListener(this);
        f_frame.add(goto_menu);
    }

    void range()
    {
        min.setBounds(170,210,200,40);
        min.setVisible(false);
        f_frame.add(min);

        max.setBounds(170,240,200,40);
        max.setVisible(false);
        f_frame.add(max);

        tf_min.setBounds(220,220,120,20);
        tf_min.setVisible(false);
        tf_min.setEditable(true);
        f_frame.add(tf_min);

        tf_max.setBounds(220,250,120,20);
        tf_max.setVisible(false);
        tf_max.setEditable(true);
        f_frame.add(tf_max);

    }

    public static Product []by_date =new Product[10000000];

    void sort_by_date()
    {
        if(s.equals("sell"))
        {
            for(int i=0;i<Main.active_product_index;i++)
            {
                by_date[i]=Main.all_products_sell[i];
            }
        }
        else if(s.equals("rent"))
        {
            for(int i=0;i<Main.active_rent_index;i++)
            {
                by_date[i]=Main.all_products_rent[i];
            }
        }
    }

    public static Product []by_price =new Product[10000000];
    void sort_by_price()
    {
        int i,j;
        int min;
        Product temp;

        if(s.equals("sell"))
        {
            by_price = new Product[Main.active_product_index];

            for (i = 0; i < Main.active_product_index; i++) {
                by_price[i] = Main.all_products_sell[i];
            }

            for (i = 0; i < Main.active_product_index - 1; i++) {
                min = i;
                for (j = i + 1; j < Main.active_product_index; j++) {
                    if (by_price[j].price < by_price[min].price) {
                        min = j;
                    }
                }

                temp = by_price[i];
                by_price[i] = by_price[min];
                by_price[min] = temp;
            }
        }

        else if(s.equals("rent"))
        {
            by_price = new Product[Main.active_rent_index];

            for (i = 0; i < Main.active_rent_index; i++) {
                by_price[i] = Main.all_products_rent[i];
            }

            for (i = 0; i < Main.active_rent_index - 1; i++) {
                min = i;
                for (j = i + 1; j < Main.active_rent_index; j++) {
                    if (by_price[j].price < by_price[min].price) {
                        min = j;
                    }
                }

                temp = by_price[i];
                by_price[i] = by_price[min];
                by_price[min] = temp;
            }
        }
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(sort_by_date))
        {
            sort_by_date();
            new Sort_By_Date(temp,s);
            f_frame.dispose();
        }
        else if(e.getSource().equals(sort_by_price))
        {
            sort_by_price();
            new Sort_By_Price(temp,s);
            f_frame.dispose();
        }
        else if(e.getSource().equals(price_range))
        {
            new Price_range(temp,s);
            f_frame.dispose();
        }
        else if(e.getSource().equals(select_by_Id))
        {
            new Search_By_ID(temp,s);
            f_frame.dispose();
        }
        else if(e.getSource().equals(goto_menu))
        {
            f_frame.dispose();
            Product_Category.p_frame.setVisible(true);
        }
    }


}
