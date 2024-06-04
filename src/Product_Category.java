import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Product_Category implements ActionListener {
    public static JFrame p_frame=new JFrame("Product Category");
    JLabel p_label=new JLabel("PRODUCT CATEGORY");

    JButton search_name=new JButton("Search Product By Name");
    JButton filter=new JButton("Product Filter");
    JButton goto_menu=new JButton("Go to Menu");

    Font f1=new Font(Font.SERIF,Font.BOLD,20);
    GUI temp;
    static public String s;
    Product_Category(GUI temp,String s)
    {
        this.temp=temp;
        this.s=s;

        frame_setting();
        text();
        Name();
        Filter();
        Menu();
    }

    void frame_setting()
    {
        p_frame.setVisible(true);
        p_frame.setResizable(false);
        p_frame.setLayout(null);
        p_frame.setBounds(500,50,500,500);
        p_frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        p_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    void text()
    {
        p_label.setBounds(130,0,500,50);
        p_label.setFont(f1);
        p_frame.add(p_label);
    }
    void Name()
    {
        search_name.setBounds(150,100,200,40);
        search_name.addActionListener(this);
        p_frame.add(search_name);
    }
    void Filter()
    {
        filter.setBounds(150,160,200,40);
        filter.addActionListener(this);
        p_frame.add(filter);
    }
    void Menu()
    {
        goto_menu.setBounds(150,220,200,40);
        goto_menu.addActionListener(this);
        p_frame.add(goto_menu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(search_name))
        {
            new Search_By_Name(temp,s);
            p_frame.dispose();
        }
        else if(e.getSource().equals(filter))
        {
            new Product_Filter(temp,s);
            p_frame.dispose();
        }
        else if(e.getSource().equals(goto_menu))
        {
            p_frame.dispose();
            Buy_product_panel.buy_frame.setVisible(true);
        }
    }
}