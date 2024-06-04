import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Product_info implements ActionListener {

    public static JFrame prod_frame=new JFrame("Product Information");
    JLabel prod_info = new JLabel("PRODUCT INFORMATION");
    JButton insert_product=new JButton("Insert Product");
    JButton add_inst =new JButton("Add Installment");
    JButton edit_product =new JButton("Edit Product");
    JButton remove_product=new JButton("Remove Product");
    JButton go_back_menu=new JButton("Go Back To Menu");

    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);
    GUI temp;

    Product_info(GUI temp)
    {
        this.temp=temp;

        frame_setting();
        product_text();
        Insert_product_Button();
        add_installment_Button();
        edit_product_Button();
        remove_product_Button();
        go_back_menu_Button();
    }

    public void frame_setting()
    {
        prod_frame.setBounds(500, 50, 500, 500);
        prod_frame.setLayout(null);
        prod_frame.getContentPane().setBackground(Color.lightGray);
        prod_frame.setVisible(true);
        prod_frame.setResizable(false);
        prod_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void product_text()
    {
        prod_info.setBounds(130, 20, 500, 50);
        prod_info.setFont(f1);
        prod_frame.add(prod_info);
    }

    public void Insert_product_Button()
    {
        insert_product.setBounds(145, 90, 200, 50);
        //product_info.setBackground(Color.LIGHT_GRAY);
        prod_frame.add(insert_product);
        insert_product.addActionListener(this);
    }

    public void add_installment_Button()
    {
        add_inst.setBounds(145, 150, 200, 50);
        //active_product.setBackground(Color.LIGHT_GRAY);
        prod_frame.add(add_inst);
        add_inst.addActionListener(this);
    }

    public void edit_product_Button() {
        edit_product.setBounds(145, 210, 200, 50);
        //sold_product.setBackground(Color.LIGHT_GRAY);
        prod_frame.add(edit_product);
        edit_product.addActionListener(this);
    }

    public void remove_product_Button()
    {
        remove_product.setBounds(145, 270, 200, 50);
        //Logout_b.setBackground(Color.LIGHT_GRAY);
        prod_frame.add(remove_product);
        remove_product.addActionListener(this);
    }

    public void go_back_menu_Button()
    {
        go_back_menu.setBounds(145, 330, 200, 50);
        //Logout_b.setBackground(Color.LIGHT_GRAY);
        prod_frame.add(go_back_menu);
        go_back_menu.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(insert_product))
        {
            new Category(temp,"Seller");
            prod_frame.dispose();

        }
        else if(e.getSource().equals(add_inst))
        {
            if(Main.s[Main.index].active_product[0]!=null) {
                prod_frame.dispose();
                new Search_ID(temp, "installment","Seller");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No Product yet");
            }
        }
        else if(e.getSource().equals(edit_product))
        {
            if(Main.s[Main.sell_index].active_product[0]!=null) {
                prod_frame.dispose();
                new Search_ID(temp, "edit","Seller");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No Product yet");
            }
        }
        else if(e.getSource().equals(remove_product))
        {
            if(Main.s[Main.sell_index].active_product[0]!=null) {
                prod_frame.dispose();
                new Search_ID(temp, "remove","Seller");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No Product yet");
            }
        }
        else if(e.getSource().equals(go_back_menu))
        {
            prod_frame.dispose();
            new Sell_product_panel(temp);
        }
    }
}
