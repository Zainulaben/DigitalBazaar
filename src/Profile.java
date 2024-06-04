import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile implements ActionListener {

    public static JFrame profile_frame=new JFrame("Profile");
    JLabel profile_l=new JLabel("PROFILE");
    JButton balance_b=new JButton("Add Cash");
    JButton sell_product_b =new JButton("Sell Product");
    JButton buy_product_b =new JButton("Buy Product");
    JButton rent_product_b=new JButton("Rent Product");
    JButton Display_personal_info_b=new JButton("Personal Info");
    JButton Logout_b=new JButton("Logout");

    Font f1=new Font(Font.SERIF,Font.BOLD,20);

    GUI temp;


    Profile(GUI temp)
    {
        this.temp=temp;

        frame_setting();
        Balance_Button();
        Seller_Button();
        Buy_Button();
        Rent_Button();
        Display_Personal_Information();
        Logout_Button();
        p_label();

    }

    public void frame_setting()
    {
        profile_frame.setBounds(500, 50, 500, 500);
        profile_frame.setLayout(null);
        profile_frame.getContentPane().setBackground(Color.lightGray);
        profile_frame.setVisible(true);
        profile_frame.setResizable(false);
        profile_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void p_label()
    {
        profile_l.setBounds(200,20,500,40);
        profile_frame.add(profile_l);
        profile_l.setFont(f1);
    }
    public void Balance_Button()
    {
        balance_b.setBounds(85,90,150,40);
        profile_frame.add(balance_b);
        balance_b.addActionListener(this);
    }

    public void Seller_Button()
    {
        sell_product_b.setBounds(245,90,150,40);
        profile_frame.add(sell_product_b);
        sell_product_b.addActionListener(this);
    }

    public void Buy_Button() {
        buy_product_b.setBounds(85, 150, 150, 40);
        profile_frame.add(buy_product_b);
        buy_product_b.addActionListener(this);
    }

    public void Rent_Button()
    {
        rent_product_b.setBounds(245, 150, 150, 40);
        profile_frame.add(rent_product_b);
        rent_product_b.addActionListener(this);

    }

    public void Display_Personal_Information()
    {
        Display_personal_info_b.setBounds(85, 210, 150, 40);
        profile_frame.add(Display_personal_info_b);
        Display_personal_info_b.addActionListener(this);
    }

    public void Logout_Button()
    {
        Logout_b.setBounds(245, 210, 150, 40);
        profile_frame.add(Logout_b);
        Logout_b.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(balance_b)) {
            new Add_Cash(temp);
            profile_frame.dispose();
        }
        else if (e.getSource().equals(Logout_b) ) {
            GUI.menu.setVisible(true);
            profile_frame.dispose();
        }
        else if (e.getSource().equals(Display_personal_info_b)) {
            new Display_Pers_Info(temp);
            profile_frame.dispose();
        }
        else if (e.getSource().equals(sell_product_b))
        {
            new Sell_product_panel(temp);
            profile_frame.dispose();
        }
        else if(e.getSource().equals(buy_product_b))
        {
            if(Main.s[0]!=null||Main.r[0]!=null) {
                new Buy_product_panel(temp);
                profile_frame.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No Seller Try Later");
            }
        }

        if(e.getSource().equals(rent_product_b))
        {
            new Rent_Product_panel(temp);
            profile_frame.dispose();
        }

    }
}