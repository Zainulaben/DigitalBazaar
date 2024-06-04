import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Search_By_Name implements ActionListener {

    JFrame name_frame=new JFrame("Search by name");
    JLabel search_name=new JLabel("SEARCH BY NAME");
    JLabel name=new JLabel("Enter Product name : ");
    JTextField tf_name=new JTextField(20);
    JLabel id_not_found=new JLabel("Product not found");

    JButton search=new JButton("SEARCH");

    JButton back_b;

    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);
    Font f2=new Font(Font.SANS_SERIF,Font.ITALIC,10);



    GUI temp;

    static public String s;
    Search_By_Name(GUI temp,String s)
    {
        this.temp=temp;
        this.s=s;

        Frame_setting();
        id_Label();
        id_Field();
        search_Button();
        back_button();
        name_text();
    }

    public void Frame_setting()
    {
        name_frame.setBounds(500,50,400,300);
        name_frame.setLayout(null);
        name_frame.setVisible(true);
        name_frame.setResizable(false);
        name_frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        name_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void name_text()
    {
        search_name.setBounds(100, 0, 500, 50);
        search_name.setFont(f1);
        name_frame.add(search_name);
    }

    public void id_Label()
    {
        name.setBounds(20,80,200,30);
        name_frame.add(name);

        id_not_found.setBounds(140, 55, 330, 30);
        id_not_found.setFont(f2);
        id_not_found.setForeground(Color.red);
        id_not_found.setVisible(false);
        name_frame.add(id_not_found);
    }

    public void id_Field()
    {
        tf_name.setBounds(140,80,230,30);
        name_frame.add(tf_name);
    }

    public void search_Button()
    {
        search.setBounds(150,170,100,40);
        name_frame.add(search);
        search.addActionListener(this);
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
        name_frame.add(back_b);
    }

    Product []by_name=new Product[100000];
    int select_name_count=0;


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(search))
        {

            if(s.equals("sell"))
            {
                if(Objects.equals(tf_name.getText(), "Laptop") || Objects.equals(tf_name.getText(), "LAPTOP") || Objects.equals(tf_name.getText(), "laptop"))
                {
                    select_name_count=0;
                    for(int i=0;i<Main.active_product_index;i++)
                    {
                        if(Objects.equals(Main.all_products_sell[i].name, "Laptop"))
                        {
                            by_name[select_name_count]=Main.all_products_sell[i];
                            select_name_count++;
                        }
                    }
                }

                else if(Objects.equals(tf_name.getText(), "Mobile") || Objects.equals(tf_name.getText(), "MOBILE") || Objects.equals(tf_name.getText(), "mobile"))
                {
                    select_name_count=0;
                    for(int i=0;i<Main.active_product_index;i++)
                    {
                        if(Objects.equals(Main.all_products_sell[i].name, "Mobile"))
                        {
                            by_name[select_name_count]=Main.all_products_sell[i];
                            select_name_count++;
                        }
                    }
                }

                else if(Objects.equals(tf_name.getText(), "Air Conditioner") || Objects.equals(tf_name.getText(), "air conditioner") || Objects.equals(tf_name.getText(), "AIR CONDITIONER") || Objects.equals(tf_name.getText(), "Air conditioner"))
                {
                    select_name_count=0;
                    for(int i=0;i<Main.active_product_index;i++)
                    {
                        if(Objects.equals(Main.all_products_sell[i].name, "Air conditioner"))
                        {
                            by_name[select_name_count]=Main.all_products_sell[i];
                            select_name_count++;
                        }
                    }
                }

                else if(Objects.equals(tf_name.getText(), "Car") || Objects.equals(tf_name.getText(), "car") || Objects.equals(tf_name.getText(), "CAR"))
                {
                    select_name_count=0;
                    for(int i=0;i<Main.active_product_index;i++)
                    {
                        if(Objects.equals(Main.all_products_sell[i].name, "Car"))
                        {
                            by_name[select_name_count]=Main.all_products_sell[i];
                            select_name_count++;
                        }
                    }
                }

                else if(Objects.equals(tf_name.getText(), "Bike") || Objects.equals(tf_name.getText(), "bike") || Objects.equals(tf_name.getText(), "BIKE"))
                {
                    select_name_count=0;
                    for(int i=0;i<Main.active_product_index;i++)
                    {
                        if(Objects.equals(Main.all_products_sell[i].name, "Bike"))
                        {
                            by_name[select_name_count]=Main.all_products_sell[i];
                            select_name_count++;
                        }
                    }
                }

                else if(Objects.equals(tf_name.getText(), "Chair") || Objects.equals(tf_name.getText(), "chair") || Objects.equals(tf_name.getText(), "CHAIR"))
                {
                    select_name_count=0;
                    for(int i=0;i<Main.active_product_index;i++)
                    {
                        if(Objects.equals(Main.all_products_sell[i].name, "Chair"))
                        {
                            by_name[select_name_count]=Main.all_products_sell[i];
                            select_name_count++;
                        }
                    }
                }

                else if(Objects.equals(tf_name.getText(), "Bed") || Objects.equals(tf_name.getText(), "bed") || Objects.equals(tf_name.getText(), "BED"))
                {
                    select_name_count=0;
                    for(int i=0;i<Main.active_product_index;i++)
                    {
                        if(Objects.equals(Main.all_products_sell[i].name, "Bed"))
                        {
                            by_name[select_name_count]=Main.all_products_sell[i];
                            select_name_count++;
                        }
                    }
                }

                else if(Objects.equals(tf_name.getText(), "Table") || Objects.equals(tf_name.getText(), "table") || Objects.equals(tf_name.getText(), "TABLE"))
                {
                    select_name_count=0;
                    for(int i=0;i<Main.active_product_index;i++)
                    {
                        if(Objects.equals(Main.all_products_sell[i].name, "Table"))
                        {
                            by_name[select_name_count]=Main.all_products_sell[i];
                            select_name_count++;
                        }
                    }
                }

                else
                {
                    id_not_found.setVisible(true);
                }
            }

            if(s.equals("rent"))
            {
                if(Objects.equals(tf_name.getText(), "Laptop") || Objects.equals(tf_name.getText(), "LAPTOP") || Objects.equals(tf_name.getText(), "laptop"))
                {
                    select_name_count=0;
                    for(int i=0;i<Main.active_rent_index;i++)
                    {
                        if(Objects.equals(Main.all_products_rent[i].name, "Laptop"))
                        {
                            by_name[select_name_count]=Main.all_products_rent[i];
                            select_name_count++;
                        }
                    }
                }

                else if(Objects.equals(tf_name.getText(), "Mobile") || Objects.equals(tf_name.getText(), "MOBILE") || Objects.equals(tf_name.getText(), "mobile"))
                {
                    select_name_count=0;
                    for(int i=0;i<Main.active_rent_index;i++)
                    {
                        if(Objects.equals(Main.all_products_rent[i].name, "Mobile"))
                        {
                            by_name[select_name_count]=Main.all_products_rent[i];
                            select_name_count++;
                        }
                    }
                }

                else if(Objects.equals(tf_name.getText(), "Air Conditioner") || Objects.equals(tf_name.getText(), "air conditioner") || Objects.equals(tf_name.getText(), "AIR CONDITIONER") || Objects.equals(tf_name.getText(), "Air conditioner"))
                {
                    select_name_count=0;
                    for(int i=0;i<Main.active_rent_index;i++)
                    {
                        if(Objects.equals(Main.all_products_rent[i].name, "Air conditioner"))
                        {
                            by_name[select_name_count]=Main.all_products_rent[i];
                            select_name_count++;
                        }
                    }
                }

                else if(Objects.equals(tf_name.getText(), "Car") || Objects.equals(tf_name.getText(), "car") || Objects.equals(tf_name.getText(), "CAR"))
                {
                    select_name_count=0;
                    for(int i=0;i<Main.active_rent_index;i++)
                    {
                        if(Objects.equals(Main.all_products_rent[i].name, "Car"))
                        {
                            by_name[select_name_count]=Main.all_products_rent[i];
                            select_name_count++;
                        }
                    }
                }

                else if(Objects.equals(tf_name.getText(), "Bike") || Objects.equals(tf_name.getText(), "bike") || Objects.equals(tf_name.getText(), "BIKE"))
                {
                    select_name_count=0;
                    for(int i=0;i<Main.active_rent_index;i++)
                    {
                        if(Objects.equals(Main.all_products_rent[i].name, "Bike"))
                        {
                            by_name[select_name_count]=Main.all_products_rent[i];
                            select_name_count++;
                        }
                    }
                }

                else if(Objects.equals(tf_name.getText(), "Chair") || Objects.equals(tf_name.getText(), "chair") || Objects.equals(tf_name.getText(), "CHAIR"))
                {
                    select_name_count=0;
                    for(int i=0;i<Main.active_rent_index;i++)
                    {
                        if(Objects.equals(Main.all_products_rent[i].name, "Chair"))
                        {
                            by_name[select_name_count]=Main.all_products_rent[i];
                            select_name_count++;
                        }
                    }
                }

                else if(Objects.equals(tf_name.getText(), "Bed") || Objects.equals(tf_name.getText(), "bed") || Objects.equals(tf_name.getText(), "BED"))
                {
                    select_name_count=0;
                    for(int i=0;i<Main.active_rent_index;i++)
                    {
                        if(Objects.equals(Main.all_products_rent[i].name, "Bed"))
                        {
                            by_name[select_name_count]=Main.all_products_rent[i];
                            select_name_count++;
                        }
                    }
                }

                else if(Objects.equals(tf_name.getText(), "Table") || Objects.equals(tf_name.getText(), "table") || Objects.equals(tf_name.getText(), "TABLE"))
                {
                    select_name_count=0;
                    for(int i=0;i<Main.active_rent_index;i++)
                    {
                        if(Objects.equals(Main.all_products_rent[i].name, "Table"))
                        {
                            by_name[select_name_count]=Main.all_products_rent[i];
                            select_name_count++;
                        }
                    }
                }

                else
                {
                    id_not_found.setVisible(true);
                }
            }

            if(by_name!=null)
            {
                if(by_name[0]!=null) {
                    new Display_Search_By_Name_Product(temp, s,by_name,select_name_count);
                    name_frame.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"No Products found");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No Products found");
            }
        }

        if(e.getSource().equals(back_b))
        {
            Product_Category.p_frame.setVisible(true);
            name_frame.dispose();
        }


    }
}
