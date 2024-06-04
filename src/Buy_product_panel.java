import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buy_product_panel implements ActionListener {
    public static JFrame buy_frame=new JFrame("Buy Product");
    JLabel buy_label=new JLabel("BUY PRODUCT");

    JButton product_buy=new JButton("Buy Product");
    JButton product_rent=new JButton("Product on Rent");
    JButton view_buy_product=new JButton("View Buy Product");
    JButton goto_menu=new JButton("Go to Menu");

    Font f1=new Font(Font.SERIF,Font.BOLD,20);
    GUI temp;

    Buy_product_panel(GUI temp)
    {
        this.temp=temp;

        frame_setting();
        text();
        Product_Button();
        rent_product();
        View_Button();
        Menu_Button();
    }

    void frame_setting()
    {
        buy_frame.setVisible(true);
        buy_frame.setResizable(false);
        buy_frame.setLayout(null);
        buy_frame.setBounds(500,50,500,500);
        buy_frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        buy_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void text()
    {
        buy_label.setBounds(170,0,500,50);
        buy_label.setFont(f1);
        buy_frame.add(buy_label);
    }
    void Product_Button()
    {
        product_buy.setBounds(145, 110, 200, 50);
        buy_frame.add(product_buy);
        product_buy.addActionListener(this);
    }
    void rent_product()
    {
        product_rent.setBounds(145,170,200,50);
        buy_frame.add(product_rent);
        product_rent.addActionListener(this);
    }
    void View_Button()
    {
        view_buy_product.setBounds(145, 230, 200, 50);
        buy_frame.add(view_buy_product);
        view_buy_product.addActionListener(this);
    }
    void Menu_Button()
    {
        goto_menu.setBounds(145, 290, 200, 50);
        buy_frame.add(goto_menu);
        goto_menu.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(product_buy))
        {
            boolean flag=false;
            if(Main.s!=null) {
                if (Main.s[0] != null) {
                    if (Main.buy_index == Main.buy_count) {
                        Main.b[Main.buy_index] = new Buyer();
                        Main.b[Main.buy_index].set_Data(Main.p[Main.index].a.f_name, Main.p[Main.index].a.l_name, Main.p[Main.index].a.u_name, Main.p[Main.index].a.password, Main.p[Main.index].a.DOB.getDay(), Main.p[Main.index].a.DOB.getMonth(), Main.p[Main.index].a.DOB.getYear());
                        Main.b[Main.buy_index].setBalance(Main.p[Main.index].balance);
                        Main.b[Main.buy_index].setAddress(Main.p[Main.index].address);
                        Main.b[Main.buy_index].setID(Main.p[Main.index].ID);
                        Main.buy_count++;
                    }

                    flag=true;
                }
            }

            if(Main.all_products_sell[0]!=null)
            {
                Main.b[Main.buy_index].setBalance(Main.p[Main.index].balance);
                new Product_Category(temp, "sell");
                buy_frame.dispose();
            }
            if(Main.all_products_sell[0]==null)
            {
                JOptionPane.showMessageDialog(null, "No products to buy");
            }

        }
        else if(e.getSource().equals(product_rent))
        {
            boolean flag=false;
            if(Main.r!=null) {
                if (Main.r[0] != null) {
                    if (Main.buy_index == Main.buy_count) {
                        Main.b[Main.buy_index] = new Buyer();
                        Main.b[Main.buy_index].set_Data(Main.p[Main.index].a.f_name, Main.p[Main.index].a.l_name, Main.p[Main.index].a.u_name, Main.p[Main.index].a.password, Main.p[Main.index].a.DOB.getDay(), Main.p[Main.index].a.DOB.getMonth(), Main.p[Main.index].a.DOB.getYear());
                        Main.b[Main.buy_index].setBalance(Main.p[Main.index].balance);
                        Main.b[Main.buy_index].setAddress(Main.p[Main.index].address);
                        Main.b[Main.buy_index].setID(Main.p[Main.index].ID);
                        Main.buy_count++;
                    }
                    flag=true;
                }
            }


            if(Main.all_products_rent[0]!=null)
            {
                Main.b[Main.buy_index].setBalance(Main.p[Main.index].balance);
                new Product_Category(temp, "rent");
                buy_frame.dispose();
            }
            if(Main.all_products_rent[0]==null)
            {
                JOptionPane.showMessageDialog(null,"No products on rent");
            }
        }
        else if(e.getSource().equals(view_buy_product))
        {
            if(Main.b[Main.buy_index]!=null) {
                if (Main.b[Main.buy_index].buy_product[0]!=null) {
                    new Buy_Product_List(temp);
                    buy_frame.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"No Product bought yet");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No Product bought yet");
            }
        }
        else if(e.getSource().equals(goto_menu))
        {
            buy_frame.dispose();
            Profile.profile_frame.setVisible(true);
        }
    }
}
