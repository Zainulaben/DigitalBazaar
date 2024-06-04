import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rent_Product_panel implements ActionListener {

    public static JFrame rent_frame=new JFrame("Rent product panel");
    JLabel rent_label = new JLabel("RENT PRODUCT");
    JButton product_info=new JButton("Product Information");
    JButton active_product =new JButton("Active Product List");
    JButton sold_product =new JButton("Sold Product List");
    JButton goto_menu=new JButton("Go to menu");

    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);
    GUI temp;

    Rent_Product_panel(GUI temp)
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
        rent_frame.setBounds(500, 50, 500, 500);
        rent_frame.setLayout(null);
        rent_frame.getContentPane().setBackground(Color.lightGray);
        rent_frame.setVisible(true);
        rent_frame.setResizable(false);
        rent_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void sell_text()
    {
        rent_label.setBounds(170, 20, 500, 50);
        rent_label.setFont(f1);
        rent_frame.add(rent_label);
    }

    public void product_info_Button()
    {
        product_info.setBounds(145, 110, 200, 50);
        rent_frame.add(product_info);
        product_info.addActionListener(this);
    }

    public void active_product_Button()
    {
        active_product.setBounds(145, 170, 200, 50);
        rent_frame.add(active_product);
        active_product.addActionListener(this);
    }

    public void sold_product_Button() {
        sold_product.setBounds(145, 230, 200, 50);
        rent_frame.add(sold_product);
        sold_product.addActionListener(this);
    }

    public void Menu_Button()
    {
        goto_menu.setBounds(145, 290, 200, 50);
       rent_frame.add(goto_menu);
        goto_menu.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(product_info))
        {
            if(Main.rent_index==Main.rent_count)
            {
                Main.r[Main.rent_index] =new Renter();
                Main.r[Main.rent_index].set_Data(Main.p[Main.index].a.f_name,Main.p[Main.index].a.l_name,Main.p[Main.index].a.u_name,Main.p[Main.index].a.password,Main.p[Main.index].a.DOB.getDay(),Main.p[Main.index].a.DOB.getMonth(),Main.p[Main.index].a.DOB.getYear());
                Main.r[Main.rent_index].setBalance(Main.p[Main.index].balance);
                Main.r[Main.rent_index].setAddress(Main.p[Main.index].address);
                Main.r[Main.rent_index].setID(Main.p[Main.index].ID);
            }
            Main.r[Main.rent_index].setBalance(Main.p[Main.index].balance);
            rent_frame.dispose();
            new Rent_Product_Info(temp);

        }
        else if(e.getSource().equals(active_product))
        {
            boolean flag=false;

            if(Main.r!=null) {
                if (Main.r[Main.sell_index]!=null) {
                    {
                        if(Main.r[Main.sell_index].active_product_List!=null)
                        {
                            if(Main.r[Main.sell_index].active_product_List[0]!=null)
                            {
                                flag=true;
                            }
                        }

                    }
                }
            }

            if(flag)
            {
                new Active_Product_List(temp,"Renter");
                rent_frame.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No Product added yet");
            }
        }
        else if(e.getSource().equals(sold_product))
        {
            boolean flag=false;

            if(Main.r!=null) {
                if (Main.r[Main.sell_index]!= null)
                {
                    if(Main.r[Main.sell_index].sold_product_list!=null)
                    {
                        if(Main.r[Main.sell_index].sold_product_list[0]!=null)
                        {
                            flag=true;
                        }
                    }
                }
            }


            if(flag)
            {
                new Sold_Product_List(temp,"rent");
                rent_frame.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No Product sold yet");
            }
        }
        else if(e.getSource().equals(goto_menu))
        {
            rent_frame.dispose();
            Profile.profile_frame.setVisible(true);
        }
    }
}
