import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Category implements ActionListener {

    public static JFrame category_frame=new JFrame("Categories");
    JLabel category_label = new JLabel("SELECT CATEGORY");
    JLabel sub_category_label=new JLabel("SUB CATEGORY : ");

    String []cat=new String[3];
    String []el=new String[3];
    String []v=new String[2];
    String []f=new String[3];

    JComboBox category;
    JComboBox ele;
    JComboBox veh;
    JComboBox fur;




    JButton go_back_menu=new JButton("Go Back To Menu");
    JButton ok=new JButton("OK");

    GUI temp;
    static String s;

    Category(GUI temp,String s)
    {
        this.temp=temp;
        Category.s =s;

        frame_setting();

        cat[0]="Electronics";
        cat[1]="Vehicle";
        cat[2]="Furniture";

        el[0]="Laptop";
        el[1]="Mobile";
        el[2]="Air Conditioner";

        v[0]="Car";
        v[1]="Bike";

        f[0]="Bed";
        f[1]="Chair";
        f[2]="Table";

        category_text();
        comboBox();

        go_back_menu_Button();
        OK_Button();

    }



    public void frame_setting()
    {
        category_frame.setBounds(500, 50, 500, 500);
        category_frame.setLayout(null);
        category_frame.getContentPane().setBackground(Color.lightGray);
        category_frame.setVisible(true);
        category_frame.setResizable(false);
        category_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void category_text()
    {
        category_label.setBounds(20, 20, 500, 40);

        category_frame.add(category_label);

        sub_category_label.setBounds(20,70,500,40);
        category_frame.add(sub_category_label);
    }

    public void comboBox()
    {
        category=new JComboBox<>(cat);
        category.setBounds(150,20,150,30);
        category_frame.add(category);
        category.addActionListener(this);


        ele=new JComboBox<>(el);
        ele.setVisible(true);
        ele.setBounds(150,80,150,30);
        category_frame.add(ele);
        ele.addActionListener(this);

        veh=new JComboBox<>(v);
        veh.setVisible(false);
        veh.setBounds(150,80,150,30);
        category_frame.add(veh);
        veh.addActionListener(this);

        fur=new JComboBox<>(f);
        fur.setVisible(false);
        fur.addActionListener(this);
        fur.setBounds(150,80,150,30);
        category_frame.add(fur);
        fur.addActionListener(this);
    }

    public void go_back_menu_Button()
    {
        go_back_menu.setBounds(80, 270, 150, 50);
        category_frame.add(go_back_menu);
        go_back_menu.addActionListener(this);
    }

    public void OK_Button()
    {
        ok.setBounds(250,270,70,50);
        category_frame.add(ok);
        ok.setVisible(true);
        ok.addActionListener(this);
    }

    void Reset()
    {
        category.setSelectedIndex(0);
        ele.setSelectedIndex(0);
        fur.setSelectedIndex(0);
        veh.setSelectedIndex(0);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Objects.equals(category.getSelectedItem(), cat[0]))
        {
            sub_category_label.setVisible(true);
            fur.setVisible(false);
            veh.setVisible(false);
            ele.setVisible(true);
            ok.setVisible(true);
        }
        else if(Objects.equals(category.getSelectedItem(),cat[1]))
        {
            sub_category_label.setVisible(true);
            ele.setVisible(false);
            fur.setVisible(false);
            veh.setVisible(true);
            ok.setVisible(true);
        }
        else if(Objects.equals(category.getSelectedItem(),cat[2]))
        {
            sub_category_label.setVisible(true);
            ele.setVisible(false);
            veh.setVisible(false);
            fur.setVisible(true);
            ok.setVisible(true);
        }

        if(e.getSource().equals(ok))
        {
            if(Objects.equals(category.getSelectedItem(), cat[0])&&Objects.equals(ele.getSelectedItem(),el[0]))
            {
                category_frame.dispose();
                new Laptop_info(temp,s);
            }
            else if(Objects.equals(category.getSelectedItem(), cat[0])&&Objects.equals(ele.getSelectedItem(),el[1]))
            {
                category_frame.dispose();
                new Mobile_info(temp,s);
            }
            else if(Objects.equals(category.getSelectedItem(), cat[0])&&Objects.equals(ele.getSelectedItem(),el[2]))
            {
                category_frame.dispose();
                new Air_Conditioner_Info(temp,s);
            }
            else if(Objects.equals(category.getSelectedItem(), cat[1])&&Objects.equals(veh.getSelectedItem(),v[0]))
            {
                category_frame.dispose();
                new Car_info(temp,s);
            }
            else if (Objects.equals(category.getSelectedItem(), cat[1])&&Objects.equals(veh.getSelectedItem(),v[1]))
            {
                category_frame.dispose();
                new Bike_info(temp,s);
            }
            else if(Objects.equals(category.getSelectedItem(), cat[2])&&Objects.equals(fur.getSelectedItem(),f[0]))
            {
                category_frame.dispose();
                new Bed_Info(temp,s);
            }
            else if(Objects.equals(category.getSelectedItem(), cat[2])&&Objects.equals(fur.getSelectedItem(),f[1]))
            {
                category_frame.dispose();
                new Chair_Info(temp,s);
            }
            else if(Objects.equals(category.getSelectedItem(), cat[2])&&Objects.equals(fur.getSelectedItem(),f[2]))
            {
                category_frame.dispose();
                new Table_Info(temp,s);
            }

            Reset();
        }
        else if(e.getSource().equals(go_back_menu))
        {
            if(s.equals("Seller")) {
                Product_info.prod_frame.setVisible(true);
            }
            else if(s.equals("Renter"))
            {
                Rent_Product_Info.r_prod_frame.setVisible(true);
            }
            category_frame.dispose();
            Reset();
        }

    }
}
