import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sell_product_panel implements ActionListener {

    public static JFrame sell_frame=new JFrame("Sell product panel");
    JLabel sell_label = new JLabel("SELL PRODUCT");
    JButton product_info=new JButton("Add Product Information");
    JButton active_product =new JButton("Active product list");
    JButton sold_product =new JButton("Sold product list");
    JButton goto_menu=new JButton("Go to menu");

    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);
    GUI temp;

    Sell_product_panel(GUI temp)
    {
        this.temp=temp;

        frame_setting();
        sell_text();
        product_info_Button();
        active_product_Button();
        sold_product_Button();
        Menu_Button();

    }

    public void frame_setting()
    {
        sell_frame.setBounds(500, 50, 500, 500);
        sell_frame.setLayout(null);
        sell_frame.getContentPane().setBackground(Color.lightGray);
        sell_frame.setVisible(true);
        sell_frame.setResizable(false);
        sell_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void sell_text()
    {
        sell_label.setBounds(170, 20, 500, 50);
        sell_label.setFont(f1);
        sell_frame.add(sell_label);
    }

    public void product_info_Button()
    {
        product_info.setBounds(145, 110, 200, 50);
        sell_frame.add(product_info);
        product_info.addActionListener(this);
    }

    public void active_product_Button()
    {
        active_product.setBounds(145, 170, 200, 50);
        sell_frame.add(active_product);
        active_product.addActionListener(this);
    }

    public void sold_product_Button() {
        sold_product.setBounds(145, 230, 200, 50);
        sell_frame.add(sold_product);
        sold_product.addActionListener(this);
    }

    public void Menu_Button()
    {
        goto_menu.setBounds(145, 290, 200, 50);
        sell_frame.add(goto_menu);
        goto_menu.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(product_info))
        {
            if(Main.sell_index==Main.sell_count)
            {
                Main.s[Main.sell_index] = new Seller();
                Main.s[Main.sell_index].set_Data(Main.p[Main.index].a.f_name,Main.p[Main.index].a.l_name,Main.p[Main.index].a.u_name,Main.p[Main.index].a.password,Main.p[Main.index].a.DOB.getDay(),Main.p[Main.index].a.DOB.getMonth(),Main.p[Main.index].a.DOB.getYear());
                Main.s[Main.sell_index].setBalance(Main.p[Main.index].balance);
                Main.s[Main.sell_index].setAddress(Main.p[Main.index].address);
                Main.s[Main.sell_index].setID(Main.p[Main.index].ID);
            }
            Main.s[Main.sell_index].setBalance(Main.p[Main.index].balance);
            sell_frame.dispose();
            new Product_info(temp);
        }
        else if(e.getSource().equals(active_product))
        {
            boolean flag=false;

            if(Main.s!=null) {
                if (Main.s[Main.sell_index]!=null) {
                    {
                        if(Main.s[Main.sell_index].active_product!=null)
                        {
                            if(Main.s[Main.sell_index].active_product[0]!=null)
                            {
                               flag=true;
                            }
                        }

                    }
                }
            }

            if(flag)
            {
                new Active_Product_List(temp,"Seller");
                sell_frame.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No Product added yet");
            }
        }
        else if(e.getSource().equals(sold_product))
        {
            boolean flag=false;

            if(Main.s!=null) {
                if (Main.s[Main.sell_index]!= null)
                {
                    if(Main.s[Main.sell_index].sold_product!=null)
                    {
                        if(Main.s[Main.sell_index].sold_product[0]!=null)
                        {
                            flag=true;
                        }
                    }
                }
            }


            if(flag)
            {
                new Sold_Product_List(temp,"sell");
                sell_frame.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No Product sold yet");
            }
        }
        else if(e.getSource().equals(goto_menu))
        {
            sell_frame.dispose();
            Profile.profile_frame.setVisible(true);
        }
    }
}
